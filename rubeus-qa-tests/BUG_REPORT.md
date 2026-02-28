# Rubeus QA Bug Report

This document contains the defects, usability issues, and improvement opportunities identified during the quality evaluation of the following applications:

* https://qualidade.apprbs.com.br/certificacao
* https://qualidade.apprbs.com.br/site

---

# Test Environment

Environment: QA
Browser: Google Chrome
OS: Windows 11
Resolution: 1920x1080
Execution Type: Manual and Automated Testing

---

# Defect Report

---

## Item 01 - Page title does not reflect application context

Type: Improvement
Classification: Desejabilidade
Priority: Low

Description:
The page title displayed in the browser tab is generic and does not clearly reflect the application name or purpose. This makes it difficult for users to identify the page when multiple tabs are open.

Expected Result:
The title should clearly identify the system, such as:
"Rubeus Certification Portal"

Actual Result:
Generic or unclear title is displayed.

Impact:
Reduces usability and professional appearance.

---

## Item 02 - Lack of loading indicator during page load

Type: Improvement
Classification: Usabilidade
Priority: Medium

Description:
When accessing the page, there is no loading indicator or visual feedback. Users may believe the system is not responding.

Expected Result:
A loading spinner or progress indicator should be displayed.

Actual Result:
No feedback is provided during loading.

Impact:
Creates uncertainty and reduces user confidence.

---

## Item 03 - No clear feedback after button interaction

Type: Correction
Classification: Utilidade
Priority: High

Description:
When clicking certain buttons, there is no confirmation, feedback, or visible action.

Expected Result:
System should display confirmation, navigate, or show feedback.

Actual Result:
No visible response.

Impact:
User cannot confirm if the action was successful.

---

## Item 04 - Poor visual hierarchy and spacing

Type: Improvement
Classification: Desejabilidade
Priority: Low

Description:
Some elements appear too close together, reducing readability and visual clarity.

Expected Result:
Consistent spacing and alignment.

Actual Result:
Crowded layout.

Impact:
Reduces readability and user experience.

---

## Item 05 - Missing validation feedback for invalid inputs

Type: Correction
Classification: Utilidade
Priority: High

Description:
When invalid data is entered, the system does not display validation messages.

Expected Result:
Clear validation message explaining the error.

Actual Result:
No feedback provided.

Impact:
User cannot understand the issue or correct input.

---

## Item 06 - No error handling for unexpected behavior

Type: Improvement
Classification: Usabilidade
Priority: Medium

Description:
System does not provide user-friendly error messages when failures occur.

Expected Result:
Clear and informative error messages.

Actual Result:
No error handling visible.

Impact:
Reduces usability and transparency.

---

# Test Evidence

Evidence generated automatically via automation framework:

* Screenshots: screenshots/
* Execution logs: logs/execution.log
* HTML Report: test-output/ExtentReport.html

---

# Automation Coverage

Automated tests validate:

* Page loading
* Navigation
* UI element presence
* Functional behavior
* Error detection

---

# Conclusion

The system is functional but contains several usability and feedback issues that should be addressed to improve the user experience and system reliability.

The automation framework successfully detects failures and generates professional evidence and reports.

---

# Author

Alexander
QA Automation Engineer
Computer Science Student
