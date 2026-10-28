// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
package com.mycompany.openevent.model;
// Imports ArrayList so this class can use that type by its short name.
import java.util.ArrayList;
// Imports HashSet so this class can use that type by its short name.
import java.util.HashSet;
// Imports List so this class can use that type by its short name.
import java.util.List;
// Imports Set so this class can use that type by its short name.
import java.util.Set;
/** A venue owns its grid dimensions, stage coordinates and a list of seats. */
// Defines the VenueLayout class and keeps its related data and operations together.
public class VenueLayout {
    // Stores rows.
    private final int rows;
    // Stores columns.
    private final int columns;
    // Stores stage row.
    private final int stageRow;
    // Stores stage column.
    private final int stageColumn;
    // Stores stage width.
    private final int stageWidth;
    // Stores seats.
    private final List<Seat> seats;
    private VenuePlan plan;
    // A grid may keep custom offers even before seats have been assigned to them.
    private List<TicketType> ticketTypes = new ArrayList<TicketType>();

    // The original constructor still checks stage bounds and unique seat positions.
    public VenueLayout(int rows, int columns, int stageRow, int stageColumn,
            int stageWidth, List<Seat> seats, List<TicketType> types) {
        this(rows, columns, stageRow, stageColumn, stageWidth, seats);
        if (types.size() > 20) { throw new IllegalArgumentException("Use at most 20 ticket types."); }
        Set<String> codes = new HashSet<String>();
        Set<String> names = new HashSet<String>();
        for (TicketType type : types) {
            if (!codes.add(type.getCode()) || !names.add(type.getName().toLowerCase(java.util.Locale.ROOT))) {
                throw new IllegalArgumentException("Ticket names and codes must be unique.");
            }
        }
        if (!types.isEmpty()) {
            for (Seat seat : seats) {
                if (!codes.contains(seat.getTypeCode())) { throw new IllegalArgumentException("Choose a ticket type for every seat."); }
            }
        }
        ticketTypes = new ArrayList<TicketType>(types);
    }

    // Return a copy to protect the offers belonging to this saved layout.
    public List<TicketType> getTicketTypes() {
        if (plan != null) { return plan.getTicketTypes(); }
        return new ArrayList<TicketType>(ticketTypes);
    }
    public VenueLayout(VenuePlan plan,List<Seat> savedSeats) {
        this.rows=14; this.columns=18;
        this.stageRow=0; this.stageColumn=0; this.stageWidth=1;
        this.plan=plan;
        // Saved seat identities may differ, but their positions must match the validated plan.
        java.util.Map<String,Seat> expected=new java.util.HashMap<String,Seat>();
        for(Seat seat:plan.createSeats()) { expected.put(seat.getRow()+":"+seat.getColumn(),seat); }
        if(expected.size()!=savedSeats.size()) { throw new IllegalArgumentException("Saved seats do not match the venue plan."); }
        for(Seat seat:savedSeats) {
            Seat planned=expected.remove(seat.getRow()+":"+seat.getColumn());
            if(planned==null || !planned.getLabel().equals(seat.getLabel()) || !planned.getTypeCode().equals(seat.getTypeCode())
                    || !planned.getAreaCode().equals(seat.getAreaCode())) {
                throw new IllegalArgumentException("Saved seats must match their physical section and ticket type.");
            }
        }
        this.seats=new ArrayList<Seat>(savedSeats);
    }
    public VenueLayout(VenuePlan plan) { this(plan,plan.createSeats()); }
    public boolean isFlexible() { return plan != null; }
    public VenuePlan getPlan() { return plan; }

