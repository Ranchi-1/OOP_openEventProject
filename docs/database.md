# Database setup

## 1. Overview

OpenEvent uses MariaDB through MySQL Connector/J 8.4.0.
The supplied schema was verified on MariaDB **10.4.32**, with the local server on port **3307**.
The default database name is `openevent`; [schema.sql](../database/schema.sql) creates or upgrades 11 InnoDB tables in the selected database.
Schema import is manual. It neither creates the database nor inserts demo data.

## 2. Requirements

- MariaDB: 10.4.32 is verified. **TODO: establish the minimum and supported server versions.** The repository does not pin them. Its `ADD COLUMN IF NOT EXISTS` syntax is MariaDB-specific; do not assume an Oracle MySQL server accepts the script unchanged.
- XAMPP Control Panel and phpMyAdmin are the tools used in [TEAM_SETUP.md](../TEAM_SETUP.md). Apache is needed for phpMyAdmin, but not for a direct Java/JDBC connection.
- A database administrator for schema import and user creation; a restricted account for normal app use.
- The XAMPP `mysql.exe` client and `mysqldump.exe` backup tool, if using commands. The installed versions here both report MariaDB 10.4.32. A separate desktop database GUI and Docker are not part of the repository setup.
- JDK 17+ and Maven to build/run the application or optional Java demo loader, as declared in [pom.xml](../pom.xml). Connector/J is version 8.4.0.

Run project commands from the repository root. Windows examples assume the standard XAMPP folder `C:\xampp`; adjust it if installed elsewhere. macOS/Linux examples assume the corresponding `mysql` and `mysqldump` client binaries are on your command path.

## 3. Start the database server

1. Open XAMPP Control Panel.
2. Click **Start** beside **MySQL**. XAMPP uses that label for its bundled MariaDB server. Confirm that the row shows running, with a PID and port.
3. For phpMyAdmin, also click **Start** beside **Apache**, then **Admin** beside **MySQL**. This opens the local phpMyAdmin page.
4. Confirm the actual database port. The project example uses **3307**, not 3306. If your server uses another port, change the commands and app configuration together.
5. Check the server directly. In Windows PowerShell:

   ```powershell
   $xamppRoot = 'C:\xampp'
   & "$xamppRoot\mysql\bin\mysql.exe" --no-defaults --host=127.0.0.1 --port=3307 --user=root --password --execute="SELECT VERSION(), @@port;"
   ```

   On macOS/Linux with the client installed:

   ```sh
   mysql --no-defaults --host=127.0.0.1 --port=3307 --user=root --password --execute="SELECT VERSION(), @@port;"
   ```

`--password` prompts without putting a password in command history. Enter your administrator password; press Enter only if your local development account really has an empty password. The committed Java fallback is `root` with an empty password, for local development only. It is not the recommended application account.

Expected on the verified environment: `10.4.32-MariaDB` and `3307`. A different version is not automatically incompatible, but has not been verified by this guide. No portable service-start command is defined for macOS/Linux in this Windows-focused repository.

## 4. Create the database and load the data

### Method A: phpMyAdmin GUI/web import — main method

1. In phpMyAdmin, choose **Databases** (or **New** in the sidebar). Enter `openevent`, choose `utf8mb4_general_ci`, and click **Create**. If `openevent` already contains data, use the existing-database instructions below instead.
2. Select **openevent** in the sidebar.
3. Open **Import** → **Choose File**, select [database/schema.sql](../database/schema.sql) from the project, leave the format as **SQL**, and click **Import** or **Go**, depending on the phpMyAdmin version.
4. Confirm a successful import and 11 tables. No records are expected yet.
5. Open the database **SQL** tab and run the account statements below after replacing the password placeholder.

### Method B: command line

