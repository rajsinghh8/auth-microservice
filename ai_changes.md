COMMIT_MESSAGE: Configure Oracle profiles on the required service port

## Features Added
- Oracle remains the Spring Data JPA runtime database for the base, `local`, and `prod` profiles through environment-overridable Oracle Thin JDBC URLs and the Oracle JDBC driver.
- The service is configured to run on port 22844, with Actuator health exposure retained.

## Files Modified
- src/main/resources/application.properties — configures the required port 22844 while retaining the Oracle datasource, Oracle driver, and health endpoint exposure.

## Files Added
- None.

## Secrets Moved
- None in this change; the existing AWS JWT secret-name configuration remains externalized as `app.secret.aws-jwt-secret-name`.

## DB URLs Resolved
- jdbc:postgresql://localhost:5432/authdb -> ${ORACLE_DB_URL:jdbc:oracle:thin:@//localhost:1521/FREEPDB1}
- jdbc:postgresql://postgres:5432/authdb -> ${ORACLE_DB_URL:jdbc:oracle:thin:@//oracle:1521/FREEPDB1}

## Compilation Result
PASSED — `mvn compile -q` and `mvn package -DskipTests -q` completed successfully; Java 21 is available.
