COMMIT_MESSAGE: Add API endpoint to return the complete user list

## Features Added
- Added authenticated GET /api/v1/users to return all registered users.
- User-list responses expose id, email, and role only; password hashes are never returned.

## Files Modified
- src/main/java/com/gab/authservice/service/AuthService.java — added retrieval and safe mapping of all users.
- src/main/resources/application.properties — set the required server port to 26715 and retained health exposure.

## Files Added
- src/main/java/com/gab/authservice/controller/UserController.java — user-list REST endpoint.
- src/main/java/com/gab/authservice/dto/UserResponse.java — password-safe user response representation.

## Secrets Moved
- JWT signing key -> app.secret.jwt-signing-key

## DB URLs Resolved
- jdbc:oracle:thin:@//localhost:1521/FREEPDB1 -> jdbc:postgresql://localhost:5432/gen_c23d12a2fecf
- jdbc:oracle:thin:@//oracle:1521/FREEPDB1 -> jdbc:postgresql://localhost:5432/gen_c23d12a2fecf_1

## Compilation Result
PASSED — mvn compile -q and mvn package -DskipTests -q completed successfully.

## Test Results Summary
- API testing was intentionally skipped because the configured testing framework is none; no server was started during the build-verification steps.
