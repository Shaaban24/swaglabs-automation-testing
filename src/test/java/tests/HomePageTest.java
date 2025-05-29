package tests;

import java.util.Map;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import Saucelab.Saucelab.pagefactory.HomePage;
import Saucelab.Saucelab.pagefactory.LoginPage;

import io.qameta.allure.*;

@Listeners({ io.qameta.allure.testng.AllureTestNg.class })
public class HomePageTest {
    WebDriver driver;
    LoginPage login;
    HomePage homepage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://Users//ZBOOK//eclipse-workspace//Saucelab//src//test//java//Saucelab//Saucelab//chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
    }

    @Test(description = "Positive add to cart test")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User adds product to cart after login")
    public void positiveAddToCartScenario() {
        login = new LoginPage(driver);
        homepage = new HomePage(driver);

        login.typeUsername("standard_user");
        login.verifyUsername("standard_user");
        login.typePassword("secret_sauce");
        login.verifyPassword("secret_sauce");
        login.clickLogin();
        login.verifyLogin("https://www.saucedemo.com/inventory.html");

        homepage.clickAddToCartBtn();
        homepage.verifyAddToCartBtnClicked();
        homepage.clickCartLnk();
        homepage.verifyCartLnkClicked("https://www.saucedemo.com/cart.html");
    }

    @AfterClass
    public void terminate() {
      //  driver.quit();
    }
} 
