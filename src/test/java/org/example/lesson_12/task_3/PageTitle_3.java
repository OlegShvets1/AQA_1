package org.example.lesson_12.task_3;

/*  Task_3  Create at 3 test using testNG:
 * Open any desirable site and verify title
 * Using Random java class Random random = new Random(); Validate that random returns values in the correct range(for example use range 10)
 * Create test with usage of DataProvider, use at least 3 sets of data*/


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class PageTitle_3{

    @Test
    public  void comperingTitle(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromeDriwer\\chromedriver.exe");
        WebDriver  driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.navigate().to("https://butlers.ua/ua/");
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title - " + actualTitle);
        //driver.manage().window().maximize();
        String expectedTitle = "BUTLERS Made for Your Home БАТЛЕРС Декор для Дома Интерьера Новый год";
        System.out.println("Expected Title - " + expectedTitle);
        Assert.assertEquals(actualTitle,expectedTitle, "The actual result does not match the expected result");
        driver.close();
        driver.quit();

    }

}
