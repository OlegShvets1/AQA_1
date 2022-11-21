package Lesson_15;

/* 4 - Add test, that adds a product to basket and verifies that error is present on the page when you add too
 much quantities of this product. */

import driver.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task_4 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void beforeClassActions() {

        driver = WebDriverRunner.getWebDriver();
        driver.get("https://butlers.ua/ua/");
        WebElement loginButton = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Вхід']")));
        loginButton.click();
        WebElement usernameField = driver.findElement(By.xpath("//div[@class='inputs']/input[@type='email']"));
        WebElement passwordField = driver.findElement(By.xpath("//div[@class='inputs']/input[@type='password']"));
        WebElement submittButton = driver.findElement(By.xpath("//div[@class='buttons']/input[@type='submit']"));
        usernameField.clear();
        usernameField.sendKeys("olehpost69@gmail.com");
        passwordField.click();
        passwordField.sendKeys("12345678");
        submittButton.click();
        WebElement newButton = driver.findElement(By.xpath("//a[@href='/ua/all'][1]"));
        newButton.click();
        WebElement product = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-productid='8654' ]")));
        product.click();
        WebElement buttonAddToBasket = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='add-to-cart-button-8654']")));
        buttonAddToBasket.click();
        WebElement basket = new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Кошик для покупок']")));
        basket.click();


    }

    @Test
    public void verifyaVailabilityOfErrorIfAddsToMuchOfProduct() throws InterruptedException {
        WebElement fieldOfQuantityOfProducts = driver.findElement(By.xpath("//*[@class='qty-input']"));
        fieldOfQuantityOfProducts.click();
        fieldOfQuantityOfProducts.clear();
        fieldOfQuantityOfProducts.sendKeys("100", Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='message-error']")).isDisplayed(),String.format("%s text should be displayed", "Максимальна кількість для покупки: 12."));

    }

}
