package com.mycompany.openevent.model;
// Import BigDecimal for the explicit types used below.

import java.math.BigDecimal;
// Import RoundingMode for the explicit types used below.
import java.math.RoundingMode;

/**
 * A named event-specific offer. Its stable code survives renaming.
 */
public class TicketType {

    // Keep identity separate from the name printed on future tickets.
    private final String code;
    // Keep name private so outside classes use the public operations.
    private final String name;
    // Keep price private so outside classes use the public operations.
    private final BigDecimal price;
    // Keep color private so outside classes use the public operations.
    private final String color;
    // Keep earlyBird private so outside classes use the public operations.
    private final boolean earlyBird;

    public TicketType(String code, String name, BigDecimal price, String color, boolean earlyBird) {
        // Reject invalid values before they can reach the database or map.
        if (code == null || !code.matches("[A-Za-z0-9_-]{1,40}")) {
            // Reject invalid input with a message the form can display.
            throw new IllegalArgumentException("Invalid ticket type code.");
        }
        // Validate this condition before continuing with the operation.
        if (name == null || name.trim().isEmpty() || name.trim().length() > 50
                || name.trim().equalsIgnoreCase("EARLY_BIRD") || name.toLowerCase(java.util.Locale.ROOT).contains(" / early bird")) {
            // Reject invalid input with a message the form can display.
            throw new IllegalArgumentException("Use a ticket name of 1–50 characters; Early Bird is reserved for discounts.");
        }
        // Validate this condition before continuing with the operation.
        if (price == null || price.signum() <= 0 || price.compareTo(new BigDecimal("99999999.99")) > 0
                || price.stripTrailingZeros().scale() > 2) {
            // Reject invalid input with a message the form can display.
            throw new IllegalArgumentException("Ticket price must be positive, within 99,999,999.99, and use at most two decimal places.");
        }
        // Validate this condition before continuing with the operation.
        if (color == null || !color.matches("#[0-9A-Fa-f]{6}")) {
            // Reject invalid input with a message the form can display.
            throw new IllegalArgumentException("Choose a valid ticket color.");
        }
        // Store the validated constructor values in this object.
        this.code = code;
        // Store the validated constructor values in this object.
        this.name = name.trim();
        // Store the validated constructor values in this object.
        this.price = price.setScale(2, RoundingMode.HALF_UP);
        // Store the validated constructor values in this object.
        this.color = color;
        // Store the validated constructor values in this object.
        this.earlyBird = earlyBird;
    }

    // Getters expose values without allowing outside code to overwrite fields.
    public String getCode() {
        return code;
    }

    // Return the requested value through an accessor.
    public String getName() {
        return name;
    }

    // Return the requested value through an accessor.
    public BigDecimal getPrice() {
        return price;
    }

    // Return the requested value through an accessor.
    public String getColor() {
        return color;
    }

    public boolean hasEarlyBird() {
        return earlyBird;
    }

    @Override
    public String toString() {
        return name + " · PHP " + price.toPlainString();
    }
}
