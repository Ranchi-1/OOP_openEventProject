// Beginner/intermediate edition: explicit classes, getters, loops and conventional listeners.
// Comments explain executable statements and logic; braces only group the statements.
// Groups this class with related OpenEvent classes in the same package.
package com.mycompany.openevent.ui;

// Imports JButton so this class can use that type by its short name.
import javax.swing.JButton;
// Imports JLabel so this class can use that type by its short name.
import javax.swing.JLabel;
// Imports JPanel so this class can use that type by its short name.
import javax.swing.JPanel;
// Imports JScrollPane so this class can use that type by its short name.
import javax.swing.JScrollPane;
// Imports UIManager so this class can use that type by its short name.
import javax.swing.UIManager;
// Imports EmptyBorder so this class can use that type by its short name.
import javax.swing.border.EmptyBorder;
// Imports LineBorder so this class can use that type by its short name.
import javax.swing.border.LineBorder;
// Imports CompoundBorder so this class can use that type by its short name.
import javax.swing.border.CompoundBorder;
// Imports BorderLayout so this class can use that type by its short name.
import java.awt.BorderLayout;
// Imports Color so this class can use that type by its short name.
import java.awt.Color;
// Imports Component so this class can use that type by its short name.
import java.awt.Component;
// Imports Container so this class can use that type by its short name.
import java.awt.Container;
// Imports Cursor so this class can use that type by its short name.
import java.awt.Cursor;
// Imports Font so this class can use that type by its short name.
import java.awt.Font;
// Imports GradientPaint so this class can use that type by its short name.
import java.awt.GradientPaint;
// Imports Graphics so this class can use that type by its short name.
import java.awt.Graphics;
// Imports Graphics2D so this class can use that type by its short name.
import java.awt.Graphics2D;
// Imports RenderingHints so this class can use that type by its short name.
import java.awt.RenderingHints;
// Imports BufferedImage so this class can use that type by its short name.
import java.awt.image.BufferedImage;
// Imports ImageIO so this class can use that type by its short name.
import javax.imageio.ImageIO;
// Imports Map so this class can use that type by its short name.
import java.util.Map;
// Imports HashMap so this class can use that type by its short name.
import java.util.HashMap;
// Imports Locale so this class can use that type by its short name.
import java.util.Locale;

// Defines the Theme class and keeps its related data and operations together.
public final class Theme {

    // Stores purple.
    public static final Color PURPLE = new Color(108, 59, 240);
    // Stores ink.
    public static final Color INK = new Color(33, 27, 53);
    // Stores muted.
    public static final Color MUTED = new Color(99, 91, 113);
    // Stores bg.
    public static final Color BG = new Color(247, 246, 251);
    // Stores line.
    public static final Color LINE = new Color(231, 227, 240);
    // Stores images.
    private static final Map<String, BufferedImage> IMAGES = new HashMap<String, BufferedImage>();

    // Constructs a Theme object and initializes or validates its starting state.
    private Theme() {
    }

