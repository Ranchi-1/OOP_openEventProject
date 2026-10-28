// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
package com.mycompany.openevent.ui;

/**
* NetBeans GUI Builder form. Edit layout in Design; behavior lives outside
* generated code.
*/
// Defines a class that inherits the fields and behavior of its parent type.
public class TicketsView extends javax.swing.JPanel {

    // Constructs a TicketsView object and initializes or validates its starting state.
    public TicketsView() {
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
        refresh=new javax.swing.JButton();
        // Updates this working value before the next step.
        ticketScroll=new javax.swing.JScrollPane();
        // Updates this working value before the next step.
        ticketBanner=new keeptoo.KGradientPanel();
        // Updates this working value before the next step.
        bannerText=new javax.swing.JLabel();
        // Updates this working value before the next step.
        ticketPanel=new javax.swing.JPanel();
        // Updates this working value before the next step.
        ticketTitle=new javax.swing.JLabel();
        // Updates this working value before the next step.
        ticketMeta=new javax.swing.JLabel();
        // Updates this working value before the next step.
        ticketCode=new javax.swing.JLabel();
        // Updates this working value before the next step.
        ticketState=new javax.swing.JLabel();
        // Updates this working value before the next step.
        receiptPanel=new javax.swing.JPanel();
        // Updates this working value before the next step.
        receiptTitle=new javax.swing.JLabel();
        // Updates this working value before the next step.
        receiptDetails=new javax.swing.JLabel();
        // Updates this working value before the next step.
        export=new javax.swing.JButton();
        // Updates this working value before the next step.
        cancel=new javax.swing.JButton();
        // Calls this operation to carry out the named step with the supplied arguments.
        setLayout(null);
        // Calls this operation to carry out the named step with the supplied arguments.
        setBackground(new java.awt.Color(247,246,251));
        // Calls this operation to carry out the named step with the supplied arguments.
        setPreferredSize(new java.awt.Dimension(1176,660));
        // Displays this text in the named Swing component.
        heading.setText("My tickets");
        // Sets the font family, style and point size used to draw this component.
        heading.setFont(new java.awt.Font("Segoe UI",1,28));
        // Sets the text or drawing color for this component.
        heading.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        heading.setBounds(32,18,1050,40);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(heading);
        // Displays this text in the named Swing component.
        subtitle.setText("Choose a saved ticket to view its status and receipt.");
        // Sets the font family, style and point size used to draw this component.
        subtitle.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        subtitle.setForeground(new java.awt.Color(130,124,145));
        // Positions this component using x, y, width and height, measured in pixels.
        subtitle.setBounds(32,60,1050,25);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(subtitle);
        // Displays this text in the named Swing component.
        refresh.setText("Refresh tickets");
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
        refresh.setBounds(946,100,196,38);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(refresh);
        // Sets the font family, style and point size used to draw this component.
        ticketScroll.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        ticketScroll.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        ticketScroll.setBackground(new java.awt.Color(255,255,255));
        // Positions this component using x, y, width and height, measured in pixels.
        ticketScroll.setBounds(32,100,886,145);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(ticketScroll);
        // Sets the font family, style and point size used to draw this component.
        ticketBanner.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        ticketBanner.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        ticketBanner.setkStartColor(new java.awt.Color(129,59,240));
        // Sets this component color; the gradient start/end colors form the purple theme.
        ticketBanner.setkEndColor(new java.awt.Color(67,55,217));
        // Chooses how child components are arranged inside this container.
        ticketBanner.setLayout(null);
        // Displays this text in the named Swing component.
        bannerText.setText("YOUR TICKET · Saved and ready when you are.");
        // Sets the font family, style and point size used to draw this component.
        bannerText.setFont(new java.awt.Font("Segoe UI",1,19));
        // Sets the text or drawing color for this component.
        bannerText.setForeground(new java.awt.Color(255,255,255));
        // Positions this component using x, y, width and height, measured in pixels.
        bannerText.setBounds(20,16,1060,34);
        // Adds this object to the collection or this child component to its parent container.
        ticketBanner.add(bannerText);
        // Positions this component using x, y, width and height, measured in pixels.
        ticketBanner.setBounds(32,270,1110,68);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(ticketBanner);
        // Sets the font family, style and point size used to draw this component.
        ticketPanel.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        ticketPanel.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        ticketPanel.setBackground(new java.awt.Color(255,255,255));
        // Chooses how child components are arranged inside this container.
        ticketPanel.setLayout(null);
        // Displays this text in the named Swing component.
        ticketTitle.setText("Choose a ticket above");
        // Sets the font family, style and point size used to draw this component.
        ticketTitle.setFont(new java.awt.Font("Segoe UI",1,25));
        // Sets the text or drawing color for this component.
        ticketTitle.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        ticketTitle.setBounds(22,18,600,40);
        // Adds this object to the collection or this child component to its parent container.
        ticketPanel.add(ticketTitle);
        // Displays this text in the named Swing component.
        ticketMeta.setText("");
        // Sets the font family, style and point size used to draw this component.
        ticketMeta.setFont(new java.awt.Font("Segoe UI",0,15));
        // Sets the text or drawing color for this component.
        ticketMeta.setForeground(new java.awt.Color(130,124,145));
        // Positions this component using x, y, width and height, measured in pixels.
        ticketMeta.setBounds(22,66,600,78);
        // Adds this object to the collection or this child component to its parent container.
        ticketPanel.add(ticketMeta);
        // Displays this text in the named Swing component.
        ticketCode.setText("OE-XXXXXXXXXXXX");
        // Sets the font family, style and point size used to draw this component.
        ticketCode.setFont(new java.awt.Font("Segoe UI",1,25));
        // Sets the text or drawing color for this component.
        ticketCode.setForeground(new java.awt.Color(108,59,240));
        // Positions this component using x, y, width and height, measured in pixels.
        ticketCode.setBounds(22,151,600,42);
        // Adds this object to the collection or this child component to its parent container.
        ticketPanel.add(ticketCode);
        // Displays this text in the named Swing component.
        ticketState.setText("");
        // Sets the font family, style and point size used to draw this component.
        ticketState.setFont(new java.awt.Font("Segoe UI",1,14));
        // Sets the text or drawing color for this component.
        ticketState.setForeground(new java.awt.Color(35,141,130));
        // Positions this component using x, y, width and height, measured in pixels.
        ticketState.setBounds(22,208,600,28);
        // Adds this object to the collection or this child component to its parent container.
        ticketPanel.add(ticketState);
        // Positions this component using x, y, width and height, measured in pixels.
        ticketPanel.setBounds(32,363,646,260);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(ticketPanel);
        // Sets the font family, style and point size used to draw this component.
        receiptPanel.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        receiptPanel.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        receiptPanel.setBackground(new java.awt.Color(255,255,255));
        // Chooses how child components are arranged inside this container.
        receiptPanel.setLayout(null);
        // Displays this text in the named Swing component.
        receiptTitle.setText("Payment receipt");
        // Sets the font family, style and point size used to draw this component.
        receiptTitle.setFont(new java.awt.Font("Segoe UI",1,21));
        // Sets the text or drawing color for this component.
        receiptTitle.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        receiptTitle.setBounds(20,16,400,30);
        // Adds this object to the collection or this child component to its parent container.
        receiptPanel.add(receiptTitle);
        // Displays this text in the named Swing component.
        receiptDetails.setText("");
        // Sets the font family, style and point size used to draw this component.
        receiptDetails.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        receiptDetails.setForeground(new java.awt.Color(130,124,145));
        // Positions this component using x, y, width and height, measured in pixels.
        receiptDetails.setBounds(20,59,400,118);
        // Adds this object to the collection or this child component to its parent container.
        receiptPanel.add(receiptDetails);
        // Displays this text in the named Swing component.
        export.setText("Save receipt");
        // Sets the font family, style and point size used to draw this component.
        export.setFont(new java.awt.Font("Segoe UI",1,14));
        // Sets the text or drawing color for this component.
        export.setForeground(new java.awt.Color(108,59,240));
        // Sets this component color; the gradient start/end colors form the purple theme.
        export.setBackground(new java.awt.Color(238,232,254));
        // Calls this operation to carry out the named step with the supplied arguments.
        export.setFocusPainted(false);
        // Changes the pointer appearance to communicate an action or a busy operation.
        export.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        // Positions this component using x, y, width and height, measured in pixels.
        export.setBounds(20,194,188,42);
        // Adds this object to the collection or this child component to its parent container.
        receiptPanel.add(export);
        // Displays this text in the named Swing component.
        cancel.setText("Cancel & refund");
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
        cancel.setBounds(220,194,198,42);
        // Adds this object to the collection or this child component to its parent container.
        receiptPanel.add(cancel);
        // Positions this component using x, y, width and height, measured in pixels.
        receiptPanel.setBounds(702,363,440,260);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(receiptPanel);
    }
    // </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Stores heading.
    public javax.swing.JLabel heading;
    // Stores subtitle.
    public javax.swing.JLabel subtitle;
    // Stores refresh.
    public javax.swing.JButton refresh;
    // Stores ticket scroll.
    public javax.swing.JScrollPane ticketScroll;
    // Stores ticket banner.
    public keeptoo.KGradientPanel ticketBanner;
    // Stores banner text.
    public javax.swing.JLabel bannerText;
    // Stores ticket panel.
    public javax.swing.JPanel ticketPanel;
    // Stores ticket title.
    public javax.swing.JLabel ticketTitle;
    // Stores ticket meta.
    public javax.swing.JLabel ticketMeta;
    // Stores ticket code.
    public javax.swing.JLabel ticketCode;
    // Stores ticket state.
    public javax.swing.JLabel ticketState;
    // Stores receipt panel.
    public javax.swing.JPanel receiptPanel;
    // Stores receipt title.
    public javax.swing.JLabel receiptTitle;
    // Stores receipt details.
    public javax.swing.JLabel receiptDetails;
    // Stores export.
    public javax.swing.JButton export;
    // Stores cancel.
    public javax.swing.JButton cancel;
    // End of variables declaration//GEN-END:variables
}
