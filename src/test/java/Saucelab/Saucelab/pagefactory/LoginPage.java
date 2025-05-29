package Saucelab.Saucelab.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.qameta.allure.Step;

public class LoginPage {
    WebDriver driver;

    By username_txtfield = By.id("user-name");
    By password_txtfield = By.id("password");
    By login_btn = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Typing username: {username}")
    public void typeUsername(String username) {
        driver.findElement(username_txtfield).sendKeys(username);
    }

    @Step("Typing password: {password}")
    public void typePassword(String password) {
        driver.findElement(password_txtfield).sendKeys(password);
    }

    @Step("Clicking login button")
    public void clickLogin() {
        driver.findElement(login_btn).click();
    }

    @Step("Verifying typed username: {username}")
    public void verifyUsername(String username) {
        Assert.assertEquals(driver.findElement(username_txtfield).getDomProperty("value"), username);
    }

    @Step("Verifying typed password: {password}")
    public void verifyPassword(String password) {
        Assert.assertEquals(driver.findElement(password_txtfield).getDomProperty("value"), password);
    }

    @Step("Verifying redirect to: {redirectedURL}")
    public void verifyLogin(String redirectedURL) {
        Assert.assertEquals(driver.getCurrentUrl(), redirectedURL);
    }
} 
