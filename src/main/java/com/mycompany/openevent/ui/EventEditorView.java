package com.mycompany.openevent.ui;

/**
 * NetBeans GUI Builder form. Edit layout in Design; behavior lives outside
 * generated code.
 */
// Defines a class that inherits the fields and behavior of its parent type.
public class EventEditorView extends javax.swing.JPanel {

    // Constructs a EventEditorView object and initializes or validates its starting state.
    public EventEditorView() {
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
        protection = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        eventName = new javax.swing.JTextField();
        venueLabel = new javax.swing.JLabel();
        venue = new javax.swing.JTextField();
        typeLabel = new javax.swing.JLabel();
        eventType = new javax.swing.JComboBox();
        priceLabel = new javax.swing.JLabel();
        basePrice = new javax.swing.JTextField();
        startsLabel = new javax.swing.JLabel();
        startsAt = new javax.swing.JTextField();
        earlyLabel = new javax.swing.JLabel();
        earlyBird = new javax.swing.JTextField();
        descriptionLabel = new javax.swing.JLabel();
        description = new javax.swing.JTextField();
        imageLabel = new javax.swing.JLabel();
        image = new javax.swing.JComboBox();
        rowsLabel = new javax.swing.JLabel();
        rows = new javax.swing.JSpinner();
        columnsLabel = new javax.swing.JLabel();
        columns = new javax.swing.JSpinner();
        stageRowLabel = new javax.swing.JLabel();
        stageRow = new javax.swing.JSpinner();
        stageColLabel = new javax.swing.JLabel();
        stageCol = new javax.swing.JSpinner();
        stageWidthLabel = new javax.swing.JLabel();
        stageWidth = new javax.swing.JSpinner();
        rebuild = new javax.swing.JButton();
        vipColor = new javax.swing.JButton();
        regularColor = new javax.swing.JButton();
        gridHelp = new javax.swing.JLabel();
        gridPanel = new javax.swing.JPanel();
        pricingRule = new javax.swing.JLabel();
        published = new javax.swing.JCheckBox();
        save = new javax.swing.JButton();

        setBackground(new java.awt.Color(247, 246, 251));
        setPreferredSize(new java.awt.Dimension(1176, 1030));
        setLayout(null);

        heading.setText("Event editor");
        heading.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        heading.setForeground(new java.awt.Color(33, 27, 53));
        add(heading);
        heading.setBounds(32, 18, 1050, 40);

        subtitle.setText("Set the event details, then configure a color-coded grid for your venue.");
        subtitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        subtitle.setForeground(new java.awt.Color(130, 124, 145));
        add(subtitle);
        subtitle.setBounds(32, 60, 1050, 25);

        back.setBackground(new java.awt.Color(238, 232, 254));
        back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back.setForeground(new java.awt.Color(108, 59, 240));
        back.setText("← Host dashboard");
        back.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(back);
        back.setBounds(32, 102, 190, 36);

        protection.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        protection.setForeground(new java.awt.Color(35, 141, 130));
        add(protection);
        protection.setBounds(244, 105, 900, 30);

        nameLabel.setText("Event title");
        nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(33, 27, 53));
        add(nameLabel);
        nameLabel.setBounds(32, 158, 400, 25);

        eventName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        eventName.setForeground(new java.awt.Color(33, 27, 53));
        eventName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(eventName);
        eventName.setBounds(32, 186, 530, 42);

        venueLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        venueLabel.setForeground(new java.awt.Color(33, 27, 53));
        venueLabel.setText("Venue");
        add(venueLabel);
        venueLabel.setBounds(590, 158, 400, 25);

        venue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        venue.setForeground(new java.awt.Color(33, 27, 53));
        venue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(venue);
        venue.setBounds(590, 186, 552, 42);

        typeLabel.setText("Event type");
        typeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        typeLabel.setForeground(new java.awt.Color(33, 27, 53));
        add(typeLabel);
        typeLabel.setBounds(32, 242, 200, 25);

        eventType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        eventType.setForeground(new java.awt.Color(33, 27, 53));
        eventType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CONCERT", "SPORTS", "MOVIE" }));
        eventType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(eventType);
        eventType.setBounds(32, 270, 250, 40);

