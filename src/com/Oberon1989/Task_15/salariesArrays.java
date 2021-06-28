package com.Oberon1989.task_15;


import java.util.Random;

public class salariesArrays {
    public static void main(String[] args) {
        salaries();
    }

    static void salaries() {
        int employees = 5;
        int mouths = 12;
        int[][] allSalariesEmp = new int[employees][mouths];
        int[] sumSalaries = new int[employees];
        Random rnd = new Random();

        //Array fill
        for (int i = 0; i < employees; i++) {
            for (int j = 0; j < mouths; j++) {
                allSalariesEmp[i][j] = rnd.nextInt(100) + 1;
            }
        }
        //array clear
        for (int i = 0; i < employees; i++) {
            sumSalaries[i] = 0;
        }
        System.out.println("Неотсортированная зарплата");

        //Print and sum
        for (int i = 0; i < employees; i++) {
            for (int j = 0; j < mouths; j++) {
                sumSalaries[i] += allSalariesEmp[i][j];
                System.out.printf("%-5d", allSalariesEmp[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < employees; i++) {
            System.out.printf("%-5d", sumSalaries[i]);
        }



        //Arrays sort

        int offset = 0;
        int tmp = 0;
        boolean isSorted;
        do {
            isSorted = true;

            for (int i = 0; i < employees - offset - 1; i++) {
                if (sumSalaries[i] < sumSalaries[i + 1]) {
                    isSorted = false;
                    tmp = sumSalaries[i];
                    sumSalaries[i] = sumSalaries[i + 1];
                    sumSalaries[i + 1] = tmp;

                    for (int j = 0; j < mouths; j++) {
                        tmp = allSalariesEmp[i][j];
                        allSalariesEmp[i][j] = allSalariesEmp[i + 1][j];
                        allSalariesEmp[i + 1][j] = tmp;

                    }
                }
            }
            offset++;
        }
        while (!isSorted);
        //print
        System.out.println("\nОтсортированная зарплата");

        for (int i = 0; i < employees; i++) {
            for (int j = 0; j < mouths; j++) {
                System.out.printf("%-5d", allSalariesEmp[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < employees; i++) {
            System.out.printf("%-5d", sumSalaries[i]);
        }
    }
}