    // Constructs a VenueLayout object and initializes or validates its starting state.
    public VenueLayout(int rows, int columns, int stageRow, int stageColumn,
    int stageWidth, List<Seat> seats) {
        // Continues into this block only when the condition below is true.
        if (rows < 4 || rows > 14 || columns < 4 || columns > 18) {
            // Stops this operation with a clear error; the caller can display or test the failure.
            throw new IllegalArgumentException("Grid: 4–14 rows and 4–18 columns.");
        }
        // Continues into this block only when the condition below is true.
        if (stageRow < 0 || stageRow >= rows || stageColumn < 0
        || stageWidth < 1 || stageColumn + stageWidth > columns) {
            // Stops this operation with a clear error; the caller can display or test the failure.
            throw new IllegalArgumentException("Keep the stage within the venue grid.");
        }
        // Stores the constructor argument in this object's private rows field.
        this.rows = rows;
        // Stores the constructor argument in this object's private columns field.
        this.columns = columns;
        // Stores the constructor argument in this object's private stage row field.
        this.stageRow = stageRow;
        // Stores the constructor argument in this object's private stage column field.
        this.stageColumn = stageColumn;
        // Stores the constructor argument in this object's private stage width field.
        this.stageWidth = stageWidth;
        // Stores the constructor argument in this object's private seats field.
        this.seats = new ArrayList<Seat>(seats);
        // Prepares the local occupied positions value used in the following steps.
        Set<String> occupiedPositions = new HashSet<String>();
        // Visits each object in the collection using an ordinary enhanced for loop.
        for (Seat seat : seats) {
            // Prepares the local position value used in the following steps.
            String position = seat.getRow() + ":" + seat.getColumn();
            // Continues into this block only when the condition below is true.
            if (seat.getRow() < 0 || seat.getRow() >= rows
            || seat.getColumn() < 0 || seat.getColumn() >= columns
            || isStage(seat.getRow(), seat.getColumn())
            || occupiedPositions.contains(position)) {
                // Stops this operation with a clear error; the caller can display or test the failure.
                throw new IllegalArgumentException("Seats must be unique, in bounds and outside the stage.");
            }
            // Adds this object to the collection or this child component to its parent container.
            occupiedPositions.add(position);
        }
    }

    // Returns rows through a getter, keeping the field itself private.
    public int getRows() {
        // Returns the stored rows value to the calling code.
        return rows;
    }
    // Returns columns through a getter, keeping the field itself private.
    public int getColumns() {
        // Returns the stored columns value to the calling code.
        return columns;
    }
    // Returns stage row through a getter, keeping the field itself private.
    public int getStageRow() {
        // Returns the stored stage row value to the calling code.
        return stageRow;
    }
    // Returns stage column through a getter, keeping the field itself private.
    public int getStageColumn() {
        // Returns the stored stage column value to the calling code.
        return stageColumn;
    }
    // Returns stage width through a getter, keeping the field itself private.
    public int getStageWidth() {
        // Returns the stored stage width value to the calling code.
        return stageWidth;
    }
    // Returns seats through a getter, keeping the field itself private.
    public List<Seat> getSeats() {
        // Returns a copy so calling code cannot modify the internal list directly.
        return new ArrayList<Seat>(seats);
    }

    // Checks whether a coordinate is inside the stage row and width.
    public boolean isStage(int row, int column) {
        // Returns this result to the method that called the current operation.
        return row == stageRow && column >= stageColumn
        && column < stageColumn + stageWidth;
    }

    // Groups seats into Section objects using two ordinary loops.
    public List<Section> getSections() {
        // Prepares the local sections value used in the following steps.
        List<Section> sections = new ArrayList<Section>();
        // Prepares the local added categories value used in the following steps.
        Set<String> addedCategories = new HashSet<String>();
        // Visits each object in the collection using an ordinary enhanced for loop.
        for (Seat seat : seats) {
            // Prepares the local category value used in the following steps.
            String category = seat.getTypeCode();
            // Continues into this block only when the condition below is true.
            if (!addedCategories.contains(category)) {
                // Prepares the local section seats value used in the following steps.
                List<Seat> sectionSeats = new ArrayList<Seat>();
                // Visits each object in the collection using an ordinary enhanced for loop.
                for (Seat otherSeat : seats) {
                    // Continues into this block only when the condition below is true.
                    if (category.equals(otherSeat.getTypeCode())) {
                        // Adds this object to the collection or this child component to its parent container.
                        sectionSeats.add(otherSeat);
                    }
                }
                // Adds this object to the collection or this child component to its parent container.
                sections.add(new Section(category, seat.getColor(), sectionSeats));
                // Adds this object to the collection or this child component to its parent container.
                addedCategories.add(category);
            }
        }
        // Returns the stored sections value to the calling code.
        return sections;
    }
}
