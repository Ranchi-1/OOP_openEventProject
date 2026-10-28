// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
package com.mycompany.openevent.ui;

/**
* NetBeans GUI Builder form. Edit layout in Design; behavior lives outside
* generated code.
*/
// Defines a class that inherits the fields and behavior of its parent type.
public class EventView extends javax.swing.JPanel {

    // Constructs a EventView object and initializes or validates its starting state.
    public EventView() {
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
        heading=new javax.swing.JLabel();
        // Updates this working value before the next step.
        subtitle=new javax.swing.JLabel();
        // Updates this working value before the next step.
        back=new javax.swing.JButton();
        // Updates this working value before the next step.
        eventName=new javax.swing.JLabel();
        // Updates this working value before the next step.
        eventMeta=new javax.swing.JLabel();
        // Updates this working value before the next step.
        mapPanel=new javax.swing.JPanel();
        // Updates this working value before the next step.
        selectionPanel=new javax.swing.JPanel();
        // Updates this working value before the next step.
        selectionTitle=new javax.swing.JLabel();
        // Updates this working value before the next step.
        selectedSeat=new javax.swing.JLabel();
        // Updates this working value before the next step.
        pricingLabel=new javax.swing.JLabel();
        // Updates this working value before the next step.
        category=new javax.swing.JComboBox();
        // Updates this working value before the next step.
        price=new javax.swing.JLabel();
        // Updates this working value before the next step.
        checkout=new javax.swing.JButton();
        // Updates this working value before the next step.
        legend=new javax.swing.JLabel();
        // Updates this working value before the next step.
        description=new javax.swing.JLabel();
        // Calls this operation to carry out the named step with the supplied arguments.
        setLayout(null);
        // Calls this operation to carry out the named step with the supplied arguments.
        setBackground(new java.awt.Color(247,246,251));
        // Calls this operation to carry out the named step with the supplied arguments.
        setPreferredSize(new java.awt.Dimension(1176,750));
        // Displays this text in the named Swing component.
        heading.setText("Choose your seat");
        // Sets the font family, style and point size used to draw this component.
        heading.setFont(new java.awt.Font("Segoe UI",1,28));
        // Sets the text or drawing color for this component.
        heading.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        heading.setBounds(32,18,1050,40);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(heading);
        // Displays this text in the named Swing component.
        subtitle.setText("Select one available seat. Your ticket is saved only after checkout.");
        // Sets the font family, style and point size used to draw this component.
        subtitle.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        subtitle.setForeground(new java.awt.Color(130,124,145));
        // Positions this component using x, y, width and height, measured in pixels.
        subtitle.setBounds(32,60,1050,25);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(subtitle);
        // Displays this text in the named Swing component.
        back.setText("← Discover");
        // Sets the font family, style and point size used to draw this component.
        back.setFont(new java.awt.Font("Segoe UI",1,14));
        // Sets the text or drawing color for this component.
        back.setForeground(new java.awt.Color(108,59,240));
        // Sets this component color; the gradient start/end colors form the purple theme.
        back.setBackground(new java.awt.Color(238,232,254));
        // Calls this operation to carry out the named step with the supplied arguments.
        back.setFocusPainted(false);
        // Changes the pointer appearance to communicate an action or a busy operation.
        back.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        // Positions this component using x, y, width and height, measured in pixels.
        back.setBounds(32,96,155,36);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(back);
        // Displays this text in the named Swing component.
        eventName.setText("Event");
        // Sets the font family, style and point size used to draw this component.
        eventName.setFont(new java.awt.Font("Segoe UI",1,27));
        // Sets the text or drawing color for this component.
        eventName.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        eventName.setBounds(32,148,1070,40);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(eventName);
        // Displays this text in the named Swing component.
        eventMeta.setText("Date · Venue");
        // Sets the font family, style and point size used to draw this component.
        eventMeta.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        eventMeta.setForeground(new java.awt.Color(130,124,145));
        // Positions this component using x, y, width and height, measured in pixels.
        eventMeta.setBounds(32,195,1080,28);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(eventMeta);
        // Sets the font family, style and point size used to draw this component.
        mapPanel.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        mapPanel.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        mapPanel.setBackground(new java.awt.Color(255,255,255));
        // Chooses how child components are arranged inside this container.
        mapPanel.setLayout(null);
        // Positions this component using x, y, width and height, measured in pixels.
        mapPanel.setBounds(32,246,745,350);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(mapPanel);
        // Sets the font family, style and point size used to draw this component.
        selectionPanel.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        selectionPanel.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        selectionPanel.setBackground(new java.awt.Color(255,255,255));
        // Chooses how child components are arranged inside this container.
        selectionPanel.setLayout(null);
        // Displays this text in the named Swing component.
        selectionTitle.setText("Your selection");
        // Sets the font family, style and point size used to draw this component.
        selectionTitle.setFont(new java.awt.Font("Segoe UI",1,23));
        // Sets the text or drawing color for this component.
        selectionTitle.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        selectionTitle.setBounds(22,18,300,32);
        // Adds this object to the collection or this child component to its parent container.
        selectionPanel.add(selectionTitle);
        // Displays this text in the named Swing component.
        selectedSeat.setText("Select a seat on the map.");
        // Sets the font family, style and point size used to draw this component.
        selectedSeat.setFont(new java.awt.Font("Segoe UI",1,15));
        // Sets the text or drawing color for this component.
        selectedSeat.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        selectedSeat.setBounds(22,72,300,40);
        // Adds this object to the collection or this child component to its parent container.
        selectionPanel.add(selectedSeat);
        // Displays this text in the named Swing component.
        pricingLabel.setText("Ticket option");
        // Sets the font family, style and point size used to draw this component.
        pricingLabel.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        pricingLabel.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        pricingLabel.setBounds(22,113,280,25);
        // Adds this object to the collection or this child component to its parent container.
        selectionPanel.add(pricingLabel);
        // Sets the font family, style and point size used to draw this component.
        category.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        category.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        category.setBackground(new java.awt.Color(255,255,255));
        // Supplies the list, combo-box or table data displayed by this control.
        category.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[]{"REGULAR"}));
        // Positions this component using x, y, width and height, measured in pixels.
        category.setBounds(22,144,296,40);
        // Adds this object to the collection or this child component to its parent container.
        selectionPanel.add(category);
        // Displays this text in the named Swing component.
        price.setText("PHP —");
        // Sets the font family, style and point size used to draw this component.
        price.setFont(new java.awt.Font("Segoe UI",1,30));
        // Sets the text or drawing color for this component.
        price.setForeground(new java.awt.Color(108,59,240));
        // Positions this component using x, y, width and height, measured in pixels.
        price.setBounds(22,203,300,42);
        // Adds this object to the collection or this child component to its parent container.
        selectionPanel.add(price);
        // Displays this text in the named Swing component.
        checkout.setText("Continue to checkout  →");
        // Sets the font family, style and point size used to draw this component.
        checkout.setFont(new java.awt.Font("Segoe UI",1,14));
        // Sets the text or drawing color for this component.
        checkout.setForeground(new java.awt.Color(255,255,255));
        // Sets this component color; the gradient start/end colors form the purple theme.
        checkout.setBackground(new java.awt.Color(108,59,240));
        // Calls this operation to carry out the named step with the supplied arguments.
        checkout.setFocusPainted(false);
        // Changes the pointer appearance to communicate an action or a busy operation.
        checkout.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        // Positions this component using x, y, width and height, measured in pixels.
        checkout.setBounds(22,271,296,48);
        // Adds this object to the collection or this child component to its parent container.
        selectionPanel.add(checkout);
        // Positions this component using x, y, width and height, measured in pixels.
        selectionPanel.setBounds(800,246,342,350);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(selectionPanel);
        // Displays this text in the named Swing component.
        legend.setText("● VIP     ● Regular     ■ Sold     □ Aisle     ■ Selected");
        // Sets the font family, style and point size used to draw this component.
        legend.setFont(new java.awt.Font("Segoe UI",0,13));
        // Sets the text or drawing color for this component.
        legend.setForeground(new java.awt.Color(130,124,145));
        // Positions this component using x, y, width and height, measured in pixels.
        legend.setBounds(32,608,1070,25);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(legend);
        // Displays this text in the named Swing component.
        description.setText("Event details");
        // Sets the font family, style and point size used to draw this component.
        description.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        description.setForeground(new java.awt.Color(130,124,145));
        // Positions this component using x, y, width and height, measured in pixels.
        description.setBounds(32,650,1100,80);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(description);
    }
    // </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Stores heading.
    public javax.swing.JLabel heading;
    // Stores subtitle.
    public javax.swing.JLabel subtitle;
    // Stores back.
    public javax.swing.JButton back;
    // Stores event name.
    public javax.swing.JLabel eventName;
    // Stores event meta.
    public javax.swing.JLabel eventMeta;
    // Stores map panel.
    public javax.swing.JPanel mapPanel;
    // Stores selection panel.
    public javax.swing.JPanel selectionPanel;
    // Stores selection title.
    public javax.swing.JLabel selectionTitle;
    // Stores selected seat.
    public javax.swing.JLabel selectedSeat;
    // Stores pricing label.
    public javax.swing.JLabel pricingLabel;
    // Stores category.
    public javax.swing.JComboBox category;
    // Stores price.
    public javax.swing.JLabel price;
    // Stores checkout.
    public javax.swing.JButton checkout;
    // Stores legend.
    public javax.swing.JLabel legend;
    // Stores description.
    public javax.swing.JLabel description;
    // End of variables declaration//GEN-END:variables
}
