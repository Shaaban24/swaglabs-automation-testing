# Sauce Test Automation

Test automation project for [Sauce](https://www.saucedemo.com), using:

- Selenium WebDriver  
- TestNG  
- Allure Reports  
- Maven  
- Page Object Model design

## Project Structure

```
Saucelab/
├── src/
│   └── test/
│       ├── java/
│       │   ├── tests/
│       │   │   ├── LoginTest.java
│       │   │   └── HomePageTest.java
│       │   └── Saucelab/Saucelab/pagefactory/
│       │       ├── LoginPage.java
│       │       └── HomePage.java
│
├── pom.xml
```

## How to Run

1. Install Java (17+) and Maven  
2. Install Chrome and download a compatible [ChromeDriver](https://chromedriver.chromium.org/)  
3. Add ChromeDriver path to `LoginTest` and `HomePageTest`  
4. Run tests:

```bash
mvn clean test
```

5. Generate Allure Report:

```bash
allure serve target/allure-results
```

## Test Scenarios

- ✅ Valid login  
- ✅ Add item to cart  
- ✅ Navigate to cart and verify item  

## Dependencies

- Selenium `4.27.0`  
- TestNG `7.4.0`  
- Allure `2.29.1`  
- Maven Surefire Plugin  

## Author

Your Name
