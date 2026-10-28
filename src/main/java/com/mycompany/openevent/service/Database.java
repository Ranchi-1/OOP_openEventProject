// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
package com.mycompany.openevent.service;

// Imports File so this class can use that type by its short name.
import java.io.File;
// Imports FileInputStream so this class can use that type by its short name.
import java.io.FileInputStream;
// Imports IOException so this class can use that type by its short name.
import java.io.IOException;
// Imports Connection so this class can use that type by its short name.
import java.sql.Connection;
// Imports DriverManager so this class can use that type by its short name.
import java.sql.DriverManager;
// Imports SQLException so this class can use that type by its short name.
import java.sql.SQLException;
// Imports Properties so this class can use that type by its short name.
import java.util.Properties;

/** Opens a new database connection for one operation or transaction. */
// Defines the Database class and keeps its related data and operations together.
public class Database {
    // Stores db name.
    private static final String DB_NAME = "openevent";
    // Stores db driver.
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    // Connects to the local OpenEvent database on XAMPP port 3307, with connection timeouts.
    private static final String DB_URL = "jdbc:mysql://localhost:3307/" + DB_NAME
    + "?connectTimeout=4000&socketTimeout=10000&useSSL=false&allowPublicKeyRetrieval=true";
    // Defaults to the restricted application login; config.properties can override this value.
    private static final String DB_USER = "root";
    // The real local password is loaded from config.properties, not stored in this source file.
    private static final String DB_PASSWORD = "";

    // Loads the saved database settings, loads the JDBC driver, and opens a new Connection.
    public static Connection connect() throws SQLException {
        // Prepares the local settings value used in the following steps.
        Properties settings = new Properties();
        // Prepares the local settings file value used in the following steps.
        String settingsFile = System.getProperty("openevent.config");
        // Uses config.properties when no alternate settings path was supplied.
        if (settingsFile == null) {
            // Updates this working value before the next step.
            settingsFile = "config.properties";
        }
        // Prepares the local config file value used in the following steps.
        File configFile = new File(settingsFile);
        // Loads local settings only when the configuration file exists.
        if (configFile.exists()) {
            // Opens these resources in try-with-resources so Java closes them automatically after this block.
            try (FileInputStream input = new FileInputStream(configFile)) {
                // Calls this operation to carry out the named step with the supplied arguments.
                settings.load(input);
            }
            // Handles this error without reporting the failed operation as a success.
            catch (IOException exception) {
                // Stops this operation with a clear error; the caller can display or test the failure.
                throw new SQLException("Cannot read database settings.", exception);
            }
        }
        // Prepares the local url value used in the following steps.
        String url = readSetting(settings, "OPENEVENT_DB_URL", "db.url", DB_URL);
        // Prepares the local user value used in the following steps.
        String user = readSetting(settings, "OPENEVENT_DB_USER", "db.user", DB_USER);
        // Prepares the local password value used in the following steps.
        String password = readSetting(settings, "OPENEVENT_DB_PASSWORD", "db.password", DB_PASSWORD);
        // Attempts the following operation and lets the catch block handle a failure.
        try {
            // Loads the MySQL JDBC driver class, following the explicit connector style used in class.
            Class.forName(DB_DRIVER);
            // Opens the MariaDB connection using the URL, user and password read above.
            Connection connection = DriverManager.getConnection(url, user, password);
            // Returns this result to the method that called the current operation.
            return connection;
        }
        // Handles this error without reporting the failed operation as a success.
        catch (ClassNotFoundException exception) {
            // Stops this operation with a clear error; the caller can display or test the failure.
            throw new SQLException("The MySQL JDBC driver is missing.", exception);
        }
    }

    // Reads an environment override first, then the settings file, then a documented default.
    private static String readSetting(Properties settings, String environmentName,
    String propertyName, String defaultValue) {
        // Reads the optional environment setting without putting credentials into the source.
        String value = System.getenv(environmentName);
        // Tries the next settings source only when the previous source did not supply a value.
        if (value == null) {
            // Updates this working value before the next step.
            value = settings.getProperty(propertyName);
        }
        // Tries the next settings source only when the previous source did not supply a value.
        if (value == null) {
            // Updates this working value before the next step.
            value = defaultValue;
        }
        // Returns this result to the method that called the current operation.
        return value;
    }
}
