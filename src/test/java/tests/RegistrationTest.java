package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegistrationPage;

import java.lang.reflect.Method;

public class RegistrationTest {

    private WebDriver driver;
    private RegistrationPage registrationPage;

    @BeforeClass(alwaysRun = true)
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromeDriwer\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://butlers.ua/ua/");
        registrationPage = new RegistrationPage(driver);

    }

    @BeforeMethod
    private void beforeMethodActions(Method method) {
        WebElement loginButton = driver.findElement(By.xpath("//*[@class = 'ico-login']"));
        loginButton.click();
        WebElement registrationButton = driver.findElement(By.xpath("//*[@value = 'Зареєструватися']"));
        registrationButton.click();
    }

    @Test
    public void checkingForIncorrectInputName() throws InterruptedException {
    registrationPage.enterWithNoName();
        Assert.assertTrue(registrationPage.errorNameMassageShown("Ім'я обов'язкове."));
    }

    @Test
    public void checkingForIncorrectInputLastName() throws InterruptedException {
        registrationPage.enterWithNoLastName();
        Assert.assertTrue(registrationPage.errorLastNameMassageShown("Прізвище обов'язкове."));
    }

    @Test
    public void checkingForIncorrectInputEmail() throws InterruptedException {
        registrationPage.enterWithNoEmail();
        Assert.assertTrue(registrationPage.errorEmailMassageShown("Електронна пошта обов'язкова."));
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        driver.close();
        driver.quit();
    }

}
