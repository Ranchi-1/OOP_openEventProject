# Flexible venues and custom ticket types

Implemented 27 October 2026 as an extension to the original OpenEvent plan.

## Host workflow

1. Sign in as Host and choose Create event. New events open the section editor.
2. Set the event details, date and Early Bird cutoff. Template starting price is used only when generating a template; actual prices are edited in Ticket types.
3. Choose Rectangular Hall, U-shaped Arena or Fan Theater and press Use template. This replaces the unsaved arrangement after confirmation.
4. Select a section in the list or on the map. Rename it, choose its ticket type and shape, adjust X/Y/width/height, and set seat rows/columns. Press Apply section before selecting another section. Dragging a block moves it; invalid moves are rejected.
5. Choose Aisles / blocked seats to toggle unavailable cells. Gray cells are omitted from sales. Each section must retain at least one seat.
6. Choose Ticket types. Add, rename, price and color offers; enable the optional 20% Early Bird discount. Apply edits before selecting another type. Assign new types to physical sections using the inspector.
7. Save as a draft or publish the event. The event, offers, overview and seats are saved in one transaction.

Existing grid events stay usable. Their editor provides Ticket types for renaming/pricing existing offers. Use section editor explicitly replaces an unbooked legacy grid with a template; it is disabled when active tickets exist. Old purchased ticket names, amounts, seat labels and codes remain saved.

## Customer workflow

Open an event, click a colored physical section, then select an available seat in that section. The overview button returns to the map. A selected seat's saved offer determines the price; customers cannot choose a cheaper unrelated offer. Eligible offers also show a named Early Bird option before the event cutoff. Checkout, receipt, cancellation and check-in follow the existing workflows.

## Limits and safeguards

- One 2D overview per event, using a logical 1000 × 700 canvas that scales uniformly to fit its panel.
- 1–12 physical sections, each with 1–10 rows and 1–10 columns: at most 1200 assigned seats.
- 1–20 ticket types. Names are unique per event, 1–50 characters; prices are positive with up to two decimal places.
- Rectangular or trapezoid section shapes; rectangular stage. Position/size fields and drag movement are supported; arbitrary rotation, freehand polygons, 3D and architectural capacity calculations are excluded.
- Conservative bounding-box overlap checks keep both rectangles and trapezoids separated. Section/stage boundaries must stay inside the venue.
- Gaps between sections and blocked seat cells represent aisles. This is a classroom visual arrangement, not a safety plan.
- Once VALID or USED tickets exist, geometry, seat numbering, section assignments and template replacement are locked. Offer names, colors, Early Bird eligibility and future prices remain editable.
- Tickets store the name and amount at purchase. Renaming or repricing an offer affects future sales, including future sales of a refunded seat, without rewriting historical tickets or receipts.
- A type used by a section or seat cannot be removed until reassigned in an unbooked layout. Unused types may be removed.
- Assigned seats only. Standing-area capacity sales, multi-level architecture, live broadcasting and real payments remain excluded.

## Java design

`VenueLayout` supports the original grid and an optional `VenuePlan`. `VenuePlan` owns one `Stage`, physical `VenueArea` objects and event-specific `TicketType` definitions. Each area references one type by a stable code; generated seats carry both area and type identity. Several physical areas can share a type. The original `Section` class groups seats by stable offer code for compatibility with existing persistence.

`VenueDesigner` is the Host editor; `VenueCanvas` renders scaled geometry and handles hit-testing; `TicketTypePanel` edits offers; `VenueBrowser` opens a section's `SeatGrid`. These runtime components are embedded in the original NetBeans GUI Builder panels. All original form panels are retained; LoginView.form now also contains a password visibility button. The other eight .form files remain unchanged.

`BookingRepository` keeps role, ownership and transaction rules. `VenuePlanRepository` reads/writes the overview and type metadata using the caller's connection. `Event.calculatePrice` uses an assigned custom offer or falls back to the legacy Regular/VIP rules. Names and price snapshots are saved in `tickets.category` and `tickets.amount`.

## Database migration

`database/migration-flexible-venue.sql` has been applied to the existing local database. It widens ticket/category labels, adds optional ticket metadata to `sections`, adds `seats.area_code`, and creates `venue_plans` and `venue_areas`. Existing event, account, seat and ticket records are preserved. The same additive SQL is included in `database/schema.sql` for fresh installations. Apply migrations with an account allowed to change table definitions; daily application use does not require those permissions.

## Verification

The original 27 integration checks and the new `FlexibleVenueChecks` harness are run explicitly after Maven compilation; Maven's default discovery does not execute these main-method harnesses. New checks cover all templates, saved geometry and seats, blocked cells, custom pricing, eligible discounts, type substitution rejection, historical ticket snapshots, price changes for future purchases, structural booking locks, role/ownership checks, refunds, check-in, persistence and Swing component initialization. Test fixtures are removed in finally blocks.

## UML addendum

Open `FlexibleVenue_Class.drawio` and `FlexibleVenue_Sequences.drawio` in draw.io. They document the added model and main workflows. They supplement the original three class views and six sequences; the earlier Word document and shared online diagrams have not been overwritten.


The complete UML has since been revised in OpenEvent-Corrected-Classes.drawio and OpenEvent-Corrected-Sequences.drawio. Use those primary files for the full implementation; the extension diagrams above remain supplementary.