    // Sets shared Swing fonts and colors before displaying the application.
    public static void install() {
        // Attempts the following operation and lets the catch block handle a failure.
        try {
            // Calls this operation to carry out the named step with the supplied arguments.
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        // Handles this error without reporting the failed operation as a success.
        catch (Exception ignored) {
        }
        // Stores this value under its key so it can be found again later.
        UIManager.put("Panel.background", BG);
        // Stores this value under its key so it can be found again later.
        UIManager.put("OptionPane.background", BG);
        // Stores this value under its key so it can be found again later.
        UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 14));
        // Stores this value under its key so it can be found again later.
        UIManager.put("Button.font", new Font("Segoe UI", Font.BOLD, 14));
        // Stores this value under its key so it can be found again later.
        UIManager.put("TextField.font", new Font("Segoe UI", Font.PLAIN, 15));
        // Stores this value under its key so it can be found again later.
        UIManager.put("ComboBox.font", new Font("Segoe UI", Font.PLAIN, 14));
        // Stores this value under its key so it can be found again later.
        UIManager.put("ScrollBar.width", 12);
    }

    // Applies consistent component styling; compact seat grids keep their own styling.
    public static void polish(Container root) {
        // Continues into this block only when the condition below is true.
        if (root instanceof SeatGrid || root instanceof VenueDesigner) {
            // Leaves this method now because there is no further work for this request.
            return;
        }
        // Visits each object in the collection using an ordinary enhanced for loop.
        for (Component c : root.getComponents()) {
            // Darker secondary text remains readable on the light page background.
            if(new Color(130,124,145).equals(c.getForeground())) { c.setForeground(MUTED); }
            // Continues into this block only when the condition below is true.
            if (c instanceof JButton) {
                // Prepares the local b value used in the following steps.
                JButton b = (JButton) c;
                // Sets the visible outline or empty padding around this component.
                b.setBorder(new EmptyBorder(9, 13, 9, 13));
                // Calls this operation to carry out the named step with the supplied arguments.
                b.setFocusPainted(true);
                // Controls whether the component paints its own background.
                b.setOpaque(true);
                // Changes the pointer appearance to communicate an action or a busy operation.
                b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            // Continues into this block only when the condition below is true.
            if (c instanceof javax.swing.text.JTextComponent) {
                // Prepares the local t value used in the following steps.
                javax.swing.text.JTextComponent t = (javax.swing.text.JTextComponent) c;
                // Sets the visible outline or empty padding around this component.
                t.setBorder(new CompoundBorder(new LineBorder(LINE, 1, true), new EmptyBorder(6, 12, 6, 12)));
                // Calls this operation to carry out the named step with the supplied arguments.
                t.setCaretColor(PURPLE);
            }
            // Continues into this block only when the condition below is true.
            if (c instanceof JScrollPane) {
                // Prepares the local s value used in the following steps.
                JScrollPane s = (JScrollPane) c;
                // Sets the visible outline or empty padding around this component.
                s.setBorder(new LineBorder(LINE, 1, true));
                // Sets this component color; the gradient start/end colors form the purple theme.
                s.getViewport().setBackground(BG);
                // Calls this operation to carry out the named step with the supplied arguments.
                s.getVerticalScrollBar().setUnitIncrement(24);
            }
            // Continues into this block only when the condition below is true.
            if (c instanceof JPanel && Color.WHITE.equals(c.getBackground())) {
                // Prepares the local p value used in the following steps.
                JPanel p = (JPanel) c;
                // Sets the visible outline or empty padding around this component.
                p.setBorder(new LineBorder(LINE, 1, true));
            }
            // Continues into this block only when the condition below is true.
            if (c instanceof Container) {
                // Prepares the local ct value used in the following steps.
                Container ct = (Container) c;
                // Calls this operation to carry out the named step with the supplied arguments.
                polish(ct);
            }
        }
    }

    // Creates a reusable label with the chosen font, weight and color.
    public static JLabel label(String text, int size, boolean bold, Color color) {
        // Prepares the local font style value used in the following steps.
        int fontStyle = Font.PLAIN;
        // Continues into this block only when the condition below is true.
        if (bold) {
            // Updates this working value before the next step.
            fontStyle = Font.BOLD;
        }
        // Prepares the local l value used in the following steps.
        JLabel l = new JLabel(text);
        // Sets the font family, style and point size used to draw this component.
        l.setFont(new Font("Segoe UI", fontStyle, size));
        // Sets the text or drawing color for this component.
        l.setForeground(color);
        // Returns this result to the method that called the current operation.
        return l;
    }

    // Creates a reusable purple action button.
    public static JButton button(String text) {
        // Prepares the local b value used in the following steps.
        JButton b = new JButton(text);
        // Sets this component color; the gradient start/end colors form the purple theme.
        b.setBackground(PURPLE);
        // Sets the text or drawing color for this component.
        b.setForeground(Color.WHITE);
        // Sets the font family, style and point size used to draw this component.
        b.setFont(new Font("Segoe UI", Font.BOLD, 14));
        // Sets the visible outline or empty padding around this component.
        b.setBorder(new EmptyBorder(11, 16, 11, 16));
        // Calls this operation to carry out the named step with the supplied arguments.
        b.setFocusPainted(true);
        // Changes the pointer appearance to communicate an action or a busy operation.
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        // Returns this result to the method that called the current operation.
        return b;
    }

    // Escapes user-supplied text before placing it inside Swing HTML labels.
    public static String html(String text) {
        // Continues into this block only when the condition below is true.
        if (text == null) {
            // Returns this result to the method that called the current operation.
            return "";
        }
        // Returns this result to the method that called the current operation.
        return text.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\n", "<br>");
    }

    // Formats a BigDecimal amount as Philippine peso text without changing the stored value.
    public static String money(java.math.BigDecimal n) {
        // Returns this result to the method that called the current operation.
        return "PHP " + String.format(java.util.Locale.US, "%,.2f", n);
    }

    // Creates an image panel that scales its photo and draws an optional caption.
    public static JPanel photo(String resource, String caption) {
        // Returns this result to the method that called the current operation.
        return new JPanel() {
            @Override
            // Draws a fitted image, a readable overlay, and its optional caption.
            protected void paintComponent(Graphics graphics) {
                // Calls this operation to carry out the named step with the supplied arguments.
                super.paintComponent(graphics);
                // Prepares the local g value used in the following steps.
                Graphics2D g = (Graphics2D) graphics.create();
                // Attempts the following operation and lets the catch block handle a failure.
                try {
                    // Prepares the local img value used in the following steps.
                    BufferedImage img = IMAGES.get(resource);
                    // Continues into this block only when the condition below is true.
                    if (img == null) {
                        // Opens these resources in try-with-resources so Java closes them automatically after this block.
                        try (java.io.InputStream in = Theme.class.getResourceAsStream("/assets/" + resource)) {
                            // Continues into this block only when the condition below is true.
                            if (in != null) {
                                // Decodes the bundled image so the panel can draw it.
                                img = ImageIO.read(in);
                            }
                        }
                        // Continues into this block only when the condition below is true.
                        if (img != null) {
                            // Stores this value under its key so it can be found again later.
                            IMAGES.put(resource, img);
                        }
                    }
                    // Continues into this block only when the condition below is true.
                    if (img != null) {
                        // Prepares the local s value used in the following steps.
                        double s = Math.max((double) getWidth() / img.getWidth(), (double) getHeight() / img.getHeight());
                        // Prepares the local w value used in the following steps.
                        int w = (int) (img.getWidth() * s);
                        // Prepares the local h value used in the following steps.
                        int h = (int) (img.getHeight() * s);
                        // Calls this operation to carry out the named step with the supplied arguments.
                        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                        // Draws the scaled image, centered so it fills the panel.
                        g.drawImage(img, (getWidth() - w) / 2, (getHeight() - h) / 2, w, h, null);
                    }
                    // Handles the remaining case after the earlier condition was false.
                    else {
                        // Calls this operation to carry out the named step with the supplied arguments.
                        g.setPaint(new GradientPaint(0, 0, PURPLE, getWidth(), getHeight(), INK));
                        // Calls this operation to carry out the named step with the supplied arguments.
                        g.fillRect(0, 0, getWidth(), getHeight());
                    }
                    // Calls this operation to carry out the named step with the supplied arguments.
                    g.setPaint(new GradientPaint(0, getHeight() / 3, new Color(0, 0, 0, 0), 0, getHeight(), new Color(10, 3, 29, 210)));
                    // Calls this operation to carry out the named step with the supplied arguments.
                    g.fillRect(0, 0, getWidth(), getHeight());
                    // Continues into this block only when the condition below is true.
                    if (caption != null) {
                        // Calls this operation to carry out the named step with the supplied arguments.
                        g.setColor(Color.WHITE);
                        // Sets the font family, style and point size used to draw this component.
                        g.setFont(new Font("Segoe UI", Font.BOLD, 21));
                        // Calls this operation to carry out the named step with the supplied arguments.
                        g.drawString(caption, 18, getHeight() - 23);
                    }
                }
                // Handles this error without reporting the failed operation as a success.
                catch (java.io.IOException ignored) {
                }
                // Runs this cleanup whether the preceding operation succeeds or fails.
                finally {
                    // Releases the temporary graphics context after painting.
                    g.dispose();
                }
            }
        };
    }

    // Replaces a placeholder panel with the runtime photo component.
    public static void fillPhoto(JPanel parent, String file, String caption) {
        // Removes the old child components before drawing the replacement content.
        parent.removeAll();
        // Chooses how child components are arranged inside this container.
        parent.setLayout(new BorderLayout());
        // Adds this object to the collection or this child component to its parent container.
        parent.add(photo(file, caption));
    }
}
