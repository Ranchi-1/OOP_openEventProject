package com.mycompany.openevent.service;
// Import Stage for the explicit types used below.
import com.mycompany.openevent.model.Stage;
// Import VenueArea for the explicit types used below.
import com.mycompany.openevent.model.VenueArea;
// Import VenuePlan for the explicit types used below.
import com.mycompany.openevent.model.VenuePlan;
// Import TicketType for the explicit types used below.
import com.mycompany.openevent.model.TicketType;
// Import Connection for the explicit types used below.
import java.sql.Connection;
// Import PreparedStatement for the explicit types used below.
import java.sql.PreparedStatement;
// Import ResultSet for the explicit types used below.
import java.sql.ResultSet;
// Import SQLException for the explicit types used below.
import java.sql.SQLException;
// Import ArrayList for the explicit types used below.
import java.util.ArrayList;
// Import HashSet for the explicit types used below.
import java.util.HashSet;
// Import List for the explicit types used below.
import java.util.List;
// Import Set for the explicit types used below.
import java.util.Set;

/** Reads and writes the overview inside BookingRepository's existing transaction. */
public class VenuePlanRepository {
    public static List<TicketType> readTypes(Connection connection,long eventId) throws SQLException {
        List<TicketType> types=new ArrayList<TicketType>();
        // Close this JDBC resource automatically when the block finishes.
        try(PreparedStatement query=connection.prepareStatement("SELECT * FROM sections WHERE event_id=? ORDER BY id")) {
            query.setLong(1,eventId);
            // Close this JDBC resource automatically when the block finishes.
            try(ResultSet rows=query.executeQuery()) {
                while(rows.next()) {
                    // Validate this condition before continuing with the operation.
                    if(rows.getBigDecimal("ticket_price")!=null) {
                        types.add(new TicketType(rows.getString("category"),rows.getString("ticket_name"),rows.getBigDecimal("ticket_price"),rows.getString("color"),rows.getBoolean("early_bird")));
                    }
                }
            }
        }
        return types;
    }
    public static VenuePlan read(Connection connection,long eventId) throws SQLException {
        Stage stage;
        // Close this JDBC resource automatically when the block finishes.
        try(PreparedStatement query=connection.prepareStatement("SELECT * FROM venue_plans WHERE event_id=?")) {
            query.setLong(1,eventId);
            // Close this JDBC resource automatically when the block finishes.
            try(ResultSet row=query.executeQuery()) {
                // Validate this condition before continuing with the operation.
                if(!row.next()) { return null; }
                stage=new Stage(row.getInt("stage_x"),row.getInt("stage_y"),row.getInt("stage_width"),row.getInt("stage_height"));
            }
        }
        List<VenueArea> areas=new ArrayList<VenueArea>();
        // Close this JDBC resource automatically when the block finishes.
        try(PreparedStatement query=connection.prepareStatement("SELECT * FROM venue_areas WHERE event_id=? ORDER BY row_offset")) {
            query.setLong(1,eventId);
            // Close this JDBC resource automatically when the block finishes.
            try(ResultSet row=query.executeQuery()) {
                while(row.next()) {
                    Set<String> blocked=new HashSet<String>();
                    String cells=row.getString("blocked_cells");
                    // Validate this condition before continuing with the operation.
                    if(!cells.isEmpty()) {
                        // Visit each relevant item using an ordinary loop.
                        for(String cell:cells.split(",")) { blocked.add(cell); }
                    }
                    areas.add(new VenueArea(row.getString("code"),row.getString("name"),row.getString("type_code"),
                        row.getInt("x"),row.getInt("y"),row.getInt("width"),row.getInt("height"),row.getInt("seat_rows"),row.getInt("seat_columns"),
                        row.getInt("row_offset"),row.getString("shape"),blocked,row.getString("area_color")));
                }
            }
        }
        return new VenuePlan(stage,areas,readTypes(connection,eventId));
    }
    public static void save(Connection connection,long eventId,VenuePlan plan) throws SQLException {
        // Children are removed before their parent; old ticket rows remain untouched.
        try(PreparedStatement delete=connection.prepareStatement("DELETE FROM venue_areas WHERE event_id=?")) {
            delete.setLong(1,eventId); delete.executeUpdate();
        }
        // Close this JDBC resource automatically when the block finishes.
        try(PreparedStatement delete=connection.prepareStatement("DELETE FROM venue_plans WHERE event_id=?")) {
            delete.setLong(1,eventId); delete.executeUpdate();
        }
        // Validate this condition before continuing with the operation.
        if(plan==null) { return; }
        Stage stage=plan.getStage();
        // Close this JDBC resource automatically when the block finishes.
        try(PreparedStatement insert=connection.prepareStatement("INSERT INTO venue_plans VALUES(?,?,?,?,?)")) {
            insert.setLong(1,eventId); insert.setInt(2,stage.getX()); insert.setInt(3,stage.getY());
            insert.setInt(4,stage.getWidth()); insert.setInt(5,stage.getHeight()); insert.executeUpdate();
        }
        // Visit each relevant item using an ordinary loop.
        for(VenueArea area:plan.getAreas()) {
            String cells=String.join(",",area.getBlocked());
            // Close this JDBC resource automatically when the block finishes.
            try(PreparedStatement insert=connection.prepareStatement("INSERT INTO venue_areas(event_id,code,name,type_code,x,y,width,height,seat_rows,seat_columns,row_offset,shape,blocked_cells,area_color) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
                insert.setLong(1,eventId); insert.setString(2,area.getCode()); insert.setString(3,area.getName()); insert.setString(4,area.getTypeCode());
                insert.setInt(5,area.getX()); insert.setInt(6,area.getY()); insert.setInt(7,area.getWidth()); insert.setInt(8,area.getHeight());
                insert.setInt(9,area.getRows()); insert.setInt(10,area.getColumns()); insert.setInt(11,area.getRowOffset());
                insert.setString(12,area.getShape()); insert.setString(13,cells); insert.setString(14,area.getColor()); insert.executeUpdate();
            }
        }
    }
    public static void updateTypes(Connection connection,long eventId,List<TicketType> types) throws SQLException {
        // An upsert changes future offers without rewriting historical ticket snapshots.
        Set<String> names=new HashSet<String>();
        Set<String> codes=new HashSet<String>();
        // Validate this condition before continuing with the operation.
        if(types.isEmpty() || types.size()>20) { throw new IllegalArgumentException("Use 1–20 ticket types."); }
        // Visit each relevant item using an ordinary loop.
        for(TicketType type:types) {
            // Validate this condition before continuing with the operation.
            if(!names.add(type.getName().toLowerCase(java.util.Locale.ROOT)) || !codes.add(type.getCode())) {
                // Reject invalid input with a message the form can display.
                throw new IllegalArgumentException("Ticket names and codes must be unique.");
            }
        }
        // An offer with assigned seats may not disappear, even if all bookings were cancelled.
        try(PreparedStatement query=connection.prepareStatement("SELECT DISTINCT sec.category FROM sections sec JOIN seats s ON s.section_id=sec.id WHERE sec.event_id=?")) {
            query.setLong(1,eventId);
            // Close this JDBC resource automatically when the block finishes.
            try(ResultSet row=query.executeQuery()) {
                while(row.next()) {
                    // Validate this condition before continuing with the operation.
                    if(!codes.contains(row.getString(1))) { throw new IllegalArgumentException("Reassign seats before deleting their ticket type."); }
                }
            }
        }
        // Visit each relevant item using an ordinary loop.
        for(TicketType type:types) {
            // Close this JDBC resource automatically when the block finishes.
            try(PreparedStatement save=connection.prepareStatement("INSERT INTO sections(event_id,category,color,ticket_name,ticket_price,early_bird) VALUES(?,?,?,?,?,?) ON DUPLICATE KEY UPDATE color=VALUES(color),ticket_name=VALUES(ticket_name),ticket_price=VALUES(ticket_price),early_bird=VALUES(early_bird)")) {
                save.setLong(1,eventId); save.setString(2,type.getCode()); save.setString(3,type.getColor());
                save.setString(4,type.getName()); save.setBigDecimal(5,type.getPrice()); save.setBoolean(6,type.hasEarlyBird()); save.executeUpdate();
            }
        }
        List<String> removed=new ArrayList<String>();
        // Close this JDBC resource automatically when the block finishes.
        try(PreparedStatement query=connection.prepareStatement("SELECT category FROM sections WHERE event_id=?")) {
            query.setLong(1,eventId);
            // Close this JDBC resource automatically when the block finishes.
            try(ResultSet row=query.executeQuery()) { while(row.next()) { if(!codes.contains(row.getString(1))) { removed.add(row.getString(1)); } } }
        }
        // Visit each relevant item using an ordinary loop.
        for(String code:removed) {
            // Close this JDBC resource automatically when the block finishes.
            try(PreparedStatement delete=connection.prepareStatement("DELETE FROM sections WHERE event_id=? AND category=?")) {
                delete.setLong(1,eventId); delete.setString(2,code); delete.executeUpdate();
            }
        }
    }
}
