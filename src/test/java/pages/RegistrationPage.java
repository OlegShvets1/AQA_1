package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends  AbstractPage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void enterWithNoName() {
        WebElement userName = driver.findElement(By.xpath("//*[@name= 'FirstName']"));
        userName.isDisplayed();
        userName.clear();
        userName.sendKeys("", Keys.ENTER);
    }

    public boolean errorNameMassageShown(String massage) {
        WebElement nameError = driver.findElement(By.xpath("//span[@id='FirstName-error']"));
        nameError.isDisplayed();
        return nameError.getText().equalsIgnoreCase(massage);
    }

    public void enterWithNoLastName() {
        WebElement userLastName = driver.findElement(By.xpath("//*[@name= 'LastName']"));
        userLastName.isDisplayed();
        userLastName.clear();
        userLastName.sendKeys("", Keys.ENTER);
    }

    public boolean errorLastNameMassageShown(String massage) {
        WebElement lastNameError = driver.findElement(By.xpath("//span[@id='LastName-error']"));
        lastNameError.isDisplayed();
        return lastNameError.getText().equalsIgnoreCase(massage);
    }

    public void enterWithNoEmail() {
        WebElement userEmail = driver.findElement(By.xpath("//input[@type='email']"));
        userEmail.isDisplayed();
        userEmail.clear();
        userEmail.sendKeys("", Keys.ENTER);
    }

    public boolean errorEmailMassageShown(String massage) {
        WebElement emailError = driver.findElement(By.xpath("//span[@id='Email-error']"));
        emailError.isDisplayed();
        return emailError.getText().equalsIgnoreCase(massage);
    }
}
