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
    private void initComponents() {

        heading = new javax.swing.JLabel();
        subtitle = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        notice = new keeptoo.KGradientPanel();
        simulation = new javax.swing.JLabel();
        paymentPanel = new javax.swing.JPanel();
        paymentTitle = new javax.swing.JLabel();
        attendee = new javax.swing.JLabel();
        method = new javax.swing.JComboBox();
        safe = new javax.swing.JLabel();
        outcome = new javax.swing.JComboBox();
        summaryPanel = new javax.swing.JPanel();
        summaryTitle = new javax.swing.JLabel();
        summary = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        pay = new javax.swing.JButton();
        policy = new javax.swing.JLabel();

        setBackground(new java.awt.Color(247, 246, 251));
        setPreferredSize(new java.awt.Dimension(1176, 660));
        setLayout(null);

        heading.setText("Review your booking");
        heading.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        heading.setForeground(new java.awt.Color(33, 27, 53));
        add(heading);
        heading.setBounds(32, 18, 1050, 40);

        subtitle.setText("Check the event, seat and price before confirming this simulated payment.");
        subtitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        subtitle.setForeground(new java.awt.Color(130, 124, 145));
        add(subtitle);
        subtitle.setBounds(32, 60, 1050, 25);

        back.setBackground(new java.awt.Color(238, 232, 254));
        back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back.setForeground(new java.awt.Color(108, 59, 240));
        back.setText("← Seat selection");
        back.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(back);
        back.setBounds(32, 102, 190, 36);

        notice.setForeground(new java.awt.Color(33, 27, 53));
        notice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        notice.setLayout(null);

        simulation.setText("SIMULATION ONLY · No real money will be collected.");
        simulation.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        simulation.setForeground(new java.awt.Color(255, 255, 255));
        notice.add(simulation);
        simulation.setBounds(20, 17, 1060, 32);

        add(notice);
        notice.setBounds(32, 158, 1110, 70);

        paymentPanel.setBackground(new java.awt.Color(255, 255, 255));
        paymentPanel.setForeground(new java.awt.Color(33, 27, 53));
        paymentPanel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        paymentPanel.setLayout(null);

        paymentTitle.setText("Payment method");
        paymentTitle.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        paymentTitle.setForeground(new java.awt.Color(33, 27, 53));
        paymentPanel.add(paymentTitle);
        paymentTitle.setBounds(24, 20, 600, 36);

        attendee.setText("Customer");
        attendee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        attendee.setForeground(new java.awt.Color(33, 27, 53));
        paymentPanel.add(attendee);
        attendee.setBounds(24, 76, 595, 30);

        method.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        method.setForeground(new java.awt.Color(33, 27, 53));
        method.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "E-wallet", "Credit card", "Cash" }));
        method.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        paymentPanel.add(method);
        method.setBounds(24, 132, 595, 40);

        safe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        safe.setForeground(new java.awt.Color(130, 124, 145));
        safe.setText("<html>Demo references are generated automatically.<br>No card number, wallet PIN or payment secrets are needed.</html>");
        paymentPanel.add(safe);
        safe.setBounds(24, 194, 595, 60);

        outcome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        outcome.setForeground(new java.awt.Color(33, 27, 53));
        outcome.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Simulate success", "Simulate decline" }));
        outcome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        paymentPanel.add(outcome);
        outcome.setBounds(24, 273, 595, 40);

        add(paymentPanel);
        paymentPanel.setBounds(32, 254, 650, 330);

        summaryPanel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        summaryPanel.setForeground(new java.awt.Color(33, 27, 53));
        summaryPanel.setBackground(new java.awt.Color(255, 255, 255));
        summaryPanel.setLayout(null);

        summaryTitle.setText("Your night, one seat away.");
        summaryTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        summaryTitle.setForeground(new java.awt.Color(33, 27, 53));
        summaryPanel.add(summaryTitle);
        summaryTitle.setBounds(24, 20, 390, 32);

        summary.setText("<html>Event<br>Seat<br>Category</html>");
        summary.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        summary.setForeground(new java.awt.Color(33, 27, 53));
        summaryPanel.add(summary);
        summary.setBounds(24, 76, 390, 110);

        total.setText("PHP —");
        total.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        total.setForeground(new java.awt.Color(108, 59, 240));
        summaryPanel.add(total);
        total.setBounds(24, 194, 390, 43);

        pay.setText("Pay & issue simulated ticket  →");
        pay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pay.setForeground(new java.awt.Color(255, 255, 255));
        pay.setBackground(new java.awt.Color(108, 59, 240));
        summaryPanel.add(pay);
        pay.setBounds(24, 259, 388, 48);

        add(summaryPanel);
        summaryPanel.setBounds(706, 254, 436, 330);

        policy.setText("One seat per booking · Unused tickets can receive a simulated refund before the event starts.");
        policy.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        policy.setForeground(new java.awt.Color(130, 124, 145));
        add(policy);
        policy.setBounds(32, 611, 1110, 30);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel attendee;
    public javax.swing.JButton back;
    public javax.swing.JLabel heading;
    public javax.swing.JComboBox method;
    public keeptoo.KGradientPanel notice;
    public javax.swing.JComboBox outcome;
    public javax.swing.JButton pay;
    public javax.swing.JPanel paymentPanel;
    public javax.swing.JLabel paymentTitle;
    public javax.swing.JLabel policy;
    public javax.swing.JLabel safe;
    public javax.swing.JLabel simulation;
    public javax.swing.JLabel subtitle;
    public javax.swing.JLabel summary;
    public javax.swing.JPanel summaryPanel;
    public javax.swing.JLabel summaryTitle;
    public javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
