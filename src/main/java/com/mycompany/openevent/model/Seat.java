package com.mycompany.openevent.model;

// Defines the Seat class and keeps its related data and operations together.
public class Seat {

    // Stores id.
    private final long id;
    // Stores row.
    private final int row;
    // Stores column.
    private final int column;
    // Stores label.
    private final String label;
    // Stores category.
    private final String category;
    // Stores color.
    private final String color;
    // Stores status.
    private final String status;
    // Optional custom offer and physical area; old grid seats keep legacy pricing.
    private TicketType ticketType;
    private String areaCode;

    public Seat(long id, int row, int column, String label, TicketType type, String status, String areaCode) {
        this(id, row, column, label, type.getName(), type.getColor(), status);
        this.ticketType = type;
        this.areaCode = areaCode;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getTypeCode() {
        if (ticketType != null) {
            return ticketType.getCode();
        }
        return category;
    }

    public boolean allowsEarlyBird() {
        if (ticketType != null) {
            return ticketType.hasEarlyBird();
        }
        return "REGULAR".equals(category);
    }

    // Constructs a Seat object and initializes or validates its starting state.
    public Seat(long id, int row, int column, String label, String category, String color, String status) {
        // Stores the constructor argument in this object's private id field.
        this.id = id;
        // Stores the constructor argument in this object's private row field.
        this.row = row;
        // Stores the constructor argument in this object's private column field.
        this.column = column;
        // Stores the constructor argument in this object's private label field.
        this.label = label;
        // Stores the constructor argument in this object's private category field.
        this.category = category;
        // Stores the constructor argument in this object's private color field.
        this.color = color;
        // Stores the constructor argument in this object's private status field.
        this.status = status;
    }

    // Returns id through a getter, keeping the field itself private.
    public long getId() {
        // Returns the stored id value to the calling code.
        return id;
    }

    // Returns row through a getter, keeping the field itself private.
    public int getRow() {
        // Returns the stored row value to the calling code.
        return row;
    }

    // Returns column through a getter, keeping the field itself private.
    public int getColumn() {
        // Returns the stored column value to the calling code.
        return column;
    }

    // Returns label through a getter, keeping the field itself private.
    public String getLabel() {
        // Returns the stored label value to the calling code.
        return label;
    }

    // Returns category through a getter, keeping the field itself private.
    public String getCategory() {
        // Returns the stored category value to the calling code.
        return category;
    }

    // Returns color through a getter, keeping the field itself private.
    public String getColor() {
        // Returns the stored color value to the calling code.
        return color;
    }

    // Returns status through a getter, keeping the field itself private.
    public String getStatus() {
        // Returns the stored status value to the calling code.
        return status;
    }

    // Returns true only for a seat whose saved status is AVAILABLE.
    public boolean isAvailable() {
        // Returns this result to the method that called the current operation.
        return "AVAILABLE".equals(status);
    }
}
