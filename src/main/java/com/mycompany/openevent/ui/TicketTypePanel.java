package com.mycompany.openevent.ui;
// Import TicketType for the explicit types used below.
import com.mycompany.openevent.model.TicketType;
// Import JPanel for the explicit types used below.
import javax.swing.JPanel;
// Import JList for the explicit types used below.
import javax.swing.JList;
// Import DefaultListModel for the explicit types used below.
import javax.swing.DefaultListModel;
// Import JScrollPane for the explicit types used below.
import javax.swing.JScrollPane;
// Import JTextField for the explicit types used below.
import javax.swing.JTextField;
// Import JCheckBox for the explicit types used below.
import javax.swing.JCheckBox;
// Import JButton for the explicit types used below.
import javax.swing.JButton;
// Import JLabel for the explicit types used below.
import javax.swing.JLabel;
// Import JOptionPane for the explicit types used below.
import javax.swing.JOptionPane;
// Import JColorChooser for the explicit types used below.
import javax.swing.JColorChooser;
// Import ListSelectionListener for the explicit types used below.
import javax.swing.event.ListSelectionListener;
// Import ListSelectionEvent for the explicit types used below.
import javax.swing.event.ListSelectionEvent;
// Import BorderLayout for the explicit types used below.
import java.awt.BorderLayout;
// Import GridLayout for the explicit types used below.
import java.awt.GridLayout;
// Import Color for the explicit types used below.
import java.awt.Color;
// Import ActionListener for the explicit types used below.
import java.awt.event.ActionListener;
// Import ActionEvent for the explicit types used below.
import java.awt.event.ActionEvent;
// Import BigDecimal for the explicit types used below.
import java.math.BigDecimal;
// Import ArrayList for the explicit types used below.
import java.util.ArrayList;
// Import List for the explicit types used below.
import java.util.List;
// Import Set for the explicit types used below.
import java.util.Set;
// Import UUID for the explicit types used below.
import java.util.UUID;

