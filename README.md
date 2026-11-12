🏦 Online Bank Account Management System

A Java-based backend application developed using Spring Boot that provides secure and efficient banking operations through RESTful APIs.

The application allows users to manage bank accounts, check account balances, perform financial transactions, and maintain transaction records. It follows a layered architecture to ensure maintainability, scalability, and separation of business logic.

🚀 Project Overview

The Online Bank Account Management System is designed to simplify essential banking operations by providing a centralized platform for account management and financial transactions.

The application implements backend business logic for handling deposits, withdrawals, fund transfers, and transaction history while maintaining data consistency and secure user authentication.

✨ Key Features

🔐 Authentication & Security

- User registration and login.
- JWT-based authentication.
- Secure password encryption.
- Protected REST API endpoints.
- Input validation.

🏦 Account Management

- Create and manage bank accounts.
- Retrieve account information.
- Check available account balance.
- Manage account-related operations.

💰 Financial Transactions

- Deposit money into accounts.
- Withdraw money from accounts.
- Transfer funds between accounts.
- Validate transaction amounts.
- Prevent withdrawals exceeding available balances.

📜 Transaction Management

- Maintain transaction records.
- View transaction history.
- Track deposits, withdrawals, and transfers.
- Store transaction details in MySQL.

⚙️ Backend Architecture

- Layered architecture.
- Controller, Service, and Repository layers.
- Business logic separation.
- Database integration using Spring Data JPA.
- Exception handling and validation.

🛠️ Technology Stack

Category| Technologies
Programming Language| Java
Backend Framework| Spring Boot
ORM| Hibernate
Data Access| Spring Data JPA
Database| MySQL
Security| Spring Security, JWT
API Architecture| RESTful APIs
Database Connectivity| JDBC
Build Tool| Maven
API Testing| Postman
IDE| Eclipse 
Version Control| Git, GitHub

🏗️ Application Architecture

The application follows a layered architecture to separate responsibilities and improve maintainability.

             CLIENT
                |
                v
          REST CONTROLLER
                |
                v
           SERVICE LAYER
                |
          BUSINESS LOGIC
                |
                v
         REPOSITORY LAYER
                |
                v
           SPRING DATA JPA
                |
                v
              MYSQL

Layer Responsibilities

1. Controller Layer

- Handles incoming HTTP requests.
- Exposes RESTful API endpoints.
- Returns appropriate HTTP responses.

2. Service Layer

- Implements banking business logic.
- Processes deposits and withdrawals.
- Validates account balances.
- Handles fund transfers.

3. Repository Layer

- Communicates with the database.
- Performs database operations using Spring Data JPA.

4. Security Layer

- Handles user authentication.
- Validates JWT tokens.
- Protects secured API endpoints.

📂 Project Structure

Online-Banking-System/
│
├── .mvn/
│   └── wrapper/
│       └── maven-wrapper.properties
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/bank/system/
│   │   │       │
│   │   │       ├── controller/
│   │   │       │   ├── AccountController.java
│   │   │       │   └── AuthController.java
│   │   │       │
│   │   │       ├── dto/
│   │   │       │   └── AccountRequestDTO.java
│   │   │       │
│   │   │       ├── exception/
│   │   │       │   └── GlobalExceptionHandler.java
│   │   │       │
│   │   │       ├── model/
│   │   │       │   ├── Account.java
│   │   │       │   └── TransactionAudit.java
│   │   │       │
│   │   │       ├── repository/
│   │   │       │   ├── AccountRepository.java
│   │   │       │   └── AuditRepository.java
│   │   │       │
│   │   │       ├── security/
│   │   │       │   ├── JwtFilter.java
│   │   │       │   ├── JwtUtil.java
│   │   │       │   └── SecurityConfig.java
│   │   │       │
│   │   │       ├── service/
│   │   │       │   └── BankingService.java
│   │   │       │
│   │   │       └── OnlineBankingSystemApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/
│           └── com/bank/system/
│               └── OnlineBankingSystemApplicationTests.java
│
├── screenshots/
│   ├── Screenshot 2026-01-31 155028.png
│   ├── Screenshot 2026-01-31 155053.png
│   ├── Screenshot 2026-01-31 161534.png
│   ├── Screenshot 2026-01-31 162308.png
│   └── Screenshot 2026-01-31 162324.png
│
├── .gitattributes
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md

🔗 API Endpoints

The following is an illustrative endpoint structure. Adjust the paths to match your actual controllers.

Method| Endpoint| Description
POST| "/auth/register"| Register a new user
POST| "/auth/login"| Authenticate user
POST| "/accounts"| Create bank account
GET| "/accounts/{id}"| Retrieve account details
GET| "/accounts/{id}/balance"| Check account balance
POST| "/transactions/deposit"| Deposit money
POST| "/transactions/withdraw"| Withdraw money
POST| "/transactions/transfer"| Transfer funds
GET| "/transactions/history/{accountId}"| View transaction history

🧪 API Testing

The REST APIs can be tested using Postman.

Testing scenarios include:

- Successful user registration and authentication.
- Valid and invalid login credentials.
- Successful deposit and withdrawal operations.
- Insufficient balance validation.
- Successful fund transfers.
- Invalid account and transaction requests.
- Transaction history retrieval.

🧠 Challenges & Problem Solving

One important business logic challenge involved handling withdrawals that exceeded the available account balance.

Problem: An invalid withdrawal could result in an incorrect account balance if the transaction was not properly validated.

Solution: Implemented validation in the service layer to verify the available balance before processing a withdrawal.

Result: Invalid withdrawal requests are rejected, helping maintain account balance correctness.

🎯 Learning Outcomes

Through this project, I gained practical experience in:

- Developing RESTful APIs using Spring Boot.
- Applying object-oriented programming principles.
- Implementing layered backend architecture.
- Integrating MySQL using Spring Data JPA and Hibernate.
- Implementing JWT-based authentication.
- Writing business logic for financial transactions.
- Handling validation and exception scenarios.
- Testing backend APIs using Postman.

👨‍💻 Developer

Rupesh Dhole
