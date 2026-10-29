# OpenEvent current QA checkpoint

29 October 2026. The simple Host venue editor, Host registration and portable gradient component are implemented locally.

- Build: Maven package succeeds after the final canvas fix.
- Dependency check: all main sources compile for Java 17 using only MySQL Connector/J, without an external KGradientPanel JAR.
- Functional baseline: 141 checks passed (27 booking, 42 flexible venue, 29 simple grid, 29 usability, 14 overview/portability).
- Final regression: six actual offscreen mouse-event checks pass for section placement, section dragging, section corner resizing, stage dragging, stage corner resizing and Customer read-only selection.
- The mouse test found and fixed a stale initial-plan reference in VenueCanvas. Mouse callbacks now read the current plan after edits.
- Test data from the integration baseline was cleaned. The final mouse tests use no database and save no event.

147 passed assertions in the combined QA evidence. The database suites preceded the narrow final canvas fix; the six gesture regressions and clean build ran afterward. This is developer QA on the available Windows environment, not a formal usability study or certification on other computers.

Use TEAM_SETUP.md for member installation and the current Word submission report for the complete operating guide. Old complex-template guide descriptions are superseded by the empty venue overview: Add section, click canvas, drag objects and open a section for simple seat editing. Restored/shared draw.io files were left untouched.
