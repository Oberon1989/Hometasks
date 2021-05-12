package com.Oberon1989;

import java.util.*;

public class Crow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int crow = scanner.nextInt();
        int tmp = crow;
        int lasDigit = tmp % 10; //последняя цифра числа.

        tmp /= 10;
        int pDigit = tmp % 10; // предпоследняя цифра числа если есть

        if (pDigit == 1) {
            lasDigit = 11; // если все верно ставим 11 что бы перейти в default
        }


        switch (lasDigit) {

            case 1: {
                System.out.println(crow + " ворона");
                break;
            }
            case 2:
            case 3:
            case 4: {
                System.out.println(crow + " вороны");
                break;
            }


            default: {
                System.out.println(crow + " ворон");
            }
        }
    }
}

