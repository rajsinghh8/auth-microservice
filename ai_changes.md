COMMIT_MESSAGE: Finalize Oracle profiles and externalize JWT secret configuration

## Features Added
- Oracle is the configured Spring Data JPA runtime database for the base, `local`, and `prod` profiles, using environment-overridable Oracle Thin JDBC URLs and the Oracle JDBC driver.
- The service port is configured as 23070 and Actuator health exposure remains enabled.
- AWS Secrets Manager's JWT secret identifier is configurable through an environment-backed application property.

## Files Modified
- src/main/resources/application.properties — retains the Oracle datasource configuration, sets port 23070, and defines the AWS JWT secret-name property.
- src/main/java/com/gab/authservice/service/JwtService.java — reads the AWS JWT secret identifier from configuration instead of a hardcoded value.

## Files Added
- None.

## Secrets Moved
- JwtService.secretName -> app.secret.aws-jwt-secret-name

## DB URLs Resolved
- jdbc:postgresql://localhost:5432/authdb -> ${ORACLE_DB_URL:jdbc:oracle:thin:@//localhost:1521/FREEPDB1}
- jdbc:postgresql://postgres:5432/authdb -> ${ORACLE_DB_URL:jdbc:oracle:thin:@//oracle:1521/FREEPDB1}

## Compilation Result
PASSED — `mvn compile -q` and `mvn package -DskipTests -q` completed successfully; Java 21 is available.
