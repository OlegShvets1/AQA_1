package tests;

import driver.WebDriverRunner;
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
        driver = WebDriverRunner.getWebDriver();
        driver.get("https://butlers.ua/ua/");
        registrationPage = new RegistrationPage(driver);

    }
    @BeforeMethod
    private void beforeMethodActions(Method method) {
        if (method.getName().equalsIgnoreCase("checkingForIncorrectInputName"))
            driver.navigate().to("https://butlers.ua/ua/register?returnUrl=%2Fua%2F");
    }
    @Test
    public void checkingForIncorrectInputName() throws InterruptedException {
    registrationPage.enterWithNoName();
        Assert.assertTrue(registrationPage.errorNameMassageShown("Ім'я обов'язкове."));
    }

    @BeforeMethod
    private void beforeMethodActions1(Method method) {
        if (method.getName().equalsIgnoreCase("checkingForIncorrectInputLastName"))
            driver.navigate().to("https://butlers.ua/ua/register?returnUrl=%2Fua%2F");
    }
    @Test
    public void checkingForIncorrectInputLastName() throws InterruptedException {
        registrationPage.enterWithNoLastName();
        Assert.assertTrue(registrationPage.errorLastNameMassageShown("Прізвище обов'язкове."));
    }

    @BeforeMethod
    private void beforeMethodActions2(Method method) {
        if (method.getName().equalsIgnoreCase("checkingForIncorrectInputEmail"))
            driver.navigate().to("https://butlers.ua/ua/register?returnUrl=%2Fua%2F");
    }

    @Test
    public void checkingForIncorrectInputEmail() throws InterruptedException {
        registrationPage.enterWithNoEmail();
        Assert.assertTrue(registrationPage.errorEmailMassageShown("Електронна пошта обов'язкова."));
    }

}
