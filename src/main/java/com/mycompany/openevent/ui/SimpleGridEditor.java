package com.mycompany.openevent.ui;

// Domain objects keep validation and pricing separate from the Swing controls.
import com.mycompany.openevent.model.Seat;
import com.mycompany.openevent.model.TicketType;
import com.mycompany.openevent.model.VenueArea;
import com.mycompany.openevent.model.VenueLayout;
import com.mycompany.openevent.model.VenuePlan;
// Use ordinary Swing controls and conventional listeners for beginner-readable code.
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/**
 * Original seat-grid workflow, with custom ticket offers and protected bookings
 * retained.
 */
public class SimpleGridEditor extends JPanel implements ActionListener {

    // Keep the loaded layout so booked seats retain their original identities and labels.
    private final VenueLayout original;
    private final boolean locked;
    private VenuePlan plan;
    private List<TicketType> types = new ArrayList<TicketType>();
    // A missing coordinate represents an aisle; a stored code represents a sellable seat.
    private final Map<String, String> cells = new HashMap<String, String>();
    private final JPanel grid = new JPanel();
    private final JComboBox<String> sections = new JComboBox<String>();
    private final JComboBox<String> paint = new JComboBox<String>();
    private final JTextField sectionName = new JTextField(12);
    private final JSpinner rows;
    private final JSpinner columns;
    private final JLabel help = new JLabel();
    private int gridRows = 8;
    private int gridColumns = 12;
    private int stageRow = 0;
    private int stageColumn = 3;
    private int stageWidth = 6;
    private int currentSection = -1;
    private boolean loading;
    // A new untouched grid follows the main starting-price field until offers are customized.
    private JTextField startingPriceField;
    private boolean customPrices;

    public void setStartingPriceField(JTextField field) {
        startingPriceField = field;
    }

    private void syncStartingPrice() {
        if (original != null || customPrices || startingPriceField == null) {
            return;
        }
        BigDecimal price = new BigDecimal(startingPriceField.getText().trim());
        List<TicketType> updated = new ArrayList<TicketType>();
        for (TicketType type : types) {
            BigDecimal amount = price;
            if ("VIP".equals(type.getCode())) {
                amount = price.multiply(new BigDecimal("1.50")).setScale(2, java.math.RoundingMode.HALF_UP);
            }
            updated.add(new TicketType(type.getCode(), type.getName(), amount, type.getColor(), type.hasEarlyBird()));
        }
        types = updated;
    }

