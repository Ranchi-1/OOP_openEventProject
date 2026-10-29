package com.mycompany.openevent;

import com.mycompany.openevent.model.VenuePlan;
import com.mycompany.openevent.model.VenueLayout;
import com.mycompany.openevent.model.Seat;
import com.mycompany.openevent.model.TicketType;
import com.mycompany.openevent.ui.VenueDesigner;
import com.mycompany.openevent.ui.TicketTypePanel;
import com.mycompany.openevent.ui.ResponsiveView;
import com.mycompany.openevent.ui.EventCards;
import com.mycompany.openevent.ui.VenueBrowser;
import com.mycompany.openevent.ui.VenueCanvas;
import com.mycompany.openevent.ui.SeatGrid;
import com.mycompany.openevent.ui.LoginView;
import com.mycompany.openevent.ui.NavigationView;
import com.mycompany.openevent.ui.DiscoverView;
import com.mycompany.openevent.ui.EventView;
import com.mycompany.openevent.ui.CheckoutView;
import com.mycompany.openevent.ui.TicketsView;
import com.mycompany.openevent.ui.HostView;
import com.mycompany.openevent.ui.EventEditorView;
import com.mycompany.openevent.ui.DisplayText;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import java.awt.Component;
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.List;
import java.util.HashSet;

/**
 * Regression checks for edits that used to disappear, stale seat selection and
 * narrow layouts.
 */
public class UsabilityChecks {

