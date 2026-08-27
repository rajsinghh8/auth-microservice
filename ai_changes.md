COMMIT_MESSAGE: Migrate database configuration and container setup to Oracle

## Features Added
- Migrated Spring Data JPA runtime support from PostgreSQL to Oracle using the Oracle JDBC driver.
- Configured Oracle datasource URLs and driver settings for the base, `local`, and `prod` profiles while keeping environment-variable overrides.
- Migrated the integration-test container to Oracle Free and migrated the Docker Compose database service to Oracle Free.
- Aligned the application, Docker Compose, Docker health check, and documented service URLs with port `24018`.

## Files Modified
- pom.xml — uses Oracle JDBC at runtime and the Oracle XE Testcontainers module.
- src/main/resources/application.properties — defines the default Oracle datasource, Oracle driver, actuator exposure, and port 24018.
- src/main/resources/application-local.properties — retains the local profile with an overridable Oracle datasource URL.
- src/main/resources/application-prod.properties — retains the production profile with an overridable Oracle datasource URL.
- src/test/java/com/gab/authservice/controller/AuthControllerIntegrationTest.java — uses an Oracle Free Testcontainer for persistence integration coverage.
- docker-compose.yml — provisions Oracle Free and supplies the Oracle production datasource URL on port 24018.
- Dockerfile — checks the Actuator health endpoint on port 24018.
- README.md — documents Oracle prerequisites, profile URLs, test container, and service URLs.

## Files Added
- None.

## Secrets Moved
- None; no hardcoded credentials or token values were found in production Java source.

## DB URLs Resolved
- jdbc:postgresql://localhost:5432/authdb -> ${ORACLE_DB_URL:jdbc:oracle:thin:@//localhost:1521/FREEPDB1}
- jdbc:postgresql://postgres:5432/authdb -> ${ORACLE_DB_URL:jdbc:oracle:thin:@//oracle:1521/FREEPDB1}

## Compilation Result
PASSED — `mvn compile -q` and `mvn package -DskipTests -q` completed successfully; Java 21 is available.
