package com.mycompany.openevent.service;

// Imports Customer so this class can use that type by its short name.
import com.mycompany.openevent.model.Customer;
import com.mycompany.openevent.model.TicketType;
import com.mycompany.openevent.model.VenuePlan;
// Imports Session so this class can use that type by its short name.
import com.mycompany.openevent.model.Session;
// Imports Event so this class can use that type by its short name.
import com.mycompany.openevent.model.Event;
// Imports Concert so this class can use that type by its short name.
import com.mycompany.openevent.model.Concert;
// Imports SportsMatch so this class can use that type by its short name.
import com.mycompany.openevent.model.SportsMatch;
// Imports MovieScreening so this class can use that type by its short name.
import com.mycompany.openevent.model.MovieScreening;
// Imports Seat so this class can use that type by its short name.
import com.mycompany.openevent.model.Seat;
// Imports Section so this class can use that type by its short name.
import com.mycompany.openevent.model.Section;
// Imports VenueLayout so this class can use that type by its short name.
import com.mycompany.openevent.model.VenueLayout;
// Imports BookingRequest so this class can use that type by its short name.
import com.mycompany.openevent.model.BookingRequest;
// Imports Ticket so this class can use that type by its short name.
import com.mycompany.openevent.model.Ticket;
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
// Imports BigDecimal so this class can use that type by its short name.
import java.math.BigDecimal;
// Imports LocalDateTime so this class can use that type by its short name.
import java.time.LocalDateTime;
// Imports List so this class can use that type by its short name.
import java.util.List;
// Imports Map so this class can use that type by its short name.
import java.util.Map;
// Imports ArrayList so this class can use that type by its short name.
import java.util.ArrayList;
// Imports HashMap so this class can use that type by its short name.
import java.util.HashMap;
// Imports Locale so this class can use that type by its short name.
import java.util.Locale;
// Imports UUID so this class can use that type by its short name.
import java.util.UUID;

// Defines the BookingRepository class and keeps its related data and operations together.
public final class BookingRepository {

    // Stores the object that checks account credentials and access.
    private final SecurityService security = new SecurityService();

    // Creates a PreparedStatement and binds each array element to a SQL question-mark placeholder.
    private PreparedStatement prepareQuery(Connection connection, String sql, Object[] parameters) throws SQLException {
        // Creates a parameterized SQL statement; values are bound separately instead of concatenated into SQL.
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        // Repeats this block with an index so each relevant position or parameter is processed.
        for (int i = 0; i < parameters.length; i++) {
            // Binds this array value to its SQL placeholder; JDBC placeholder numbering starts at 1.
            preparedStatement.setObject(i + 1, parameters[i]);
        }
        // Returns this result to the method that called the current operation.
        return preparedStatement;
    }

