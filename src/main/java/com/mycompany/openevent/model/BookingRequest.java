package com.mycompany.openevent.model;

// Defines the BookingRequest class and keeps its related data and operations together.
public class BookingRequest {

    // Stores event id.
    private final long eventId;
    // Stores seat id.
    private final long seatId;
    // Stores category.
    private final String category;
    // Stores payment.
    private final Payment payment;
    // Stores simulate success.
    private final boolean simulateSuccess;

    // Constructs a BookingRequest object and initializes or validates its starting state.
    public BookingRequest(long eventId, long seatId, String category, Payment payment, boolean simulateSuccess) {
        // Stores the constructor argument in this object's private event id field.
        this.eventId = eventId;
        // Stores the constructor argument in this object's private seat id field.
        this.seatId = seatId;
        // Stores the constructor argument in this object's private category field.
        this.category = category;
        // Stores the constructor argument in this object's private payment field.
        this.payment = payment;
        // Stores the constructor argument in this object's private simulate success field.
        this.simulateSuccess = simulateSuccess;
    }

    // Returns event id through a getter, keeping the field itself private.
    public long getEventId() {
        // Returns the stored event id value to the calling code.
        return eventId;
    }

    // Returns seat id through a getter, keeping the field itself private.
    public long getSeatId() {
        // Returns the stored seat id value to the calling code.
        return seatId;
    }

    // Returns category through a getter, keeping the field itself private.
    public String getCategory() {
        // Returns the stored category value to the calling code.
        return category;
    }

    // Returns payment through a getter, keeping the field itself private.
    public Payment getPayment() {
        // Returns the stored payment value to the calling code.
        return payment;
    }

    // Performs the is simulate success operation; exceptions are passed to the caller when needed.
    public boolean isSimulateSuccess() {
        // Returns this result to the method that called the current operation.
        return simulateSuccess;
    }
}

//Abarquez