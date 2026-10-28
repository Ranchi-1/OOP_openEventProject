<<<<<<< HEAD
# OOP_openEventProject
=======
# OpenEvent quick start

The flexible venue extension is implemented. New events use a section-based editor with custom ticket names, prices and colors. Read `documentation/FlexibleVenue_Guide.md` in the project (or `OpenEvent_FlexibleVenue_Guide.md` beside this guide). Existing grid events remain supported. The grid-specific instructions below describe legacy events.


Project: C:\Users\User\Documents\NetBeansProjects\OpenEvent

## Run the project

Start MySQL in XAMPP. This computer uses port 3307. Open OpenEvent in Apache NetBeans and press F6. Its main class is com.mycompany.openevent.OpenEvent. Java 25 is required.

The executable JAR is target/OpenEvent-1.0-SNAPSHOT.jar. Keep target/lib beside it. From the project directory, it can also be launched with java -jar target/OpenEvent-1.0-SNAPSHOT.jar. Local config.properties contains the database settings; keep it private.

## Demo accounts

| Role | Email | Password |
|---|---|---|
| Customer | alex@openevent.local | OpenEvent2026! |
| Host | host@openevent.local | OpenEvent2026! |

These are fictional classroom accounts. New Customers can register from the login screen. Hosts are preconfigured.

## Customer demonstration

Sign in, search an event title, open an event and select one available seat. Regular seats offer Early Bird pricing before the cutoff. Review checkout and choose Cash, E-wallet or Credit card, plus a simulated success or decline. Success saves a unique ticket and receipt. My tickets shows saved status. Save receipt exports a text receipt. Cancel and refund is allowed only while the ticket is VALID and the event has not started.

All payments and refunds are simulated. No real money, bank connection, card number or wallet PIN is used. Selecting a seat does not hold it before purchase commits; a conflicting purchase is rejected.

## Host demonstration

The dashboard lists only that Host's events. Create or edit an event and choose Concert, Sports or Movie. Dates use yyyy-MM-dd HH:mm. Set the Regular base price and Early Bird cutoff.

The venue editor supports 4–14 rows and 4–18 columns. Stage coordinates start at 1; its width must remain within the grid. Apply grid builds a center aisle. Click cells to cycle Regular, VIP and Aisle; use the color buttons to set section colors. Check Published to show the saved event to Customers. Stage cells cannot be sold. Seat labels use physical row letters and column numbers.

Layouts with VALID or USED tickets are protected from destructive edits. Event details remain editable. Dashboard totals refresh manually. Enter a ticket code to check in once: VALID becomes USED. Wrong-event, USED and CANCELLED tickets are rejected. Select a ticket row to request an eligible simulated refund.

## Pricing

Regular equals the base price. VIP equals 150% of base. Early Bird equals 80% of Regular, applies to Regular seats only, and ends at the saved cutoff. Existing ticket amounts remain saved if the event price changes. Eligible cancellation simulates a full refund.

## Edit in NetBeans Design view

Expand Source Packages, then com.mycompany.openevent.ui. Open a Java form and select Design. All nine forms have matching .form files for Palette and Properties editing.

| Form | Purpose |
|---|---|
| OpenEventUI | Main frame |
| NavigationView | Brand and navigation |
| LoginView | Sign-in |
| DiscoverView | Event search and event-list container |
| EventView | Details and seat-map container |
| CheckoutView | Simulated payment and summary |
| TicketsView | Saved ticket and receipt |
| HostView | Dashboard and check-in |
| EventEditorView | Event details and venue editor |

Cards, seat cells, ticket lists and dashboard rows are populated at runtime from saved data. Their surrounding panels are editable in Design. SeatGrid renders seat cells. Theme handles styling and photos. Behavior is outside generated initComponents sections in OpenEventUI. Keep each Java and form pair together. The original login form is preserved for reference; run OpenEvent for the application.

## OOP design

Encapsulation: private User and Event fields with validated operations. Inheritance: Concert, SportsMatch and MovieScreening extend Event; CashPayment, EWalletPayment and CreditCardPayment extend Payment; Customer and Host extend User. Polymorphism: the UI works through Event and Payment parent types. Abstraction: shared contracts separate the interface, booking rules and persistence. BookingController and BookingSystem coordinate requests, BookingRepository owns SQL and transactions, and SecurityService handles authentication and access checks.

## Database and checks

The openevent database contains hosts, customers, events, venue_layouts, sections, seats, tickets, payments and receipts. The restricted openevent_app login has SELECT, INSERT, UPDATE and DELETE access within this database. Its generated password is only in ignored config.properties. Environment variables OPENEVENT_DB_URL, OPENEVENT_DB_USER and OPENEVENT_DB_PASSWORD can override local settings. Account passwords use salted PBKDF2 hashes.

Table definitions are in database/schema.sql. Purchases, refunds and check-in use transactions. A unique active-seat index also prevents duplicate active seat claims.

The executable integration harness is src/test/java/com/mycompany/openevent/AcceptanceChecks.java. Run it explicitly after compiling, with target/test-classes, target/classes and the runtime libraries on the Java classpath. Maven default test discovery does not automatically execute this plain-Java harness. It creates uniquely named temporary fixtures and removes only those fixtures afterward.

All 27 acceptance checks passed on 26 October 2026: login, disabled accounts, duplicate registration, grid validation, pricing, discovery, ownership, payment decline, SQL-write rollback, purchase, duplicate/concurrent seat claims, layout protection, refunds, wrong-event/cancelled/repeated check-in, USED/late-refund rejection and persistence across connections.

## Assets and scope

