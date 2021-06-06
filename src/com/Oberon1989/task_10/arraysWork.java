package com.Oberon1989.task_10;

import java.util.Random;
import java.util.Scanner;

public class arraysWork {
    static Scanner scanner = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        task1();
        task2(10);
        task3(20, 50, 100);
        task4(20);
        task5(12);
        task6(18, 7);
        task7(7);

    }

    static void task1() {
        System.out.println("Первая задача");
        int[] arr = {37, 0, 50, 46, 34, 46, 0, 13};

        for (int current : arr) {
            System.out.printf("%s ", current);
        }

        System.out.println("\n\n");
    }

    static void task2(int length) {
        System.out.println("Вторая задача");
        int[] arr = new int[length];
        System.out.printf("Заполните массив из десяти чисел, после каждого ввода нажимайте ENTER\n");

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Введите %s элемент массива\n", i + 1);

            if (scanner.hasNextInt()) {
                arr[i] = scanner.nextInt();

            } else {
                System.out.println("Необходимо целое число!");
                scanner.next();
                i--;
            }
        }
        System.out.printf("Ниже ваш массив в текстовом представлении\n");

        for (int current : arr) {
            System.out.printf("%s ", current);
        }

        System.out.println("\n\n");
    }

    static void task3(int length, int min, int max) {
        System.out.println("Третья задача\n");
        int[] arr = new int[length];
        System.out.printf("Массив из %s элементов со случайными числами в диапазоне от %s до %s\n", length, min, max);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(max - min + 1) + min;
        }

        for (int current : arr) {
            System.out.printf("%s ", current);
        }

        System.out.println("\n\n");
    }

    static void task4(int length) {
        System.out.println("Четвертая задача");
        int[] arr = new int[length];
        int current = length;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = current;
            current--;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s ", arr[i]);
        }

        System.out.println("\n\n");
    }

    static void task5(int length) {
        System.out.println("Пятая задача");
        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        for (int current : arr) {
            System.out.printf("%s ", current);
        }

        System.out.println("\n\n");
    }

    static void task6(int length, int index) {
        System.out.println("Шестая задача");

        if (index < 0) {
            System.out.printf("Индекс %S находится вне диапазона\nИндекс должен быть не меньше 0 \n", index);
            return;
        }

        if (index > length - 1) {
            System.out.printf("Индекс %S находится вне диапазона\nИндекс должен быть не больше %s так как массивы индексируются с 0\n", index, length - 1);
            return;
        }

        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100) + 1;
        }

        System.out.printf("Элемент массива с индексом %s является цифрой : %s\n\n", index, arr[index]);
    }

    static void task7(int length) {
        System.out.println("Седьмая задача\nОбычный порядок");
        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100) + 1;
            System.out.printf("%s ", arr[i]);
        }

        System.out.println("\nОбратный порядок");

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.printf("%S ", arr[i]);
        }

        System.out.println("\n\n");
    }

}
