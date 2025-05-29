package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import Saucelab.Saucelab.pagefactory.LoginPage;
import io.qameta.allure.*;

@Listeners({ io.qameta.allure.testng.AllureTestNg.class })
public class LoginTest {
    WebDriver driver;
    LoginPage login;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://Users//ZBOOK//eclipse-workspace//Saucelab//src//test//java//Saucelab//Saucelab//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        login = new LoginPage(driver);
    }

    @Test(description = "Positive login test")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User logs in with valid credentials")
    public void positiveLoginScenario() {
        login.typeUsername("standard_user");
        login.verifyUsername("standard_user");
        login.typePassword("secret_sauce");
        login.verifyPassword("secret_sauce");
        login.clickLogin();
        login.verifyLogin("https://www.saucedemo.com/inventory.html");
    }

    @AfterClass
    public void terminate() {
        driver.quit();
    }
}
