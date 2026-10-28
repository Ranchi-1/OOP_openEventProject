// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
package com.mycompany.openevent;

// Imports Host so this class can use that type by its short name.
import com.mycompany.openevent.model.Host;
// Imports Customer so this class can use that type by its short name.
import com.mycompany.openevent.model.Customer;
// Imports Session so this class can use that type by its short name.
import com.mycompany.openevent.model.Session;
// Imports Event so this class can use that type by its short name.
import com.mycompany.openevent.model.Event;
// Imports Concert so this class can use that type by its short name.
import com.mycompany.openevent.model.Concert;
// Imports Seat so this class can use that type by its short name.
import com.mycompany.openevent.model.Seat;
// Imports VenueLayout so this class can use that type by its short name.
import com.mycompany.openevent.model.VenueLayout;
// Imports Payment so this class can use that type by its short name.
import com.mycompany.openevent.model.Payment;
// Imports CashPayment so this class can use that type by its short name.
import com.mycompany.openevent.model.CashPayment;
// Imports EWalletPayment so this class can use that type by its short name.
import com.mycompany.openevent.model.EWalletPayment;
// Imports CreditCardPayment so this class can use that type by its short name.
import com.mycompany.openevent.model.CreditCardPayment;
// Imports BookingRequest so this class can use that type by its short name.
import com.mycompany.openevent.model.BookingRequest;
// Imports Ticket so this class can use that type by its short name.
import com.mycompany.openevent.model.Ticket;
// Imports BookingRepository so this class can use that type by its short name.
import com.mycompany.openevent.service.BookingRepository;
// Imports Database so this class can use that type by its short name.
import com.mycompany.openevent.service.Database;
// Imports SecurityService so this class can use that type by its short name.
import com.mycompany.openevent.service.SecurityService;
// Imports Connection so this class can use that type by its short name.
import java.sql.Connection;
// Imports SQLException so this class can use that type by its short name.
import java.sql.SQLException;
// Imports PreparedStatement so this class can use that type by its short name.
import java.sql.PreparedStatement;
// Imports ResultSet so this class can use that type by its short name.
import java.sql.ResultSet;
// Imports Statement so this class can use that type by its short name.
import java.sql.Statement;
// Imports LocalDateTime so this class can use that type by its short name.
import java.time.LocalDateTime;
// Imports BigDecimal so this class can use that type by its short name.
import java.math.BigDecimal;
// Imports List so this class can use that type by its short name.
import java.util.List;
// Imports ArrayList so this class can use that type by its short name.
import java.util.ArrayList;
// Imports Arrays so this class can use that type by its short name.
import java.util.Arrays;
// Imports UUID so this class can use that type by its short name.
import java.util.UUID;
// Imports Callable so this class can use that type by its short name.
import java.util.concurrent.Callable;
// Imports CountDownLatch so this class can use that type by its short name.
import java.util.concurrent.CountDownLatch;
// Imports ExecutorService so this class can use that type by its short name.
import java.util.concurrent.ExecutorService;
// Imports Executors so this class can use that type by its short name.
import java.util.concurrent.Executors;
// Imports Future so this class can use that type by its short name.
import java.util.concurrent.Future;

/**
* Integration acceptance checks. Temporary fixtures are removed in finally;
* sample events are untouched.
*/
// Defines the AcceptanceChecks class and keeps its related data and operations together.
public final class AcceptanceChecks {

    // Stores repo.
    private static final BookingRepository repo = new BookingRepository();
    // Stores the object that checks account credentials and access.
    private static final SecurityService security = new SecurityService();
    // Stores checks.
    private static int checks;
    // Stores host id.
    private static long hostId;
    // Stores customer id.
    private static long customerId;
    // Stores other id.
    private static long otherId;
    // Stores event ids.
    private static final List<Long> eventIds = new ArrayList<Long>();

    // Defines a normal callback contract that another class implements.
    interface Checked {

        void run() throws Exception;
    }

    // Prints a passed assertion, or stops the test if the expected behavior is missing.
    static void check(boolean ok, String label) {
        // Continues into this block only when the condition below is true.
        if (!ok) {
            // Stops this operation with a clear error; the caller can display or test the failure.
            throw new AssertionError(label);
        }
        // Prints this test or setup result to the program output.
        System.out.println("PASS " + (++checks) + ": " + label);
    }

