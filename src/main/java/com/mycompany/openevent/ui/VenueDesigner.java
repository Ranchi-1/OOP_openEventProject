package com.mycompany.openevent.ui;
// Import VenuePlan for the explicit types used below.

import com.mycompany.openevent.model.VenuePlan;
// Import VenueArea for the explicit types used below.
import com.mycompany.openevent.model.VenueArea;
// Import Stage for the explicit types used below.
import com.mycompany.openevent.model.Stage;
// Import TicketType for the explicit types used below.
import com.mycompany.openevent.model.TicketType;
// Import JPanel for the explicit types used below.
import javax.swing.JPanel;
// Import JSplitPane for the explicit types used below.
import javax.swing.JSplitPane;
// Import JScrollPane for the explicit types used below.
import javax.swing.JScrollPane;
// Import JList for the explicit types used below.
import javax.swing.JList;
// Import DefaultListModel for the explicit types used below.
import javax.swing.DefaultListModel;
// Import JComboBox for the explicit types used below.
import javax.swing.JComboBox;
// Import JSpinner for the explicit types used below.
import javax.swing.JSpinner;
// Import SpinnerNumberModel for the explicit types used below.
import javax.swing.SpinnerNumberModel;
// Import JTextField for the explicit types used below.
import javax.swing.JTextField;
// Import JButton for the explicit types used below.
import javax.swing.JButton;
// Import JLabel for the explicit types used below.
import javax.swing.JLabel;
// Import JOptionPane for the explicit types used below.
import javax.swing.JOptionPane;
// Import BorderFactory for the explicit types used below.
import javax.swing.BorderFactory;
// Import ListSelectionListener for the explicit types used below.
import javax.swing.event.ListSelectionListener;
// Import ListSelectionEvent for the explicit types used below.
import javax.swing.event.ListSelectionEvent;
// Import BorderLayout for the explicit types used below.
import java.awt.BorderLayout;
// Import GridLayout for the explicit types used below.
import java.awt.GridLayout;
// Import Dimension for the explicit types used below.
import java.awt.Dimension;
// Import Color for the explicit types used below.
import java.awt.Color;
// Import ActionListener for the explicit types used below.
import java.awt.event.ActionListener;
// Import ActionEvent for the explicit types used below.
import java.awt.event.ActionEvent;
// Import BigDecimal for the explicit types used below.
import java.math.BigDecimal;
// Import List for the explicit types used below.
import java.util.List;
// Import ArrayList for the explicit types used below.
import java.util.ArrayList;
// Import HashSet for the explicit types used below.
import java.util.HashSet;
// Import Set for the explicit types used below.
import java.util.Set;

/**
 * Host editor. Immutable model replacements make invalid moves easy to reject.
 */
public class VenueDesigner extends JPanel implements ActionListener {

    private VenuePlan plan;
    // Keep locked private so outside classes use the public operations.
    private final boolean locked;
    // Keep defaultPrice private so outside classes use the public operations.
    private final BigDecimal defaultPrice;
    // Read the visible starting-price field again whenever a template is generated.
    private JTextField templatePriceField;

    public void setTemplatePriceField(JTextField field) {
        templatePriceField = field;
    }

    private BigDecimal templatePrice() {
        if (templatePriceField != null) {
            return new BigDecimal(templatePriceField.getText().trim());
        }
        return defaultPrice;
    }
    // Keep canvas private so outside classes use the public operations.
    private final VenueCanvas canvas;
    private final DefaultListModel<String> names = new DefaultListModel<String>();
    private final JList<String> list = new JList<String>(names);
    private final JTextField name = new JTextField();
    private final JComboBox<TicketType> type = new JComboBox<TicketType>();
    private final JComboBox<String> shape = new JComboBox<String>(new String[]{"RECTANGLE", "TRAPEZOID"});
    private final JComboBox<String> template = new JComboBox<String>(new String[]{"Rectangular Hall", "U-shaped Arena", "Fan Theater"});
    private final JSpinner x = spinner(0, 0, 1000);
    private final JSpinner y = spinner(0, 0, 700);
    private final JSpinner width = spinner(200, 40, 1000);
    private final JSpinner height = spinner(120, 30, 700);
    private final JSpinner rows = spinner(5, 1, 10);
    private final JSpinner columns = spinner(6, 1, 10);
    private boolean refreshing;
    // Track the form currently being edited separately from the requested list selection.
    private int editingIndex = -2;