1. From the project root, open the client. Windows PowerShell:

   ```powershell
   $xamppRoot = 'C:\xampp'
   & "$xamppRoot\mysql\bin\mysql.exe" --no-defaults --host=127.0.0.1 --port=3307 --user=root --password --default-character-set=utf8mb4
   ```

   macOS/Linux:

   ```sh
   mysql --no-defaults --host=127.0.0.1 --port=3307 --user=root --password --default-character-set=utf8mb4
   ```

2. At the SQL prompt, create/select the new database and import the real script:

   ```sql
   CREATE DATABASE openevent CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
   USE openevent;
   SOURCE database/schema.sql;
   ```

   `SOURCE` is a client command; it is not SQL for phpMyAdmin’s SQL tab. Use forward slashes in file paths, including on Windows. If the client was opened elsewhere, use the actual full path to the script with forward slashes.

### Create the application account

Run this in an administrative SQL session or phpMyAdmin SQL tab. `REPLACE_WITH_LOCAL_PASSWORD` is a placeholder; choose your own value.

```sql
CREATE USER 'openevent_app'@'localhost' IDENTIFIED BY 'REPLACE_WITH_LOCAL_PASSWORD';
GRANT SELECT, INSERT, UPDATE, DELETE ON openevent.* TO 'openevent_app'@'localhost';
```

If that user already exists, inspect/reuse the intended local account rather than rerunning `CREATE USER` blindly. Schema changes and imports use the administrator account; the app needs only the four listed data permissions.

### Existing databases and re-running scripts

- `schema.sql` contains no `DROP DATABASE`, `DROP TABLE`, `TRUNCATE`, or data-deletion statements. It does not drop/recreate the database and does not reset records.
- A second import succeeded on the scratch database. `CREATE TABLE IF NOT EXISTS` and `ADD COLUMN IF NOT EXISTS` skip existing objects. The `MODIFY` statements still execute; import can lock tables and is not a general schema-repair tool.
- For a pre-flexible-venue database, import [migration-flexible-venue.sql](../database/migration-flexible-venue.sql), then [migration-section-color.sql](../database/migration-section-color.sql). If flexible venue storage already exists and only its independent color is missing, apply only the color migration.
- A new full schema already includes both changes. No Flyway/Liquibase runner, migration version table, ORM auto-creation, or startup schema import is implemented. `CREATE TABLE IF NOT EXISTS` does not reconcile arbitrary incompatible existing columns.
- Take a backup first when upgrading saved data. Importing DDL is not an all-or-nothing application transaction.

The import creates structure only. To add the optional demonstration records, follow section 8.

## 5. Connect the application

1. Copy [config.example.properties](../config.example.properties) to `config.properties` at the project root.

   Windows PowerShell:

   ```powershell
   Copy-Item config.example.properties config.properties
   ```

   macOS/Linux:

   ```sh
   cp config.example.properties config.properties
   ```

2. Edit the copied file:

   ```properties
   db.url=jdbc:mysql://127.0.0.1:3307/openevent
   db.user=openevent_app
   db.password=REPLACE_WITH_LOCAL_PASSWORD
   ```

3. Make the host, port, database name, account, and password match the server you actually created. For another database, replace the final `/openevent` URL segment and grant that account access to the new database.
4. Build/run from the project root:

   ```sh
   mvn clean package
   java -jar target/OpenEvent-1.0-SNAPSHOT.jar
   ```

   Keep `target/lib/` beside the JAR. It contains the packaged Connector/J driver.

### Settings and precedence

[`Database.java`](../src/main/java/com/mycompany/openevent/service/Database.java) reads environment variables first, then properties, then source fallbacks. Empty environment values still override properties. An existing unreadable properties file causes `Cannot read database settings.`; a missing file allows fallback settings.

