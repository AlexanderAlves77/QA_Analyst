# QA E2E Automation Suite

End-to-End Test Automation Framework built using Java, Selenium WebDriver, Hibernate, and MySQL.

This project demonstrates the implementation of a scalable, maintainable, and production-ready automation framework following industry best practices.

---

## Overview

The purpose of this project is to automate end-to-end testing of a web application, including:

* UI Automation
* Database validation
* Test reporting
* Scalable architecture
* Maintainable code using design patterns

This framework is designed to simulate real-world QA Automation Engineer responsibilities.

---

## Architecture

This project follows a layered architecture:

```
qa-e2e-automation-suite/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── config/          # Hibernate configuration
│   │   │   ├── models/          # Entity classes
│   │   │   ├── dao/             # Database access layer
│   │   │   ├── utils/           # Utilities (Hibernate, Driver, etc.)
│   │   │   └── pages/           # Page Object Model classes
│   │   │
│   │   └── resources/
│   │       └── hibernate.cfg.xml
│   │
│   └── test/
│       └── java/
│           └── tests/           # Test classes
│
├── pom.xml
├── .gitignore
└── README.md
```

---

## Technologies Used

* Java
* Selenium WebDriver
* Hibernate ORM
* MySQL
* Maven
* JUnit / TestNG
* Page Object Model (POM)
* JDBC
* Git & GitHub

---

## Features

* UI Test Automation
* Database Integration with Hibernate
* Entity Mapping
* Automated database validation
* Scalable and maintainable structure
* Separation of concerns (DAO, Models, Pages, Tests)
* Maven dependency management

---

## Database Configuration

This project uses MySQL with Hibernate ORM.

Example configuration:

```
Database: qa_db
Username: root
Password: root
Port: 3306
```

Hibernate configuration file:

```
src/main/resources/hibernate.cfg.xml
```

---

## Hibernate Features Implemented

* SessionFactory configuration
* Entity mapping
* Automatic table creation
* CRUD operations via DAO layer
* MySQL dialect configuration

---

## How to Run the Project

### 1. Clone repository

```
git clone https://github.com/your-username/QA_Analyst.git
```

---

### 2. Navigate to project

```
cd QA_Analyst/qa-e2e-automation-suite
```

---

### 3. Configure database

Create database in MySQL:

```
CREATE DATABASE qa_db;
```

Update credentials in:

```
hibernate.cfg.xml
```

---

### 4. Install dependencies

```
mvn clean install
```

---

### 5. Run tests

```
mvn test
```

---

## Design Patterns Used

* Page Object Model (POM)
* Data Access Object (DAO)
* Singleton Pattern (Hibernate SessionFactory)
* Layered Architecture

---

## Example Entity

```
UserEntity
```

Mapped using Hibernate ORM to database table.

---

## Learning Objectives

This project demonstrates:

* Real-world QA automation framework design
* Database validation using Hibernate
* Automation best practices
* Clean architecture principles
* Integration between UI and Database testing

---

## Future Improvements

* Test reporting with Allure or ExtentReports
* CI/CD integration (GitHub Actions)
* Docker support
* Parallel test execution
* Logging with Log4j

---

## Author

Alexander
Computer Science Student
Game Development
QA Automation Engineer (in progress)

---

## Status

In development – actively expanding features and test coverage.
