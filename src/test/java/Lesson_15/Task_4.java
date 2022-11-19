package Lesson_15;

/* 4 - Add test, that adds a product to basket and verifies that error is present on the page when you add too
 much quantities of this product. */

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

        System.setProperty("webdriver.chrome.driver", "C:\\chromeDriwer\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://butlers.ua/ua/");
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
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-productid='8567' ]")));
        product.click();
        WebElement buttonAddToBasket = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='add-to-cart-button-8567']")));
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
        fieldOfQuantityOfProducts.sendKeys("10", Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Максимальна кількість для покупки: 5.']")).isDisplayed());

    }

    @AfterClass(alwaysRun = true)
    public void closrDriver() {
        driver.close();
        driver.quit();
    }
}
