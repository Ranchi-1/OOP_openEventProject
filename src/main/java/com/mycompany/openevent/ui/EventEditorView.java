// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
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
    // NetBeans generates this layout code from the matching .form file; positions are measured in pixels.
    private void initComponents() {

        // Updates this working value before the next step.
        heading = new javax.swing.JLabel();
        // Updates this working value before the next step.
        subtitle = new javax.swing.JLabel();
        // Updates this working value before the next step.
        back = new javax.swing.JButton();
        // Updates this working value before the next step.
        protection = new javax.swing.JLabel();
        // Updates this working value before the next step.
        nameLabel = new javax.swing.JLabel();
        // Updates this working value before the next step.
        eventName = new javax.swing.JTextField();
        // Updates this working value before the next step.
        venueLabel = new javax.swing.JLabel();
        // Updates this working value before the next step.
        venue = new javax.swing.JTextField();
        // Updates this working value before the next step.
        typeLabel = new javax.swing.JLabel();
        // Updates this working value before the next step.
        eventType = new javax.swing.JComboBox();
        // Updates this working value before the next step.
        priceLabel = new javax.swing.JLabel();
        // Updates this working value before the next step.
        basePrice = new javax.swing.JTextField();
        // Updates this working value before the next step.
        startsLabel = new javax.swing.JLabel();
        // Updates this working value before the next step.
        startsAt = new javax.swing.JTextField();
        // Updates this working value before the next step.
        earlyLabel = new javax.swing.JLabel();
        // Updates this working value before the next step.
        earlyBird = new javax.swing.JTextField();
        // Updates this working value before the next step.
        descriptionLabel = new javax.swing.JLabel();
        // Updates this working value before the next step.
        description = new javax.swing.JTextField();
        // Updates this working value before the next step.
        imageLabel = new javax.swing.JLabel();
        // Updates this working value before the next step.
        image = new javax.swing.JComboBox();
        // Updates this working value before the next step.
        rowsLabel = new javax.swing.JLabel();
        // Updates this working value before the next step.
        rows = new javax.swing.JSpinner();
        // Updates this working value before the next step.
        columnsLabel = new javax.swing.JLabel();
        // Updates this working value before the next step.
        columns = new javax.swing.JSpinner();
        // Updates this working value before the next step.
        stageRowLabel = new javax.swing.JLabel();
        // Updates this working value before the next step.
        stageRow = new javax.swing.JSpinner();
        // Updates this working value before the next step.
        stageColLabel = new javax.swing.JLabel();
        // Updates this working value before the next step.
        stageCol = new javax.swing.JSpinner();
        // Updates this working value before the next step.
        stageWidthLabel = new javax.swing.JLabel();
        // Updates this working value before the next step.
        stageWidth = new javax.swing.JSpinner();
        // Updates this working value before the next step.
        rebuild = new javax.swing.JButton();
        // Updates this working value before the next step.
        vipColor = new javax.swing.JButton();
        // Updates this working value before the next step.
        regularColor = new javax.swing.JButton();
        // Updates this working value before the next step.
        gridHelp = new javax.swing.JLabel();
        // Updates this working value before the next step.
        gridPanel = new javax.swing.JPanel();
        // Updates this working value before the next step.
        pricingRule = new javax.swing.JLabel();
        // Updates this working value before the next step.
        published = new javax.swing.JCheckBox();
        // Updates this working value before the next step.
        save = new javax.swing.JButton();

        // Calls this operation to carry out the named step with the supplied arguments.
        setBackground(new java.awt.Color(247, 246, 251));
        // Calls this operation to carry out the named step with the supplied arguments.
        setPreferredSize(new java.awt.Dimension(1176, 1030));
        // Calls this operation to carry out the named step with the supplied arguments.
        setLayout(null);

        // Displays this text in the named Swing component.
        heading.setText("Event editor");
        // Sets the font family, style and point size used to draw this component.
        heading.setFont(new java.awt.Font("Segoe UI", 1, 28));
        // NOI18N
        // Sets the text or drawing color for this component.
        heading.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(heading);
        // Positions this component using x, y, width and height, measured in pixels.
        heading.setBounds(32, 18, 1050, 40);

        // Displays this text in the named Swing component.
        subtitle.setText("Set the event details, then configure a color-coded grid for your venue.");
        // Sets the font family, style and point size used to draw this component.
        subtitle.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        subtitle.setForeground(new java.awt.Color(130, 124, 145));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(subtitle);
        // Positions this component using x, y, width and height, measured in pixels.
        subtitle.setBounds(32, 60, 1050, 25);

        // Displays this text in the named Swing component.
        back.setText("← Host dashboard");
        // Sets the font family, style and point size used to draw this component.
        back.setFont(new java.awt.Font("Segoe UI", 1, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        back.setForeground(new java.awt.Color(108, 59, 240));
        // Sets this component color; the gradient start/end colors form the purple theme.
        back.setBackground(new java.awt.Color(238, 232, 254));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(back);
        // Positions this component using x, y, width and height, measured in pixels.
        back.setBounds(32, 102, 190, 36);

        // Sets the font family, style and point size used to draw this component.
        protection.setFont(new java.awt.Font("Segoe UI", 1, 13));
        // NOI18N
        // Sets the text or drawing color for this component.
        protection.setForeground(new java.awt.Color(35, 141, 130));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(protection);
        // Positions this component using x, y, width and height, measured in pixels.
        protection.setBounds(244, 105, 900, 30);

        // Displays this text in the named Swing component.
        nameLabel.setText("Event title");
        // Sets the font family, style and point size used to draw this component.
        nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        nameLabel.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(nameLabel);
        // Positions this component using x, y, width and height, measured in pixels.
        nameLabel.setBounds(32, 158, 400, 25);

        // Sets the font family, style and point size used to draw this component.
        eventName.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        eventName.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(eventName);
        // Positions this component using x, y, width and height, measured in pixels.
        eventName.setBounds(32, 186, 530, 42);

        // Displays this text in the named Swing component.
        venueLabel.setText("Venue");
        // Sets the font family, style and point size used to draw this component.
        venueLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        venueLabel.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(venueLabel);
        // Positions this component using x, y, width and height, measured in pixels.
        venueLabel.setBounds(590, 158, 400, 25);

        // Sets the font family, style and point size used to draw this component.
        venue.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        venue.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(venue);
        // Positions this component using x, y, width and height, measured in pixels.
        venue.setBounds(590, 186, 552, 42);

        // Displays this text in the named Swing component.
        typeLabel.setText("Event type");
        // Sets the font family, style and point size used to draw this component.
        typeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        typeLabel.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(typeLabel);
        // Positions this component using x, y, width and height, measured in pixels.
        typeLabel.setBounds(32, 242, 200, 25);

        // Sets the font family, style and point size used to draw this component.
        eventType.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        eventType.setForeground(new java.awt.Color(33, 27, 53));
        // Supplies the list, combo-box or table data displayed by this control.
        eventType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CONCERT", "SPORTS", "MOVIE" }));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(eventType);
        // Positions this component using x, y, width and height, measured in pixels.
        eventType.setBounds(32, 270, 250, 40);

        // Displays this text in the named Swing component.
        priceLabel.setText("Regular price (PHP)");
        // Sets the font family, style and point size used to draw this component.
        priceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        priceLabel.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(priceLabel);
        // Positions this component using x, y, width and height, measured in pixels.
        priceLabel.setBounds(310, 242, 250, 25);

        // Sets the font family, style and point size used to draw this component.
        basePrice.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        basePrice.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(basePrice);
        // Positions this component using x, y, width and height, measured in pixels.
        basePrice.setBounds(310, 270, 252, 42);

        // Displays this text in the named Swing component.
        startsLabel.setText("Starts (yyyy-MM-dd HH:mm)");
        // Sets the font family, style and point size used to draw this component.
        startsLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        startsLabel.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(startsLabel);
        // Positions this component using x, y, width and height, measured in pixels.
        startsLabel.setBounds(590, 242, 260, 25);

        // Sets the font family, style and point size used to draw this component.
        startsAt.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        startsAt.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(startsAt);
        // Positions this component using x, y, width and height, measured in pixels.
        startsAt.setBounds(590, 270, 264, 42);

        // Displays this text in the named Swing component.
        earlyLabel.setText("Early Bird ends (yyyy-MM-dd HH:mm)");
        // Sets the font family, style and point size used to draw this component.
        earlyLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        earlyLabel.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(earlyLabel);
        // Positions this component using x, y, width and height, measured in pixels.
        earlyLabel.setBounds(882, 242, 260, 25);

        // Sets the font family, style and point size used to draw this component.
        earlyBird.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        earlyBird.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(earlyBird);
        // Positions this component using x, y, width and height, measured in pixels.
        earlyBird.setBounds(882, 270, 260, 42);

        // Displays this text in the named Swing component.
        descriptionLabel.setText("Description");
        // Sets the font family, style and point size used to draw this component.
        descriptionLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        descriptionLabel.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(descriptionLabel);
        // Positions this component using x, y, width and height, measured in pixels.
        descriptionLabel.setBounds(32, 328, 500, 25);

        // Sets the font family, style and point size used to draw this component.
        description.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        description.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(description);
        // Positions this component using x, y, width and height, measured in pixels.
        description.setBounds(32, 356, 822, 42);

        // Displays this text in the named Swing component.
        imageLabel.setText("Event photo");
        // Sets the font family, style and point size used to draw this component.
        imageLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        imageLabel.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(imageLabel);
        // Positions this component using x, y, width and height, measured in pixels.
        imageLabel.setBounds(882, 328, 250, 25);

        // Sets the font family, style and point size used to draw this component.
        image.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        image.setForeground(new java.awt.Color(33, 27, 53));
        // Supplies the list, combo-box or table data displayed by this control.
        image.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "concert.jpg", "electronic.jpg", "acoustic.jpg" }));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(image);
        // Positions this component using x, y, width and height, measured in pixels.
        image.setBounds(882, 356, 260, 40);

        // Displays this text in the named Swing component.
        rowsLabel.setText("Rows");
        // Sets the font family, style and point size used to draw this component.
        rowsLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        rowsLabel.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(rowsLabel);
        // Positions this component using x, y, width and height, measured in pixels.
        rowsLabel.setBounds(32, 414, 80, 25);

        // Sets the font family, style and point size used to draw this component.
        rows.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        rows.setForeground(new java.awt.Color(33, 27, 53));
        // Supplies the list, combo-box or table data displayed by this control.
        rows.setModel(new javax.swing.SpinnerNumberModel(7, 4, 14, 1));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(rows);
        // Positions this component using x, y, width and height, measured in pixels.
        rows.setBounds(32, 444, 70, 36);

        // Displays this text in the named Swing component.
        columnsLabel.setText("Columns");
        // Sets the font family, style and point size used to draw this component.
        columnsLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        columnsLabel.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(columnsLabel);
        // Positions this component using x, y, width and height, measured in pixels.
        columnsLabel.setBounds(124, 414, 80, 25);

        // Sets the font family, style and point size used to draw this component.
        columns.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        columns.setForeground(new java.awt.Color(33, 27, 53));
        // Supplies the list, combo-box or table data displayed by this control.
        columns.setModel(new javax.swing.SpinnerNumberModel(12, 4, 18, 1));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(columns);
        // Positions this component using x, y, width and height, measured in pixels.
        columns.setBounds(124, 444, 70, 36);

        // Displays this text in the named Swing component.
        stageRowLabel.setText("Stage row");
        // Sets the font family, style and point size used to draw this component.
        stageRowLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        stageRowLabel.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(stageRowLabel);
        // Positions this component using x, y, width and height, measured in pixels.
        stageRowLabel.setBounds(216, 414, 110, 25);

        // Sets the font family, style and point size used to draw this component.
        stageRow.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        stageRow.setForeground(new java.awt.Color(33, 27, 53));
        // Supplies the list, combo-box or table data displayed by this control.
        stageRow.setModel(new javax.swing.SpinnerNumberModel(1, 1, 14, 1));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(stageRow);
        // Positions this component using x, y, width and height, measured in pixels.
        stageRow.setBounds(216, 444, 70, 36);

        // Displays this text in the named Swing component.
        stageColLabel.setText("Stage column");
        // Sets the font family, style and point size used to draw this component.
        stageColLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        stageColLabel.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(stageColLabel);
        // Positions this component using x, y, width and height, measured in pixels.
        stageColLabel.setBounds(330, 414, 115, 25);

        // Sets the font family, style and point size used to draw this component.
        stageCol.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        stageCol.setForeground(new java.awt.Color(33, 27, 53));
        // Supplies the list, combo-box or table data displayed by this control.
        stageCol.setModel(new javax.swing.SpinnerNumberModel(4, 1, 18, 1));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(stageCol);
        // Positions this component using x, y, width and height, measured in pixels.
        stageCol.setBounds(330, 444, 70, 36);

        // Displays this text in the named Swing component.
        stageWidthLabel.setText("Stage width");
        // Sets the font family, style and point size used to draw this component.
        stageWidthLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        stageWidthLabel.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(stageWidthLabel);
        // Positions this component using x, y, width and height, measured in pixels.
        stageWidthLabel.setBounds(458, 414, 110, 25);

        // Sets the font family, style and point size used to draw this component.
        stageWidth.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        stageWidth.setForeground(new java.awt.Color(33, 27, 53));
        // Supplies the list, combo-box or table data displayed by this control.
        stageWidth.setModel(new javax.swing.SpinnerNumberModel(6, 1, 18, 1));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(stageWidth);
        // Positions this component using x, y, width and height, measured in pixels.
        stageWidth.setBounds(458, 444, 70, 36);

        // Displays this text in the named Swing component.
        rebuild.setText("Apply grid");
        // Sets the font family, style and point size used to draw this component.
        rebuild.setFont(new java.awt.Font("Segoe UI", 1, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        rebuild.setForeground(new java.awt.Color(108, 59, 240));
        // Sets this component color; the gradient start/end colors form the purple theme.
        rebuild.setBackground(new java.awt.Color(238, 232, 254));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(rebuild);
        // Positions this component using x, y, width and height, measured in pixels.
        rebuild.setBounds(582, 440, 132, 40);

        // Sets this component color; the gradient start/end colors form the purple theme.
        vipColor.setBackground(new java.awt.Color(238, 232, 254));
        // Sets the font family, style and point size used to draw this component.
        vipColor.setFont(new java.awt.Font("Segoe UI", 1, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        vipColor.setForeground(new java.awt.Color(108, 59, 240));
        // Displays this text in the named Swing component.
        vipColor.setText("VIP color");
        // Calls this operation to carry out the named step with the supplied arguments.
        add(vipColor);
        // Positions this component using x, y, width and height, measured in pixels.
        vipColor.setBounds(728, 440, 132, 40);

        // Displays this text in the named Swing component.
        regularColor.setText("Regular color");
        // Sets the font family, style and point size used to draw this component.
        regularColor.setFont(new java.awt.Font("Segoe UI", 1, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        regularColor.setForeground(new java.awt.Color(108, 59, 240));
        // Sets this component color; the gradient start/end colors form the purple theme.
        regularColor.setBackground(new java.awt.Color(238, 232, 254));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(regularColor);
        // Positions this component using x, y, width and height, measured in pixels.
        regularColor.setBounds(874, 440, 148, 40);

        // Displays this text in the named Swing component.
        gridHelp.setText("Click a seat to cycle Regular → VIP → Aisle. Stage cells are fixed. Grid coordinates start at 1.");
        // Sets the font family, style and point size used to draw this component.
        gridHelp.setFont(new java.awt.Font("Segoe UI", 0, 13));
        // NOI18N
        // Sets the text or drawing color for this component.
        gridHelp.setForeground(new java.awt.Color(130, 124, 145));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(gridHelp);
        // Positions this component using x, y, width and height, measured in pixels.
        gridHelp.setBounds(32, 497, 1110, 28);

        // Sets the font family, style and point size used to draw this component.
        gridPanel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        gridPanel.setForeground(new java.awt.Color(33, 27, 53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        gridPanel.setBackground(new java.awt.Color(255, 255, 255));
        // Chooses how child components are arranged inside this container.
        gridPanel.setLayout(null);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(gridPanel);
        // Positions this component using x, y, width and height, measured in pixels.
        gridPanel.setBounds(32, 540, 1110, 350);

        // Displays this text in the named Swing component.
        pricingRule.setText("Pricing: Regular = base · VIP = 150% · Early Bird = 80% of Regular, before its cutoff.");
        // Sets the font family, style and point size used to draw this component.
        pricingRule.setFont(new java.awt.Font("Segoe UI", 0, 13));
        // NOI18N
        // Sets the text or drawing color for this component.
        pricingRule.setForeground(new java.awt.Color(130, 124, 145));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(pricingRule);
        // Positions this component using x, y, width and height, measured in pixels.
        pricingRule.setBounds(32, 908, 1100, 28);

        // Displays this text in the named Swing component.
        published.setText("Published and visible to Customers");
        // Sets the font family, style and point size used to draw this component.
        published.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        published.setForeground(new java.awt.Color(33, 27, 53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        published.setBackground(new java.awt.Color(247, 246, 251));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(published);
        // Positions this component using x, y, width and height, measured in pixels.
        published.setBounds(32, 956, 620, 38);

        // Displays this text in the named Swing component.
        save.setText("Save event & venue  →");
        // Sets the font family, style and point size used to draw this component.
        save.setFont(new java.awt.Font("Segoe UI", 1, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        save.setForeground(new java.awt.Color(255, 255, 255));
        // Sets this component color; the gradient start/end colors form the purple theme.
        save.setBackground(new java.awt.Color(108, 59, 240));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(save);
        // Positions this component using x, y, width and height, measured in pixels.
        save.setBounds(790, 950, 352, 48);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Stores back.
    public javax.swing.JButton back;
    // Stores base price.
    public javax.swing.JTextField basePrice;
    // Stores columns.
    public javax.swing.JSpinner columns;
    // Stores columns label.
    public javax.swing.JLabel columnsLabel;
    // Stores description.
    public javax.swing.JTextField description;
    // Stores description label.
    public javax.swing.JLabel descriptionLabel;
    // Stores early bird.
    public javax.swing.JTextField earlyBird;
    // Stores early label.
    public javax.swing.JLabel earlyLabel;
    // Stores event name.
    public javax.swing.JTextField eventName;
    // Stores event type.
    public javax.swing.JComboBox eventType;
    // Stores grid help.
    public javax.swing.JLabel gridHelp;
    // Stores grid panel.
    public javax.swing.JPanel gridPanel;
    // Stores heading.
    public javax.swing.JLabel heading;
    // Stores image.
    public javax.swing.JComboBox image;
    // Stores image label.
    public javax.swing.JLabel imageLabel;
    // Stores name label.
    public javax.swing.JLabel nameLabel;
    // Stores price label.
    public javax.swing.JLabel priceLabel;
    // Stores pricing rule.
    public javax.swing.JLabel pricingRule;
    // Stores protection.
    public javax.swing.JLabel protection;
    // Stores published.
    public javax.swing.JCheckBox published;
    // Stores rebuild.
    public javax.swing.JButton rebuild;
    // Stores regular color.
    public javax.swing.JButton regularColor;
    // Stores rows.
    public javax.swing.JSpinner rows;
    // Stores rows label.
    public javax.swing.JLabel rowsLabel;
    // Stores save.
    public javax.swing.JButton save;
    // Stores stage col.
    public javax.swing.JSpinner stageCol;
    // Stores stage col label.
    public javax.swing.JLabel stageColLabel;
    // Stores stage row.
    public javax.swing.JSpinner stageRow;
    // Stores stage row label.
    public javax.swing.JLabel stageRowLabel;
    // Stores stage width.
    public javax.swing.JSpinner stageWidth;
    // Stores stage width label.
    public javax.swing.JLabel stageWidthLabel;
    // Stores starts at.
    public javax.swing.JTextField startsAt;
    // Stores starts label.
    public javax.swing.JLabel startsLabel;
    // Stores subtitle.
    public javax.swing.JLabel subtitle;
    // Stores type label.
    public javax.swing.JLabel typeLabel;
    // Stores venue.
    public javax.swing.JTextField venue;
    // Stores venue label.
    public javax.swing.JLabel venueLabel;
    // Stores vip color.
    public javax.swing.JButton vipColor;
    // End of variables declaration//GEN-END:variables
}
