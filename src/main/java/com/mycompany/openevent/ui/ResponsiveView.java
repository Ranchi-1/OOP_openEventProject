package com.mycompany.openevent.ui;
import javax.swing.JPanel;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.LinkedHashMap;
import java.util.Map;

/** Adapts existing Palette forms horizontally while retaining their editable reference layout. */
public class ResponsiveView extends JPanel implements Scrollable {
    private final JPanel content;
    private final int referenceWidth;
    // Remember the original bounds once; never repeatedly scale already scaled coordinates.
    private final Map<Component,Rectangle> bounds=new LinkedHashMap<Component,Rectangle>();
    private final Map<Component,Font> fonts=new LinkedHashMap<Component,Font>();
    public ResponsiveView(JPanel content,int referenceWidth) {
        super(new BorderLayout());this.content=content;this.referenceWidth=referenceWidth;
        capture(content);add(content,BorderLayout.CENTER);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent event) { fitWidth(); }
        });
    }
    private void capture(Container parent) {
        // Layout-managed components, such as the map and seat grid, resize themselves.
        if(parent.getLayout()!=null) { return; }
        for(Component child:parent.getComponents()) {
            bounds.put(child,new Rectangle(child.getBounds()));fonts.put(child,child.getFont());
            if(child instanceof Container) { capture((Container)child); }
        }
    }
    public void fitWidth() {
        if(getWidth()<=0) { return; }
        double factor=Math.min(1.0,(double)getWidth()/referenceWidth);
        int center=Math.max(0,(getWidth()-referenceWidth)/2);
        for(Map.Entry<Component,Rectangle> entry:bounds.entrySet()) {
            Component child=entry.getKey();Rectangle original=entry.getValue();
            int offset=0;if(child.getParent()==content) { offset=center; }
            child.setBounds(offset+(int)Math.round(original.x*factor),original.y,
                Math.max(1,(int)Math.round(original.width*factor)),original.height);
            Font originalFont=fonts.get(child);
            if(originalFont!=null) {
                float minimum=Math.min(12,originalFont.getSize());
                child.setFont(originalFont.deriveFont(Math.max(minimum,(float)(originalFont.getSize()*factor))));
            }
        }
        content.revalidate();content.repaint();
    }
    @Override
    public Dimension getPreferredSize() { return content.getPreferredSize(); }
    @Override
    public Dimension getPreferredScrollableViewportSize() { return content.getPreferredSize(); }
    @Override
    public int getScrollableUnitIncrement(Rectangle visible,int orientation,int direction) { return 26; }
    @Override
    public int getScrollableBlockIncrement(Rectangle visible,int orientation,int direction) {
        if(orientation==SwingConstants.VERTICAL) { return Math.max(26,visible.height-40); }
        return Math.max(26,visible.width-40);
    }
    @Override
    public boolean getScrollableTracksViewportWidth() { return true; }
    @Override
    public boolean getScrollableTracksViewportHeight() { return false; }
}