    // The same compact editor opens both old grids and already saved section-based venues.
    public SimpleGridEditor(VenueLayout layout, boolean protectSeats, BigDecimal startingPrice) {
        super(new BorderLayout(8, 8));
        original = layout;
        locked = protectSeats;
        if (layout != null) {
            plan = layout.getPlan();
            types = layout.getTicketTypes();
            gridRows = layout.getRows();
            gridColumns = layout.getColumns();
            stageRow = layout.getStageRow();
            stageColumn = layout.getStageColumn();
            stageWidth = layout.getStageWidth();
            for (Seat seat : layout.getSeats()) {
                cells.put(key(seat.getRow(), seat.getColumn()), seat.getTypeCode());
            }
        }
        // Older events without custom metadata retain their original Regular/VIP price rules.
        if (types.isEmpty()) {
            Set<String> found = new HashSet<String>();
            if (layout != null) {
                for (Seat seat : layout.getSeats()) {
                    if (found.add(seat.getTypeCode())) {
                        BigDecimal price = startingPrice;
                        boolean early = true;
                        if ("VIP".equals(seat.getTypeCode())) {
                            price = startingPrice.multiply(new BigDecimal("1.50")).setScale(2, java.math.RoundingMode.HALF_UP);
                            early = false;
                        }
                        String name = DisplayText.category(seat.getTypeCode());
                        types.add(new TicketType(seat.getTypeCode(), name, price, seat.getColor(), early));
                    }
                }
            }
            if (types.isEmpty()) {
                types.add(new TicketType("REGULAR", "Regular", startingPrice, "#2AA89B", true));
                types.add(new TicketType("VIP", "VIP", startingPrice.multiply(new BigDecimal("1.50")).setScale(2, java.math.RoundingMode.HALF_UP), "#8B5CF6", false));
            }
        }
        // A fresh event starts as the first-version grid, rather than a multi-section template.
        if (layout == null) {
            for (int r = 0; r < gridRows; r++) {
                for (int c = 0; c < gridColumns; c++) {
                    if (!isStage(r, c)) {
                        String code = "REGULAR";
                        if (r < 3) {
                            code = "VIP";
                        }
                        cells.put(key(r, c), code);
                    }
                }
            }
        }
        int minimum = 4;
        int maximumRows = 14;
        int maximumColumns = 18;
        if (plan != null) {
            minimum = 1;
            maximumRows = 10;
            maximumColumns = 10;
        }
        int initialRows = gridRows;
        int initialColumns = gridColumns;
        if (plan != null) {
            currentSection = 0;
            initialRows = plan.getAreas().get(0).getRows();
            initialColumns = plan.getAreas().get(0).getColumns();
        }
        rows = new JSpinner(new SpinnerNumberModel(initialRows, minimum, maximumRows, 1));
        columns = new JSpinner(new SpinnerNumberModel(initialColumns, minimum, maximumColumns, 1));
        rows.setPreferredSize(new Dimension(65, 30));
        columns.setPreferredSize(new Dimension(65, 30));
        rows.getAccessibleContext().setAccessibleName("Grid rows");
        columns.getAccessibleContext().setAccessibleName("Seats per row");
        paint.getAccessibleContext().setAccessibleName("Grid ticket type");
        sections.getAccessibleContext().setAccessibleName("Saved venue section");
        sectionName.getAccessibleContext().setAccessibleName("Section name");
        // Only two short toolbar rows are visible; ticket details stay in one dialog.
        JPanel toolbar = new JPanel(new GridLayout(0, 1, 4, 4));
        if (plan != null) {
            JPanel choice = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));
            for (VenueArea area : plan.getAreas()) {
                sections.addItem(area.getName());
            }
            choice.add(new JLabel("Section"));
            choice.add(sections);
            choice.add(new JLabel("Name"));
            choice.add(sectionName);
            choice.add(button("Color", !locked));
            choice.add(button("Shape", !locked));
            toolbar.add(choice);
            sections.addActionListener(this);
        }
        JPanel size = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));
        size.add(new JLabel("Rows"));
        size.add(rows);
        size.add(new JLabel("Seats per row"));
        size.add(columns);
        size.add(button("Update grid", !locked));
        if (plan == null) {
            size.add(button("Stage", !locked));
        }
        size.add(button("Ticket types", true));
        toolbar.add(size);
        JPanel tools = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));
        String caption = "Paint seats";
        if (plan != null) {
            caption = "Section ticket type";
        }
        tools.add(new JLabel(caption));
        tools.add(paint);
        tools.add(help);
        toolbar.add(tools);
        add(toolbar, BorderLayout.NORTH);
        grid.setBackground(Color.WHITE);
        grid.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        add(new JScrollPane(grid), BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        // Geometry is disabled for bookings, while future names/prices remain editable.
        rows.setEnabled(!locked);
        columns.setEnabled(!locked);
        sectionName.setEnabled(!locked);
        paint.setEnabled(!locked);
        if (locked) {
            help.setText("Booked seats are locked. Ticket names and future prices can still change.");
        } else if (plan != null) {
            help.setText("Click a seat to make an aisle. Update grid applies section changes.");
        } else {
            help.setText("Choose a type or Aisle, then click seats. Save the event when done.");
        }
        refreshTypes(null);
        loadSection();
        drawGrid();
    }

    // A small helper gives every button a conventional named action.
    private JButton button(String text, boolean enabled) {
        JButton button = Theme.button(text);
        button.setEnabled(enabled);
        button.addActionListener(this);
        return button;
    }

    // Coordinates are stable map keys, independent from the display name of a ticket.
    private String key(int row, int column) {
        return row + ":" + column;
    }

    // The stage occupies one row, as in the original grid editor.
    private boolean isStage(int row, int column) {
        return row == stageRow && column >= stageColumn && column < stageColumn + stageWidth;
    }

    // Reject unfinished spinner text rather than silently saving its previous number.
    private int number(JSpinner spinner) {
        try {
            spinner.commitEdit();
        } catch (java.text.ParseException exception) {
            throw new IllegalArgumentException("Enter a whole number.");
        }
        return ((Number) spinner.getValue()).intValue();
    }

    // Look up the immutable offer by its stable database code.
    private TicketType offer(String code) {
        for (TicketType type : types) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Choose a valid ticket type.");
    }

    // Refill names after a rename; stored grid cells keep their stable offer codes.
    private void refreshTypes(String selectedCode) {
        loading = true;
        paint.removeAllItems();
        for (TicketType type : types) {
            paint.addItem(type.getName());
        }
        if (plan == null) {
            paint.addItem("Aisle / no seat");
        }
        int selected = 0;
        for (int i = 0; i < types.size(); i++) {
            if (types.get(i).getCode().equals(selectedCode)) {
                selected = i;
            }
        }
        paint.setSelectedIndex(selected);
        loading = false;
    }

    // Existing section geometry stays unchanged; only its small seat grid is edited here.
    private void loadSection() {
        if (plan == null) {
            return;
        }
        VenueArea area = plan.getAreas().get(currentSection);
        sectionName.setText(area.getName());
        rows.setValue(area.getRows());
        columns.setValue(area.getColumns());
        refreshTypes(area.getTypeCode());
    }

    // Apply only the visible section's seat count/name/type, retaining its saved physical position.
    private void applyGrid() {
        if (locked) {
            return;
        }
        int newRows = number(rows);
        int newColumns = number(columns);
        if (plan != null) {
            VenueArea old = plan.getAreas().get(currentSection);
            Set<String> blocked = new HashSet<String>();
            for (int r = 0; r < newRows; r++) {
                for (int c = 0; c < newColumns; c++) {
                    if (old.isBlocked(r, c)) {
                        blocked.add(key(r, c));
                    }
                }
            }
            TicketType type = types.get(paint.getSelectedIndex());
            List<VenueArea> areas = plan.getAreas();
            areas.set(currentSection, new VenueArea(old.getCode(), sectionName.getText(), type.getCode(),
                    old.getX(), old.getY(), old.getWidth(), old.getHeight(), newRows, newColumns,
                    old.getRowOffset(), old.getShape(), blocked, old.getColor()));
            plan = new VenuePlan(plan.getStage(), areas, types);
            loading = true;
            sections.insertItemAt(areas.get(currentSection).getName(), currentSection);
            sections.removeItemAt(currentSection + 1);
            sections.setSelectedIndex(currentSection);
            loading = false;
        } else {
            // Keep the stage inside a resized grid, without requiring extra setup steps.
            stageRow = Math.min(stageRow, newRows - 1);
            stageWidth = Math.min(stageWidth, newColumns);
            stageColumn = Math.min(stageColumn, newColumns - stageWidth);
            Map<String, String> resized = new HashMap<String, String>();
            for (int r = 0; r < newRows; r++) {
                for (int c = 0; c < newColumns; c++) {
                    String code = cells.get(key(r, c));
                    if (r >= gridRows || c >= gridColumns) {
                        code = types.get(0).getCode();
                    }
                    if (code != null && !isStage(r, c)) {
                        resized.put(key(r, c), code);
                    }
                }
            }
            cells.clear();
            cells.putAll(resized);
            gridRows = newRows;
            gridColumns = newColumns;
        }
        drawGrid();
    }

    // Each seat is a normal button. Aisles remain clickable so the Host can restore them.
    private void drawGrid() {
        grid.removeAll();
        int countRows = gridRows;
        int countColumns = gridColumns;
        VenueArea area = null;
        if (plan != null) {
            area = plan.getAreas().get(currentSection);
            countRows = area.getRows();
            countColumns = area.getColumns();
        }
        grid.setLayout(new GridLayout(countRows, countColumns, 4, 4));
        grid.setPreferredSize(new Dimension(Math.max(600, countColumns * 48), Math.max(290, countRows * 34)));
        for (int r = 0; r < countRows; r++) {
            for (int c = 0; c < countColumns; c++) {
                if (plan == null && isStage(r, c)) {
                    JLabel stage = new JLabel("STAGE", JLabel.CENTER);
                    stage.setOpaque(true);
                    stage.setBackground(Theme.INK);
                    stage.setForeground(Color.WHITE);
                    grid.add(stage);
                } else {
                    String code = cells.get(key(r, c));
                    String label = "" + (char) ('A' + r) + (c + 1);
                    if (area != null) {
                        code = area.getTypeCode();
                        if (area.isBlocked(r, c)) {
                            code = null;
                        }
                        label = area.getCode() + "-" + label;
                    }
                    JButton seat = new JButton(label);
                    seat.setActionCommand("seat:" + r + ":" + c);
                    seat.addActionListener(this);
                    seat.setEnabled(!locked);
                    if (code == null) {
                        seat.setText("—");
                        seat.setBackground(new Color(235, 235, 240));
                        seat.setToolTipText(label + ": aisle / no seat");
                    } else {
                        TicketType type = offer(code);
                        seat.setBackground(Color.decode(type.getColor()));
                        seat.setForeground(VenueCanvas.contrast(seat.getBackground()));
                        seat.setToolTipText(label + ": " + type.getName() + " · PHP " + type.getPrice().toPlainString());
                    }
                    grid.add(seat);
                }
            }
        }
        grid.revalidate();
        grid.repaint();
    }

    // Paint the selected offer directly, or toggle an aisle within an existing saved section.
    private void clickSeat(int row, int column) {
        if (locked) {
            return;
        }
        if (plan == null) {
            if (paint.getSelectedIndex() == types.size()) {
                cells.remove(key(row, column));
            } else {
                cells.put(key(row, column), types.get(paint.getSelectedIndex()).getCode());
            }
        } else {
            applyGrid();
            VenueArea area = plan.getAreas().get(currentSection);
            Set<String> blocked = area.getBlocked();
            if (!blocked.remove(key(row, column))) {
                blocked.add(key(row, column));
            }
            List<VenueArea> areas = plan.getAreas();
            areas.set(currentSection, new VenueArea(area.getCode(), area.getName(), area.getTypeCode(),
                    area.getX(), area.getY(), area.getWidth(), area.getHeight(), area.getRows(), area.getColumns(),
                    area.getRowOffset(), area.getShape(), blocked, area.getColor()));
            plan = new VenuePlan(plan.getStage(), areas, types);
        }
        drawGrid();
    }

    // Open the section requested by an overview click; no coordinate fields are exposed.
    public int getSelectedSection() {
        return currentSection;
    }

    public void showSection(int index) {
        if (plan == null || index < 0 || index >= plan.getAreas().size()) {
            return;
        }
        loading = true;
        sections.setSelectedIndex(index);
        loading = false;
        currentSection = index;
        loadSection();
        drawGrid();
    }

    // Keep the first-version stage controls in one small optional dialog.
    private void stageSettings() {
        JSpinner row = new JSpinner(new SpinnerNumberModel(stageRow + 1, 1, gridRows, 1));
        JSpinner column = new JSpinner(new SpinnerNumberModel(stageColumn + 1, 1, gridColumns, 1));
        JSpinner width = new JSpinner(new SpinnerNumberModel(stageWidth, 1, gridColumns, 1));
        JPanel fields = new JPanel(new GridLayout(0, 2, 6, 6));
        fields.add(new JLabel("Stage row"));
        fields.add(row);
        fields.add(new JLabel("First seat column"));
        fields.add(column);
        fields.add(new JLabel("Stage width (cells)"));
        fields.add(width);
        while (JOptionPane.showConfirmDialog(this, fields, "Stage", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION) {
            int nextRow = number(row) - 1;
            int nextColumn = number(column) - 1;
            int nextWidth = number(width);
            if (nextColumn + nextWidth > gridColumns) {
                JOptionPane.showMessageDialog(this, "Keep the stage inside the grid.");
                continue;
            }
            // Remove seats underneath the stage. Old stage cells remain aisles until painted.
            stageRow = nextRow;
            stageColumn = nextColumn;
            stageWidth = nextWidth;
            for (int c = stageColumn; c < stageColumn + stageWidth; c++) {
                cells.remove(key(stageRow, c));
            }
            drawGrid();
            return;
        }
    }

    // Renaming offers never rewrites the snapshot on an already purchased ticket.
    private void editTypes() {
        syncStartingPrice();
        applyGrid();
        Set<String> assigned = new HashSet<String>();
        if (plan != null) {
            for (VenueArea area : plan.getAreas()) {
                assigned.add(area.getTypeCode());
            }
        } else {
            assigned.addAll(cells.values());
        }
        TicketTypePanel panel = new TicketTypePanel(types, assigned);
        panel.setPreferredSize(new Dimension(600, 410));
        while (JOptionPane.showConfirmDialog(this, panel, "Ticket types", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION) {
            try {
                List<TicketType> updated = panel.getTypes();
                if (plan != null) {
                    plan = new VenuePlan(plan.getStage(), plan.getAreas(), updated);
                }
                types = updated;
                customPrices = true;
                refreshTypes(null);
                loadSection();
                drawGrid();
                return;
            } catch (IllegalArgumentException exception) {
                JOptionPane.showMessageDialog(this, exception.getMessage());
            }
        }
    }

    // Create the validated domain object only when the parent event form is saved.
    public VenueLayout getVenueLayout() {
        syncStartingPrice();
        applyGrid();
        if (plan != null) {
            if (locked) {
                return new VenueLayout(plan, original.getSeats());
            }
            return new VenueLayout(plan);
        }
        List<Seat> seats = new ArrayList<Seat>();
        if (locked) {
            seats = original.getSeats();
        } else {
            for (int r = 0; r < gridRows; r++) {
                for (int c = 0; c < gridColumns; c++) {
                    String code = cells.get(key(r, c));
                    if (code != null && !isStage(r, c)) {
                        seats.add(new Seat(0, r, c, "" + (char) ('A' + r) + (c + 1), offer(code), "AVAILABLE", null));
                    }
                }
            }
        }
        return new VenueLayout(gridRows, gridColumns, stageRow, stageColumn, stageWidth, seats, types);
    }

    // One readable handler routes the few editor controls to their named operations.
    @Override
    public void actionPerformed(ActionEvent event) {
        if (loading) {
            return;
        }
        try {
            if (event.getSource() == sections) {
                int requested = sections.getSelectedIndex();
                if (requested < 0 || requested == currentSection) {
                    return;
                }
                try {
                    applyGrid();
                } catch (RuntimeException exception) {
                    loading = true;
                    sections.setSelectedIndex(currentSection);
                    loading = false;
                    throw exception;
                }
                currentSection = requested;
                loadSection();
                drawGrid();
                return;
            }
            String command = event.getActionCommand();
            if ("Ticket types".equals(command)) {
                editTypes();
                return;
            }
            if (locked) {
                return;
            }
            if ("Color".equals(command)) {
                applyGrid();
                VenueArea area = plan.getAreas().get(currentSection);
                String current = area.getColor();
                if (current == null) {
                    current = offer(area.getTypeCode()).getColor();
                }
                Color chosen = javax.swing.JColorChooser.showDialog(this, "Section color", Color.decode(current));
                if (chosen != null) {
                    String hex = String.format("#%02X%02X%02X", chosen.getRed(), chosen.getGreen(), chosen.getBlue());
                    List<VenueArea> areas = plan.getAreas();
                    areas.set(currentSection, new VenueArea(area.getCode(), area.getName(), area.getTypeCode(), area.getX(), area.getY(), area.getWidth(), area.getHeight(), area.getRows(), area.getColumns(), area.getRowOffset(), area.getShape(), area.getBlocked(), hex));
                    plan = new VenuePlan(plan.getStage(), areas, types);
                }
            } else if ("Shape".equals(command)) {
                applyGrid();
                VenueArea area = plan.getAreas().get(currentSection);
                Object chosen = JOptionPane.showInputDialog(this, "Section outline", "Shape", JOptionPane.PLAIN_MESSAGE, null, new String[]{"Rectangle", "Trapezoid"}, "Rectangle");
                if (chosen != null) {
                    String shape = "RECTANGLE";
                    if ("Trapezoid".equals(chosen)) {
                        shape = "TRAPEZOID";
                    }
                    List<VenueArea> areas = plan.getAreas();
                    areas.set(currentSection, new VenueArea(area.getCode(), area.getName(), area.getTypeCode(), area.getX(), area.getY(), area.getWidth(), area.getHeight(), area.getRows(), area.getColumns(), area.getRowOffset(), shape, area.getBlocked(), area.getColor()));
                    plan = new VenuePlan(plan.getStage(), areas, types);
                }
            } else if ("Update grid".equals(command)) {
                applyGrid();
            } else if ("Stage".equals(command)) {
                stageSettings();
            } else if (command.startsWith("seat:")) {
                String[] parts = command.split(":");
                clickSeat(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            }
        } catch (RuntimeException exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage(), "Check grid", JOptionPane.WARNING_MESSAGE);
        }
    }
}
