package com.mycompany.openevent.model;

// Imports BigDecimal so this class can use that type by its short name.
import java.math.BigDecimal;
// Imports LocalDateTime so this class can use that type by its short name.
import java.time.LocalDateTime;

// Defines a class that inherits the fields and behavior of its parent type.
public final class MovieScreening extends Event {

    // Constructs a MovieScreening object and initializes or validates its starting state.
    public MovieScreening(long id, long hostId, String title, String venue, String description, String image, LocalDateTime starts, LocalDateTime early, BigDecimal price, boolean published) {
        // Passes the shared initialization values to the parent constructor.
        super(id, hostId, title, venue, description, image, starts, early, price, published);
    }

    @Override
    // Provides the concrete event type through the abstract Event contract.
    public String eventType() {
        // Returns this result to the method that called the current operation.
        return "MOVIE";
    }

    @Override
    // Provides the subclass-specific description through polymorphism.
    public String experienceLabel() {
        // Returns this result to the method that called the current operation.
        return "Stories are better together.";
    }
}
