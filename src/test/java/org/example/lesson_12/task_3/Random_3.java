package org.example.lesson_12.task_3;

/*    *Using Random java class Random random = new Random(); Validate that random returns values
in the correct range(for example use range 10)*/

import java.util.Random;

public class Random_3 {
    public static void main(String args[]) {
        Random random = new Random();
        int x = 10;
        int randomValue = random.nextInt(x);
        System.out.println("Random value is - " + randomValue);
        if (randomValue <= x) {
            System.out.println("Random returns values in the correct range");
        } else {
            System.out.println("Random doesn`t return values in the correct range");
        }
    }
}
