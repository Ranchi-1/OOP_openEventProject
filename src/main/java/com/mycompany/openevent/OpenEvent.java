// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
package com.mycompany.openevent;
// Imports OpenEventUI so this class can use that type by its short name.
import com.mycompany.openevent.ui.OpenEventUI;
// Imports Theme so this class can use that type by its short name.
import com.mycompany.openevent.ui.Theme;
// Imports SwingUtilities so this class can use that type by its short name.
import javax.swing.SwingUtilities;

/** Starts Swing on its event-dispatch thread, which is responsible for drawing. */
// Defines the OpenEvent class and keeps its related data and operations together.
public class OpenEvent {
    // Starts the application or the explicitly selected utility/test program.
    public static void main(String[] args) {
        // Calls this operation to carry out the named step with the supplied arguments.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            // Performs the run operation; exceptions are passed to the caller when needed.
            public void run() {
                // Calls this operation to carry out the named step with the supplied arguments.
                Theme.install();
                // Prepares the local window value used in the following steps.
                OpenEventUI window = new OpenEventUI();
                // Shows or hides this component for the current screen state.
                window.setVisible(true);
            }
        });
    }
}
