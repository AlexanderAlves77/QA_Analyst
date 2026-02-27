# Rubeus QA Automation Tests

This repository contains automated and manual quality assurance tests developed for the Quality Analyst Junior selection process at Rubeus.

---

# Objective

The purpose of this project is to evaluate the functionality, usability, and overall quality of the following web applications:

- https://qualidade.apprbs.com.br/certificacao
- https://qualidade.apprbs.com.br/site

This project demonstrates skills in:

- Software Quality Assurance
- Automated UI Testing
- Test Automation using Java and Selenium
- Bug identification and reporting
- Test organization and best practices

---

# Technologies Used

| Technology | Purpose |
|----------|---------|
| Java 17 | Programming language |
| Maven | Dependency management and build tool |
| Selenium WebDriver | Browser automation |
| JUnit 5 | Test framework |
| WebDriverManager | Automatic driver management |
| Eclipse IDE | Development environment |
| Git & GitHub | Version control |

---

# Project Structure

rubeus-qa-tests/
│
├── src/
│ └── test/
│ └── java/
│ └── com/
│ └── rubeus/
│ └── qa/
│ ├── base/
│ ├── tests/
│ └── utils/
│
├── pom.xml
├── README.md
└── .gitignore


---

# Test Coverage

This project includes automated tests for:

- Page loading validation
- Navigation testing
- Button interaction testing
- Form validation testing
- UI element verification
- Functional behavior validation

---

# Automation Strategy

The test automation framework follows best practices including:

- Base test class for WebDriver setup and teardown
- Reusable components
- Clean and maintainable code structure
- Automated driver management
- Isolated and independent test execution

---

# Requirements

Before running the tests, ensure the following are installed:

- Java 17 or higher
- Maven
- Google Chrome browser
- Eclipse IDE (recommended)

---

# How to Run Tests

## Option 1 — Using Eclipse

Right click on project  
Run As → Maven test  

or  

Right click on test class  
Run As → JUnit Test  

---

## Option 2 — Using Maven command line

mvn clean test 

---

## Author

Alexander
Computer Science Student
Game Development
QA Automation Engineer (in progress)