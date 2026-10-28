package com.mycompany.openevent.ui;
// Import VenuePlan for the explicit types used below.
import com.mycompany.openevent.model.VenuePlan;
// Import VenueArea for the explicit types used below.
import com.mycompany.openevent.model.VenueArea;
// Import Stage for the explicit types used below.
import com.mycompany.openevent.model.Stage;
// Import JPanel for the explicit types used below.
import javax.swing.JPanel;
// Import ToolTipManager for the explicit types used below.
import javax.swing.ToolTipManager;
// Import Color for the explicit types used below.
import java.awt.Color;
// Import Dimension for the explicit types used below.
import java.awt.Dimension;
// Import Font for the explicit types used below.
import java.awt.Font;
// Import Graphics for the explicit types used below.
import java.awt.Graphics;
// Import Graphics2D for the explicit types used below.
import java.awt.Graphics2D;
// Import RenderingHints for the explicit types used below.
import java.awt.RenderingHints;
// Import Shape for the explicit types used below.
import java.awt.Shape;
// Import BasicStroke for the explicit types used below.
import java.awt.BasicStroke;
// Import Path2D for the explicit types used below.
import java.awt.geom.Path2D;
// Import Rectangle2D for the explicit types used below.
import java.awt.geom.Rectangle2D;
// Import MouseAdapter for the explicit types used below.
import java.awt.event.MouseAdapter;
// Import MouseEvent for the explicit types used below.
import java.awt.event.MouseEvent;

