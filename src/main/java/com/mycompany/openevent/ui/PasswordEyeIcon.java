package com.mycompany.openevent.ui;
import javax.swing.Icon;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;

/** Draws a crisp eye icon without downloaded images or extra libraries. */
public class PasswordEyeIcon implements Icon {
    // A slash means the next button action will hide the currently visible password.
    private final boolean slash;
    public PasswordEyeIcon(boolean slash) { this.slash=slash; }
    @Override
    public int getIconWidth() { return 24; }
    @Override
    public int getIconHeight() { return 24; }
    @Override
    public void paintIcon(Component component,Graphics graphics,int x,int y) {
        // Use a copy so this icon cannot change the button's drawing settings.
        Graphics2D eye=(Graphics2D)graphics.create();
        eye.translate(x,y);
        eye.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        eye.setColor(new Color(108,59,240));
        if(!component.isEnabled()) { eye.setColor(Color.GRAY); }
        eye.setStroke(new BasicStroke(1.8f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
        // Two curves form the upper and lower eyelids.
        Path2D outline=new Path2D.Double();
        outline.moveTo(2,12);outline.quadTo(12,1,22,12);
        outline.quadTo(12,23,2,12);eye.draw(outline);
        eye.drawOval(9,9,6,6);
        if(slash) { eye.drawLine(3,3,21,21); }
        eye.dispose();
    }
}