    private static int passed;

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
        System.out.println("PASS " + (++passed) + ": " + message);
    }

    private static <T> T find(Container root, Class<T> type, String name) {
        for (Component child : root.getComponents()) {
            if (type.isInstance(child)) {
                String accessible = null;
                if (child.getAccessibleContext() != null) {
                    accessible = child.getAccessibleContext().getAccessibleName();
                }
                if (name == null || name.equals(accessible) || (child instanceof JButton && name.equals(((JButton) child).getText()))) {
                    return type.cast(child);
                }
            }
            if (child instanceof Container) {
                T nested = find((Container) child, type, name);
                if (nested != null) {
                    return nested;
                }
            }
        }
        return null;
    }

    private static void inside(JPanel panel, int width) {
        ResponsiveView view = new ResponsiveView(panel, 1176);
        view.setSize(width, panel.getPreferredSize().height);
        view.doLayout();
        view.fitWidth();
        for (Component component : panel.getComponents()) {
            if (!component.isVisible()) {
                continue;
            }
            Rectangle bounds = component.getBounds();
            if (bounds.x < 0 || bounds.x + bounds.width > width + 1) {
                throw new AssertionError(panel.getClass().getSimpleName() + " contains a cut-off control");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                VenuePlan original = VenuePlan.template("Rectangular Hall", new BigDecimal("500.00"));
                VenueDesigner designer = new VenueDesigner(original, false, new BigDecimal("500.00"));
                JTextField sectionName = find(designer, JTextField.class, "Section name");
                JList<?> sections = find(designer, JList.class, "Venue sections");
                sectionName.setText("Main Floor");
                sections.setSelectedIndex(2);
                check(designer.getPlan().getAreas().get(0).getName().equals("Main Floor"), "Section rename survives switching sections without pressing Apply");
                sections.setSelectedIndex(0);
                JSpinner left = find(designer, JSpinner.class, "Left position");
                left.setValue(300);
                sections.setSelectedIndex(1);
                check(designer.getPlan().getStage().getX() == 300, "Stage edit survives switching back to a seating section");
                sectionName.setText("Temporary field edit");
                find(designer, JButton.class, "Reset field edits").doClick();
                check(sectionName.getText().equals("Main Floor"), "Reset field edits restores the last accepted section values");
                VenueDesigner locked = new VenueDesigner(original, true, new BigDecimal("500.00"));
                check(!find(locked, JButton.class, "Use template").isEnabled(), "Booked editor disables template replacement");
                check(find(locked, JButton.class, "Ticket types").isEnabled(), "Booked editor still permits future offer edits");
                HashSet<String> assigned = new HashSet<String>();
                assigned.add("GENERAL");
                assigned.add("PREMIUM");
                TicketTypePanel types = new TicketTypePanel(original.getTicketTypes(), assigned);
                JTextField name = find(types, JTextField.class, "Ticket name");
                JTextField price = find(types, JTextField.class, "Ticket price");
                JList<?> offers = find(types, JList.class, "Ticket types");
                name.setText("Floor_Pass");
                price.setText("650.00");
                offers.setSelectedIndex(1);
                check(types.getTypes().get(0).getName().equals("Floor_Pass"), "Ticket rename survives switching offers without pressing Apply");
                check(types.getTypes().get(0).getPrice().equals(new BigDecimal("650.00")), "Ticket price edit survives switching offers");
                find(types, JButton.class, "Add").doClick();
                check(types.getTypes().size() == 3, "A third custom offer can be added");
                name.setText("Meet and Greet");
                offers.setSelectedIndex(0);
                check(types.getTypes().get(2).getName().equals("Meet and Greet"), "New custom offer edits survive another selection");
                offers.setSelectedIndex(2);
                find(types, JButton.class, "Remove").doClick();
                check(types.getTypes().size() == 2, "Unused offer removal retains the other offers");
                JPanel[] panels = {new LoginView(), new NavigationView(), new DiscoverView(), new EventView(), new CheckoutView(), new TicketsView(), new HostView(), new EventEditorView()};
                for (JPanel panel : panels) {
                    inside(panel, 960);
                    check(true, panel.getClass().getSimpleName() + " controls fit a narrow viewport");
                }
                LoginView login = new LoginView();
                ResponsiveView responsive = new ResponsiveView(login, 1176);
                responsive.setSize(960, 660);
                responsive.doLayout();
                responsive.fitWidth();
                Rectangle narrow = login.passwordToggle.getBounds();
                responsive.setSize(1240, 660);
                responsive.doLayout();
                responsive.fitWidth();
                responsive.setSize(960, 660);
                responsive.doLayout();
                responsive.fitWidth();
                check(narrow.equals(login.passwordToggle.getBounds()), "Repeated resizing does not progressively shrink controls");
                EventCards cards = new EventCards();
                for (int i = 0; i < 7; i++) {
                    cards.add(new JPanel());
                }
                cards.setSize(940, 300);
                cards.updateColumns();
                check(((java.awt.GridLayout) cards.getLayout()).getColumns() == 2, "Narrow discovery uses two readable card columns");
                cards.setSize(1120, 300);
                cards.updateColumns();
                check(((java.awt.GridLayout) cards.getLayout()).getColumns() == 3, "Wide discovery restores three card columns");
                final Seat[] chosen = {new Seat(0, 0, 0, "old", "REGULAR", "#000000", "AVAILABLE")};
                final int[] cleared = {0};
                VenueBrowser browser = new VenueBrowser(new VenueLayout(original), new SeatGrid.SeatSelectionListener() {
                    @Override
                    public void seatSelected(Seat seat) {
                        chosen[0] = seat;
                        if (seat == null) {
                            cleared[0]++;
                        }
                    }
                });
                check(chosen[0] == null, "Opening the overview clears any old checkout seat");
                VenueCanvas canvas = find(browser, VenueCanvas.class, null);
                canvas.setSize(720, 500);
                BufferedImage image = new BufferedImage(720, 500, BufferedImage.TYPE_INT_RGB);
                java.awt.Graphics graphics = image.getGraphics();
                canvas.paint(graphics);
                graphics.dispose();
                // Hall section 1 is around logical (200,245), safely away from its edges.
                canvas.dispatchEvent(new MouseEvent(canvas, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, 154, 178, 1, false));
                check(cleared[0] >= 2, "Opening a different section clears checkout selection");
                JButton seat = find(browser, JButton.class, "S1-A1");
                check(seat != null, "Section detail contains labeled assigned seats");
                seat.doClick();
                check(chosen[0] != null && chosen[0].getLabel().equals("S1-A1"), "Seat buttons notify the booking screen");
                find(browser, JButton.class, "← Venue overview").doClick();
                check(chosen[0] == null, "Returning to the overview clears the previously chosen seat");
                check(DisplayText.category("Floor_Pass").equals("Floor_Pass"), "Custom ticket names keep their original spelling and underscores");
                check(DisplayText.ticketStatus("USED").equals("Checked in"), "Ticket status uses a clear customer-facing label");
                check(DisplayText.paymentStatus("SIMULATED_REFUNDED").equals("Simulated refund completed"), "Refund status stays clear about simulation");
            }
        });
        System.out.println("ALL " + passed + " USABILITY CHECKS PASSED");
    }
}
