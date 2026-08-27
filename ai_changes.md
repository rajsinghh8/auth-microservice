COMMIT_MESSAGE: Add API endpoint to return the complete user list

## Features Added
- Added authenticated GET /api/v1/users to return all registered users.
- User-list responses expose id, email, and role only; password hashes are never returned.

## Files Modified
- pom.xml — replaced the Oracle runtime driver with PostgreSQL for resolved local database URLs.
- src/main/java/com/gab/authservice/service/AuthService.java — added retrieval and safe mapping of all users.
- src/main/java/com/gab/authservice/config/JwtAuthFilter.java — simplified token authentication to align with the current JWT service.
- src/main/java/com/gab/authservice/config/SecurityConfig.java — aligned public authentication routes with the /api/v1 prefix.
- src/main/java/com/gab/authservice/controller/AuthController.java — aligned authentication routes with /api/v1 and validated login requests.
- src/main/java/com/gab/authservice/dto/LoginRequest.java — added request validation and a no-argument constructor for binding.
- src/main/resources/application.properties — set PostgreSQL configuration, port 26715, and health exposure.
- src/main/resources/application-local.properties — set the resolved local PostgreSQL configuration.
- src/main/resources/application-prod.properties — set the resolved production-profile PostgreSQL configuration.

## Files Added
- src/main/java/com/gab/authservice/controller/UserController.java — user-list REST endpoint.
- src/main/java/com/gab/authservice/dto/UserResponse.java — password-safe user response representation.
- src/main/java/com/gab/authservice/service/ServiceMonitorService.java — actuator health status adapter.
- src/main/java/com/gab/authservice/controller/ServiceMonitorController.java — service monitoring endpoint.

## Secrets Moved
- None.

## DB URLs Resolved
- jdbc:oracle:thin:@//localhost:1521/FREEPDB1 -> jdbc:postgresql://localhost:5432/gen_c23d12a2fecf
- jdbc:oracle:thin:@//oracle:1521/FREEPDB1 -> jdbc:postgresql://localhost:5432/gen_c23d12a2fecf_1

## Compilation Result
PASSED — mvn compile -q and mvn package -DskipTests -q completed successfully.

## Test Results Summary
- API testing was intentionally skipped because the configured testing framework is none; no server was started during the build-verification steps.
