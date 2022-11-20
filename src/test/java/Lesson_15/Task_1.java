package Lesson_15;

/*  1 - Get rid of Thread.sleep() in your tests, use explicit waits instead.*/

import driver.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Task_1 {

        public static String EXPECTED_TEXT = "Персональний кабінет";
        private WebDriver driver;

        private WebDriverWait wait;

        @BeforeClass
        public void beforeClassActions() {

            driver = WebDriverRunner.getWebDriver();
            driver.get("https://butlers.ua/ua/");

        }

        @Test
        public void checkLoginTrue() throws InterruptedException {
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

            Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Персональний кабінет']")).getText(), EXPECTED_TEXT,
                    String.format("text should be displayed" + EXPECTED_TEXT));
            }

    }



