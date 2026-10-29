package com.mycompany.openevent.model;
// Import Rectangle for the explicit types used below.

import java.awt.Rectangle;
// Import HashSet for the explicit types used below.
import java.util.HashSet;
// Import Set for the explicit types used below.
import java.util.Set;

/**
 * A physical section; several sections may share the same ticket type.
 */
public class VenueArea {

    // Keep code private so outside classes use the public operations.
    private final String code;
    // Keep name private so outside classes use the public operations.
    private final String name;
    // Keep typeCode private so outside classes use the public operations.
    private final String typeCode;
    // Keep x private so outside classes use the public operations.
    private final int x;
    // Keep y private so outside classes use the public operations.
    private final int y;
    // Keep width private so outside classes use the public operations.
    private final int width;
    // Keep height private so outside classes use the public operations.
    private final int height;
    // Keep rows private so outside classes use the public operations.
    private final int rows;
    // Keep columns private so outside classes use the public operations.
    private final int columns;
    // Keep rowOffset private so outside classes use the public operations.
    private final int rowOffset;
    // Keep shape private so outside classes use the public operations.
    private final String shape;
    // Keep blocked private so outside classes use the public operations.
    private final Set<String> blocked;
    // An optional overview color is independent from the ticket offer's seat color.
    private String color;

    public VenueArea(String code, String name, String typeCode, int x, int y, int width, int height,
            int rows, int columns, int rowOffset, String shape, Set<String> blocked, String color) {
        this(code, name, typeCode, x, y, width, height, rows, columns, rowOffset, shape, blocked);
        if (color != null && !color.matches("#[0-9A-Fa-f]{6}")) {
            throw new IllegalArgumentException("Choose a valid section color.");
        }
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public VenueArea(String code, String name, String typeCode, int x, int y, int width,
            int height, int rows, int columns, int rowOffset, String shape, Set<String> blocked) {
        // Names are printed separately from stable codes used for database relationships.
        if (code == null || !code.matches("[A-Za-z0-9_-]{1,30}") || name == null
                || name.trim().isEmpty() || name.trim().length() > 40) {
            // Reject invalid input with a message the form can display.
            throw new IllegalArgumentException("Section name: 1–40 characters.");
        }
        // Validate this condition before continuing with the operation.
        if (x < 0 || y < 0 || width < 60 || height < 50 || x + width > 1000 || y + height > 700) {
            // Reject invalid input with a message the form can display.
            throw new IllegalArgumentException("Keep every section inside the venue, with minimum size 60 × 50.");
        }
        // Validate this condition before continuing with the operation.
        if (rows < 1 || rows > 10 || columns < 1 || columns > 10 || rowOffset < 0) {
            // Reject invalid input with a message the form can display.
            throw new IllegalArgumentException("Each section supports 1–10 rows and 1–10 columns.");
        }
        // Validate this condition before continuing with the operation.
        if (!"RECTANGLE".equals(shape) && !"TRAPEZOID".equals(shape)) {
            // Reject invalid input with a message the form can display.
            throw new IllegalArgumentException("Choose Rectangle or Trapezoid.");
        }
        // Store the validated constructor values in this object.
        this.code = code;
        // Store the validated constructor values in this object.
        this.name = name.trim();
        // Store the validated constructor values in this object.
        this.typeCode = typeCode;
        // Store the validated constructor values in this object.
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        // Store the validated constructor values in this object.
        this.rows = rows;
        this.columns = columns;
        this.rowOffset = rowOffset;
        // Store the validated constructor values in this object.
        this.shape = shape;
        // Store the validated constructor values in this object.
        this.blocked = new HashSet<String>(blocked);
        // Every blocked cell must refer to a real local seat position.
        for (String position : blocked) {
            boolean found = false;
            // Visit each relevant item using an ordinary loop.
            for (int r = 0; r < rows; r++) {
                // Visit each relevant item using an ordinary loop.
                for (int c = 0; c < columns; c++) {
                    // Validate this condition before continuing with the operation.
                    if (position.equals(r + ":" + c)) {
                        found = true;
                    }
                }
            }
            // Validate this condition before continuing with the operation.
            if (!found) {
                throw new IllegalArgumentException("A blocked position is outside its section.");
            }
        }
    }

    // Return the requested value through an accessor.
    public String getCode() {
        return code;
    }

    // Return the requested value through an accessor.
    public String getName() {
        return name;
    }

    // Return the requested value through an accessor.
    public String getTypeCode() {
        return typeCode;
    }

    // Return the requested value through an accessor.
    public int getX() {
        return x;
    }

    // Return the requested value through an accessor.
    public int getY() {
        return y;
    }

    // Return the requested value through an accessor.
    public int getWidth() {
        return width;
    }

    // Return the requested value through an accessor.
    public int getHeight() {
        return height;
    }

    // Return the requested value through an accessor.
    public int getRows() {
        return rows;
    }

    // Return the requested value through an accessor.
    public int getColumns() {
        return columns;
    }

    // Return the requested value through an accessor.
    public int getRowOffset() {
        return rowOffset;
    }

    // Return the requested value through an accessor.
    public String getShape() {
        return shape;
    }

    // Return the requested value through an accessor.
    public Set<String> getBlocked() {
        return new HashSet<String>(blocked);
    }

    public boolean isBlocked(int row, int column) {
        return blocked.contains(row + ":" + column);
    }

    // Return the requested value through an accessor.
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public String toString() {
        return name;
    }
}
