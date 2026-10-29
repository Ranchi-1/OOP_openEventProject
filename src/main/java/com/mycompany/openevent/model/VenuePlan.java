package com.mycompany.openevent.model;
// Import ArrayList for the explicit types used below.

import java.util.ArrayList;
// Import HashSet for the explicit types used below.
import java.util.HashSet;
// Import List for the explicit types used below.
import java.util.List;
// Import Set for the explicit types used below.
import java.util.Set;
// Import BigDecimal for the explicit types used below.
import java.math.BigDecimal;

/**
 * Immutable venue overview with independent physical sections and ticket
 * offers.
 */
public class VenuePlan {

    // Keep stage private so outside classes use the public operations.
    private final Stage stage;
    // Keep areas private so outside classes use the public operations.
    private final List<VenueArea> areas;
    // Keep types private so outside classes use the public operations.
    private final List<TicketType> types;

    public VenuePlan(Stage stage, List<VenueArea> areas, List<TicketType> types) {
        this(stage, areas, types, false);
    }

    // Only the editor may temporarily hold no sections. Saved layouts still need seats.
    public static VenuePlan draft(Stage stage, List<VenueArea> areas, List<TicketType> types) {
        return new VenuePlan(stage, areas, types, true);
    }

    public static VenuePlan empty(BigDecimal price) {
        List<TicketType> types = new ArrayList<TicketType>();
        types.add(new TicketType("GENERAL", "General Admission", price, "#2AA89B", true));
        return draft(new Stage(370, 30, 260, 70), new ArrayList<VenueArea>(), types);
    }

    private VenuePlan(Stage stage, List<VenueArea> areas, List<TicketType> types, boolean draft) {
        // Validate this condition before continuing with the operation.
        if (stage == null || (!draft && areas.isEmpty()) || areas.size() > 12 || types.isEmpty() || types.size() > 20) {
            // Reject invalid input with a message the form can display.
            throw new IllegalArgumentException("Use 1–12 sections and 1–20 ticket types.");
        }
        // Store the validated constructor values in this object.
        this.stage = stage;
        // Store the validated constructor values in this object.
        this.areas = new ArrayList<VenueArea>(areas);
        // Store the validated constructor values in this object.
        this.types = new ArrayList<TicketType>(types);
        Set<String> codes = new HashSet<String>();
        Set<String> names = new HashSet<String>();
        // Visit each relevant item using an ordinary loop.
        for (TicketType type : types) {
            // Validate this condition before continuing with the operation.
            if (!codes.add(type.getCode()) || !names.add(type.getName().toLowerCase(java.util.Locale.ROOT))) {
                // Reject invalid input with a message the form can display.
                throw new IllegalArgumentException("Ticket type names and codes must be unique within the event.");
            }
        }
        codes.clear();
        names.clear();
        Set<String> positions = new HashSet<String>();
        int seats = 0;
        // Visit each relevant item using an ordinary loop.
        for (int i = 0; i < areas.size(); i++) {
            VenueArea area = areas.get(i);
            // Validate this condition before continuing with the operation.
            if (!codes.add(area.getCode()) || !names.add(area.getName().toLowerCase(java.util.Locale.ROOT))) {
                // Reject invalid input with a message the form can display.
                throw new IllegalArgumentException("Section names and codes must be unique.");
            }
            getType(area.getTypeCode());
            // Bounding rectangles are deliberately conservative for trapezoid spacing.
            if (area.getBounds().intersects(stage.getBounds())) {
                // Reject invalid input with a message the form can display.
                throw new IllegalArgumentException(area.getName() + " overlaps the stage.");
            }
            // Visit each relevant item using an ordinary loop.
            for (int j = 0; j < i; j++) {
                // Validate this condition before continuing with the operation.
                if (area.getBounds().intersects(areas.get(j).getBounds())) {
                    // Reject invalid input with a message the form can display.
                    throw new IllegalArgumentException(area.getName() + " overlaps " + areas.get(j).getName() + ".");
                }
            }
            int sectionSeats = 0;
            // Visit each relevant item using an ordinary loop.
            for (int r = 0; r < area.getRows(); r++) {
                // Visit each relevant item using an ordinary loop.
                for (int c = 0; c < area.getColumns(); c++) {
                    String position = (area.getRowOffset() + r) + ":" + c;
                    // Validate this condition before continuing with the operation.
                    if (!positions.add(position)) {
                        throw new IllegalArgumentException("Section seat positions conflict.");
                    }
                    // Validate this condition before continuing with the operation.
                    if (!area.isBlocked(r, c)) {
                        seats++;
                        sectionSeats++;
                    }
                }
            }
            // Validate this condition before continuing with the operation.
            if (sectionSeats == 0) {
                throw new IllegalArgumentException("Keep at least one sellable seat in each section.");
            }
        }
        // Validate this condition before continuing with the operation.
        if ((!areas.isEmpty() && seats == 0) || seats > 1200) {
            throw new IllegalArgumentException("Use 1–1200 assigned seats.");
        }
    }

