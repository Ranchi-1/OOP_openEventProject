# Run OpenEvent on another member's computer

The gradient component now compiles from src/main/java/keeptoo/KGradientPanel.java. It is a small project-owned Swing bean that supports the color properties used by our existing NetBeans forms. No separate KGradientPanel JAR, local Maven installation of that JAR, or Palette installation is needed to run the app. Build the project before opening its existing forms in Design view.

1. Clone or copy the whole project, including pom.xml, src, database, config.example.properties and lib/runtime/mysql-connector-j-8.4.0.jar. Do not copy only the Java files.
2. Install/use JDK 17 or newer. Open the Maven project in NetBeans and choose Clean and Build. Maven may need internet access for its first dependency/plugin download.
3. Start MariaDB in XAMPP. Create a local database named openevent, select it in phpMyAdmin, then import database/schema.sql. Do not import an empty schema over an existing database to reset it.
4. Create a local application login with SELECT, INSERT, UPDATE and DELETE permissions on openevent. Set its own password on that computer. Database setup/import uses an administrative database account; the Java app does not need administrative permissions.
5. Copy config.example.properties to config.properties. Set the local database URL/port, user and password. The port in the sample is 3307; use the port shown by that member's XAMPP installation. config.properties is ignored by Git and must remain private.
6. Run com.mycompany.openevent.OpenEvent with NetBeans F6. Alternatively, run java -jar target/OpenEvent-1.0-SNAPSHOT.jar from the project folder. Keep target/lib beside the JAR; it contains the MySQL JDBC driver.
7. On a fresh database, use Create Host account and Create Customer account. Existing demonstration accounts appear only if the member imported the relevant sample data.

For a database created before independent section colors were added, run database/migration-section-color.sql once. It adds one optional column and keeps existing data. New database/schema.sql already includes this step.

Host layout: a new event starts with a stage and no sections. Click Add section, then click the empty canvas. Drag a section/stage to move it; select it and drag its bottom-right corner to resize. Click a section to rename it, change its color/outline, assign a ticket type, and edit its numbered seats. Click seat positions to make aisles or restore them. Ticket types holds names, prices, colors and Early Bird eligibility. Save the event after editing. Booked layouts keep geometry and assigned seats protected.

Do not commit config.properties, real database exports or account passwords. Keep the source-owned gradient bean and every paired .java/.form file in the repository. Old lib/unknown and KGradientPanel JAR files are no longer application dependencies.
