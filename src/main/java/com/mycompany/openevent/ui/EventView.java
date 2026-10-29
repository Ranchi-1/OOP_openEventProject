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
    private void initComponents() {

        heading = new javax.swing.JLabel();
        subtitle = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        eventName = new javax.swing.JLabel();
        eventMeta = new javax.swing.JLabel();
        mapPanel = new javax.swing.JPanel();
        selectionPanel = new javax.swing.JPanel();
        selectionTitle = new javax.swing.JLabel();
        selectedSeat = new javax.swing.JLabel();
        pricingLabel = new javax.swing.JLabel();
        category = new javax.swing.JComboBox();
        price = new javax.swing.JLabel();
        checkout = new javax.swing.JButton();
        legend = new javax.swing.JLabel();
        description = new javax.swing.JLabel();

        setBackground(new java.awt.Color(247, 246, 251));
        setPreferredSize(new java.awt.Dimension(1176, 750));
        setLayout(null);

        heading.setText("Choose your seat");
        heading.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        heading.setForeground(new java.awt.Color(33, 27, 53));
        add(heading);
        heading.setBounds(32, 18, 1050, 40);

        subtitle.setText("Select one available seat. Your ticket is saved only after checkout.");
        subtitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        subtitle.setForeground(new java.awt.Color(130, 124, 145));
        add(subtitle);
        subtitle.setBounds(32, 60, 1050, 25);

        back.setBackground(new java.awt.Color(238, 232, 254));
        back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back.setForeground(new java.awt.Color(108, 59, 240));
        back.setText("← Discover");
        back.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(back);
        back.setBounds(32, 96, 155, 36);

        eventName.setText("Event");
        eventName.setFont(new java.awt.Font("Segoe UI", 1, 27)); // NOI18N
        eventName.setForeground(new java.awt.Color(33, 27, 53));
        add(eventName);
        eventName.setBounds(32, 148, 1070, 40);

        eventMeta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        eventMeta.setForeground(new java.awt.Color(130, 124, 145));
        eventMeta.setText("Date · Venue");
        add(eventMeta);
        eventMeta.setBounds(32, 195, 1080, 28);

        mapPanel.setBackground(new java.awt.Color(255, 255, 255));
        mapPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        mapPanel.setForeground(new java.awt.Color(33, 27, 53));
        mapPanel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mapPanel.setLayout(null);
        add(mapPanel);
        mapPanel.setBounds(32, 246, 745, 350);

        selectionPanel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectionPanel.setForeground(new java.awt.Color(33, 27, 53));
        selectionPanel.setBackground(new java.awt.Color(255, 255, 255));
        selectionPanel.setLayout(null);

        selectionTitle.setText("Your selection");
        selectionTitle.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        selectionTitle.setForeground(new java.awt.Color(33, 27, 53));
        selectionPanel.add(selectionTitle);
        selectionTitle.setBounds(22, 18, 300, 32);

        selectedSeat.setText("Select a seat on the map.");
        selectedSeat.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        selectedSeat.setForeground(new java.awt.Color(33, 27, 53));
        selectionPanel.add(selectedSeat);
        selectedSeat.setBounds(22, 72, 300, 40);

        pricingLabel.setText("Ticket option");
        pricingLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pricingLabel.setForeground(new java.awt.Color(33, 27, 53));
        selectionPanel.add(pricingLabel);
        pricingLabel.setBounds(22, 113, 280, 25);

        category.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        category.setForeground(new java.awt.Color(33, 27, 53));
        category.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "REGULAR" }));
        selectionPanel.add(category);
        category.setBounds(22, 144, 296, 40);

        price.setText("PHP —");
        price.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        price.setForeground(new java.awt.Color(108, 59, 240));
        selectionPanel.add(price);
        price.setBounds(22, 203, 300, 42);

        checkout.setText("Continue to checkout  →");
        checkout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        checkout.setForeground(new java.awt.Color(255, 255, 255));
        checkout.setBackground(new java.awt.Color(108, 59, 240));
        selectionPanel.add(checkout);
        checkout.setBounds(22, 271, 296, 48);

        add(selectionPanel);
        selectionPanel.setBounds(800, 246, 342, 350);

        legend.setText("● VIP     ● Regular     ■ Sold     □ Aisle     ■ Selected");
        legend.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        legend.setForeground(new java.awt.Color(130, 124, 145));
        add(legend);
        legend.setBounds(32, 608, 1070, 25);

        description.setText("Event details");
        description.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        description.setForeground(new java.awt.Color(130, 124, 145));
        add(description);
        description.setBounds(32, 650, 1100, 80);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton back;
    public javax.swing.JComboBox category;
    public javax.swing.JButton checkout;
    public javax.swing.JLabel description;
    public javax.swing.JLabel eventMeta;
    public javax.swing.JLabel eventName;
    public javax.swing.JLabel heading;
    public javax.swing.JLabel legend;
    public javax.swing.JPanel mapPanel;
    public javax.swing.JLabel price;
    public javax.swing.JLabel pricingLabel;
    public javax.swing.JLabel selectedSeat;
    public javax.swing.JPanel selectionPanel;
    public javax.swing.JLabel selectionTitle;
    public javax.swing.JLabel subtitle;
    // End of variables declaration//GEN-END:variables
}
