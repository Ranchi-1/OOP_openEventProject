package com.mycompany.openevent.model;

// Defines the Session class and keeps its related data and operations together.
public class Session {

    // Stores user.
    private final User user;

    // Constructs a Session object and initializes or validates its starting state.
    public Session(User user) {
        // Continues into this block only when the condition below is true.
        if (user == null) {
            // Stops this operation with a clear error; the caller can display or test the failure.
            throw new IllegalArgumentException("Please sign in.");
        }
        // Stores the constructor argument in this object's private user field.
        this.user = user;
    }

    // Returns user through a getter, keeping the field itself private.
    public User getUser() {
        // Returns the stored user value to the calling code.
        return user;
    }

    // Checks whether this session contains a Host object.
    public boolean isHost() {
        // Returns this result to the method that called the current operation.
        return user instanceof Host;
    }
}
