package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;

public class LoginPage extends  AbstractPage{

    public  LoginPage(WebDriver driver){
        super (driver);
    }

    @FindBy (xpath = "//div[@class='inputs']/input[@type='email']")
    WebElement usernameField;

    @FindBy(xpath = "//div[@class='inputs']/input[@type='password']")
    WebElement passwordField;

    @FindBy (xpath = "//div[@class='buttons']/input[@type='submit']")
    WebElement submitButton;

    @FindBy (xpath = "//a[text()='Персональний кабінет']")
    WebElement  element;

    @FindBy (xpath = "//span[@id='Email-error']")
    WebElement  element1;

    @FindBy (xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement  element2;


    public void login(String name, String password) throws InterruptedException {
        usernameField.isDisplayed();
        usernameField.clear();
        usernameField.sendKeys("olehpost69@gmail.com");
        passwordField.isDisplayed();
        passwordField.click();
        passwordField.sendKeys("12345678");
        submitButton.isDisplayed();
        submitButton.click();
        Thread.sleep(1000);
    }

    public  void setUserName(String name){
        usernameField.isDisplayed();
        usernameField.clear();
        usernameField.sendKeys(name);
    }

    public  void setPassword(String password){
        passwordField.isDisplayed();
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public  void submit(){
        submitButton.isDisplayed();
        submitButton.click();
    }

    public  boolean confirmationOfEntryToThePersonalAccount(String massage) throws InterruptedException {
        element.isDisplayed();
        Thread.sleep(1000);
        return  element.getText().equalsIgnoreCase(massage);
    }

    public  boolean isUserNameErrorMessageShown(String massage) throws InterruptedException {
        element1.isDisplayed();
        Thread.sleep(1000);
        return  element1.getText().equalsIgnoreCase(massage);
    }

    public  boolean isPassErrorMessageShown(String massage) throws InterruptedException {
        element2.isDisplayed();
        Thread.sleep(1000);
        return  element2.getText().contains(massage);
    }


}
