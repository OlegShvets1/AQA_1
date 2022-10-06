package org.example.lesson_13.task_4;

/*4) Create 3 Java Classes with String variables which will contain css and xpath locators for each field,
including  buttons. Implement those classes for Login, Registration and Profile page*/

public class LoginPage {
    private  String usernameFieldCSS = "[name='Email']";
    private  String usernameFieldXpath = "//div[@class='inputs']/input[@type='email']";

    private  String passwordFieldCSS = "[name= 'Password']";
    private  String passwordFieldXpath = "//div[@class='inputs']/input[@type='password']";

    private  String loginButtonCSS = "[value='Вхід']";
    private  String loginButtonXpath = "//div[@class='buttons']/input[@type='submit']";

    private  String registrationButtonCSS = "[value='Зареєструватися']";
    private  String registrationButtonXpath = "//div[@class = 'buttons']/input[@type='button']";
}
