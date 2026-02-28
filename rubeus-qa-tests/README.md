# Rubeus QA Automation Tests

This repository contains automated and manual quality assurance tests developed for the Quality Analyst Junior selection process at Rubeus.

---

# Objective

The purpose of this project is to evaluate the functionality, usability, stability, and overall quality of the following web applications:

* https://qualidade.apprbs.com.br/certificacao
* https://qualidade.apprbs.com.br/site

This project demonstrates professional skills in:

* Software Quality Assurance
* Automated UI Testing
* Test Automation Framework Design
* Bug identification and reporting
* Evidence generation and reporting
* Enterprise-level test architecture

---

# Technologies Used

| Technology         | Purpose                         |
| ------------------ | ------------------------------- |
| Java 17            | Programming language            |
| Maven              | Build and dependency management |
| Selenium WebDriver | Browser automation              |
| JUnit 5            | Test execution framework        |
| WebDriverManager   | Automatic driver management     |
| ExtentReports      | Professional HTML reporting     |
| Log4j2             | Execution logging               |
| Eclipse IDE        | Development environment         |
| Git & GitHub       | Version control                 |

---

# Framework Architecture

This automation framework follows enterprise-level design patterns and best practices.

## Architecture Components

```
src/test/java/com/rubeus/qa/

base/
   BaseTest.java
   BasePage.java

tests/
   CertificacaoTest.java
   SiteTest.java

pages/
   CertificacaoPage.java
   SitePage.java

utils/
   TestUtils.java
   LoggerManager.java

report/
   ExtentManager.java
   ExtentTestManager.java

extensions/
   ScreenshotExtension.java
```

---

# Features Implemented

## Automated UI Testing

* Page load validation
* Navigation testing
* UI element validation
* Functional behavior testing
* Form interaction testing

## Automatic Screenshot Capture

Screenshots are automatically captured when a test fails.

```
screenshots/
   2026-02-28/
      SiteTest_accessHomePage_2026-02-28_16-32-10.png
```

---

## Professional HTML Reporting (ExtentReports)

After execution, a professional report is generated:

```
test-output/
   ExtentReport_YYYY-MM-DD_HH-mm-ss.html
```

The report includes:

* Test execution status (PASS / FAIL)
* Error details
* Execution time
* Screenshot evidence
* Logs

---

## Execution Logging (Log4j2)

All execution events are logged automatically:

```
logs/
   execution.log
```

Example:

```
2026-02-28 16:32:10 [INFO] Starting test: SiteTest - accessHomePage
2026-02-28 16:32:15 [INFO] Browser started
2026-02-28 16:32:20 [INFO] Browser closed
```

---

# Test Automation Strategy

This framework follows industry best practices:

* Page Object Model (POM)
* Base test class abstraction
* Automatic screenshot capture on failure
* Professional HTML reporting
* Structured logging
* Reusable components
* Clean architecture
* Maintainable and scalable design

---

# Requirements

Before running the tests, install:

* Java 17 or higher
* Maven
* Google Chrome
* Eclipse IDE (recommended)
* Git

---

# How to Run Tests

## Using Eclipse

Right click project
Run As → Maven test
or
Right click test class
Run As → JUnit Test

---

## Using Maven command line

```
mvn clean test
```

---

# Test Evidence Generated

After execution, the following artifacts are automatically generated:

```
screenshots/
test-output/
logs/
```

These provide complete traceability and debugging capability.

---

# Quality Engineering Practices Demonstrated

This project demonstrates professional QA engineering capabilities including:

* Test automation framework development
* Automated evidence generation
* Failure analysis support
* Professional reporting
* Logging and traceability
* Clean code practices
* Scalable architecture design

---

# Author

Alexander
Computer Science Student
QA Automation Engineer
Game Developer

GitHub: https://github.com/alexanderalves77
