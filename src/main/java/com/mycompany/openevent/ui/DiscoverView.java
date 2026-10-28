// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
package com.mycompany.openevent.ui;
/** NetBeans GUI Builder form. Edit layout in Design; behavior lives outside generated code. */
// Defines a class that inherits the fields and behavior of its parent type.
public class DiscoverView extends javax.swing.JPanel {
    // Constructs a DiscoverView object and initializes or validates its starting state.
    public DiscoverView(){
        // Calls this operation to carry out the named step with the supplied arguments.
        initComponents();
    }
    @SuppressWarnings({
        "unchecked","rawtypes"
    })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // NetBeans generates this layout code from the matching .form file; positions are measured in pixels.
    private void initComponents() {

        // Updates this working value before the next step.
        hero = new keeptoo.KGradientPanel();
        // Updates this working value before the next step.
        eyebrow = new javax.swing.JLabel();
        // Updates this working value before the next step.
        heroTitle = new javax.swing.JLabel();
        // Updates this working value before the next step.
        heroSubtitle = new javax.swing.JLabel();
        // Updates this working value before the next step.
        heroPhoto = new javax.swing.JPanel();
        // Updates this working value before the next step.
        searchLabel = new javax.swing.JLabel();
        // Updates this working value before the next step.
        search = new javax.swing.JTextField();
        // Updates this working value before the next step.
        searchButton = new javax.swing.JButton();
        // Updates this working value before the next step.
        heading = new javax.swing.JLabel();
        // Updates this working value before the next step.
        count = new javax.swing.JLabel();
        // Updates this working value before the next step.
        eventsScroll = new javax.swing.JScrollPane();
        // Updates this working value before the next step.
        scope = new javax.swing.JLabel();

        // Calls this operation to carry out the named step with the supplied arguments.
        setBackground(new java.awt.Color(247, 246, 251));
        // Calls this operation to carry out the named step with the supplied arguments.
        setPreferredSize(new java.awt.Dimension(1176, 660));
        // Calls this operation to carry out the named step with the supplied arguments.
        setLayout(null);

        // Sets the font family, style and point size used to draw this component.
        hero.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        hero.setForeground(new java.awt.Color(33, 27, 53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        hero.setkStartColor(new java.awt.Color(129, 59, 240));
        // Sets this component color; the gradient start/end colors form the purple theme.
        hero.setkEndColor(new java.awt.Color(67, 55, 217));
        // Chooses how child components are arranged inside this container.
        hero.setLayout(null);

        // Displays this text in the named Swing component.
        eyebrow.setText("INDEPENDENT SOUNDS. SHARED SPACES.");
        // Sets the font family, style and point size used to draw this component.
        eyebrow.setFont(new java.awt.Font("Segoe UI", 1, 12));
        // NOI18N
        // Sets the text or drawing color for this component.
        eyebrow.setForeground(new java.awt.Color(233, 223, 255));
        // Adds this object to the collection or this child component to its parent container.
        hero.add(eyebrow);
        // Positions this component using x, y, width and height, measured in pixels.
        eyebrow.setBounds(24, 16, 610, 22);

        // Displays this text in the named Swing component.
        heroTitle.setText("<html>Your next favorite night<br>starts here.</html>");
        // Sets the font family, style and point size used to draw this component.
        heroTitle.setFont(new java.awt.Font("Segoe UI", 1, 31));
        // NOI18N
        // Sets the text or drawing color for this component.
        heroTitle.setForeground(new java.awt.Color(255, 255, 255));
        // Adds this object to the collection or this child component to its parent container.
        hero.add(heroTitle);
        // Positions this component using x, y, width and height, measured in pixels.
        heroTitle.setBounds(24, 40, 620, 67);

        // Displays this text in the named Swing component.
        heroSubtitle.setText("Find your people. Support a local stage. Be there for the music.");
        // Sets the font family, style and point size used to draw this component.
        heroSubtitle.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        heroSubtitle.setForeground(new java.awt.Color(242, 233, 255));
        // Adds this object to the collection or this child component to its parent container.
        hero.add(heroSubtitle);
        // Positions this component using x, y, width and height, measured in pixels.
        heroSubtitle.setBounds(24, 115, 650, 26);

        // Sets the font family, style and point size used to draw this component.
        heroPhoto.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        heroPhoto.setForeground(new java.awt.Color(33, 27, 53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        heroPhoto.setBackground(new java.awt.Color(255, 255, 255));
        // Chooses how child components are arranged inside this container.
        heroPhoto.setLayout(null);
        // Adds this object to the collection or this child component to its parent container.
        hero.add(heroPhoto);
        // Positions this component using x, y, width and height, measured in pixels.
        heroPhoto.setBounds(730, 0, 380, 150);

        // Calls this operation to carry out the named step with the supplied arguments.
        add(hero);
        // Positions this component using x, y, width and height, measured in pixels.
        hero.setBounds(32, 18, 1110, 150);

        // Displays this text in the named Swing component.
        searchLabel.setText("Search event titles");
        // Sets the font family, style and point size used to draw this component.
        searchLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
        // NOI18N
        // Sets the text or drawing color for this component.
        searchLabel.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(searchLabel);
        // Positions this component using x, y, width and height, measured in pixels.
        searchLabel.setBounds(32, 180, 750, 22);

        // Sets the font family, style and point size used to draw this component.
        search.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        search.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(search);
        // Positions this component using x, y, width and height, measured in pixels.
        search.setBounds(32, 210, 840, 40);

        // Displays this text in the named Swing component.
        searchButton.setText("Search events");
        // Sets the font family, style and point size used to draw this component.
        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        // Sets this component color; the gradient start/end colors form the purple theme.
        searchButton.setBackground(new java.awt.Color(108, 59, 240));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(searchButton);
        // Positions this component using x, y, width and height, measured in pixels.
        searchButton.setBounds(890, 210, 252, 40);

        // Displays this text in the named Swing component.
        heading.setText("Upcoming events");
        // Sets the font family, style and point size used to draw this component.
        heading.setFont(new java.awt.Font("Segoe UI", 1, 26));
        // NOI18N
        // Sets the text or drawing color for this component.
        heading.setForeground(new java.awt.Color(33, 27, 53));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(heading);
        // Positions this component using x, y, width and height, measured in pixels.
        heading.setBounds(32, 268, 800, 36);

        // Displays this text in the named Swing component.
        count.setText("Small stages. Big feelings. Discover what is coming up.");
        // Sets the font family, style and point size used to draw this component.
        count.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        count.setForeground(new java.awt.Color(130, 124, 145));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(count);
        // Positions this component using x, y, width and height, measured in pixels.
        count.setBounds(32, 309, 1000, 25);

        // Sets the font family, style and point size used to draw this component.
        eventsScroll.setFont(new java.awt.Font("Segoe UI", 0, 14));
        // NOI18N
        // Sets the text or drawing color for this component.
        eventsScroll.setForeground(new java.awt.Color(33, 27, 53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        eventsScroll.setBackground(new java.awt.Color(247, 246, 251));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(eventsScroll);
        // Positions this component using x, y, width and height, measured in pixels.
        eventsScroll.setBounds(32, 347, 1110, 286);

        // Displays this text in the named Swing component.
        scope.setText("Illustrative events · All payments and sales are simulated");
        // Sets the text or drawing color for this component.
        scope.setForeground(new java.awt.Color(130, 124, 145));
        // Calls this operation to carry out the named step with the supplied arguments.
        add(scope);
        // Positions this component using x, y, width and height, measured in pixels.
        scope.setBounds(32, 638, 1100, 20);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Stores count.
    public javax.swing.JLabel count;
    // Stores events scroll.
    public javax.swing.JScrollPane eventsScroll;
    // Stores eyebrow.
    public javax.swing.JLabel eyebrow;
    // Stores heading.
    public javax.swing.JLabel heading;
    // Stores hero.
    public keeptoo.KGradientPanel hero;
    // Stores hero photo.
    public javax.swing.JPanel heroPhoto;
    // Stores hero subtitle.
    public javax.swing.JLabel heroSubtitle;
    // Stores hero title.
    public javax.swing.JLabel heroTitle;
    // Stores scope.
    public javax.swing.JLabel scope;
    // Stores search.
    public javax.swing.JTextField search;
    // Stores search button.
    public javax.swing.JButton searchButton;
    // Stores search label.
    public javax.swing.JLabel searchLabel;
    // End of variables declaration//GEN-END:variables
}
