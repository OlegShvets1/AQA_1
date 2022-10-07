package Lesson_14.Task_1;

/*  1 - зробити 3 негативних тести на формі реєстрації*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Registration_Negative_Tests {


    public static String EXPECTED_TEXT_1 = "Прізвище обов'язкове.";

    public static String EXPECTED_TEXT_2 = "Невірне повідомлення електронної пошти";
    public static String EXPECTED_TEXT_3 = "Ім'я обов'язкове.";
    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeClass
    public void beforeClassActions() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\chromeDriwer\\chromedriver.exe");
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
        driver.navigate().to("https://butlers.ua/ua/");
        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.xpath("//*[@class = 'ico-login']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement registrationButton = driver.findElement(By.xpath("//*[@value = 'Зареєструватися']"));
        registrationButton.click();
        Thread.sleep(2000);

    }

    @Test
    public void introductionLastName() throws InterruptedException {

        WebElement userLastNameField = driver.findElement(By.xpath("//*[@name= 'LastName']"));
        userLastNameField.clear();
        userLastNameField.sendKeys("");
        softAssert.assertEquals(driver.findElement(By.xpath("//*[@class = 'field-validation-error']")).getText(), EXPECTED_TEXT_1,
                String.format("text should be displayed" + EXPECTED_TEXT_1));
    }

    @Test
    public void introductionEmail() throws InterruptedException {

        WebElement userEmailField = driver.findElement(By.xpath("//*[@name= 'Email']"));
        userEmailField.clear();
        userEmailField.sendKeys("12345678");
        Thread.sleep(2000);
        softAssert.assertEquals(driver.findElement(By.xpath("//*[@data-val-email='Невірне повідомлення електронної пошти']")).getText(), EXPECTED_TEXT_2,
                String.format("text should be displayed" + EXPECTED_TEXT_2));
    }

    @Test
    public void introductionPassword() throws InterruptedException {
        WebElement userPasswordField = driver.findElement(By.xpath("//*[@name='FirstName']"));
        userPasswordField.click();
        userPasswordField.sendKeys("");
        softAssert.assertEquals(driver.findElement(By.xpath("//span[@data-valmsg-for='FirstName']")).getText(), EXPECTED_TEXT_3,
                String.format("text should be displayed" + EXPECTED_TEXT_3));
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver1() {
        driver.close();}

}



