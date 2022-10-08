package org.example.lesson_12.task_3;

/* Create test with usage of DataProvider, use at least 3 sets of data*/

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
        Assert.assertEquals(name, "User1", "Actual name and expected  name is different");
        Assert.assertEquals(email, "abc@gmail.com", "Actual e-mail and expected e-mail is different");
        Assert.assertEquals(password, "12345678", "Actual password and expected password is different");
        Assert.assertTrue(false);
        Assert.assertTrue(true, "Expected result is - False");

    }


}