    // Return the requested value through an accessor.
    public Stage getStage() {
        return stage;
    }

    // Return the requested value through an accessor.
    public List<VenueArea> getAreas() {
        return new ArrayList<VenueArea>(areas);
    }

    // Return the requested value through an accessor.
    public List<TicketType> getTicketTypes() {
        return new ArrayList<TicketType>(types);
    }

    public TicketType getType(String code) {
        // Visit each relevant item using an ordinary loop.
        for (TicketType type : types) {
            // Validate this condition before continuing with the operation.
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        // Reject invalid input with a message the form can display.
        throw new IllegalArgumentException("Assign an existing ticket type to every section.");
    }

    // Generate stable section-prefixed seat labels, with gaps for aisles or blocked cells.
    public List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<Seat>();
        // Visit each relevant item using an ordinary loop.
        for (VenueArea area : areas) {
            TicketType type = getType(area.getTypeCode());
            // Visit each relevant item using an ordinary loop.
            for (int r = 0; r < area.getRows(); r++) {
                // Visit each relevant item using an ordinary loop.
                for (int c = 0; c < area.getColumns(); c++) {
                    // Validate this condition before continuing with the operation.
                    if (!area.isBlocked(r, c)) {
                        String label = area.getCode() + "-" + (char) ('A' + r) + (c + 1);
                        seats.add(new Seat(0, area.getRowOffset() + r, c, label, type, "AVAILABLE", area.getCode()));
                    }
                }
            }
        }
        return seats;
    }

    // Templates use simple editable blocks, not architectural or 3D geometry.
    public static VenuePlan template(String template, BigDecimal price) {
        List<TicketType> types = new ArrayList<TicketType>();
        types.add(new TicketType("GENERAL", "General Admission", price, "#2AA89B", true));
        types.add(new TicketType("PREMIUM", "Front Row", price.multiply(new BigDecimal("1.50")).setScale(2, java.math.RoundingMode.HALF_UP), "#8B5CF6", false));
        List<VenueArea> areas = new ArrayList<VenueArea>();
        Stage stage = new Stage(370, 30, 260, 70);
        // Validate this condition before continuing with the operation.
        if ("U-shaped Arena".equals(template)) {
            stage = new Stage(50, 280, 160, 140);
            int[][] boxes = {{260, 220, 220, 120}, {510, 220, 220, 120}, {260, 370, 220, 120}, {510, 370, 220, 120},
            {230, 40, 250, 120}, {510, 40, 250, 120}, {230, 540, 250, 120}, {510, 540, 250, 120}, {800, 220, 150, 270}};
            // Visit each relevant item using an ordinary loop.
            for (int i = 0; i < boxes.length; i++) {
                String type = "GENERAL";
                if (i < 4) {
                    type = "PREMIUM";
                }
                areas.add(makeArea(i, boxes[i], type, "RECTANGLE"));
            }
        } else if ("Fan Theater".equals(template)) {
            // A wider rear tier and narrower front tier face a stage at the bottom.
            stage = new Stage(370, 590, 260, 80);
            int[][] boxes = {{40, 40, 280, 200}, {360, 40, 280, 200}, {680, 40, 280, 200},
            {140, 310, 220, 190}, {390, 310, 220, 190}, {640, 310, 220, 190}};
            for (int i = 0; i < boxes.length; i++) {
                String type = "GENERAL";
                if (i >= 3) {
                    type = "PREMIUM";
                }
                areas.add(makeArea(i, boxes[i], type, "TRAPEZOID"));
            }
        } else {
            String shape = "RECTANGLE";
            // Validate this condition before continuing with the operation.
            if ("Fan Theater".equals(template)) {
                shape = "TRAPEZOID";
            }
            // Visit each relevant item using an ordinary loop.
            for (int r = 0; r < 2; r++) {
                // Visit each relevant item using an ordinary loop.
                for (int c = 0; c < 3; c++) {
                    int i = r * 3 + c;
                    String type = "GENERAL";
                    if (r == 0) {
                        type = "PREMIUM";
                    }
                    areas.add(makeArea(i, new int[]{70 + c * 300, 150 + r * 240, 260, 190}, type, shape));
                }
            }
        }
        return new VenuePlan(stage, areas, types);
    }

    private static VenueArea makeArea(int i, int[] box, String type, String shape) {
        return new VenueArea("S" + (i + 1), "Section " + (i + 1), type, box[0], box[1], box[2], box[3], 5, 6, i * 10, shape, new HashSet<String>());
    }
}