/** Scales logical venue coordinates to fit; seat positions do not depend on screen size. */
public class VenueCanvas extends JPanel {
    public interface Listener {
        void selected(int index);
        void moved(int index,int x,int y);
    }
    // Optional editor callbacks keep the Customer browser read-only.
    public interface EditorListener extends Listener {
        void resized(int index,int width,int height);
        void opened(int index);
        void placed(int x,int y);
    }
    private boolean resizing;
    private int previewX,previewY;
    private VenuePlan plan;
    // Keep listener private so outside classes use the public operations.
    private final Listener listener;
    // Keep editable private so outside classes use the public operations.
    private final boolean editable;
    private int selected=-2;
    private int pressX,pressY;
    private double scale=1;
    private double offsetX,offsetY;
    public VenueCanvas(VenuePlan plan,boolean editable,Listener listener) {
        // Store the validated constructor values in this object.
        this.plan=plan; this.editable=editable; this.listener=listener;
        setBackground(Color.WHITE); setPreferredSize(new Dimension(720,500));
        ToolTipManager.sharedInstance().registerComponent(this);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                // Hit-testing uses the same transform and shapes as painting.
                int x=logicalX(event.getX()); int y=logicalY(event.getY());
                selected=hit(x,y); pressX=x; pressY=y;previewX=0;previewY=0;
                resizing=false;
                if(editable && listener instanceof EditorListener && selected>=-1) {
                    java.awt.Rectangle bounds=plan.getStage().getBounds();
                    if(selected>=0) { bounds=plan.getAreas().get(selected).getBounds(); }
                    resizing=x>=bounds.x+bounds.width-22 && y>=bounds.y+bounds.height-22;
                }
                listener.selected(selected); repaint();
            }
            @Override
            public void mouseReleased(MouseEvent event) {
                // Validate this condition before continuing with the operation.
                if(!VenueCanvas.this.editable) { return; }
                if(selected < -1) {
                    if(listener instanceof EditorListener) { ((EditorListener)listener).placed(logicalX(event.getX()),logicalY(event.getY())); }
                    return;
                }
                int dx=logicalX(event.getX())-pressX;
                int dy=logicalY(event.getY())-pressY;
                // Validate this condition before continuing with the operation.
                previewX=0;previewY=0;
                if(Math.abs(dx)+Math.abs(dy)<5) {
                    if(listener instanceof EditorListener && !resizing) { ((EditorListener)listener).opened(selected); }
                    repaint();return;
                }
                if(resizing && listener instanceof EditorListener) {
                    java.awt.Rectangle bounds=plan.getStage().getBounds();
                    if(selected>=0) { bounds=plan.getAreas().get(selected).getBounds(); }
                    ((EditorListener)listener).resized(selected,bounds.width+dx,bounds.height+dy);
                    repaint();return;
                }
                int x=plan.getStage().getX(); int y=plan.getStage().getY();
                // Validate this condition before continuing with the operation.
                if(selected>=0) { x=plan.getAreas().get(selected).getX(); y=plan.getAreas().get(selected).getY(); }
                listener.moved(selected,x+dx,y+dy);
            }
        });
        // A temporary outline follows the pointer while the actual validated plan stays unchanged.
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent event) {
                if(editable && selected>=-1) {
                    previewX=logicalX(event.getX())-pressX;
                    previewY=logicalY(event.getY())-pressY;
                    repaint();
                }
            }
        });
    }
    public void setPlan(VenuePlan plan) { this.plan=plan; repaint(); }
    public void select(int index) { selected=index; repaint(); }
    private int logicalX(int x) { return (int)((x-offsetX)/scale); }
    private int logicalY(int y) { return (int)((y-offsetY)/scale); }
    private Shape areaShape(VenueArea area) {
        // Validate this condition before continuing with the operation.
        if("RECTANGLE".equals(area.getShape())) { return area.getBounds(); }
        // A simple trapezoid gives fan templates angled sides without a drawing toolkit.
        Path2D path=new Path2D.Double();
        double inset=area.getWidth()*0.15;
        path.moveTo(area.getX()+inset,area.getY());
        path.lineTo(area.getX()+area.getWidth()-inset,area.getY());
        path.lineTo(area.getX()+area.getWidth(),area.getY()+area.getHeight());
        path.lineTo(area.getX(),area.getY()+area.getHeight()); path.closePath();
        return path;
    }
    private int hit(int x,int y) {
        // Validate this condition before continuing with the operation.
        if(plan.getStage().getBounds().contains(x,y)) { return -1; }
        // Visit each relevant item using an ordinary loop.
        for(int i=0;i<plan.getAreas().size();i++) {
            // Validate this condition before continuing with the operation.
            if(areaShape(plan.getAreas().get(i)).contains(x,y)) { return i; }
        }
        return -2;
    }
    @Override
    public String getToolTipText(MouseEvent event) {
        int index=hit(logicalX(event.getX()),logicalY(event.getY()));
        // Validate this condition before continuing with the operation.
        if(index==-1) { return "Stage"; }
        // Validate this condition before continuing with the operation.
        if(index>=0) {
            VenueArea area=plan.getAreas().get(index);
            if(editable) { return area.getName()+" · Click for seats. Drag to move; drag the corner to resize."; }
            return area.getName()+" · "+plan.getType(area.getTypeCode()).toString()+" · Click to view seats";
        }
        return "Venue overview";
    }
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g=(Graphics2D)graphics.create();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        // Uniform scaling preserves section proportions on different window sizes.
        scale=Math.min((getWidth()-20)/1000.0,(getHeight()-20)/700.0);
        // Validate this condition before continuing with the operation.
        if(scale<=0) { g.dispose(); return; }
        offsetX=(getWidth()-1000*scale)/2; offsetY=(getHeight()-700*scale)/2;
        g.translate(offsetX,offsetY); g.scale(scale,scale);
        g.setColor(new Color(247,246,251)); g.fillRoundRect(0,0,1000,700,24,24);
        Stage stage=plan.getStage();
        g.setColor(Theme.INK); g.fill(stage.getBounds());
        drawText(g,"STAGE",stage.getX(),stage.getY(),stage.getWidth(),stage.getHeight(),Color.WHITE);
        // Visit each relevant item using an ordinary loop.
        for(int i=0;i<plan.getAreas().size();i++) {
            VenueArea area=plan.getAreas().get(i);
            Shape shape=areaShape(area);
            g.setColor(gColor(area)); g.fill(shape);
            g.setStroke(new BasicStroke(3)); g.setColor(Color.WHITE); g.draw(shape);
            drawText(g,area.getName(),area.getX(),area.getY(),area.getWidth(),area.getHeight(),contrast(gColor(area)));
            // Validate this condition before continuing with the operation.
            if(selected==i) { g.setColor(Theme.INK); g.setStroke(new BasicStroke(5)); g.draw(shape); }
        }
        // Validate this condition before continuing with the operation.
        if(selected==-1) { g.setColor(Theme.PURPLE);g.setStroke(new BasicStroke(5));g.draw(stage.getBounds()); }
        if(editable && listener instanceof EditorListener && selected>=-1) {
            java.awt.Rectangle bounds=stage.getBounds();
            if(selected>=0) { bounds=plan.getAreas().get(selected).getBounds(); }
            g.setColor(Theme.PURPLE);
            g.fillRect(bounds.x+bounds.width-18,bounds.y+bounds.height-18,18,18);
            if(previewX!=0 || previewY!=0) {
                int x=bounds.x;int y=bounds.y;int width=bounds.width;int height=bounds.height;
                if(resizing) { width+=previewX;height+=previewY; }
                else { x+=previewX;y+=previewY; }
                g.setStroke(new BasicStroke(3));g.drawRect(x,y,Math.max(1,width),Math.max(1,height));
            }
        }
        if(plan.getAreas().isEmpty()) {
            drawText(g,"Add a section, then click an empty space",160,300,680,70,Theme.MUTED);
        }
        g.dispose();
    }
    private Color gColor(VenueArea area) {
        String color=area.getColor();
        if(color==null) { color=plan.getType(area.getTypeCode()).getColor(); }
        return Color.decode(color);
    }
    public static Color contrast(Color color) {
        // Validate this condition before continuing with the operation.
        if(color.getRed()*0.299+color.getGreen()*0.587+color.getBlue()*0.114>155) { return Theme.INK; }
        return Color.WHITE;
    }
    private void drawText(Graphics2D g,String text,int x,int y,int width,int height,Color color) {
        // Shrink long names instead of clipping labels out of their section.
        int size=24;
        g.setFont(new Font("Segoe UI",Font.BOLD,size));
        while(g.getFontMetrics().stringWidth(text)>width-18 && size>10) {
            size--; g.setFont(new Font("Segoe UI",Font.BOLD,size));
        }
        // Very narrow sections use an ellipsis; the tooltip retains the complete name.
        String shown=text;
        if(g.getFontMetrics().stringWidth(shown)>width-18) {
            while(shown.length()>1 && g.getFontMetrics().stringWidth(shown+"…")>width-18) {
                shown=shown.substring(0,shown.length()-1);
            }
            shown=shown+"…";
        }
        g.setColor(color);
        g.drawString(shown,x+(width-g.getFontMetrics().stringWidth(shown))/2,y+height/2+g.getFontMetrics().getAscent()/3);
    }
}
