package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import pages.PersonalAccountPage;

public class PersonalAccountTest {

    private WebDriver driver;
    private PersonalAccountPage personalAccountPage;

    @BeforeClass(alwaysRun = true)
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromeDriwer\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://butlers.ua/ua/");
        personalAccountPage = new PersonalAccountPage(driver);

    }
}