| Setting | Committed example/default | Meaning |
| --- | --- | --- |
| `db.url` / `OPENEVENT_DB_URL` | Example: `jdbc:mysql://127.0.0.1:3307/openevent` | Host, port, and database. |
| Source URL fallback | `jdbc:mysql://localhost:3307/openevent?connectTimeout=4000&socketTimeout=10000&useSSL=false&allowPublicKeyRetrieval=true` | Used only if no URL override/property exists; local development settings. |
| `db.user` / `OPENEVENT_DB_USER` | Example: `openevent_app`; fallback: `root` | Database login, separate from a Host/Customer account. |
| `db.password` / `OPENEVENT_DB_PASSWORD` | Example: `YOUR_LOCAL_DATABASE_PASSWORD`; fallback: empty | Replace the example placeholder with your local password. The empty root fallback is local-only. |
| JVM property `openevent.config` | `config.properties`, relative to the working directory | Choose another properties file without changing code. |

For example, `java "-Dopenevent.config=config.test.properties" -jar target/OpenEvent-1.0-SNAPSHOT.jar` reads a user-created alternate file. [.gitignore](../.gitignore) excludes `config.properties` and `config.*.properties`, while keeping `config.example.properties` as the safe template. Do not commit credentials in files with other names.

### Timezone

There is no application timezone property in the example file and no timezone parameter in the source JDBC URL. Events use `DATETIME`; ticket issue time uses `DATETIME DEFAULT CURRENT_TIMESTAMP`. The app reads/writes timestamps and compares them with `LocalDateTime.now()` in [BookingRepository](../src/main/java/com/mycompany/openevent/service/BookingRepository.java), so it does not store an event timezone identifier.

Check the server with `SELECT @@global.time_zone, @@session.time_zone, NOW();`. The verified server returned `SYSTEM` for both timezone settings. That means the server uses its system timezone; it does not establish a project-wide timezone policy.

To change the Java process timezone for a local run, use the standard JVM option, for example `java "-Duser.timezone=Asia/Manila" -jar target/OpenEvent-1.0-SNAPSHOT.jar`. This does not change MariaDB’s timezone or convert existing event dates. Use a matching server/system timezone for local testing. **TODO: agree and validate a shared timezone policy before running clients across timezones.** There is no committed MariaDB server configuration or timezone migration to apply.

## 6. Verify it worked

Select the target database first with `USE openevent;`. Run these five checks. Expected demo results assume a fresh schema followed by exactly one successful demo load; existing personal data changes counts.

1. Confirm the selected database, server version, port, and timezone:

   ```sql
   SELECT DATABASE(), VERSION(), @@port, @@session.time_zone;
   ```

   Expected: `openevent`, your MariaDB version, the configured port (3307 here), and the server session timezone (`SYSTEM` here).

2. List tables:

   ```sql
   SHOW TABLES;
   ```

   Expected 11: `customers`, `events`, `hosts`, `payments`, `receipts`, `seats`, `sections`, `tickets`, `venue_areas`, `venue_layouts`, `venue_plans`. No views are defined.

3. Count core records:

   ```sql
   SELECT (SELECT COUNT(*) FROM hosts) AS hosts,
          (SELECT COUNT(*) FROM customers) AS customers,
          (SELECT COUNT(*) FROM events) AS events,
          (SELECT COUNT(*) FROM seats) AS seats,
          (SELECT COUNT(*) FROM tickets) AS tickets;
   ```

   Expected after schema import only: `0, 0, 0, 0, 0`. After demo loading: `1, 1, 3, 180, 0`.

4. Look up demo logins without exposing stored password hashes:

   ```sql
   SELECT 'Host' AS role, email, enabled
   FROM hosts WHERE email = 'host@openevent.local'
   UNION ALL
   SELECT 'Customer', email, enabled
   FROM customers WHERE email = 'alex@openevent.local';
   ```

   Expected before demo loading: no rows. After demo loading: both addresses, each with `enabled=1`. This confirms records exist, not that a password was authenticated.

5. Check demo events and assigned seats:

   ```sql
   SELECT e.title, e.base_price, e.published, COUNT(s.id) AS seat_count
   FROM events e LEFT JOIN seats s ON s.event_id = e.id
   GROUP BY e.id, e.title, e.base_price, e.published
   ORDER BY e.id;
   ```

   Expected on the empty schema: no rows. After demo loading: Between the Islands / 850.00, After Hours, Escolta / 500.00, Soft Sounds Sunday / 400.00; each has `published=1` and 60 seats.

