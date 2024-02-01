# Spring Boot Security Project using jwt authentication

This Java project, built with Spring Boot, integrates several dependencies for key functionalities:

- **Spring Boot Starter Security:** Enables authentication and authorization.
- **Spring Boot Starter Web:** Facilitates RESTful API development.
- **Spring Boot Starter Validation:** Ensures data integrity with DTO validations.
- **SpringDoc OpenAPI:** Provides API documentation and testing capabilities with Swagger.
- **MyBatis Spring Boot Starter:** Simplifies database interaction with MyBatis.
- **MySQL Connector/J:** Connects the application to the MySQL database.
- **Flyway Core:** Facilitates database migration management.
- **Lombok:** Reduces boilerplate code in Java classes.
- **MapStruct:** Simplifies Java bean mapping.
- **Spring Security Test:** Provides testing utilities for Spring Security.
- **Spring Data JPA Starter:** Integrates Spring Data JPA for database access.
- **JJWT:** Implements JSON Web Token functionality for stateless authentication.
## Requirements

- Local MySQL Database running with the following credentials:
    - **Username:** `root`
    - **Password:** `password`

## Instructions

1. **Run the Application:**
    - Make sure your MySQL database is running locally.
    - Modify the `application.properties` file in the `src/main/resources` directory with your MySQL database configuration.
    - Build and run the application using Maven or your preferred IDE.

2. **Login:**
    - Access the `/auth/login` endpoint to login.
    - Use the following credentials:
        - **Regular User:**
            - **Username:** `USER`
            - **Password:** `password_user`
        - **Admin User:**
            - **Username:** `ADMIN`
            - **Password:** `password_admin`

3. **Authentication Token:**
    - Upon successful login, copy the authentication token from the response.

4. **Accessing Other Endpoints:**
    - Use the copied authentication token in the headers of subsequent requests to access other endpoints.


## Additional Notes

- The application automatically creates the required database tables upon startup.
- Make sure to secure your authentication tokens properly and avoid exposing them in public repositories or insecure channels.
- Refer to the project documentation or codebase for more detailed information on endpoints, functionalities, and configurations.

