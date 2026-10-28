// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
package com.mycompany.openevent.ui;

/**
* NetBeans GUI Builder form. Edit layout in Design; behavior lives outside
* generated code.
*/
// Defines a class that inherits the fields and behavior of its parent type.
public class CheckoutView extends javax.swing.JPanel {

    // Constructs a CheckoutView object and initializes or validates its starting state.
    public CheckoutView() {
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
        notice=new keeptoo.KGradientPanel();
        // Updates this working value before the next step.
        simulation=new javax.swing.JLabel();
        // Updates this working value before the next step.
        paymentPanel=new javax.swing.JPanel();
        // Updates this working value before the next step.
        paymentTitle=new javax.swing.JLabel();
        // Updates this working value before the next step.
        attendee=new javax.swing.JLabel();
        // Updates this working value before the next step.
        method=new javax.swing.JComboBox();
        // Updates this working value before the next step.
        safe=new javax.swing.JLabel();
        // Updates this working value before the next step.
        outcome=new javax.swing.JComboBox();
        // Updates this working value before the next step.
        summaryPanel=new javax.swing.JPanel();
        // Updates this working value before the next step.
        summaryTitle=new javax.swing.JLabel();
        // Updates this working value before the next step.
        summary=new javax.swing.JLabel();
        // Updates this working value before the next step.
        total=new javax.swing.JLabel();
        // Updates this working value before the next step.
        pay=new javax.swing.JButton();
        // Updates this working value before the next step.
        policy=new javax.swing.JLabel();
        // Calls this operation to carry out the named step with the supplied arguments.
        setLayout(null);
        // Calls this operation to carry out the named step with the supplied arguments.
        setBackground(new java.awt.Color(247,246,251));
        // Calls this operation to carry out the named step with the supplied arguments.
        setPreferredSize(new java.awt.Dimension(1176,660));
        // Displays this text in the named Swing component.
        heading.setText("Review your booking");
        // Sets the font family, style and point size used to draw this component.
        heading.setFont(new java.awt.Font("Segoe UI",1,28));
        // Sets the text or drawing color for this component.
        heading.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        heading.setBounds(32,18,1050,40);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(heading);
        // Displays this text in the named Swing component.
        subtitle.setText("Check the event, seat and price before confirming this simulated payment.");
        // Sets the font family, style and point size used to draw this component.
        subtitle.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        subtitle.setForeground(new java.awt.Color(130,124,145));
        // Positions this component using x, y, width and height, measured in pixels.
        subtitle.setBounds(32,60,1050,25);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(subtitle);
        // Displays this text in the named Swing component.
        back.setText("← Seat selection");
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
        back.setBounds(32,102,190,36);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(back);
        // Sets the font family, style and point size used to draw this component.
        notice.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        notice.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        notice.setkStartColor(new java.awt.Color(129,59,240));
        // Sets this component color; the gradient start/end colors form the purple theme.
        notice.setkEndColor(new java.awt.Color(67,55,217));
        // Chooses how child components are arranged inside this container.
        notice.setLayout(null);
        // Displays this text in the named Swing component.
        simulation.setText("SIMULATION ONLY · No real money will be collected.");
        // Sets the font family, style and point size used to draw this component.
        simulation.setFont(new java.awt.Font("Segoe UI",1,16));
        // Sets the text or drawing color for this component.
        simulation.setForeground(new java.awt.Color(255,255,255));
        // Positions this component using x, y, width and height, measured in pixels.
        simulation.setBounds(20,17,1060,32);
        // Adds this object to the collection or this child component to its parent container.
        notice.add(simulation);
        // Positions this component using x, y, width and height, measured in pixels.
        notice.setBounds(32,158,1110,70);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(notice);
        // Sets the font family, style and point size used to draw this component.
        paymentPanel.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        paymentPanel.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        paymentPanel.setBackground(new java.awt.Color(255,255,255));
        // Chooses how child components are arranged inside this container.
        paymentPanel.setLayout(null);
        // Displays this text in the named Swing component.
        paymentTitle.setText("Payment method");
        // Sets the font family, style and point size used to draw this component.
        paymentTitle.setFont(new java.awt.Font("Segoe UI",1,23));
        // Sets the text or drawing color for this component.
        paymentTitle.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        paymentTitle.setBounds(24,20,600,36);
        // Adds this object to the collection or this child component to its parent container.
        paymentPanel.add(paymentTitle);
        // Displays this text in the named Swing component.
        attendee.setText("Customer");
        // Sets the font family, style and point size used to draw this component.
        attendee.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        attendee.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        attendee.setBounds(24,76,595,30);
        // Adds this object to the collection or this child component to its parent container.
        paymentPanel.add(attendee);
        // Sets the font family, style and point size used to draw this component.
        method.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        method.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        method.setBackground(new java.awt.Color(255,255,255));
        // Supplies the list, combo-box or table data displayed by this control.
        method.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[]{"E-wallet","Credit card","Cash"}));
        // Positions this component using x, y, width and height, measured in pixels.
        method.setBounds(24,132,595,40);
        // Adds this object to the collection or this child component to its parent container.
        paymentPanel.add(method);
        // Displays this text in the named Swing component.
        safe.setText("<html>Demo references are generated automatically.<br>No card number, wallet PIN or payment secrets are needed.</html>");
        // Sets the font family, style and point size used to draw this component.
        safe.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        safe.setForeground(new java.awt.Color(130,124,145));
        // Positions this component using x, y, width and height, measured in pixels.
        safe.setBounds(24,194,595,60);
        // Adds this object to the collection or this child component to its parent container.
        paymentPanel.add(safe);
        // Sets the font family, style and point size used to draw this component.
        outcome.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        outcome.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        outcome.setBackground(new java.awt.Color(255,255,255));
        // Supplies the list, combo-box or table data displayed by this control.
        outcome.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[]{"Simulate success","Simulate decline"}));
        // Positions this component using x, y, width and height, measured in pixels.
        outcome.setBounds(24,273,595,40);
        // Adds this object to the collection or this child component to its parent container.
        paymentPanel.add(outcome);
        // Positions this component using x, y, width and height, measured in pixels.
        paymentPanel.setBounds(32,254,650,330);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(paymentPanel);
        // Sets the font family, style and point size used to draw this component.
        summaryPanel.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        summaryPanel.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        summaryPanel.setBackground(new java.awt.Color(255,255,255));
        // Chooses how child components are arranged inside this container.
        summaryPanel.setLayout(null);
        // Displays this text in the named Swing component.
        summaryTitle.setText("Your night, one seat away.");
        // Sets the font family, style and point size used to draw this component.
        summaryTitle.setFont(new java.awt.Font("Segoe UI",1,22));
        // Sets the text or drawing color for this component.
        summaryTitle.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        summaryTitle.setBounds(24,20,390,32);
        // Adds this object to the collection or this child component to its parent container.
        summaryPanel.add(summaryTitle);
        // Displays this text in the named Swing component.
        summary.setText("<html>Event<br>Seat<br>Category</html>");
        // Sets the font family, style and point size used to draw this component.
        summary.setFont(new java.awt.Font("Segoe UI",0,16));
        // Sets the text or drawing color for this component.
        summary.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        summary.setBounds(24,76,390,110);
        // Adds this object to the collection or this child component to its parent container.
        summaryPanel.add(summary);
        // Displays this text in the named Swing component.
        total.setText("PHP —");
        // Sets the font family, style and point size used to draw this component.
        total.setFont(new java.awt.Font("Segoe UI",1,30));
        // Sets the text or drawing color for this component.
        total.setForeground(new java.awt.Color(108,59,240));
        // Positions this component using x, y, width and height, measured in pixels.
        total.setBounds(24,194,390,43);
        // Adds this object to the collection or this child component to its parent container.
        summaryPanel.add(total);
        // Displays this text in the named Swing component.
        pay.setText("Pay & issue simulated ticket  →");
        // Sets the font family, style and point size used to draw this component.
        pay.setFont(new java.awt.Font("Segoe UI",1,14));
        // Sets the text or drawing color for this component.
        pay.setForeground(new java.awt.Color(255,255,255));
        // Sets this component color; the gradient start/end colors form the purple theme.
        pay.setBackground(new java.awt.Color(108,59,240));
        // Calls this operation to carry out the named step with the supplied arguments.
        pay.setFocusPainted(false);
        // Changes the pointer appearance to communicate an action or a busy operation.
        pay.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        // Positions this component using x, y, width and height, measured in pixels.
        pay.setBounds(24,259,388,48);
        // Adds this object to the collection or this child component to its parent container.
        summaryPanel.add(pay);
        // Positions this component using x, y, width and height, measured in pixels.
        summaryPanel.setBounds(706,254,436,330);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(summaryPanel);
        // Displays this text in the named Swing component.
        policy.setText("One seat per booking · Unused tickets can receive a simulated refund before the event starts.");
        // Sets the font family, style and point size used to draw this component.
        policy.setFont(new java.awt.Font("Segoe UI",0,13));
        // Sets the text or drawing color for this component.
        policy.setForeground(new java.awt.Color(130,124,145));
        // Positions this component using x, y, width and height, measured in pixels.
        policy.setBounds(32,611,1110,30);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(policy);
    }
    // </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Stores heading.
    public javax.swing.JLabel heading;
    // Stores subtitle.
    public javax.swing.JLabel subtitle;
    // Stores back.
    public javax.swing.JButton back;
    // Stores notice.
    public keeptoo.KGradientPanel notice;
    // Stores simulation.
    public javax.swing.JLabel simulation;
    // Stores payment panel.
    public javax.swing.JPanel paymentPanel;
    // Stores payment title.
    public javax.swing.JLabel paymentTitle;
    // Stores attendee.
    public javax.swing.JLabel attendee;
    // Stores method.
    public javax.swing.JComboBox method;
    // Stores safe.
    public javax.swing.JLabel safe;
    // Stores outcome.
    public javax.swing.JComboBox outcome;
    // Stores summary panel.
    public javax.swing.JPanel summaryPanel;
    // Stores summary title.
    public javax.swing.JLabel summaryTitle;
    // Stores summary.
    public javax.swing.JLabel summary;
    // Stores total.
    public javax.swing.JLabel total;
    // Stores pay.
    public javax.swing.JButton pay;
    // Stores policy.
    public javax.swing.JLabel policy;
    // End of variables declaration//GEN-END:variables
}
