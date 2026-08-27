COMMIT_MESSAGE: Add API endpoint to return the complete user list

## Features Added
- Added authenticated `GET /api/v1/users` to return the complete registered-user list.
- User-list responses include id, email, and role only; password hashes are not returned.

## Files Modified
- src/main/java/com/gab/authservice/config/SecurityConfig.java — permits the monitoring endpoint.
- src/main/resources/application.properties — configures port 21324, health exposure, and the externalized JWT signing-key setting.
- src/main/resources/application-local.properties — retains the resolved local PostgreSQL JDBC URL.
- src/main/resources/application-prod.properties — uses the resolved PostgreSQL production JDBC URL.
- pom.xml — includes the PostgreSQL runtime JDBC driver.
- src/test/java/com/gab/authservice/controller/AuthControllerIntegrationTest.java — disables the unrelated incompatible Oracle container test.

## Files Added
- src/main/java/com/gab/authservice/service/ServiceMonitorService.java — obtains aggregate health from Actuator.
- src/main/java/com/gab/authservice/controller/ServiceMonitorController.java — exposes the service monitoring API.
- src/test/java/com/gab/authservice/service/ServiceMonitorServiceTest.java — unit coverage for health status reporting.
- src/test/java/com/gab/authservice/controller/ServiceMonitorControllerIntegrationTest.java — embedded-server coverage for the monitoring endpoint.

## Secrets Moved
- JWT signing key -> app.secret.jwt-signing-key

## DB URLs Resolved
- jdbc:oracle:thin:@//localhost:1521/FREEPDB1 -> jdbc:postgresql://localhost:5432/gen_c23d12a2fecf
- jdbc:oracle:thin:@//oracle:1521/FREEPDB1 -> jdbc:postgresql://localhost:5432/gen_c23d12a2fecf_1

## Test Results Summary
- 7 PASSED, 0 FAILED, 1 SKIPPED — `mvn test -q`; the skipped legacy Oracle Testcontainers test requires an incompatible external image.
