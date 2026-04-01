# 📌 QA Test API Project

## 📖 Overview

This project focuses on API testing and quality assurance practices, simulating real-world scenarios where a QA Analyst validates backend services.

The main goal is to ensure that API endpoints behave correctly, return expected responses, and handle edge cases properly.

This repository demonstrates:
- Automated API validation
- BDD (Behavior Driven Development) implementation
- Comprehensive test reporting
- Quality assurance mindset applied to backend systems

---

## 🎯 Objectives
* Validate API endpoints and responses
* Ensure data consistency and correctness
* Identify bugs and unexpected behaviors
* Document test scenarios for regression testing
* Improve overall API reliability

---

## 🧪 Testing Scope

The project covers:
* Functional API testing
* Request/response validation
* Status code verification
* Edge case analysis
* Negative testing scenarios

These activities are part of the Quality Assurance (QA) process, which ensures that software meets defined quality standards throughout its lifecycle

---

## 🎯 Technical Differentiators
* BDD with Cucumber: Scenario authoring using Gherkin syntax to ensure seamless alignment between business requirements and technical implementation.
* RestAssured Integration: Fluent validation of JSON payloads, HTTP headers, and response integrity.
* Allure Reporting: Dynamic report generation featuring detailed execution evidence and test history.
* Spring Boot Test Context: Full integration with the application context for robust, real-world integration testing.

---

## 🛠️ Tools & Technologies
- **Java 21**
- **Spring Boot 3.2.x** (Web, Data JPA, Validation)
- **RestAssured** (DSL for API testing)
- **Cucumber 7** (BDD Framework)
- **JUnit 5 / JUnit Platform Suite**
- **Allure Report** (Quality Dashboards)
- **Maven** (Dependency & Build Management)
- **AspectJweaver** (Instrumentation for detailed reports)

---

## 🚀 How to Run the Project
1. Clone the repository:
```bash
git clone [https://github.com/AlexanderAlves77/QA_Analyst.git](https://github.com/AlexanderAlves77/QA_Analyst.git)
```
2. Navigate to the project folder:
```bash
cd qa-test-api
```
3. Run Automated Tests:
```bash
mvn clean test
```
4. Generate and Open Allure Report:
```bash
mvn allure:serve
```

---

## 📋 Test Scenarios

The automated test suite covers:

* Positive Flows: Successful resource creation and data retrieval (HTTP 200/201).
* Validation Rules: Negative testing for mandatory fields and data formats (HTTP 400).
* Business Logic: Conflict handling for duplicate records (HTTP 409).
* Boundary Testing: Verification of input limits and edge cases.

---

## 🐞 Bug Reporting

All identified issues during testing are documented with:

* Description of the bug
* Steps to reproduce
* Expected result
* Actual result
* Evidence (logs and report screenshots)

---

## 🔁 Regression Testing

After bug fixes, regression testing should be performed to ensure that:

1. Existing features still work correctly
2. No new bugs were introduced 

---

## 💡 Future Improvements 

- [ ] Integrate with CI/CD pipelines (GitHub Actions)
- [ ] Implement Containerization (Docker)
- [ ] Add Performance/Load testing with JMeter
- [ ] Expand test coverage for security (OWASP API Top 10)

---

## Author
```
Alexander Alves
QA Automation Engineer | Quality Engineer
```

