package com.Oberon1989;

import java.util.Scanner;

public class book_5_72 {
    public static void main(String[] args) {
        float sum = 0;
        float dayDistance = 10;
        final int PERCENT = 10;
        int days = 10;
        for (int i = 0; i < days; i++) {


            if (i > 0) {
                dayDistance += dayDistance * PERCENT / 100;
                System.out.printf("За %s день лыжник прошел %.2f километров\n", i + 1, dayDistance);
            }

            if (i == 6) {
                dayDistance += dayDistance * PERCENT / 100;
                System.out.printf("Суммарный путь за первые 7 дней составляет %.2f километров\n", sum);
            }
            sum += dayDistance;
        }

    }
}
