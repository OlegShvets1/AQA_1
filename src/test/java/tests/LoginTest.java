package tests;

import driver.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

import java.lang.reflect.Method;

public class LoginTest {

    private WebDriver driver;

    private LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setupTest() {

           driver = WebDriverRunner.getWebDriver();
        driver.get("https://butlers.ua/ua/");
        loginPage = new LoginPage(driver);
    }

    @BeforeMethod
    private void beforeMethodActions1(Method method) {
        if (method.getName().equalsIgnoreCase("exitWithoutData"))
            driver.navigate().to("https://butlers.ua/ua/login?returnUrl=%2Fua%2F");
    }

    @Test
    public void exitWithoutData() throws InterruptedException {
        loginPage.setUserName("");
        loginPage.setPassword("");
        loginPage.submit();
        Assert.assertTrue(loginPage.isUserNameErrorMessageShown("Будь ласка, введіть свою електронну адресу"));

    }

    @BeforeMethod
    private void beforeMethodActions2(Method method) {
        if (method.getName().equalsIgnoreCase("exitWithoutUserName"))
            driver.navigate().to("https://butlers.ua/ua/login?returnUrl=%2Fua%2F");
    }

    @Test
    public void exitWithoutUserName() throws InterruptedException {
        loginPage.setUserName("");
        loginPage.setPassword("12345678");
        loginPage.submit();
        Assert.assertTrue(loginPage.isUserNameErrorMessageShown("Будь ласка, введіть свою електронну адресу"));

    }

    @BeforeMethod
    private void beforeMethodActions3(Method method) {
        if (method.getName().equalsIgnoreCase("exitWithoutPassword"))
            driver.navigate().to("https://butlers.ua/ua/login?returnUrl=%2Fua%2F");
    }

    @Test
    public void exitWithoutPassword() throws InterruptedException {
        loginPage.setUserName("olehpost69@gmail.com");
        loginPage.setPassword("");
        loginPage.submit();
        Assert.assertTrue(loginPage.isPassErrorMessageShown("Вхід не вдалося. Виправте помилки та повторіть спробу."));

    }

    @BeforeMethod
    private void beforeMethodActions4(Method method) {
        if (method.getName().equalsIgnoreCase("exitWithCorrectData"))
            driver.navigate().to("https://butlers.ua/ua/login?returnUrl=%2Fua%2F");
    }

    @Test
    public void exitWithCorrectData() throws InterruptedException {
        loginPage.login("olehpost69@gmail.com", "12345678");
        Assert.assertTrue(loginPage.confirmationOfEntryToThePersonalAccount("Персональний кабінет"));

    }

}
