// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
package com.mycompany.openevent.model;

// Imports BigDecimal so this class can use that type by its short name.
import java.math.BigDecimal;
// Imports RoundingMode so this class can use that type by its short name.
import java.math.RoundingMode;
// Imports LocalDateTime so this class can use that type by its short name.
import java.time.LocalDateTime;

// Defines an abstract parent class; concrete subclasses provide the missing behavior.
public abstract class Event {

    // Stores id.
    private final long id;
    // Stores host id.
    private final long hostId;
    // Stores title.
    private final String title;
    // Stores venue.
    private final String venue;
    // Stores description.
    private final String description;
    // Stores image.
    private final String image;
    // Stores starts at.
    private final LocalDateTime startsAt;
    // Stores early bird until.
    private final LocalDateTime earlyBirdUntil;
    // Stores base price.
    private final BigDecimal basePrice;
    // Stores published.
    private final boolean published;

    // Constructs a Event object and initializes or validates its starting state.
    protected Event(long id, long hostId, String title, String venue, String description, String image, LocalDateTime startsAt, LocalDateTime earlyBirdUntil, BigDecimal basePrice, boolean published) {
        // Continues into this block only when the condition below is true.
        if (title == null || title.isBlank() || venue == null || venue.isBlank()) {
            // Stops this operation with a clear error; the caller can display or test the failure.
            throw new IllegalArgumentException("Event title and venue are required.");
        }
        // Continues into this block only when the condition below is true.
        if (basePrice == null || basePrice.signum() <= 0 || basePrice.compareTo(new BigDecimal("99999999.99"))>0 || basePrice.stripTrailingZeros().scale()>2) {
            // Stops this operation with a clear error; the caller can display or test the failure.
            throw new IllegalArgumentException("Enter a positive price up to 99,999,999.99 with at most two decimal places.");
        }
        // Stores the constructor argument in this object's private id field.
        this.id = id;
        // Stores the constructor argument in this object's private host id field.
        this.hostId = hostId;
        // Stores the constructor argument in this object's private title field.
        this.title = title;
        // Stores the constructor argument in this object's private venue field.
        this.venue = venue;
        // Stores the constructor argument in this object's private description field.
        this.description = description;
        // Stores the constructor argument in this object's private image field.
        this.image = image;
        // Stores the constructor argument in this object's private starts at field.
        this.startsAt = startsAt;
        // Stores the constructor argument in this object's private early bird until field.
        this.earlyBirdUntil = earlyBirdUntil;
        // Stores the constructor argument in this object's private base price field.
        this.basePrice = basePrice;
        // Stores the constructor argument in this object's private published field.
        this.published = published;
    }

    // Provides the concrete event type through the abstract Event contract.
    public abstract String eventType();

    // Provides the subclass-specific description through polymorphism.
    public abstract String experienceLabel();

    // Applies Regular, VIP or eligible Early Bird pricing with two-decimal rounding.
    public BigDecimal calculatePrice(Seat seat, String category) {
        // Custom ticket prices are independent of the legacy Regular/VIP multipliers.
        if (seat.getTicketType() != null) {
            TicketType type=seat.getTicketType();
            if ((type.getName() + " / Early Bird").equals(category)) {
                if (!type.hasEarlyBird() || earlyBirdUntil==null || !LocalDateTime.now().isBefore(earlyBirdUntil)) {
                    throw new IllegalArgumentException("Early Bird is unavailable for this ticket type.");
                }
                return type.getPrice().multiply(new BigDecimal("0.80")).setScale(2,RoundingMode.HALF_UP);
            }
            if (!type.getName().equals(category)) {
                throw new IllegalArgumentException("The ticket type changed. Refresh the event and select the seat again.");
            }
            return type.getPrice();
        }

        // Continues into this block only when the condition below is true.
        if ("VIP".equals(seat.getCategory())) {
            // Continues into this block only when the condition below is true.
            if (!"VIP".equals(category)) {
                // Stops this operation with a clear error; the caller can display or test the failure.
                throw new IllegalArgumentException("Choose VIP pricing for a VIP seat.");
            }
            // Returns this result to the method that called the current operation.
            return basePrice.multiply(new BigDecimal("1.50")).setScale(2, RoundingMode.HALF_UP);
        }
        // Continues into this block only when the condition below is true.
        if ("EARLY_BIRD".equals(category)) {
            // Continues into this block only when the condition below is true.
            if (earlyBirdUntil == null || !LocalDateTime.now().isBefore(earlyBirdUntil)) {
                // Stops this operation with a clear error; the caller can display or test the failure.
                throw new IllegalArgumentException("Early Bird sales have ended.");
            }
            // Returns this result to the method that called the current operation.
            return basePrice.multiply(new BigDecimal("0.80")).setScale(2, RoundingMode.HALF_UP);
        }
        // Continues into this block only when the condition below is true.
        if (!"REGULAR".equals(category)) {
            // Stops this operation with a clear error; the caller can display or test the failure.
            throw new IllegalArgumentException("Choose Regular or eligible Early Bird pricing.");
        }
        // Returns this result to the method that called the current operation.
        return basePrice.setScale(2, RoundingMode.HALF_UP);
    }

    // Returns id through a getter, keeping the field itself private.
    public long getId() {
        // Returns the stored id value to the calling code.
        return id;
    }

    // Returns host id through a getter, keeping the field itself private.
    public long getHostId() {
        // Returns the stored host id value to the calling code.
        return hostId;
    }

    // Returns title through a getter, keeping the field itself private.
    public String getTitle() {
        // Returns the stored title value to the calling code.
        return title;
    }

    // Returns venue through a getter, keeping the field itself private.
    public String getVenue() {
        // Returns the stored venue value to the calling code.
        return venue;
    }

    // Returns description through a getter, keeping the field itself private.
    public String getDescription() {
        // Returns the stored description value to the calling code.
        return description;
    }

    // Returns image through a getter, keeping the field itself private.
    public String getImage() {
        // Returns the stored image value to the calling code.
        return image;
    }

    // Returns starts at through a getter, keeping the field itself private.
    public LocalDateTime getStartsAt() {
        // Returns the stored starts at value to the calling code.
        return startsAt;
    }

    // Returns early bird until through a getter, keeping the field itself private.
    public LocalDateTime getEarlyBirdUntil() {
        // Returns the stored early bird until value to the calling code.
        return earlyBirdUntil;
    }

    // Returns base price through a getter, keeping the field itself private.
    public BigDecimal getBasePrice() {
        // Returns the stored base price value to the calling code.
        return basePrice;
    }

    // Performs the is published operation; exceptions are passed to the caller when needed.
    public boolean isPublished() {
        // Returns this result to the method that called the current operation.
        return published;
    }

    @Override
    // Provides readable text when this object is shown in a list or combo box.
    public String toString() {
        // Continues into this block only when the condition below is true.
        if (published) {
            // Returns this result to the method that called the current operation.
            return title;
        }
        // Returns this result to the method that called the current operation.
        return title + " [DRAFT]";
    }
}
