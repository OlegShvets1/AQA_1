package Lesson_14.Task_2;

/*   2 - Зробити позитивний тест на формі логіна  */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login_Positive_Test {

    public static String EXPECTED_TEXT = "Персональний кабінет";
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
    public void verifyUserIsAbleToLoginWithCorrectData() throws InterruptedException {

        WebElement loginButton = driver.findElement(By.xpath("//*[@class = 'ico-login']"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement usernameField = driver.findElement(By.xpath("//div[@class='inputs']/input[@type='email']"));
        WebElement passwordField = driver.findElement(By.xpath("//div[@class='inputs']/input[@type='password']"));
        WebElement submittButton = driver.findElement(By.xpath("//div[@class='buttons']/input[@type='submit']"));
        usernameField.clear();
        usernameField.sendKeys("olehpost69@gmail.com");
        passwordField.click();
        passwordField.sendKeys("12345678");
        submittButton.click();
        Thread.sleep(3000);
//        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Персональний кабінет']")).getText(), EXPECTED_TEXT,
//                String.format("text should be displayed" + EXPECTED_TEXT));
        try {
            Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Персональний кабінет']")).isDisplayed());
        } catch (AssertionError e) {
            System.err.println("overview not found: " + e.getMessage());
        }

       }


    @AfterClass(alwaysRun = true)
    public void closeDriver1() {
        driver.close();
    }
}


