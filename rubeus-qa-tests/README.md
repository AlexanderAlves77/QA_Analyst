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
* Automated evidence generation
* Professional QA report generation (PDF and Excel)
* Enterprise-level test architecture

---

# Technologies Used

| Technology         | Purpose                         |
| ------------------ | ------------------------------- |
| Java 21            | Programming language            |
| Maven              | Build and dependency management |
| Selenium WebDriver | Browser automation              |
| JUnit 5            | Test execution framework        |
| WebDriverManager   | Automatic driver management     |
| ExtentReports      | Professional HTML reporting     |
| Log4j2             | Execution logging               |
| Eclipse IDE        | Development environment         |
| Apache POI         | Excel report generation         |
| iText PDF          | PDF report generation           |
| Git & GitHub       | Version control                 |


---

# Framework Architecture

This automation framework follows enterprise-level design patterns and best practices.

## Architecture Components

rubeus-qa-tests/
│
├── src/
│   ├── main/java/com/rubeus/qa/
│   │
│   │   ├── base/
│   │   │   └── BaseTest.java
│   │   │
│   │   ├── config/
│   │   │   └── ConfigManager.java
│   │   │
│   │   ├── pages/
│   │   │   ├── BasePage.java
│   │   │   ├── SitePage.java
│   │   │   └── CertificacaoPage.java
│   │   │
│   │   ├── report/
│   │   │   ├── ExtentManager.java
│   │   │   ├── ExtentTestManager.java
│   │   │   └── QAReportGenerator.java
│   │   │
│   │   └── utils/
│   │       ├── LoggerManager.java
│   │       ├── LoggerUtils.java
│   │       └── TestUtils.java
│   │
│   └── test/java/com/rubeus/qa/tests/
│       ├── SiteTest.java
│       └── CertificacaoTest.java
│
├── screenshots/
├── reports/
├── logs/
├── test-output/
└── pom.xml


---

# Features Implemented

## Automated UI Testing

* Page accessibility
* Page load success
* URL correctness
* Title validation
* Content validation
* Functional stability

## Automatic Screenshot Capture

Screenshots are automatically captured when a test fails.

```
screenshots/
   2026-03-02/
      SiteTest_validateSitePage_success_2026-03-02_14-32-10.png
```

---

## Automatic QA Report Generation (PDF and Excel)

After test execution, structured QA reports are automatically generated:
```
reports/
   QA_Report.pdf
   QA_Report.xlsx
```

These reports include:
- Page name
- Issue or validation item
- Type (Correction, Improvement, New Feature)
- Classification (Utility, Usability, Desirability)
- Priority (High, Medium, Low)
- Detailed description
- Screenshot evidence

This format follows the exact reporting requirements specified by Rubeus.
   

---

## Professional HTML Reporting (ExtentReports)

After execution, a professional report is generated:

```
test-output/
   ExtentReport_YYYY-MM-DD_HH-mm-ss.html
```

The report includes:

* Test execution status
* PASS / FAIL results
* Error details
* Screenshots
* Execution timeline

---

## Execution Logging (Log4j2)

All framework activities are logged:

```
logs/
   execution.log
```

Example:

```
2026-03-02 14:32:10 [INFO] Starting test: SiteTest - validateSitePage
2026-03-02 14:32:15 [INFO] Browser started successfully
2026-03-02 14:32:20 [INFO] Browser closed
```

---

# Test Automation Strategy

This framework follows industry-standard best practices:
- Page Object Model (POM)
- Base Test abstraction
- Automatic screenshot capture
- Automatic PDF and Excel report generation
- Professional HTML reporting
- Structured logging
- Clean architecture
- Scalable and maintainable design
- Enterprise-grade automation structure

---

Evidence Generated

After execution, the following artifacts are available:
```
screenshots/
reports/
logs/
test-output/
```

---

# Requirements

Before running the tests, install:

* Java 21 or higher
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

# Expected Output After Execution
```
screenshots/
reports/
   QA_Report.pdf
   QA_Report.xlsx
logs/
test-output/
   ExtentReport.html
```

---

# Quality Engineering Practices Demonstrated

This project demonstrates professional QA engineering capabilities including:

* Automated UI testing
* Automated evidence generation
* Structured bug reporting
* Professional PDF and Excel report generation
* Automation framework architecture
* Failure diagnostics support
* Logging and traceability
* Clean code and maintainable design

---

# Author
```
Alexander
Computer Science Student
QA Automation Engineer
Java Developer
Game Developer

GitHub: https://github.com/alexanderalves77
```

---

# Final Notes

This framework was designed to simulate a real-world enterprise QA automation environment and fully complies with the reporting and validation requirements defined in the Rubeus Quality Analyst selection process.