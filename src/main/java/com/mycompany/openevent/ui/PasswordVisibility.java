package com.mycompany.openevent.ui;

import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Connects one password field to its own accessible show/hide control.
 */
public class PasswordVisibility implements ActionListener {

    // Never copy password text into labels, logs or another field.
    private final JPasswordField field;
    private final JToggleButton button;
    private final char mask;

    public PasswordVisibility(JPasswordField field, JToggleButton button) {
        this.field = field;
        this.button = button;
        // Remember this Look and Feel's mask character for the Hide action.
        char echo = field.getEchoChar();
        if (echo == 0) {
            echo = '\u2022';
        }
        mask = echo;
        button.setText("");
        button.setIcon(new PasswordEyeIcon(false));
        button.setSelectedIcon(new PasswordEyeIcon(true));
        button.setFocusPainted(true);
        button.setMnemonic('V');
        button.addActionListener(this);
        hidePassword();
    }

    // New forms and submitted sign-ins always use the masked state.
    public void hidePassword() {
        button.setSelected(false);
        updateDisplay();
    }

    private void updateDisplay() {
        String action = "Show password";
        if (button.isSelected()) {
            field.setEchoChar((char) 0);
            action = "Hide password";
        } else {
            field.setEchoChar(mask);
        }
        // Tooltips and accessibility names describe the next available action.
        button.setToolTipText(action + " (Alt+V)");
        button.getAccessibleContext().setAccessibleName(action);
        button.getAccessibleContext().setAccessibleDescription("Toggle password visibility without changing the password.");
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        updateDisplay();
    }
}
