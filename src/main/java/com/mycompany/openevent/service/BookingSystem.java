// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
package com.mycompany.openevent.service;

// Imports Session so this class can use that type by its short name.
import com.mycompany.openevent.model.Session;
// Imports BookingRequest so this class can use that type by its short name.
import com.mycompany.openevent.model.BookingRequest;
// Imports Ticket so this class can use that type by its short name.
import com.mycompany.openevent.model.Ticket;
// Imports SQLException so this class can use that type by its short name.
import java.sql.SQLException;

// Defines the BookingSystem class and keeps its related data and operations together.
public final class BookingSystem {

    // Stores the object that reads and writes database records.
    private final BookingRepository repository;

    // Constructs a BookingSystem object and initializes or validates its starting state.
    public BookingSystem(BookingRepository repository) {
        // Stores the constructor argument in this object's private repository field.
        this.repository = repository;
    }

    // Claims one AVAILABLE seat and saves its ticket, payment and receipt atomically.
    public Ticket purchase(Session session, BookingRequest request) throws SQLException {
        // Returns this result to the method that called the current operation.
        return repository.purchase(session, request);
    }

    // Checks refund eligibility and changes ticket, payment and seat status in one transaction.
    public void cancel(Session session, long id) throws SQLException {
        // Calls this operation to carry out the named step with the supplied arguments.
        repository.cancel(session, id);
    }

    // Checks event ownership and conditionally changes a paid VALID ticket to USED once.
    public String checkIn(Session session, long event, String code) throws SQLException {
        // Returns this result to the method that called the current operation.
        return repository.checkIn(session, event, code);
    }
}
