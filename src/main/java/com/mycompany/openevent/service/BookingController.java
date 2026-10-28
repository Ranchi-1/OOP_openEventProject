// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
package com.mycompany.openevent.service;

// Imports Host so this class can use that type by its short name.
import com.mycompany.openevent.model.Host;
// Imports Session so this class can use that type by its short name.
import com.mycompany.openevent.model.Session;
// Imports BookingRequest so this class can use that type by its short name.
import com.mycompany.openevent.model.BookingRequest;
// Imports Ticket so this class can use that type by its short name.
import com.mycompany.openevent.model.Ticket;
// Imports SQLException so this class can use that type by its short name.
import java.sql.SQLException;

// Defines the BookingController class and keeps its related data and operations together.
public final class BookingController {

    // Stores the object that checks account credentials and access.
    private final SecurityService security = new SecurityService();
    // Stores system.
    private final BookingSystem system;

    // Constructs a BookingController object and initializes or validates its starting state.
    public BookingController(BookingRepository repository) {
        // Updates this working value before the next step.
        system = new BookingSystem(repository);
    }

    // Claims one AVAILABLE seat and saves its ticket, payment and receipt atomically.
    public Ticket purchase(Session s, BookingRequest r) throws SQLException {
        // Calls this operation to carry out the named step with the supplied arguments.
        security.requireCustomer(s);
        // Returns this result to the method that called the current operation.
        return system.purchase(s, r);
    }

    // Checks refund eligibility and changes ticket, payment and seat status in one transaction.
    public void cancel(Session s, long id) throws SQLException {
        // Calls this operation to carry out the named step with the supplied arguments.
        system.cancel(s, id);
    }

    // Checks event ownership and conditionally changes a paid VALID ticket to USED once.
    public String checkIn(Session s, long e, String code) throws SQLException {
        // Continues into this block only when the condition below is true.
        if (!s.isHost()) {
            // Stops this operation with a clear error; the caller can display or test the failure.
            throw new IllegalArgumentException("Only a Host can check tickets in.");
        }
        // Returns this result to the method that called the current operation.
        return system.checkIn(s, e, code);
    }
}
