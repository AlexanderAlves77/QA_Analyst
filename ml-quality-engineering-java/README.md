# 📊 ML Quality Engineering - Data & UI Integrity

This project is a core component of my **SDET / Quality Engineering** portfolio, focusing on quality assurance for Machine Learning-driven systems. The practical scenario involves validating an automated Credit Card Fraud Detection engine.

## 🎯 Project Goals
Unlike conventional automation, this framework validates the data lifecycle:
1.  **Dataset Integrity:** Ensures the CSV source (test data) is healthy and properly formatted.
2.  **Statistical Consistency:** Verifies class distribution balance (Fraud vs. Legitimate transactions).
3.  **UI/Data Accuracy:** Ensures the Dashboard correctly reflects the processed ML model results using Selenium.

---

## 🛠️ Tech Stack
* **Language:** Java 21 (leveraging modern Streams API).
* **UI Automation:** Selenium WebDriver 4.38.
* **Testing Framework:** JUnit 5.
* **Assertions:** AssertJ (Fluent Assertions).
* **Observability & Reporting:** Allure Report.
* **Build Tool:** Maven.

---

## 🏗️ Test Architecture

### 1. Data Layer (`DataDistributionTest`)
* **Schema Validation:** Checks for the 31 critical columns (V1-V28, Amount, Class).
* **Fraud Analysis:** Logic-based verification to ensure the presence of fraudulent transactions (`Class 1`) in the dataset.
* **Evidence:** Automatic generation of distribution logs and PNG chart attachments directly into the report.

### 2. UI Layer (`MLDashboardUITest`)
* **Page Object Model (POM):** Encapsulation of UI logic for enhanced maintainability.
* **Screenshot on Action:** Automatic visual evidence capture at every critical validation step.

---

## 📊 Observability (Allure Report)
The framework is configured to generate rich reports for efficient debugging:
* **Custom Categories:** Clear distinction between "Data Issues" (CSV errors) and "UI Issues" (Selenium/Interface errors).
* **Severity Levels:** Identification of critical tests for CI/CD pipeline prioritization.

### How to generate the report:
1. Run tests: `mvn clean test`
2. Serve report: `allure serve target/allure-results`

---

## 🚀 Getting Started
1. Ensure **Java 21** and **Maven** are installed.
2. Clone the repository.
3. Place the `creditcard.csv` dataset in `src/test/resources/`.
4. Run via terminal or Eclipse (Run as Maven Test).

---

### 📈 Engineering Highlights
* **MLOps Mindset:** Quality applied to Data Science workflows.
* **Advanced Observability:** Technical dashboards for cross-functional stakeholders.
* **Clean Code:** Industry-standard design patterns applied to test automation.

---

## Author
Alexander
Computer Science Student
Game Development
QA Automation Engineer (in progress)