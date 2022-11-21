package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends  AbstractPage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@name= 'FirstName']")
    WebElement userName;

    @FindBy(xpath = "//span[@id='FirstName-error']")
    WebElement nameError;

    @FindBy(xpath = "//*[@name= 'LastName']")
    WebElement userLastName;

    @FindBy(xpath = "//span[@id='LastName-error']")
    WebElement lastNameError;

    @FindBy(xpath = "//input[@type='email']")
    WebElement userEmail;

    @FindBy(xpath = "//span[@id='Email-error']")
    WebElement emailError;


    public void enterWithNoName() {
        userName.isDisplayed();
        userName.clear();
        userName.sendKeys("", Keys.ENTER);
    }

    public boolean errorNameMassageShown(String massage) {
        nameError.isDisplayed();
        return nameError.getText().equalsIgnoreCase(massage);
    }

    public void enterWithNoLastName() {
        userLastName.isDisplayed();
        userLastName.clear();
        userLastName.sendKeys("", Keys.ENTER);
    }

    public boolean errorLastNameMassageShown(String massage) {
        lastNameError.isDisplayed();
        return lastNameError.getText().equalsIgnoreCase(massage);
    }

    public void enterWithNoEmail() {
        userEmail.isDisplayed();
        userEmail.clear();
        userEmail.sendKeys("", Keys.ENTER);
    }

    public boolean errorEmailMassageShown(String massage) {
        emailError.isDisplayed();
        return emailError.getText().equalsIgnoreCase(massage);
    }
}