    // Checks that an intentionally invalid test operation is rejected.
    static void rejects(Checked operation, String label) throws Exception {
        // Attempts the following operation and lets the catch block handle a failure.
        try {
            // Calls this operation to carry out the named step with the supplied arguments.
            operation.run();
            // Stops this operation with a clear error; the caller can display or test the failure.
            throw new AssertionError("Expected rejection: " + label);
        }
        // Handles this error without reporting the failed operation as a success.
        catch (IllegalArgumentException | SQLException ex) {
            // Verifies this expected behavior using the existing acceptance test.
            check(true, label);
        }
    }

    // Performs the account operation; exceptions are passed to the caller when needed.
    static long account(String table, String email) throws Exception {
        // Creates a parameterized SQL statement; values are bound separately instead of concatenated into SQL.
        try (Connection c = Database.connect(); PreparedStatement q = c.prepareStatement("INSERT INTO " + table + "(name,email,password_hash) VALUES('Acceptance QA',?,?)", Statement.RETURN_GENERATED_KEYS)) {
            // Binds a typed value to the corresponding SQL placeholder.
            q.setString(1, email);
            // Binds a typed value to the corresponding SQL placeholder.
            q.setString(2, SecurityService.hash("TestPass2026!".toCharArray()));
            // Runs the write statement and obtains its affected-row count.
            q.executeUpdate();
            // Reads the primary key MariaDB generated for the newly inserted row.
            try (ResultSet r = q.getGeneratedKeys()) {
                // Moves to the next database row; false means there are no more matching records.
                r.next();
                // Returns this result to the method that called the current operation.
                return r.getLong(1);
            }
        }
    }

    // Performs the count operation; exceptions are passed to the caller when needed.
    static long count(String table) throws Exception {
        // Creates a parameterized SQL statement; values are bound separately instead of concatenated into SQL.
        try (Connection c = Database.connect(); PreparedStatement q = c.prepareStatement("SELECT COUNT(*) FROM " + table); ResultSet r = q.executeQuery()) {
            // Moves to the next database row; false means there are no more matching records.
            r.next();
            // Returns this result to the method that called the current operation.
            return r.getLong(1);
        }
    }

    // Performs the sql operation; exceptions are passed to the caller when needed.
    static void sql(String text, Object[] args) throws Exception {
        // Creates a parameterized SQL statement; values are bound separately instead of concatenated into SQL.
        try (Connection c = Database.connect(); PreparedStatement q = c.prepareStatement(text)) {
            // Repeats this block with an index so each relevant position or parameter is processed.
            for (int i = 0; i < args.length; i++) {
                // Binds this array value to its SQL placeholder; JDBC placeholder numbering starts at 1.
                q.setObject(i + 1, args[i]);
            }
            // Runs the write statement and obtains its affected-row count.
            q.executeUpdate();
        }
    }

    // Loads the saved venue dimensions, stage and seats from MariaDB.
    static VenueLayout layout() {
        // Prepares the local seats value used in the following steps.
        List<Seat> seats = new ArrayList<Seat>();
        // Repeats this block with an index so each relevant position or parameter is processed.
        for (int r = 1; r < 4; r++) {
            // Repeats this block with an index so each relevant position or parameter is processed.
            for (int c = 0; c < 4; c++) {
                // Prepares the local category value used in the following steps.
                String category = "REGULAR";
                // Prepares the local color value used in the following steps.
                String color = "#2AA89B";
                // Continues into this block only when the condition below is true.
                if (r == 1) {
                    // Updates this working value before the next step.
                    category = "VIP";
                    // Updates this working value before the next step.
                    color = "#8B5CF6";
                }
                // Adds this object to the collection or this child component to its parent container.
                seats.add(new Seat(0, r, c, "" + (char) ('A' + r) + (c + 1), category, color, "AVAILABLE"));
            }
        }
        // Returns this result to the method that called the current operation.
        return new VenueLayout(4, 4, 0, 0, 4, seats);
    }

    // Reads an Event from a row or loads one by ID; the lock option protects transaction decisions.
    static Event event(long id) {
        // Returns this result to the method that called the current operation.
        return new Concert(id, hostId, "[TEST] Atomic booking", "Test venue", "Temporary acceptance fixture", "concert.jpg", LocalDateTime.now().plusDays(15), LocalDateTime.now().plusDays(5), new BigDecimal("100.00"), true);
    }

