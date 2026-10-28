package com.mycompany.openevent;
import com.mycompany.openevent.model.BookingRequest;
import com.mycompany.openevent.model.Concert;
import com.mycompany.openevent.model.Event;
import com.mycompany.openevent.model.Host;
import com.mycompany.openevent.model.Session;
import com.mycompany.openevent.model.Seat;
import com.mycompany.openevent.model.Stage;
import com.mycompany.openevent.model.Ticket;
import com.mycompany.openevent.model.TicketType;
import com.mycompany.openevent.model.VenueArea;
import com.mycompany.openevent.model.VenuePlan;
import com.mycompany.openevent.model.VenueLayout;
import com.mycompany.openevent.model.CashPayment;
import com.mycompany.openevent.service.BookingRepository;
import com.mycompany.openevent.service.Database;
import com.mycompany.openevent.service.SecurityService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/** Explicit integration harness; every event it creates is cleaned in finally. */
public class FlexibleVenueChecks {
    private static int passed;
    private static final BookingRepository repository=new BookingRepository();
    private static final List<Long> events=new ArrayList<Long>();
    private static Session host;
    private static Session customer;
    interface Operation { void run() throws Exception; }
    private static void check(boolean condition,String message) {
        if(!condition) { throw new AssertionError(message); }
        System.out.println("PASS "+(++passed)+": "+message);
    }
    private static void reject(Operation operation,String message) throws Exception {
        boolean rejected=false;
        try { operation.run(); } catch(IllegalArgumentException exception) { rejected=true; }
        check(rejected,message);
    }
    private static Event event(long id,String title) {
        return new Concert(id,host.getUser().getId(),title,"Test venue","Temporary test fixture","concert.jpg",
            LocalDateTime.now().plusDays(40),LocalDateTime.now().plusDays(20),new BigDecimal("500.00"),true);
    }
    private static VenueArea copyArea(VenueArea area,String type,Set<String> blocked) {
        return new VenueArea(area.getCode(),area.getName(),type,area.getX(),area.getY(),area.getWidth(),area.getHeight(),area.getRows(),area.getColumns(),area.getRowOffset(),area.getShape(),blocked);
    }
    public static void main(String[] args) throws Exception {
        SecurityService security=new SecurityService();
        host=security.login("host@openevent.local","OpenEvent2026!".toCharArray(),true);
        customer=security.login("alex@openevent.local","OpenEvent2026!".toCharArray(),false);
        String prefix="Flexible test "+UUID.randomUUID().toString().substring(0,8);
        try {
            for(String template:new String[]{"Rectangular Hall","U-shaped Arena","Fan Theater"}) {
                VenuePlan plan=VenuePlan.template(template,new BigDecimal("500.00"));
                check(plan.createSeats().size()>=180,"Template validates and generates seats: "+template);
                long id=repository.saveEvent(host,event(0,prefix+template),new VenueLayout(plan),true);events.add(id);
                VenueLayout loaded=repository.layout(id);
                check(loaded.isFlexible() && loaded.getPlan().getAreas().size()==plan.getAreas().size(),"Overview round trip: "+template);
                check(loaded.getSeats().size()==plan.createSeats().size(),"Seat persistence: "+template);
            }
            final VenuePlan original=VenuePlan.template("Fan Theater",new BigDecimal("500.00"));
            reject(new Operation() { public void run() { new Stage(950,50,100,50); } },"Out-of-bounds stage rejected");
            reject(new Operation() { public void run() {
                new VenuePlan(new Stage(100,170,200,100),original.getAreas(),original.getTicketTypes());
            } },"Stage-section overlap rejected");
            reject(new Operation() { public void run() {
                List<VenueArea> areas=original.getAreas();VenueArea a=areas.get(0);VenueArea b=areas.get(1);
                areas.set(1,new VenueArea(b.getCode(),b.getName(),b.getTypeCode(),a.getX(),a.getY(),a.getWidth(),a.getHeight(),5,6,10,"RECTANGLE",new HashSet<String>()));
                new VenuePlan(original.getStage(),areas,original.getTicketTypes());
            } },"Section-section overlap rejected");
            reject(new Operation() { public void run() {
                new VenueArea("S","Too large","GENERAL",0,0,100,100,11,10,0,"RECTANGLE",new HashSet<String>());
            } },"More than 100 seats in a section rejected");
            reject(new Operation() { public void run() {
                List<TicketType> types=original.getTicketTypes();types.add(new TicketType("DUP","General Admission",new BigDecimal("100"),"#000000",false));
                new VenuePlan(original.getStage(),original.getAreas(),types);
            } },"Duplicate display names rejected");
            List<TicketType> offers=original.getTicketTypes();
            offers.add(new TicketType("MEET","Meet and Greet",new BigDecimal("1550.00"),"#DDAA11",true));
            List<VenueArea> areas=original.getAreas();
            Set<String> blocked=new HashSet<String>();blocked.add("0:0");
            areas.set(0,copyArea(areas.get(0),"MEET",blocked));
            final VenuePlan custom=new VenuePlan(original.getStage(),areas,offers);
            check(custom.createSeats().size()==179,"Blocked cell is excluded from sellable seats");
            long customId=repository.saveEvent(host,event(0,prefix+"Custom"),new VenueLayout(custom),true);events.add(customId);
            final long id=customId;
            VenueLayout loaded=repository.layout(id);
            check(loaded.getPlan().getTicketTypes().size()==3,"Third custom ticket type persisted");
            check(loaded.getPlan().getAreas().get(0).isBlocked(0,0),"Blocked positions persist");
            Seat selected=null;
            for(Seat seat:loaded.getSeats()) { if("S1".equals(seat.getAreaCode())) { selected=seat;break; } }
            final Seat seat=selected;
            check(seat!=null && seat.getTicketType().getName().equals("Meet and Greet"),"Physical section and ticket type load independently");
            check(event(id,prefix).calculatePrice(seat,"Meet and Greet").equals(new BigDecimal("1550.00")),"Custom price ignores legacy VIP multipliers");
            check(event(id,prefix).calculatePrice(seat,"Meet and Greet / Early Bird").equals(new BigDecimal("1240.00")),"Early Bird applies to eligible custom offer");
            reject(new Operation() { public void run() {
                event(id,prefix).calculatePrice(seat,"General Admission");
            } },"Cheaper category substitution rejected");
            Ticket purchased=repository.purchase(customer,new BookingRequest(id,seat.getId(),"Meet and Greet",new CashPayment(),true));
            check(purchased.getCategory().equals("Meet and Greet") && purchased.getAmount().equals(new BigDecimal("1550.00")),"Purchase snapshots custom name and price");
            reject(new Operation() { public void run() throws Exception {
                repository.saveEvent(host,event(id,prefix),new VenueLayout(custom),true);
            } },"Active purchase blocks layout replacement");
            List<TicketType> renamed=new ArrayList<TicketType>();
            for(TicketType type:custom.getTicketTypes()) {
                if(type.getCode().equals("MEET")) { renamed.add(new TicketType("MEET","Artist Circle",new BigDecimal("1800.00"),"#EE9900",true)); }
                else { renamed.add(type); }
            }
            final VenuePlan updated=new VenuePlan(custom.getStage(),custom.getAreas(),renamed);
            repository.saveEvent(host,event(id,prefix),new VenueLayout(updated),false);
            check(repository.layout(id).getPlan().getType("MEET").getName().equals("Artist Circle"),"Booked event allows ticket rename and future-price update");
            Ticket historical=repository.tickets(customer,id).get(0);
            // Find our fixture rather than relying on unrelated tickets' issue times.
            for(Ticket item:repository.tickets(customer,id)) { if(item.getId()==purchased.getId()) { historical=item; } }
            check(historical.getCategory().equals("Meet and Greet") && historical.getAmount().equals(new BigDecimal("1550.00")),"Existing purchased ticket retains original offer snapshot");
            Seat next=null;
            for(Seat item:repository.layout(id).getSeats()) { if(item.isAvailable() && "S1".equals(item.getAreaCode())) { next=item;break; } }
            Ticket second=repository.purchase(customer,new BookingRequest(id,next.getId(),"Artist Circle",new CashPayment(),true));
            check(second.getAmount().equals(new BigDecimal("1800.00")),"Future purchase uses renamed offer and updated price");
            reject(new Operation() { public void run() throws Exception {
                List<VenueArea> changed=updated.getAreas();VenueArea a=changed.get(0);
                changed.set(0,new VenueArea(a.getCode(),a.getName(),a.getTypeCode(),a.getX()+1,a.getY(),a.getWidth(),a.getHeight(),a.getRows(),a.getColumns(),a.getRowOffset(),a.getShape(),a.getBlocked()));
                repository.saveEvent(host,event(id,prefix),new VenueLayout(new VenuePlan(updated.getStage(),changed,updated.getTicketTypes())),false);
            } },"Booked layout cannot bypass move protection through metadata save");
            reject(new Operation() { public void run() throws Exception {
                List<TicketType> removed=updated.getTicketTypes();removed.remove(2);repository.updateTicketTypes(host,id,removed);
            } },"Assigned ticket type cannot be removed");
            reject(new Operation() { public void run() throws Exception {
                repository.updateTicketTypes(customer,id,updated.getTicketTypes());
            } },"Customer cannot modify ticket offers");
            reject(new Operation() { public void run() throws Exception {
                Session other=new Session(new Host(host.getUser().getId()+100000,"Other","other@example.local"));
                repository.updateTicketTypes(other,id,updated.getTicketTypes());
            } },"Different Host cannot modify offers");
            repository.cancel(customer,purchased.getId());
            check(repository.layout(id).getSeats().get(0).isAvailable(),"Refund releases custom section seat");
            check(repository.checkIn(host,id,second.getCode())!=null,"Custom ticket supports one-time check-in");
            check(new BookingRepository().layout(id).getPlan().getType("MEET").getPrice().equals(new BigDecimal("1800.00")),"Custom layout survives a new connection");
            // Smoke-test Swing constructors and immutable designer save on the drawing thread.
            javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    com.mycompany.openevent.ui.VenueDesigner designer=new com.mycompany.openevent.ui.VenueDesigner(custom,false,new BigDecimal("500.00"));
                    check(designer.getPlan().createSeats().size()==179,"Venue designer initializes without losing blocked seats");
                    com.mycompany.openevent.ui.VenueBrowser browser=new com.mycompany.openevent.ui.VenueBrowser(new VenueLayout(custom),new com.mycompany.openevent.ui.SeatGrid.SeatSelectionListener() {
                        public void seatSelected(Seat selectedSeat) { }
                    });
                    boolean overview=false;
                    for(java.awt.Component component:browser.getComponents()) { if(component instanceof com.mycompany.openevent.ui.VenueCanvas) { overview=true; } }
                    check(overview,"Customer section browser initializes with its overview");
                }
            });
            List<Seat> legacySeats=new ArrayList<Seat>();
            legacySeats.add(new Seat(0,1,0,"B1","REGULAR","#2AA89B","AVAILABLE"));
            legacySeats.add(new Seat(0,1,1,"B2","REGULAR","#2AA89B","AVAILABLE"));
            legacySeats.add(new Seat(0,2,0,"C1","VIP","#8B5CF6","AVAILABLE"));
            VenueLayout legacy=new VenueLayout(4,4,0,0,2,legacySeats);
            long legacyId=repository.saveEvent(host,event(0,prefix+"Legacy"),legacy,true);events.add(legacyId);
            VenueLayout legacyBefore=repository.layout(legacyId);
            Seat oldSeat=legacyBefore.getSeats().get(0);
            Ticket oldTicket=repository.purchase(customer,new BookingRequest(legacyId,oldSeat.getId(),"REGULAR",new CashPayment(),true));
            List<TicketType> legacyTypes=repository.ticketTypes(host,legacyId);
            check(legacyTypes.size()==2 && legacyTypes.get(0).getPrice()!=null,"Legacy offers receive editable default prices");
            List<TicketType> legacyUpdated=new ArrayList<TicketType>();
            for(TicketType offer:legacyTypes) {
                if(offer.getCode().equals("REGULAR")) { legacyUpdated.add(new TicketType("REGULAR","Floor Pass",new BigDecimal("600.00"),"#3377AA",true)); }
                else { legacyUpdated.add(offer); }
            }
            repository.updateTicketTypes(host,legacyId,legacyUpdated);
            VenueLayout legacyAfter=repository.layout(legacyId);
            check(!legacyAfter.isFlexible() && legacyAfter.getSeats().get(0).getId()==oldSeat.getId(),"Renaming a legacy offer preserves its grid and seat identities");
            check(legacyAfter.getSeats().get(1).getCategory().equals("Floor Pass"),"Legacy grid seats display renamed custom offers");
            Ticket legacyFuture=repository.purchase(customer,new BookingRequest(legacyId,legacyAfter.getSeats().get(1).getId(),"Floor Pass",new CashPayment(),true));
            check(legacyFuture.getAmount().equals(new BigDecimal("600.00")),"Legacy future sales use the customized price");
            Ticket originalSnapshot=null;
            for(Ticket item:repository.tickets(customer,legacyId)) { if(item.getId()==oldTicket.getId()) { originalSnapshot=item; } }
            check(originalSnapshot!=null && originalSnapshot.getCategory().equals("REGULAR") && originalSnapshot.getAmount().equals(new BigDecimal("500.00")),"Legacy purchased ticket keeps original name and amount");
            reject(new Operation() { public void run() {
                List<VenueArea> tooMany=new ArrayList<VenueArea>();
                for(int i=0;i<13;i++) { tooMany.add(original.getAreas().get(0)); }
                new VenuePlan(original.getStage(),tooMany,original.getTicketTypes());
            } },"More than 12 physical sections rejected");
            reject(new Operation() { public void run() {
                List<TicketType> tooMany=new ArrayList<TicketType>();
                for(int i=0;i<21;i++) { tooMany.add(new TicketType("T"+i,"Type "+i,new BigDecimal("100.00"),"#000000",false)); }
                new VenuePlan(original.getStage(),original.getAreas(),tooMany);
            } },"More than 20 ticket types rejected");
            System.out.println("ALL "+passed+" FLEXIBLE VENUE CHECKS PASSED");
        }
        finally {
            // Clean only the fixture events recorded by this process, in foreign-key order.
            try(Connection connection=Database.connect()) {
                for(long id:events) {
                    for(String sql:new String[]{
                        "DELETE r FROM receipts r JOIN tickets t ON t.id=r.ticket_id WHERE t.event_id=?",
                        "DELETE p FROM payments p JOIN tickets t ON t.id=p.ticket_id WHERE t.event_id=?",
                        "DELETE FROM tickets WHERE event_id=?","DELETE FROM seats WHERE event_id=?",
                        "DELETE FROM venue_areas WHERE event_id=?","DELETE FROM venue_plans WHERE event_id=?",
                        "DELETE FROM sections WHERE event_id=?","DELETE FROM venue_layouts WHERE event_id=?","DELETE FROM events WHERE id=?"}) {
                        try(PreparedStatement query=connection.prepareStatement(sql)) { query.setLong(1,id);query.executeUpdate(); }
                    }
                }
            }
        }
    }
}

