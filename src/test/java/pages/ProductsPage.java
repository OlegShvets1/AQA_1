package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage extends AbstractPage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@data-productid='7589']")
    WebElement candle;

    @FindBy(xpath = "//h1")
    WebElement candle1;

    @FindBy(xpath = "//div[@data-productid='8578']")
    WebElement pillow;

    @FindBy(xpath = "//h1")
    WebElement pillow1;

    public void chooseCandle() {
        candle.click();
    }

    public boolean verifyCandleTitleWithExpectedData(String massage){
        candle1.getText().equalsIgnoreCase(massage);
            return candle1.getText().equalsIgnoreCase(massage);}


    public void choosePillow() {
    pillow.click();
    }

    public boolean verifyPillowTitleWithExpectedData(String massage){
        return pillow1.getText().equalsIgnoreCase(massage);
    }
}

