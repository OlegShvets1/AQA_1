package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage extends AbstractPage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    public void chooseCandle() {
        WebElement candle = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Свічка TWISTED O:2.2 см. H:24 см. 10225665']")));
        candle.click();
    }

    public boolean verifyCandleTitleWithExpectedData(String massage){
        WebElement candle = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[text()='Свічка TWISTED O:2.2 см. H:24 см. 10225665']")));
        return candle.getText().equalsIgnoreCase(massage);}


    public void choosePillow() {
        WebElement pillow = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Подушка PAREA 50х50 см. H:50 см. L:50 см. 10226676']")));
        pillow.click();
    }

    public boolean verifyPillowTitleWithExpectedData(String massage){
        WebElement pillow = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Подушка PAREA 50х50 см. H:50 см. L:50 см. 10226676']")));
        return pillow.getText().equalsIgnoreCase(massage);
    }
}