    // Starts the application or the explicitly selected utility/test program.
    public static void main(String[] args) throws Exception {
        // Prepares the local suffix value used in the following steps.
        String suffix = UUID.randomUUID().toString().substring(0, 8);
        // Prepares the local host value used in the following steps.
        Session host = null;
        // Prepares the local customer value used in the following steps.
        Session customer = null;
        // Attempts the following operation and lets the catch block handle a failure.
        try {
            // Updates this working value before the next step.
            hostId = account("hosts", "qa-host-" + suffix + "@test.local");
            // Updates this working value before the next step.
            otherId = account("hosts", "qa-other-" + suffix + "@test.local");
            // Calls this operation to carry out the named step with the supplied arguments.
            security.registerCustomer("Acceptance QA", "qa-customer-" + suffix + "@test.local", "TestPass2026!".toCharArray());
            // Updates this working value before the next step.
            customer = security.login("qa-customer-" + suffix + "@test.local", "TestPass2026!".toCharArray(), false);
            // Updates this working value before the next step.
            customerId = customer.getUser().getId();
            // Updates this working value before the next step.
            host = security.login("qa-host-" + suffix + "@test.local", "TestPass2026!".toCharArray(), true);
            // Prepares the local h value used in the following steps.
            final Session h = host;
            // Prepares the local c value used in the following steps.
            final Session c = customer;
            // Prepares the local other value used in the following steps.
            final Session other = new Session(new Host(otherId, "Other", "other@test.local"));
            // Verifies this expected behavior using the existing acceptance test.
            check(!c.isHost() && h.isHost(), "valid Customer and Host authentication");
            // Verifies this expected behavior using the existing acceptance test.
            rejects(new Checked() {
                @Override public void run() throws Exception {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    security.login("qa-customer-" + suffix + "@test.local", "wrong".toCharArray(), false);
                }
            }, "invalid login creates no session");
            // Calls this operation to carry out the named step with the supplied arguments.
            sql("UPDATE customers SET enabled=0 WHERE id=?", new Object[]{customerId});
            // Verifies this expected behavior using the existing acceptance test.
            rejects(new Checked() {
                @Override public void run() throws Exception {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    security.login("qa-customer-" + suffix + "@test.local", "TestPass2026!".toCharArray(), false);
                }
            }, "disabled login rejected");
            // Calls this operation to carry out the named step with the supplied arguments.
            sql("UPDATE customers SET enabled=1 WHERE id=?", new Object[]{customerId});
            // Verifies this expected behavior using the existing acceptance test.
            rejects(new Checked() {
                @Override public void run() throws Exception {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    security.registerCustomer("QA", "qa-customer-" + suffix + "@test.local", "TestPass2026!".toCharArray());
                }
            }, "duplicate Customer email rejected");
            // Verifies this expected behavior using the existing acceptance test.
            rejects(new Checked() {
                @Override public void run() throws Exception {
                    new VenueLayout(4, 4, 0, 0, 5, new ArrayList<Seat>());
                }
            }, "out-of-bounds stage rejected");
            // Prepares the local invalid value used in the following steps.
            Seat invalid = new Seat(0, 1, 0, "B1", "REGULAR", "#2AA89B", "AVAILABLE");
            // Verifies this expected behavior using the existing acceptance test.
            rejects(new Checked() {
                @Override public void run() throws Exception {
                    new VenueLayout(4, 4, 0, 0, 4, Arrays.asList(invalid, invalid));
                }
            }, "duplicate grid positions rejected");
            // Prepares the local id value used in the following steps.
            long id = repo.saveEvent(h, event(0), layout(), true);
            // Adds this object to the collection or this child component to its parent container.
            eventIds.add(id);
            // Prepares the local event value used in the following steps.
            Event event = repo.event(id);
            // Prepares the local l value used in the following steps.
            VenueLayout l = repo.layout(id);
            // Prepares the local vip value used in the following steps.
            Seat vip = l.getSeats().get(0), regular = findRegularSeat(l);
            // Verifies this expected behavior using the existing acceptance test.
            check(event.calculatePrice(vip, "VIP").equals(new BigDecimal("150.00")) && event.calculatePrice(regular, "EARLY_BIRD").equals(new BigDecimal("80.00")), "VIP and Early Bird price rules");
            // Verifies this expected behavior using the existing acceptance test.
            check(containsEvent(repo.events(c, "[TEST]"), id), "published event discovery and title search");
            // Verifies this expected behavior using the existing acceptance test.
            rejects(new Checked() {
                @Override public void run() throws Exception {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    repo.saveEvent(c, event, layout(), true);
                }
            }, "Customer cannot edit an event");
            // Verifies this expected behavior using the existing acceptance test.
            rejects(new Checked() {
                @Override public void run() throws Exception {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    repo.saveEvent(other, event, layout(), true);
                }
            }, "different Host cannot edit owner event");
            // Prepares the local before value used in the following steps.
            long before = count("tickets");
            // Prepares the local receipts value used in the following steps.
            long receipts = count("receipts");
            // Verifies this expected behavior using the existing acceptance test.
            rejects(new Checked() {
                @Override public void run() throws Exception {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    repo.purchase(c, new BookingRequest(id, regular.getId(), "REGULAR", new CashPayment(), false));
                }
            }, "simulated decline rejected");
            // Verifies this expected behavior using the existing acceptance test.
            check(count("tickets") == before && count("receipts") == receipts && findSeat(repo.layout(id), regular.getId()).isAvailable(), "decline rolls back seat, ticket and receipt");
            // Prepares the local bad value used in the following steps.
            Payment bad = new Payment() {
                // Provides the concrete payment method through the abstract Payment contract.
                public String method() {
                    // Returns this result to the method that called the current operation.
                    return "INVALID";
                }
            };
            // Verifies this expected behavior using the existing acceptance test.
            rejects(new Checked() {
                @Override public void run() throws Exception {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    repo.purchase(c, new BookingRequest(id, regular.getId(), "REGULAR", bad, true));
                }
            }, "database write failure rejected");
            // Verifies this expected behavior using the existing acceptance test.
            check(count("tickets") == before && count("receipts") == receipts && findSeat(repo.layout(id), regular.getId()).isAvailable(), "failed payment insert rolls back previously inserted ticket and seat");
            // Prepares the local ticket value used in the following steps.
            Ticket ticket = repo.purchase(c, new BookingRequest(id, regular.getId(), "EARLY_BIRD", new EWalletPayment(), true));
            // Verifies this expected behavior using the existing acceptance test.
            check(ticket.getStatus().equals("VALID") && ticket.getAmount().equals(new BigDecimal("80.00")) && ticket.getReceiptNumber() != null, "purchase saves one valid ticket, payment and receipt");
            // Verifies this expected behavior using the existing acceptance test.
            rejects(new Checked() {
                @Override public void run() throws Exception {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    repo.purchase(c, new BookingRequest(id, regular.getId(), "REGULAR", new CashPayment(), true));
                }
            }, "duplicate seat purchase rejected");
            // Verifies this expected behavior using the existing acceptance test.
            rejects(new Checked() {
                @Override public void run() throws Exception {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    repo.saveEvent(h, event, layout(), true);
                }
            }, "active booking protects venue layout");
            // Verifies this expected behavior using the existing acceptance test.
            rejects(new Checked() {
                @Override public void run() throws Exception {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    repo.checkIn(other, id, ticket.getCode());
                }
            }, "different Host cannot check in");
            // Prepares the local wrong id value used in the following steps.
            long wrongId = repo.saveEvent(h, event(0), layout(), true);
            // Adds this object to the collection or this child component to its parent container.
            eventIds.add(wrongId);
            // Verifies this expected behavior using the existing acceptance test.
            rejects(new Checked() {
                @Override public void run() throws Exception {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    repo.checkIn(h, wrongId, ticket.getCode());
                }
            }, "wrong-event ticket rejected");
            // Calls this operation to carry out the named step with the supplied arguments.
            repo.cancel(c, ticket.getId());
            // Prepares the local cancelled value used in the following steps.
            Ticket cancelled = findTicket(repo.tickets(c, 0), ticket.getId());
            // Verifies this expected behavior using the existing acceptance test.
            check(cancelled.getStatus().equals("CANCELLED") && cancelled.getPaymentStatus().equals("SIMULATED_REFUNDED"), "cancellation saves simulated refund");
            // Verifies this expected behavior using the existing acceptance test.
            check(findSeat(repo.layout(id), regular.getId()).isAvailable(), "cancellation releases the seat");
            // Verifies this expected behavior using the existing acceptance test.
            rejects(new Checked() {
                @Override public void run() throws Exception {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    repo.checkIn(h, id, ticket.getCode());
                }
            }, "cancelled ticket rejected at entry");
            // Prepares the local replacement value used in the following steps.
            Ticket replacement = repo.purchase(c, new BookingRequest(id, regular.getId(), "REGULAR", new CreditCardPayment(), true));
            // Calls this operation to carry out the named step with the supplied arguments.
            repo.checkIn(h, id, replacement.getCode());
            // Verifies this expected behavior using the existing acceptance test.
            rejects(new Checked() {
                @Override public void run() throws Exception {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    repo.checkIn(h, id, replacement.getCode());
                }
            }, "repeated check-in rejected");
            // Verifies this expected behavior using the existing acceptance test.
            rejects(new Checked() {
                @Override public void run() throws Exception {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    repo.cancel(c, replacement.getId());
                }
            }, "USED ticket cannot be refunded");
            // Prepares the local race seat value used in the following steps.
            Seat raceSeat = findAvailableSeat(repo.layout(id));
            // Prepares the local start value used in the following steps.
            CountDownLatch start = new CountDownLatch(1);
            // Prepares the local attempt value used in the following steps.
            Callable<Boolean> attempt = new Callable<Boolean>() {
                @Override
                // Performs the call operation; exceptions are passed to the caller when needed.
                public Boolean call() throws Exception {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    start.await();
                    // Attempts the following operation and lets the catch block handle a failure.
                    try {
                        // Calls this operation to carry out the named step with the supplied arguments.
                        repo.purchase(c, new BookingRequest(id, raceSeat.getId(), raceSeat.getCategory(), new CashPayment(), true));
                        // Returns this result to the method that called the current operation.
                        return true;
                    }
                    // Handles this error without reporting the failed operation as a success.
                    catch (IllegalArgumentException ex) {
                        // Returns this result to the method that called the current operation.
                        return false;
                    }
                }
            };
            // Prepares the local pool value used in the following steps.
            ExecutorService pool = Executors.newFixedThreadPool(2);
            // Attempts the following operation and lets the catch block handle a failure.
            try {
                // Prepares the local a value used in the following steps.
                Future<Boolean> a = pool.submit(attempt);
                // Prepares the local b value used in the following steps.
                Future<Boolean> b = pool.submit(attempt);
                // Calls this operation to carry out the named step with the supplied arguments.
                start.countDown();
                // Prepares the local winners value used in the following steps.
                int winners = 0;
                // Continues into this block only when the condition below is true.
                if (a.get()) {
                    // Updates the running count for this loop or summary.
                    winners++;
                }
                // Continues into this block only when the condition below is true.
                if (b.get()) {
                    // Updates the running count for this loop or summary.
                    winners++;
                }
                // Verifies this expected behavior using the existing acceptance test.
                check(winners == 1, "concurrent purchases: exactly one wins the seat");
            }
            // Runs this cleanup whether the preceding operation succeeds or fails.
            finally {
                // Releases the test worker threads after the concurrency check.
                pool.shutdown();
            }
            // Prepares the local persisted value used in the following steps.
            Ticket persisted = findTicket(new BookingRepository().tickets(c, 0), replacement.getId());
            // Verifies this expected behavior using the existing acceptance test.
            check(persisted.getStatus().equals("USED"), "saved state survives new repository and database connection");
            // Calls this operation to carry out the named step with the supplied arguments.
            sql("UPDATE events SET starts_at=DATE_SUB(NOW(),INTERVAL 1 DAY) WHERE id=?", new Object[]{id});
            // Prepares the local race ticket value used in the following steps.
            Ticket raceTicket = findValidTicket(repo.tickets(c, 0));
            // Verifies this expected behavior using the existing acceptance test.
            rejects(new Checked() {
                @Override public void run() throws Exception {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    repo.cancel(c, raceTicket.getId());
                }
            }, "refund after event starts rejected");
            // Prints this test or setup result to the program output.
            System.out.println("ALL " + checks + " ACCEPTANCE CHECKS PASSED");
        }
        // Runs this cleanup whether the preceding operation succeeds or fails.
        finally {
            // Visits each object in the collection using an ordinary enhanced for loop.
            for (long id : eventIds) {
                // Calls this operation to carry out the named step with the supplied arguments.
                sql("DELETE r FROM receipts r JOIN tickets t ON t.id=r.ticket_id WHERE t.event_id=?", new Object[]{id});
                // Calls this operation to carry out the named step with the supplied arguments.
                sql("DELETE p FROM payments p JOIN tickets t ON t.id=p.ticket_id WHERE t.event_id=?", new Object[]{id});
                // Calls this operation to carry out the named step with the supplied arguments.
                sql("DELETE FROM tickets WHERE event_id=?", new Object[]{id});
                // Calls this operation to carry out the named step with the supplied arguments.
                sql("DELETE FROM seats WHERE event_id=?", new Object[]{id});
                // Calls this operation to carry out the named step with the supplied arguments.
                sql("DELETE FROM sections WHERE event_id=?", new Object[]{id});
                // Calls this operation to carry out the named step with the supplied arguments.
                sql("DELETE FROM venue_layouts WHERE event_id=?", new Object[]{id});
                // Calls this operation to carry out the named step with the supplied arguments.
                sql("DELETE FROM events WHERE id=?", new Object[]{id});
            }
            // Continues into this block only when the condition below is true.
            if (customerId != 0) {
                // Calls this operation to carry out the named step with the supplied arguments.
                sql("DELETE FROM customers WHERE id=?", new Object[]{customerId});
            }
            // Continues into this block only when the condition below is true.
            if (hostId != 0) {
                // Calls this operation to carry out the named step with the supplied arguments.
                sql("DELETE FROM hosts WHERE id=?", new Object[]{hostId});
            }
            // Continues into this block only when the condition below is true.
            if (otherId != 0) {
                // Calls this operation to carry out the named step with the supplied arguments.
                sql("DELETE FROM hosts WHERE id=?", new Object[]{otherId});
            }
        }
    }

