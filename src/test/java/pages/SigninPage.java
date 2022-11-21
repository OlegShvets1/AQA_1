package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SigninPage extends AbstractPage {

    public SigninPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@class='button-1 register-button']")
    WebElement registrationButton;

    @FindBy(xpath = "//div[@class='page-title']")
    WebElement element;

    @FindBy(xpath = "//a[@href='/ua/ideyi-dlya-podarunkiv']")
    WebElement IdeaForPresents;

    @FindBy(xpath = "//a[@href='/ua/gift']")
    WebElement submenueIdeaForPresents;

    @FindBy(xpath = "//a[@href='/ua/xmas22']")
    WebElement Xmas;

    @FindBy(xpath = "//a[@href='/ua/yalinkovi-igrashki']")
    WebElement submenueXmas;

    public  void clickRegistrationButton(){
        registrationButton.isDisplayed();
        registrationButton.click();
    }

    public boolean checkClickRegistrationButton(String massage) {
        return element.getText().equalsIgnoreCase(massage);
    }

    public void checkButtonIdeaForPresents() throws InterruptedException {
        IdeaForPresents.isDisplayed();
        Actions actions = new Actions(driver);
        actions.moveToElement(IdeaForPresents).perform();
        Thread.sleep(1000);
    }

    public boolean checkingIdeaForPresentsAppearanceOfSubmenu(String massage) {
         return submenueIdeaForPresents.getText().contains(massage);
    }

    public void checkButtonXmas() throws InterruptedException {
        Xmas.isDisplayed();
        Actions actions = new Actions(driver);
        actions.moveToElement(Xmas).perform();
        Thread.sleep(1000);
    }

    public boolean checkingXmasAppearanceOfSubmenu(String massage) {
        return submenueXmas.getText().contains(massage);
    }
}
