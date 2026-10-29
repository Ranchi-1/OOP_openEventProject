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
    private void initComponents() {

        heading = new javax.swing.JLabel();
        subtitle = new javax.swing.JLabel();
        eventSelector = new javax.swing.JComboBox();
        refresh = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        create = new javax.swing.JButton();
        hostBanner = new keeptoo.KGradientPanel();
        eventTitle = new javax.swing.JLabel();
        eventMeta = new javax.swing.JLabel();
        salesCard = new javax.swing.JPanel();
        salesLabel = new javax.swing.JLabel();
        sales = new javax.swing.JLabel();
        ticketsCard = new javax.swing.JPanel();
        ticketLabel = new javax.swing.JLabel();
        tickets = new javax.swing.JLabel();
        checkinsCard = new javax.swing.JPanel();
        checkinsLabel = new javax.swing.JLabel();
        checkins = new javax.swing.JLabel();
        checkinLabel = new javax.swing.JLabel();
        ticketCode = new javax.swing.JTextField();
        checkIn = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        tableScroll = new javax.swing.JScrollPane();
        checkinResult = new javax.swing.JLabel();

        setBackground(new java.awt.Color(247, 246, 251));
        setPreferredSize(new java.awt.Dimension(1176, 780));
        setLayout(null);

        heading.setText("Host dashboard");
        heading.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        heading.setForeground(new java.awt.Color(33, 27, 53));
        add(heading);
        heading.setBounds(32, 18, 1050, 40);

        subtitle.setText("Choose an event to view bookings, manage the venue, or check in a guest.");
        subtitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        subtitle.setForeground(new java.awt.Color(130, 124, 145));
        add(subtitle);
        subtitle.setBounds(32, 60, 1050, 25);

        eventSelector.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        eventSelector.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(eventSelector);
        eventSelector.setBounds(32, 104, 570, 40);

        refresh.setText("Refresh");
        refresh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        refresh.setForeground(new java.awt.Color(108, 59, 240));
        refresh.setBackground(new java.awt.Color(238, 232, 254));
        add(refresh);
        refresh.setBounds(622, 104, 130, 40);

        edit.setText("Edit event & venue");
        edit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        edit.setForeground(new java.awt.Color(108, 59, 240));
        edit.setBackground(new java.awt.Color(238, 232, 254));
        add(edit);
        edit.setBounds(768, 104, 180, 40);

        create.setText("+ Create event");
        create.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        create.setForeground(new java.awt.Color(255, 255, 255));
        create.setBackground(new java.awt.Color(108, 59, 240));
        add(create);
        create.setBounds(964, 104, 178, 40);

        hostBanner.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        hostBanner.setForeground(new java.awt.Color(33, 27, 53));
        hostBanner.setLayout(null);

        eventTitle.setText("Your event overview");
        eventTitle.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        eventTitle.setForeground(new java.awt.Color(255, 255, 255));
        hostBanner.add(eventTitle);
        eventTitle.setBounds(20, 12, 1060, 30);

        eventMeta.setText("Select an event to begin.");
        eventMeta.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        eventMeta.setForeground(new java.awt.Color(238, 230, 255));
        hostBanner.add(eventMeta);
        eventMeta.setBounds(20, 48, 1060, 24);

        add(hostBanner);
        hostBanner.setBounds(32, 165, 1110, 82);

        salesCard.setBackground(new java.awt.Color(255, 255, 255));
        salesCard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        salesCard.setForeground(new java.awt.Color(33, 27, 53));
        salesCard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        salesCard.setLayout(null);

        salesLabel.setText("SIMULATED NET SALES");
        salesLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        salesLabel.setForeground(new java.awt.Color(130, 124, 145));
        salesCard.add(salesLabel);
        salesLabel.setBounds(18, 10, 320, 22);

        sales.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        sales.setForeground(new java.awt.Color(108, 59, 240));
        sales.setText("PHP 0.00");
        salesCard.add(sales);
        sales.setBounds(18, 40, 320, 40);

        add(salesCard);
        salesCard.setBounds(32, 267, 355, 94);

        ticketsCard.setBackground(new java.awt.Color(255, 255, 255));
        ticketsCard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ticketsCard.setForeground(new java.awt.Color(33, 27, 53));
        ticketsCard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ticketsCard.setLayout(null);

        ticketLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ticketLabel.setForeground(new java.awt.Color(130, 124, 145));
        ticketLabel.setText("TICKETS / CAPACITY");
        ticketsCard.add(ticketLabel);
        ticketLabel.setBounds(18, 10, 320, 22);

        tickets.setText("0 / 0");
        tickets.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        tickets.setForeground(new java.awt.Color(33, 27, 53));
        ticketsCard.add(tickets);
        tickets.setBounds(18, 40, 320, 40);

        add(ticketsCard);
        ticketsCard.setBounds(410, 267, 355, 94);

        checkinsCard.setBackground(new java.awt.Color(255, 255, 255));
        checkinsCard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        checkinsCard.setForeground(new java.awt.Color(33, 27, 53));
        checkinsCard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkinsCard.setLayout(null);

        checkinsLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        checkinsLabel.setForeground(new java.awt.Color(130, 124, 145));
        checkinsLabel.setText("CHECKED IN");
        checkinsCard.add(checkinsLabel);
        checkinsLabel.setBounds(18, 10, 320, 22);

        checkins.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        checkins.setForeground(new java.awt.Color(35, 141, 130));
        checkins.setText("0");
        checkinsCard.add(checkins);
        checkins.setBounds(18, 40, 320, 40);

        add(checkinsCard);
        checkinsCard.setBounds(788, 267, 354, 94);

        checkinLabel.setText("Let your people in.");
        checkinLabel.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        checkinLabel.setForeground(new java.awt.Color(33, 27, 53));
        add(checkinLabel);
        checkinLabel.setBounds(32, 386, 760, 30);

        ticketCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ticketCode.setForeground(new java.awt.Color(33, 27, 53));
        ticketCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(ticketCode);
        ticketCode.setBounds(32, 431, 570, 42);

        checkIn.setText("Validate & check in  →");
        checkIn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        checkIn.setForeground(new java.awt.Color(255, 255, 255));
        checkIn.setBackground(new java.awt.Color(108, 59, 240));
        add(checkIn);
        checkIn.setBounds(622, 431, 284, 42);

        cancel.setText("Refund selected");
        cancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancel.setForeground(new java.awt.Color(108, 59, 240));
        cancel.setBackground(new java.awt.Color(238, 232, 254));
        add(cancel);
        cancel.setBounds(924, 431, 218, 42);

        tableScroll.setBackground(new java.awt.Color(255, 255, 255));
        tableScroll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tableScroll.setForeground(new java.awt.Color(33, 27, 53));
        tableScroll.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(tableScroll);
        tableScroll.setBounds(32, 495, 1110, 220);

        checkinResult.setText("A ticket can be checked in once. Refresh to see updated records.");
        checkinResult.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkinResult.setForeground(new java.awt.Color(130, 124, 145));
        add(checkinResult);
        checkinResult.setBounds(32, 734, 1110, 30);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton cancel;
    public javax.swing.JButton checkIn;
    public javax.swing.JLabel checkinLabel;
    public javax.swing.JLabel checkinResult;
    public javax.swing.JLabel checkins;
    public javax.swing.JPanel checkinsCard;
    public javax.swing.JLabel checkinsLabel;
    public javax.swing.JButton create;
    public javax.swing.JButton edit;
    public javax.swing.JLabel eventMeta;
    public javax.swing.JComboBox eventSelector;
    public javax.swing.JLabel eventTitle;
    public javax.swing.JLabel heading;
    public keeptoo.KGradientPanel hostBanner;
    public javax.swing.JButton refresh;
    public javax.swing.JLabel sales;
    public javax.swing.JPanel salesCard;
    public javax.swing.JLabel salesLabel;
    public javax.swing.JLabel subtitle;
    public javax.swing.JScrollPane tableScroll;
    public javax.swing.JTextField ticketCode;
    public javax.swing.JLabel ticketLabel;
    public javax.swing.JLabel tickets;
    public javax.swing.JPanel ticketsCard;
    // End of variables declaration//GEN-END:variables
}
