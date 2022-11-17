package org.example.lesson_12.task_1;

/*  Task_1.   Implement singleton patern for Webdriver*/


    public class WebDriver {

        private static WebDriver webdriver;

        private WebDriver() {
        }

        public static WebDriver getwebdriver() {
            if (webdriver == null) {
                webdriver = new WebDriver();
            }
            return webdriver;
        }

        public static void main(String[] args) {
            System.out.println(webdriver.getwebdriver());
            System.out.println(webdriver.getwebdriver());
            System.out.println(webdriver.getwebdriver());
        }
    }


