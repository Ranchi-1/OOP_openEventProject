// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
package com.mycompany.openevent.ui;

/**
* NetBeans GUI Builder form. Edit layout in Design; behavior lives outside
* generated code.
*/
// Defines a class that inherits the fields and behavior of its parent type.
public class NavigationView extends javax.swing.JPanel {

    // Constructs a NavigationView object and initializes or validates its starting state.
    public NavigationView() {
        // Calls this operation to carry out the named step with the supplied arguments.
        initComponents();
    }

    @SuppressWarnings({
        "unchecked", "rawtypes"
    })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // NetBeans generates this layout code from the matching .form file; positions are measured in pixels.
    private void initComponents(){
        // Updates this working value before the next step.
        brand=new javax.swing.JLabel();
        // Updates this working value before the next step.
        discover=new javax.swing.JButton();
        // Updates this working value before the next step.
        tickets=new javax.swing.JButton();
        // Updates this working value before the next step.
        demo=new javax.swing.JLabel();
        // Updates this working value before the next step.
        identity=new javax.swing.JLabel();
        // Updates this working value before the next step.
        logout=new javax.swing.JButton();
        // Calls this operation to carry out the named step with the supplied arguments.
        setLayout(null);
        // Calls this operation to carry out the named step with the supplied arguments.
        setBackground(new java.awt.Color(247,246,251));
        // Calls this operation to carry out the named step with the supplied arguments.
        setPreferredSize(new java.awt.Dimension(1176,72));
        // Displays this text in the named Swing component.
        brand.setText("OpenEvent");
        // Sets the font family, style and point size used to draw this component.
        brand.setFont(new java.awt.Font("Segoe UI",1,25));
        // Sets the text or drawing color for this component.
        brand.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        brand.setBounds(25,16,245,38);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(brand);
        // Displays this text in the named Swing component.
        discover.setText("Discover");
        // Sets the font family, style and point size used to draw this component.
        discover.setFont(new java.awt.Font("Segoe UI",1,14));
        // Sets the text or drawing color for this component.
        discover.setForeground(new java.awt.Color(108,59,240));
        // Sets this component color; the gradient start/end colors form the purple theme.
        discover.setBackground(new java.awt.Color(238,232,254));
        // Calls this operation to carry out the named step with the supplied arguments.
        discover.setFocusPainted(false);
        // Changes the pointer appearance to communicate an action or a busy operation.
        discover.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        // Positions this component using x, y, width and height, measured in pixels.
        discover.setBounds(296,17,125,38);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(discover);
        // Displays this text in the named Swing component.
        tickets.setText("My tickets");
        // Sets the font family, style and point size used to draw this component.
        tickets.setFont(new java.awt.Font("Segoe UI",1,14));
        // Sets the text or drawing color for this component.
        tickets.setForeground(new java.awt.Color(108,59,240));
        // Sets this component color; the gradient start/end colors form the purple theme.
        tickets.setBackground(new java.awt.Color(238,232,254));
        // Calls this operation to carry out the named step with the supplied arguments.
        tickets.setFocusPainted(false);
        // Changes the pointer appearance to communicate an action or a busy operation.
        tickets.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        // Positions this component using x, y, width and height, measured in pixels.
        tickets.setBounds(431,17,125,38);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(tickets);
        // Displays this text in the named Swing component.
        demo.setText("PROTOTYPE · SIMULATED PAYMENTS");
        // Sets the font family, style and point size used to draw this component.
        demo.setFont(new java.awt.Font("Segoe UI",1,11));
        // Sets the text or drawing color for this component.
        demo.setForeground(new java.awt.Color(130,124,145));
        // Positions this component using x, y, width and height, measured in pixels.
        demo.setBounds(588,22,360,28);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(demo);
        // Displays this text in the named Swing component.
        identity.setText("");
        // Sets the font family, style and point size used to draw this component.
        identity.setFont(new java.awt.Font("Segoe UI",1,13));
        // Sets the text or drawing color for this component.
        identity.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        identity.setBounds(900,22,150,28);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(identity);
        // Displays this text in the named Swing component.
        logout.setText("Sign out");
        // Sets the font family, style and point size used to draw this component.
        logout.setFont(new java.awt.Font("Segoe UI",1,14));
        // Sets the text or drawing color for this component.
        logout.setForeground(new java.awt.Color(108,59,240));
        // Sets this component color; the gradient start/end colors form the purple theme.
        logout.setBackground(new java.awt.Color(238,232,254));
        // Calls this operation to carry out the named step with the supplied arguments.
        logout.setFocusPainted(false);
        // Changes the pointer appearance to communicate an action or a busy operation.
        logout.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        // Positions this component using x, y, width and height, measured in pixels.
        logout.setBounds(1055,17,115,38);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(logout);
    }
    // </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Stores brand.
    public javax.swing.JLabel brand;
    // Stores discover.
    public javax.swing.JButton discover;
    // Stores tickets.
    public javax.swing.JButton tickets;
    // Stores demo.
    public javax.swing.JLabel demo;
    // Stores identity.
    public javax.swing.JLabel identity;
    // Stores logout.
    public javax.swing.JButton logout;
    // End of variables declaration//GEN-END:variables
}