Downloaded event photos are in C:\Users\User\Downloads\assest and packaged under src/main/resources/assets. Existing icons are reused. Photos: Unsplash images photo-1492684223066-81342ee5ff30, photo-1470229722913-7c0e2dbbafd3 and photo-1516280440614-37939bbacd81.

Figma was inspected and left unchanged. Real payments, QR/camera scanning, advanced filters, email/SMS, public deployment and large-scale operations remain outside the BSIT-2 scope.


## Beginner and intermediate code revision on 27 October 2026

The implementation now uses ordinary Java classes and getters instead of records, explicit types instead of var, loops instead of streams, normal if/else decisions instead of arrow switches or ternary expressions, and standard listeners instead of lambda expressions and method references. Database.java follows an explicit connector structure with database constants, Class.forName and DriverManager.getConnection. It keeps the existing restricted login and private configuration file. PreparedStatement, transactions and salted password hashes are retained and explained in the comments.

OpenEventUI uses named screen methods and a clearly separated ScreenTask class. ScreenTask extends SwingWorker so database requests do not freeze Swing. Each task has performTask for background work and showResult for drawing-thread updates. The source includes detailed explanations for fields, constructors, methods, statements, queries, conditions, listeners, form properties and cleanup. Imports are explicit. NetBeans-generated comments may be regenerated by the form editor; custom logic remains outside guarded layout sections.

Validation reconfirmed on 27 October 2026: Maven package BUILD SUCCESS; all 27 live database acceptance checks passed after the database repair; all nine NetBeans form definitions remain byte-for-byte unchanged. The 17 database-independent model checks passed during the rewrite. Customer login, event discovery and the colored seat map were also verified in the running application launched from NetBeans. The user repaired mysql.db locally using the targeted repair script and retained a backup of its table files.



## Flexible venue extension verification — 27 October 2026

The project builds successfully with 45 main sources. The original 27 database checks and 42 flexible venue checks pass. The new checks include all three templates, independent physical sections and ticket types, overlap/boundary validation, blocked cells, custom pricing, optional Early Bird, historical ticket snapshots, repricing future purchases, active-layout protection, legacy offer customization, role/ownership checks, refunds, check-in, persistence and Swing initialization.

The live NetBeans UI was checked for Host sign-in, new-event section editing, ticket-type dialog and drag movement. The original nine .form files are preserved. UML extension files: documentation/FlexibleVenue_Class.drawio and documentation/FlexibleVenue_Sequences.drawio. The Word plan has now been updated to include the implemented system and current UML. Shared online diagrams were not uploaded.


## Current UML and password controls

The full local UML files have been revised against the final code: documentation/OpenEvent-Corrected-Classes.drawio (five views) and documentation/OpenEvent-Corrected-Sequences.drawio (six workflows). These supersede the earlier extension-only UML for a complete view. See documentation/UML_Readme.md. The shared online copies have not been uploaded. The updated Word report now embeds the current diagrams.

Sign-in and registration now have eye/eye-slash buttons to show or hide passwords. Fields begin hidden; sign-in submission hides them again. LoginView.java and LoginView.form were updated together so the button remains editable in NetBeans. Other eight form definitions remain unchanged. Thirteen password-display checks passed and the package builds successfully.


## Comprehensive QA revision — 28 October 2026

Latest build: 50 main sources and three plain-Java harnesses. All 112 assertions/configuration checks passed (27 acceptance, 42 flexible venue, 29 usability, 13 password visibility, one configuration override). Final database suites were rerun after MySQL restarted; desktop QA fixture and its booking were removed. See documentation/OpenEvent_QA_Report.md.

Fixed lost editor fields on selection changes, stale checkout selections, narrow-screen forms/cards, status-specific ticket feedback, editor-exit protection, registration correction guidance, price validation and template/removal safeguards. JDBC now honors private config values and the authorized restricted application account was restored. Several Java/form labels were deliberately updated together; all nine form definitions parse.

The revised Word report includes current embedded UML, implemented scope, operating instructions and QA. Primary local draw.io files are current. Shared online copies were not uploaded. Figma was unchanged.


## Shared draw.io update and teacher-reference audit — 28 October 2026

The original shared ClassDiagram_Group6 document now contains the five current implementation views; the six current workflows replaced the old sequenceOop.drawio pages. Original cloud file identities and permissions were retained. Draw.io confirmed All changes saved in Drive. Class document: https://app.diagrams.net/#G1HNE8P2cYPgPPxIXOfF8UX7w_-GRjuhvB . Sequence document: https://app.diagrams.net/#G1NScF9eE1w8fl24jx-g6zuSU2yzboD6pd . Old local originals remain backed up.

Teacher reference audited: D:/School/oop/OOP Lesson 3 class.pdf, pages 6–17. All 112 displayed operation signatures now include parameter names/types. Shared reusable venue values use hollow aggregation diamonds rather than claiming exclusive composite lifetime. Eight solid inheritance links have hollow triangles pointing to superclasses. Relationship counts are explicit source-to-target; dependent operations remain dashed. See OpenEvent_UML_Reference_Audit.md for reasoning.

The synchronized report is Group_6_OpenEvent_UML_Aligned_Documentation.docx. It was exported through native Word and all 30 pages inspected. Copies are in outputs, project/documentation and the original report folder. Primary class/sequence files in those locations are synchronized. The earlier outputs/Group_6_OpenEvent_Revised_Documentation.docx may be an earlier open copy; use the UML_Aligned report for the latest revision. No Java behavior changed in this UML audit; the prior 112 functional/config checks remain valid.

Do not rerun work/uml-password/classes.py or the one-time work/uml-standard/refine.py on completed diagrams. They would reset final routing or duplicate metadata. This task's backup is work/uml-standard/classes-before.drawio.
>>>>>>> 307bba6 (Add OpenEvent project)
