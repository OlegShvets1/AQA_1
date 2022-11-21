package Lesson_15;

/*  2  - Write a test that verifies actual information about a Product. (Click on it, check title, description, etc) */

import driver.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class Task_2 {

    public static String EXPECTED_TEXT = "Фігура будди для декору BUDDHA H:27 см. 10226408";
    public static String EXPECTED_TEXT_1="Декоративна фігура Будди з серії BUDDHA - можливість " +
            "додати спокою та гармонії в інтерєр вашого дому та ваше життя. Керамічна статуя білого " +
            "кольору виглядає велично й монументально. Її висота 21,7 см, ширина - 12,6 см - компактний розмір для того," +
            " щоб розмістити в будинку. Фігура Будди додасть дизайну східних мотивів та наповнить його затишком." +
            " Він прекрасно виглядатиме в будь-якому місці, але рекомендовано розміщати фігуру там," +
            " де ви зможете концентруватися та знаходити час для спокою й безперервного споглядання. " +
            "Однак Будда може стати влучним доповненням робочого кабінету, де серед робочої метушні точно " +
            "потрібен час для тиші й спокою. Він також може стати чудовим подарунком для тих, " +
            "хто захоплюється східними практиками. Обирайте деталі зі змістом з колекцією BUDDHA.";
        private WebDriver driver;
        private WebDriverWait wait;

        @BeforeClass
        public void beforeClassActions() {

            driver = WebDriverRunner.getWebDriver();
            driver.get("https://butlers.ua/ua/");
            WebElement loginButton = new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Вхід']")));
            loginButton.click();
            WebElement usernameField = driver.findElement(By.xpath("//div[@class='inputs']/input[@type='email']"));
            WebElement passwordField = driver.findElement(By.xpath("//div[@class='inputs']/input[@type='password']"));
            WebElement submittButton = driver.findElement(By.xpath("//div[@class='buttons']/input[@type='submit']"));
            usernameField.clear();
            usernameField.sendKeys("olehpost69@gmail.com");
            passwordField.click();
            passwordField.sendKeys("12345678");
            submittButton.click();
        }

        @Test
        public void verifyActualTitleAndDescriptionWithExpectedData() throws InterruptedException {

          WebElement newButton = driver.findElement(By.xpath("//a[@href='/ua/all'][1]"));
          newButton.click();

            WebElement product = new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-productid='8567' ]")));
         product.click();
         Assert.assertEquals(driver.findElement(By.xpath("//h1[@itemprop='name']")).getText(), EXPECTED_TEXT,
                    String.format("%s text should be displayed", EXPECTED_TEXT));
         Assert.assertEquals(driver.findElement(By.xpath("//div[@class='full-description']")).getText(), EXPECTED_TEXT_1,
                    String.format("%s text should be displayed", EXPECTED_TEXT_1));
        }

    }