    // Performs the find regular seat operation; exceptions are passed to the caller when needed.
    static Seat findRegularSeat(VenueLayout layout) {
        // Visits each object in the collection using an ordinary enhanced for loop.
        for (Seat seat : layout.getSeats()) {
            // Continues into this block only when the condition below is true.
            if ("REGULAR".equals(seat.getCategory())) {
                // Returns this result to the method that called the current operation.
                return seat;
            }
        }
        // Stops this operation with a clear error; the caller can display or test the failure.
        throw new AssertionError("No regular test seat found.");
    }
    // Performs the find seat operation; exceptions are passed to the caller when needed.
    static Seat findSeat(VenueLayout layout, long seatId) {
        // Visits each object in the collection using an ordinary enhanced for loop.
        for (Seat seat : layout.getSeats()) {
            // Continues into this block only when the condition below is true.
            if (seat.getId() == seatId) {
                // Returns this result to the method that called the current operation.
                return seat;
            }
        }
        // Stops this operation with a clear error; the caller can display or test the failure.
        throw new AssertionError("Test seat not found.");
    }
    // Performs the find available seat operation; exceptions are passed to the caller when needed.
    static Seat findAvailableSeat(VenueLayout layout) {
        // Visits each object in the collection using an ordinary enhanced for loop.
        for (Seat seat : layout.getSeats()) {
            // Allows selection only for seats whose status is AVAILABLE.
            if (seat.isAvailable()) {
                // Returns this result to the method that called the current operation.
                return seat;
            }
        }
        // Stops this operation with a clear error; the caller can display or test the failure.
        throw new AssertionError("No available test seat.");
    }
    // Performs the contains event operation; exceptions are passed to the caller when needed.
    static boolean containsEvent(List<Event> events, long eventId) {
        // Visits each object in the collection using an ordinary enhanced for loop.
        for (Event event : events) {
            // Continues into this block only when the condition below is true.
            if (event.getId() == eventId) {
                // Returns this result to the method that called the current operation.
                return true;
            }
        }
        // Returns this result to the method that called the current operation.
        return false;
    }
    // Performs the find ticket operation; exceptions are passed to the caller when needed.
    static Ticket findTicket(List<Ticket> tickets, long ticketId) {
        // Visits each object in the collection using an ordinary enhanced for loop.
        for (Ticket ticket : tickets) {
            // Continues into this block only when the condition below is true.
            if (ticket.getId() == ticketId) {
                // Returns this result to the method that called the current operation.
                return ticket;
            }
        }
        // Stops this operation with a clear error; the caller can display or test the failure.
        throw new AssertionError("Test ticket not found.");
    }
    // Performs the find valid ticket operation; exceptions are passed to the caller when needed.
    static Ticket findValidTicket(List<Ticket> tickets) {
        // Visits each object in the collection using an ordinary enhanced for loop.
        for (Ticket ticket : tickets) {
            // Continues into this block only when the condition below is true.
            if ("VALID".equals(ticket.getStatus())) {
                // Returns this result to the method that called the current operation.
                return ticket;
            }
        }
        // Stops this operation with a clear error; the caller can display or test the failure.
        throw new AssertionError("No valid test ticket.");
    }
}
