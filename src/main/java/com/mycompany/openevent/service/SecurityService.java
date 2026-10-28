// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
package com.mycompany.openevent.service;

// Imports User so this class can use that type by its short name.
import com.mycompany.openevent.model.User;
// Imports Host so this class can use that type by its short name.
import com.mycompany.openevent.model.Host;
// Imports Customer so this class can use that type by its short name.
import com.mycompany.openevent.model.Customer;
// Imports Session so this class can use that type by its short name.
import com.mycompany.openevent.model.Session;
// Imports SecretKeyFactory so this class can use that type by its short name.
import javax.crypto.SecretKeyFactory;
// Imports PBEKeySpec so this class can use that type by its short name.
import javax.crypto.spec.PBEKeySpec;
// Imports SecureRandom so this class can use that type by its short name.
import java.security.SecureRandom;
// Imports MessageDigest so this class can use that type by its short name.
import java.security.MessageDigest;
// Imports GeneralSecurityException so this class can use that type by its short name.
import java.security.GeneralSecurityException;
// Imports Arrays so this class can use that type by its short name.
import java.util.Arrays;
// Imports Base64 so this class can use that type by its short name.
import java.util.Base64;
// Imports Locale so this class can use that type by its short name.
import java.util.Locale;
// Imports Connection so this class can use that type by its short name.
import java.sql.Connection;
// Imports SQLException so this class can use that type by its short name.
import java.sql.SQLException;
// Imports PreparedStatement so this class can use that type by its short name.
import java.sql.PreparedStatement;
// Imports ResultSet so this class can use that type by its short name.
import java.sql.ResultSet;
// Imports SQLIntegrityConstraintViolationException so this class can use that type by its short name.
import java.sql.SQLIntegrityConstraintViolationException;

// Defines the SecurityService class and keeps its related data and operations together.
public final class SecurityService {

    // Creates a random salt and a password hash; the original password is never saved.
    public static String hash(char[] password) {
        // Prepares random bytes stored with a hash so identical passwords do not produce identical saved hashes.
        byte[] salt = new byte[16];
        // Fills the salt with cryptographically random bytes; ordinary Random is unsuitable here.
        new SecureRandom().nextBytes(salt);
        // Prepares the derived password bytes, never the original readable password.
        byte[] passwordHash = derive(password, salt);
        // Prepares the local saved salt value used in the following steps.
        String savedSalt = Base64.getEncoder().encodeToString(salt);
        // Prepares the local saved hash value used in the following steps.
        String savedHash = Base64.getEncoder().encodeToString(passwordHash);
        // Returns this result to the method that called the current operation.
        return savedSalt + ":" + savedHash;
    }

    // Uses standard PBKDF2 to derive a password hash; 120000 iterations slow guessing attempts.
    private static byte[] derive(char[] password, byte[] salt) {
        // Requests a 256-bit PBKDF2 hash using this password, random salt and 120000 iterations.
        PBEKeySpec passwordSpec = new PBEKeySpec(password, salt, 120000, 256);
        // Attempts the following operation and lets the catch block handle a failure.
        try {
            // Selects the standard password-hashing algorithm, preserving compatibility with saved accounts.
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            // Prepares the derived password bytes, never the original readable password.
            byte[] passwordHash = factory.generateSecret(passwordSpec).getEncoded();
            // Returns this result to the method that called the current operation.
            return passwordHash;
        }
        // Handles this error without reporting the failed operation as a success.
        catch (GeneralSecurityException exception) {
            // Stops this operation with a clear error; the caller can display or test the failure.
            throw new IllegalStateException(exception);
        }
        // Runs this cleanup whether the preceding operation succeeds or fails.
        finally {
            // Clears the temporary password characters after use.
            passwordSpec.clearPassword();
        }
    }

    // Hashes the entered password with the saved salt and compares the two hashes.
    public static boolean verify(char[] password, String stored) {
        // Attempts the following operation and lets the catch block handle a failure.
        try {
            // Prepares the local parts value used in the following steps.
            String[] parts = stored.split(":");
            // Prepares random bytes stored with a hash so identical passwords do not produce identical saved hashes.
            byte[] salt = Base64.getDecoder().decode(parts[0]);
            // Prepares the local saved hash value used in the following steps.
            byte[] savedHash = Base64.getDecoder().decode(parts[1]);
            // Prepares the local entered hash value used in the following steps.
            byte[] enteredHash = derive(password, salt);
            // Returns this result to the method that called the current operation.
            return MessageDigest.isEqual(enteredHash, savedHash);
        }
        // Handles this error without reporting the failed operation as a success.
        catch (RuntimeException exception) {
            // Returns this result to the method that called the current operation.
            return false;
        }
    }

