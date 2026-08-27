COMMIT_MESSAGE: Configure Oracle service on the required port

## Features Added
- Confirmed the existing Spring Data JPA configuration uses Oracle Thin JDBC URLs and `oracle.jdbc.OracleDriver` for the base, `local`, and `prod` profiles.
- Configured the service to use the required port 23812 while retaining Actuator health exposure.

## Files Modified
- src/main/resources/application.properties — sets `server.port` to 23812; retains the environment-overridable local Oracle datasource configuration and health endpoint exposure.
- ai_changes.md — records the completed Oracle profile verification and compilation result.

## Files Added
- None.

## Secrets Moved
- None; datasource credentials remain environment supplied through `DB_USERNAME` and `DB_PASSWORD`, and the AWS JWT secret name remains externalized as `app.secret.aws-jwt-secret-name`.

## DB URLs Resolved
- No JDBC URL resolution was required: all discovered base, local, and production datasource URLs already use environment-overridable Oracle Thin URLs.
- Base/local: `${ORACLE_DB_URL:jdbc:oracle:thin:@//localhost:1521/FREEPDB1}`.
- Production: `${ORACLE_DB_URL:jdbc:oracle:thin:@//oracle:1521/FREEPDB1}`.

## Compilation Result
PASSED — `mvn compile -q` and `mvn package -DskipTests -q` completed successfully; Java 21 is available.
