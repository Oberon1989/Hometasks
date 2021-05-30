package com.Oberon1989.tasks_8;

public class task_Cycles {
    public static void main(String[] args) {
        task1();
        System.out.println();
        task2();
        System.out.println();
        task3();
        System.out.println();
        task4();
        System.out.println();
        task5();
    }

    static void task1() {
        int width = 6;
        int height = 4;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(5 + " ");
            }
            System.out.println("");
        }
    }

    static void task2() {

        int width = 1;
        int height = 5;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(5 + " ");
            }
            System.out.println("");
            width++;
        }


    }

    static void task3() {
        int width = 5;
        int height = 5;

        for (int i = 0; i < height; i++) {
            for (int j = width; j >= 1; j--) {
                System.out.print(1 + " ");
            }
            System.out.println("");
            width--;
        }

    }

    static void task4() {
        int width = 1;
        int height = 5;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(width + " ");
            }
            width++;
            System.out.println();
        }
    }

    static void task5() {
        int width = 5;
        int height = 5;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(width + " ");
            }
            width--;
            System.out.println();
        }
    }
}
