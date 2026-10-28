// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
package com.mycompany.openevent.service;

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
// Imports Connection so this class can use that type by its short name.
import java.sql.Connection;
// Imports PreparedStatement so this class can use that type by its short name.
import java.sql.PreparedStatement;
// Imports BigDecimal so this class can use that type by its short name.
import java.math.BigDecimal;
// Imports LocalDate so this class can use that type by its short name.
import java.time.LocalDate;
// Imports LocalDateTime so this class can use that type by its short name.
import java.time.LocalDateTime;
// Imports List so this class can use that type by its short name.
import java.util.List;
// Imports ArrayList so this class can use that type by its short name.
import java.util.ArrayList;

// Defines the DemoData class and keeps its related data and operations together.
public final class DemoData {

    // Constructs a DemoData object and initializes or validates its starting state.
    private DemoData() {
    }

    // Starts the application or the explicitly selected utility/test program.
    public static void main(String[] args) throws Exception {
        // Opens these resources in try-with-resources so Java closes them automatically after this block.
        try (Connection connection = Database.connect()) {
            // Creates a parameterized SQL statement; values are bound separately instead of concatenated into SQL.
            for (String role : new String[]{"hosts", "customers"})try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO " + role + "(name,email,password_hash) VALUES(?,?,?)")) {
                // Prepares the local name value used in the following steps.
                String name = "Alex Lim";
                // Prepares the local email value used in the following steps.
                String email = "alex@openevent.local";
                // Continues into this block only when the condition below is true.
                if (role.equals("hosts")) {
                    // Updates this working value before the next step.
                    name = "Mika Santos";
                    // Updates this working value before the next step.
                    email = "host@openevent.local";
                }
                // Binds a typed value to the corresponding SQL placeholder.
                preparedStatement.setString(1, name);
                // Binds a typed value to the corresponding SQL placeholder.
                preparedStatement.setString(2, email);
                // Binds a typed value to the corresponding SQL placeholder.
                preparedStatement.setString(3, SecurityService.hash("OpenEvent2026!".toCharArray()));
                // Runs the write statement and obtains its affected-row count.
                preparedStatement.executeUpdate();
            }
        }
        // Prepares the local host value used in the following steps.
        Session host = new SecurityService().login("host@openevent.local", "OpenEvent2026!".toCharArray(), true);
        // Prepares the object that reads and writes database records.
        BookingRepository repository = new BookingRepository();
        // Continues into this block only when the condition below is true.
        if (!repository.events(host, "").isEmpty()) {
            // Prints this test or setup result to the program output.
            System.out.println("Demo events already exist.");
            // Leaves this method now because there is no further work for this request.
            return;
        }
        // Prepares the local titles value used in the following steps.
        String[] titles = {"Between the Islands", "After Hours, Escolta", "Soft Sounds Sunday"};
        // Prepares the local venues value used in the following steps.
        String[] venues = {"123 Block · Mandaluyong", "First United Building · Manila", "Mow's · Quezon City"};
        // Prepares the local images value used in the following steps.
        String[] images = {"concert.jpg", "electronic.jpg", "acoustic.jpg"};
        // Repeats this block with an index so each relevant position or parameter is processed.
        for (int eventIndex = 0; eventIndex < 3; eventIndex++) {
            // Prepares the local start value used in the following steps.
            LocalDateTime start = LocalDate.now().plusDays(26 + eventIndex * 7).atTime(19, 0);
            // Prepares the local event value used in the following steps.
            Event event = new Concert(0, host.getUser().getId(), titles[eventIndex], venues[eventIndex], "A night for the independent scene. Discover local artists, find your people, and support a shared stage. " +
                    "Doors open one hour before the show. Bring your ticket code for entry.", images[eventIndex], start, start.minusDays(7), new BigDecimal(new String[]{"850", "500", "400"}[eventIndex]), true);
            // Prepares the local seats value used in the following steps.
            List<Seat> seats = new ArrayList<Seat>();
            // Repeats this block with an index so each relevant position or parameter is processed.
            for (int row = 1; row < 7; row++) {
                // Repeats this block with an index so each relevant position or parameter is processed.
                for (int column = 0; column < 12; column++) {
                    // Continues into this block only when the condition below is true.
                    if (column != 5 && column != 6) {
                        // Prepares the local category value used in the following steps.
                        String category = "REGULAR";
                        // Prepares the local color value used in the following steps.
                        String color = "#2AA89B";
                        // Continues into this block only when the condition below is true.
                        if (row <= 2) {
                            // Updates this working value before the next step.
                            category = "VIP";
                            // Updates this working value before the next step.
                            color = "#8B5CF6";
                        }
                        // Adds this object to the collection or this child component to its parent container.
                        seats.add(new Seat(0, row, column, "" + (char) ('A' + row) + (column + 1), category, color, "AVAILABLE"));
                    }
                }
            }
            // Calls this operation to carry out the named step with the supplied arguments.
            repository.saveEvent(host, event, new VenueLayout(7, 12, 0, 3, 6, seats), true);
        }
        // Prints this test or setup result to the program output.
        System.out.println("Three sample events created.");
    }
}
