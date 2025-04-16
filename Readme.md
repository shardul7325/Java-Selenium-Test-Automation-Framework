
# Java-Selenium Test Automation Framework

This is a Java-Selenium based Test Automation Framework designed for scalability, maintainability, and ease of use.

It supports data-driven testing, cloud execution via LambdaTest, headless browser testing, and generates detailed reports and logs.


## 🚀 About Me
Hi, my name is Shardul Pakhare and I have more than 3 years of experience in Automation Testing using technologies like Selenium WebDriver and Rest Assured.

My major expertise is in Java programming language and automating desktop web applications.


## Author

- [@shardul7325](https://github.com/shardul7325)
- EmailAddress: shardulpakhare2512@gmail.com

## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/shardul7325)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](www.linkedin.com/in/shardul-pakhare-a593b0170)
## Prerequisites

Before  running this framework, ensure the following software is installed on your system:

- **Java 11** - Make sure Java 11 is installed and the JAVA_HOME variable is set.
- **Maven** - Ensure maven is installed and added to the system path.
    Download link - https://maven.apache.org/download.cgi
- **Git** (if cloning from repo)
- **IDE** like IntelliJ IDEA / Eclipse (optional)

## 🧪 Test Data Support
This framework supports data-driven testing via:

- CSV files (using OpenCSV)
- Excel files (using Apache POI)
- JSON files (using Gson)

Test data is stored in the testData/ directory.

## 🌐 LambdaTest Integration
If you choose to run tests on LambdaTest (isLambdaTest=true), make sure your credentials are set correctly. You can manage these via environment variables or a config file.

You will need:
- LambdaTest Username
- LambdaTest Access Key

These are typically passed or stored securely and injected at runtime.

## 📊 Reports and Logs
**ExtentReports** - Test execution results are generated in HTML format.
- Output: ./extent-reports/report.html

**Log4j Logs** - Logs for each test run are saved in the logs/ directory.
- Output: ./logs/automation.log

These provide detailed insights into test execution and can be used for debugging and validation.

## 🔧 Additional Features
- **Headless Mode Support** - Run tests without opening the browser UI.

- **Fake Data Generation** - Use Faker to generate dynamic test data on the fly.

- **Parameterized Execution** - Easily control execution flow using Maven CLI parameters.

## 🛠️ Tech Stack

- **Java 11**
- **TestNG** - Testing framework
- **OpenCSV** - For reading CSV test data
- **Apache POI** - For reading Excel files
- **Gson** - For JSON parsing
- **Faker** - For generating fake data
- **Maven** - Build tool & dependency management
- **ExtentReports** - For test reports
- **Log4j** - For logging
- **LambdaTest** - For cloud-based test execution
- **Selenium WebDriver** - For browser automation
## Setup Instructions

**Clone the repository:**

```bash
    git clone https://github.com/shardul7325/Java-Selenium-Test-Automation-Framework.git

    cd Java-Selenium-Test-Automation-Framework
```

## 🚀 How to Run Tests
**Run via Maven (Command Line)**

```bash
    mvn test -X -Dbrowser=<browser> -DisLambdaTest=<true|false> -DisHeadless=<true|false>
```

Parameters:
- browser: Name of the browser to run tests on. (e.g., chrome, firefox)

- isLambdaTest: Set to true to run tests on LambdaTest cloud, false to run locally.

- isHeadless: Set to true to run tests in headless mode for faster execution.

Example:
```bash
    mvn test -X -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true
```

## Integrated the project with Github Actions
This automation framework is integrated with github Actions.
The tests will be executed at 23:30 IST every single day.

The reports will be archived in gh-pages branch.
You can view the html reports at:
https://shardul7325.github.io/Java-Selenium-Test-Automation-Framework/report.html


    
