package com.mycompany.openevent.ui;

/**
 * NetBeans GUI Builder form. Edit layout in Design; behavior lives outside
 * generated code.
 */
// Defines a class that inherits the fields and behavior of its parent type.
public class DiscoverView extends javax.swing.JPanel {

    // Constructs a DiscoverView object and initializes or validates its starting state.
    public DiscoverView() {
        // Calls this operation to carry out the named step with the supplied arguments.
        initComponents();
    }

    @SuppressWarnings({
        "unchecked", "rawtypes"
    })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hero = new keeptoo.KGradientPanel();
        eyebrow = new javax.swing.JLabel();
        heroTitle = new javax.swing.JLabel();
        heroSubtitle = new javax.swing.JLabel();
        heroPhoto = new javax.swing.JPanel();
        searchLabel = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        heading = new javax.swing.JLabel();
        count = new javax.swing.JLabel();
        eventsScroll = new javax.swing.JScrollPane();
        scope = new javax.swing.JLabel();

        setBackground(new java.awt.Color(247, 246, 251));
        setPreferredSize(new java.awt.Dimension(1176, 660));
        setLayout(null);

        hero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        hero.setForeground(new java.awt.Color(33, 27, 53));
        hero.setLayout(null);

        eyebrow.setText("INDEPENDENT SOUNDS. SHARED SPACES.");
        eyebrow.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        eyebrow.setForeground(new java.awt.Color(233, 223, 255));
        hero.add(eyebrow);
        eyebrow.setBounds(24, 16, 610, 22);

        heroTitle.setText("<html>Your next favorite night<br>starts here.</html>");
        heroTitle.setFont(new java.awt.Font("Segoe UI", 1, 31)); // NOI18N
        heroTitle.setForeground(new java.awt.Color(255, 255, 255));
        hero.add(heroTitle);
        heroTitle.setBounds(24, 40, 620, 67);

        heroSubtitle.setText("Find your people. Support a local stage. Be there for the music.");
        heroSubtitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        heroSubtitle.setForeground(new java.awt.Color(242, 233, 255));
        hero.add(heroSubtitle);
        heroSubtitle.setBounds(24, 115, 650, 26);

        heroPhoto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        heroPhoto.setForeground(new java.awt.Color(33, 27, 53));
        heroPhoto.setBackground(new java.awt.Color(255, 255, 255));
        heroPhoto.setLayout(null);
        hero.add(heroPhoto);
        heroPhoto.setBounds(730, 0, 380, 150);

        add(hero);
        hero.setBounds(32, 18, 1110, 150);

        searchLabel.setText("Search event titles");
        searchLabel.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        searchLabel.setForeground(new java.awt.Color(33, 27, 53));
        add(searchLabel);
        searchLabel.setBounds(32, 180, 750, 22);

        search.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        search.setForeground(new java.awt.Color(33, 27, 53));
        search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(search);
        search.setBounds(32, 210, 840, 40);

        searchButton.setText("Search events");
        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setBackground(new java.awt.Color(108, 59, 240));
        add(searchButton);
        searchButton.setBounds(890, 210, 252, 40);

        heading.setText("Upcoming events");
        heading.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        heading.setForeground(new java.awt.Color(33, 27, 53));
        add(heading);
        heading.setBounds(32, 268, 800, 36);

        count.setText("Small stages. Big feelings. Discover what is coming up.");
        count.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        count.setForeground(new java.awt.Color(130, 124, 145));
        add(count);
        count.setBounds(32, 309, 1000, 25);

        eventsScroll.setBackground(new java.awt.Color(247, 246, 251));
        eventsScroll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        eventsScroll.setForeground(new java.awt.Color(33, 27, 53));
        eventsScroll.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(eventsScroll);
        eventsScroll.setBounds(32, 347, 1110, 286);

        scope.setText("Illustrative events · All payments and sales are simulated");
        scope.setForeground(new java.awt.Color(130, 124, 145));
        add(scope);
        scope.setBounds(32, 638, 1100, 20);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel count;
    public javax.swing.JScrollPane eventsScroll;
    public javax.swing.JLabel eyebrow;
    public javax.swing.JLabel heading;
    public keeptoo.KGradientPanel hero;
    public javax.swing.JPanel heroPhoto;
    public javax.swing.JLabel heroSubtitle;
    public javax.swing.JLabel heroTitle;
    public javax.swing.JLabel scope;
    public javax.swing.JTextField search;
    public javax.swing.JButton searchButton;
    public javax.swing.JLabel searchLabel;
    // End of variables declaration//GEN-END:variables
}
