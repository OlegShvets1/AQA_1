package org.example.lesson_13;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void asd() {

        System.setProperty("webdriver.chrome.driver", "C:\\chromeDriwer\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://butlers.ua/ua/");
        driver.findElement(By.xpath("//a[text()='Вхід']")).click();
        // driver.findElement(By.xpath())
    }
}