    // Inserts one database row and returns its automatically generated primary key.
    private long insertRecord(Connection connection, String sql, Object[] parameters) throws SQLException {
        // Opens these resources in try-with-resources so Java closes them automatically after this block.
        try (PreparedStatement preparedStatement = prepareQuery(connection, sql, parameters)) {
            // Runs the write statement and obtains its affected-row count.
            preparedStatement.executeUpdate();
            // Reads the primary key MariaDB generated for the newly inserted row.
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                // Moves to the next database row; false means there are no more matching records.
                if (!resultSet.next()) {
                    // Stops this operation with a clear error; the caller can display or test the failure.
                    throw new SQLException("Missing generated ID.");
                }
                // Returns this result to the method that called the current operation.
                return resultSet.getLong(1);
            }
        }
    }

    // Runs an update/delete statement and returns how many rows were affected.
    private int updateRecords(Connection connection, String sql, Object[] parameters) throws SQLException {
        // Opens these resources in try-with-resources so Java closes them automatically after this block.
        try (PreparedStatement preparedStatement = prepareQuery(connection, sql, parameters)) {
            // Runs the write statement and obtains its affected-row count.
            return preparedStatement.executeUpdate();
        }
    }

    // Reads an Event from a row or loads one by ID; the lock option protects transaction decisions.
    private Event event(ResultSet resultSet) throws SQLException {
        // Prepares the local id value used in the following steps.
        long id = resultSet.getLong("id");
        // Prepares the local host value used in the following steps.
        long host = resultSet.getLong("host_id");
        // Prepares the local title value used in the following steps.
        String title = resultSet.getString("title");
        // Prepares the local venue value used in the following steps.
        String venue = resultSet.getString("venue");
        // Prepares the local description value used in the following steps.
        String description = resultSet.getString("description");
        // Prepares the local image value used in the following steps.
        String image = resultSet.getString("image");
        // Prepares the local starts value used in the following steps.
        LocalDateTime starts = resultSet.getTimestamp("starts_at").toLocalDateTime();
        // Prepares the local early value used in the following steps.
        LocalDateTime early = resultSet.getTimestamp("early_bird_until").toLocalDateTime();
        // Prepares the local price value used in the following steps.
        BigDecimal price = resultSet.getBigDecimal("base_price");
        // Prepares the local published value used in the following steps.
        boolean published = resultSet.getBoolean("published");
        // Prepares the local type value used in the following steps.
        String type = resultSet.getString("type");
        // Continues into this block only when the condition below is true.
        if ("SPORTS".equals(type)) {
            // Returns this result to the method that called the current operation.
            return new SportsMatch(id, host, title, venue, description, image, starts, early, price, published);
        } // Checks the next possible case when the earlier condition was false.
        else if ("MOVIE".equals(type)) {
            // Returns this result to the method that called the current operation.
            return new MovieScreening(id, host, title, venue, description, image, starts, early, price, published);
        } // Handles the remaining case after the earlier condition was false.
        else {
            // Returns this result to the method that called the current operation.
            return new Concert(id, host, title, venue, description, image, starts, early, price, published);
        }
    }

    // Loads only events visible to this Customer or owned by this Host.
    public List<Event> events(Session session, String search) throws SQLException {
        // Prepares the local access condition value used in the following steps.
        String accessCondition = "published=1 AND starts_at>NOW()";
        // Uses the Host workflow and its ownership restrictions.
        if (session.isHost()) {
            // Updates this working value before the next step.
            accessCondition = "host_id=?";
        }
        // Prepares the local sql value used in the following steps.
        String sql = "SELECT * FROM events WHERE " + accessCondition + " AND title LIKE ? ORDER BY starts_at";
        // Creates a parameterized SQL statement; values are bound separately instead of concatenated into SQL.
        try (Connection connection = Database.connect(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Prepares the local i value used in the following steps.
            int i = 1;
            // Uses the Host workflow and its ownership restrictions.
            if (session.isHost()) {
                // Binds a typed value to the corresponding SQL placeholder.
                preparedStatement.setLong(i++, session.getUser().getId());
            }
            // Binds a typed value to the corresponding SQL placeholder.
            preparedStatement.setString(i, "%" + search + "%");
            // Runs the SELECT and obtains a ResultSet containing the returned rows.
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Prepares the local list value used in the following steps.
                List<Event> list = new ArrayList<Event>();
                // Moves to the next database row; false means there are no more matching records.
                while (resultSet.next()) {
                    // Adds this object to the collection or this child component to its parent container.
                    list.add(event(resultSet));
                }
                // Returns this result to the method that called the current operation.
                return list;
            }
        }
    }

    // Reads an Event from a row or loads one by ID; the lock option protects transaction decisions.
    private Event event(Connection connection, long id, boolean lock) throws SQLException {
        // Prepares the local sql value used in the following steps.
        String sql = "SELECT * FROM events WHERE id=?";
        // Continues into this block only when the condition below is true.
        if (lock) {
            // Locks the matching row during this transaction so competing requests cannot change the decision.
            sql = sql + " FOR UPDATE";
        }
        // Runs the SELECT and obtains a ResultSet containing the returned rows.
        try (PreparedStatement preparedStatement = prepareQuery(connection, sql, new Object[]{id}); ResultSet resultSet = preparedStatement.executeQuery()) {
            // Moves to the next database row; false means there are no more matching records.
            if (!resultSet.next()) {
                // Stops this operation with a clear error; the caller can display or test the failure.
                throw new IllegalArgumentException("Event no longer exists.");
            }
            // Returns this result to the method that called the current operation.
            return event(resultSet);
        }
    }

    // Reads an Event from a row or loads one by ID; the lock option protects transaction decisions.
    public Event event(long id) throws SQLException {
        // Opens these resources in try-with-resources so Java closes them automatically after this block.
        try (Connection connection = Database.connect()) {
            // Returns this result to the method that called the current operation.
            return event(connection, id, false);
        }
    }

    // Loads the saved venue dimensions, stage and seats from MariaDB.
    public VenueLayout layout(long id) throws SQLException {
        // Runs the SELECT and obtains a ResultSet containing the returned rows.
        try (Connection connection = Database.connect(); PreparedStatement preparedStatement = prepareQuery(connection, "SELECT * FROM venue_layouts WHERE event_id=?", new Object[]{id}); ResultSet resultSet = preparedStatement.executeQuery()) {
            // Moves to the next database row; false means there are no more matching records.
            if (!resultSet.next()) {
                // Stops this operation with a clear error; the caller can display or test the failure.
                throw new IllegalArgumentException("This event has no venue layout.");
            }
            // Prepares the local seats value used in the following steps.
            List<Seat> seats = new ArrayList<Seat>();
            // Runs the SELECT and obtains a ResultSet containing the returned rows.
            try (PreparedStatement seatStatement = prepareQuery(connection, "SELECT s.*,sec.category,sec.color,sec.ticket_name,sec.ticket_price,sec.early_bird FROM seats s JOIN sections sec ON sec.id=s.section_id WHERE "
                    + "s.event_id=? ORDER BY row_no,col_no", new Object[]{id}); ResultSet seatResultSet = seatStatement.executeQuery()) {
                // Moves to the next database row; false means there are no more matching records.
                while (seatResultSet.next()) {
                    // Adds this object to the collection or this child component to its parent container.
                    seats.add(readSeat(seatResultSet));
                }
            }
            // Returns this result to the method that called the current operation.
            VenuePlan plan = VenuePlanRepository.read(connection, id);
            if (plan != null) {
                return new VenueLayout(plan, seats);
            }
            return new VenueLayout(resultSet.getInt("grid_rows"), resultSet.getInt("grid_cols"), resultSet.getInt("stage_row"), resultSet.getInt("stage_col"), resultSet.getInt("stage_width"), seats, VenuePlanRepository.readTypes(connection, id));
        }
    }

    // Counts VALID and USED tickets, which protect the venue from destructive layout changes.
    public long activeTickets(long eventId) throws SQLException {
        // Runs the SELECT and obtains a ResultSet containing the returned rows.
        try (Connection connection = Database.connect(); PreparedStatement preparedStatement = prepareQuery(connection, "SELECT COUNT(*) FROM tickets WHERE event_id=? AND status IN ('VALID','USED')", new Object[]{eventId}); ResultSet resultSet = preparedStatement.executeQuery()) {
            // Moves to the next database row; false means there are no more matching records.
            resultSet.next();
            // Returns this result to the method that called the current operation.
            return resultSet.getLong(1);
        }
    }

    // Validates ownership and saves event/layout changes in one transaction.
    public long saveEvent(Session session, Event event, VenueLayout layout, boolean replaceLayout) throws SQLException {
        // Calls this operation to carry out the named step with the supplied arguments.
        security.requireHost(session, event.getHostId());
        // Continues into this block only when the condition below is true.
        if (!event.getStartsAt().isAfter(LocalDateTime.now())) {
            // Stops this operation with a clear error; the caller can display or test the failure.
            throw new IllegalArgumentException("Choose a future event date.");
        }
        // Continues into this block only when the condition below is true.
        if (event.getEarlyBirdUntil().isAfter(event.getStartsAt())) {
            // Stops this operation with a clear error; the caller can display or test the failure.
            throw new IllegalArgumentException("Early Bird must end before the event starts.");
        }
        // Continues into this block only when the condition below is true.
        if (layout.getSeats().isEmpty()) {
            // Stops this operation with a clear error; the caller can display or test the failure.
            throw new IllegalArgumentException("Add at least one seat.");
        }
        // Opens these resources in try-with-resources so Java closes them automatically after this block.
        try (Connection connection = Database.connect()) {
            // Starts a transaction: changes stay uncommitted until every related operation succeeds.
            connection.setAutoCommit(false);
            // Attempts the following operation and lets the catch block handle a failure.
            try {
                // Prepares the local id value used in the following steps.
                long id = event.getId();
                // Continues into this block only when the condition below is true.
                if (id == 0) {
                    // Saves the new row using the listed placeholder values and returns its generated ID when needed.
                    id = insertRecord(connection, "INSERT INTO events(host_id,type,title,venue,description,image,starts_at,early_bird_until,base_price,published) VALUES(?,?,?,?,?,?,?,?,?,?)", new Object[]{event.getHostId(), event.eventType(), event.getTitle(), event.getVenue(), event.getDescription(), event.getImage(), event.getStartsAt(), event.getEarlyBirdUntil(), event.getBasePrice(), event.isPublished()});
                } // Handles the remaining case after the earlier condition was false.
                else {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    security.requireHost(session, event(connection, id, true).getHostId());
                    // Applies this status or layout change within the existing database transaction.
                    updateRecords(connection, "UPDATE events SET type=?,title=?,venue=?,description=?,image=?,starts_at=?,early_bird_until=?,base_price=?,published=? WHERE id=?", new Object[]{event.eventType(), event.getTitle(), event.getVenue(), event.getDescription(), event.getImage(), event.getStartsAt(), event.getEarlyBirdUntil(), event.getBasePrice(), event.isPublished(), id});
                }
                // Replaces the saved grid only when the layout changed and booking protection allows it.
                if (replaceLayout) {
                    // Runs the SELECT and obtains a ResultSet containing the returned rows.
                    try (PreparedStatement preparedStatement = prepareQuery(connection, "SELECT COUNT(*) FROM tickets WHERE event_id=? AND status IN ('VALID','USED')", new Object[]{id}); ResultSet resultSet = preparedStatement.executeQuery()) {
                        // Moves to the next database row; false means there are no more matching records.
                        resultSet.next();
                        // Continues into this block only when the condition below is true.
                        if (resultSet.getInt(1) > 0) {
                            // Stops this operation with a clear error; the caller can display or test the failure.
                            throw new IllegalArgumentException("Booked seats protect this layout. Edit event details only.");
                        }
                    }
                    // Applies this status or layout change within the existing database transaction.
                    updateRecords(connection, "DELETE FROM seats WHERE event_id=?", new Object[]{id});
                    // Applies this status or layout change within the existing database transaction.
                    updateRecords(connection, "DELETE FROM sections WHERE event_id=?", new Object[]{id});
                    // Applies this status or layout change within the existing database transaction.
                    updateRecords(connection, "DELETE FROM venue_layouts WHERE event_id=?", new Object[]{id});
                    // Saves the new row using the listed placeholder values and returns its generated ID when needed.
                    insertRecord(connection, "INSERT INTO venue_layouts(event_id,grid_rows,grid_cols,stage_row,stage_col,stage_width) VALUES(?,?,?,?,?,?)", new Object[]{id, layout.getRows(), layout.getColumns(), layout.getStageRow(), layout.getStageColumn(), layout.getStageWidth()});
                    Map<String, Long> sectionIds = new HashMap<String, Long>();
                    // Visits each object in the collection using an ordinary enhanced for loop.
                    for (Section section : layout.getSections()) {
                        // Saves the new row using the listed placeholder values and returns its generated ID when needed.
                        sectionIds.put(section.getName(), insertRecord(connection, "INSERT INTO sections(event_id,category,color) VALUES(?,?,?)", new Object[]{id, section.getName(), section.getColor()}));
                    }
                    // Visits each object in the collection using an ordinary enhanced for loop.
                    if (!layout.getTicketTypes().isEmpty()) {
                        for (TicketType type : layout.getTicketTypes()) {
                            if (!sectionIds.containsKey(type.getCode())) {
                                sectionIds.put(type.getCode(), insertRecord(connection, "INSERT INTO sections(event_id,category,color) VALUES(?,?,?)", new Object[]{id, type.getCode(), type.getColor()}));
                            }
                        }
                    }
                    for (Seat seat : layout.getSeats()) {
                        // Saves the new row using the listed placeholder values and returns its generated ID when needed.
                        insertRecord(connection, "INSERT INTO seats(event_id,section_id,row_no,col_no,label,area_code,status) VALUES(?,?,?,?,?,?,'AVAILABLE')", new Object[]{id, sectionIds.get(seat.getTypeCode()), seat.getRow(), seat.getColumn(), seat.getLabel(), seat.getAreaCode()});
                    }
                }
                // Commits all transaction changes together so other connections can see the completed result.
                // Save offers and overview in the same transaction as seats and event details.
                if (layout.isFlexible()) {
                    VenuePlan oldPlan = null;
                    if (!replaceLayout) {
                        oldPlan = VenuePlanRepository.read(connection, id);
                    }
                    if (!replaceLayout && (oldPlan == null || !sameGeometry(oldPlan, layout.getPlan()))) {
                        throw new IllegalArgumentException("Booked layouts cannot be moved, resized, reassigned or renumbered.");
                    }
                    VenuePlanRepository.updateTypes(connection, id, layout.getPlan().getTicketTypes());
                    if (replaceLayout) {
                        VenuePlanRepository.save(connection, id, layout.getPlan());
                    }
                } else {
                    // Save names, prices and unused grid offers in the same transaction.
                    if (!layout.getTicketTypes().isEmpty()) {
                        VenuePlanRepository.updateTypes(connection, id, layout.getTicketTypes());
                    }
                    if (replaceLayout) {
                        VenuePlanRepository.save(connection, id, null);
                    }
                }
                connection.commit();
                // Returns this result to the method that called the current operation.
                return id;
            } // Handles this error without reporting the failed operation as a success.
            catch (SQLException | RuntimeException ex) {
                // Undoes the uncommitted changes so a failure cannot leave a partial booking or refund.
                connection.rollback();
                // Stops this operation with a clear error; the caller can display or test the failure.
                throw ex;
            }
        }
    }

    // Claims one AVAILABLE seat and saves its ticket, payment and receipt atomically.
    public Ticket purchase(Session session, BookingRequest request) throws SQLException {
        // Calls this operation to carry out the named step with the supplied arguments.
        security.requireCustomer(session);
        // Prepares the local ticket id value used in the following steps.
        long ticketId;
        // Opens these resources in try-with-resources so Java closes them automatically after this block.
        try (Connection connection = Database.connect()) {
            // Starts a transaction: changes stay uncommitted until every related operation succeeds.
            connection.setAutoCommit(false);
            // Attempts the following operation and lets the catch block handle a failure.
            try {
                // Prepares the local event value used in the following steps.
                Event event = event(connection, request.getEventId(), true);
                // Continues into this block only when the condition below is true.
                if (!event.isPublished() || !event.getStartsAt().isAfter(LocalDateTime.now())) {
                    // Stops this operation with a clear error; the caller can display or test the failure.
                    throw new IllegalArgumentException("This event is not open for booking.");
                }
                // Prepares the local seat value used in the following steps.
                Seat seat;
                // Runs the SELECT and obtains a ResultSet containing the returned rows.
                try (PreparedStatement preparedStatement = prepareQuery(connection, "SELECT s.*,sec.category,sec.color,sec.ticket_name,sec.ticket_price,sec.early_bird FROM seats s JOIN sections sec ON sec.id=s.section_id WHERE s.id=? AND "
                        + "s.event_id=? FOR UPDATE", new Object[]{request.getSeatId(), request.getEventId()}); ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Moves to the next database row; false means there are no more matching records.
                    if (!resultSet.next()) {
                        // Stops this operation with a clear error; the caller can display or test the failure.
                        throw new IllegalArgumentException("Seat is not part of this event.");
                    }
                    // Updates this working value before the next step.
                    seat = readSeat(resultSet);
                }
                // Claims the seat only if it is still AVAILABLE; exactly one affected row is required.
                if (updateRecords(connection, "UPDATE seats SET status='SOLD' WHERE id=? AND status='AVAILABLE'", new Object[]{seat.getId()}) != 1) {
                    // Stops this operation with a clear error; the caller can display or test the failure.
                    throw new IllegalArgumentException("That seat was just booked. Please select another seat.");
                }
                // Prepares the local amount value used in the following steps.
                BigDecimal amount = event.calculatePrice(seat, request.getCategory());
                // Prepares the local reference value used in the following steps.
                String reference = request.getPayment().processSimulatedPayment(amount, request.isSimulateSuccess());
                // Prepares the local code value used in the following steps.
                String code = "OE-" + UUID.randomUUID().toString().replace("-", "").substring(0, 12).toUpperCase();
                // Saves the new row using the listed placeholder values and returns its generated ID when needed.
                ticketId = insertRecord(connection, "INSERT INTO tickets(code,event_id,customer_id,seat_id,seat_label,category,amount,status) VALUES(?,?,?,?,?,?,?,'VALID')", new Object[]{code, event.getId(), session.getUser().getId(), seat.getId(), seat.getLabel(), request.getCategory(), amount});
                // Saves the new row using the listed placeholder values and returns its generated ID when needed.
                long paymentId = insertRecord(connection, "INSERT INTO payments(ticket_id,method,reference,amount,status) VALUES(?,?,?,?,'SIMULATED_SUCCESS')", new Object[]{ticketId, request.getPayment().method(), reference, amount});
                // Saves the new row using the listed placeholder values and returns its generated ID when needed.
                insertRecord(connection, "INSERT INTO receipts(ticket_id,payment_id,number) VALUES(?,?,?)", new Object[]{ticketId, paymentId, "R-" + code.substring(3)});
                // Commits all transaction changes together so other connections can see the completed result.
                connection.commit();
            } // Handles this error without reporting the failed operation as a success.
            catch (SQLException | RuntimeException ex) {
                // Undoes the uncommitted changes so a failure cannot leave a partial booking or refund.
                connection.rollback();
                // Stops this operation with a clear error; the caller can display or test the failure.
                throw ex;
            }
        }
        // Prepares the local saved tickets value used in the following steps.
        List<Ticket> savedTickets = tickets(session, request.getEventId());
        // Visits each object in the collection using an ordinary enhanced for loop.
        for (Ticket ticket : savedTickets) {
            // Continues into this block only when the condition below is true.
            if (ticket.getId() == ticketId) {
                // Returns this result to the method that called the current operation.
                return ticket;
            }
        }
        // Stops this operation with a clear error; the caller can display or test the failure.
        throw new SQLException("The saved ticket could not be loaded.");
    }

    // Performs the tickets operation; exceptions are passed to the caller when needed.
    public List<Ticket> tickets(Session session, long eventId) throws SQLException {
        // Prepares the local access condition value used in the following steps.
        String accessCondition = "t.customer_id=?";
        // Prepares the local parameters value used in the following steps.
        Object[] parameters = new Object[]{session.getUser().getId()};
        // Uses the Host workflow and its ownership restrictions.
        if (session.isHost()) {
            // Updates this working value before the next step.
            accessCondition = "e.host_id=? AND e.id=?";
            // Updates this working value before the next step.
            parameters = new Object[]{session.getUser().getId(), eventId};
        }
        // Prepares the local sql value used in the following steps.
        String sql = "SELECT t.*,e.title,e.venue,e.starts_at,c.name,p.status payment_status,p.method,p.reference,r.number FROM "
                + "tickets t JOIN events e ON e.id=t.event_id JOIN customers c ON c.id=t.customer_id JOIN payments p ON "
                + "p.ticket_id=t.id JOIN receipts r ON r.ticket_id=t.id WHERE " + accessCondition + " ORDER BY t.issued_at DESC,t.id DESC";
        // Runs the SELECT and obtains a ResultSet containing the returned rows.
        try (Connection connection = Database.connect(); PreparedStatement preparedStatement = prepareQuery(connection, sql, parameters); ResultSet resultSet = preparedStatement.executeQuery()) {
            // Prepares the local list value used in the following steps.
            List<Ticket> list = new ArrayList<Ticket>();
            // Moves to the next database row; false means there are no more matching records.
            while (resultSet.next()) {
                // Adds this object to the collection or this child component to its parent container.
                list.add(new Ticket(resultSet.getLong("id"), resultSet.getString("code"), resultSet.getLong("event_id"), resultSet.getLong("customer_id"), resultSet.getString("name"), resultSet.getString("title"), resultSet.getString("venue"), resultSet.getTimestamp("starts_at").toLocalDateTime(), resultSet.getString("seat_label"), resultSet.getString("category"), resultSet.getBigDecimal("amount"), resultSet.getString("status"), resultSet.getString("payment_status"), resultSet.getString("method"), resultSet.getString("reference"), resultSet.getString("number"), resultSet.getTimestamp("issued_at").toLocalDateTime()));
            }
            // Returns this result to the method that called the current operation.
            return list;
        }
    }

    // Checks refund eligibility and changes ticket, payment and seat status in one transaction.
    public void cancel(Session session, long ticketId) throws SQLException {
        // Opens these resources in try-with-resources so Java closes them automatically after this block.
        try (Connection connection = Database.connect()) {
            // Starts a transaction: changes stay uncommitted until every related operation succeeds.
            connection.setAutoCommit(false);
            // Attempts the following operation and lets the catch block handle a failure.
            try {
                // Prepares the local event id value used in the following steps.
                long eventId;
                // Runs the SELECT and obtains a ResultSet containing the returned rows.
                try (PreparedStatement preparedStatement = prepareQuery(connection, "SELECT event_id FROM tickets WHERE id=?", new Object[]{ticketId}); ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Moves to the next database row; false means there are no more matching records.
                    if (!resultSet.next()) {
                        // Stops this operation with a clear error; the caller can display or test the failure.
                        throw new IllegalArgumentException("Ticket not found.");
                    }
                    // Updates this working value before the next step.
                    eventId = resultSet.getLong(1);
                }
                // Prepares the local event value used in the following steps.
                Event event = event(connection, eventId, true);
                // Runs the SELECT and obtains a ResultSet containing the returned rows.
                try (PreparedStatement preparedStatement = prepareQuery(connection, "SELECT t.*,p.status payment_status FROM tickets t JOIN payments p ON p.ticket_id=t.id WHERE t.id=? FOR UPDATE", new Object[]{ticketId}); ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Moves to the next database row; false means there are no more matching records.
                    if (!resultSet.next()) {
                        // Stops this operation with a clear error; the caller can display or test the failure.
                        throw new IllegalArgumentException("Ticket not found.");
                    }
                    // Uses the Host workflow and its ownership restrictions.
                    if (session.isHost()) {
                        // Calls this operation to carry out the named step with the supplied arguments.
                        security.requireHost(session, event.getHostId());
                    } // Checks the next possible case when the earlier condition was false.
                    else if (session.getUser().getId() != resultSet.getLong("customer_id")) {
                        // Stops this operation with a clear error; the caller can display or test the failure.
                        throw new IllegalArgumentException("This ticket belongs to another Customer.");
                    }
                    // Continues into this block only when the condition below is true.
                    if (!"VALID".equals(resultSet.getString("status")) || !"SIMULATED_SUCCESS".equals(resultSet.getString("payment_status")) || !LocalDateTime.now().isBefore(event.getStartsAt())) {
                        // Stops this operation with a clear error; the caller can display or test the failure.
                        throw new IllegalArgumentException("Only an unused valid ticket before the event starts can be cancelled.");
                    }
                    // Applies this status or layout change within the existing database transaction.
                    updateRecords(connection, "UPDATE tickets SET status='CANCELLED' WHERE id=? AND status='VALID'", new Object[]{ticketId});
                    // Applies this status or layout change within the existing database transaction.
                    updateRecords(connection, "UPDATE payments SET status='SIMULATED_REFUNDED' WHERE ticket_id=?", new Object[]{ticketId});
                    // Applies this status or layout change within the existing database transaction.
                    updateRecords(connection, "UPDATE seats SET status='AVAILABLE' WHERE id=?", new Object[]{resultSet.getLong("seat_id")});
                }
                // Commits all transaction changes together so other connections can see the completed result.
                connection.commit();
            } // Handles this error without reporting the failed operation as a success.
            catch (SQLException | RuntimeException ex) {
                // Undoes the uncommitted changes so a failure cannot leave a partial booking or refund.
                connection.rollback();
                // Stops this operation with a clear error; the caller can display or test the failure.
                throw ex;
            }
        }
    }

    // Checks event ownership and conditionally changes a paid VALID ticket to USED once.
    public String checkIn(Session session, long eventId, String code) throws SQLException {
        // Opens these resources in try-with-resources so Java closes them automatically after this block.
        try (Connection connection = Database.connect()) {
            // Starts a transaction: changes stay uncommitted until every related operation succeeds.
            connection.setAutoCommit(false);
            // Attempts the following operation and lets the catch block handle a failure.
            try {
                // Calls this operation to carry out the named step with the supplied arguments.
                security.requireHost(session, event(connection, eventId, true).getHostId());
                // Prepares the local name value used in the following steps.
                String name;
                // Runs the SELECT and obtains a ResultSet containing the returned rows.
                try (PreparedStatement preparedStatement = prepareQuery(connection, "SELECT t.id,t.status,c.name,p.status payment_status FROM tickets t JOIN customers c ON "
                        + "c.id=t.customer_id JOIN payments p ON p.ticket_id=t.id WHERE t.code=? AND t.event_id=? FOR UPDATE", new Object[]{code.trim().toUpperCase(Locale.ROOT), eventId}); ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Moves to the next database row; false means there are no more matching records.
                    if (!resultSet.next()) {
                        // Stops this operation with a clear error; the caller can display or test the failure.
                        throw new IllegalArgumentException("Ticket code does not match this event.");
                    }
                    // Continues into this block only when the condition below is true.
                    if (!"VALID".equals(resultSet.getString("status")) || !"SIMULATED_SUCCESS".equals(resultSet.getString("payment_status"))) {
                        // Stops this operation with a clear error; the caller can display or test the failure.
                        throw new IllegalArgumentException("Entry rejected: ticket is " + resultSet.getString("status") + ".");
                    }
                    // Changes VALID to USED conditionally, preventing a ticket from being checked in twice.
                    if (updateRecords(connection, "UPDATE tickets SET status='USED' WHERE id=? AND status='VALID'", new Object[]{resultSet.getLong("id")}) != 1) {
                        // Stops this operation with a clear error; the caller can display or test the failure.
                        throw new IllegalArgumentException("Ticket was already checked in.");
                    }
                    // Updates this working value before the next step.
                    name = resultSet.getString("name");
                }
                // Commits all transaction changes together so other connections can see the completed result.
                connection.commit();
                // Returns this result to the method that called the current operation.
                return name;
            } // Handles this error without reporting the failed operation as a success.
            catch (SQLException | RuntimeException ex) {
                // Undoes the uncommitted changes so a failure cannot leave a partial booking or refund.
                connection.rollback();
                // Stops this operation with a clear error; the caller can display or test the failure.
                throw ex;
            }
        }
    }

    // Convert one row using saved offer metadata when present, otherwise retain legacy rules.
    private Seat readSeat(ResultSet row) throws SQLException {
        if (row.getBigDecimal("ticket_price") != null) {
            TicketType type = new TicketType(row.getString("category"), row.getString("ticket_name"), row.getBigDecimal("ticket_price"), row.getString("color"), row.getBoolean("early_bird"));
            return new Seat(row.getLong("id"), row.getInt("row_no"), row.getInt("col_no"), row.getString("label"), type, row.getString("status"), row.getString("area_code"));
        }
        return new Seat(row.getLong("id"), row.getInt("row_no"), row.getInt("col_no"), row.getString("label"), row.getString("category"), row.getString("color"), row.getString("status"));
    }

    public List<TicketType> ticketTypes(Session session, long eventId) throws SQLException {
        try (Connection connection = Database.connect()) {
            Event event = event(connection, eventId, false);
            security.requireHost(session, event.getHostId());
            List<TicketType> types = new ArrayList<TicketType>();
            try (PreparedStatement query = prepareQuery(connection, "SELECT * FROM sections WHERE event_id=? ORDER BY id", new Object[]{eventId}); ResultSet row = query.executeQuery()) {
                while (row.next()) {
                    BigDecimal price = row.getBigDecimal("ticket_price");
                    String code = row.getString("category");
                    String name = row.getString("ticket_name");
                    boolean early = row.getBoolean("early_bird");
                    if (price == null) {
                        price = event.getBasePrice();
                        name = code;
                        early = "REGULAR".equals(code);
                        if ("VIP".equals(code)) {
                            price = price.multiply(new BigDecimal("1.50")).setScale(2, java.math.RoundingMode.HALF_UP);
                        }
                    }
                    types.add(new TicketType(code, name, price, row.getString("color"), early));
                }
            }
            return types;
        }
    }

    public void updateTicketTypes(Session session, long eventId, List<TicketType> types) throws SQLException {
        try (Connection connection = Database.connect()) {
            connection.setAutoCommit(false);
            try {
                security.requireHost(session, event(connection, eventId, true).getHostId());
                VenuePlanRepository.updateTypes(connection, eventId, types);
                connection.commit();
            } catch (SQLException | RuntimeException exception) {
                connection.rollback();
                throw exception;
            }
        }
    }

    // Compare every structural value, but allow display names, offer prices and colors to change.
    private boolean sameGeometry(VenuePlan first, VenuePlan second) {
        com.mycompany.openevent.model.Stage a = first.getStage();
        com.mycompany.openevent.model.Stage b = second.getStage();
        if (!a.getBounds().equals(b.getBounds()) || first.getAreas().size() != second.getAreas().size()) {
            return false;
        }
        for (int i = 0; i < first.getAreas().size(); i++) {
            com.mycompany.openevent.model.VenueArea x = first.getAreas().get(i);
            com.mycompany.openevent.model.VenueArea y = second.getAreas().get(i);
            if (!x.getCode().equals(y.getCode()) || !x.getName().equals(y.getName()) || !x.getTypeCode().equals(y.getTypeCode())
                    || !x.getBounds().equals(y.getBounds()) || x.getRows() != y.getRows() || x.getColumns() != y.getColumns()
                    || x.getRowOffset() != y.getRowOffset() || !x.getShape().equals(y.getShape()) || !x.getBlocked().equals(y.getBlocked())) {
                return false;
            }
        }
        return true;
    }
}
