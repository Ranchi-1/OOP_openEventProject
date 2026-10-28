# OpenEvent UML reference audit

Reference: Carlo A. Castro, OOP Lesson 3 class.pdf, D:/School/oop. Checked pages 6–17 for class compartments, visibility, operation signatures, inheritance, association, multiplicity, aggregation and composition. The sequence companion is Lesson 3-Cont2 sequnce.pdf.

## Corrections

- All 112 displayed operation signatures now include actual parameter names and types, using visibility name(parameter : Type) : ReturnType. Long signatures wrap within their class compartments.
- Inheritance uses solid lines and hollow triangles pointing to User, Event or Payment. Abstract classes/operations are italic; concrete shared Event.calculatePrice remains concrete. Static operations are underlined.
- Reusable value objects in VenueLayout and VenuePlan use hollow diamonds for shared aggregation. The code copies lists while sharing independently created value objects; it does not guarantee exclusive composite ownership or automatic destruction. Do not infer composition solely from a has-a field or database foreign key.
- Section-to-Seat is a grouping association. VenueArea refers to an assigned type by stable code; several areas share a type. Seat references an optional offer for legacy compatibility.
- Relationship counts explicitly read source to target. VenuePlan has one Stage, 1–12 VenueArea objects and 1–20 TicketType definitions. VenueLayout has an optional plan. Generating seats is a dashed dependency.
- Services retained as fields use associations. Temporary calls and generated results use dashed dependencies. Unimplemented enums, reserve methods and delegated Host permission claims from the older online design are excluded from the current views.

Source member verification, XML bounds, line routing and text fit passed for five class views and six sequence workflows. Primary local files are in outputs and project/documentation. Backup before this audit: work/uml-standard/classes-before.drawio.
