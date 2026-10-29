package com.mycompany.openevent.ui;

/**
 * NetBeans GUI Builder form. Edit layout in Design; behavior lives outside
 * generated code.
 */
// Defines a class that inherits the fields and behavior of its parent type.
public class LoginView extends javax.swing.JPanel {

    // This helper remembers the mask character and handles the eye button.
    private PasswordVisibility passwordVisibility;

    public void hidePassword() {
        passwordVisibility.hidePassword();
    }

    // Constructs a LoginView object and initializes or validates its starting state.
    public LoginView() {
        // Calls this operation to carry out the named step with the supplied arguments.
        initComponents();
        // Keep behavior outside generated layout code, so NetBeans can regenerate the form.
        passwordVisibility = new PasswordVisibility(password, passwordToggle);
    }

    @SuppressWarnings({
        "unchecked", "rawtypes"
    })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomePanel = new keeptoo.KGradientPanel();
        eyebrow = new javax.swing.JLabel();
        welcome = new javax.swing.JLabel();
        intro = new javax.swing.JLabel();
        photoPanel = new javax.swing.JPanel();
        tagline = new javax.swing.JLabel();
        loginTitle = new javax.swing.JLabel();
        loginSubtitle = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        role = new javax.swing.JComboBox();
        emailLabel = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        signIn = new javax.swing.JButton();
        register = new javax.swing.JButton();
        registerHost = new javax.swing.JButton();
        demo = new javax.swing.JLabel();
        passwordToggle = new javax.swing.JToggleButton();

        setBackground(new java.awt.Color(247, 246, 251));
        setPreferredSize(new java.awt.Dimension(1176, 660));
        setLayout(null);

        welcomePanel.setForeground(new java.awt.Color(33, 27, 53));
        welcomePanel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        welcomePanel.setLayout(null);

        eyebrow.setText("INDEPENDENT SOUNDS. SHARED SPACES.");
        eyebrow.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        eyebrow.setForeground(new java.awt.Color(233, 223, 255));
        welcomePanel.add(eyebrow);
        eyebrow.setBounds(32, 28, 470, 25);

        welcome.setText("<html>Your next great night<br>starts here.</html>");
        welcome.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        welcome.setForeground(new java.awt.Color(255, 255, 255));
        welcomePanel.add(welcome);
        welcome.setBounds(32, 80, 470, 120);

        intro.setText("Find your people. Support a local stage.");
        intro.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        intro.setForeground(new java.awt.Color(240, 229, 255));
        welcomePanel.add(intro);
        intro.setBounds(32, 216, 470, 30);

        photoPanel.setBackground(new java.awt.Color(255, 255, 255));
        photoPanel.setForeground(new java.awt.Color(33, 27, 53));
        photoPanel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        photoPanel.setLayout(null);
        welcomePanel.add(photoPanel);
        photoPanel.setBounds(24, 302, 492, 210);

        tagline.setText("OpenEvent / For the independent scene.");
        tagline.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tagline.setForeground(new java.awt.Color(231, 223, 255));
        welcomePanel.add(tagline);
        tagline.setBounds(32, 540, 460, 25);

        add(welcomePanel);
        welcomePanel.setBounds(32, 24, 540, 600);

        loginTitle.setText("Welcome back.");
        loginTitle.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        loginTitle.setForeground(new java.awt.Color(33, 27, 53));
        add(loginTitle);
        loginTitle.setBounds(644, 54, 460, 50);

        loginSubtitle.setText("Sign in to find a seat or bring your next event to life.");
        loginSubtitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loginSubtitle.setForeground(new java.awt.Color(130, 124, 145));
        add(loginSubtitle);
        loginSubtitle.setBounds(644, 108, 460, 25);

        roleLabel.setText("I am signing in as");
        roleLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        roleLabel.setForeground(new java.awt.Color(33, 27, 53));
        add(roleLabel);
        roleLabel.setBounds(644, 162, 400, 25);

        role.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        role.setForeground(new java.awt.Color(33, 27, 53));
        role.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Customer", "Host" }));
        role.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(role);
        role.setBounds(644, 191, 450, 40);

        emailLabel.setText("Email address");
        emailLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(33, 27, 53));
        add(emailLabel);
        emailLabel.setBounds(644, 244, 400, 25);

        email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        email.setForeground(new java.awt.Color(33, 27, 53));
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(email);
        email.setBounds(644, 273, 450, 42);

        passwordLabel.setText("Password");
        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(33, 27, 53));
        add(passwordLabel);
        passwordLabel.setBounds(644, 326, 400, 25);

        password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        password.setForeground(new java.awt.Color(33, 27, 53));
        password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255)));
        add(password);
        password.setBounds(644, 355, 390, 42);

        signIn.setText("Sign in  →");
        signIn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        signIn.setForeground(new java.awt.Color(255, 255, 255));
        signIn.setBackground(new java.awt.Color(108, 59, 240));
        add(signIn);
        signIn.setBounds(644, 420, 450, 46);

        register.setText("Create Customer account");
        register.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        register.setForeground(new java.awt.Color(108, 59, 240));
        register.setBackground(new java.awt.Color(238, 232, 254));
        add(register);
        register.setBounds(644, 480, 220, 42);

        registerHost.setText("Create Host account");
        registerHost.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        registerHost.setForeground(new java.awt.Color(108, 59, 240));
        registerHost.setBackground(new java.awt.Color(238, 232, 254));
        add(registerHost);
        registerHost.setBounds(874, 480, 220, 42);

        demo.setText("<html>CLASSROOM DEMO<br>alex@openevent.local · host@openevent.local<br>Password: OpenEvent2026!</html>");
        demo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        demo.setForeground(new java.awt.Color(130, 124, 145));
        add(demo);
        demo.setBounds(644, 548, 460, 68);

        passwordToggle.setBackground(new java.awt.Color(238, 232, 254));
        passwordToggle.setToolTipText("Show password");
        add(passwordToggle);
        passwordToggle.setBounds(1044, 355, 50, 42);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel demo;
    public javax.swing.JTextField email;
    public javax.swing.JLabel emailLabel;
    public javax.swing.JLabel eyebrow;
    public javax.swing.JLabel intro;
    public javax.swing.JLabel loginSubtitle;
    public javax.swing.JLabel loginTitle;
    public javax.swing.JPasswordField password;
    public javax.swing.JLabel passwordLabel;
    public javax.swing.JToggleButton passwordToggle;
    public javax.swing.JPanel photoPanel;
    public javax.swing.JButton register;
    public javax.swing.JButton registerHost;
    public javax.swing.JComboBox role;
    public javax.swing.JLabel roleLabel;
    public javax.swing.JButton signIn;
    public javax.swing.JLabel tagline;
    public javax.swing.JLabel welcome;
    public keeptoo.KGradientPanel welcomePanel;
    // End of variables declaration//GEN-END:variables
}
