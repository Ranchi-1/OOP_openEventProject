// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
package com.mycompany.openevent.ui;

/**
* NetBeans GUI Builder form. Edit layout in Design; behavior lives outside
* generated code.
*/
// Defines a class that inherits the fields and behavior of its parent type.
public class LoginView extends javax.swing.JPanel {
    // This helper remembers the mask character and handles the eye button.
    private PasswordVisibility passwordVisibility;
    public void hidePassword() { passwordVisibility.hidePassword(); }

    // Constructs a LoginView object and initializes or validates its starting state.
    public LoginView() {
        // Calls this operation to carry out the named step with the supplied arguments.
        initComponents();
        // Keep behavior outside generated layout code, so NetBeans can regenerate the form.
        passwordVisibility=new PasswordVisibility(password,passwordToggle);
    }

    @SuppressWarnings({
        "unchecked", "rawtypes"
    })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // NetBeans generates this layout code from the matching .form file; positions are measured in pixels.
    private void initComponents(){
        // Updates this working value before the next step.
        welcomePanel=new keeptoo.KGradientPanel();
        // Updates this working value before the next step.
        eyebrow=new javax.swing.JLabel();
        // Updates this working value before the next step.
        welcome=new javax.swing.JLabel();
        // Updates this working value before the next step.
        intro=new javax.swing.JLabel();
        // Updates this working value before the next step.
        photoPanel=new javax.swing.JPanel();
        // Updates this working value before the next step.
        tagline=new javax.swing.JLabel();
        // Updates this working value before the next step.
        loginTitle=new javax.swing.JLabel();
        // Updates this working value before the next step.
        loginSubtitle=new javax.swing.JLabel();
        // Updates this working value before the next step.
        roleLabel=new javax.swing.JLabel();
        // Updates this working value before the next step.
        role=new javax.swing.JComboBox();
        // Updates this working value before the next step.
        emailLabel=new javax.swing.JLabel();
        // Updates this working value before the next step.
        email=new javax.swing.JTextField();
        // Updates this working value before the next step.
        passwordLabel=new javax.swing.JLabel();
        // Updates this working value before the next step.
        password=new javax.swing.JPasswordField();
        // GUI Builder component; the helper installs its scalable icon at runtime.
        passwordToggle=new javax.swing.JToggleButton();
        // Updates this working value before the next step.
        signIn=new javax.swing.JButton();
        // Updates this working value before the next step.
        register=new javax.swing.JButton();
        registerHost=new javax.swing.JButton();
        // Updates this working value before the next step.
        demo=new javax.swing.JLabel();
        // Calls this operation to carry out the named step with the supplied arguments.
        setLayout(null);
        // Calls this operation to carry out the named step with the supplied arguments.
        setBackground(new java.awt.Color(247,246,251));
        // Calls this operation to carry out the named step with the supplied arguments.
        setPreferredSize(new java.awt.Dimension(1176,660));
        // Sets the font family, style and point size used to draw this component.
        welcomePanel.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        welcomePanel.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        welcomePanel.setkStartColor(new java.awt.Color(129,59,240));
        // Sets this component color; the gradient start/end colors form the purple theme.
        welcomePanel.setkEndColor(new java.awt.Color(67,55,217));
        // Chooses how child components are arranged inside this container.
        welcomePanel.setLayout(null);
        // Displays this text in the named Swing component.
        eyebrow.setText("INDEPENDENT SOUNDS. SHARED SPACES.");
        // Sets the font family, style and point size used to draw this component.
        eyebrow.setFont(new java.awt.Font("Segoe UI",1,12));
        // Sets the text or drawing color for this component.
        eyebrow.setForeground(new java.awt.Color(233,223,255));
        // Positions this component using x, y, width and height, measured in pixels.
        eyebrow.setBounds(32,28,470,25);
        // Adds this object to the collection or this child component to its parent container.
        welcomePanel.add(eyebrow);
        // Displays this text in the named Swing component.
        welcome.setText("<html>Your next great night<br>starts here.</html>");
        // Sets the font family, style and point size used to draw this component.
        welcome.setFont(new java.awt.Font("Segoe UI",1,38));
        // Sets the text or drawing color for this component.
        welcome.setForeground(new java.awt.Color(255,255,255));
        // Positions this component using x, y, width and height, measured in pixels.
        welcome.setBounds(32,80,470,120);
        // Adds this object to the collection or this child component to its parent container.
        welcomePanel.add(welcome);
        // Displays this text in the named Swing component.
        intro.setText("Find your people. Support a local stage.");
        // Sets the font family, style and point size used to draw this component.
        intro.setFont(new java.awt.Font("Segoe UI",0,16));
        // Sets the text or drawing color for this component.
        intro.setForeground(new java.awt.Color(240,229,255));
        // Positions this component using x, y, width and height, measured in pixels.
        intro.setBounds(32,216,470,30);
        // Adds this object to the collection or this child component to its parent container.
        welcomePanel.add(intro);
        // Sets the font family, style and point size used to draw this component.
        photoPanel.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        photoPanel.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        photoPanel.setBackground(new java.awt.Color(255,255,255));
        // Chooses how child components are arranged inside this container.
        photoPanel.setLayout(null);
        // Positions this component using x, y, width and height, measured in pixels.
        photoPanel.setBounds(24,302,492,210);
        // Adds this object to the collection or this child component to its parent container.
        welcomePanel.add(photoPanel);
        // Displays this text in the named Swing component.
        tagline.setText("OpenEvent / For the independent scene.");
        // Sets the font family, style and point size used to draw this component.
        tagline.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        tagline.setForeground(new java.awt.Color(231,223,255));
        // Positions this component using x, y, width and height, measured in pixels.
        tagline.setBounds(32,540,460,25);
        // Adds this object to the collection or this child component to its parent container.
        welcomePanel.add(tagline);
        // Positions this component using x, y, width and height, measured in pixels.
        welcomePanel.setBounds(32,24,540,600);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(welcomePanel);
        // Displays this text in the named Swing component.
        loginTitle.setText("Welcome back.");
        // Sets the font family, style and point size used to draw this component.
        loginTitle.setFont(new java.awt.Font("Segoe UI",1,32));
        // Sets the text or drawing color for this component.
        loginTitle.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        loginTitle.setBounds(644,54,460,50);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(loginTitle);
        // Displays this text in the named Swing component.
        loginSubtitle.setText("Sign in to find a seat or bring your next event to life.");
        // Sets the font family, style and point size used to draw this component.
        loginSubtitle.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        loginSubtitle.setForeground(new java.awt.Color(130,124,145));
        // Positions this component using x, y, width and height, measured in pixels.
        loginSubtitle.setBounds(644,108,460,25);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(loginSubtitle);
        // Displays this text in the named Swing component.
        roleLabel.setText("I am signing in as");
        // Sets the font family, style and point size used to draw this component.
        roleLabel.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        roleLabel.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        roleLabel.setBounds(644,162,400,25);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(roleLabel);
        // Sets the font family, style and point size used to draw this component.
        role.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        role.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        role.setBackground(new java.awt.Color(255,255,255));
        // Supplies the list, combo-box or table data displayed by this control.
        role.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[]{"Customer","Host"}));
        // Positions this component using x, y, width and height, measured in pixels.
        role.setBounds(644,191,450,40);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(role);
        // Displays this text in the named Swing component.
        emailLabel.setText("Email address");
        // Sets the font family, style and point size used to draw this component.
        emailLabel.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        emailLabel.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        emailLabel.setBounds(644,244,400,25);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(emailLabel);
        // Sets the font family, style and point size used to draw this component.
        email.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        email.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        email.setBackground(new java.awt.Color(255,255,255));
        // Positions this component using x, y, width and height, measured in pixels.
        email.setBounds(644,273,450,42);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(email);
        // Displays this text in the named Swing component.
        passwordLabel.setText("Password");
        // Sets the font family, style and point size used to draw this component.
        passwordLabel.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        passwordLabel.setForeground(new java.awt.Color(33,27,53));
        // Positions this component using x, y, width and height, measured in pixels.
        passwordLabel.setBounds(644,326,400,25);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(passwordLabel);
        // Sets the font family, style and point size used to draw this component.
        password.setFont(new java.awt.Font("Segoe UI",0,14));
        // Sets the text or drawing color for this component.
        password.setForeground(new java.awt.Color(33,27,53));
        // Sets this component color; the gradient start/end colors form the purple theme.
        password.setBackground(new java.awt.Color(255,255,255));
        // Positions this component using x, y, width and height, measured in pixels.
        password.setBounds(644,355,390,42);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(password);
        passwordToggle.setToolTipText("Show password");
        passwordToggle.setBackground(new java.awt.Color(238,232,254));
        passwordToggle.setBounds(1044,355,50,42);
        add(passwordToggle);
        // Displays this text in the named Swing component.
        signIn.setText("Sign in  →");
        // Sets the font family, style and point size used to draw this component.
        signIn.setFont(new java.awt.Font("Segoe UI",1,14));
        // Sets the text or drawing color for this component.
        signIn.setForeground(new java.awt.Color(255,255,255));
        // Sets this component color; the gradient start/end colors form the purple theme.
        signIn.setBackground(new java.awt.Color(108,59,240));
        // Calls this operation to carry out the named step with the supplied arguments.
        signIn.setFocusPainted(false);
        // Changes the pointer appearance to communicate an action or a busy operation.
        signIn.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        // Positions this component using x, y, width and height, measured in pixels.
        signIn.setBounds(644,420,450,46);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(signIn);
        // Displays this text in the named Swing component.
        register.setText("Create Customer account");
        // Sets the font family, style and point size used to draw this component.
        register.setFont(new java.awt.Font("Segoe UI",1,14));
        // Sets the text or drawing color for this component.
        register.setForeground(new java.awt.Color(108,59,240));
        // Sets this component color; the gradient start/end colors form the purple theme.
        register.setBackground(new java.awt.Color(238,232,254));
        // Calls this operation to carry out the named step with the supplied arguments.
        register.setFocusPainted(false);
        // Changes the pointer appearance to communicate an action or a busy operation.
        register.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        // Positions this component using x, y, width and height, measured in pixels.
        register.setBounds(644,480,220,42);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(register);
        // Separate account buttons make the chosen account role explicit.
        registerHost.setText("Create Host account");
        registerHost.setFont(new java.awt.Font("Segoe UI",1,14));
        registerHost.setForeground(new java.awt.Color(108,59,240));
        registerHost.setBackground(new java.awt.Color(238,232,254));
        registerHost.setBounds(874,480,220,42);
        add(registerHost);
        // Displays this text in the named Swing component.
        demo.setText("<html>CLASSROOM DEMO<br>alex@openevent.local · host@openevent.local<br>Password: OpenEvent2026!</html>");
        // Sets the font family, style and point size used to draw this component.
        demo.setFont(new java.awt.Font("Segoe UI",0,13));
        // Sets the text or drawing color for this component.
        demo.setForeground(new java.awt.Color(130,124,145));
        // Positions this component using x, y, width and height, measured in pixels.
        demo.setBounds(644,548,460,68);
        // Calls this operation to carry out the named step with the supplied arguments.
        add(demo);
    }
    // </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Stores welcome panel.
    public keeptoo.KGradientPanel welcomePanel;
    // Stores eyebrow.
    public javax.swing.JLabel eyebrow;
    // Stores welcome.
    public javax.swing.JLabel welcome;
    // Stores intro.
    public javax.swing.JLabel intro;
    // Stores photo panel.
    public javax.swing.JPanel photoPanel;
    // Stores tagline.
    public javax.swing.JLabel tagline;
    // Stores login title.
    public javax.swing.JLabel loginTitle;
    // Stores login subtitle.
    public javax.swing.JLabel loginSubtitle;
    // Stores role label.
    public javax.swing.JLabel roleLabel;
    // Stores role.
    public javax.swing.JComboBox role;
    // Stores email label.
    public javax.swing.JLabel emailLabel;
    // Stores email.
    public javax.swing.JTextField email;
    // Stores password label.
    public javax.swing.JLabel passwordLabel;
    // Stores password.
    public javax.swing.JPasswordField password;
    // The eye control remains selectable and movable in NetBeans Design.
    public javax.swing.JToggleButton passwordToggle;
    // Stores sign in.
    public javax.swing.JButton signIn;
    // Stores register.
    public javax.swing.JButton register;
    // Host sign-up control remains editable in NetBeans Design.
    public javax.swing.JButton registerHost;
    // Stores demo.
    public javax.swing.JLabel demo;
    // End of variables declaration//GEN-END:variables
}
