package com.mycompany.openevent.model;

// Defines a class that inherits the fields and behavior of its parent type.
public final class Customer extends User {

    // Constructs a Customer object and initializes or validates its starting state.
    public Customer(long id, String name, String email) {
        // Passes the shared initialization values to the parent constructor.
        super(id, name, email);
    }

    @Override
    // Returns the role implemented by this User subclass.
    public String role() {
        // Returns this result to the method that called the current operation.
        return "CUSTOMER";
    }
}
