package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class LoginPage extends  AbstractPage{

    public  LoginPage(WebDriver driver){
        super (driver);
    }

    public void login(String name, String password) throws InterruptedException {
        WebElement usernameField = driver.findElement(By.xpath("//div[@class='inputs']/input[@type='email']"));
        WebElement passwordField = driver.findElement(By.xpath("//div[@class='inputs']/input[@type='password']"));
        WebElement submitButton = driver.findElement(By.xpath("//div[@class='buttons']/input[@type='submit']"));
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
        WebElement usernameField = driver.findElement(By.xpath("//div[@class='inputs']/input[@type='email']"));
        usernameField.isDisplayed();
        usernameField.clear();
        usernameField.sendKeys(name);
    }

    public  void setPassword(String password){
        WebElement passwordField = driver.findElement(By.xpath("//div[@class='inputs']/input[@type='password']"));
        passwordField.isDisplayed();
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public  void submit(){
        WebElement submitButton = driver.findElement(By.xpath("//div[@class='buttons']/input[@type='submit']"));
        submitButton.isDisplayed();
        submitButton.click();
    }

    public  boolean confirmationOfEntryToThePersonalAccount(String massage){
        WebElement el = driver.findElement(By.xpath("//a[text()='Персональний кабінет']"));
        el.isDisplayed();
        return  el.getText().equalsIgnoreCase(massage);
    }

    public  boolean isUserNameErrorMessageShown(String massage){
        WebElement element1 = driver.findElement(By.xpath("//span[@id='Email-error']"));
        element1.isDisplayed();
        return  element1.getText().equalsIgnoreCase(massage);
    }

    public  boolean isPassErrorMessageShown(String massage) throws InterruptedException {
        WebElement element2 = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        element2.isDisplayed();
        Thread.sleep(1000);
        return  element2.getText().contains(massage);
    }


}
