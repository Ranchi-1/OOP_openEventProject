# OpenEvent functionality UI and UX QA

Completed developer checks on 27–28 October 2026 for the current Windows Java Swing build and local MariaDB database.

## Result

The package builds successfully. All **112 automated assertions and configuration checks passed**. These plain-Java harnesses were run explicitly; Maven package alone does not execute them.

| Suite | Passed | Coverage |
| --- | ---: | --- |
| AcceptanceChecks | 27 | Authentication, access rules, discovery, purchase, rollback, duplicate and concurrent booking, refunds, check-in, persistence |
| FlexibleVenueChecks | 42 | Three templates, geometry, blocked seats, custom offers, snapshots, legacy compatibility, booked-layout protection |
| UsabilityChecks | 29 | Retained editor values, responsive forms/cards, seat-selection clearing, readable labels |
| PasswordVisibilityChecks | 13 | Masking, independent controls, accessible labels, character preservation |
| DatabaseConfigurationCheck | 1 | Configured connection settings are actually honored |

All suites were rerun successfully on 28 October after MySQL restarted. The 27/42 database harnesses clean their fixtures. The separately identified desktop QA event and its booking were removed successfully afterward; no original event or ticket was deleted.

## Problems corrected

- Database.java read private settings but connected using constants. It now uses the configured URL, user and password. The previously authorized restricted account, missing following the earlier system-table repair, was restored with only SELECT, INSERT, UPDATE and DELETE in openevent.
- Changing section or ticket-type selection could lose field edits. Valid changes are now retained before switching; invalid input keeps the selection and explains the problem.
- Opening another section or the venue overview could leave a stale seat ready for checkout. Navigation now clears it and disables checkout until a new seat is chosen.
- Fixed-width forms and cards were difficult to use on smaller screens. Original editable forms now sit in adaptive wrappers; cards change columns, and the initial frame fits the working desktop area. Repeated resizing does not progressively shrink controls.
- Ticket feedback could describe a cancelled ticket as ready. Banners, list labels, payment descriptions and empty states now reflect the actual ticket state.
- Leaving an event editor could silently discard work. Navigation, logout and closing now warn and default to keeping edits.
- Registration retains fields after local validation errors. Empty sign-in shows direct guidance. Passwords start hidden and hide again on submission.
- Improved screen headings, focus cues, text contrast, field associations, date/price tooltips, selected-seat text, ticket-type color/name/price legends and refund eligibility feedback.
- Booked layouts disable template replacement. Replacing a draft template explains that offers also change; section removal asks for confirmation. New custom type names remain unique.
- Added price precision/range checks and case-insensitive checks for reserved offer names. Custom names preserve underscores and are escaped when shown as HTML.

## Live desktop checks

Customer sign-in; empty sign-in guidance; title search; venue overview; section and seat selection; correct custom price at checkout; simulated purchase; saved ticket/receipt; eligible cancellation; disabled repeat refund; actual receipt export through the file chooser; logout; Host sign-in/dashboard; event editor; keep-editing and leave-without-saving navigation. Receipt contents matched the selected event, ticket, amount and simulated-refund status.

Automated checks cover successful and declined payments, transactional write failures, competing bookings, role/ownership violations, one-time check-in and snapshot preservation. The desktop tests use demonstration accounts and simulated payments.

## Documentation and UML

The revised Word documentation describes the implemented scope, limitations, OOP mapping, database, operating steps and QA. Its appendices contain current UML exports for five class views and six workflows, split into readable continuation sheets. Editable primary draw.io copies are in project documentation and this chat outputs. Shared online draw.io copies were not uploaded. Figma was unchanged. Original institutional/member placeholders were preserved.

## Practical limits

This is classroom prototype QA on the available Windows workstation, not a formal user study, a multi-platform certification or production load test. Payments/refunds are simulated. Advanced filters, live seat broadcasting, real payment processing, cloud deployment, standing-capacity sales, arbitrary geometry and 3D remain outside scope. The nine NetBeans Java/form pairs remain editable; several labels and password controls were deliberately updated together.

Evidence logs are saved beside this report: OpenEvent_Final_QA_Build.txt, OpenEvent_Functional_QA.txt, OpenEvent_Venue_QA.txt, OpenEvent_Usability_QA.txt, OpenEvent_Password_Visibility_QA.txt and OpenEvent_Configuration_QA.txt.

Final delivery verification on 28 October: all 30 rendered Word pages inspected; operating-guide spillover corrected. Verified report copied into project documentation and the original documentation output folder. Latest compiled application launched with NetBeans F6 and sign-in screen inspected. MySQL was restarted by the user; all 112 checks passed again. Desktop fixture cleanup succeeded. App left at sign-in.
