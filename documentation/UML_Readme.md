# Current OpenEvent UML diagrams

Updated against the implemented Java code on 28 October 2026.

## Primary files

- OpenEvent-Corrected-Classes.drawio: five views — accounts/payments; event hierarchy/legacy seating; flexible venue/custom offers; services/JDBC; Swing editors/password visibility.
- OpenEvent-Corrected-Sequences.drawio: six workflows — authentication; event setup; purchase; refund; check-in; monitoring.

Open these files in draw.io. They replace the older local files with the same names. Copies are in this project documentation folder, the current chat outputs folder, and the original documentation output folder from 25 October. Original pre-edit files are backed up under the current chat's work/uml-password folder.

These primary diagrams supersede the earlier FlexibleVenue_Class.drawio and FlexibleVenue_Sequences.drawio addendum files for a complete implementation view. Class field and method declarations were checked directly against Java sources. Relationships are routed around class boxes; XML bounds and text fitting were checked and raster layout previews were reviewed. Sequence messages follow actual UI/service/repository calls, with guarded success and failure alternatives and JDBC transaction boundaries.

The revised Word documentation now embeds current figures for all five class views and six workflows. Long figures use continuation sheets with repeated sequence participant headers. The 30-page report was exported through Word and visually checked. Shared online draw.io documents were not uploaded; import the primary editable files there when preparing your shared submission.

## Password visibility

LoginView now has a NetBeans-editable JToggleButton next to its password field. PasswordEyeIcon draws an eye and eye-slash; PasswordVisibility changes only the field's echo character and updates its tooltip/accessibility name. Sign-in and registration start hidden, use independent controls, and preserve entered characters when toggled. Sign-in submission hides the field again. Alt+V also toggles the focused form's control.

Build: SUCCESS, 50 main sources. Comprehensive QA passed 112 assertions/configuration checks: 27 acceptance, 42 venue, 29 usability, 13 password visibility and one configuration override. All were rerun on 28 October. See OpenEvent_QA_Report.md.


## Shared draw.io update and teacher-reference audit — 28 October 2026

The original shared ClassDiagram_Group6 document now contains the five current implementation views; the six current workflows replaced the old sequenceOop.drawio pages. Original cloud file identities and permissions were retained. Draw.io confirmed All changes saved in Drive. Class document: https://app.diagrams.net/#G1HNE8P2cYPgPPxIXOfF8UX7w_-GRjuhvB . Sequence document: https://app.diagrams.net/#G1NScF9eE1w8fl24jx-g6zuSU2yzboD6pd . Old local originals remain backed up.

Teacher reference audited: D:/School/oop/OOP Lesson 3 class.pdf, pages 6–17. All 112 displayed operation signatures now include parameter names/types. Shared reusable venue values use hollow aggregation diamonds rather than claiming exclusive composite lifetime. Eight solid inheritance links have hollow triangles pointing to superclasses. Relationship counts are explicit source-to-target; dependent operations remain dashed. See OpenEvent_UML_Reference_Audit.md for reasoning.

The synchronized report is Group_6_OpenEvent_UML_Aligned_Documentation.docx. It was exported through native Word and all 30 pages inspected. Copies are in outputs, project/documentation and the original report folder. Primary class/sequence files in those locations are synchronized. The earlier outputs/Group_6_OpenEvent_Revised_Documentation.docx may be an earlier open copy; use the UML_Aligned report for the latest revision. No Java behavior changed in this UML audit; the prior 112 functional/config checks remain valid.


