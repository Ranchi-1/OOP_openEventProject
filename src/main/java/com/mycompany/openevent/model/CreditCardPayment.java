
package com.mycompany.openevent.model;

// Defines a class that inherits the fields and behavior of its parent type.
public final class CreditCardPayment extends Payment {

    @Override
    // Provides the concrete payment method through the abstract Payment contract.
    public String method() {
        // Returns this result to the method that called the current operation.
        return "CARD";
    }
}
