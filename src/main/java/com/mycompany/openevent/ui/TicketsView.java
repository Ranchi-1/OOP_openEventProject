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
    private void initComponents() {

        heading = new javax.swing.JLabel();
        subtitle = new javax.swing.JLabel();
        refresh = new javax.swing.JButton();
        ticketScroll = new javax.swing.JScrollPane();
        ticketBanner = new keeptoo.KGradientPanel();
        bannerText = new javax.swing.JLabel();
        ticketPanel = new javax.swing.JPanel();
        ticketTitle = new javax.swing.JLabel();
        ticketMeta = new javax.swing.JLabel();
        ticketCode = new javax.swing.JLabel();
        ticketState = new javax.swing.JLabel();
        receiptPanel = new javax.swing.JPanel();
        receiptTitle = new javax.swing.JLabel();
        receiptDetails = new javax.swing.JLabel();
        export = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        setBackground(new java.awt.Color(247, 246, 251));
        setPreferredSize(new java.awt.Dimension(1176, 660));
        setLayout(null);

        heading.setText("My tickets");
        heading.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        heading.setForeground(new java.awt.Color(33, 27, 53));
        add(heading);
        heading.setBounds(32, 18, 1050, 40);

        subtitle.setText("Choose a saved ticket to view its status and receipt.");
        subtitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        subtitle.setForeground(new java.awt.Color(130, 124, 145));
        add(subtitle);
        subtitle.setBounds(32, 60, 1050, 25);

        refresh.setBackground(new java.awt.Color(238, 232, 254));
        refresh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        refresh.setForeground(new java.awt.Color(108, 59, 240));
        refresh.setText("Refresh tickets");
        refresh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(refresh);
        refresh.setBounds(946, 100, 196, 38);

        ticketScroll.setBackground(new java.awt.Color(255, 255, 255));
        ticketScroll.setForeground(new java.awt.Color(33, 27, 53));
        ticketScroll.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(ticketScroll);
        ticketScroll.setBounds(32, 100, 886, 145);

        ticketBanner.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ticketBanner.setForeground(new java.awt.Color(33, 27, 53));
        ticketBanner.setLayout(null);

        bannerText.setText("YOUR TICKET · Saved and ready when you are.");
        bannerText.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        bannerText.setForeground(new java.awt.Color(255, 255, 255));
        ticketBanner.add(bannerText);
        bannerText.setBounds(20, 16, 1060, 34);

        add(ticketBanner);
        ticketBanner.setBounds(32, 270, 1110, 68);

        ticketPanel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ticketPanel.setForeground(new java.awt.Color(33, 27, 53));
        ticketPanel.setBackground(new java.awt.Color(255, 255, 255));
        ticketPanel.setLayout(null);

        ticketTitle.setText("Choose a ticket above");
        ticketTitle.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        ticketTitle.setForeground(new java.awt.Color(33, 27, 53));
        ticketPanel.add(ticketTitle);
        ticketTitle.setBounds(22, 18, 600, 40);

        ticketMeta.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        ticketMeta.setForeground(new java.awt.Color(130, 124, 145));
        ticketPanel.add(ticketMeta);
        ticketMeta.setBounds(22, 66, 600, 78);

        ticketCode.setText("OE-XXXXXXXXXXXX");
        ticketCode.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        ticketCode.setForeground(new java.awt.Color(108, 59, 240));
        ticketPanel.add(ticketCode);
        ticketCode.setBounds(22, 151, 600, 42);

        ticketState.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ticketState.setForeground(new java.awt.Color(35, 141, 130));
        ticketPanel.add(ticketState);
        ticketState.setBounds(22, 208, 600, 28);

        add(ticketPanel);
        ticketPanel.setBounds(32, 363, 646, 260);

        receiptPanel.setBackground(new java.awt.Color(255, 255, 255));
        receiptPanel.setForeground(new java.awt.Color(33, 27, 53));
        receiptPanel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        receiptPanel.setLayout(null);

        receiptTitle.setText("Payment receipt");
        receiptTitle.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        receiptTitle.setForeground(new java.awt.Color(33, 27, 53));
        receiptPanel.add(receiptTitle);
        receiptTitle.setBounds(20, 16, 400, 30);

        receiptDetails.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        receiptDetails.setForeground(new java.awt.Color(130, 124, 145));
        receiptPanel.add(receiptDetails);
        receiptDetails.setBounds(20, 59, 400, 118);

        export.setBackground(new java.awt.Color(238, 232, 254));
        export.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        export.setForeground(new java.awt.Color(108, 59, 240));
        export.setText("Save receipt");
        export.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        receiptPanel.add(export);
        export.setBounds(20, 194, 188, 42);

        cancel.setBackground(new java.awt.Color(238, 232, 254));
        cancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancel.setForeground(new java.awt.Color(108, 59, 240));
        cancel.setText("Cancel & refund");
        cancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        receiptPanel.add(cancel);
        cancel.setBounds(220, 194, 198, 42);

        add(receiptPanel);
        receiptPanel.setBounds(702, 363, 440, 260);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel bannerText;
    public javax.swing.JButton cancel;
    public javax.swing.JButton export;
    public javax.swing.JLabel heading;
    public javax.swing.JLabel receiptDetails;
    public javax.swing.JPanel receiptPanel;
    public javax.swing.JLabel receiptTitle;
    public javax.swing.JButton refresh;
    public javax.swing.JLabel subtitle;
    public keeptoo.KGradientPanel ticketBanner;
    public javax.swing.JLabel ticketCode;
    public javax.swing.JLabel ticketMeta;
    public javax.swing.JPanel ticketPanel;
    public javax.swing.JScrollPane ticketScroll;
    public javax.swing.JLabel ticketState;
    public javax.swing.JLabel ticketTitle;
    // End of variables declaration//GEN-END:variables
}
