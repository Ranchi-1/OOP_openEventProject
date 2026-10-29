package com.mycompany.openevent.ui;

/**
 * NetBeans GUI Builder form. Edit layout in Design; behavior lives outside
 * generated code.
 */
// Defines a class that inherits the fields and behavior of its parent type.
public class NavigationView extends javax.swing.JPanel {

    // Constructs a NavigationView object and initializes or validates its starting state.
    public NavigationView() {
        // Calls this operation to carry out the named step with the supplied arguments.
        initComponents();
    }

    @SuppressWarnings({
        "unchecked", "rawtypes"
    })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        brand = new javax.swing.JLabel();
        discover = new javax.swing.JButton();
        tickets = new javax.swing.JButton();
        demo = new javax.swing.JLabel();
        identity = new javax.swing.JLabel();
        logout = new javax.swing.JButton();

        setBackground(new java.awt.Color(247, 246, 251));
        setPreferredSize(new java.awt.Dimension(1176, 72));
        setLayout(null);

        brand.setText("OpenEvent");
        brand.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        brand.setForeground(new java.awt.Color(33, 27, 53));
        add(brand);
        brand.setBounds(25, 16, 245, 38);

        discover.setBackground(new java.awt.Color(238, 232, 254));
        discover.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        discover.setForeground(new java.awt.Color(108, 59, 240));
        discover.setText("Discover");
        discover.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(discover);
        discover.setBounds(296, 17, 125, 38);

        tickets.setBackground(new java.awt.Color(238, 232, 254));
        tickets.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tickets.setForeground(new java.awt.Color(108, 59, 240));
        tickets.setText("My tickets");
        tickets.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(tickets);
        tickets.setBounds(431, 17, 125, 38);

        demo.setText("PROTOTYPE · SIMULATED PAYMENTS");
        demo.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        demo.setForeground(new java.awt.Color(130, 124, 145));
        add(demo);
        demo.setBounds(588, 22, 360, 28);

        identity.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        identity.setForeground(new java.awt.Color(33, 27, 53));
        add(identity);
        identity.setBounds(900, 22, 150, 28);

        logout.setBackground(new java.awt.Color(238, 232, 254));
        logout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logout.setForeground(new java.awt.Color(108, 59, 240));
        logout.setText("Sign out");
        logout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(logout);
        logout.setBounds(1055, 17, 115, 38);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel brand;
    public javax.swing.JLabel demo;
    public javax.swing.JButton discover;
    public javax.swing.JLabel identity;
    public javax.swing.JButton logout;
    public javax.swing.JButton tickets;
    // End of variables declaration//GEN-END:variables
}
