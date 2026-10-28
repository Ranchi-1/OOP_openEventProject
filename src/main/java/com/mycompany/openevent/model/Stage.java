package com.mycompany.openevent.model;
// Import Rectangle for the explicit types used below.
import java.awt.Rectangle;

/** Stage coordinates use a fixed 1000 by 700 logical canvas. */
public class Stage {
    // Keep x private so outside classes use the public operations.
    private final int x;
    // Keep y private so outside classes use the public operations.
    private final int y;
    // Keep width private so outside classes use the public operations.
    private final int width;
    // Keep height private so outside classes use the public operations.
    private final int height;
    public Stage(int x, int y, int width, int height) {
        // A stage must remain inside the logical venue and stay large enough to see.
        if (x < 0 || y < 0 || width < 40 || height < 30 || x + width > 1000 || y + height > 700) {
            // Reject invalid input with a message the form can display.
            throw new IllegalArgumentException("Keep the stage inside the 1000 × 700 venue.");
        }
        // Store the validated constructor values in this object.
        this.x = x;
        // Store the validated constructor values in this object.
        this.y = y;
        // Store the validated constructor values in this object.
        this.width = width;
        // Store the validated constructor values in this object.
        this.height = height;
    }
    // Return the requested value through an accessor.
    public int getX() { return x; }
    // Return the requested value through an accessor.
    public int getY() { return y; }
    // Return the requested value through an accessor.
    public int getWidth() { return width; }
    // Return the requested value through an accessor.
    public int getHeight() { return height; }
    // Return the requested value through an accessor.
    public Rectangle getBounds() { return new Rectangle(x,y,width,height); }
}
