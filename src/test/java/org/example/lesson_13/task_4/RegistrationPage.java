package org.example.lesson_13.task_4;

/*4) Create 3 Java Classes with String variables which will contain css and xpath locators for each field,
including  buttons. Implement those classes for Login, Registration and Profile page*/

public class RegistrationPage {

    private String userGenderFieldCSS = " ";
    private String userGenderFieldXpath = "//div[@class='gender']";

    private String userFirstNameFieldCSS = "[name= 'FirstName']";
    private String userFirstNameFieldXpath = "//input[@name='FirstName']";

    private String userLastNameFieldCSS = "[name= 'LastName']";
    private String userLastNameFieldXpath = "//*[@name='LastName']";

    private String userDateOfBirthDayCSS = "[name= 'DateOfBirthDay']";
    private String userDateOfBirthDayXpath = "//*[@name='DateOfBirthDay']";

    private String userDateOfBirthMonthCSS = "[name= 'DateOfBirthMonth']";
    private String userDateOfBirthMonthXpath = "//*[@name='DateOfBirthMonth']";

    private String userDateOfBirthYearCSS = "[name= 'DateOfBirthYear']";
    private String userDateOfBirthYearXpath = "//*[@name='DateOfBirthYear']";

    private String userE_mailCSS = "[name = 'Email']";
    private String userE_mailXpath = "//*[@name='Email']";

    private String userPhoneCSS = "[name = 'Phone']";
    private String userPhoneXpath = "//*[@name='Phone']";

    private String userPasswordCSS = "[name='Password']";
    private String userPasswordXpath = "//*[@name='Password']";

    private String userConfirmPasswordCSS = "[name='ConfirmPassword']";
    private String userConfirmPasswordXpath = "//*[@name='ConfirmPassword']";

    private String userRegistrationButtonCSS = "[value='Зареєструватися']";
    private String userRegistrationButtonXpath = "//*[@value='Зареєструватися']";

}