/** A small reusable form for custom ticket names, prices, colors and discounts. */
public class TicketTypePanel extends JPanel implements ActionListener {
    private final DefaultListModel<TicketType> model=new DefaultListModel<TicketType>();
    private final JList<TicketType> list=new JList<TicketType>(model);
    private final JTextField name=new JTextField();
    private final JTextField price=new JTextField();
    private final JCheckBox early=new JCheckBox("Allow 20% Early Bird discount before event cutoff");
    private final JButton color=new JButton("Choose color");
    // Keep assigned private so outside classes use the public operations.
    private final Set<String> assigned;
    private boolean changing;
    private int editingIndex=-1;
    private String hex="#2AA89B";
    public TicketTypePanel(List<TicketType> types,Set<String> assigned) {
        super(new BorderLayout(8,8)); this.assigned=assigned;
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10,10,10,10));
        name.getAccessibleContext().setAccessibleName("Ticket name");
        price.getAccessibleContext().setAccessibleName("Ticket price");
        list.getAccessibleContext().setAccessibleName("Ticket types");
        // Visit each relevant item using an ordinary loop.
        for(TicketType type:types) { model.addElement(type); }
        add(new JScrollPane(list),BorderLayout.CENTER);
        JPanel fields=new JPanel(new GridLayout(0,1,5,5));
        fields.add(new JLabel("Ticket name"));fields.add(name);
        fields.add(new JLabel("Price (PHP)"));fields.add(price);fields.add(color);fields.add(early);
        JPanel actions=new JPanel(new GridLayout(1,3,5,5));
        // Visit each relevant item using an ordinary loop.
        for(String command:new String[]{"Add","Apply","Remove"}) {
            JButton button=new JButton(command);button.addActionListener(this);actions.add(button);
        }
        fields.add(actions);
        fields.add(new JLabel("Edits are kept when switching types. Purchased tickets keep their original details."));
        add(fields,BorderLayout.SOUTH);
        color.addActionListener(this);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) { if(!changing && !event.getValueIsAdjusting()) { changeSelection(); } }
        });
        // Validate this condition before continuing with the operation.
        if(!types.isEmpty()) { list.setSelectedIndex(0); }
    }
    private void changeSelection() {
        int requested=list.getSelectedIndex();
        if(requested==editingIndex || requested<0) { return; }
        try {
            if(editingIndex>=0) { apply(); }
            changing=true;list.setSelectedIndex(requested);changing=false;load();
        }
        catch(RuntimeException exception) {
            changing=true;list.setSelectedIndex(editingIndex);changing=false;
            JOptionPane.showMessageDialog(this,exception.getMessage()+"\nCorrect this ticket type before choosing another.","Check ticket type",JOptionPane.WARNING_MESSAGE);
        }
    }
    private void load() {
        TicketType type=list.getSelectedValue();
        editingIndex=list.getSelectedIndex();
        // Validate this condition before continuing with the operation.
        if(type!=null) {
            name.setText(type.getName());price.setText(type.getPrice().toPlainString());
            early.setSelected(type.hasEarlyBird());hex=type.getColor(); color.setBackground(Color.decode(hex));
        }
    }
    public List<TicketType> getTypes() {
        // Commit the visible form so Save cannot silently ignore the last edit.
        apply();
        List<TicketType> result=new ArrayList<TicketType>();
        // Visit each relevant item using an ordinary loop.
        for(int i=0;i<model.size();i++) { result.add(model.get(i)); }
        return result;
    }
    private void apply() {
        int index=editingIndex;
        // Validate this condition before continuing with the operation.
        if(index<0) { return; }
        TicketType old=model.get(index);
        TicketType updated=new TicketType(old.getCode(),name.getText(),readPrice(),hex,early.isSelected());
        // Visit each relevant item using an ordinary loop.
        for(int i=0;i<model.size();i++) {
            // Validate this condition before continuing with the operation.
            if(i!=index && model.get(i).getName().equalsIgnoreCase(updated.getName())) {
                // Reject invalid input with a message the form can display.
                throw new IllegalArgumentException("Ticket names must be unique.");
            }
        }
        changing=true;model.set(index,updated);changing=false;
    }
    private BigDecimal readPrice() {
        try { return new BigDecimal(price.getText().trim()); }
        catch(NumberFormatException exception) { throw new IllegalArgumentException("Enter a ticket price such as 500.00."); }
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            String command=event.getActionCommand();
            // Validate this condition before continuing with the operation.
            if(event.getSource()==color) {
                Color selected=JColorChooser.showDialog(this,"Ticket color",Color.decode(hex));
                // Validate this condition before continuing with the operation.
                if(selected!=null) { hex=String.format("#%02X%02X%02X",selected.getRed(),selected.getGreen(),selected.getBlue()); color.setBackground(selected); }
            }
            else if("Add".equals(command)) {
                apply();
                // Validate this condition before continuing with the operation.
                if(model.size()>=20) { throw new IllegalArgumentException("Maximum 20 ticket types."); }
                String code="T_"+UUID.randomUUID().toString().replace("-","").substring(0,12);
                int suffix=model.size()+1;
                boolean exists=true;
                while(exists) {
                    exists=false;
                    for(int i=0;i<model.size();i++) { if(model.get(i).getName().equalsIgnoreCase("New type "+suffix)) { exists=true;break; } }
                    if(exists) { suffix++; }
                }
                model.addElement(new TicketType(code,"New type "+suffix,new BigDecimal("500.00"),"#2AA89B",false));
                list.setSelectedIndex(model.size()-1);
            }
            else if("Remove".equals(command)) {
                TicketType type=list.getSelectedValue();
                // Validate this condition before continuing with the operation.
                if(type==null) { return; }
                // Validate this condition before continuing with the operation.
                if(model.size()==1 || assigned.contains(type.getCode())) {
                    // Reject invalid input with a message the form can display.
                    throw new IllegalArgumentException("Keep at least one type. Reassign its sections/seats before removing an assigned type.");
                }
                int index=list.getSelectedIndex();
                changing=true;model.remove(index);list.setSelectedIndex(Math.max(0,index-1));changing=false;load();
            }
            else { apply(); }
        }
        catch(RuntimeException exception) { JOptionPane.showMessageDialog(this,exception.getMessage(),"Ticket types",JOptionPane.WARNING_MESSAGE); }
    }
}
