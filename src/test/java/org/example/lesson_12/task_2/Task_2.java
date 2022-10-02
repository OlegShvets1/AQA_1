package org.example.lesson_12.task_2;

/* Task_2. Implement properties using Owner library   http://owner.aeonbits.org/ */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


    public class Task_2 {
        public static void main(String[] args) throws IOException {
            Properties properties = new Properties();
            properties.setProperty("one", "1");
            properties.setProperty("two", "2");
            properties.setProperty("three", "3");
            System.out.println(properties.getProperty("one"));
            System.out.println(properties.getProperty("two"));
            System.out.println(properties.getProperty("three"));
            FileOutputStream out = new FileOutputStream("myProperties");
            properties.store(out, "First coment");
            FileInputStream in = new FileInputStream("myProperties");
            properties.load(in);
            System.out.println(properties.getProperty("three"));
            System.out.println(properties.getProperty("two"));
            System.out.println(properties.getProperty("one"));

        }
    }

