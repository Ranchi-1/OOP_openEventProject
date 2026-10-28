// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
package com.mycompany.openevent.model;

// Defines an abstract parent class; concrete subclasses provide the missing behavior.
public abstract class User {

    // Stores id.
    private final long id;
    // Stores name.
    private final String name;
    // Stores email.
    private final String email;

    // Constructs a User object and initializes or validates its starting state.
    protected User(long id, String name, String email) {
        // Stores the constructor argument in this object's private id field.
        this.id = id;
        // Stores the constructor argument in this object's private name field.
        this.name = name;
        // Stores the constructor argument in this object's private email field.
        this.email = email;
    }

    // Returns id through a getter, keeping the field itself private.
    public long getId() {
        // Returns the stored id value to the calling code.
        return id;
    }

    // Returns name through a getter, keeping the field itself private.
    public String getName() {
        // Returns the stored name value to the calling code.
        return name;
    }

    // Returns email through a getter, keeping the field itself private.
    public String getEmail() {
        // Returns the stored email value to the calling code.
        return email;
    }

    // Returns the role implemented by this User subclass.
    public abstract String role();
}
