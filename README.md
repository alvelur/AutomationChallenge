# AutomationChallenge

This project contains automated tests using Selenium for UI testing and RestAssured for API testing. It also includes integration with Allure for report generation.

## Requirements

- Java 11 or higher
- Maven

## Setup

1. Clone this repository:

```bash
git clone https://github.com/alvelur/PrediktiveChallenge.git
 ```

## Running Tests

To run all tests, use the following Maven command:

```bash
mvn clean test
```

This will execute the tests defined in the project.

## Generating Allure Reports

1. **Run the tests to generate Allure results:**
   ```bash
   mvn clean test
   ```

2. **Generate the Allure report:**
   ```bash
   mvn allure:report
   ```

3. **Serve the report on a local server:**
   ```bash
   mvn allure:serve
   ```

This will open a server in your browser where you can view the generated report.
