# 📊 Data-driven Framework

This project is a Data-Driven Test Automation Framework designed to execute automated tests using external data sources, improving test coverage, scalability, and maintainability.
It enables running the same test logic with multiple input datasets, reducing code duplication and increasing efficiency in test execution.



## 🎯 Purpose
The main goal of this framework is to:

- Separate test logic from test data
- Enable scalable execution of multiple test scenarios
- Improve maintainability and reusability of automated tests
- Support dynamic and flexible test execution

---

## 🧱 Architecture

The project follows a modular and scalable architecture:
```
src/
├── tests/ # Test cases and execution logic
├── data/ # External test data (Excel, CSV)
├── utils/ # Utility classes (data readers, helpers)
├── core/ # Framework engine and execution control
```

---

## 🛠️ Tech Used

- Java
- Selenium WebDriver
- TestNG
- Apache POI (Excel handling)
- Maven

---

## 🧪 Testing Strategy

This framework is based on Data-Driven Testing principles:

- ✅ Externalized test data (Excel/CSV)
- ✅ Multiple scenarios executed with the same test logic
- ✅ Parameterized test execution
- ✅ Dynamic data handling

---

## 🚀 How to Run

1. Clone the repository:
```
git clone https://github.com/AlexanderAlves77/QA_Analyst.git
cd data-driven-framework
mvn clean install
mvn test

```

---

## 📊 Key Features
- Reusable test execution engine
- External data integration (Excel/CSV)
- Scalable test scenarios
- Reduced code duplication
- Easy maintenance and extension

## 🔄 CI/CD Integration

The framework is designed to be integrated into CI/CD pipelines, enabling automated execution and continuous validation.

## 📌 Use Cases
- Regression testing with multiple datasets
- Form validation testing
- API parameter testing
- Scenario variation testing

---

## Author
```
Alexander Alves
QA Automation Engineer | Quality Engineer
```