    // Verifies an enabled account and returns a Session only after its password matches.
    public Session login(String email, char[] password, boolean host) throws SQLException {
        // Prepares the local table value used in the following steps.
        String table = "customers";
        // Chooses the Host account path; otherwise the operation uses a Customer account.
        if (host) {
            // Updates this working value before the next step.
            table = "hosts";
        }
        // Prepares the local sql value used in the following steps.
        String sql = "SELECT * FROM " + table + " WHERE email=? AND enabled=1";
        // Creates a parameterized SQL statement; values are bound separately instead of concatenated into SQL.
        try (Connection connection = Database.connect(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Binds a typed value to the corresponding SQL placeholder.
            preparedStatement.setString(1, email.trim().toLowerCase(Locale.ROOT));
            // Runs the SELECT and obtains a ResultSet containing the returned rows.
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Moves to the next database row; false means there are no more matching records.
                if (!resultSet.next() || !verify(password, resultSet.getString("password_hash"))) {
                    // Stops this operation with a clear error; the caller can display or test the failure.
                    throw new IllegalArgumentException("Email or password is incorrect for the selected role.");
                }
                // Prepares the local user value used in the following steps.
                User user;
                // Chooses the Host account path; otherwise the operation uses a Customer account.
                if (host) {
                    // Updates this working value before the next step.
                    user = new Host(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("email"));
                }
                // Handles the remaining case after the earlier condition was false.
                else {
                    // Updates this working value before the next step.
                    user = new Customer(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("email"));
                }
                // Returns this result to the method that called the current operation.
                return new Session(user);
            }
        }
        // Runs this cleanup whether the preceding operation succeeds or fails.
        finally {
            // Clears the temporary password characters after use.
            Arrays.fill(password, '\0');
        }
    }

    // Customers and Hosts use the same validation and salted-password storage.
    public void registerCustomer(String name, String email, char[] password) throws SQLException {
        registerAccount(name, email, password, false);
    }

    // A Host can create events after signing in with the Host role.
    public void registerHost(String name, String email, char[] password) throws SQLException {
        registerAccount(name, email, password, true);
    }

    // The boolean chooses between two fixed table names; input never becomes SQL code.
    private void registerAccount(String name, String email, char[] password, boolean host) throws SQLException {
        try {
            String table = "customers";
            String role = "Customer";
            if (host) {
                table = "hosts";
                role = "Host";
            }
            // Validate before opening a connection or creating a database record.
            String cleanName = name.trim();
            String cleanEmail = email.trim().toLowerCase(Locale.ROOT);
            if (cleanName.length() < 2 || cleanName.length() > 100
                    || !cleanEmail.matches("[^\\s@]+@[^\\s@]+\\.[^\\s@]+")
                    || cleanEmail.length() > 190 || password.length < 8) {
                throw new IllegalArgumentException("Enter a name, valid email and a password of at least 8 characters.");
            }
            // Bind the values and save only a salted hash, never the readable password.
            try (Connection connection = Database.connect();
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO " + table + "(name,email,password_hash) VALUES(?,?,?)")) {
                statement.setString(1, cleanName);
                statement.setString(2, cleanEmail);
                statement.setString(3, hash(password));
                statement.executeUpdate();
            }
            catch (SQLIntegrityConstraintViolationException exception) {
                throw new IllegalArgumentException("A " + role + " account already uses this email.");
            }
        }
        finally {
            // Clear the caller's temporary password even when validation or saving fails.
            Arrays.fill(password, '\0');
        }
    }

    // Rejects requests from anyone except the event owner signed in as a Host.
    public void requireHost(Session session, long ownerId) {
        // Continues into this block only when the condition below is true.
        if (session == null || !session.isHost() || session.getUser().getId() != ownerId) {
            // Stops this operation with a clear error; the caller can display or test the failure.
            throw new IllegalArgumentException("Only this event's owning Host can manage it.");
        }
    }

    // Rejects purchase requests unless the current user is a Customer.
    public void requireCustomer(Session session) {
        // Stops this Customer-only screen when nobody is signed in or the user is a Host.
        if (session == null || session.isHost()) {
            // Stops this operation with a clear error; the caller can display or test the failure.
            throw new IllegalArgumentException("Sign in as a Customer to purchase a ticket.");
        }
    }
}
