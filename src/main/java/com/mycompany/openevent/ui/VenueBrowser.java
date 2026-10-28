package com.mycompany.openevent.ui;
// Import VenueLayout for the explicit types used below.
import com.mycompany.openevent.model.VenueLayout;
// Import VenuePlan for the explicit types used below.
import com.mycompany.openevent.model.VenuePlan;
// Import VenueArea for the explicit types used below.
import com.mycompany.openevent.model.VenueArea;
// Import Seat for the explicit types used below.
import com.mycompany.openevent.model.Seat;
// Import JPanel for the explicit types used below.
import javax.swing.JPanel;
// Import JButton for the explicit types used below.
import javax.swing.JButton;
// Import JLabel for the explicit types used below.
import javax.swing.JLabel;
// Import JScrollPane for the explicit types used below.
import javax.swing.JScrollPane;
// Import BorderLayout for the explicit types used below.
import java.awt.BorderLayout;
// Import Dimension for the explicit types used below.
import java.awt.Dimension;
// Import ActionEvent for the explicit types used below.
import java.awt.event.ActionEvent;
// Import ActionListener for the explicit types used below.
import java.awt.event.ActionListener;
// Import List for the explicit types used below.
import java.util.List;
// Import ArrayList for the explicit types used below.
import java.util.ArrayList;

/** Customer overview opens one physical section at a time for readable seat buttons. */
public class VenueBrowser extends JPanel {
    // Keep layout private so outside classes use the public operations.
    private final VenueLayout layout;
    // Keep listener private so outside classes use the public operations.
    private final SeatGrid.SeatSelectionListener listener;
    public VenueBrowser(VenueLayout layout,SeatGrid.SeatSelectionListener listener) {
        super(new BorderLayout(6,6)); this.layout=layout;this.listener=listener;
        setPreferredSize(new Dimension(700,480));showOverview();
    }
    private void showOverview() {
        listener.seatSelected(null);
        removeAll();
        add(new JLabel("Choose a colored section to view its assigned seats."),BorderLayout.NORTH);
        add(new VenueCanvas(layout.getPlan(),false,new VenueCanvas.Listener() {
            @Override
            public void selected(int index) { if(index>=0) { showSection(index); } }
            @Override
            public void moved(int index,int x,int y) { }
        }),BorderLayout.CENTER);
        // Named price tags make the color meaning visible before a section is opened.
        JPanel tags=new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT,6,3));
        java.util.Set<String> used=new java.util.HashSet<String>();
        for(VenueArea area:layout.getPlan().getAreas()) {
            if(used.add(area.getTypeCode())) {
                com.mycompany.openevent.model.TicketType type=layout.getPlan().getType(area.getTypeCode());
                JLabel tag=new JLabel(type.toString());tag.setOpaque(true);
                tag.setBackground(java.awt.Color.decode(type.getColor()));tag.setForeground(VenueCanvas.contrast(tag.getBackground()));
                tag.setBorder(javax.swing.BorderFactory.createEmptyBorder(4,8,4,8));tags.add(tag);
            }
        }
        JScrollPane legend=new JScrollPane(tags,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        legend.setPreferredSize(new Dimension(500,48));add(legend,BorderLayout.SOUTH);
        revalidate();repaint();
    }
    private void showSection(int index) {
        listener.seatSelected(null);
        VenueArea area=layout.getPlan().getAreas().get(index);
        List<Seat> seats=new ArrayList<Seat>();
        // Visit each relevant item using an ordinary loop.
        for(Seat seat:layout.getSeats()) {
            // Validate this condition before continuing with the operation.
            if(area.getCode().equals(seat.getAreaCode())) { seats.add(seat); }
        }
        removeAll();
        JButton back=new JButton("← Venue overview");
        int available=0;
        for(Seat seat:seats) { if(seat.isAvailable()) { available++; } }
        JPanel header=new JPanel(new BorderLayout(8,4));
        JLabel detail=new JLabel("<html><b>"+Theme.html(area.getName())+"</b> · "+Theme.html(layout.getPlan().getType(area.getTypeCode()).toString())
            +"<br>"+available+" of "+seats.size()+" seats available. Gray × means already sold.</html>");
        header.add(back,BorderLayout.WEST);header.add(detail,BorderLayout.CENTER);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) { showOverview(); }
        });
        add(header,BorderLayout.NORTH);
        SeatGrid grid=new SeatGrid(seats,area.getRows(),area.getColumns(),area.getRowOffset(),listener);
        grid.setPreferredSize(new Dimension(Math.max(500,area.getColumns()*55),Math.max(300,area.getRows()*45)));
        add(new JScrollPane(grid),BorderLayout.CENTER);
        revalidate();repaint();
    }
}
