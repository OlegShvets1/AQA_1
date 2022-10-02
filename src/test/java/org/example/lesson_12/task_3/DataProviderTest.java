package org.example.lesson_12.task_3;

/* Create test with usage of DataProvider, use at least 3 sets of data*/

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {


    @DataProvider(name = "loginDataProvider")
    public Object[][] getData() {
        Object[][] data = {{"User1", "abc@gmail.com", "12345678"},
                {"User2", "bcd@gmail.com", "23456789"},
                {"User3", "cde@gmail.com", "34567891"}};
        return data;
    }


    @Test(dataProvider = "loginDataProvider")
    public void loginTest(String name, String email, String password) {
        Assert.assertTrue(true, "Expected result is - False");
        Assert.assertEquals(name, "User1", "Actual name "  + name + " and expected  name is different");


    }


}
