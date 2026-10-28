# OpenEvent

OpenEvent is a Java desktop event booking application built with Swing and
MySQL. It supports customer event discovery and booking, host event
management, venue layouts, ticket types, payments, receipts, refunds, and
check-in.

## Features

- Customer registration, sign-in, event discovery, seat selection, and tickets
- Host event creation, editing, publishing, and ticket check-in
- Concert, sports match, and movie screening event types
- Grid and section-based venue layouts
- Regular, VIP, and Early Bird pricing
- Simulated cash, e-wallet, and credit-card payments
- Transactional booking, cancellation, refund, and persistence workflows
- NetBeans GUI forms and editable Swing views

## Requirements

- Java 25 or a compatible JDK
- Maven
- MySQL
- Apache NetBeans is recommended for editing the GUI forms

## Configuration

1. Create a local `config.properties` file based on
   `config.example.properties`.
2. Set the database URL, username, and password for your own MySQL instance.
3. Keep `config.properties` private. It is ignored by Git and must not be
   committed.
4. Apply `database/schema.sql` to an empty database before running the
   application.

The database username, password, host, port, and other environment-specific
values are intentionally not documented here.

## Build and run

```text
mvn clean package
```

Run the application from NetBeans using the main class
`com.mycompany.openevent.OpenEvent`, or launch the packaged JAR produced in
the `target` directory.

## Tests

The project includes plain-Java checks under `src/test`. Build the project
first, then run the checks using the classpath and database configuration
appropriate for your local environment. Some checks require a running MySQL
instance and create temporary test data.

## Project layout

```text
database/       Database schema and migrations
documentation/  UML diagrams and project documentation
src/main/java/  Application source code
src/main/resources/ Application assets
src/test/       Verification checks
lib/            Runtime libraries
```



Never commit passwords, database credentials, tokens, private URLs, local
machine paths, or generated build output. Use environment variables or the
ignored local configuration file for secrets.
