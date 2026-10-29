package com.mycompany.openevent.model;

// Imports BigDecimal so this class can use that type by its short name.
import java.math.BigDecimal;
// Imports UUID so this class can use that type by its short name.
import java.util.UUID;

// Defines an abstract parent class; concrete subclasses provide the missing behavior.
public abstract class Payment {

    // Provides the concrete payment method through the abstract Payment contract.
    public abstract String method();

    // Returns a generated demo reference or rejects a simulated decline; no real payment is made.
    public String processSimulatedPayment(BigDecimal amount, boolean success) {
        // Continues into this block only when the condition below is true.
        if (amount.signum() <= 0) {
            // Stops this operation with a clear error; the caller can display or test the failure.
            throw new IllegalArgumentException("Invalid amount.");
        }
        // Continues into this block only when the condition below is true.
        if (!success) {
            // Stops this operation with a clear error; the caller can display or test the failure.
            throw new IllegalArgumentException("Simulated payment declined. No ticket issued; the seat remains available.");
        }
        // Returns this result to the method that called the current operation.
        return "DEMO-" + method() + "-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
