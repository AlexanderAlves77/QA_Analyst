# QA Analyst Portfolio

This repository contains a collection of high-level Quality Assurance projects. The focus is on building robust, maintainable, and scalable test frameworks that cover the entire software development lifecycle—from raw data integrity to final UI rendering.

---

## Repository Structure

```
QA_Analyst/
│
├── qa-ml-quality-engineering/  # ML Data & UI Integrity (Java 21, Allure, Selenium)
├── qa-e2e-automation-suite/    # End-to-End UI Automation (Selenium, TestNG)
├── qa-test-api/                # API & Database Automation (RestAssured, Hibernate, MySQL)
├── data-driven-framework/      # Data-Driven Testing Engine (Core Utilities)
├── qa-performance-tests/       # Performance and load testing (Roadmap)
└── qa-mobile-tests/            # Mobile test automation (Roadmap)
```

---

* * *

## Projects Overview

### 🆕 qa-ml-quality-engineering (Current Highlight)
Specialized framework for Quality Engineering in Machine Learning ecosystems.
* **Context:** Validation of a Credit Card Fraud Detection system.
* **Tech Stack:** Java 21, Maven, Selenium WebDriver 4, Allure Report, AssertJ.
* **Key Capabilities:** * **Data Integrity:** Validation of CSV datasets (schema, null values, and data types).
    * **Statistical Analysis:** Class distribution testing to ensure fraud/legitimate balance.
    * **UI/Data Consistency:** Selenium tests ensuring the Dashboard reflects the ML model results.
    * **Observability:** Advanced Allure integration with categories, severity levels, and rich attachments (logs and charts).
	
### qa-e2e-automation-suite
End-to-End test automation framework for web applications.
*   **Tech Stack:** Java, Maven, Selenium WebDriver, TestNG.
*   **Features:** Page Object Model (POM), explicit waits, parallel execution, ExtentReports integration, reusable components.

### qa-test-api
Comprehensive framework for testing RESTful APIs and performing database validations.
*   **Tech Stack:** Java, Maven, RestAssured, TestNG, Hibernate, MySQL.
*   **Features:** Fluent API validations, database state verification using Hibernate, global exception handling for API tests, data-driven testing.

### data-driven-framework
A robust, reusable core framework designed to power data-driven testing across all projects. This is the foundational engine for handling test data, configurations, reporting, and utilities.
*   **Tech Stack:** Java, Maven, Apache POI, TestNG, Log4j2, ExtentReports, ReportNG, JavaMail API.
*   **Core Capabilities:**
    *   **Data Management:** Excel readers/writers for test data, properties file handlers for configuration.
    *   **Reporting & Logging:** ExtentReports for rich HTML reports, ReportNG for TestNG integration, comprehensive logging with Log4j2.
    *   **Utilities:** Email modules for sending reports, ZIP archiving for historical reports, screenshot capture on failure.
    *   **Execution Control:** TestNG listeners for soft assertions and failure analysis, runmode controllers (smoke/sanity/regression), custom TestNG configurations.
    *   **Infrastructure:** Database connection utilities, Jenkins integration ready, parallel execution support.

* * *

## Technologies and Core Competencies

*   **Languages & Build:** Java, Maven
*   **Automation:** Selenium WebDriver, RestAssured
*   **Testing Frameworks:** TestNG, ReportNG
*   **Data Handling:** Apache POI (Excel), Properties Files
*   **Reporting:** ExtentReports, Log4j2/Logback
*   **Database:** MySQL, Hibernate (ORM), JDBC
*   **Utilities:** JavaMail API (Email), ZIP utilities, Screenshot capture
*   **Design Patterns:** Page Object Model (POM), Data-Driven Testing, Singleton (for utilities)
*   **DevOps & Tools:** Git, GitHub, Jenkins (CI/CD ready)
*   **Validation Layers:** UI, API, and Database with comprehensive test execution control

* * *

## Objectives

This repository serves to:
*   Demonstrate the ability to build and architect multi-layered test automation frameworks.
*   Apply industry best practices for code maintainability, readability, and reusability.
*   Showcase real-world testing scenarios, including API contract tests and database state validation.
*   Provide a professional portfolio that reflects senior-level QA automation engineering skills.
*   Serve as a continuous learning platform for evolving testing tools and strategies.

* * *

## Status

**Active Development** – Continuously evolving with new projects and improvements. The frameworks are designed to be extended and integrated into CI/CD pipelines.


## Author

Alexander
Computer Science Student
Game Development
QA Automation Engineer (in progress)