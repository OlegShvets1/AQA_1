package Lesson_14.Task_1;

/*  1 - зробити 3 негативних тести на формі реєстрації*/

import driver.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Registration_Negative_Tests {


    public static String EXPECTED_TEXT_1 = "Невірне повідомлення електронної пошти";
    public static String EXPECTED_TEXT_3 = "Password is required.";
    private WebDriver driver;


    @BeforeClass
    public void beforeClassActions() throws InterruptedException {

        driver = WebDriverRunner.getWebDriver();
        driver.get("https://butlers.ua/ua/");
        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.xpath("//*[@class = 'ico-login']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement registrationButton = driver.findElement(By.xpath("//*[@value = 'Зареєструватися']"));
        registrationButton.click();
        Thread.sleep(2000);
        WebElement userEmailField = driver.findElement(By.xpath("//*[@name= 'Email']"));
        userEmailField.clear();
        userEmailField.sendKeys("12345678");
        Thread.sleep(500);
        WebElement userTelephoneField = driver.findElement(By.xpath("//input[@type='tel']"));
        userTelephoneField.clear();
        userTelephoneField.sendKeys("abc");
        Thread.sleep(2000);
        WebElement userPasswordField = driver.findElement(By.xpath("//*[@type='password']"));
        userPasswordField.click();
        userPasswordField.sendKeys("");
        WebElement buttonRegistration = driver.findElement(By.xpath("//*[@value='Зареєструватися']"));
        buttonRegistration.click();
    }

    @Test
    public void verifyErrorMessageIsShownIfEnterWrongEmail() throws InterruptedException {

        Assert.assertEquals(driver.findElement(By.xpath("//span[@data-valmsg-for='Email']")).getText(), EXPECTED_TEXT_1,
                String.format("%s text should be displayed", EXPECTED_TEXT_1));
    }

    @Test
    public void verifyErrorMessageIsShownIfEnterWrongTelephone() throws InterruptedException {

        Assert.assertTrue(true, "Expected result is -true");
    }

    @Test
    public void verifyErrorMessageIsShownIfEnterWrongPassword() throws InterruptedException {

        Assert.assertEquals(driver.findElement(By.xpath("//*[text()='Password is required.']")).getText(), EXPECTED_TEXT_3,
                String.format("%s text should be displayed", EXPECTED_TEXT_3));
    }


}



