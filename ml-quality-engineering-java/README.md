# 📊 ML Quality Engineering - Data & UI Integrity

This project is a Quality Engineering framework focused on validating data integrity, consistency, and reliability in Machine Learning systems.
It ensures that data pipelines, transformations, and outputs maintain high quality standards, supporting reliable decision-making and system stability.


## 🎯 Purpose
Machine Learning systems rely heavily on data quality. This framework was designed to:

- Validate input and output datasets
- Detect inconsistencies, anomalies, and missing values
- Ensure data integrity across processing stages
- Support automated validation for ML pipelines

---

## 🧱 Architecture

The project follows a modular and scalable architecture:
```
src/
├── data/ # Input datasets (CSV, Excel)
├── validators/ # Data validation logic
├── utils/ # Helper classes and utilities
├── tests/ # Test execution and validation scenarios
```

---

## 🛠️ Tech Stack
* **Language:** Java 21 (leveraging modern Streams API).
* **UI Automation:** Selenium WebDriver 4.38.
* **Testing Framework:** JUnit 5.
* **Assertions:** AssertJ (Fluent Assertions).
* **Observability & Reporting:** Allure Report.
* **Build Tool:** Maven.

---

## 🧪 Testing Strategy

The framework validates data using:

- ✅ Consistency checks (input vs output)
- ✅ Missing values detection
- ✅ Outlier identification
- ✅ Data integrity validation
- ✅ Business rule validation

---

## 🚀 How to Run

1. Clone the repository:
```
git clone https://github.com/AlexanderAlves77/QA_Analyst.git
cd ml-quality-engineering-java
mvn clean install
mvn test

```

---

## 📊 Key Features
- Data validation automation for ML systems
- Multi-layer validation approach
- Scalable and reusable structure
- Designed for integration with CI/CD pipelines

## 🔄 CI/CD Integration

This project is designed to be integrated into CI/CD pipelines to ensure continuous data validation during model execution and deployment.

## 📌 Use Cases
- Machine Learning data validation
- Data pipeline testing
- Data quality assurance
- Analytics and reporting validation

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
```
Alexander Alves
QA Automation Engineer | Quality Engineer
```