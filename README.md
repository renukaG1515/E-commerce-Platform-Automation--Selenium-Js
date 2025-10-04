<h1 align="center">🛒 SwagLabs E-commerce Automation</h1>
<p align="center">
  🚀 Selenium + Java | TestNG | Page Object Model | CI/CD Ready
</p>

---

## ✨ Overview

Automated testing framework for the [SwagLabs Demo Site](https://www.saucedemo.com/), designed using **Selenium WebDriver with Java**. This project provides a robust and scalable solution for automating core e-commerce functionalities such as:

- 🔐 Login (valid, invalid, locked-out)
- 🛍️ Product browsing and selection
- 🛒 Cart management
- 💳 Checkout process
- 📦 Order confirmation

---

## 🧰 Tech Stack

| 🔧 Tool           | 💡 Purpose                          |
|------------------|-------------------------------------|
| Java             | Core programming language           |
| Selenium WebDriver | Browser automation                 |
| TestNG / JUnit   | Testing framework                   |
| Maven / Gradle   | Build & dependency management       |
| Page Object Model (POM) | Clean and maintainable code    |
| ExtentReports / Allure | Reporting                      |
| Log4j / SLF4J    | Logging                             |
| Git & GitHub     | Version control                     |
| GitHub Actions / Jenkins | CI/CD                        |

---

## 📂 Project Structure

ecommerce-automation/
├── src/
│ ├── main/java/
│ │ ├── pages/ # Page Object classes
│ │ └── utils/ # Helpers (driver, waits, configs)
│ └── test/java/
│ ├── tests/ # Test cases
│ └── runners/ # Test runners
├── testng.xml # TestNG suite config
├── pom.xml # Maven configuration
└── README.md

---

## 🧪 Test Scenarios Covered

| 🧾 Test Case             | 🧠 Description                        |
|--------------------------|---------------------------------------|
| ✅ Login Tests           | Valid, invalid, locked-out user login |
| 📋 Inventory Page        | View products, sort, add to cart      |
| 🛒 Cart Operations       | Add/remove products, view cart        |
| 💰 Checkout Flow         | Checkout steps & validations          |
| 🚪 Logout Flow           | Session termination                   |
| ❌ Negative Scenarios    | Empty inputs, error messages          |

---

## ⚙️ Setup Instructions

### ✅ Prerequisites

- Java JDK 11 or later
- Maven or Gradle
- Chrome/Firefox browser
- Git
- IDE (e.g., IntelliJ, Eclipse)

### 📥 Clone the Repository

```bash
git clone [https://github.com/renukaG1515/E-commerce-Platform-Automation--Selenium-Js.git]
cd ecommerce-automation-swaglabs
🔨 Build the Project
mvn clean install

▶️ Run Tests
mvn test


Or run with a specific suite file:

mvn test -DsuiteXmlFile=testng.xml

📊 Reports & Logging

✅ TestNG Reports: Generated in test-output/

📸 Screenshots: Captured on failure in /screenshots/

📝 Logs: Logged in /logs/test-log.log

📈 Allure/Extent Reports: Optional integration available

🧩 Design Patterns & Practices

✅ Page Object Model (POM)

🔁 Reusable utility methods (driver, waits, logger)

📦 Config-driven design (config.properties)

📂 Data-driven tests (Excel/JSON supported)

🔐 SwagLabs Credentials
👤 Username: standard_user
🔑 Password: secret_sauce

🔒 Locked Out User:
👤 Username: locked_out_user
🔑 Password: secret_sauce

🚀 CI/CD Integration

Easily integrate with:

✅ GitHub Actions

✅ Jenkins
