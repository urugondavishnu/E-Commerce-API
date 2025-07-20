# E-Commerce RESTful API

A fully functional E-Commerce backend API built with Spring Boot, featuring user authentication, product management, cart functionality, and order processing.

## Features

- **User Management**
  - Registration, login, and authentication
  - Role-based authorization (User/Admin)
  - JWT token authentication
  - Refresh tokens for persistent sessions

- **Product Management**
  - CRUD operations for products
  - Product categorization
  - Search and filtering

- **Shopping Cart**
  - Add/remove items
  - Quantity adjustment
  - Cart persistence

- **Order Processing**
  - Checkout functionality
  - Order history
  - Order status tracking

- **Security**
  - Password hashing with BCrypt
  - JWT authentication
  - CSRF protection
  - Input validation

## Technologies Used

- **Backend**
  - Java 17
  - Spring Boot 3.x
  - Spring Security
  - JWT (JSON Web Tokens)
  - MapStruct for DTO mapping
  - Jakarta Validation
  - Spring Data JPA

- **Database**
  - MySQL (Production)
  - H2 (Development)

- **Tools**
  - Maven
  - Postman (for API testing)
  - Swagger (API documentation)
  - Railway (Deployment)


## Installation & Setup

### Prerequisites
- Java 17 JDK
- Maven 3.8+
- MySQL 8.0+ (for production)
- Git

### Local Development

1. Clone the repository:
   ```bash
   git clone https://github.com/urugondavishnu/E-Commerce-RESTFUL_API.git

2. Navigate to the project directory:
   ```bash
   cd E-Commerce-RESTFUL_API

3. Create a `.env` file in the root directory with the following variables:
   ```text
   SPRING_JWT_SECRET=your-256-bit-secret-key-here
   SPRING_DATASOURCE_URL=jdbc:h2:mem:ecommerce

4. Build and run the application:
   ```bash
   mvn spring-boot:run

The application will be available at `http://localhost:8080`

## Production Deployment
1. Set up a MySQL database (Railway recommended).
2. Configure the following environment variables:
   ``` text
   SPRING_PROFILES_ACTIVE=prod
   SPRING_JWT_SECRET
   SPRING_DATASOURCE_URL
3. Build the application:
   ``` bash
   mvn clean package
4. Deploy the generated `target/*.jar` file to your production environment

## Security
The API implements:
- JWT-based authentication
- Role-based authorization
- Password hashing with BCrypt
- Input validation
- Secure token handling with refresh tokens

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.

## Acknowledgments
- Spring Framework
- JJWT library
- MapStruct
- Railway for deployment

## Contact
For questions or feedback, please contact  [urugondavishnu](https://github.com/urugondavishnu).

