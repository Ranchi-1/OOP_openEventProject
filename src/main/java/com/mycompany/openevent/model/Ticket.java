package com.mycompany.openevent.model;

// Imports BigDecimal so this class can use that type by its short name.
import java.math.BigDecimal;
// Imports LocalDateTime so this class can use that type by its short name.
import java.time.LocalDateTime;

// Defines the Ticket class and keeps its related data and operations together.
public class Ticket {

    // Stores id.
    private final long id;
    // Stores code.
    private final String code;
    // Stores event id.
    private final long eventId;
    // Stores customer id.
    private final long customerId;
    // Stores customer name.
    private final String customerName;
    // Stores event title.
    private final String eventTitle;
    // Stores venue.
    private final String venue;
    // Stores starts at.
    private final LocalDateTime startsAt;
    // Stores seat label.
    private final String seatLabel;
    // Stores category.
    private final String category;
    // Stores amount.
    private final BigDecimal amount;
    // Stores status.
    private final String status;
    // Stores payment status.
    private final String paymentStatus;
    // Stores method.
    private final String method;
    // Stores reference.
    private final String reference;
    // Stores receipt number.
    private final String receiptNumber;
    // Stores issued at.
    private final LocalDateTime issuedAt;

    // Constructs a Ticket object and initializes or validates its starting state.
    public Ticket(long id, String code, long eventId, long customerId, String customerName, String eventTitle, String venue, LocalDateTime startsAt, String seatLabel, String category, BigDecimal amount, String status, String paymentStatus, String method, String reference, String receiptNumber, LocalDateTime issuedAt) {
        // Stores the constructor argument in this object's private id field.
        this.id = id;
        // Stores the constructor argument in this object's private code field.
        this.code = code;
        // Stores the constructor argument in this object's private event id field.
        this.eventId = eventId;
        // Stores the constructor argument in this object's private customer id field.
        this.customerId = customerId;
        // Stores the constructor argument in this object's private customer name field.
        this.customerName = customerName;
        // Stores the constructor argument in this object's private event title field.
        this.eventTitle = eventTitle;
        // Stores the constructor argument in this object's private venue field.
        this.venue = venue;
        // Stores the constructor argument in this object's private starts at field.
        this.startsAt = startsAt;
        // Stores the constructor argument in this object's private seat label field.
        this.seatLabel = seatLabel;
        // Stores the constructor argument in this object's private category field.
        this.category = category;
        // Stores the constructor argument in this object's private amount field.
        this.amount = amount;
        // Stores the constructor argument in this object's private status field.
        this.status = status;
        // Stores the constructor argument in this object's private payment status field.
        this.paymentStatus = paymentStatus;
        // Stores the constructor argument in this object's private method field.
        this.method = method;
        // Stores the constructor argument in this object's private reference field.
        this.reference = reference;
        // Stores the constructor argument in this object's private receipt number field.
        this.receiptNumber = receiptNumber;
        // Stores the constructor argument in this object's private issued at field.
        this.issuedAt = issuedAt;
    }

    // Returns id through a getter, keeping the field itself private.
    public long getId() {
        // Returns the stored id value to the calling code.
        return id;
    }

    // Returns code through a getter, keeping the field itself private.
    public String getCode() {
        // Returns the stored code value to the calling code.
        return code;
    }

    // Returns event id through a getter, keeping the field itself private.
    public long getEventId() {
        // Returns the stored event id value to the calling code.
        return eventId;
    }

    // Returns customer id through a getter, keeping the field itself private.
    public long getCustomerId() {
        // Returns the stored customer id value to the calling code.
        return customerId;
    }

    // Returns customer name through a getter, keeping the field itself private.
    public String getCustomerName() {
        // Returns the stored customer name value to the calling code.
        return customerName;
    }

    // Returns event title through a getter, keeping the field itself private.
    public String getEventTitle() {
        // Returns the stored event title value to the calling code.
        return eventTitle;
    }

    // Returns venue through a getter, keeping the field itself private.
    public String getVenue() {
        // Returns the stored venue value to the calling code.
        return venue;
    }

    // Returns starts at through a getter, keeping the field itself private.
    public LocalDateTime getStartsAt() {
        // Returns the stored starts at value to the calling code.
        return startsAt;
    }

    // Returns seat label through a getter, keeping the field itself private.
    public String getSeatLabel() {
        // Returns the stored seat label value to the calling code.
        return seatLabel;
    }

    // Returns category through a getter, keeping the field itself private.
    public String getCategory() {
        // Returns the stored category value to the calling code.
        return category;
    }

    // Returns amount through a getter, keeping the field itself private.
    public BigDecimal getAmount() {
        // Returns the stored amount value to the calling code.
        return amount;
    }

    // Returns status through a getter, keeping the field itself private.
    public String getStatus() {
        // Returns the stored status value to the calling code.
        return status;
    }

    // Returns payment status through a getter, keeping the field itself private.
    public String getPaymentStatus() {
        // Returns the stored payment status value to the calling code.
        return paymentStatus;
    }

    // Returns method through a getter, keeping the field itself private.
    public String getMethod() {
        // Returns the stored method value to the calling code.
        return method;
    }

    // Returns reference through a getter, keeping the field itself private.
    public String getReference() {
        // Returns the stored reference value to the calling code.
        return reference;
    }

    // Returns receipt number through a getter, keeping the field itself private.
    public String getReceiptNumber() {
        // Returns the stored receipt number value to the calling code.
        return receiptNumber;
    }

    // Returns issued at through a getter, keeping the field itself private.
    public LocalDateTime getIssuedAt() {
        // Returns the stored issued at value to the calling code.
        return issuedAt;
    }

    @Override
    // Provides readable text when this object is shown in a list or combo box.
    public String toString() {
        // Returns this result to the method that called the current operation.
        return code + "  ·  " + eventTitle + "  ·  " + seatLabel + "  ·  " + status;
    }
}