Validation on 29 October 2026 used isolated scratch databases on MariaDB 10.4.32: import and re-import passed, empty/demo counts matched, a second demo run kept three events, and a dump/restore retained one Host, three events, and 180 seats. Scratch databases were removed. The existing `openevent` records were not modified. GUI clicks, new-account provisioning, and other operating systems were not tested.

## 7. Schema overview

This describes the final schema after the ALTER statements, not just the initial CREATE definitions.

| Table | Purpose | Key columns or relationships |
| --- | --- | --- |
| `hosts` | Host accounts | Auto-increment `id`; unique `email`; `password_hash`; `enabled`. |
| `customers` | Customer accounts | Auto-increment `id`; unique `email`; `password_hash`; `enabled`. |
| `events` | Event details and publication | `host_id` → `hosts.id`; `type`, `starts_at`, `early_bird_until`, `base_price`, `published`. |
| `venue_layouts` | Legacy grid geometry | Unique `event_id` → `events.id`; rows/columns and legacy stage coordinates. |
| `sections` | Legacy categories and custom ticket offers | `event_id` → `events.id`; unique `(event_id,category)`; final `category VARCHAR(40)`, `ticket_name`, `ticket_price`, `early_bird`, `color`. |
| `seats` | Assigned seat inventory | `event_id` → `events.id`; `section_id` → `sections.id`; unique `(event_id,row_no,col_no)`; final `label VARCHAR(64)`; optional `area_code`; status. |
| `tickets` | Issued/historical tickets | References event, customer, and nullable seat; unique `code`; final `category VARCHAR(80)` and `seat_label VARCHAR(64)`; status and calculated `active_seat`. |
| `payments` | Simulated payment/refund records | Unique `ticket_id` → `tickets.id`; unique `reference`; method, amount, status. |
| `receipts` | Receipt identifiers | Unique `ticket_id` → `tickets.id`; unique `payment_id` → `payments.id`; unique `number`. |
| `venue_plans` | Flexible overview stage | `event_id` is primary key and FK to `events.id`; stage position/size. |
| `venue_areas` | Physical sections and seat-generation geometry | Composite PK `(event_id,code)`; `event_id` → `events.id`; `type_code`, dimensions, `seat_rows`, `seat_columns`, `shape`, `blocked_cells`, nullable `area_color`. |

Important database rules:

- All tables use InnoDB. Required fields use `NOT NULL`; selected statuses/types use `ENUM`.
- `tickets.active_seat` is stored/generated from `seat_id` while status is `VALID` or `USED`, otherwise NULL. Its unique index prevents two active tickets for one seat while permitting cancelled ticket history.
- Deleting a referenced seat sets `tickets.seat_id` to NULL (`ON DELETE SET NULL`). Other foreign keys have no explicit delete cascade; there is no general `ON DELETE CASCADE`.
- There are no explicit SQL `CHECK` constraints, triggers, stored procedures, or views in the scripts. Positive amounts, venue bounds, overlaps, ownership, and same-event consistency also depend on Java validation/transactions.
- `venue_areas.type_code` and `seats.area_code` are logical links in the Java code, not declared foreign keys. `sections` stores ticket offers; it is not the physical-section table for flexible venues.
- Host and Customer emails are unique within their separate tables. The same address may exist in both roles.

See [schema.sql](../database/schema.sql) for exact types and constraints, and Appendix C of the [submission report](../documentation/Group6_OpenEvent_Submission.docx) for database relationships. The [venue guide](../documentation/FlexibleVenue_Guide.md) warns that older standalone `.drawio` files were not synchronized after the editor revision; use the report and current SQL as the reference.

## 8. Sample data

There are no `INSERT` statements or seed accounts in the SQL scripts. A new schema starts empty. Create accounts in the login UI, or explicitly run [DemoData.java](../src/main/java/com/mycompany/openevent/service/DemoData.java) for a local demonstration.

