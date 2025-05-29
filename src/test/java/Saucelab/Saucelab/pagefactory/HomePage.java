package Saucelab.Saucelab.pagefactory;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Step;

public class HomePage {
    WebDriver driver;

    By addToCart_btn = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//button");
    By removeBackPack_btn = By.id("remove-sauce-labs-backpack");
    By cart_lnk = By.className("shopping_cart_link");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Clicking 'Add to Cart' button")
    public void clickAddToCartBtn() {
        driver.findElement(addToCart_btn).click();
    }

    @Step("Navigating to Cart page")
    public void clickCartLnk() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    @Step("Verifying item added to cart")
    public void verifyAddToCartBtnClicked() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(removeBackPack_btn));
        Assert.assertTrue(driver.findElement(removeBackPack_btn).isDisplayed());
    }

    @Step("Verifying cart URL: {redirectedURL}")
    public void verifyCartLnkClicked(String redirectedURL) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(redirectedURL));
        Assert.assertEquals(driver.getCurrentUrl(), redirectedURL);
    }
} 
