package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SigninPage extends AbstractPage {

    public SigninPage(WebDriver driver) {
        super(driver);
    }

    public  void clickRegistrationButton(){
        WebElement registrationButton = driver.findElement(By.xpath("//input[@class='button-1 register-button']"));
        registrationButton.isDisplayed();
        registrationButton.click();
    }

    public boolean checkClickRegistrationButton(String massage) {
        WebElement element = driver.findElement(By.xpath("//div[@class='page-title']"));
        return element.getText().equalsIgnoreCase(massage);
    }

    public void checkButtonIdeaForPresents() throws InterruptedException {
        WebElement IdeaForPresents = driver.findElement(By.xpath("//a[@href='/ua/ideyi-dlya-podarunkiv']"));
        IdeaForPresents.isDisplayed();
        Actions actions = new Actions(driver);
        actions.moveToElement(IdeaForPresents).perform();
        Thread.sleep(1000);
    }

    public boolean checkingIdeaForPresentsAppearanceOfSubmenu(String massage) {
        WebElement submenueIdeaForPresents = driver.findElement(By.xpath("//a[@href='/ua/gift']"));
        return submenueIdeaForPresents.getText().contains(massage);
    }

    public void checkButtonXmas() throws InterruptedException {
        WebElement Xmas = driver.findElement(By.xpath("//a[@href='/ua/xmas22']"));
        Xmas.isDisplayed();
        Actions actions = new Actions(driver);
        actions.moveToElement(Xmas).perform();
        Thread.sleep(1000);
    }

    public boolean checkingXmasAppearanceOfSubmenu(String massage) {
        WebElement submenueXmas = driver.findElement(By.xpath("//a[@href='/ua/yalinkovi-igrashki']"));
        return submenueXmas.getText().contains(massage);
    }
}
