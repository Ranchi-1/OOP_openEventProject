// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
package com.mycompany.openevent.model;

// Defines a class that inherits the fields and behavior of its parent type.
public final class EWalletPayment extends Payment {

    @Override
    // Provides the concrete payment method through the abstract Payment contract.
    public String method() {
        // Returns this result to the method that called the current operation.
        return "EWALLET";
    }
}