    public VenueDesigner(VenuePlan plan, boolean locked, BigDecimal defaultPrice) {
        super(new BorderLayout(8, 8));
        this.plan = plan;
        this.locked = locked;
        this.defaultPrice = defaultPrice;
        setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        JPanel toolbar = new JPanel(new BorderLayout(8, 4));
        JPanel tools = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 2));
        tools.add(template);
        tools.add(button("Use template"));
        tools.add(button("Ticket types"));
        toolbar.add(tools, BorderLayout.NORTH);
        toolbar.add(new JLabel("<html>Drag a section to move it. Use the fields to resize or rename it.<br>Edits are kept when switching sections. Save the event when finished.</html>"), BorderLayout.SOUTH);
        add(toolbar, BorderLayout.NORTH);
        canvas = new VenueCanvas(plan, !locked, new VenueCanvas.Listener() {
            @Override
            public void selected(int index) {
                if (index >= -1) {
                    list.setSelectedIndex(index + 1);
                }
            }

            @Override
            public void moved(int index, int newX, int newY) {
                move(index, newX, newY);
            }
        });
        JPanel inspector = new JPanel(new BorderLayout(5, 5));
        list.getAccessibleContext().setAccessibleName("Venue sections");
        JScrollPane sections = new JScrollPane(list);
        sections.setPreferredSize(new Dimension(260, 130));
        inspector.add(sections, BorderLayout.NORTH);
        JPanel fields = new JPanel(new GridLayout(0, 2, 5, 5));
        field(fields, "Section name", name);
        field(fields, "Ticket type", type);
        field(fields, "Shape", shape);
        field(fields, "Left position", x);
        field(fields, "Top position", y);
        x.setToolTipText("Horizontal position on the venue canvas (0–1000).");
        y.setToolTipText("Vertical position on the venue canvas (0–700).");
        field(fields, "Width", width);
        field(fields, "Height", height);
        field(fields, "Seat rows", rows);
        field(fields, "Seats per row", columns);
        fields.add(button("Apply section"));
        fields.add(button("Aisles / blocked seats"));
        fields.add(button("Add section"));
        fields.add(button("Remove section"));
        fields.add(button("Reset field edits"));
        fields.add(new JLabel("Save event to store the venue."));
        inspector.add(fields, BorderLayout.CENTER);
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, canvas, inspector);
        split.setResizeWeight(0.72);
        split.setDividerLocation(720);
        add(split, BorderLayout.CENTER);
        String message = "1–12 sections · up to 10 × 10 seats each · no overlapping bounds · stage is not sellable";
        // Validate this condition before continuing with the operation.
        if (locked) {
            message = "Purchased seats lock geometry and section assignments. Ticket names, colors and future prices can still change.";
        }
        add(new JLabel(message), BorderLayout.SOUTH);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!refreshing && !event.getValueIsAdjusting()) {
                    changeSelection();
                }
            }
        });
        refresh(1);
        // Validate this condition before continuing with the operation.
        if (locked) {
            template.setEnabled(false);
            // Visit each relevant item using an ordinary loop.
            for (java.awt.Component component : fields.getComponents()) {
                component.setEnabled(false);
            }
        }
    }

    private static JSpinner spinner(int value, int minimum, int maximum) {
        return new JSpinner(new SpinnerNumberModel(value, minimum, maximum, 1));
    }

    private void field(JPanel panel, String label, java.awt.Component input) {
        JLabel caption = new JLabel(label);
        caption.setLabelFor(input);
        input.getAccessibleContext().setAccessibleName(label);
        panel.add(caption);
        panel.add(input);
    }

    private JButton button(String command) {
        JButton button = new JButton(command);
        button.addActionListener(this);
        if (locked && !"Ticket types".equals(command)) {
            button.setEnabled(false);
        }
        return button;
    }

    private int number(JSpinner spinner) {
        try {
            spinner.commitEdit();
        } catch (java.text.ParseException exception) {
            throw new IllegalArgumentException("Enter a whole number.");
        }
        return ((Number) spinner.getValue()).intValue();
    }

    private void refresh(int selection) {
        refreshing = true;
        names.clear();
        names.addElement("STAGE");
        // Visit each relevant item using an ordinary loop.
        for (VenueArea area : plan.getAreas()) {
            names.addElement(area.getName());
        }
        type.removeAllItems();
        for (TicketType offer : plan.getTicketTypes()) {
            type.addItem(offer);
        }
        list.setSelectedIndex(Math.min(Math.max(selection, 0), names.size() - 1));
        refreshing = false;
        canvas.setPlan(plan);
        load();
    }

    private void changeSelection() {
        int requested = list.getSelectedIndex() - 1;
        if (requested == editingIndex || requested < -1) {
            return;
        }
        try {
            if (editingIndex >= -1 && !locked) {
                apply();
            }
            refreshing = true;
            list.setSelectedIndex(requested + 1);
            refreshing = false;
            load();
        } catch (RuntimeException exception) {
            refreshing = true;
            list.setSelectedIndex(editingIndex + 1);
            refreshing = false;
            canvas.select(editingIndex);
            JOptionPane.showMessageDialog(this, exception.getMessage() + "\nCorrect these fields before choosing another section.", "Check section", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void load() {
        int index = list.getSelectedIndex() - 1;
        // Validate this condition before continuing with the operation.
        if (index < -1) {
            return;
        }
        editingIndex = index;
        canvas.select(index);
        // Validate this condition before continuing with the operation.
        if (index == -1) {
            Stage stage = plan.getStage();
            name.setText("STAGE");
            x.setValue(stage.getX());
            y.setValue(stage.getY());
            width.setValue(stage.getWidth());
            height.setValue(stage.getHeight());
        } else {
            VenueArea area = plan.getAreas().get(index);
            name.setText(area.getName());
            x.setValue(area.getX());
            y.setValue(area.getY());
            width.setValue(area.getWidth());
            height.setValue(area.getHeight());
            rows.setValue(area.getRows());
            columns.setValue(area.getColumns());
            shape.setSelectedItem(area.getShape());
            // Visit each relevant item using an ordinary loop.
            for (int i = 0; i < type.getItemCount(); i++) {
                // Validate this condition before continuing with the operation.
                if (type.getItemAt(i).getCode().equals(area.getTypeCode())) {
                    type.setSelectedIndex(i);
                    break;
                }
            }
        }
        name.setEnabled(!locked && index >= 0);
        type.setEnabled(!locked && index >= 0);
        shape.setEnabled(!locked && index >= 0);
        rows.setEnabled(!locked && index >= 0);
        columns.setEnabled(!locked && index >= 0);
    }

    public VenuePlan getPlan() {
        if (!locked) {
            apply();
        }
        return plan;
    }

    private void apply() {
        // Validate this condition before continuing with the operation.
        if (locked) {
            return;
        }
        int index = editingIndex;
        // Validate this condition before continuing with the operation.
        if (index < -1) {
            return;
        }
        // Validate this condition before continuing with the operation.
        if (index == -1) {
            Stage stage = new Stage(number(x), number(y), number(width), number(height));
            plan = new VenuePlan(stage, plan.getAreas(), plan.getTicketTypes());
        } else {
            List<VenueArea> areas = plan.getAreas();
            VenueArea old = areas.get(index);
            Set<String> blocked = new HashSet<String>();
            // Keep only blocked cells still inside the resized seat grid.
            for (int r = 0; r < number(rows); r++) {
                for (int c = 0; c < number(columns); c++) {
                    // Validate this condition before continuing with the operation.
                    if (old.isBlocked(r, c)) {
                        blocked.add(r + ":" + c);
                    }
                }
            }
            TicketType offer = (TicketType) type.getSelectedItem();
            areas.set(index, new VenueArea(old.getCode(), name.getText(), offer.getCode(), number(x), number(y), number(width), number(height),
                    number(rows), number(columns), old.getRowOffset(), (String) shape.getSelectedItem(), blocked));
            plan = new VenuePlan(plan.getStage(), areas, plan.getTicketTypes());
        }
        refresh(index + 1);
    }

    private void move(int index, int newX, int newY) {
        try {
            list.setSelectedIndex(index + 1);
            if (editingIndex != index) {
                return;
            }
            x.setValue(Math.max(0, Math.min(1000, newX)));
            y.setValue(Math.max(0, Math.min(700, newY)));
            apply();
        } catch (RuntimeException exception) {
            load();
            JOptionPane.showMessageDialog(this, exception.getMessage(), "Move rejected", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void manageTypes() {
        // Validate this condition before continuing with the operation.
        if (!locked) {
            apply();
        }
        Set<String> assigned = new HashSet<String>();
        // Visit each relevant item using an ordinary loop.
        for (VenueArea area : plan.getAreas()) {
            assigned.add(area.getTypeCode());
        }
        TicketTypePanel editor = new TicketTypePanel(plan.getTicketTypes(), assigned);
        editor.setPreferredSize(new Dimension(650, 440));
        while (JOptionPane.showConfirmDialog(this, editor, "Event ticket types", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION) {
            try {
                plan = new VenuePlan(plan.getStage(), plan.getAreas(), editor.getTypes());
                refresh(list.getSelectedIndex());
                return;
            } catch (RuntimeException exception) {
                JOptionPane.showMessageDialog(this, exception.getMessage());
            }
        }
    }

    private void addSection() {
        apply();
        // Validate this condition before continuing with the operation.
        if (plan.getAreas().size() >= 12) {
            throw new IllegalArgumentException("Maximum 12 sections.");
        }
        Set<String> codes = new HashSet<String>();
        int offset = 0;
        // Visit each relevant item using an ordinary loop.
        for (VenueArea area : plan.getAreas()) {
            codes.add(area.getCode());
            offset = Math.max(offset, area.getRowOffset() + 10);
        }
        int next = 1;
        while (codes.contains("S" + next)) {
            next++;
        }
        // Find a free initial rectangle; all later moves must pass the same overlap rules.
        for (int py = 10; py <= 640; py += 10) {
            // Visit each relevant item using an ordinary loop.
            for (int px = 10; px <= 900; px += 10) {
                VenueArea area = new VenueArea("S" + next, "Section " + next, plan.getTicketTypes().get(0).getCode(), px, py, 90, 50, 4, 5, offset, "RECTANGLE", new HashSet<String>());
                List<VenueArea> areas = plan.getAreas();
                areas.add(area);
                try {
                    plan = new VenuePlan(plan.getStage(), areas, plan.getTicketTypes());
                    refresh(areas.size());
                    return;
                } catch (IllegalArgumentException overlap) {
                    /* Try the next position. */ }
            }
        }
        // Reject invalid input with a message the form can display.
        throw new IllegalArgumentException("No free space. Resize or move existing sections first.");
    }

    private void blockedSeats() {
        apply();
        int index = list.getSelectedIndex() - 1;
        // Validate this condition before continuing with the operation.
        if (index < 0) {
            throw new IllegalArgumentException("Select a section first.");
        }
        VenueArea area = plan.getAreas().get(index);
        final Set<String> blocked = area.getBlocked();
        JPanel grid = new JPanel(new GridLayout(area.getRows(), area.getColumns(), 5, 5));
        // Visit each relevant item using an ordinary loop.
        for (int r = 0; r < area.getRows(); r++) {
            for (int c = 0; c < area.getColumns(); c++) {
                final String position = r + ":" + c;
                final JButton seat = new JButton("" + (char) ('A' + r) + (c + 1));
                seat.setBackground(Color.decode(plan.getType(area.getTypeCode()).getColor()));
                seat.setForeground(VenueCanvas.contrast(seat.getBackground()));
                // Validate this condition before continuing with the operation.
                if (blocked.contains(position)) {
                    seat.setBackground(Color.LIGHT_GRAY);
                }
                seat.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        // Validate this condition before continuing with the operation.
                        if (blocked.remove(position)) {
                            seat.setBackground(Color.decode(plan.getType(area.getTypeCode()).getColor()));
                        } else {
                            blocked.add(position);
                            seat.setBackground(Color.LIGHT_GRAY);
                        }
                        seat.setForeground(VenueCanvas.contrast(seat.getBackground()));
                    }
                });
                grid.add(seat);
            }
        }
        // Validate this condition before continuing with the operation.
        if (JOptionPane.showConfirmDialog(this, grid, "Click cells to toggle aisles / blocked spaces", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            List<VenueArea> areas = plan.getAreas();
            areas.set(index, new VenueArea(area.getCode(), area.getName(), area.getTypeCode(), area.getX(), area.getY(), area.getWidth(), area.getHeight(), area.getRows(), area.getColumns(), area.getRowOffset(), area.getShape(), blocked));
            plan = new VenuePlan(plan.getStage(), areas, plan.getTicketTypes());
            refresh(index + 1);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            String command = event.getActionCommand();
            // Validate this condition before continuing with the operation.
            if ("Ticket types".equals(command)) {
                manageTypes();
                return;
            }
            // Validate this condition before continuing with the operation.
            if (locked) {
                throw new IllegalArgumentException("Purchased tickets protect this layout.");
            }
            // Validate this condition before continuing with the operation.
            if ("Apply section".equals(command)) {
                apply();
            } else if ("Reset field edits".equals(command)) {
                load();
            } else if ("Add section".equals(command)) {
                addSection();
            } else if ("Remove section".equals(command)) {
                int index = list.getSelectedIndex() - 1;
                // Validate this condition before continuing with the operation.
                if (index < 0 || plan.getAreas().size() == 1) {
                    throw new IllegalArgumentException("Keep the stage and at least one section.");
                }
                if (JOptionPane.showConfirmDialog(this, "Remove " + plan.getAreas().get(index).getName() + " and its seats from this draft?", "Remove section", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
                    return;
                }
                List<VenueArea> areas = plan.getAreas();
                areas.remove(index);
                plan = new VenuePlan(plan.getStage(), areas, plan.getTicketTypes());
                refresh(1);
            } else if ("Aisles / blocked seats".equals(command)) {
                blockedSeats();
            } else if ("Use template".equals(command) && JOptionPane.showConfirmDialog(this, "Replace the current draft venue AND its ticket types with this template?", "Use template", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                plan = VenuePlan.template((String) template.getSelectedItem(), templatePrice());
                refresh(1);
            }
        } catch (RuntimeException exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage(), "Venue editor", JOptionPane.WARNING_MESSAGE);
        }
    }
}
