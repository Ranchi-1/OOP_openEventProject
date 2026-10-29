package com.mycompany.openevent.ui;

// Imports Host so this class can use that type by its short name.
import com.mycompany.openevent.model.Host;
// Imports Customer so this class can use that type by its short name.
import com.mycompany.openevent.model.Customer;
// Imports Session so this class can use that type by its short name.
import com.mycompany.openevent.model.Session;
// Imports Concert so this class can use that type by its short name.
import com.mycompany.openevent.model.Concert;
// Imports SportsMatch so this class can use that type by its short name.
import com.mycompany.openevent.model.SportsMatch;
// Imports MovieScreening so this class can use that type by its short name.
import com.mycompany.openevent.model.MovieScreening;
// Imports Seat so this class can use that type by its short name.
import com.mycompany.openevent.model.Seat;
import com.mycompany.openevent.model.VenuePlan;
import com.mycompany.openevent.model.TicketType;
// Imports VenueLayout so this class can use that type by its short name.
import com.mycompany.openevent.model.VenueLayout;
// Imports Payment so this class can use that type by its short name.
import com.mycompany.openevent.model.Payment;
// Imports CashPayment so this class can use that type by its short name.
import com.mycompany.openevent.model.CashPayment;
// Imports EWalletPayment so this class can use that type by its short name.
import com.mycompany.openevent.model.EWalletPayment;
// Imports CreditCardPayment so this class can use that type by its short name.
import com.mycompany.openevent.model.CreditCardPayment;
// Imports BookingRequest so this class can use that type by its short name.
import com.mycompany.openevent.model.BookingRequest;
// Imports Ticket so this class can use that type by its short name.
import com.mycompany.openevent.model.Ticket;
// Imports Receipt so this class can use that type by its short name.
import com.mycompany.openevent.model.Receipt;
// Imports Event so this class can use that type by its short name.
import com.mycompany.openevent.model.Event;
// Imports BookingController so this class can use that type by its short name.
import com.mycompany.openevent.service.BookingController;
// Imports BookingRepository so this class can use that type by its short name.
import com.mycompany.openevent.service.BookingRepository;
// Imports Database so this class can use that type by its short name.
import com.mycompany.openevent.service.Database;
// Imports SecurityService so this class can use that type by its short name.
import com.mycompany.openevent.service.SecurityService;
// Imports AbstractButton so this class can use that type by its short name.
import javax.swing.AbstractButton;
// Imports BorderFactory so this class can use that type by its short name.
import javax.swing.BorderFactory;
// Imports Box so this class can use that type by its short name.
import javax.swing.Box;
// Imports BoxLayout so this class can use that type by its short name.
import javax.swing.BoxLayout;
// Imports DefaultComboBoxModel so this class can use that type by its short name.
import javax.swing.DefaultComboBoxModel;
// Imports DefaultListModel so this class can use that type by its short name.
import javax.swing.DefaultListModel;
// Imports ImageIcon so this class can use that type by its short name.
import javax.swing.ImageIcon;
// Imports JButton so this class can use that type by its short name.
import javax.swing.JButton;
// Imports JComboBox so this class can use that type by its short name.
import javax.swing.JComboBox;
// Imports JColorChooser so this class can use that type by its short name.
import javax.swing.JColorChooser;
// Imports JComponent so this class can use that type by its short name.
import javax.swing.JComponent;
// Imports JFileChooser so this class can use that type by its short name.
import javax.swing.JFileChooser;
// Imports JFrame so this class can use that type by its short name.
import javax.swing.JFrame;
// Imports JLabel so this class can use that type by its short name.
import javax.swing.JLabel;
// Imports JList so this class can use that type by its short name.
import javax.swing.JList;
// Imports JOptionPane so this class can use that type by its short name.
import javax.swing.JOptionPane;
// Imports JPanel so this class can use that type by its short name.
import javax.swing.JPanel;
// Imports JPasswordField so this class can use that type by its short name.
import javax.swing.JPasswordField;
// Imports JScrollPane so this class can use that type by its short name.
import javax.swing.JScrollPane;
// Imports JSpinner so this class can use that type by its short name.
import javax.swing.JSpinner;
// Imports JTable so this class can use that type by its short name.
import javax.swing.JTable;
// Imports JTextField so this class can use that type by its short name.
import javax.swing.JTextField;
// Imports ListSelectionModel so this class can use that type by its short name.
import javax.swing.ListSelectionModel;
// Imports SwingConstants so this class can use that type by its short name.
import javax.swing.SwingConstants;
// Imports SwingWorker so this class can use that type by its short name.
import javax.swing.SwingWorker;
// Imports WindowConstants so this class can use that type by its short name.
import javax.swing.WindowConstants;
// Imports DefaultTableModel so this class can use that type by its short name.
import javax.swing.table.DefaultTableModel;
// Imports ListSelectionEvent so this class can use that type by its short name.
import javax.swing.event.ListSelectionEvent;
// Imports ListSelectionListener so this class can use that type by its short name.
import javax.swing.event.ListSelectionListener;
// Imports BorderLayout so this class can use that type by its short name.
import java.awt.BorderLayout;
// Imports Color so this class can use that type by its short name.
import java.awt.Color;
// Imports Component so this class can use that type by its short name.
import java.awt.Component;
// Imports Cursor so this class can use that type by its short name.
import java.awt.Cursor;
// Imports Dimension so this class can use that type by its short name.
import java.awt.Dimension;
// Imports Font so this class can use that type by its short name.
import java.awt.Font;
// Imports GridLayout so this class can use that type by its short name.
import java.awt.GridLayout;
// Imports Image so this class can use that type by its short name.
import java.awt.Image;
// Imports Insets so this class can use that type by its short name.
import java.awt.Insets;
// Imports ActionEvent so this class can use that type by its short name.
import java.awt.event.ActionEvent;
// Imports ActionListener so this class can use that type by its short name.
import java.awt.event.ActionListener;
// Imports MouseAdapter so this class can use that type by its short name.
import java.awt.event.MouseAdapter;
// Imports File so this class can use that type by its short name.
import java.io.File;
// Imports IOException so this class can use that type by its short name.
import java.io.IOException;
// Imports BigDecimal so this class can use that type by its short name.
import java.math.BigDecimal;
// Imports Files so this class can use that type by its short name.
import java.nio.file.Files;
// Imports Path so this class can use that type by its short name.
import java.nio.file.Path;
// Imports SQLException so this class can use that type by its short name.
import java.sql.SQLException;
// Imports LocalDate so this class can use that type by its short name.
import java.time.LocalDate;
// Imports LocalDateTime so this class can use that type by its short name.
import java.time.LocalDateTime;
// Imports DateTimeFormatter so this class can use that type by its short name.
import java.time.format.DateTimeFormatter;
// Imports DateTimeParseException so this class can use that type by its short name.
import java.time.format.DateTimeParseException;
// Imports ResolverStyle so this class can use that type by its short name.
import java.time.format.ResolverStyle;
// Imports ArrayList so this class can use that type by its short name.
import java.util.ArrayList;
// Imports HashMap so this class can use that type by its short name.
import java.util.HashMap;
// Imports List so this class can use that type by its short name.
import java.util.List;
// Imports Map so this class can use that type by its short name.
import java.util.Map;
// Imports ExecutionException so this class can use that type by its short name.
import java.util.concurrent.ExecutionException;

/**
 * Coordinates screens using named methods and conventional Swing listeners.
 */
@SuppressWarnings("unchecked")
// Defines a class that inherits the fields and behavior of its parent type.
public class OpenEventUI extends JFrame implements ActionListener {

    // Stores the object that reads and writes database records.
    private final BookingRepository repository = new BookingRepository();
    // Stores the object that coordinates booking requests.
    private final BookingController controller = new BookingController(repository);
    // Stores the object that checks account credentials and access.
    private final SecurityService security = new SecurityService();
    // Stores display date.
    private final DateTimeFormatter displayDate = DateTimeFormatter.ofPattern("dd MMM yyyy · h:mm a");
    // Stores input date.
    private final DateTimeFormatter inputDate = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm").withResolverStyle(ResolverStyle.STRICT);
    // Stores the currently authenticated user; null means nobody is signed in.
    private Session session;
    // Stores current event.
    private Event currentEvent;
    // Stores the selected seat before purchase; selection does not reserve it.
    private Seat currentSeat;
    // Stores current category.
    private String currentCategory;
    // Stores whether a background operation is already running.
    private boolean busy;
    // Remember the visible form so leaving an unsaved event can be confirmed.
    private JPanel currentView;
    // Stores login view.
    private LoginView loginView;
    // Stores discover view.
    private DiscoverView discoverView;
    // Stores event view.
    private EventView eventView;
    // Stores checkout view.
    private CheckoutView checkoutView;
    // Stores tickets view.
    private TicketsView ticketsView;
    // Stores host view.
    private HostView hostView;
    // Stores editor view.
    private EventEditorView editorView;
    // Stores ticket list.
    private JList<Ticket> ticketList;
    // Stores host table.
    private JTable hostTable;
    // Stores host tickets.
    private List<Ticket> hostTickets = new ArrayList<Ticket>();
    // Stores the event being edited, or null when creating one.
    private Event editingEvent;
    // Stores the original venue layout, used to detect destructive changes.
    private VenueLayout savedLayout;
    // Stores whether active/used tickets prevent destructive layout changes.
    private boolean protectedLayout;
    // Stores whether the draft seat arrangement needs to be saved.
    private boolean layoutChanged;
    // The flexible designer lives inside the existing NetBeans form's map container.
    private VenueDesigner venueDesigner;
    // The Host uses a small seat-grid editor instead of the advanced inspector.
    private SimpleGridEditor simpleGridEditor;
    // A blank, direct-manipulation overview is used for new section-based venues.
    private VenueLayoutEditor venueLayoutEditor;
    // Stores draft cell positions and their section categories; missing cells are aisles.
    private final Map<String, String> editorSeats = new HashMap<String, String>();
    // Stores vip color.
    private String vipColor = "#8B5CF6";
    // Stores regular color.
    private String regularColor = "#2AA89B";

