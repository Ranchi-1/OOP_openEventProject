// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
package com.mycompany.openevent.ui;

/**
* NetBeans GUI Builder form. Edit layout in Design; behavior lives outside
* generated code.
*/
// Defines a class that inherits the fields and behavior of its parent type.
public class HostView extends javax.swing.JPanel {

    // Constructs a HostView object and initializes or validates its starting state.
    public HostView() {
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
        eventSelector=new javax.swing.JComboBox();
        // Updates this working value before the next step.
        refresh=new javax.swing.JButton();
        // Updates this working value before the next step.
        edit=new javax.swing.JButton();
        // Updates this working value before the next step.
        create=new javax.swing.JButton();
        // Updates this working value before the next step.
        hostBanner=new keeptoo.KGradientPanel();
        // Updates this working value before the next step.
        eventTitle=new javax.swing.JLabel();
        // Updates this working value before the next step.
        eventMeta=new javax.swing.JLabel();
        // Updates this working value before the next step.
        salesCard=new javax.swing.JPanel();
        // Updates this working value before the next step.
        salesLabel=new javax.swing.JLabel();
        // Updates this working value before the next step.
        sales=new javax.swing.JLabel();
        // Updates this working value before the next step.
        ticketsCard=new javax.swing.JPanel();
        // Updates this working value before the next step.
        ticketLabel=new javax.swing.JLabel();
        // Updates this working value before the next step.
        tickets=new javax.swing.JLabel();
        // Updates this working value before the next step.
        checkinsCard=new javax.swing.JPanel();
        // Updates this working value before the next step.
        checkinsLabel=new javax.swing.JLabel();
        // Updates this working value before the next step.
        checkins=new javax.swing.JLabel();
        // Updates this working value before the next step.
        checkinLabel=new javax.swing.JLabel();
        // Updates this working value before the next step.
        ticketCode=new javax.swing.JTextField();
        // Updates this working value before the next step.
        checkIn=new javax.swing.JButton();
        // Updates this working value before the next step.
        cancel=new javax.swing.JButton();
        // Updates this working value before the next step.
        tableScroll=new javax.swing.JScrollPane();
        // Updates this working value before the next step.
        checkinResult=new javax.swing.JLabel();
        // Calls this operation to carry out the named step with the supplied arguments.
        setLayout(null);
        // Calls this operation to carry out the named step with the supplied arguments.
        setBackground(new java.awt.Color(247,246,251));
        // Calls this operation to carry out the named step with the supplied arguments.
        setPreferredSize(new java.awt.Dimension(1176,780));
        // Displays this text in the named Swing component.
        heading.setText("Host dashboard");
        // Sets the font family, style and point size used to draw this component.
        heading.setFont(new java.awt.Font("Segoe UI",1,28));
        // Sets the text or drawing color for this component.
        heading.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        heading.setBounds(32,18,1050,40);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(heading);
        // Displays this text in the named Swing component.
        subtitle.setText("Choose an event to view bookings, manage the venue, or check in a guest.");
        // Sets the font family, style and point size used to draw this component.
        subtitle.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        subtitle.setForeground(new java.awt.Color(130,124,145));
        // Positions this component using x, y, width and height, measured in pixels.
        subtitle.setBounds(32,60,1050,25);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(subtitle);
        // Sets the font family, style and point size used to draw this component.
        eventSelector.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        eventSelector.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        eventSelector.setBackground(new java.awt.Color(255,255,255));
        // Supplies the list, combo-box or table data displayed by this control.
        eventSelector.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[]{}));
        // Positions this component using x, y, width and height, measured in pixels.
        eventSelector.setBounds(32,104,570,40);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(eventSelector);
        // Displays this text in the named Swing component.
        refresh.setText("Refresh");
        // Sets the font family, style and point size used to draw this component.
        refresh.setFont(new java.awt.Font("Segoe UI",1,14));
        // Sets the text or drawing color for this component.
        refresh.setForeground(new java.awt.Color(108,59,240));
        // Sets this component color; the gradient start/end colors form the purple theme.
        refresh.setBackground(new java.awt.Color(238,232,254));
        // Calls this operation to carry out the named step with the supplied arguments.
        refresh.setFocusPainted(false);
        // Changes the pointer appearance to communicate an action or a busy operation.
        refresh.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        // Positions this component using x, y, width and height, measured in pixels.
        refresh.setBounds(622,104,130,40);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(refresh);
        // Displays this text in the named Swing component.
        edit.setText("Edit event & venue");
        // Sets the font family, style and point size used to draw this component.
        edit.setFont(new java.awt.Font("Segoe UI",1,14));
        // Sets the text or drawing color for this component.
        edit.setForeground(new java.awt.Color(108,59,240));
        // Sets this component color; the gradient start/end colors form the purple theme.
        edit.setBackground(new java.awt.Color(238,232,254));
        // Calls this operation to carry out the named step with the supplied arguments.
        edit.setFocusPainted(false);
        // Changes the pointer appearance to communicate an action or a busy operation.
        edit.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        // Positions this component using x, y, width and height, measured in pixels.
        edit.setBounds(768,104,180,40);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(edit);
        // Displays this text in the named Swing component.
        create.setText("+ Create event");
        // Sets the font family, style and point size used to draw this component.
        create.setFont(new java.awt.Font("Segoe UI",1,14));
        // Sets the text or drawing color for this component.
        create.setForeground(new java.awt.Color(255,255,255));
        // Sets this component color; the gradient start/end colors form the purple theme.
        create.setBackground(new java.awt.Color(108,59,240));
        // Calls this operation to carry out the named step with the supplied arguments.
        create.setFocusPainted(false);
        // Changes the pointer appearance to communicate an action or a busy operation.
        create.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        // Positions this component using x, y, width and height, measured in pixels.
        create.setBounds(964,104,178,40);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(create);
        // Sets the font family, style and point size used to draw this component.
        hostBanner.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        hostBanner.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        hostBanner.setkStartColor(new java.awt.Color(129,59,240));
        // Sets this component color; the gradient start/end colors form the purple theme.
        hostBanner.setkEndColor(new java.awt.Color(67,55,217));
        // Chooses how child components are arranged inside this container.
        hostBanner.setLayout(null);
        // Displays this text in the named Swing component.
        eventTitle.setText("Your event overview");
        // Sets the font family, style and point size used to draw this component.
        eventTitle.setFont(new java.awt.Font("Segoe UI",1,23));
        // Sets the text or drawing color for this component.
        eventTitle.setForeground(new java.awt.Color(255,255,255));
        // Positions this component using x, y, width and height, measured in pixels.
        eventTitle.setBounds(20,12,1060,30);
        // Adds this object to the collection or this child component to its parent container.
        hostBanner.add(eventTitle);
        // Displays this text in the named Swing component.
        eventMeta.setText("Select an event to begin.");
        // Sets the font family, style and point size used to draw this component.
        eventMeta.setFont(new java.awt.Font("Segoe UI",0,13));
        // Sets the text or drawing color for this component.
        eventMeta.setForeground(new java.awt.Color(238,230,255));
        // Positions this component using x, y, width and height, measured in pixels.
        eventMeta.setBounds(20,48,1060,24);
        // Adds this object to the collection or this child component to its parent container.
        hostBanner.add(eventMeta);
        // Positions this component using x, y, width and height, measured in pixels.
        hostBanner.setBounds(32,165,1110,82);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(hostBanner);
        // Sets the font family, style and point size used to draw this component.
        salesCard.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        salesCard.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        salesCard.setBackground(new java.awt.Color(255,255,255));
        // Chooses how child components are arranged inside this container.
        salesCard.setLayout(null);
        // Displays this text in the named Swing component.
        salesLabel.setText("SIMULATED NET SALES");
        // Sets the font family, style and point size used to draw this component.
        salesLabel.setFont(new java.awt.Font("Segoe UI",1,12));
        // Sets the text or drawing color for this component.
        salesLabel.setForeground(new java.awt.Color(130,124,145));
        // Positions this component using x, y, width and height, measured in pixels.
        salesLabel.setBounds(18,10,320,22);
        // Adds this object to the collection or this child component to its parent container.
        salesCard.add(salesLabel);
        // Displays this text in the named Swing component.
        sales.setText("PHP 0.00");
        // Sets the font family, style and point size used to draw this component.
        sales.setFont(new java.awt.Font("Segoe UI",1,28));
        // Sets the text or drawing color for this component.
        sales.setForeground(new java.awt.Color(108,59,240));
        // Positions this component using x, y, width and height, measured in pixels.
        sales.setBounds(18,40,320,40);
        // Adds this object to the collection or this child component to its parent container.
        salesCard.add(sales);
        // Positions this component using x, y, width and height, measured in pixels.
        salesCard.setBounds(32,267,355,94);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(salesCard);
        // Sets the font family, style and point size used to draw this component.
        ticketsCard.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        ticketsCard.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        ticketsCard.setBackground(new java.awt.Color(255,255,255));
        // Chooses how child components are arranged inside this container.
        ticketsCard.setLayout(null);
        // Displays this text in the named Swing component.
        ticketLabel.setText("TICKETS / CAPACITY");
        // Sets the font family, style and point size used to draw this component.
        ticketLabel.setFont(new java.awt.Font("Segoe UI",1,12));
        // Sets the text or drawing color for this component.
        ticketLabel.setForeground(new java.awt.Color(130,124,145));
        // Positions this component using x, y, width and height, measured in pixels.
        ticketLabel.setBounds(18,10,320,22);
        // Adds this object to the collection or this child component to its parent container.
        ticketsCard.add(ticketLabel);
        // Displays this text in the named Swing component.
        tickets.setText("0 / 0");
        // Sets the font family, style and point size used to draw this component.
        tickets.setFont(new java.awt.Font("Segoe UI",1,28));
        // Sets the text or drawing color for this component.
        tickets.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        tickets.setBounds(18,40,320,40);
        // Adds this object to the collection or this child component to its parent container.
        ticketsCard.add(tickets);
        // Positions this component using x, y, width and height, measured in pixels.
        ticketsCard.setBounds(410,267,355,94);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(ticketsCard);
        // Sets the font family, style and point size used to draw this component.
        checkinsCard.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        checkinsCard.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        checkinsCard.setBackground(new java.awt.Color(255,255,255));
        // Chooses how child components are arranged inside this container.
        checkinsCard.setLayout(null);
        // Displays this text in the named Swing component.
        checkinsLabel.setText("CHECKED IN");
        // Sets the font family, style and point size used to draw this component.
        checkinsLabel.setFont(new java.awt.Font("Segoe UI",1,12));
        // Sets the text or drawing color for this component.
        checkinsLabel.setForeground(new java.awt.Color(130,124,145));
        // Positions this component using x, y, width and height, measured in pixels.
        checkinsLabel.setBounds(18,10,320,22);
        // Adds this object to the collection or this child component to its parent container.
        checkinsCard.add(checkinsLabel);
        // Displays this text in the named Swing component.
        checkins.setText("0");
        // Sets the font family, style and point size used to draw this component.
        checkins.setFont(new java.awt.Font("Segoe UI",1,28));
        // Sets the text or drawing color for this component.
        checkins.setForeground(new java.awt.Color(35,141,130));
        // Positions this component using x, y, width and height, measured in pixels.
        checkins.setBounds(18,40,320,40);
        // Adds this object to the collection or this child component to its parent container.
        checkinsCard.add(checkins);
        // Positions this component using x, y, width and height, measured in pixels.
        checkinsCard.setBounds(788,267,354,94);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(checkinsCard);
        // Displays this text in the named Swing component.
        checkinLabel.setText("Let your people in.");
        // Sets the font family, style and point size used to draw this component.
        checkinLabel.setFont(new java.awt.Font("Segoe UI",1,22));
        // Sets the text or drawing color for this component.
        checkinLabel.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        checkinLabel.setBounds(32,386,760,30);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(checkinLabel);
        // Sets the font family, style and point size used to draw this component.
        ticketCode.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        ticketCode.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        ticketCode.setBackground(new java.awt.Color(255,255,255));
        // Positions this component using x, y, width and height, measured in pixels.
        ticketCode.setBounds(32,431,570,42);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(ticketCode);
        // Displays this text in the named Swing component.
        checkIn.setText("Validate & check in  →");
        // Sets the font family, style and point size used to draw this component.
        checkIn.setFont(new java.awt.Font("Segoe UI",1,14));
        // Sets the text or drawing color for this component.
        checkIn.setForeground(new java.awt.Color(255,255,255));
        // Sets this component color; the gradient start/end colors form the purple theme.
        checkIn.setBackground(new java.awt.Color(108,59,240));
        // Calls this operation to carry out the named step with the supplied arguments.
        checkIn.setFocusPainted(false);
        // Changes the pointer appearance to communicate an action or a busy operation.
        checkIn.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        // Positions this component using x, y, width and height, measured in pixels.
        checkIn.setBounds(622,431,284,42);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(checkIn);
        // Displays this text in the named Swing component.
        cancel.setText("Refund selected");
        // Sets the font family, style and point size used to draw this component.
        cancel.setFont(new java.awt.Font("Segoe UI",1,14));
        // Sets the text or drawing color for this component.
        cancel.setForeground(new java.awt.Color(108,59,240));
        // Sets this component color; the gradient start/end colors form the purple theme.
        cancel.setBackground(new java.awt.Color(238,232,254));
        // Calls this operation to carry out the named step with the supplied arguments.
        cancel.setFocusPainted(false);
        // Changes the pointer appearance to communicate an action or a busy operation.
        cancel.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        // Positions this component using x, y, width and height, measured in pixels.
        cancel.setBounds(924,431,218,42);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(cancel);
        // Sets the font family, style and point size used to draw this component.
        tableScroll.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        tableScroll.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        tableScroll.setBackground(new java.awt.Color(255,255,255));
        // Positions this component using x, y, width and height, measured in pixels.
        tableScroll.setBounds(32,495,1110,220);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(tableScroll);
        // Displays this text in the named Swing component.
        checkinResult.setText("A ticket can be checked in once. Refresh to see updated records.");
        // Sets the font family, style and point size used to draw this component.
        checkinResult.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        checkinResult.setForeground(new java.awt.Color(130,124,145));
        // Positions this component using x, y, width and height, measured in pixels.
        checkinResult.setBounds(32,734,1110,30);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(checkinResult);
    }
    // </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Stores heading.
    public javax.swing.JLabel heading;
    // Stores subtitle.
    public javax.swing.JLabel subtitle;
    // Stores event selector.
    public javax.swing.JComboBox eventSelector;
    // Stores refresh.
    public javax.swing.JButton refresh;
    // Stores edit.
    public javax.swing.JButton edit;
    // Stores create.
    public javax.swing.JButton create;
    // Stores host banner.
    public keeptoo.KGradientPanel hostBanner;
    // Stores event title.
    public javax.swing.JLabel eventTitle;
    // Stores event meta.
    public javax.swing.JLabel eventMeta;
    // Stores sales card.
    public javax.swing.JPanel salesCard;
    // Stores sales label.
    public javax.swing.JLabel salesLabel;
    // Stores sales.
    public javax.swing.JLabel sales;
    // Stores tickets card.
    public javax.swing.JPanel ticketsCard;
    // Stores ticket label.
    public javax.swing.JLabel ticketLabel;
    // Stores tickets.
    public javax.swing.JLabel tickets;
    // Stores checkins card.
    public javax.swing.JPanel checkinsCard;
    // Stores checkins label.
    public javax.swing.JLabel checkinsLabel;
    // Stores checkins.
    public javax.swing.JLabel checkins;
    // Stores checkin label.
    public javax.swing.JLabel checkinLabel;
    // Stores ticket code.
    public javax.swing.JTextField ticketCode;
    // Stores check in.
    public javax.swing.JButton checkIn;
    // Stores cancel.
    public javax.swing.JButton cancel;
    // Stores table scroll.
    public javax.swing.JScrollPane tableScroll;
    // Stores checkin result.
    public javax.swing.JLabel checkinResult;
    // End of variables declaration//GEN-END:variables
}
