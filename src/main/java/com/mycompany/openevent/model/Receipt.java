package com.mycompany.openevent.model;

// Defines the Receipt class and keeps its related data and operations together.
public class Receipt {

    // Stores ticket.
    private final Ticket ticket;

    // Constructs a Receipt object and initializes or validates its starting state.
    public Receipt(Ticket ticket) {
        // Stores the constructor argument in this object's private ticket field.
        this.ticket = ticket;
    }

    // Returns ticket through a getter, keeping the field itself private.
    public Ticket getTicket() {
        // Returns the stored ticket value to the calling code.
        return ticket;
    }

    // Creates the plain-text simulated receipt from the saved ticket values.
    public String asText() {
        // Returns this result to the method that called the current operation.
        return "OPENEVENT — SIMULATED RECEIPT\n" + ticket.getReceiptNumber() + "\n\n" + ticket.getEventTitle() + "\n" + ticket.getVenue() + "\n" + ticket.getStartsAt() + "\nSeat: " + ticket.getSeatLabel() + " / " + ticket.getCategory() + "\nTicket: " + ticket.getCode() + "\nCustomer: " + ticket.getCustomerName() + "\n\nPHP " + ticket.getAmount() + "\nMethod: " + ticket.getMethod() + "\nReference: " + ticket.getReference() + "\nPayment: " + ticket.getPaymentStatus() + "\nTicket status: " + ticket.getStatus() + "\nIssued: " + ticket.getIssuedAt() + "\n\nCLASSROOM SIMULATION — NO REAL MONEY COLLECTED\n";
    }
}
