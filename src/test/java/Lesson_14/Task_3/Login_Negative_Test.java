package Lesson_14.Task_3;

/*  3  - Зробити негативний тест на формі логіна */

import driver.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Login_Negative_Test {

   private WebDriver driver;

    @BeforeClass
    public void beforeClassActions() throws InterruptedException {

        driver = WebDriverRunner.getWebDriver();
        driver.get("https://butlers.ua/ua/");
        Thread.sleep(2000);


    }

    @Test
    public void loginWithWrongEmail() throws InterruptedException {
        WebElement loginButton = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class = 'ico-login']")));
         loginButton.click();


        WebElement usernameField = driver.findElement(By.xpath("//div[@class='inputs']/input[@type='email']"));
        WebElement passwordField = driver.findElement(By.xpath("//div[@class='inputs']/input[@type='password']"));
        WebElement submitButton = driver.findElement(By.xpath("//div[@class='buttons']/input[@type='submit']"));
        usernameField.clear();
        usernameField.sendKeys("olehpost96@gmail.com");
        passwordField.click();
        passwordField.sendKeys("12345678");
        submitButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ico-login']")).isDisplayed());

    }


}
