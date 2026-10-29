# Venue layout and custom tickets

Current workflow, 29 October 2026. This replaces the earlier template and inspector instructions.

## Host workflow

1. Create an event and enter its details. A new venue contains a stage and no sections.
2. Click Add section, then click an empty part of the canvas. Repeat as needed.
3. Drag a section or stage to move it. Select it and drag the bottom-right corner to resize. Invalid overlaps keep the prior valid position.
4. Click a section to open its simple seat grid. Set its name, color, rectangle/trapezoid outline, rows, seats per row and ticket type. Choose Update grid. Click seat positions to make aisles or restore seats.
5. Choose Save section to retain the section edits. Remove section removes an unneeded area while unbooked; Cancel leaves its changes.
6. Open Ticket types to create or rename offers and set prices, colors and optional Early Bird eligibility. Several sections can share one offer. A physical section can have a different overview color from its offer.
7. Save the event, then publish when ready. The venue needs at least one valid section with seats before saving. A stage-only layout is an in-memory editing draft.

Existing legacy events retain the simple grid editor. New flexible venues use VenueLayoutEditor; section details use SimpleGridEditor. The old VenueDesigner class and template helper remain in the source for compatibility but are not the default new-event workflow.

## Customer workflow

Open a published upcoming event. Click a physical section in its overview, choose an available numbered seat and use Back to overview for another section. Checkout uses the seat's assigned offer and any eligible Early Bird option. Cash, E-wallet and Card payments are simulations. Tickets and text receipts are saved; eligible unused tickets can be cancelled before the event. Only the owning Host can check a valid paid ticket in once.

## Limits and safeguards

- Logical canvas: 1000 by 700, scaled to its panel.
- Saved venues: 1–12 physical sections, 1–10 rows and columns per section, 1–20 ticket types. Empty drafts are allowed only while editing.
- Rectangles and trapezoids; a rectangular stage. Bounding-box overlap checks, no free rotation, 3D, architectural or safety calculations.
- Assigned seats only; blocked positions are omitted from sales. Each section retains at least one seat.
- VALID or USED tickets protect geometry, seat numbering and section assignments. Future offers can be updated through the guarded offer workflow.
- Purchased names and amounts remain historical snapshots when future offers change.
- No real payment gateway or automatic live availability broadcast; refresh to see other activity.

## Data and setup

VenuePlan describes stage, areas and ticket types. VenueLayout also supports legacy grids. VenueArea represents a physical section, while the sections table stores offer metadata. VenuePlanRepository saves geometry using the booking transaction connection. Independent overview color is optional venue_areas.area_color.

For a new installation import schema.sql. Existing installations use the relevant additive migrations, including migration-section-color.sql; do not reset existing data. See TEAM_SETUP.md for JDK 17+, complete-source builds, the source-owned KGradientPanel and private database configuration.

## Verification and diagrams

See OpenEvent_Layout_Host_Portability_QA.md for the 141-check baseline, six final mouse-gesture checks and clean compilation without an external gradient JAR. The final canvas fix makes mouse listeners use the latest plan after adding sections.

Group6_OpenEvent_Submission.docx contains report-specific class, sequence and database diagrams for this version. Restored/shared draw.io documents were deliberately left unchanged after the user's revert. Older standalone diagrams may describe the earlier editor; do not assume they were synchronized by this task.
