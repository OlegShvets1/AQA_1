package org.example.lesson_13.task_3;

/*3) Navigate to Butlers shop site https://butlers.ua/ua/ */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigateToSiteTest {


    @Test
    public void navigateToSite() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //driver.get("https://butlers.ua/ua/ ");
        driver.navigate().to("https://butlers.ua/ua/ ");
        Thread.sleep(3000);
        driver.close();
        Assert.assertTrue(true);
    }
}
