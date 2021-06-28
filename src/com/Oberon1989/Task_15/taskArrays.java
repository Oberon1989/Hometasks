package com.Oberon1989.task_15;

import java.util.Arrays;
import java.util.Random;

public class taskArrays {
    public static void main(String[] args) {
        task_12_5();
        task_12_6();
        task_12_7();
        task_8_12();
        task_8_14();
    }

    static void task_12_5() {
        int x = 6;
        int y = 6;
        final int FIVE = 5;
        Random rnd = new Random();
        int sColumn = rnd.nextInt(x-1) + 1;
        int[][] arr = array2dFill(x, y, 50, 100);

        System.out.println(array2dPrint(arr, "Ваш массив"));
        System.out.println(FIVE + "  строка");

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == FIVE) {
                    System.out.printf("%-5d", arr[i][j]);
                }
            }
        }

        System.out.printf("\n%s столбец\n", sColumn);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (j == sColumn) {
                    System.out.printf("%-5d", arr[i][j]);
                }
            }
        }
        System.out.println();
    }

    static void task_12_6() {
        int x = 6;
        int y = 6;
        Random rnd = new Random();
        final int SECOND_COLUMN = 2;
        //int m = rnd.nextInt(y-1) + 1;
        int m = 3;
        int[][] arr = array2dFill(x, y, 50, 100);
        System.out.println(array2dPrint(arr, "Ваш массив"));
        System.out.println(SECOND_COLUMN + " столбец");

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (j == SECOND_COLUMN) {
                    System.out.printf("%-5d", arr[i][j]);
                }
            }
        }

        System.out.println("\n" + m + "  строка");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == m) {
                    System.out.printf("%-5d", arr[i][j]);
                }
            }
        }
        System.out.println();
    }

    static void task_12_7() {
        int x = 6;
        int y = 6;
        final int FIVE = 5;
        final int VALUE = 1949;
        int a = 777;
        int[][] arr = array2dFill(x, y, 50, 100);
        System.out.println(array2dPrint(arr, "Ваш массив"));

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == FIVE) {
                    arr[i][j] = VALUE;
                }
            }
        }
        System.out.println(array2dPrint(arr, "После замены 5 строки"));
        arr[4][4] = a;
        System.out.println(array2dPrint(arr, "После замены значения по индексу[4][4]"));
    }

    static void task_8_12() {
        int athleteCount = 15;
        int programCount = 3;
        int[][] arr = array2dFill(15, 3, 50, 100);
        int[] sumPointStage = new int[programCount];

        for (int i = 0; i < programCount; i++) {
            sumPointStage[i] = 0;
        }

        System.out.println(array2dPrint(arr, "Таблица баллов"));
        int tmp = 0;

        for (int i = 0; i < athleteCount; i++) {
            for (int j = 0; j < programCount; j++) {
                tmp += arr[i][j];
            }
            tmp = tmp / programCount;
            System.out.printf("Среднее количество баллов полученное %s спортсменом равно %S\n", i + 1, tmp);
        }

        System.out.println();
        int current = 0;

        do {

            for (int i = 0; i < athleteCount; i++) {
                sumPointStage[current] += arr[i][current];
            }

            current++;
        }
        while (current < programCount);

        for (int i = 0; i < programCount; i++) {
            System.out.printf("Программа номер %s - общее количество баллов всех участников - %s\n", i + 1, sumPointStage[i]);
        }

        System.out.println();

        for (int i = 0; i < programCount; i++) {
            System.out.printf("Программа номер %s - средний балл каждого участника - %s\n", i + 1, sumPointStage[i] / athleteCount);
        }
    }

    static void task_8_14() {
        int studentCount = 15;
        int disciplineCount = 3;
        int[][] arr = array2dFill(studentCount, disciplineCount, 2, 5);
        System.out.println(array2dPrint(arr, "Таблица оценок"));
        int notTwoRatingCount = 0;
        int[] twoCountInDiscipline = new int[disciplineCount];
        boolean isWrong;

        for (int i = 0; i < disciplineCount; i++) {
            twoCountInDiscipline[i] = 0;
        }

        for (int i = 0; i < studentCount; i++) {
            isWrong = false;

            for (int j = 0; j < disciplineCount; j++) {

                if (arr[i][j] == 2) {
                    isWrong = true;
                }
            }

            if (!isWrong) {
                notTwoRatingCount++;
            }
        }

        System.out.printf("без двоек сдали %s студентов\n", notTwoRatingCount);

        boolean isFourAndFive;
        int fourAndFive = 0;
        int current = 0;

        do {
            isFourAndFive = true;

            for (int i = 0; i < studentCount; i++) {

                if (arr[i][current] < 4) {
                    isFourAndFive = false;
                }

                if (arr[i][current] == 2) {
                    twoCountInDiscipline[current]++;
                }
            }

            if (isFourAndFive) {
                fourAndFive++;
            }

            current++;
        }
        while (current < disciplineCount);

        System.out.printf("Количество предметов с оценкой только 4 или 5 - %s\n", fourAndFive);

        for (int i = 0; i < disciplineCount; i++) {
            System.out.printf("Количество двоек по предмету номер %s составляет - %s\n", i + 1, twoCountInDiscipline[i]);
        }
    }

    static int[][] array2dFill(int x, int y, int rangeMin, int rangeMax) {
        Random rnd = new Random();
        int[][] arr = new int[x][y];

        for (int i = 0; i < x; i++) {

            for (int j = 0; j < y; j++) {
                arr[i][j] = rnd.nextInt(rangeMax - rangeMin + 1) + rangeMin;
            }
        }

        return arr;
    }

    static String array2dPrint(int[][] arr, String str) {
        int x = arr.length;
        StringBuilder builder = new StringBuilder();
        System.out.println(str);

        for (int i = 0; i < x; i++) {

            for (int j = 0; j < arr[i].length; j++) {
                builder.append(String.format("%-5d", arr[i][j]));
            }

            builder.append("\n");
        }

        return builder.toString();
    }
}
