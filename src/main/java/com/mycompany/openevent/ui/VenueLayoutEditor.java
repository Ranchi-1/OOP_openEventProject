package com.mycompany.openevent.ui;

// Validated immutable objects hold the arrangement independently from the screen size.
import com.mycompany.openevent.model.VenueLayout;
import com.mycompany.openevent.model.VenuePlan;
import com.mycompany.openevent.model.VenueArea;
import com.mycompany.openevent.model.TicketType;
import com.mycompany.openevent.model.Stage;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * A blank venue canvas with two main buttons and a simple click-to-edit seat
 * dialog.
 */
public class VenueLayoutEditor extends JPanel implements ActionListener, VenueCanvas.EditorListener {

    private VenuePlan plan;
    private final VenueLayout original;
    private final boolean locked;
    private final VenueCanvas canvas;
    private final JLabel help = new JLabel();
    private final JButton add = new JButton("Add section");
    private boolean placing;
    private boolean customPrices;
    private JTextField startingPriceField;

    // Existing saved plans are preserved; new venues start with a stage and no sections.
    public VenueLayoutEditor(VenueLayout layout, boolean protectSeats, BigDecimal price) {
        super(new BorderLayout(6, 6));
        original = layout;
        locked = protectSeats;
        if (layout == null) {
            plan = VenuePlan.empty(price);
        } else {
            plan = layout.getPlan();
        }
        canvas = new VenueCanvas(plan, !locked, this);
        canvas.getAccessibleContext().setAccessibleName("Editable venue overview");
        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 2));
        add.addActionListener(this);
        add.setEnabled(!locked);
        toolbar.add(add);
        JButton types = new JButton("Ticket types");
        types.addActionListener(this);
        toolbar.add(types);
        toolbar.add(new JLabel("Click a section for seats · Drag to move · Drag its corner to resize"));
        add(toolbar, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(help, BorderLayout.SOUTH);
        setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        setPreferredSize(new Dimension(1000, 510));
        message("Start empty: add sections and arrange them into a U, rows, or your own layout.");
        if (locked) {
            message("Booked layout: positions and seats are locked. Future ticket offers can still change.");
        }
    }

    // Read the main price only before the first offer is customized or used by a section.
    public void setStartingPriceField(JTextField field) {
        startingPriceField = field;
    }

    private void syncStartingPrice() {
        if (original != null || customPrices || !plan.getAreas().isEmpty() || startingPriceField == null) {
            return;
        }
        TicketType type = plan.getTicketTypes().get(0);
        List<TicketType> types = new ArrayList<TicketType>();
        types.add(new TicketType(type.getCode(), type.getName(), new BigDecimal(startingPriceField.getText().trim()), type.getColor(), type.hasEarlyBird()));
        plan = VenuePlan.draft(plan.getStage(), plan.getAreas(), types);
        canvas.setPlan(plan);
    }

    // Messages stay beneath the canvas so an invalid drag does not interrupt editing with a popup.
    private void message(String text) {
        help.setText("<html>" + Theme.html(text) + "</html>");
    }

    // Save only a real venue with at least one section and one available seat per section.
    public VenueLayout getVenueLayout() {
        if (plan.getAreas().isEmpty()) {
            throw new IllegalArgumentException("Add at least one section before saving the event.");
        }
        VenuePlan validated = new VenuePlan(plan.getStage(), plan.getAreas(), plan.getTicketTypes());
        if (locked) {
            return new VenueLayout(validated, original.getSeats());
        }
        return new VenueLayout(validated);
    }

    // Expose the immutable draft for preview/testing without permitting external list mutation.
    public VenuePlan getPlan() {
        return plan;
    }

    @Override
    public void selected(int index) {
        canvas.select(index);
    }

    // Add mode uses the next click on blank space; clicking the button again cancels placement.
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            if (event.getSource() == add) {
                if (locked) {
                    return;
                }
                syncStartingPrice();
                if (plan.getAreas().size() >= 12) {
                    message("Maximum 12 sections. Edit or remove a section first.");
                    return;
                }
                placing = !placing;
                if (placing) {
                    add.setText("Cancel add");
                    canvas.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                    message("Click an empty space to place the section.");
                } else {
                    finishPlacement();
                }
            } else {
                editTicketTypes();
            }
        } catch (RuntimeException exception) {
            message(exception.getMessage());
        }
    }

    private void finishPlacement() {
        placing = false;
        add.setText("Add section");
        canvas.setCursor(Cursor.getDefaultCursor());
        message("Click a section for its seat grid. Drag sections or the stage to arrange the venue.");
    }

    // Sections have stable codes and separate logical seat rows, even when moved on the canvas.
    @Override
    public void placed(int x, int y) {
        if (!placing || locked) {
            return;
        }
        try {
            List<VenueArea> areas = plan.getAreas();
            Set<String> used = new HashSet<String>();
            int offset = 0;
            for (VenueArea area : areas) {
                used.add(area.getCode());
                used.add(area.getName().toLowerCase(java.util.Locale.ROOT));
                offset = Math.max(offset, area.getRowOffset() + 10);
            }
            int next = 1;
            while (used.contains("S" + next) || used.contains("section " + next)) {
                next++;
            }
            int left = Math.max(0, Math.min(840, x - 80));
            int top = Math.max(0, Math.min(590, y - 55));
            TicketType type = plan.getTicketTypes().get(0);
            areas.add(new VenueArea("S" + next, "Section " + next, type.getCode(), left, top, 160, 110, 5, 6, offset, "RECTANGLE", new HashSet<String>()));
            plan = VenuePlan.draft(plan.getStage(), areas, plan.getTicketTypes());
            canvas.setPlan(plan);
            canvas.select(areas.size() - 1);
            finishPlacement();
            message("Section added. Click it to rename it, choose a ticket type, color it, or edit its seats.");
        } catch (RuntimeException exception) {
            message("Cannot place here: " + exception.getMessage() + " Try another empty space.");
        }
    }

    // Clamp dragged objects inside the logical canvas and reject overlaps without changing the saved draft.
    @Override
    public void moved(int index, int x, int y) {
        if (locked) {
            return;
        }
        try {
            if (index == -1) {
                Stage old = plan.getStage();
                Stage stage = new Stage(Math.max(0, Math.min(1000 - old.getWidth(), x)), Math.max(0, Math.min(700 - old.getHeight(), y)), old.getWidth(), old.getHeight());
                plan = VenuePlan.draft(stage, plan.getAreas(), plan.getTicketTypes());
            } else {
                VenueArea old = plan.getAreas().get(index);
                replaceArea(index, Math.max(0, Math.min(1000 - old.getWidth(), x)), Math.max(0, Math.min(700 - old.getHeight(), y)), old.getWidth(), old.getHeight());
            }
            canvas.setPlan(plan);
            message("Position updated. Save the event when finished.");
        } catch (RuntimeException exception) {
            canvas.repaint();
            message("Move not applied: " + exception.getMessage());
        }
    }

    // A small bottom-right corner grip resizes the stage or section; no coordinate inspector is needed.
    @Override
    public void resized(int index, int width, int height) {
        if (locked) {
            return;
        }
        try {
            if (index == -1) {
                Stage old = plan.getStage();
                Stage stage = new Stage(old.getX(), old.getY(), Math.max(40, Math.min(1000 - old.getX(), width)), Math.max(30, Math.min(700 - old.getY(), height)));
                plan = VenuePlan.draft(stage, plan.getAreas(), plan.getTicketTypes());
            } else {
                VenueArea old = plan.getAreas().get(index);
                replaceArea(index, old.getX(), old.getY(), Math.max(60, Math.min(1000 - old.getX(), width)), Math.max(50, Math.min(700 - old.getY(), height)));
            }
            canvas.setPlan(plan);
            message("Size updated. Section seat counts are edited by clicking the section.");
        } catch (RuntimeException exception) {
            canvas.repaint();
            message("Resize not applied: " + exception.getMessage());
        }
    }

    private void replaceArea(int index, int x, int y, int width, int height) {
        List<VenueArea> areas = plan.getAreas();
        VenueArea old = areas.get(index);
        areas.set(index, new VenueArea(old.getCode(), old.getName(), old.getTypeCode(), x, y, width, height, old.getRows(), old.getColumns(), old.getRowOffset(), old.getShape(), old.getBlocked(), old.getColor()));
        plan = VenuePlan.draft(plan.getStage(), areas, plan.getTicketTypes());
    }

    // Clicking a section opens the familiar readable seat grid instead of a permanent inspector.
    @Override
    public void opened(int index) {
        if (placing || index < 0) {
            return;
        }
        SimpleGridEditor editor = new SimpleGridEditor(getVenueLayout(), locked, plan.getTicketTypes().get(0).getPrice());
        editor.showSection(index);
        editor.setPreferredSize(new Dimension(840, 510));
        Object[] options = {"Save section", "Remove section", "Cancel"};
        if (locked) {
            options = new Object[]{"Save offers", "Cancel"};
        }
        while (true) {
            int choice = JOptionPane.showOptionDialog(this, editor, "Section and seats", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (choice == 0) {
                try {
                    plan = editor.getVenueLayout().getPlan();
                    canvas.setPlan(plan);
                    message("Section changes kept. Save the event to store them.");
                    return;
                } catch (RuntimeException exception) {
                    JOptionPane.showMessageDialog(this, exception.getMessage());
                }
            } else if (choice == 1 && !locked) {
                if (JOptionPane.showConfirmDialog(this, "Remove this section and its seats from the draft?", "Remove section", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    List<VenueArea> areas = plan.getAreas();
                    areas.remove(editor.getSelectedSection());
                    plan = VenuePlan.draft(plan.getStage(), areas, plan.getTicketTypes());
                    canvas.select(-2);
                    canvas.setPlan(plan);
                    return;
                }
            } else {
                return;
            }
        }
    }

    // Keep custom names, prices and offer colors together in one dialog.
    private void editTicketTypes() {
        syncStartingPrice();
        Set<String> assigned = new HashSet<String>();
        for (VenueArea area : plan.getAreas()) {
            assigned.add(area.getTypeCode());
        }
        TicketTypePanel editor = new TicketTypePanel(plan.getTicketTypes(), assigned);
        editor.setPreferredSize(new Dimension(620, 420));
        while (JOptionPane.showConfirmDialog(this, editor, "Ticket types", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION) {
            try {
                plan = VenuePlan.draft(plan.getStage(), plan.getAreas(), editor.getTypes());
                customPrices = true;
                canvas.setPlan(plan);
                message("Ticket offers updated. Save the event when finished.");
                return;
            } catch (RuntimeException exception) {
                JOptionPane.showMessageDialog(this, exception.getMessage());
            }
        }
    }
}
