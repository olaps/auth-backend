# OAuth2 Authentication App

This is a Spring Boot application that demonstrates OAuth2 authentication with GitHub and JWT token-based authentication.

## Features

- OAuth2 authentication with GitHub
- JWT token-based authentication
- H2 in-memory database
- RESTful API endpoints
- CORS configuration
- Secure password handling

## Prerequisites

- Java 17 or higher
- Maven
- GitHub OAuth2 application credentials

## Setup

1. Clone the repository
2. Create a GitHub OAuth2 application:
   - Go to GitHub Settings > Developer settings > OAuth Apps
   - Create a new OAuth App
   - Set the Homepage URL to `http://localhost:8080`
   - Set the Authorization callback URL to `http://localhost:8080/login/oauth2/code/github`
   - Copy the Client ID and Client Secret

3. Set up environment variables:
   ```bash
   export GITHUB_CLIENT_ID=your_client_id
   export GITHUB_CLIENT_SECRET=your_client_secret
   ```

4. Build the project:
   ```bash
   mvn clean install
   ```

5. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

- `POST /api/auth/login` - Login with username/password
- `GET /api/auth/oauth2/github` - Initiate GitHub OAuth2 login
- `GET /api/auth/me` - Get current user details
- `POST /api/auth/logout` - Logout

## Security

- JWT tokens are used for authentication
- Passwords are hashed using BCrypt
- CORS is configured to allow requests from `http://localhost:3000`
- OAuth2 state parameter is used to prevent CSRF attacks

## Database

- H2 in-memory database is used
- Access the H2 console at `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: `password`

## Frontend

The frontend is a React application that communicates with this backend. See the `auth-frontend` directory for more details.

## License

MIT 