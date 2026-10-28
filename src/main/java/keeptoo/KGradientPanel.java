package keeptoo;

// A small project-owned JavaBean keeps existing NetBeans forms portable.
// It implements the two gradient properties used by OpenEvent; no external JAR is required.
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class KGradientPanel extends JPanel {
    // Standard JavaBean getters/setters let NetBeans Design edit these colors.
    private Color kStartColor = new Color(129,59,240);
    private Color kEndColor = new Color(67,55,217);

    public KGradientPanel() {
        // The gradient paints the background while Swing paints child controls normally.
        setOpaque(false);
    }
    public Color getkStartColor() { return kStartColor; }
    public void setkStartColor(Color color) {
        if(color==null) { throw new IllegalArgumentException("Choose a start color."); }
        kStartColor=color;repaint();
    }
    public Color getkEndColor() { return kEndColor; }
    public void setkEndColor(Color color) {
        if(color==null) { throw new IllegalArgumentException("Choose an end color."); }
        kEndColor=color;repaint();
    }
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        // Work on a copy so this component cannot change another component's drawing state.
        Graphics2D drawing=(Graphics2D)graphics.create();
        drawing.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        drawing.setPaint(new GradientPaint(0,0,kStartColor,Math.max(1,getWidth()),Math.max(1,getHeight()),kEndColor));
        drawing.fillRect(0,0,getWidth(),getHeight());
        drawing.dispose();
    }
}
