package com.mycompany.openevent;

import com.mycompany.openevent.model.*;
import com.mycompany.openevent.service.*;
import com.mycompany.openevent.ui.*;
import javax.swing.*;
import java.awt.Component;
import java.awt.Container;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

/**
 * Checks the restored grid and Host registration; only this harness's fixtures
 * are removed.
 */
public class SimpleGridChecks {

    private static int passed;
    private static VenueLayout draft;

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
        System.out.println("PASS " + (++passed) + ": " + message);
    }

    private static Component find(Container root, String name) {
        for (Component child : root.getComponents()) {
            if (!(child instanceof JLabel) && child.getAccessibleContext() != null && name.equals(child.getAccessibleContext().getAccessibleName())) {
                return child;
            }
            if (child instanceof JButton && name.equals(((JButton) child).getText())) {
                return child;
            }
            if (child instanceof Container) {
                Component nested = find((Container) child, name);
                if (nested != null) {
                    return nested;
                }
            }
        }
        return null;
    }

    private static Seat at(VenueLayout layout, int row, int column) {
        for (Seat seat : layout.getSeats()) {
            if (seat.getRow() == row && seat.getColumn() == column) {
                return seat;
            }
        }
        return null;
    }

    private static void rejectHost(SecurityService security, String name, String email, char[] password) throws Exception {
        boolean rejected = false;
        try {
            security.registerHost(name, email, password);
        } catch (IllegalArgumentException expected) {
            rejected = true;
        }
        check(rejected, "Host registration rejects invalid or duplicate details");
        boolean cleared = true;
        for (char c : password) {
            if (c != '\0') {
                cleared = false;
            }
        }
        check(cleared, "Rejected registration clears temporary password characters");
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                SimpleGridEditor editor = new SimpleGridEditor(null, false, new BigDecimal("500.00"));
                check(!editor.getVenueLayout().isFlexible(), "New events return to the original single grid");
                check(editor.getVenueLayout().getTicketTypes().size() == 2, "Starting grid keeps two editable offers");
                JComboBox<?> paint = (JComboBox<?>) find(editor, "Grid ticket type");
                paint.setSelectedIndex(2);
                ((JButton) find(editor, "A1")).doClick();
                check(at(editor.getVenueLayout(), 0, 0) == null, "Painting Aisle removes only the clicked seat");
                paint.setSelectedIndex(1);
                // The cleared button displays a dash, so identify it by its stable action command.
                for (Component component : ((JPanel) ((JViewport) ((JScrollPane) editor.getComponent(1)).getViewport()).getView()).getComponents()) {
                    if (component instanceof JButton && "seat:0:0".equals(((JButton) component).getActionCommand())) {
                        ((JButton) component).doClick();
                        break;
                    }
                }
                check(at(editor.getVenueLayout(), 0, 0).getTypeCode().equals("VIP"), "Painting restores a seat with the selected offer");
                ((JSpinner) find(editor, "Grid rows")).setValue(4);
                ((JSpinner) find(editor, "Seats per row")).setValue(4);
                ((JButton) find(editor, "Update grid")).doClick();
                check(editor.getVenueLayout().getStageColumn() + editor.getVenueLayout().getStageWidth() <= 4, "Resizing automatically keeps the stage in bounds");
                check(editor.getVenueLayout().getSeats().size() == 12, "Resized seats exclude the stage");
                JTextField price = new JTextField("99.99");
                SimpleGridEditor priced = new SimpleGridEditor(null, false, new BigDecimal("500.00"));
                priced.setStartingPriceField(price);
                check(priced.getVenueLayout().getTicketTypes().get(0).getPrice().equals(new BigDecimal("99.99")), "Fresh offers follow the main starting price");
                check(priced.getVenueLayout().getTicketTypes().get(1).getPrice().equals(new BigDecimal("149.99")), "Default VIP price rounds to two decimals");
                VenueLayout flexible = new VenueLayout(VenuePlan.template("U-shaped Arena", new BigDecimal("500.00")));
                SimpleGridEditor saved = new SimpleGridEditor(flexible, false, new BigDecimal("500.00"));
                String code = flexible.getPlan().getAreas().get(0).getCode();
                ((JTextField) find(saved, "Section name")).setText("Main Floor");
                ((JComboBox<?>) find(saved, "Saved venue section")).setSelectedIndex(1);
                VenuePlan kept = saved.getVenueLayout().getPlan();
                check(kept.getAreas().get(0).getName().equals("Main Floor"), "Section edits are retained when switching grids");
                check(kept.getStage().getBounds().equals(flexible.getPlan().getStage().getBounds()), "Saved flexible venue keeps its stage geometry");
                check(kept.getAreas().get(0).getCode().equals(code) && kept.getAreas().get(0).getBounds().equals(flexible.getPlan().getAreas().get(0).getBounds()), "Saved section identity and physical position stay unchanged");
                SimpleGridEditor locked = new SimpleGridEditor(flexible, true, new BigDecimal("500.00"));
                check(!find(locked, "Update grid").isEnabled() && !find(locked, "Grid rows").isEnabled(), "Booked layout controls are disabled");
                check(find(locked, "Ticket types").isEnabled(), "Booked events can still edit future offers");
                check(locked.getVenueLayout().getSeats().size() == flexible.getSeats().size(), "Locked editor preserves seat inventory");
                LoginView login = new LoginView();
                check(login.registerHost.getText().equals("Create Host account") && login.registerHost.getBounds().x >= login.register.getBounds().x + login.register.getWidth(), "Host and Customer sign-up buttons are separate and do not overlap");
                draft = editor.getVenueLayout();
            }
        });
        SecurityService security = new SecurityService();
        BookingRepository repository = new BookingRepository();
        String email = "grid-host-" + UUID.randomUUID().toString() + "@example.test";
        long hostId = 0;
        long eventId = 0;
        try {
            char[] password = "Classroom2026!".toCharArray();
            security.registerHost("Grid QA Host", email, password);
            boolean cleared = true;
            for (char c : password) {
                if (c != '\0') {
                    cleared = false;
                }
            }
            check(cleared, "Successful Host registration clears the supplied password");
            Session host = security.login(email, "Classroom2026!".toCharArray(), true);
            hostId = host.getUser().getId();
            check(host.isHost(), "A registered Host can sign in with the Host role");
            rejectHost(security, "Duplicate", email, "Another2026!".toCharArray());
            rejectHost(security, "X", "invalid", "short".toCharArray());
            boolean wrongRole = false;
            try {
                security.login(email, "Classroom2026!".toCharArray(), false);
            } catch (IllegalArgumentException expected) {
                wrongRole = true;
            }
            check(wrongRole, "Host registration does not silently create a Customer login");
            List<TicketType> types = draft.getTicketTypes();
            TicketType extra = new TicketType("BACKSTAGE", "Backstage Pass", new BigDecimal("875.00"), "#334455", true);
            types.add(extra);
            types.add(new TicketType("FUTURE", "Future Offer", new BigDecimal("200.00"), "#778899", false));
            List<Seat> seats = new ArrayList<Seat>();
            for (Seat seat : draft.getSeats()) {
                seats.add(new Seat(0, seat.getRow(), seat.getColumn(), seat.getLabel(), extra, "AVAILABLE", null));
            }
            VenueLayout custom = new VenueLayout(draft.getRows(), draft.getColumns(), draft.getStageRow(), draft.getStageColumn(), draft.getStageWidth(), seats, types);
            LocalDateTime starts = LocalDateTime.now().plusDays(40);
            Event event = new Concert(0, hostId, "Simple grid QA " + UUID.randomUUID(), "QA Hall", "Temporary test event", "concert.jpg", starts, starts.minusDays(5), new BigDecimal("500.00"), true);
            eventId = repository.saveEvent(host, event, custom, true);
            VenueLayout loaded = repository.layout(eventId);
            check(!loaded.isFlexible() && loaded.getSeats().size() == seats.size(), "Registered Host saves and reloads a simple grid");
            check(loaded.getTicketTypes().size() == 4, "Custom and unused offers survive a grid save");
            check(loaded.getSeats().get(0).getTicketType().getName().equals("Backstage Pass"), "Seat offer name and price reload with the grid");
            Session customer = security.login("alex@openevent.local", "OpenEvent2026!".toCharArray(), false);
            Ticket ticket = repository.purchase(customer, new BookingRequest(eventId, loaded.getSeats().get(0).getId(), loaded.getSeats().get(0).getCategory(), new CashPayment(), true));
            check(ticket.getAmount().compareTo(new BigDecimal("875.00")) == 0, "Purchasing a painted custom offer uses its saved price");
            types.set(2, new TicketType("BACKSTAGE", "Meet the Artist", new BigDecimal("950.00"), "#112233", false));
            VenueLayout protectedGrid = new VenueLayout(loaded.getRows(), loaded.getColumns(), loaded.getStageRow(), loaded.getStageColumn(), loaded.getStageWidth(), loaded.getSeats(), types);
            Event existing = new Concert(eventId, hostId, event.getTitle(), event.getVenue(), event.getDescription(), event.getImage(), starts, starts.minusDays(5), new BigDecimal("500.00"), true);
            repository.saveEvent(host, existing, protectedGrid, false);
            check(repository.layout(eventId).getSeats().get(0).getId() == loaded.getSeats().get(0).getId(), "Offer-only save preserves booked seat identities");
            check(repository.layout(eventId).getSeats().get(0).getTicketType().getName().equals("Meet the Artist"), "Booked grids save new offer names for future sales");
            boolean blocked = false;
            try {
                repository.saveEvent(host, existing, protectedGrid, true);
            } catch (IllegalArgumentException expected) {
                blocked = true;
            }
            check(blocked, "Server still rejects structural changes to booked grids");
            System.out.println("ALL " + passed + " SIMPLE GRID AND HOST CHECKS PASSED");
        } finally {
            // Remove only the unique fixture event/account created in this process.
            try (Connection connection = Database.connect()) {
                if (eventId > 0) {
                    for (String sql : new String[]{"DELETE r FROM receipts r JOIN tickets t ON t.id=r.ticket_id WHERE t.event_id=?", "DELETE p FROM payments p JOIN tickets t ON t.id=p.ticket_id WHERE t.event_id=?", "DELETE FROM tickets WHERE event_id=?", "DELETE FROM seats WHERE event_id=?", "DELETE FROM venue_areas WHERE event_id=?", "DELETE FROM venue_plans WHERE event_id=?", "DELETE FROM sections WHERE event_id=?", "DELETE FROM venue_layouts WHERE event_id=?", "DELETE FROM events WHERE id=?"}) {
                        try (PreparedStatement statement = connection.prepareStatement(sql)) {
                            statement.setLong(1, eventId);
                            statement.executeUpdate();
                        }
                    }
                }
                if (hostId > 0) {
                    try (PreparedStatement statement = connection.prepareStatement("DELETE FROM hosts WHERE id=? AND email=?")) {
                        statement.setLong(1, hostId);
                        statement.setString(2, email);
                        statement.executeUpdate();
                    }
                }
            }
        }
    }
}
