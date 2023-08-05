# Simple Web Shop Application

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1-brightgreen)
![License](https://img.shields.io/badge/License-MIT-green)

A simple web shop application developed using Spring Boot.

## Features

- List products with brand names and prices.
- Buy products and complete checkout process.
- Simulated credit card processing.
- Order storage and notification.

## Getting Started

These instructions will help you set up and run the project on your local machine.

### Prerequisites

- Java 17
- Maven
- MySQL server (or Docker for local development)
- Internet connection for Bootstrap CDN (optional)

### Installing

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/simple-web-shop-application.git
   
2. Navigate to the project directory:
   ```bash
   cd simple-web-shop-application

3. Create a MySQL database named "shop" (or update application.properties).

4. Build and run the application:
   ```bash
   mvn spring-boot:run

5. Open your browser and visit: http://localhost:8080

### Configuration

You can configure various aspects of the application by modifying the `application.yml` file:

```yaml
server:
  port: ${SERVER_PORT:5000}
spring:
  datasource:
    url: ${MYSQL_URL:jdbc:mysql://localhost:3306/shop?allowMultiQueries=true}
    driverClassName: com.mysql.cj.jdbc.Driver
    username: ${MYSQL_USER:api}
    password: ${MYSQL_PASSWORD:123456*}
  jpa:
    show-sql: true
    hibernate:
      ddl-auto: ${DDL_AUTO:none}
  liquibase:
    enabled: true
  mail:
    admin: ${MAIL_ADMIN:your-email@example.com}
    active: ${MAIL_ACTIVE:false}
    host: smtp.example.com
    port: 587
    username: ${MAIL_USERNAME:your-email@example.com}
    password: ${MAIL_PASS:your-email-password}
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
seeder:
  run: ${SEEDER_RUN:false}
```

### Usage
- Visit http://localhost:8080 to view the list of products.
- Click on the "SATIN AL" button to proceed to checkout.
- Fill out the checkout form and submit the order.
### Technologies Used
- Spring Boot
- Thymeleaf (for HTML templates)
- MySQL (Database)
- Bootstrap (Frontend framework)
- Mockito and JUnit (for unit testing)
- Flyway and Liquibase (for database migrations)
- Docker (for local development environment)
- JavaMail (for email notifications)
### License
This project is licensed under the MIT License - see the LICENSE file for details.