1. Configure the intended local database and build with `mvn clean package`.
2. Run the optional loader from the project root. Windows PowerShell:

   ```powershell
   java -cp "target/classes;target/lib/*" com.mycompany.openevent.service.DemoData
   ```

   macOS/Linux:

   ```sh
   java -cp "target/classes:target/lib/*" com.mycompany.openevent.service.DemoData
   ```

3. Use these committed demonstration credentials **only for local development**:

| Role | Demo email | Committed demo password | Demonstrates |
| --- | --- | --- | --- |
| Host | `host@openevent.local` | `OpenEvent2026!` | Owns the seeded events; manages tickets/check-in. |
| Customer | `alex@openevent.local` | `OpenEvent2026!` | Discovers events and makes simulated bookings. |

The loader hashes the password through `SecurityService`; it does not store plaintext passwords in account rows.

| Demo event | Base price (PHP) | Start relative to loader date | Seats |
| --- | ---: | --- | ---: |
| Between the Islands | 850.00 | 26 days later, 19:00 | 60 |
| After Hours, Escolta | 500.00 | 33 days later, 19:00 | 60 |
| Soft Sounds Sunday | 400.00 | 40 days later, 19:00 | 60 |

All three are published Concert events with legacy grid layouts. Each has 20 VIP and 40 Regular seats; columns 5 and 6 are omitted as an aisle. Early Bird cutoff is seven days before each start. The loader creates no bookings, payments, or receipts.

Re-run behavior: account inserts use `INSERT IGNORE`, so existing matching emails are not overwritten. If the demo Host already owns any events, event seeding is skipped. A fresh successful second run was verified to keep three events. The loader is not one transaction for the whole dataset: partial failures can leave accounts or some events. An existing demo email with a different password can also make the Host login fail. Do not treat re-running as a repair/reset.

## 9. Reset and backup

### Back up before changing data

1. Stop application writes while performing schema changes. Use an administrator/backup account, not the restricted app account.
2. Dump the database outside the repo. Windows PowerShell:

   ```powershell
   $xamppRoot = 'C:\xampp'
   & "$xamppRoot\mysql\bin\mysqldump.exe" --no-defaults --host=127.0.0.1 --port=3307 --user=root --password --single-transaction --default-character-set=utf8mb4 --result-file=../openevent-backup.sql openevent
   ```

   macOS/Linux:

   ```sh
   mysqldump --no-defaults --host=127.0.0.1 --port=3307 --user=root --password --single-transaction --default-character-set=utf8mb4 --result-file=../openevent-backup.sql openevent
   ```

   `--result-file` avoids PowerShell output-encoding differences. Check the command succeeded and the file is nonempty. This is a data/schema backup of one database, not a backup of MariaDB server users/grants. It contains account hashes and saved user records; keep it private.
3. Test restore into a **new, empty** database, using an administrative client launched from the same project root:

   ```sql
   CREATE DATABASE openevent_restore CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
   USE openevent_restore;
   SOURCE ../openevent-backup.sql;
   SHOW TABLES;
   ```

   The selected database receives the dump because the command above omits `--databases`. A normal dump can contain `DROP TABLE` statements; restore only into an empty target unless deliberately replacing its contents. Recreate/grant the app login for a restored database before pointing the app at it.

### Reset a disposable local database

1. Back up first and close the app. Confirm that you intend to permanently discard every account, event, ticket, payment, and receipt in this local database.
2. In an administrative client opened from the project root, execute:

   ```sql
   DROP DATABASE openevent;
   CREATE DATABASE openevent CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
   USE openevent;
   SOURCE database/schema.sql;
   ```

3. Confirm counts are zero using section 6. Keep/recreate the restricted login as needed. Optionally load demonstration data again. Importing `schema.sql` alone is **not** a reset.

These production-name reset commands are documentation only; they were not executed during guide verification. The tested backup/restore used only scratch databases.

