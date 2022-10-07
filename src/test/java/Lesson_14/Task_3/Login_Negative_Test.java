package Lesson_14.Task_3;

/*  3  - Зробити негативний тест на формі логіна */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login_Negative_Test {

    public static String EXPECTED_TEXT = "Вхід не вдалося. Виправте помилки та повторіть спробу.";
    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeClass
    public void beforeClassActions() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\chromeDriwer\\chromedriver.exe");
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
        driver.navigate().to("https://butlers.ua/ua/");
        Thread.sleep(2000);


    }

    @Test
    public void login_With_Wrong_Email() throws InterruptedException {

        WebElement loginButton = driver.findElement(By.xpath("//*[@class = 'ico-login']"));
        Thread.sleep(2000);
        loginButton.click();


        WebElement usernameField = driver.findElement(By.xpath("//div[@class='inputs']/input[@type='email']"));
        WebElement passwordField = driver.findElement(By.xpath("//div[@class='inputs']/input[@type='password']"));
        WebElement submittButton = driver.findElement(By.xpath("//div[@class='buttons']/input[@type='submit']"));
        usernameField.clear();
        usernameField.sendKeys("olehpost96@gmail.com");
        passwordField.click();
        passwordField.sendKeys("12345678");
        submittButton.click();
        Thread.sleep(2000);
        softAssert.assertEquals(driver.findElement(By.xpath("//*[@class = 'message-error validation-summary-errors']")).
                        getText(), EXPECTED_TEXT,
                String.format("text should be displayed" + EXPECTED_TEXT));


    }

    @AfterClass(alwaysRun = true)
    public void closeDriver1() {
        driver.close();
    }

}
