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
import pages.LoginPage;
import pages.ProductsPage;
import pages.RegistrationPage;

import java.lang.reflect.Method;

public class ProductsTest {

    private WebDriver driver;
    private ProductsPage productsPage;
    private LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromeDriwer\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://butlers.ua/ua/");
        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);
    }

//    @BeforeMethod
//    private void beforeMethodActions(Method method) throws InterruptedException {
//        if (method.getName().equalsIgnoreCase("verifyCandleTitleWithExpectedData"))
//            driver.navigate().to("https://butlers.ua/ua/");
//    }

    @Test
    public void verifyCandleTitleWithExpectedData() throws InterruptedException {
        productsPage.chooseCandle();
        Assert.assertTrue(productsPage.verifyCandleTitleWithExpectedData("Свічка TWISTED O:2.2 см. H:24 см. 10225665"));
    }

    @BeforeMethod
    private void beforeMethodActions1(Method method) throws InterruptedException {
        if (method.getName().equalsIgnoreCase("verifyPillowTitleWithExpectedData"))
            driver.navigate().to("https://butlers.ua/ua/");
    }

    @Test
    public void verifyPillowTitleWithExpectedData() throws InterruptedException {
        productsPage.choosePillow();
        Assert.assertTrue(productsPage.verifyPillowTitleWithExpectedData("Подушка PAREA 50х50 см. H:50 см. L:50 см. 10226676"));
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}