### Change the scripts safely

Create an additive migration for saved installations and update the fresh-schema path consistently. Test both a new import and an upgrade with representative data. Check constraints and re-run behavior before sharing. Avoid narrowing existing columns or deleting data without an explicit migration/backup plan. Database schema work remains manual; there is no migration runner to record which scripts ran.

## 10. Troubleshooting

| Symptom | Likely cause | Fix/check |
| --- | --- | --- |
| Connection refused / communications failure | MariaDB stopped or wrong host/port | Check the XAMPP MySQL row and direct version query. Match port 3307 from the example to the actual server. Apache alone does not start the database. |
| Connection error 10013 | Local connection blocked by permissions/firewall | Test the client directly. Check local firewall/access permissions before changing SQL or resetting data. The initial verification connection here needed local network access. |
| Access denied for user | Wrong credentials, unmatched account host, or missing grants | Check `db.user`/`db.password`, environment overrides, and grants for the connection host. App accounts need SELECT/INSERT/UPDATE/DELETE; import/reset requires administrator rights. |
| Unknown database / no database selected | URL database missing, or import without selecting a database | Create/select `openevent`; use `USE openevent` before `SOURCE`. The script does not contain CREATE DATABASE or USE. |
| Port already in use / MySQL will not start | Another server/process uses the chosen port | Identify the listener before stopping anything. Run one intended server, or choose a free port and update XAMPP, JDBC URL, and client commands together. Changing only the Control Panel port display does not update Java configuration. |
| Missing `venue_areas`, `ticket_name`, or `area_color` | Older schema or incomplete import | Inspect the database and apply only the relevant migrations from section 4. The restricted app account cannot perform schema upgrades. |
| Syntax error near `IF NOT EXISTS` / generated column | Unsupported server version or different SQL dialect | Check `SELECT VERSION()`; use the verified MariaDB setup. TODO: establish the minimum supported version. Do not remove constraints just to silence an import error. |
| Re-import succeeds but incompatible columns remain | CREATE TABLE IF NOT EXISTS skips existing tables | Compare SHOW CREATE TABLE with schema.sql; plan a targeted migration. The script is not a general schema reconciler. |
| Demo login missing / no events | Only the schema was imported, or demo loader skipped/failed | Schema import seeds no accounts. Register in the UI or run DemoData deliberately. Read loader output; existing emails are not overwritten and any Host event causes event seeding to skip. |
| Demo password rejected | Wrong selected role or existing demo address has a different password | Select Host/Customer correctly. Use your own registered account or a disposable clean demo database; do not overwrite real accounts to force demo credentials. |
| Event or cutoff times appear shifted | JVM/server timezone mismatch and timezone-free DATETIME values | Check server NOW()/session timezone and the Java process timezone. Align local settings before entering dates. No shared timezone policy or conversion migration is implemented. |
| Accented text is garbled | Wrong database/import/client character set | Use utf8mb4 for the database and import/client connection. Scripts do not declare table charset/collation, so tables inherit database defaults. Changing the display charset does not repair already-corrupted stored text. |
| File not found / Unknown command during SOURCE | Wrong working directory or Windows backslashes interpreted by the client | Run the client from the project root and use forward-slash paths such as database/schema.sql. |
| MySQL JDBC driver is missing | Packaged driver not beside the JAR | Rebuild and keep target/lib/mysql-connector-j-8.4.0.jar beside the packaged app as described in the README. No SQL repair is needed. |
| Unexpected root login or wrong database despite editing config | Missing config file, different working directory, or environment overrides | Check openevent.config and OPENEVENT_DB_* precedence. Source fallback is root/empty password on localhost:3307; the template instead selects openevent_app. |

Unverified steps: phpMyAdmin/XAMPP clicks, new-user provisioning, timezone alignment, destructive reset of `openevent`, and macOS/Linux execution. Schema import/re-import, demo seeding/re-run, verification data, and scratch dump/restore were exercised on the available Windows/MariaDB environment
