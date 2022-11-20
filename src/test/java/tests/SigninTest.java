package tests;

import driver.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SigninPage;
import java.lang.reflect.Method;

public class SigninTest {

    private WebDriver driver;
    private SigninPage signinPage;

    @BeforeClass(alwaysRun = true)
    public void setupTest() {
        driver = WebDriverRunner.getWebDriver();
       // driver.get("https://butlers.ua/ua/");
        signinPage = new SigninPage(driver);

    }

    @BeforeMethod
    private void beforeMethodActions1(Method method) {
        if (method.getName().equalsIgnoreCase("checkRegistrationButton"))
            driver.navigate().to("https://butlers.ua/ua/login?returnUrl=%2Fua%2F");
    }

    @Test
    public void checkRegistrationButton() {
        signinPage.clickRegistrationButton();
        Assert.assertTrue(signinPage.checkClickRegistrationButton("Зареєструватися"));
    }

    @BeforeMethod
    private void beforeMethodActions2(Method method) {
        if (method.getName().equalsIgnoreCase("checkButtonIdeaForPresents"))
            driver.navigate().to("https://butlers.ua/ua/login?returnUrl=%2Fua%2F");
    }

    @Test
    public void checkButtonIdeaForPresents() throws InterruptedException {
        signinPage.checkButtonIdeaForPresents();
        Assert.assertTrue(signinPage.checkingIdeaForPresentsAppearanceOfSubmenu("СЕРТИФІКАТИ"));
    }

    @BeforeMethod
    private void beforeMethodActions3(Method method) {
        if (method.getName().equalsIgnoreCase("checkButtonXmas"))
            driver.navigate().to("https://butlers.ua/ua/login?returnUrl=%2Fua%2F");
    }

    @Test
    public void checkButtonXmas() throws InterruptedException {
        signinPage.checkButtonXmas();
        Assert.assertTrue(signinPage.checkingXmasAppearanceOfSubmenu("Ялинкові іграшки"));
    }

}
