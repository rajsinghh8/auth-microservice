COMMIT_MESSAGE: Migrate local and production database configuration to Oracle

## Features Added
- Migrated the Spring Data JPA runtime database driver and local/prod datasource configurations from PostgreSQL to Oracle.
- Preserved profile-specific configuration with overridable `ORACLE_DB_URL` values for local development and production.
- Migrated the integration-test database container from PostgreSQL to Oracle Free.

## Files Modified
- pom.xml — replaced the PostgreSQL JDBC runtime driver with Oracle JDBC and the PostgreSQL Testcontainers module with Oracle XE.
- src/main/resources/application.properties — configured the Oracle JDBC URL/driver and server port 21722.
- src/main/resources/application-local.properties — configured the local Oracle datasource profile.
- src/main/resources/application-prod.properties — configured the production Oracle datasource profile.
- src/test/java/com/gab/authservice/controller/AuthControllerIntegrationTest.java — switched Testcontainers datasource wiring to Oracle Free.

## Files Added
- None.

## Secrets Moved
- None; no hardcoded credentials or token values were found in production Java source.

## DB URLs Resolved
- jdbc:postgresql://localhost:5432/authdb -> ${ORACLE_DB_URL:jdbc:oracle:thin:@//localhost:1521/FREEPDB1}
- jdbc:postgresql://postgres:5432/authdb -> ${ORACLE_DB_URL:jdbc:oracle:thin:@//oracle:1521/FREEPDB1}

## Compilation Result
PASSED — `mvn compile -q` and `mvn package -DskipTests -q` completed successfully with JDK 21 available.
