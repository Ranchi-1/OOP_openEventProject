// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
package com.mycompany.openevent.ui;
// Imports Seat so this class can use that type by its short name.
import com.mycompany.openevent.model.Seat;
// Imports VenueLayout so this class can use that type by its short name.
import com.mycompany.openevent.model.VenueLayout;
// Imports BorderFactory so this class can use that type by its short name.
import javax.swing.BorderFactory;
// Imports JButton so this class can use that type by its short name.
import javax.swing.JButton;
// Imports JLabel so this class can use that type by its short name.
import javax.swing.JLabel;
// Imports JPanel so this class can use that type by its short name.
import javax.swing.JPanel;
// Imports SwingConstants so this class can use that type by its short name.
import javax.swing.SwingConstants;
// Imports Color so this class can use that type by its short name.
import java.awt.Color;
// Imports Font so this class can use that type by its short name.
import java.awt.Font;
// Imports GridLayout so this class can use that type by its short name.
import java.awt.GridLayout;
// Imports Insets so this class can use that type by its short name.
import java.awt.Insets;
// Imports ActionEvent so this class can use that type by its short name.
import java.awt.event.ActionEvent;
// Imports ActionListener so this class can use that type by its short name.
import java.awt.event.ActionListener;
// Imports HashMap so this class can use that type by its short name.
import java.util.HashMap;
// Imports Map so this class can use that type by its short name.
import java.util.Map;

/** Displays saved seats; clicking a button only selects a seat, not a booking. */
// Defines a class that inherits the fields and behavior of its parent type.
public class SeatGrid extends JPanel {
    /** A normal interface tells the window which seat was clicked. */
    // Defines a normal callback contract that another class implements.
    public interface SeatSelectionListener {
        void seatSelected(Seat seat);
    }

    // Stores buttons.
    private final Map<Long, JButton> buttons = new HashMap<Long, JButton>();
    // Stores listener.
    private final SeatSelectionListener listener;
    // Stores selected.
    private Seat selected;