        priceLabel.setText("Regular price (PHP)");
        priceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(33, 27, 53));
        add(priceLabel);
        priceLabel.setBounds(310, 242, 250, 25);

        basePrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        basePrice.setForeground(new java.awt.Color(33, 27, 53));
        basePrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(basePrice);
        basePrice.setBounds(310, 270, 252, 42);

        startsLabel.setText("Starts (yyyy-MM-dd HH:mm)");
        startsLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        startsLabel.setForeground(new java.awt.Color(33, 27, 53));
        add(startsLabel);
        startsLabel.setBounds(590, 242, 260, 25);

        startsAt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        startsAt.setForeground(new java.awt.Color(33, 27, 53));
        startsAt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(startsAt);
        startsAt.setBounds(590, 270, 264, 42);

        earlyLabel.setText("Early Bird ends (yyyy-MM-dd HH:mm)");
        earlyLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        earlyLabel.setForeground(new java.awt.Color(33, 27, 53));
        add(earlyLabel);
        earlyLabel.setBounds(882, 242, 260, 25);

        earlyBird.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        earlyBird.setForeground(new java.awt.Color(33, 27, 53));
        earlyBird.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(earlyBird);
        earlyBird.setBounds(882, 270, 260, 42);

        descriptionLabel.setText("Description");
        descriptionLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descriptionLabel.setForeground(new java.awt.Color(33, 27, 53));
        add(descriptionLabel);
        descriptionLabel.setBounds(32, 328, 500, 25);

        description.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        description.setForeground(new java.awt.Color(33, 27, 53));
        description.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(description);
        description.setBounds(32, 356, 822, 42);

        imageLabel.setText("Event photo");
        imageLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        imageLabel.setForeground(new java.awt.Color(33, 27, 53));
        add(imageLabel);
        imageLabel.setBounds(882, 328, 250, 25);

        image.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        image.setForeground(new java.awt.Color(33, 27, 53));
        image.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "concert.jpg", "electronic.jpg", "acoustic.jpg" }));
        image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(image);
        image.setBounds(882, 356, 260, 40);

        rowsLabel.setText("Rows");
        rowsLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rowsLabel.setForeground(new java.awt.Color(33, 27, 53));
        add(rowsLabel);
        rowsLabel.setBounds(32, 414, 80, 25);

        rows.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rows.setForeground(new java.awt.Color(33, 27, 53));
        rows.setModel(new javax.swing.SpinnerNumberModel(7, 4, 14, 1));
        add(rows);
        rows.setBounds(32, 444, 70, 36);

        columnsLabel.setText("Columns");
        columnsLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        columnsLabel.setForeground(new java.awt.Color(33, 27, 53));
        add(columnsLabel);
        columnsLabel.setBounds(124, 414, 80, 25);

        columns.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        columns.setForeground(new java.awt.Color(33, 27, 53));
        columns.setModel(new javax.swing.SpinnerNumberModel(12, 4, 18, 1));
        add(columns);
        columns.setBounds(124, 444, 70, 36);

        stageRowLabel.setText("Stage row");
        stageRowLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stageRowLabel.setForeground(new java.awt.Color(33, 27, 53));
        add(stageRowLabel);
        stageRowLabel.setBounds(216, 414, 110, 25);

        stageRow.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stageRow.setForeground(new java.awt.Color(33, 27, 53));
        stageRow.setModel(new javax.swing.SpinnerNumberModel(1, 1, 14, 1));
        add(stageRow);
        stageRow.setBounds(216, 444, 70, 36);

        stageColLabel.setText("Stage column");
        stageColLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stageColLabel.setForeground(new java.awt.Color(33, 27, 53));
        add(stageColLabel);
        stageColLabel.setBounds(330, 414, 115, 25);

        stageCol.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stageCol.setForeground(new java.awt.Color(33, 27, 53));
        stageCol.setModel(new javax.swing.SpinnerNumberModel(4, 1, 18, 1));
        add(stageCol);
        stageCol.setBounds(330, 444, 70, 36);

        stageWidthLabel.setText("Stage width");
        stageWidthLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stageWidthLabel.setForeground(new java.awt.Color(33, 27, 53));
        add(stageWidthLabel);
        stageWidthLabel.setBounds(458, 414, 110, 25);

        stageWidth.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stageWidth.setForeground(new java.awt.Color(33, 27, 53));
        stageWidth.setModel(new javax.swing.SpinnerNumberModel(6, 1, 18, 1));
        add(stageWidth);
        stageWidth.setBounds(458, 444, 70, 36);

        rebuild.setBackground(new java.awt.Color(238, 232, 254));
        rebuild.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rebuild.setForeground(new java.awt.Color(108, 59, 240));
        rebuild.setText("Apply grid");
        rebuild.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(rebuild);
        rebuild.setBounds(582, 440, 132, 40);

        vipColor.setBackground(new java.awt.Color(238, 232, 254));
        vipColor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        vipColor.setForeground(new java.awt.Color(108, 59, 240));
        vipColor.setText("VIP color");
        vipColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(vipColor);
        vipColor.setBounds(728, 440, 132, 40);

        regularColor.setBackground(new java.awt.Color(238, 232, 254));
        regularColor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        regularColor.setForeground(new java.awt.Color(108, 59, 240));
        regularColor.setText("Regular color");
        regularColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(regularColor);
        regularColor.setBounds(874, 440, 148, 40);

        gridHelp.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        gridHelp.setForeground(new java.awt.Color(130, 124, 145));
        gridHelp.setText("Click a seat to cycle Regular → VIP → Aisle. Stage cells are fixed. Grid coordinates start at 1.");
        add(gridHelp);
        gridHelp.setBounds(32, 497, 1110, 28);

        gridPanel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gridPanel.setForeground(new java.awt.Color(33, 27, 53));
        gridPanel.setBackground(new java.awt.Color(255, 255, 255));
        gridPanel.setLayout(null);
        add(gridPanel);
        gridPanel.setBounds(32, 540, 1110, 350);

        pricingRule.setText("Pricing: Regular = base · VIP = 150% · Early Bird = 80% of Regular, before its cutoff.");
        pricingRule.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        pricingRule.setForeground(new java.awt.Color(130, 124, 145));
        add(pricingRule);
        pricingRule.setBounds(32, 908, 1100, 28);

        published.setText("Published and visible to Customers");
        published.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        published.setForeground(new java.awt.Color(33, 27, 53));
        published.setBackground(new java.awt.Color(247, 246, 251));
        add(published);
        published.setBounds(32, 956, 620, 38);

        save.setText("Save event & venue  →");
        save.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setBackground(new java.awt.Color(108, 59, 240));
        add(save);
        save.setBounds(790, 950, 352, 48);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton back;
    public javax.swing.JTextField basePrice;
    public javax.swing.JSpinner columns;
    public javax.swing.JLabel columnsLabel;
    public javax.swing.JTextField description;
    public javax.swing.JLabel descriptionLabel;
    public javax.swing.JTextField earlyBird;
    public javax.swing.JLabel earlyLabel;
    public javax.swing.JTextField eventName;
    public javax.swing.JComboBox eventType;
    public javax.swing.JLabel gridHelp;
    public javax.swing.JPanel gridPanel;
    public javax.swing.JLabel heading;
    public javax.swing.JComboBox image;
    public javax.swing.JLabel imageLabel;
    public javax.swing.JLabel nameLabel;
    public javax.swing.JLabel priceLabel;
    public javax.swing.JLabel pricingRule;
    public javax.swing.JLabel protection;
    public javax.swing.JCheckBox published;
    public javax.swing.JButton rebuild;
    public javax.swing.JButton regularColor;
    public javax.swing.JSpinner rows;
    public javax.swing.JLabel rowsLabel;
    public javax.swing.JButton save;
    public javax.swing.JSpinner stageCol;
    public javax.swing.JLabel stageColLabel;
    public javax.swing.JSpinner stageRow;
    public javax.swing.JLabel stageRowLabel;
    public javax.swing.JSpinner stageWidth;
    public javax.swing.JLabel stageWidthLabel;
    public javax.swing.JTextField startsAt;
    public javax.swing.JLabel startsLabel;
    public javax.swing.JLabel subtitle;
    public javax.swing.JLabel typeLabel;
    public javax.swing.JTextField venue;
    public javax.swing.JLabel venueLabel;
    public javax.swing.JButton vipColor;
    // End of variables declaration//GEN-END:variables
}
