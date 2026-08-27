COMMIT_MESSAGE: Clean and stabilize the authentication service configuration

## Features Added
- Cleaned the application bootstrap and removed local dotenv-based system-property mutation.
- Aligned the authentication API with the `/api/v1` prefix and request validation.
- Simplified JWT authentication handling and removed role-derived authorization from the request filter.
- Corrected the Actuator health component type usage and retained health endpoint exposure.
- Configured the service port as `25166`.

## Files Modified
- src/main/java/com/gab/authservice/AuthServiceApplication.java — uses the standard Spring Boot bootstrap only.
- src/main/java/com/gab/authservice/config/JwtAuthFilter.java — establishes authenticated principals without role authorities.
- src/main/java/com/gab/authservice/config/SecurityConfig.java — removes method security and permits the versioned auth API.
- src/main/java/com/gab/authservice/controller/AuthController.java — uses `/api/v1/auth`, validates login input, and removes RSA public-key exposure.
- src/main/java/com/gab/authservice/dto/LoginRequest.java — adds no-argument construction and email/password validation.
- src/main/java/com/gab/authservice/service/AuthService.java — retains the existing user-list integration required by the present controller.
- src/main/resources/application.properties — configures port 25166, the externalized JWT signing key, and health exposure.
- src/main/resources/application-local.properties — uses the resolved local PostgreSQL configuration.
- src/main/resources/application-prod.properties — uses the resolved production PostgreSQL configuration.
- pom.xml — uses PostgreSQL runtime support for the resolved datasource configuration.

## Files Added
- None.

## Secrets Moved
- JWT signing key -> app.secret.jwt-signing-key

## DB URLs Resolved
- jdbc:oracle:thin:@//localhost:1521/FREEPDB1 -> jdbc:postgresql://localhost:5432/gen_c23d12a2fecf_1
- jdbc:oracle:thin:@//oracle:1521/FREEPDB1 -> jdbc:postgresql://localhost:5432/gen_c23d12a2fecf_2
- jdbc:postgresql://localhost:5432/gen_c23d12a2fecf -> jdbc:postgresql://localhost:5432/gen_c23d12a2fecf

## Compilation Result
PASSED — `mvn compile -q` and `mvn package -DskipTests -q` completed successfully with Java 21.