    // Constructs a SeatGrid object and initializes or validates its starting state.
    public SeatGrid(java.util.List<Seat> seats,int rows,int columns,int rowOffset,SeatSelectionListener listener) {
        super(new GridLayout(rows,columns,7,7));
        this.listener=listener;
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(12,12,12,12));
        Map<String,Seat> positions=new HashMap<String,Seat>();
        for(Seat seat:seats) { positions.put(seat.getRow()+":"+seat.getColumn(),seat); }
        for(int r=0;r<rows;r++) {
            for(int c=0;c<columns;c++) {
                Seat seat=positions.get((rowOffset+r)+":"+c);
                if(seat==null) { add(new JLabel()); } else { addSeatButton(seat); }
            }
        }
    }
    public SeatGrid(VenueLayout layout, SeatSelectionListener listener) {
        // Passes the shared initialization values to the parent constructor.
        super(new GridLayout(layout.getRows(), layout.getColumns(), 7, 7));
        // Stores the constructor argument in this object's private listener field.
        this.listener = listener;
        // Calls this operation to carry out the named step with the supplied arguments.
        setBackground(Color.WHITE);
        // Calls this operation to carry out the named step with the supplied arguments.
        setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 18));
        Map<String, Seat> positions = new HashMap<String, Seat>();
        // Visits each object in the collection using an ordinary enhanced for loop.
        for (Seat seat : layout.getSeats()) {
            // Stores this value under its key so it can be found again later.
            positions.put(seat.getRow() + ":" + seat.getColumn(), seat);
        }
        // Repeats this block with an index so each relevant position or parameter is processed.
        for (int row = 0; row < layout.getRows(); row++) {
            // Repeats this block with an index so each relevant position or parameter is processed.
            for (int column = 0; column < layout.getColumns(); column++) {
                // Continues into this block only when the condition below is true.
                if (layout.isStage(row, column)) {
                    // Prepares the local text value used in the following steps.
                    String text = "";
                    // Continues into this block only when the condition below is true.
                    if (column == layout.getStageColumn() + layout.getStageWidth() / 2) {
                        // Updates this working value before the next step.
                        text = "STAGE";
                    }
                    // Prepares the local stage value used in the following steps.
                    JLabel stage = new JLabel(text, SwingConstants.CENTER);
                    // Controls whether the component paints its own background.
                    stage.setOpaque(true);
                    // Sets this component color; the gradient start/end colors form the purple theme.
                    stage.setBackground(Theme.INK);
                    // Sets the text or drawing color for this component.
                    stage.setForeground(Color.WHITE);
                    // Sets the font family, style and point size used to draw this component.
                    stage.setFont(new Font("Segoe UI", Font.BOLD, 10));
                    // Calls this operation to carry out the named step with the supplied arguments.
                    add(stage);
                }
                // Handles the remaining case after the earlier condition was false.
                else {
                    // Prepares the local seat value used in the following steps.
                    Seat seat = positions.get(row + ":" + column);
                    // Draws an aisle because this coordinate has no saved seat.
                    if (seat == null) {
                        // Calls this operation to carry out the named step with the supplied arguments.
                        add(new JLabel());
                    }
                    // Handles the remaining case after the earlier condition was false.
                    else {
                        // Calls this operation to carry out the named step with the supplied arguments.
                        addSeatButton(seat);
                    }
                }
            }
        }
    }

    // Creates one Customer seat button and attaches a conventional ActionListener.
    private void addSeatButton(final Seat seat) {
        // Prepares the local button value used in the following steps.
        final JButton button = new JButton();
        // Allows selection only for seats whose status is AVAILABLE.
        if (seat.isAvailable()) {
            // Displays this text in the named Swing component.
            button.setText(seat.getLabel());
            // Sets this component color; the gradient start/end colors form the purple theme.
            button.setBackground(Color.decode(seat.getColor()));
            // Sets the text or drawing color for this component.
            button.setForeground(VenueCanvas.contrast(Color.decode(seat.getColor())));
        }
        // Handles the remaining case after the earlier condition was false.
        else {
            // Displays this text in the named Swing component.
            button.setText("×");
            // Sets this component color; the gradient start/end colors form the purple theme.
            button.setBackground(new Color(223, 219, 230));
            // Sets the text or drawing color for this component.
            button.setForeground(Theme.MUTED);
        }
        // Sets the font family, style and point size used to draw this component.
        button.setFont(new Font("Segoe UI", Font.BOLD, 11));
        // Calls this operation to carry out the named step with the supplied arguments.
        button.setMargin(new Insets(0, 0, 0, 0));
        // Calls this operation to carry out the named step with the supplied arguments.
        button.setFocusPainted(false);
        // Controls whether the component paints its own background.
        button.setOpaque(true);
        // Sets the visible outline or empty padding around this component.
        button.setBorder(BorderFactory.createEmptyBorder());
        // Enables or disables interaction according to the current selection or permissions.
        button.setEnabled(seat.isAvailable());
        // Shows this explanation when the pointer rests over the component.
        button.setToolTipText(seat.getLabel() + " · " + seat.getCategory() + " · " + seat.getStatus());
        // Stores this value under its key so it can be found again later.
        buttons.put(seat.getId(), button);
        // Registers the standard listener that runs when this control is activated.
        button.addActionListener(new ActionListener() {
            @Override
            // Receives button/field events and routes each command to a clearly named handler.
            public void actionPerformed(ActionEvent event) {
                // Calls this operation to carry out the named step with the supplied arguments.
                selectSeat(seat, button);
            }
        });
        // Calls this operation to carry out the named step with the supplied arguments.
        add(button);
    }

    // Restores the old seat color, highlights the new seat, and notifies the window.
    private void selectSeat(Seat seat, JButton button) {
        // Restores the previous selected seat before highlighting the new selection.
        if (selected != null) {
            // Prepares the local old button value used in the following steps.
            JButton oldButton = buttons.get(selected.getId());
            // Sets this component color; the gradient start/end colors form the purple theme.
            oldButton.setBackground(Color.decode(selected.getColor()));
            oldButton.setForeground(VenueCanvas.contrast(Color.decode(selected.getColor())));
            // Sets the visible outline or empty padding around this component.
            oldButton.setBorder(BorderFactory.createEmptyBorder());
        }
        // Updates this working value before the next step.
        selected = seat;
        // Sets this component color; the gradient start/end colors form the purple theme.
        button.setBackground(Theme.INK);
        button.setForeground(Color.WHITE);
        // Sets the visible outline or empty padding around this component.
        button.setBorder(BorderFactory.createLineBorder(Theme.PURPLE, 3));
        // Calls this operation to carry out the named step with the supplied arguments.
        listener.seatSelected(seat);
    }
}
