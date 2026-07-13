# UI Test Automation — Yandex Scooter

[![Java 11](https://img.shields.io/badge/Java-11-blue?logo=openjdk)](https://openjdk.org)
[![JUnit 4](https://img.shields.io/badge/JUnit-4.13.2-green?logo=junit5)](https://junit.org/junit4/)
[![Selenium](https://img.shields.io/badge/Selenium-4.29.0-orange?logo=selenium)](https://www.selenium.dev)
[![WebDriverManager](https://img.shields.io/badge/WebDriverManager-5.7.0-purple)](https://bonigarcia.dev/webdrivermanager/)
[![Maven](https://img.shields.io/badge/Maven-3-red?logo=apache-maven)](https://maven.apache.org)

Automated UI testing project for the **Yandex Scooter** web application.

The project demonstrates end-to-end browser automation using **Selenium WebDriver**, **JUnit 4**, and the **Page Object Model**. It covers the application's core user journeys, including order placement, FAQ verification, navigation, and form validation. The framework is designed to be maintainable, reusable, and easily extensible while supporting execution in multiple browsers.

---

## 🚀 Project Highlights

- End-to-end UI automation for a multi-page web application
- Page Object Model architecture
- Cross-browser execution (Chrome & Firefox)
- Parameterized tests with reusable test data
- Explicit waits instead of `Thread.sleep()`
- Shared test lifecycle via `BaseTest`
- Automatic browser driver management with WebDriverManager

---

## 🛠 Tech Stack

| Layer | Technology |
|:------|:-----------|
| Language | Java 11 |
| Test Framework | JUnit 4.13.2 |
| UI Automation | Selenium WebDriver 4.29.0 |
| Driver Management | WebDriverManager 5.7.0 |
| Assertions | Hamcrest |
| Build Tool | Maven |
| Design Pattern | Page Object Model |
| Browsers | Google Chrome, Mozilla Firefox |

---

## 🏗 Project Architecture

The project follows the **Page Object Model (POM)** design pattern, where every application page is represented by a dedicated Java class exposing business-level actions instead of low-level Selenium interactions.

A shared `BaseTest` class is responsible for browser initialization, common setup, cookie handling, page object creation, and driver cleanup, allowing test classes to remain concise and focused on business scenarios.

```
src/
├── main/java/Scooter/
│   ├── MainPageScooter.java
│   ├── OrderPageScooter.java
│   ├── RentPageScooter.java
│   ├── OrderConfirmationPage.java
│   ├── YandexMainPage.java
│   └── Urls.java
│
└── test/java/
    ├── BaseTest.java
    ├── OrderScooterTestsUpperButton.java
    ├── OrderScooterTestsLowerButton.java
    ├── ImportantQuestionsTest.java
    ├── ScooterLogoGoesToHomePage.java
    ├── YandexLogoGoesToYandexPage.java
    ├── WrongOrderNumberTest.java
    └── CheckErrorsInOrderForm.java
```

---

## 📋 Test Coverage

The project automates the following functionality:

- Order placement via the upper **Order** button
- Order placement via the lower **Order** button
- FAQ accordion verification using parameterized tests
- Navigation through the Scooter logo
- Navigation through the Yandex logo in a new browser tab
- Validation of incorrect order numbers
- Validation messages for mandatory order form fields

The suite combines positive, negative, and parameterized scenarios while keeping tests independent and reusable.

---

## ⚙ Engineering Features

- ✅ Page Object Model architecture
- ✅ Parameterized tests with JUnit 4
- ✅ Cross-browser execution
- ✅ Explicit waits (`WebDriverWait`)
- ✅ Soft assertions using `ErrorCollector`
- ✅ Browser window and tab switching
- ✅ JavaScript scrolling for off-screen elements
- ✅ Shared setup and teardown through `BaseTest`
- ✅ Automatic WebDriver configuration
- ✅ No usage of `Thread.sleep()`

---

## ▶ Running the Project

Run all tests (Chrome):

```bash
mvn clean test
```

Run with Firefox:

```bash
mvn clean test -Dbrowser=firefox
```

Run a single test class:

```bash
mvn test -Dtest=ImportantQuestionsTest
```

WebDriver binaries are downloaded and configured automatically by WebDriverManager.

---

## 📂 Project Structure

```
Sprint_4/
├── pom.xml
├── README.md
├── .gitignore
└── src/
    ├── main/
    │   └── java/
    │       └── Scooter/
    └── test/
        └── java/
```

---

## 💡 What This Project Demonstrates

- Selenium WebDriver automation
- Page Object Model implementation
- UI functional testing
- Cross-browser execution
- Explicit synchronization strategies
- Parameterized testing
- Form validation testing
- Browser navigation and window handling
- Java 11
- Maven project organization

---

## 📝 Notes

- The project focuses exclusively on **UI automation** and does not use REST Assured or backend APIs.
- Application URLs are centralized in the `Urls` class, making environment configuration straightforward.
- Synchronization relies entirely on explicit waits, improving test stability and avoiding fixed delays.
- The architecture is designed to simplify maintenance and future extension with new test scenarios.
