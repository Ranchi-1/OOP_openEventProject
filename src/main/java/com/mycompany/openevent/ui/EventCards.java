package com.mycompany.openevent.ui;
import javax.swing.JPanel;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/** Uses fewer columns on narrow windows instead of squeezing event cards or adding side scrolling. */
public class EventCards extends JPanel implements Scrollable {
    private final GridLayout grid=new GridLayout(0,3,18,18);
    public EventCards() {
        setLayout(grid);setBackground(Theme.BG);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent event) { updateColumns(); }
        });
    }
    public void updateColumns() {
        int columns=Math.max(1,Math.min(3,getWidth()/320));
        grid.setColumns(columns);
        int rows=Math.max(1,(getComponentCount()+columns-1)/columns);
        setPreferredSize(new Dimension(300,rows*290));revalidate();
    }
    @Override
    public Dimension getPreferredScrollableViewportSize() { return new Dimension(900,320); }
    @Override
    public int getScrollableUnitIncrement(Rectangle visible,int orientation,int direction) { return 26; }
    @Override
    public int getScrollableBlockIncrement(Rectangle visible,int orientation,int direction) { return Math.max(26,visible.height-40); }
    @Override
    public boolean getScrollableTracksViewportWidth() { return true; }
    @Override
    public boolean getScrollableTracksViewportHeight() { return false; }
}
