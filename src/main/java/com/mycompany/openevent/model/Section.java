// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
package com.mycompany.openevent.model;

// Imports List so this class can use that type by its short name.
import java.util.List;

// Defines the Section class and keeps its related data and operations together.
public class Section {
    // Stores name.
    private final String name;
    // Stores color.
    private final String color;
    // Stores seats.
    private final List<Seat> seats;

    // Constructs a Section object and initializes or validates its starting state.
    public Section(String name, String color, List<Seat> seats) {
        // Stores the constructor argument in this object's private name field.
        this.name = name;
        // Stores the constructor argument in this object's private color field.
        this.color = color;
        // Stores the constructor argument in this object's private seats field.
        this.seats = new java.util.ArrayList<Seat>(seats);
    }

    // Returns name through a getter, keeping the field itself private.
    public String getName() {
        // Returns the stored name value to the calling code.
        return name;
    }

    // Returns color through a getter, keeping the field itself private.
    public String getColor() {
        // Returns the stored color value to the calling code.
        return color;
    }

    // Returns seats through a getter, keeping the field itself private.
    public List<Seat> getSeats() {
        // Returns the stored seats value to the calling code.
        return new java.util.ArrayList<Seat>(seats);
    }
}