    // Constructs a OpenEventUI object and initializes or validates its starting state.
    public OpenEventUI() {
        // Calls this operation to carry out the named step with the supplied arguments.
        initComponents();
        // Calls this operation to carry out the named step with the supplied arguments.
        Theme.polish(navigation);
        // Sets the visible outline or empty padding around this component.
        viewport.setBorder(null);
        // Calls this operation to carry out the named step with the supplied arguments.
        viewport.getVerticalScrollBar().setUnitIncrement(26);
        // Displays this text in the named Swing component.
        navigation.brand.setText("OpenEvent");
        // Loads the named packaged asset from the application classpath.
        java.net.URL brandUrl = getClass().getResource("/assets/Brand mark.png");
        // Continues into this block only when the condition below is true.
        if (brandUrl != null) {
            // Prepares the local original icon value used in the following steps.
            ImageIcon originalIcon = new ImageIcon(brandUrl);
            // Prepares the local scaled icon value used in the following steps.
            Image scaledIcon = originalIcon.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
            // Calls this operation to carry out the named step with the supplied arguments.
            navigation.brand.setIcon(new ImageIcon(scaledIcon));
            // Calls this operation to carry out the named step with the supplied arguments.
            navigation.brand.setIconTextGap(10);
        }
        // Calls this operation to carry out the named step with the supplied arguments.
        // Fit the working desktop so the title bar, footer and taskbar remain reachable.
        java.awt.GraphicsConfiguration display = getGraphicsConfiguration();
        java.awt.Rectangle displayBounds = display.getBounds();
        java.awt.Insets reserved = java.awt.Toolkit.getDefaultToolkit().getScreenInsets(display);
        int availableWidth = displayBounds.width - reserved.left - reserved.right;
        int availableHeight = displayBounds.height - reserved.top - reserved.bottom;
        int minimumWidth = Math.min(1000, availableWidth);
        int minimumHeight = Math.min(700, availableHeight);
        setMinimumSize(new Dimension(minimumWidth, minimumHeight));
        int windowWidth = Math.max(minimumWidth, Math.min(1240, availableWidth - 20));
        int windowHeight = Math.max(minimumHeight, Math.min(810, availableHeight - 20));
        setSize(windowWidth, windowHeight);
        setLocation(displayBounds.x + reserved.left + (availableWidth - windowWidth) / 2,
                displayBounds.y + reserved.top + (availableHeight - windowHeight) / 2);
        // Connects this control to the named event-handler command.
        connectButton(navigation.discover, "navigate");
        // Connects this control to the named event-handler command.
        connectButton(navigation.tickets, "myTickets");
        // Connects this control to the named event-handler command.
        connectButton(navigation.logout, "logout");
        // Calls this operation to carry out the named step with the supplied arguments.
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent event) {
                if (busy) {
                    info("Please wait for the current request to finish before closing.");
                    return;
                }
                if (confirmLeaveEditor()) {
                    dispose();
                }
            }
        });
        showLogin();
    }

    // Assigns a command and registers this window as the button listener.
    private void connectButton(AbstractButton button, String command) {
        // Assigns the command text checked by actionPerformed.
        button.setActionCommand(command);
        // Registers the standard listener that runs when this control is activated.
        button.addActionListener(this);
    }

    // Registers the action to perform when Enter is pressed in this text field.
    private void connectText(JTextField field, String command) {
        // Assigns the command text checked by actionPerformed.
        field.setActionCommand(command);
        // Registers the standard listener that runs when this control is activated.
        field.addActionListener(this);
    }

    // Registers the handler used when a combo-box selection changes.
    private void connectCombo(JComboBox combo, String command) {
        // Assigns the command text checked by actionPerformed.
        combo.setActionCommand(command);
        // Registers the standard listener that runs when this control is activated.
        combo.addActionListener(this);
    }

    @Override
    // Receives button/field events and routes each command to a clearly named handler.
    public void actionPerformed(ActionEvent event) {
        // Ignores repeated requests while an earlier background operation is still running.
        if (busy) {
            // Leaves this method now because there is no further work for this request.
            return;
        }
        // Prepares the local command value used in the following steps.
        String command = event.getActionCommand();
        if (("navigate".equals(command) || "editorBack".equals(command) || "logout".equals(command)) && !confirmLeaveEditor()) {
            return;
        }
        // Continues into this block only when the condition below is true.
        if ("navigate".equals(command)) {
            // Calls this operation to carry out the named step with the supplied arguments.
            discover();
        } // Checks the next possible case when the earlier condition was false.
        else if ("myTickets".equals(command)) {
            // Calls this operation to carry out the named step with the supplied arguments.
            showTickets(null);
        } // Checks the next possible case when the earlier condition was false.
        else if ("logout".equals(command)) {
            // Updates this working value before the next step.
            session = null;
            // Updates this working value before the next step.
            currentEvent = null;
            // Updates this working value before the next step.
            currentSeat = null;
            // Calls this operation to carry out the named step with the supplied arguments.
            showLogin();
        } // Checks the next possible case when the earlier condition was false.
        else if ("login".equals(command)) {
            // Calls this operation to carry out the named step with the supplied arguments.
            signIn();
        } // Checks the next possible case when the earlier condition was false.
        else if ("registerHost".equals(command)) {
            registerAccount(true);
        } else if ("register".equals(command)) {
            // Calls this operation to carry out the named step with the supplied arguments.
            registerAccount(false);
        } // Checks the next possible case when the earlier condition was false.
        else if ("search".equals(command)) {
            // Calls this operation to carry out the named step with the supplied arguments.
            loadEvents();
        } // Checks the next possible case when the earlier condition was false.
        else if (command.startsWith("openEvent:")) {
            // Prepares the local event id value used in the following steps.
            long eventId = Long.parseLong(command.substring("openEvent:".length()));
            // Calls this operation to carry out the named step with the supplied arguments.
            openEvent(eventId);
        } // Checks the next possible case when the earlier condition was false.
        else if ("price".equals(command)) {
            // Calls this operation to carry out the named step with the supplied arguments.
            updatePrice();
        } // Checks the next possible case when the earlier condition was false.
        else if ("checkout".equals(command)) {
            // Updates this working value before the next step.
            currentCategory = (String) eventView.category.getSelectedItem();
            // Calls this operation to carry out the named step with the supplied arguments.
            showCheckout();
        } // Checks the next possible case when the earlier condition was false.
        else if ("backToSeats".equals(command)) {
            // Calls this operation to carry out the named step with the supplied arguments.
            openEvent(currentEvent.getId());
        } // Checks the next possible case when the earlier condition was false.
        else if ("pay".equals(command)) {
            // Calls this operation to carry out the named step with the supplied arguments.
            payForTicket();
        } // Checks the next possible case when the earlier condition was false.
        else if ("saveReceipt".equals(command)) {
            // Calls this operation to carry out the named step with the supplied arguments.
            saveSelectedReceipt();
        } // Checks the next possible case when the earlier condition was false.
        else if ("cancelCustomer".equals(command)) {
            // Calls this operation to carry out the named step with the supplied arguments.
            requestCancellation(ticketList.getSelectedValue());
        } // Checks the next possible case when the earlier condition was false.
        else if ("hostSelect".equals(command)) {
            // Calls this operation to carry out the named step with the supplied arguments.
            loadHostOverview();
        } // Checks the next possible case when the earlier condition was false.
        else if ("hostRefresh".equals(command)) {
            // Calls this operation to carry out the named step with the supplied arguments.
            showHostDashboard(selectedHostEventId());
        } // Checks the next possible case when the earlier condition was false.
        else if ("createEvent".equals(command)) {
            // Calls this operation to carry out the named step with the supplied arguments.
            showEditor(null, null, false);
        } // Checks the next possible case when the earlier condition was false.
        else if ("editEvent".equals(command)) {
            // Calls this operation to carry out the named step with the supplied arguments.
            editSelectedEvent();
        } // Checks the next possible case when the earlier condition was false.
        else if ("checkIn".equals(command)) {
            // Calls this operation to carry out the named step with the supplied arguments.
            checkInTicket();
        } // Checks the next possible case when the earlier condition was false.
        else if ("cancelHost".equals(command)) {
            // Calls this operation to carry out the named step with the supplied arguments.
            cancelHostSelection();
        } // Checks the next possible case when the earlier condition was false.
        else if ("editorBack".equals(command)) {
            // Prepares the local event id value used in the following steps.
            long eventId = 0;
            // Continues into this block only when the condition below is true.
            if (editingEvent != null) {
                // Updates this working value before the next step.
                eventId = editingEvent.getId();
            }
            // Calls this operation to carry out the named step with the supplied arguments.
            showHostDashboard(eventId);
        } // Checks the next possible case when the earlier condition was false.
        else if ("rebuildGrid".equals(command)) {
            // Calls this operation to carry out the named step with the supplied arguments.
            rebuildEditorGrid();
        } // Checks the next possible case when the earlier condition was false.
        else if ("vipColor".equals(command)) {
            // Calls this operation to carry out the named step with the supplied arguments.
            chooseSectionColor(true);
        } // Checks the next possible case when the earlier condition was false.
        else if ("regularColor".equals(command)) {
            // Calls this operation to carry out the named step with the supplied arguments.
            chooseSectionColor(false);
        } // Checks the next possible case when the earlier condition was false.
        else if (command.startsWith("editSeat:")) {
            // Calls this operation to carry out the named step with the supplied arguments.
            changeEditorSeat(command.substring("editSeat:".length()));
        } // Checks the next possible case when the earlier condition was false.
        else if ("saveEvent".equals(command)) {
            // Calls this operation to carry out the named step with the supplied arguments.
            saveEditorEvent();
        }
    }

    // Displays a panel and refreshes navigation for the signed-in role.
    private boolean confirmLeaveEditor() {
        if (editorView == null || currentView != editorView) {
            return true;
        }
        Object[] options = {"Keep editing", "Leave without saving"};
        int choice = JOptionPane.showOptionDialog(this, "Have you saved this event? Unsaved event, venue and ticket-type changes will be lost.",
                "Leave event editor", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        return choice == 1;
    }

    private void screen(JPanel view) {
        currentView = view;
        // Calls this operation to carry out the named step with the supplied arguments.
        getRootPane().setDefaultButton(null);
        // Calls this operation to carry out the named step with the supplied arguments.
        Theme.polish(view);
        // Places the requested content inside the scroll pane.
        viewport.setViewportView(new ResponsiveView(view, 1176));
        // Calls this operation to carry out the named step with the supplied arguments.
        viewport.getVerticalScrollBar().setValue(0);
        // Prepares the local signed in value used in the following steps.
        boolean signedIn = session != null;
        // Shows or hides this component for the current screen state.
        navigation.discover.setVisible(signedIn);
        // Shows or hides this component for the current screen state.
        navigation.logout.setVisible(signedIn);
        // Shows or hides this component for the current screen state.
        navigation.tickets.setVisible(false);
        // Displays this text in the named Swing component.
        navigation.identity.setText("");
        // Displays this text in the named Swing component.
        navigation.discover.setText("Discover");
        // Continues into this block only when the condition below is true.
        if (signedIn) {
            // Prepares the local role value used in the following steps.
            String role = "Customer";
            // Uses the Host workflow and its ownership restrictions.
            if (session.isHost()) {
                // Updates this working value before the next step.
                role = "Host";
                // Displays this text in the named Swing component.
                navigation.discover.setText("Dashboard");
            } // Handles the remaining case after the earlier condition was false.
            else {
                // Shows or hides this component for the current screen state.
                navigation.tickets.setVisible(true);
            }
            // Displays this text in the named Swing component.
            navigation.identity.setText(session.getUser().getName() + " · " + role);
            navigation.identity.setToolTipText(session.getUser().getName() + " · " + role);
        }
        // Asks Swing to recalculate the layout after components change.
        revalidate();
        // Asks Swing to redraw the updated component.
        repaint();
    }

    // Shows an informational dialog to the user.
    private void info(String message) {
        // Calls this operation to carry out the named step with the supplied arguments.
        JOptionPane.showMessageDialog(this, message, "OpenEvent", JOptionPane.INFORMATION_MESSAGE);
    }

    // Shows a useful error message instead of treating a failed operation as successful.
    private void failure(Throwable exception) {
        // Continues into this block only when the condition below is true.
        if (exception instanceof SQLException) {
            // Calls this operation to carry out the named step with the supplied arguments.
            exception.printStackTrace();
            // Calls this operation to carry out the named step with the supplied arguments.
            JOptionPane.showMessageDialog(this,
                    "The database request failed. Check XAMPP MySQL on port 3307 and config.properties.\n"
                    + "A purchase is successful only after it is saved.",
                    "Database unavailable", JOptionPane.ERROR_MESSAGE);
        } // Handles the remaining case after the earlier condition was false.
        else {
            // Prepares the local message value used in the following steps.
            String message = exception.getMessage();
            // Continues into this block only when the condition below is true.
            if (message == null) {
                // Updates this working value before the next step.
                message = "The request could not be completed.";
            }
            // Calls this operation to carry out the named step with the supplied arguments.
            JOptionPane.showMessageDialog(this, message, "Please check", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Runs database work off the drawing thread so the window stays responsive.
     */
    // Defines an abstract parent class; concrete subclasses provide the missing behavior.
    private abstract class ScreenTask extends SwingWorker<Void, Void> {

        // Runs database work in the background; it must not modify Swing controls.
        protected abstract void performTask() throws Exception;

        // Updates the screen after background work completes successfully.
        protected abstract void showResult();

        @Override
        // SwingWorker calls this method on a worker thread, keeping the interface responsive.
        protected Void doInBackground() throws Exception {
            // Calls this operation to carry out the named step with the supplied arguments.
            performTask();
            // Returns this result to the method that called the current operation.
            return null;
        }

        @Override
        // SwingWorker calls this on the Swing thread; get() reports any background error.
        protected void done() {
            // Calls this operation to carry out the named step with the supplied arguments.
            setBusy(false);
            // Attempts the following operation and lets the catch block handle a failure.
            try {
                // Waits for the already-finished worker result and rethrows any background exception.
                get();
                // Calls this operation to carry out the named step with the supplied arguments.
                showResult();
            } // Handles this error without reporting the failed operation as a success.
            catch (ExecutionException exception) {
                // Calls this operation to carry out the named step with the supplied arguments.
                failure(exception.getCause());
            } // Handles this error without reporting the failed operation as a success.
            catch (InterruptedException exception) {
                // Calls this operation to carry out the named step with the supplied arguments.
                Thread.currentThread().interrupt();
                // Calls this operation to carry out the named step with the supplied arguments.
                failure(exception);
            }
        }
    }

    // Starts one background operation and prevents duplicate button requests while it runs.
    private void beginTask(ScreenTask task) {
        // Starts work only when no other database task is running.
        if (!busy) {
            // Calls this operation to carry out the named step with the supplied arguments.
            setBusy(true);
            // Starts SwingWorker on a background thread rather than blocking the drawing thread.
            task.execute();
        }
    }

    // Temporarily blocks navigation and mouse clicks during a database operation.
    private void setBusy(boolean value) {
        // Updates this working value before the next step.
        busy = value;
        // Enables or disables interaction according to the current selection or permissions.
        navigation.discover.setEnabled(!value);
        // Enables or disables interaction according to the current selection or permissions.
        navigation.tickets.setEnabled(!value);
        // Enables or disables interaction according to the current selection or permissions.
        navigation.logout.setEnabled(!value);
        // Continues into this block only when the condition below is true.
        if (value) {
            // Calls this operation to carry out the named step with the supplied arguments.
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            // Prepares the local shield value used in the following steps.
            JPanel shield = new JPanel();
            // Controls whether the component paints its own background.
            shield.setOpaque(false);
            // Calls this operation to carry out the named step with the supplied arguments.
            shield.addMouseListener(new MouseAdapter() {
            });
            // Calls this operation to carry out the named step with the supplied arguments.
            setGlassPane(shield);
            // Shows or hides this component for the current screen state.
            shield.setVisible(true);
        } // Handles the remaining case after the earlier condition was false.
        else {
            // Calls this operation to carry out the named step with the supplied arguments.
            setCursor(Cursor.getDefaultCursor());
            // Shows or hides this component for the current screen state.
            getGlassPane().setVisible(false);
        }
    }

    // Creates the sign-in form and connects its buttons and password field.
    private void showLogin() {
        // Updates this working value before the next step.
        loginView = new LoginView();
        // Calls this operation to carry out the named step with the supplied arguments.
        loginView.emailLabel.setLabelFor(loginView.email);
        loginView.passwordLabel.setLabelFor(loginView.password);
        Theme.fillPhoto(loginView.photoPanel, "concert.jpg", "Between the Islands");
        // Connects this control to the named event-handler command.
        connectButton(loginView.signIn, "login");
        // Connects this control to the named event-handler command.
        connectText(loginView.password, "login");
        // Connects this control to the named event-handler command.
        connectButton(loginView.register, "register");
        connectButton(loginView.registerHost, "registerHost");
        // Calls this operation to carry out the named step with the supplied arguments.
        screen(loginView);
        // Calls this operation to carry out the named step with the supplied arguments.
        getRootPane().setDefaultButton(loginView.signIn);
    }

    // Reads the selected role and credentials, then requests a verified session.
    private void signIn() {
        // Prepares the local email value used in the following steps.
        final String email = loginView.email.getText();
        // Prepares the local password value used in the following steps.
        loginView.hidePassword();
        final char[] password = loginView.password.getPassword();
        if (loginView.email.getText().trim().isEmpty() || password.length == 0) {
            java.util.Arrays.fill(password, '\0');
            info("Enter your email address and password, then choose Customer or Host.");
            loginView.email.requestFocusInWindow();
            return;
        }

        // Prepares the local host value used in the following steps.
        final boolean host = loginView.role.getSelectedIndex() == 1;
        // Creates a background task; its fields hold results until showResult updates the interface.
        beginTask(new ScreenTask() {
            // Stores signed in session.
            private Session signedInSession;

            @Override
            // Runs database work in the background; it must not modify Swing controls.
            protected void performTask() throws Exception {
                // Updates this working value before the next step.
                signedInSession = security.login(email, password, host);
            }

            @Override
            // Updates the screen after background work completes successfully.
            protected void showResult() {
                // Updates this working value before the next step.
                session = signedInSession;
                // Displays this text in the named Swing component.
                loginView.password.setText("");
                // Calls this operation to carry out the named step with the supplied arguments.
                discover();
            }
        });
    }

    // Validates new Customer details and saves a salted password hash.
    private void registerAccount(final boolean host) {
        // Prepares the local name field value used in the following steps.
        JTextField nameField = new JTextField();
        // Prepares the local email field value used in the following steps.
        JTextField emailField = new JTextField();
        // Prepares the local password field value used in the following steps.
        JPasswordField passwordField = new JPasswordField();
        // Prepares the local panel value used in the following steps.
        JPanel panel = new JPanel(new GridLayout(0, 1, 8, 8));
        // Adds this object to the collection or this child component to its parent container.
        panel.add(new JLabel("Your name"));
        // Adds this object to the collection or this child component to its parent container.
        panel.add(nameField);
        // Adds this object to the collection or this child component to its parent container.
        panel.add(new JLabel("Email address"));
        // Adds this object to the collection or this child component to its parent container.
        panel.add(emailField);
        // Adds this object to the collection or this child component to its parent container.
        panel.add(new JLabel("Password (at least 8 characters)"));
        // Adds this object to the collection or this child component to its parent container.
        // Registration uses an independent eye button and begins with masked text.
        JPanel passwordPanel = new JPanel(new BorderLayout(6, 0));
        javax.swing.JToggleButton passwordToggle = new javax.swing.JToggleButton();
        passwordToggle.setPreferredSize(new Dimension(45, 36));
        new PasswordVisibility(passwordField, passwordToggle);
        passwordPanel.add(passwordField, BorderLayout.CENTER);
        passwordPanel.add(passwordToggle, BorderLayout.EAST);
        panel.add(passwordPanel);
        // Prepares the local choice value used in the following steps.
        int choice;
        while (true) {
            String title = "Create Customer account";
            if (host) {
                title = "Create Host account";
            }
            choice = JOptionPane.showConfirmDialog(this, panel, title, JOptionPane.OK_CANCEL_OPTION);
            if (choice != JOptionPane.OK_OPTION) {
                passwordField.setText("");
                return;
            }
            String enteredName = nameField.getText().trim();
            String enteredEmail = emailField.getText().trim();
            char[] enteredPassword = passwordField.getPassword();
            int passwordLength = enteredPassword.length;
            java.util.Arrays.fill(enteredPassword, '\0');
            if (enteredName.length() >= 2 && enteredName.length() <= 100 && enteredEmail.matches("[^\\s@]+@[^\\s@]+\\.[^\\s@]+") && enteredEmail.length() <= 190 && passwordLength >= 8) {
                break;
            }
            info("Enter a name of 2–100 characters, a valid email address, and a password of at least 8 characters.");
        }
        // Continues into this block only when the condition below is true.
        if (choice == JOptionPane.OK_OPTION) {
            // Prepares the local name value used in the following steps.
            final String name = nameField.getText();
            // Prepares the local email value used in the following steps.
            final String email = emailField.getText();
            // Prepares the local password value used in the following steps.
            final char[] password = passwordField.getPassword();
            passwordField.setText("");
            // Creates a background task; its fields hold results until showResult updates the interface.
            beginTask(new ScreenTask() {
                @Override
                // Runs database work in the background; it must not modify Swing controls.
                protected void performTask() throws Exception {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    if (host) {
                        security.registerHost(name, email, password);
                    } else {
                        security.registerCustomer(name, email, password);
                    }
                }

                @Override
                // Updates the screen after background work completes successfully.
                protected void showResult() {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    loginView.email.setText(email);
                    if (host) {
                        loginView.role.setSelectedIndex(1);
                    } else {
                        loginView.role.setSelectedIndex(0);
                    }
                    loginView.password.requestFocusInWindow();
                    info("Account created. Your email is filled in; enter your password to sign in.");
                }
            });
        }
    }

    // Chooses the login, Customer discovery, or Host dashboard screen for this session.
    private void discover() {
        // Shows sign-in because no verified user session exists.
        if (session == null) {
            // Calls this operation to carry out the named step with the supplied arguments.
            showLogin();
        } // Checks the next possible case when the earlier condition was false.
        else if (session.isHost()) {
            // Calls this operation to carry out the named step with the supplied arguments.
            showHostDashboard(0);
        } // Handles the remaining case after the earlier condition was false.
        else {
            // Updates this working value before the next step.
            discoverView = new DiscoverView();
            discoverView.search.setToolTipText("Search event titles. Leave blank to show every upcoming event.");
            // Calls this operation to carry out the named step with the supplied arguments.
            Theme.fillPhoto(discoverView.heroPhoto, "concert.jpg", "Between the Islands");
            // Connects this control to the named event-handler command.
            connectButton(discoverView.searchButton, "search");
            // Connects this control to the named event-handler command.
            connectText(discoverView.search, "search");
            // Calls this operation to carry out the named step with the supplied arguments.
            screen(discoverView);
            // Calls this operation to carry out the named step with the supplied arguments.
            getRootPane().setDefaultButton(discoverView.searchButton);
            // Calls this operation to carry out the named step with the supplied arguments.
            loadEvents();
        }
    }

    // Fetches the title search results without blocking the Swing thread.
    private void loadEvents() {
        // Prepares the local search value used in the following steps.
        final String search = discoverView.search.getText().trim();
        // Creates a background task; its fields hold results until showResult updates the interface.
        beginTask(new ScreenTask() {
            // Stores events.
            private List<Event> events;

            @Override
            // Runs database work in the background; it must not modify Swing controls.
            protected void performTask() throws Exception {
                // Updates this working value before the next step.
                events = repository.events(session, search);
            }

            @Override
            // Updates the screen after background work completes successfully.
            protected void showResult() {
                // Calls this operation to carry out the named step with the supplied arguments.
                displayEvents(events);
            }
        });
    }

    // Builds visible event cards from the search results using a normal loop.
    private void displayEvents(List<Event> events) {
        // Displays this text in the named Swing component.
        String eventWord = "events";
        if (events.size() == 1) {
            eventWord = "event";
        }
        discoverView.count.setText(events.size() + " upcoming " + eventWord + " · Choose an event to view its seats and prices.");
        // Prepares the local cards value used in the following steps.
        EventCards cards = new EventCards();
        // Sets this component color; the gradient start/end colors form the purple theme.
        cards.setBackground(Theme.BG);
        // Sets the visible outline or empty padding around this component.
        cards.setBorder(BorderFactory.createEmptyBorder(0, 0, 6, 0));
        // Continues into this block only when the condition below is true.
        if (events.isEmpty()) {
            // Adds this object to the collection or this child component to its parent container.
            cards.add(Theme.label("No events found. Try another title.", 17, false, Theme.MUTED));
        }
        // Visits each object in the collection using an ordinary enhanced for loop.
        for (Event event : events) {
            // Adds this object to the collection or this child component to its parent container.
            cards.add(createEventCard(event));
        }
        // Prepares the local rows value used in the following steps.
        int rows = Math.max(1, (events.size() + 2) / 3);
        // Specifies the component size requested from its layout or scroll container.
        cards.setPreferredSize(new Dimension(300, rows * 290));
        // Places the requested content inside the scroll pane.
        discoverView.eventsScroll.setViewportView(cards);
    }

    // Creates the image, labels and open-event button for one event.
    private JPanel createEventCard(Event event) {
        // Prepares the local card value used in the following steps.
        JPanel card = new JPanel(new BorderLayout());
        // Sets this component color; the gradient start/end colors form the purple theme.
        card.setBackground(Color.WHITE);
        // Sets the visible outline or empty padding around this component.
        card.setBorder(BorderFactory.createLineBorder(Theme.LINE));
        // Prepares the local photo value used in the following steps.
        JPanel photo = Theme.photo(event.getImage(), event.getTitle());
        // Specifies the component size requested from its layout or scroll container.
        photo.setPreferredSize(new Dimension(340, 125));
        // Adds this object to the collection or this child component to its parent container.
        card.add(photo, BorderLayout.NORTH);
        // Prepares the local body value used in the following steps.
        JPanel body = new JPanel();
        // Sets this component color; the gradient start/end colors form the purple theme.
        body.setBackground(Color.WHITE);
        // Chooses how child components are arranged inside this container.
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
        // Sets the visible outline or empty padding around this component.
        body.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 16));
        // Prepares the local day value used in the following steps.
        String day = event.getStartsAt().format(DateTimeFormatter.ofPattern("dd MMM · EEE"));
        // Adds this object to the collection or this child component to its parent container.
        body.add(Theme.label(event.eventType() + " / " + day.toUpperCase(), 11, true, Theme.PURPLE));
        // Adds this object to the collection or this child component to its parent container.
        body.add(Box.createVerticalStrut(9));
        // Adds this object to the collection or this child component to its parent container.
        body.add(Theme.label(event.getTitle(), 19, true, Theme.INK));
        // Adds this object to the collection or this child component to its parent container.
        body.add(Box.createVerticalStrut(8));
        // Adds this object to the collection or this child component to its parent container.
        body.add(Theme.label(event.getVenue(), 12, false, Theme.MUTED));
        // Adds this object to the collection or this child component to its parent container.
        body.add(Box.createVerticalStrut(14));
        // Prepares the local open button value used in the following steps.
        JButton openButton = Theme.button("View seats & ticket prices  →");
        // Calls this operation to carry out the named step with the supplied arguments.
        openButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        // Connects this control to the named event-handler command.
        connectButton(openButton, "openEvent:" + event.getId());
        // Adds this object to the collection or this child component to its parent container.
        body.add(openButton);
        // Adds this object to the collection or this child component to its parent container.
        card.add(body, BorderLayout.CENTER);
        // Returns this result to the method that called the current operation.
        return card;
    }

    // Loads the selected event and its saved venue layout.
    private void openEvent(final long eventId) {
        // Creates a background task; its fields hold results until showResult updates the interface.
        beginTask(new ScreenTask() {
            // Stores event.
            private Event event;
            // Stores layout.
            private VenueLayout layout;

            @Override
            // Runs database work in the background; it must not modify Swing controls.
            protected void performTask() throws Exception {
                // Updates this working value before the next step.
                event = repository.event(eventId);
                // Updates this working value before the next step.
                layout = repository.layout(eventId);
            }

            @Override
            // Updates the screen after background work completes successfully.
            protected void showResult() {
                // Calls this operation to carry out the named step with the supplied arguments.
                displayEvent(event, layout);
            }
        });
    }

    // Displays the published seat map and connects seat-selection controls.
    private void displayEvent(Event event, VenueLayout layout) {
        // Updates this working value before the next step.
        currentEvent = event;
        // Updates this working value before the next step.
        currentSeat = null;
        // Updates this working value before the next step.
        eventView = new EventView();
        // Displays this text in the named Swing component.
        eventView.eventName.setText(event.getTitle());
        // Displays this text in the named Swing component.
        eventView.eventMeta.setText(event.getStartsAt().format(displayDate) + " / " + event.getVenue());
        // Displays this text in the named Swing component.
        eventView.description.setText("<html>" + Theme.html(event.getDescription()) + "</html>");
        // Enables or disables interaction according to the current selection or permissions.
        eventView.checkout.setEnabled(false);
        // Chooses how child components are arranged inside this container.
        eventView.mapPanel.setLayout(new BorderLayout());
        // Prepares the local grid value used in the following steps.
        SeatGrid.SeatSelectionListener selection = new SeatGrid.SeatSelectionListener() {
            @Override
            public void seatSelected(Seat seat) {
                chooseSeat(seat);
            }
        };
        if (layout.isFlexible()) {
            eventView.subtitle.setText("Choose a section, then an available seat. Your booking is saved after checkout.");
            eventView.mapPanel.add(new VenueBrowser(layout, selection), BorderLayout.CENTER);
            eventView.legend.setText("Section colors show ticket types · Gray ×: sold · Gaps: aisles / blocked · Click a section to view seats");
        } else {
            eventView.mapPanel.add(new SeatGrid(layout, selection), BorderLayout.CENTER);
            eventView.legend.setText("Colors show ticket types · Gray ×: sold · Gaps: aisles · Select a seat to see its offer");
        }
        connectCombo(eventView.category, "price");
        // Connects this control to the named event-handler command.
        connectButton(eventView.back, "navigate");
        // Connects this control to the named event-handler command.
        connectButton(eventView.checkout, "checkout");
        // Calls this operation to carry out the named step with the supplied arguments.
        screen(eventView);
    }

    // Remembers one selected seat and lists the pricing categories allowed for it.
    private void chooseSeat(Seat seat) {
        if (seat == null) {
            currentSeat = null;
            currentCategory = null;
            eventView.selectedSeat.setText("Select a section to begin.");
            eventView.category.setModel(new DefaultComboBoxModel<String>());
            eventView.category.setEnabled(false);
            eventView.checkout.setEnabled(false);
            eventView.price.setText("Choose a seat");
            return;
        }
        eventView.category.setEnabled(true);

        // Updates this working value before the next step.
        currentSeat = seat;
        // Displays this text in the named Swing component.
        eventView.selectedSeat.setText("<html><b>Seat " + Theme.html(seat.getLabel()) + "</b><br>" + Theme.html(DisplayText.category(seat.getCategory())) + "</html>");
        eventView.selectedSeat.setToolTipText(seat.getLabel() + " · " + seat.getCategory());
        // Prepares the local categories value used in the following steps.
        DefaultComboBoxModel<String> categories = new DefaultComboBoxModel<String>();
        // Adds this object to the list/combo model in display order.
        categories.addElement(seat.getCategory());
        // Continues into this block only when the condition below is true.
        if (seat.allowsEarlyBird() && LocalDateTime.now().isBefore(currentEvent.getEarlyBirdUntil())) {
            // Adds this object to the list/combo model in display order.
            if (seat.getTicketType() != null) {
                categories.addElement(seat.getCategory() + " / Early Bird");
            } else {
                categories.addElement("EARLY_BIRD");
            }
        }
        // Supplies the list, combo-box or table data displayed by this control.
        eventView.category.setModel(categories);
        // Enables or disables interaction according to the current selection or permissions.
        eventView.checkout.setEnabled(true);
        // Calls this operation to carry out the named step with the supplied arguments.
        updatePrice();
    }

    // Recalculates the displayed price for the selected seat and category.
    private void updatePrice() {
        // Recalculates pricing only after the user has selected a seat.
        if (currentSeat != null) {
            // Attempts the following operation and lets the catch block handle a failure.
            try {
                // Prepares the local category value used in the following steps.
                String category = (String) eventView.category.getSelectedItem();
                // Prepares the local price value used in the following steps.
                BigDecimal price = currentEvent.calculatePrice(currentSeat, category);
                // Displays this text in the named Swing component.
                eventView.price.setText(Theme.money(price));
            } // Handles this error without reporting the failed operation as a success.
            catch (RuntimeException exception) {
                // Calls this operation to carry out the named step with the supplied arguments.
                failure(exception);
            }
        }
    }

    // Displays the selected attendee, seat, category and simulated total.
    private void showCheckout() {
        // Stops checkout when no available seat has been selected.
        if (currentSeat == null) {
            // Leaves this method now because there is no further work for this request.
            return;
        }
        // Updates this working value before the next step.
        checkoutView = new CheckoutView();
        // Displays this text in the named Swing component.
        checkoutView.attendee.setText("Attendee: " + session.getUser().getName() + " · " + session.getUser().getEmail());
        // Displays this text in the named Swing component.
        checkoutView.summary.setText("<html><b>" + Theme.html(currentEvent.getTitle()) + "</b><br>"
                + currentEvent.getStartsAt().format(displayDate) + "<br>Seat " + currentSeat.getLabel()
                + " · " + Theme.html(DisplayText.category(currentCategory)) + "<br>One ticket / one seat</html>");
        // Displays this text in the named Swing component.
        checkoutView.total.setText(Theme.money(currentEvent.calculatePrice(currentSeat, currentCategory)));
        // Connects this control to the named event-handler command.
        connectButton(checkoutView.back, "backToSeats");
        // Connects this control to the named event-handler command.
        connectButton(checkoutView.pay, "pay");
        // Calls this operation to carry out the named step with the supplied arguments.
        screen(checkoutView);
    }

    // Creates the chosen Payment subclass and requests one saved purchase.
    private void payForTicket() {
        // Prepares the local payment value used in the following steps.
        Payment payment;
        // Prepares the local method value used in the following steps.
        int method = checkoutView.method.getSelectedIndex();
        // Continues into this block only when the condition below is true.
        if (method == 1) {
            // Updates this working value before the next step.
            payment = new CreditCardPayment();
        } // Checks the next possible case when the earlier condition was false.
        else if (method == 2) {
            // Updates this working value before the next step.
            payment = new CashPayment();
        } // Handles the remaining case after the earlier condition was false.
        else {
            // Updates this working value before the next step.
            payment = new EWalletPayment();
        }
        // Prepares the local simulate success value used in the following steps.
        boolean simulateSuccess = checkoutView.outcome.getSelectedIndex() == 0;
        // Prepares the local request value used in the following steps.
        final BookingRequest request = new BookingRequest(currentEvent.getId(), currentSeat.getId(), currentCategory, payment, simulateSuccess);
        // Creates a background task; its fields hold results until showResult updates the interface.
        beginTask(new ScreenTask() {
            // Stores saved ticket.
            private Ticket savedTicket;

            @Override
            // Runs database work in the background; it must not modify Swing controls.
            protected void performTask() throws Exception {
                // Updates this working value before the next step.
                savedTicket = controller.purchase(session, request);
            }

            @Override
            // Updates the screen after background work completes successfully.
            protected void showResult() {
                // Updates this working value before the next step.
                currentSeat = null;
                // Calls this operation to carry out the named step with the supplied arguments.
                showTickets(savedTicket.getCode());
            }
        });
    }

    // Loads the Customer ticket history, optionally focusing a recently changed ticket.
    private void showTickets(final String focusCode) {
        // Stops this Customer-only screen when nobody is signed in or the user is a Host.
        if (session == null || session.isHost()) {
            // Leaves this method now because there is no further work for this request.
            return;
        }
        // Creates a background task; its fields hold results until showResult updates the interface.
        beginTask(new ScreenTask() {
            // Stores tickets.
            private List<Ticket> tickets;

            @Override
            // Runs database work in the background; it must not modify Swing controls.
            protected void performTask() throws Exception {
                // Updates this working value before the next step.
                tickets = repository.tickets(session, 0);
            }

            @Override
            // Updates the screen after background work completes successfully.
            protected void showResult() {
                // Calls this operation to carry out the named step with the supplied arguments.
                displayTickets(tickets, focusCode);
            }
        });
    }

    // Adds saved tickets to the list and connects ticket actions.
    private void displayTickets(List<Ticket> tickets, String focusCode) {
        // Updates this working value before the next step.
        ticketsView = new TicketsView();
        // Prepares the local model value used in the following steps.
        DefaultListModel<Ticket> model = new DefaultListModel<Ticket>();
        // Visits each object in the collection using an ordinary enhanced for loop.
        for (Ticket ticket : tickets) {
            // Adds this object to the list/combo model in display order.
            model.addElement(ticket);
        }
        // Updates this working value before the next step.
        ticketList = new JList<Ticket>(model);
        // Lists use the same friendly states as the detailed ticket panel.
        ticketList.setCellRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean selected, boolean focused) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, selected, focused);
                if (value instanceof Ticket) {
                    Ticket ticket = (Ticket) value;
                    String summary = ticket.getCode() + " · " + ticket.getEventTitle() + " · " + ticket.getSeatLabel() + " · " + DisplayText.ticketStatus(ticket.getStatus());
                    label.setText(summary);
                    label.setToolTipText(summary);
                }
                return label;
            }
        });
        // Sets the font family, style and point size used to draw this component.
        ticketList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        // Calls this operation to carry out the named step with the supplied arguments.
        ticketList.setFixedCellHeight(40);
        // Calls this operation to carry out the named step with the supplied arguments.
        ticketList.setSelectionBackground(new Color(236, 229, 253));
        // Calls this operation to carry out the named step with the supplied arguments.
        ticketList.setSelectionForeground(Theme.PURPLE);
        // Calls this operation to carry out the named step with the supplied arguments.
        ticketList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Registers the listener that refreshes details after the ticket selection changes.
        ticketList.addListSelectionListener(new ListSelectionListener() {
            @Override
            // Performs the value changed operation; exceptions are passed to the caller when needed.
            public void valueChanged(ListSelectionEvent event) {
                // Continues into this block only when the condition below is true.
                if (!event.getValueIsAdjusting()) {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    showSelectedTicket();
                }
            }
        });
        // Places the requested content inside the scroll pane.
        ticketsView.ticketScroll.setViewportView(ticketList);
        // Connects this control to the named event-handler command.
        connectButton(ticketsView.refresh, "myTickets");
        // Connects this control to the named event-handler command.
        connectButton(ticketsView.cancel, "cancelCustomer");
        // Connects this control to the named event-handler command.
        connectButton(ticketsView.export, "saveReceipt");
        // Calls this operation to carry out the named step with the supplied arguments.
        screen(ticketsView);
        // Continues into this block only when the condition below is true.
        if (!tickets.isEmpty()) {
            // Prepares the local selected index value used in the following steps.
            int selectedIndex = 0;
            // Repeats this block with an index so each relevant position or parameter is processed.
            for (int index = 0; index < tickets.size(); index++) {
                // Continues into this block only when the condition below is true.
                if (tickets.get(index).getCode().equals(focusCode)) {
                    // Updates this working value before the next step.
                    selectedIndex = index;
                    // Stops the loop because the requested match has already been found.
                    break;
                }
            }
            // Calls this operation to carry out the named step with the supplied arguments.
            ticketList.setSelectedIndex(selectedIndex);
        }
        // Calls this operation to carry out the named step with the supplied arguments.
        showSelectedTicket();
        // Continues into this block only when the condition below is true.

    }

    // Shows the selected ticket and enables refund only when it can be requested.
    private void updateTicketBanner(Ticket ticket) {
        if ("CANCELLED".equals(ticket.getStatus())) {
            ticketsView.bannerText.setText("REFUND SAVED · This ticket is cancelled. The simulated refund is recorded.");
        } else if ("USED".equals(ticket.getStatus())) {
            ticketsView.bannerText.setText("CHECKED IN · This ticket has already been used for entry.");
        } else {
            ticketsView.bannerText.setText("TICKET SAVED · Keep this ticket code for entry.");
        }
    }

    private void showSelectedTicket() {
        // Prepares the local ticket value used in the following steps.
        Ticket ticket = ticketList.getSelectedValue();
        // Prepares the local can cancel value used in the following steps.
        boolean canCancel = false;
        // Continues into this block only when the condition below is true.
        if (ticket != null && "VALID".equals(ticket.getStatus()) && LocalDateTime.now().isBefore(ticket.getStartsAt())) {
            // Updates this working value before the next step.
            canCancel = true;
        }
        // Enables or disables interaction according to the current selection or permissions.
        ticketsView.cancel.setEnabled(canCancel);
        // Enables or disables interaction according to the current selection or permissions.
        ticketsView.export.setEnabled(ticket != null);
        // Stops or shows the empty state when no ticket is selected.
        if (ticket == null) {
            // Displays this text in the named Swing component.
            ticketsView.ticketTitle.setText("No tickets yet");
            // Displays this text in the named Swing component.
            ticketsView.ticketMeta.setText("Book an event to see your ticket here.");
            ticketsView.ticketCode.setText("No ticket selected");
            ticketsView.ticketState.setText("");
            ticketsView.receiptDetails.setText("");
            ticketsView.bannerText.setText("Your saved tickets will appear here after a successful booking.");
            // Leaves this method now because there is no further work for this request.
            return;
        }
        // Displays this text in the named Swing component.
        updateTicketBanner(ticket);
        ticketsView.ticketTitle.setText(ticket.getEventTitle());
        ticketsView.ticketTitle.setToolTipText(ticket.getEventTitle());
        // Displays this text in the named Swing component.
        ticketsView.ticketMeta.setText("<html>" + ticket.getStartsAt().format(displayDate) + "<br>"
                + Theme.html(ticket.getVenue()) + "<br>Seat " + ticket.getSeatLabel() + " · "
                + Theme.html(DisplayText.category(ticket.getCategory())) + " · " + Theme.html(ticket.getCustomerName()) + "</html>");
        // Displays this text in the named Swing component.
        ticketsView.ticketCode.setText(ticket.getCode());
        // Displays this text in the named Swing component.
        ticketsView.ticketState.setText("Ticket: " + DisplayText.ticketStatus(ticket.getStatus()) + " · " + DisplayText.paymentStatus(ticket.getPaymentStatus()));
        // Displays this text in the named Swing component.
        ticketsView.receiptDetails.setText("<html><b>" + Theme.money(ticket.getAmount()) + "</b> · "
                + DisplayText.method(ticket.getMethod()) + "<br>" + ticket.getReceiptNumber() + "<br>"
                + ticket.getReference() + "<br>No real money collected.</html>");
    }

    // Asks for confirmation before requesting an eligible simulated refund.
    private void requestCancellation(final Ticket ticket) {
        // Stops or shows the empty state when no ticket is selected.
        if (ticket == null) {
            // Leaves this method now because there is no further work for this request.
            return;
        }
        // Prepares the local choice value used in the following steps.
        int choice = JOptionPane.showConfirmDialog(this, "Cancel " + ticket.getCode()
                + " and simulate a full refund?", "Cancel ticket", JOptionPane.YES_NO_OPTION);
        // Continues into this block only when the condition below is true.
        if (choice == JOptionPane.YES_OPTION) {
            // Creates a background task; its fields hold results until showResult updates the interface.
            beginTask(new ScreenTask() {
                @Override
                // Runs database work in the background; it must not modify Swing controls.
                protected void performTask() throws Exception {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    controller.cancel(session, ticket.getId());
                }

                @Override
                // Updates the screen after background work completes successfully.
                protected void showResult() {
                    // Uses the Host workflow and its ownership restrictions.
                    if (session.isHost()) {
                        // Calls this operation to carry out the named step with the supplied arguments.
                        showHostDashboard(ticket.getEventId());
                    } // Handles the remaining case after the earlier condition was false.
                    else {
                        // Calls this operation to carry out the named step with the supplied arguments.
                        showTickets(ticket.getCode());
                    }
                }
            });
        }
    }

    // Exports a saved ticket receipt after the user chooses a destination.
    private void saveSelectedReceipt() {
        // Prepares the local ticket value used in the following steps.
        Ticket ticket = ticketList.getSelectedValue();
        // Stops or shows the empty state when no ticket is selected.
        if (ticket == null) {
            // Leaves this method now because there is no further work for this request.
            return;
        }
        // Prepares the local chooser value used in the following steps.
        JFileChooser chooser = new JFileChooser();
        // Calls this operation to carry out the named step with the supplied arguments.
        chooser.setSelectedFile(new File(ticket.getReceiptNumber() + ".txt"));
        // Continues into this block only when the condition below is true.
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            // Prepares the local file value used in the following steps.
            Path file = chooser.getSelectedFile().toPath();
            // Continues into this block only when the condition below is true.
            if (Files.exists(file)) {
                // Prepares the local choice value used in the following steps.
                int choice = JOptionPane.showConfirmDialog(this, "Replace this receipt file?", "Save receipt", JOptionPane.YES_NO_OPTION);
                // Continues into this block only when the condition below is true.
                if (choice != JOptionPane.YES_OPTION) {
                    // Leaves this method now because there is no further work for this request.
                    return;
                }
            }
            // Attempts the following operation and lets the catch block handle a failure.
            try {
                // Prepares the local receipt value used in the following steps.
                Receipt receipt = new Receipt(ticket);
                // Calls this operation to carry out the named step with the supplied arguments.
                Files.writeString(file, receipt.asText());
                // Calls this operation to carry out the named step with the supplied arguments.
                info("Receipt saved.");
            } // Handles this error without reporting the failed operation as a success.
            catch (IOException exception) {
                // Calls this operation to carry out the named step with the supplied arguments.
                failure(exception);
            }
        }
    }

    // Returns the selected event ID, or zero when there is no event.
    private long selectedHostEventId() {
        // Prepares the local selected value used in the following steps.
        Event selected = (Event) hostView.eventSelector.getSelectedItem();
        // Continues into this block only when the condition below is true.
        if (selected == null) {
            // Returns this result to the method that called the current operation.
            return 0;
        }
        // Returns this result to the method that called the current operation.
        return selected.getId();
    }

    // Loads the current Host events and selects the requested event.
    private void showHostDashboard(final long selectedEventId) {
        // Creates a background task; its fields hold results until showResult updates the interface.
        beginTask(new ScreenTask() {
            // Stores events.
            private List<Event> events;

            @Override
            // Runs database work in the background; it must not modify Swing controls.
            protected void performTask() throws Exception {
                // Updates this working value before the next step.
                events = repository.events(session, "");
            }

            @Override
            // Updates the screen after background work completes successfully.
            protected void showResult() {
                // Calls this operation to carry out the named step with the supplied arguments.
                displayHostDashboard(events, selectedEventId);
            }
        });
    }

    // Creates Host controls and fills the event selector before attaching its listener.
    private void displayHostDashboard(List<Event> events, long selectedEventId) {
        // Updates this working value before the next step.
        hostView = new HostView();
        // Prepares the local model value used in the following steps.
        DefaultComboBoxModel<Event> model = new DefaultComboBoxModel<Event>();
        // Visits each object in the collection using an ordinary enhanced for loop.
        for (Event event : events) {
            // Adds this object to the list/combo model in display order.
            model.addElement(event);
        }
        // Supplies the list, combo-box or table data displayed by this control.
        hostView.eventSelector.setModel(model);
        // Visits each object in the collection using an ordinary enhanced for loop.
        for (Event event : events) {
            // Continues into this block only when the condition below is true.
            if (event.getId() == selectedEventId) {
                // Calls this operation to carry out the named step with the supplied arguments.
                hostView.eventSelector.setSelectedItem(event);
                // Stops the loop because the requested match has already been found.
                break;
            }
        }
        // Updates this working value before the next step.
        hostTable = new JTable();
        hostTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    updateHostRefundButton();
                }
            }
        });
        // Calls this operation to carry out the named step with the supplied arguments.
        hostTable.setRowHeight(32);
        // Sets the font family, style and point size used to draw this component.
        hostTable.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        // Calls this operation to carry out the named step with the supplied arguments.
        hostTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Calls this operation to carry out the named step with the supplied arguments.
        hostTable.getTableHeader().setReorderingAllowed(false);
        // Places the requested content inside the scroll pane.
        hostView.tableScroll.setViewportView(hostTable);
        // Connects this control to the named event-handler command.
        connectCombo(hostView.eventSelector, "hostSelect");
        // Connects this control to the named event-handler command.
        connectButton(hostView.refresh, "hostRefresh");
        // Connects this control to the named event-handler command.
        connectButton(hostView.create, "createEvent");
        // Connects this control to the named event-handler command.
        connectButton(hostView.edit, "editEvent");
        // Connects this control to the named event-handler command.
        connectButton(hostView.checkIn, "checkIn");
        // Connects this control to the named event-handler command.
        connectText(hostView.ticketCode, "checkIn");
        // Connects this control to the named event-handler command.
        connectButton(hostView.cancel, "cancelHost");
        // Calls this operation to carry out the named step with the supplied arguments.
        screen(hostView);
        // Calls this operation to carry out the named step with the supplied arguments.
        loadHostOverview();
    }

    // Loads the selected event tickets and venue for manual monitoring.
    private void loadHostOverview() {
        // Prepares the local event value used in the following steps.
        final Event event = (Event) hostView.eventSelector.getSelectedItem();
        // Prepares the local has event value used in the following steps.
        boolean hasEvent = event != null;
        // Enables or disables interaction according to the current selection or permissions.
        hostView.edit.setEnabled(hasEvent);
        // Enables or disables interaction according to the current selection or permissions.
        hostView.checkIn.setEnabled(hasEvent);
        // Enables or disables interaction according to the current selection or permissions.
        hostView.cancel.setEnabled(hasEvent);
        // Continues into this block only when the condition below is true.
        if (!hasEvent) {
            // Displays this text in the named Swing component.
            hostView.eventTitle.setText("Create your first event.");
            // Leaves this method now because there is no further work for this request.
            return;
        }
        // Creates a background task; its fields hold results until showResult updates the interface.
        beginTask(new ScreenTask() {
            // Stores tickets.
            private List<Ticket> tickets;
            // Stores layout.
            private VenueLayout layout;

            @Override
            // Runs database work in the background; it must not modify Swing controls.
            protected void performTask() throws Exception {
                // Updates this working value before the next step.
                tickets = repository.tickets(session, event.getId());
                // Updates this working value before the next step.
                layout = repository.layout(event.getId());
            }

            @Override
            // Updates the screen after background work completes successfully.
            protected void showResult() {
                // Calls this operation to carry out the named step with the supplied arguments.
                displayHostOverview(event, tickets, layout);
            }
        });
    }

    // Uses loops to calculate saved ticket counts and simulated net totals.
    private void displayHostOverview(Event event, List<Ticket> tickets, VenueLayout layout) {
        // Updates this working value before the next step.
        hostTickets = tickets;
        // Prepares the local active count value used in the following steps.
        int activeCount = 0;
        // Prepares the local used count value used in the following steps.
        int usedCount = 0;
        // Prepares the local total value used in the following steps.
        BigDecimal total = BigDecimal.ZERO;
        // Visits each object in the collection using an ordinary enhanced for loop.
        for (Ticket ticket : tickets) {
            // Counts seats still occupied by VALID or USED tickets.
            if (!"CANCELLED".equals(ticket.getStatus())) {
                // Updates the running count for this loop or summary.
                activeCount++;
            }
            // Counts tickets already used for entry.
            if ("USED".equals(ticket.getStatus())) {
                // Updates the running count for this loop or summary.
                usedCount++;
            }
            // Adds only successful, non-refunded demo payments to net sales.
            if ("SIMULATED_SUCCESS".equals(ticket.getPaymentStatus())) {
                // Adds this object to the collection or this child component to its parent container.
                total = total.add(ticket.getAmount());
            }
        }
        // Prepares the local title value used in the following steps.
        String title = event.getTitle();
        // Marks this Host-only event as a draft until it is published.
        if (!event.isPublished()) {
            // Updates this working value before the next step.
            title = title + " · DRAFT";
        }
        // Displays this text in the named Swing component.
        hostView.eventTitle.setText(title);
        // Displays this text in the named Swing component.
        hostView.eventMeta.setText(event.getStartsAt().format(displayDate) + " / " + event.getVenue());
        // Displays this text in the named Swing component.
        hostView.sales.setText(Theme.money(total));
        // Displays this text in the named Swing component.
        hostView.tickets.setText(activeCount + " / " + layout.getSeats().size());
        // Displays this text in the named Swing component.
        hostView.checkins.setText(Integer.toString(usedCount));
        // Prepares the local model value used in the following steps.
        DefaultTableModel model = new DefaultTableModel(
                new String[]{"Ticket code", "Guest", "Seat", "Category", "Ticket status", "Payment"}, 0) {
            @Override
            // Performs the is cell editable operation; exceptions are passed to the caller when needed.
            public boolean isCellEditable(int row, int column) {
                // Returns this result to the method that called the current operation.
                return false;
            }
        };
        // Visits each object in the collection using an ordinary enhanced for loop.
        for (Ticket ticket : tickets) {
            // Adds one saved ticket as a row in the read-only monitoring table.
            model.addRow(new Object[]{ticket.getCode(), ticket.getCustomerName(), ticket.getSeatLabel(),
                // Calls this operation to carry out the named step with the supplied arguments.
                DisplayText.category(ticket.getCategory()), DisplayText.ticketStatus(ticket.getStatus()), DisplayText.paymentStatus(ticket.getPaymentStatus())});
        }
        // Supplies the list, combo-box or table data displayed by this control.
        hostTable.setModel(model);
        updateHostRefundButton();
    }

    // Requests one-time validation of the entered ticket code for the selected event.
    private void checkInTicket() {
        // Prepares the local event value used in the following steps.
        final Event event = (Event) hostView.eventSelector.getSelectedItem();
        // Prepares the local code value used in the following steps.
        final String code = hostView.ticketCode.getText();
        // Continues into this block only when the condition below is true.
        if (event != null) {
            // Creates a background task; its fields hold results until showResult updates the interface.
            beginTask(new ScreenTask() {
                // Stores guest name.
                private String guestName;

                @Override
                // Runs database work in the background; it must not modify Swing controls.
                protected void performTask() throws Exception {
                    // Updates this working value before the next step.
                    guestName = controller.checkIn(session, event.getId(), code);
                }

                @Override
                // Updates the screen after background work completes successfully.
                protected void showResult() {
                    // Calls this operation to carry out the named step with the supplied arguments.
                    info("Welcome, " + guestName + ". Check-in saved. This ticket cannot be used for entry again.");
                    // Calls this operation to carry out the named step with the supplied arguments.
                    showHostDashboard(event.getId());
                }
            });
        }
    }

    // Finds the selected table ticket and passes it to the common refund handler.
    private void updateHostRefundButton() {
        boolean allowed = false;
        if (hostView != null && hostTable != null) {
            int row = hostTable.getSelectedRow();
            if (row >= 0) {
                int index = hostTable.convertRowIndexToModel(row);
                if (index >= 0 && index < hostTickets.size()) {
                    Ticket ticket = hostTickets.get(index);
                    allowed = "VALID".equals(ticket.getStatus()) && LocalDateTime.now().isBefore(ticket.getStartsAt());
                }
            }
            hostView.cancel.setEnabled(allowed);
            hostView.cancel.setToolTipText("Select an unused ticket before its event starts to request a simulated refund.");
        }
    }

    private void cancelHostSelection() {
        // Prepares the local row value used in the following steps.
        int row = hostTable.getSelectedRow();
        // Continues into this block only when the condition below is true.
        if (row < 0) {
            // Calls this operation to carry out the named step with the supplied arguments.
            info("Select a ticket in the table first.");
        } // Handles the remaining case after the earlier condition was false.
        else {
            // Prepares the local model row value used in the following steps.
            int modelRow = hostTable.convertRowIndexToModel(row);
            // Calls this operation to carry out the named step with the supplied arguments.
            requestCancellation(hostTickets.get(modelRow));
        }
    }

    // Loads the event layout and checks whether existing bookings protect it.
    private void editSelectedEvent() {
        // Prepares the local event value used in the following steps.
        final Event event = (Event) hostView.eventSelector.getSelectedItem();
        // Continues into this block only when the condition below is true.
        if (event == null) {
            // Leaves this method now because there is no further work for this request.
            return;
        }
        // Creates a background task; its fields hold results until showResult updates the interface.
        beginTask(new ScreenTask() {
            // Stores layout.
            private VenueLayout layout;
            // Stores active tickets.
            private long activeTickets;

            @Override
            // Runs database work in the background; it must not modify Swing controls.
            protected void performTask() throws Exception {
                // Updates this working value before the next step.
                layout = repository.layout(event.getId());
                // Updates this working value before the next step.
                activeTickets = repository.activeTickets(event.getId());
            }

            @Override
            // Updates the screen after background work completes successfully.
            protected void showResult() {
                // Calls this operation to carry out the named step with the supplied arguments.
                showEditor(event, layout, activeTickets > 0);
            }
        });
    }

    // Converts a spinner value to a normal int for grid calculations.
    private int number(JSpinner spinner) {
        // Prepares the local value value used in the following steps.
        Number value = (Number) spinner.getValue();
        // Returns this result to the method that called the current operation.
        return value.intValue();
    }

    // Fills the event editor and restores its saved stage, colors and seats.
    private void showEditor(Event event, VenueLayout layout, boolean protectSeats) {
        // Updates this working value before the next step.
        venueDesigner = null;
        simpleGridEditor = null;
        venueLayoutEditor = null;
        editingEvent = event;
        // Updates this working value before the next step.
        savedLayout = layout;
        // Updates this working value before the next step.
        protectedLayout = protectSeats;
        // Updates this working value before the next step.
        layoutChanged = event == null;
        // Clears the draft collection before building its replacement values.
        editorSeats.clear();
        // Updates this working value before the next step.
        vipColor = "#8B5CF6";
        // Updates this working value before the next step.
        regularColor = "#2AA89B";
        // Updates this working value before the next step.
        editorView = new EventEditorView();
        if (event == null) {
            editorView.heading.setText("Create event");
        } else {
            editorView.heading.setText("Edit event and venue");
        }
        editorView.startsAt.setToolTipText("Use year-month-day and 24-hour time. Example: 2026-12-15 19:00.");
        editorView.earlyBird.setToolTipText("Discounts stop at this date/time. It must be before the event starts.");
        editorView.basePrice.setToolTipText("Starting price for a new grid. Once customized, edit actual prices under Ticket types.");
        editorView.published.setToolTipText("Leave unchecked to save a private draft; check to allow Customer bookings.");
        editorView.nameLabel.setLabelFor(editorView.eventName);
        editorView.venueLabel.setLabelFor(editorView.venue);
        editorView.startsLabel.setLabelFor(editorView.startsAt);
        editorView.earlyLabel.setLabelFor(editorView.earlyBird);
        // Continues into this block only when the condition below is true.
        if (event == null) {
            // Displays this text in the named Swing component.
            editorView.basePrice.setText("500.00");
            // Displays this text in the named Swing component.
            editorView.startsAt.setText(LocalDate.now().plusDays(30).atTime(19, 0).format(inputDate));
            // Displays this text in the named Swing component.
            editorView.earlyBird.setText(LocalDate.now().plusDays(20).atTime(23, 59).format(inputDate));
        } // Handles the remaining case after the earlier condition was false.
        else {
            // Displays this text in the named Swing component.
            editorView.eventName.setText(event.getTitle());
            // Displays this text in the named Swing component.
            editorView.venue.setText(event.getVenue());
            // Calls this operation to carry out the named step with the supplied arguments.
            editorView.eventType.setSelectedItem(event.eventType());
            // Displays this text in the named Swing component.
            editorView.basePrice.setText(event.getBasePrice().toPlainString());
            // Displays this text in the named Swing component.
            editorView.startsAt.setText(event.getStartsAt().format(inputDate));
            // Displays this text in the named Swing component.
            editorView.earlyBird.setText(event.getEarlyBirdUntil().format(inputDate));
            // Displays this text in the named Swing component.
            editorView.description.setText(event.getDescription());
            // Calls this operation to carry out the named step with the supplied arguments.
            editorView.image.setSelectedItem(event.getImage());
            // Calls this operation to carry out the named step with the supplied arguments.
            editorView.published.setSelected(event.isPublished());
        }
        // Restores the saved grid instead of rebuilding it from defaults.
        if (layout != null) {
            // Calls this operation to carry out the named step with the supplied arguments.
            editorView.rows.setValue(layout.getRows());
            // Calls this operation to carry out the named step with the supplied arguments.
            editorView.columns.setValue(layout.getColumns());
            // Calls this operation to carry out the named step with the supplied arguments.
            editorView.stageRow.setValue(layout.getStageRow() + 1);
            // Calls this operation to carry out the named step with the supplied arguments.
            editorView.stageCol.setValue(layout.getStageColumn() + 1);
            // Calls this operation to carry out the named step with the supplied arguments.
            editorView.stageWidth.setValue(layout.getStageWidth());
            // Visits each object in the collection using an ordinary enhanced for loop.
            for (Seat seat : layout.getSeats()) {
                // Stores this value under its key so it can be found again later.
                editorSeats.put(seat.getRow() + ":" + seat.getColumn(), seat.getCategory());
                // Continues into this block only when the condition below is true.
                if ("VIP".equals(seat.getCategory())) {
                    // Updates this working value before the next step.
                    vipColor = seat.getColor();
                } // Handles the remaining case after the earlier condition was false.
                else {
                    // Updates this working value before the next step.
                    regularColor = seat.getColor();
                }
            }
        }
        // Prevents draft layout changes because VALID or USED tickets refer to this venue.
        if (protectedLayout) {
            // Displays this text in the named Swing component.
            editorView.protection.setText("Booked seats protect this layout. You can still edit event details.");
            // Prepares the local controls value used in the following steps.
            JComponent[] controls = {editorView.rows, editorView.columns, editorView.stageRow,
                editorView.stageCol, editorView.stageWidth, editorView.rebuild,
                editorView.vipColor, editorView.regularColor};
            // Visits each object in the collection using an ordinary enhanced for loop.
            for (JComponent control : controls) {
                // Enables or disables interaction according to the current selection or permissions.
                control.setEnabled(false);
            }
        }
        // Connects this control to the named event-handler command.
        connectButton(editorView.back, "editorBack");
        // Connects this control to the named event-handler command.
        connectButton(editorView.rebuild, "rebuildGrid");
        // Connects this control to the named event-handler command.
        connectButton(editorView.vipColor, "vipColor");
        // Connects this control to the named event-handler command.
        connectButton(editorView.regularColor, "regularColor");
        // Connects this control to the named event-handler command.
        connectButton(editorView.save, "saveEvent");
        // Calls this operation to carry out the named step with the supplied arguments.

        // Return to the original click-to-edit grid without changing saved venue geometry.
        if (layout == null || layout.isFlexible()) {
            venueLayoutEditor = new VenueLayoutEditor(layout, protectedLayout, new BigDecimal(editorView.basePrice.getText().trim()));
            venueLayoutEditor.setStartingPriceField(editorView.basePrice);
        } else {
            simpleGridEditor = new SimpleGridEditor(layout, protectedLayout, new BigDecimal(editorView.basePrice.getText().trim()));
            simpleGridEditor.setStartingPriceField(editorView.basePrice);
        }
        // Hide the old duplicate controls; the compact grid contains only its own essentials.
        for (JComponent control : new JComponent[]{editorView.rows, editorView.rowsLabel,
            editorView.columns, editorView.columnsLabel, editorView.stageRow, editorView.stageRowLabel,
            editorView.stageCol, editorView.stageColLabel, editorView.stageWidth, editorView.stageWidthLabel,
            editorView.rebuild, editorView.vipColor, editorView.regularColor, editorView.gridHelp, editorView.pricingRule}) {
            control.setVisible(false);
        }
        editorView.gridPanel.removeAll();
        editorView.gridPanel.setLayout(new BorderLayout());
        editorView.gridPanel.setBounds(32, 414, 1110, 510);
        if (venueLayoutEditor != null) {
            editorView.gridPanel.add(venueLayoutEditor, BorderLayout.CENTER);
        } else {
            editorView.gridPanel.add(simpleGridEditor, BorderLayout.CENTER);
        }
        editorView.published.setLocation(32, 950);
        editorView.save.setLocation(790, 944);
        editorView.setPreferredSize(new Dimension(1176, 1020));
        editorView.subtitle.setText("Add sections to the empty venue. Drag to arrange; click a section to edit its seats.");
        editorView.priceLabel.setText("Starting price (PHP)");
        if (!protectedLayout) {
            layoutChanged = true;
        }
        screen(editorView);
    }

    // Checks whether a grid coordinate belongs to the configured stage.
    private boolean editorStage(int row, int column) {
        // Prepares the local stage row value used in the following steps.
        int stageRow = number(editorView.stageRow) - 1;
        // Prepares the local stage column value used in the following steps.
        int stageColumn = number(editorView.stageCol) - 1;
        // Prepares the local stage width value used in the following steps.
        int stageWidth = number(editorView.stageWidth);
        // Returns this result to the method that called the current operation.
        return row == stageRow && column >= stageColumn && column < stageColumn + stageWidth;
    }

    // Returns the configured color for the selected section category.
    private String sectionColor(String category) {
        // Continues into this block only when the condition below is true.
        if ("VIP".equals(category)) {
            // Returns this result to the method that called the current operation.
            return vipColor;
        }
        // Returns this result to the method that called the current operation.
        return regularColor;
    }

    // Draws the stage, seat buttons and aisles without changing the database.
    private void renderEditorGrid() {
        // Prepares the local rows value used in the following steps.
        int rows = number(editorView.rows);
        // Prepares the local columns value used in the following steps.
        int columns = number(editorView.columns);
        // Prepares the local grid value used in the following steps.
        JPanel grid = new JPanel(new GridLayout(rows, columns, 5, 5));
        // Sets this component color; the gradient start/end colors form the purple theme.
        grid.setBackground(Color.WHITE);
        // Sets the visible outline or empty padding around this component.
        grid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // Repeats this block with an index so each relevant position or parameter is processed.
        for (int row = 0; row < rows; row++) {
            // Repeats this block with an index so each relevant position or parameter is processed.
            for (int column = 0; column < columns; column++) {
                // Continues into this block only when the condition below is true.
                if (editorStage(row, column)) {
                    // Prepares the local stage text value used in the following steps.
                    String stageText = "";
                    // Continues into this block only when the condition below is true.
                    if (column == number(editorView.stageCol) - 1 + number(editorView.stageWidth) / 2) {
                        // Updates this working value before the next step.
                        stageText = "STAGE";
                    }
                    // Prepares the local stage value used in the following steps.
                    JLabel stage = new JLabel(stageText, SwingConstants.CENTER);
                    // Controls whether the component paints its own background.
                    stage.setOpaque(true);
                    // Sets this component color; the gradient start/end colors form the purple theme.
                    stage.setBackground(Theme.INK);
                    // Sets the text or drawing color for this component.
                    stage.setForeground(Color.WHITE);
                    // Adds this object to the collection or this child component to its parent container.
                    grid.add(stage);
                } // Handles the remaining case after the earlier condition was false.
                else {
                    // Prepares the local key value used in the following steps.
                    String key = row + ":" + column;
                    // Prepares the local category value used in the following steps.
                    String category = editorSeats.get(key);
                    // Prepares the local seat button value used in the following steps.
                    JButton seatButton = new JButton();
                    // Continues into this block only when the condition below is true.
                    if (category == null) {
                        // Displays this text in the named Swing component.
                        seatButton.setText("·");
                        // Sets this component color; the gradient start/end colors form the purple theme.
                        seatButton.setBackground(Theme.BG);
                        // Shows this explanation when the pointer rests over the component.
                        seatButton.setToolTipText("AISLE");
                    } // Handles the remaining case after the earlier condition was false.
                    else {
                        // Prepares the local seat label value used in the following steps.
                        String seatLabel = "" + (char) ('A' + row) + (column + 1);
                        // Displays this text in the named Swing component.
                        seatButton.setText(seatLabel);
                        // Sets this component color; the gradient start/end colors form the purple theme.
                        seatButton.setBackground(Color.decode(sectionColor(category)));
                        // Shows this explanation when the pointer rests over the component.
                        seatButton.setToolTipText(category);
                    }
                    // Sets the font family, style and point size used to draw this component.
                    seatButton.setFont(new Font("Segoe UI", Font.BOLD, 11));
                    // Calls this operation to carry out the named step with the supplied arguments.
                    seatButton.setMargin(new Insets(0, 0, 0, 0));
                    // Sets the visible outline or empty padding around this component.
                    seatButton.setBorder(BorderFactory.createEmptyBorder());
                    // Controls whether the component paints its own background.
                    seatButton.setOpaque(true);
                    // Sets the text or drawing color for this component.
                    seatButton.setForeground(Color.WHITE);
                    // Enables or disables interaction according to the current selection or permissions.
                    seatButton.setEnabled(!protectedLayout);
                    // Connects this control to the named event-handler command.
                    connectButton(seatButton, "editSeat:" + key);
                    // Adds this object to the collection or this child component to its parent container.
                    grid.add(seatButton);
                }
            }
        }
        // Removes the old child components before drawing the replacement content.
        editorView.gridPanel.removeAll();
        // Chooses how child components are arranged inside this container.
        editorView.gridPanel.setLayout(new BorderLayout());
        // Adds this object to the collection or this child component to its parent container.
        editorView.gridPanel.add(grid, BorderLayout.CENTER);
        // Asks Swing to recalculate the layout after components change.
        editorView.gridPanel.revalidate();
        // Asks Swing to redraw the updated component.
        editorView.gridPanel.repaint();
    }

    // Validates grid bounds and rebuilds the editable seat arrangement.
    private void rebuildEditorGrid() {
        // Prevents draft layout changes because VALID or USED tickets refer to this venue.
        if (protectedLayout) {
            // Leaves this method now because there is no further work for this request.
            return;
        }
        // Attempts the following operation and lets the catch block handle a failure.
        try {
            new VenueLayout(number(editorView.rows), number(editorView.columns),
                    // Calls this operation to carry out the named step with the supplied arguments.
                    number(editorView.stageRow) - 1, number(editorView.stageCol) - 1,
                    // Calls this operation to carry out the named step with the supplied arguments.
                    number(editorView.stageWidth), new ArrayList<Seat>());
            // Clears the draft collection before building its replacement values.
            editorSeats.clear();
            // Repeats this block with an index so each relevant position or parameter is processed.
            for (int row = 0; row < number(editorView.rows); row++) {
                // Repeats this block with an index so each relevant position or parameter is processed.
                for (int column = 0; column < number(editorView.columns); column++) {
                    // Continues into this block only when the condition below is true.
                    if (column != number(editorView.columns) / 2) {
                        // Prepares the local category value used in the following steps.
                        String category = "REGULAR";
                        // Continues into this block only when the condition below is true.
                        if (row <= 2) {
                            // Updates this working value before the next step.
                            category = "VIP";
                        }
                        // Stores this value under its key so it can be found again later.
                        editorSeats.put(row + ":" + column, category);
                    }
                }
            }
            // Updates this working value before the next step.
            layoutChanged = true;
            // Calls this operation to carry out the named step with the supplied arguments.
            renderEditorGrid();
        } // Handles this error without reporting the failed operation as a success.
        catch (RuntimeException exception) {
            // Calls this operation to carry out the named step with the supplied arguments.
            failure(exception);
        }
    }

    // Cycles one cell between Regular, VIP and an aisle.
    private void changeEditorSeat(String key) {
        // Prevents draft layout changes because VALID or USED tickets refer to this venue.
        if (protectedLayout) {
            // Leaves this method now because there is no further work for this request.
            return;
        }
        // Prepares the local category value used in the following steps.
        String category = editorSeats.get(key);
        // Continues into this block only when the condition below is true.
        if (category == null) {
            // Stores this value under its key so it can be found again later.
            editorSeats.put(key, "REGULAR");
        } // Checks the next possible case when the earlier condition was false.
        else if ("REGULAR".equals(category)) {
            // Stores this value under its key so it can be found again later.
            editorSeats.put(key, "VIP");
        } // Handles the remaining case after the earlier condition was false.
        else {
            // Removes this draft entry; for a grid cell, a missing entry represents an aisle.
            editorSeats.remove(key);
        }
        // Updates this working value before the next step.
        layoutChanged = true;
        // Calls this operation to carry out the named step with the supplied arguments.
        renderEditorGrid();
    }

    // Uses the color chooser to change a section color in the draft layout.
    private void chooseSectionColor(boolean vip) {
        // Prevents draft layout changes because VALID or USED tickets refer to this venue.
        if (protectedLayout) {
            // Leaves this method now because there is no further work for this request.
            return;
        }
        // Prepares the local previous color value used in the following steps.
        String previousColor = regularColor;
        // Prepares the local title value used in the following steps.
        String title = "Regular section color";
        // Continues into this block only when the condition below is true.
        if (vip) {
            // Updates this working value before the next step.
            previousColor = vipColor;
            // Updates this working value before the next step.
            title = "VIP section color";
        }
        // Prepares the local chosen color value used in the following steps.
        Color chosenColor = JColorChooser.showDialog(this, title, Color.decode(previousColor));
        // Applies the chosen color only if the user accepted the color dialog.
        if (chosenColor != null) {
            // Prepares the local hex color value used in the following steps.
            String hexColor = String.format("#%02X%02X%02X", chosenColor.getRed(), chosenColor.getGreen(), chosenColor.getBlue());
            // Continues into this block only when the condition below is true.
            if (vip) {
                // Updates this working value before the next step.
                vipColor = hexColor;
            } // Handles the remaining case after the earlier condition was false.
            else {
                // Updates this working value before the next step.
                regularColor = hexColor;
            }
            // Updates this working value before the next step.
            layoutChanged = true;
            // Calls this operation to carry out the named step with the supplied arguments.
            renderEditorGrid();
        }
    }

    // Reads and validates the form, creates an Event subclass and saves it with its layout.
    private void saveEditorEvent() {
        // Attempts the following operation and lets the catch block handle a failure.
        try {
            // Prepares the local rows value used in the following steps.
            int rows = number(editorView.rows);
            // Prepares the local columns value used in the following steps.
            int columns = number(editorView.columns);
            // Prepares the local stage row value used in the following steps.
            int stageRow = number(editorView.stageRow) - 1;
            // Prepares the local stage column value used in the following steps.
            int stageColumn = number(editorView.stageCol) - 1;
            // Prepares the local stage width value used in the following steps.
            int stageWidth = number(editorView.stageWidth);
            // Prepares the local seats value used in the following steps.
            List<Seat> seats = new ArrayList<Seat>();
            // Repeats this block with an index so each relevant position or parameter is processed.
            for (int row = 0; row < rows; row++) {
                // Repeats this block with an index so each relevant position or parameter is processed.
                for (int column = 0; column < columns; column++) {
                    // Prepares the local category value used in the following steps.
                    String category = editorSeats.get(row + ":" + column);
                    // Continues into this block only when the condition below is true.
                    if (category != null && !editorStage(row, column)) {
                        // Prepares the local label value used in the following steps.
                        String label = "" + (char) ('A' + row) + (column + 1);
                        // Prepares the local seat value used in the following steps.
                        Seat seat = new Seat(0, row, column, label, category, sectionColor(category), "AVAILABLE");
                        // Adds this object to the collection or this child component to its parent container.
                        seats.add(seat);
                    }
                }
            }
            // Prepares the local layout value used in the following steps.
            final VenueLayout layout;
            if (venueLayoutEditor != null) {
                layout = venueLayoutEditor.getVenueLayout();
            } else if (simpleGridEditor != null) {
                layout = simpleGridEditor.getVenueLayout();
            } else if (venueDesigner != null) {
                layout = new VenueLayout(venueDesigner.getPlan());
            } else if (savedLayout != null && (protectedLayout || hasCustomTypes(savedLayout))) {
                layout = savedLayout;
            } else {
                layout = new VenueLayout(rows, columns, stageRow, stageColumn, stageWidth, seats);
            }
            // Prepares the local start value used in the following steps.
            LocalDateTime start = LocalDateTime.parse(editorView.startsAt.getText().trim(), inputDate);
            // Prepares the local early value used in the following steps.
            LocalDateTime early = LocalDateTime.parse(editorView.earlyBird.getText().trim(), inputDate);
            // Prepares the local price value used in the following steps.
            BigDecimal price = new BigDecimal(editorView.basePrice.getText().trim());
            // Continues into this block only when the condition below is true.
            if (price.compareTo(new BigDecimal("99999999.99")) > 0) {
                // Stops this operation with a clear error; the caller can display or test the failure.
                throw new IllegalArgumentException("Price is too large.");
            }
            // Prepares the local name value used in the following steps.
            String name = editorView.eventName.getText().trim();
            // Prepares the local venue value used in the following steps.
            String venue = editorView.venue.getText().trim();
            // Prepares the local description value used in the following steps.
            String description = editorView.description.getText().trim();
            // Continues into this block only when the condition below is true.
            if (name.length() > 140 || venue.length() > 180 || description.length() > 3000) {
                // Stops this operation with a clear error; the caller can display or test the failure.
                throw new IllegalArgumentException("Use at most 140 title, 180 venue and 3000 description characters.");
            }
            // Prepares the local id value used in the following steps.
            long id = 0;
            // Continues into this block only when the condition below is true.
            if (editingEvent != null) {
                // Updates this working value before the next step.
                id = editingEvent.getId();
            }
            // Prepares the local owner value used in the following steps.
            long owner = session.getUser().getId();
            // Prepares the local image value used in the following steps.
            String image = (String) editorView.image.getSelectedItem();
            // Prepares the local publish value used in the following steps.
            final boolean publish = editorView.published.isSelected();
            // Prepares the local type value used in the following steps.
            String type = (String) editorView.eventType.getSelectedItem();
            // Prepares the local event value used in the following steps.
            final Event event;
            // Continues into this block only when the condition below is true.
            if ("SPORTS".equals(type)) {
                // Updates this working value before the next step.
                event = new SportsMatch(id, owner, name, venue, description, image, start, early, price, publish);
            } // Checks the next possible case when the earlier condition was false.
            else if ("MOVIE".equals(type)) {
                // Updates this working value before the next step.
                event = new MovieScreening(id, owner, name, venue, description, image, start, early, price, publish);
            } // Handles the remaining case after the earlier condition was false.
            else {
                // Updates this working value before the next step.
                event = new Concert(id, owner, name, venue, description, image, start, early, price, publish);
            }
            // Prepares the local changed value used in the following steps.
            boolean changed = layoutChanged || savedLayout == null;
            // Continues into this block only when the condition below is true.
            if (savedLayout != null && (rows != savedLayout.getRows() || columns != savedLayout.getColumns()
                    || stageRow != savedLayout.getStageRow() || stageColumn != savedLayout.getStageColumn()
                    || stageWidth != savedLayout.getStageWidth())) {
                // Updates this working value before the next step.
                changed = true;
            }
            // Prepares the local replace layout value used in the following steps.
            if (venueLayoutEditor != null || simpleGridEditor != null || venueDesigner != null) {
                changed = !protectedLayout;
            } else if (savedLayout != null && hasCustomTypes(savedLayout)) {
                changed = false;
            }
            final boolean replaceLayout = changed;
            // Creates a background task; its fields hold results until showResult updates the interface.
            beginTask(new ScreenTask() {
                // Stores saved event id.
                private long savedEventId;

                @Override
                // Runs database work in the background; it must not modify Swing controls.
                protected void performTask() throws Exception {
                    // Updates this working value before the next step.
                    savedEventId = repository.saveEvent(session, event, layout, replaceLayout);
                }

                @Override
                // Updates the screen after background work completes successfully.
                protected void showResult() {
                    // Continues into this block only when the condition below is true.
                    if (publish) {
                        // Calls this operation to carry out the named step with the supplied arguments.
                        info("Event and venue saved and published.");
                    } // Handles the remaining case after the earlier condition was false.
                    else {
                        // Calls this operation to carry out the named step with the supplied arguments.
                        info("Event and venue saved as a draft.");
                    }
                    // Calls this operation to carry out the named step with the supplied arguments.
                    showHostDashboard(savedEventId);
                }
            });
        } // Handles this error without reporting the failed operation as a success.
        catch (DateTimeParseException exception) {
            // Calls this operation to carry out the named step with the supplied arguments.
            info("Use a valid date and time in yyyy-MM-dd HH:mm format.");
        } // Handles this error without reporting the failed operation as a success.
        catch (NumberFormatException exception) {
            // Calls this operation to carry out the named step with the supplied arguments.
            info("Enter a price such as 500.00. Custom ticket prices are set in Ticket types.");
        } // Handles this error without reporting the failed operation as a success.
        catch (RuntimeException exception) {
            // Calls this operation to carry out the named step with the supplied arguments.
            failure(exception);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // NetBeans generates this layout code from the matching .form file; positions are measured in pixels.
    private void initComponents(){
        // Updates this working value before the next step.
        navigation=new NavigationView();
        // Updates this working value before the next step.
        viewport=new JScrollPane();
        // Updates this working value before the next step.
        footer=new JLabel();
        // Calls this operation to carry out the named step with the supplied arguments.
        setTitle("OpenEvent · For the independent scene");
        // Calls this operation to carry out the named step with the supplied arguments.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Chooses how child components are arranged inside this container.
        getContentPane().setLayout(new BorderLayout());
        // Specifies the component size requested from its layout or scroll container.
        navigation.setPreferredSize(new Dimension(1176,72));
        // Adds this object to the collection or this child component to its parent container.
        getContentPane().add(new ResponsiveView(navigation,1176),BorderLayout.NORTH);
        // Sets the visible outline or empty padding around this component.
        viewport.setBorder(null);
        // Calls this operation to carry out the named step with the supplied arguments.
        viewport.getVerticalScrollBar().setUnitIncrement(26);
        // Adds this object to the collection or this child component to its parent container.
        getContentPane().add(viewport,BorderLayout.CENTER);
        // Displays this text in the named Swing component.
        footer.setText("   OpenEvent / For the independent scene.                                      Classroom prototype · All " +
                "payments and refunds are simulated");
        // Sets the font family, style and point size used to draw this component.
        footer.setFont(new Font("Segoe UI",0,11));
        // Sets the text or drawing color for this component.
        footer.setForeground(Theme.MUTED);
        // Specifies the component size requested from its layout or scroll container.
        footer.setPreferredSize(new Dimension(1176,27));
        // Adds this object to the collection or this child component to its parent container.
        getContentPane().add(footer,BorderLayout.SOUTH);
        // Calls this operation to carry out the named step with the supplied arguments.
        pack();
    }
    // </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Stores navigation.
    private NavigationView navigation;
    // Stores viewport.
    private JScrollPane viewport;
    // Stores footer.
    private JLabel footer;
    // End of variables declaration//GEN-END:variables

    // Reuse the form's existing container; all generated .form metadata stays intact.
    private void installFlexibleEditor(VenuePlan plan) {
        venueDesigner = new VenueDesigner(plan, protectedLayout, new BigDecimal(editorView.basePrice.getText().trim()));
        venueDesigner.setTemplatePriceField(editorView.basePrice);
        for (JComponent control : new JComponent[]{editorView.rows, editorView.rowsLabel, editorView.columns, editorView.columnsLabel,
            editorView.stageRow, editorView.stageRowLabel, editorView.stageCol, editorView.stageColLabel,
            editorView.stageWidth, editorView.stageWidthLabel, editorView.rebuild, editorView.vipColor,
            editorView.regularColor, editorView.gridHelp, editorView.pricingRule}) {
            control.setVisible(false);
        }
        // Remove legacy-only runtime buttons if the user upgrades an old unbooked grid.
        for (java.awt.Component component : editorView.getComponents()) {
            if (component instanceof JButton && component.getY() == 497) {
                component.setVisible(false);
            }
        }
        editorView.gridPanel.removeAll();
        editorView.gridPanel.setLayout(new BorderLayout());
        editorView.gridPanel.setBounds(32, 414, 1110, 660);
        editorView.gridPanel.add(venueDesigner, BorderLayout.CENTER);
        editorView.published.setLocation(32, 1100);
        editorView.save.setLocation(790, 1094);
        editorView.setPreferredSize(new Dimension(1176, 1170));
        editorView.subtitle.setText("Arrange physical sections and assign custom ticket offers. Prices are set in Ticket types.");
        editorView.priceLabel.setText("Template starting price (PHP)");
        layoutChanged = true;
        editorView.revalidate();
        editorView.repaint();
    }

    private boolean hasCustomTypes(VenueLayout layout) {
        for (Seat seat : layout.getSeats()) {
            if (seat.getTicketType() != null) {
                return true;
            }
        }
        return false;
    }

    private void manageLegacyTypes() {
        final long eventId = editingEvent.getId();
        beginTask(new ScreenTask() {
            private List<TicketType> types;

            @Override
            protected void performTask() throws Exception {
                types = repository.ticketTypes(session, eventId);
            }

            @Override
            protected void showResult() {
                java.util.Set<String> assigned = new java.util.HashSet<String>();
                for (Seat seat : savedLayout.getSeats()) {
                    assigned.add(seat.getTypeCode());
                }
                TicketTypePanel panel = new TicketTypePanel(types, assigned);
                panel.setPreferredSize(new Dimension(650, 440));
                while (JOptionPane.showConfirmDialog(OpenEventUI.this, panel, "Event ticket types", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION) {
                    try {
                        saveLegacyTypes(eventId, panel.getTypes());
                        return;
                    } catch (RuntimeException exception) {
                        failure(exception);
                    }
                }
            }
        });
    }

    private void saveLegacyTypes(final long eventId, final List<TicketType> types) {
        beginTask(new ScreenTask() {
            @Override
            protected void performTask() throws Exception {
                repository.updateTicketTypes(session, eventId, types);
            }

            @Override
            protected void showResult() {
                info("Ticket types saved. Existing purchased tickets keep their original names and amounts.");
                showHostDashboard(eventId);
            }
        });
    }
}
