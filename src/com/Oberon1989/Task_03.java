package com.Oberon1989;

import java.util.Scanner;
//Честно было лень заводить 3 класса, поэтому я сделал три метода

public class Task_03 {
    final static int MAX_LENGTH = 6;
    static final int MAX_VALUE = 999999;
    static final int EMPLOYEES = 3;

    public static void main(String[] args) {

        //checkLuckyTicket();

        //salaryDifference();

        System.out.println("Демонстрация метода обмена значениями для двух переменных без использования третьей переменной");

        Swap(32, 64);

    }

    public static void checkLuckyTicket() {
        int originalNumber, singleNumber, count = 0;
        int firstPartSum = 0;
        int secondPartSum = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("введите 6-значный номер билета");
        try {
            if (scanner.hasNextInt()) {
                originalNumber = scanner.nextInt();
                if (originalNumber <= MAX_VALUE) {

                    while (originalNumber > 0) {
                        singleNumber = originalNumber % 10;
                        if (count < MAX_LENGTH / 2) {
                            secondPartSum += singleNumber;
                        } else {
                            firstPartSum += singleNumber;
                        }
                        count++;
                        originalNumber /= 10;

                    }
                } else {
                    throw new Exception("Вы ввели больше больше чем 6-значное число");
                }
            } else {
                throw new Exception("Введите 6-значное неотрицательное число");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        String output = String.format(" билет! Сумма 3-х первых цифр равна %s : Сумма 3-х последних цифр равна %s", firstPartSum, secondPartSum);

        if (firstPartSum == secondPartSum) {
            System.out.println("Счастливый" + output);
        } else {
            System.out.println("Несчастливый" + output);
        }
    }

    public static void salaryDifference() {
        int[] allSalary = new int[EMPLOYEES];
        int count = 0;
        int maxCount = 3;
        try {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < EMPLOYEES; i++) {
                System.out.println("Введите сумму зарплаты");
                if (scanner.hasNextInt()) {

                    allSalary[i] = scanner.nextInt();
                } else if (count < maxCount) {
                    System.out.println("Было введено неккоректное значение повторите попытку!");
                    i--;
                    count++;
                } else {
                    throw new Exception("Вы исчерпали лимит попыток ввода. Завершение...");
                }
            }
            int min = 0;
            int max = 0;

            for (int i = 0; i < allSalary.length; i++) {
                if (allSalary[i] > allSalary[max]) {
                    max = i;
                } else if (allSalary[i] < allSalary[min]) {
                    min = i;
                }
            }

            System.out.println(String.format("Разница между наибольшей и наименьшей зарплатой равна %s ", allSalary[max] - allSalary[min]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Swap(int x, int y) {

        System.out.println("X " + x + " Y " + y);
//       x = x + y;  Арифметический метод
//       y = x - y;
//       x = x - y;

        System.out.println("Swapping.. ");

        x = x ^ y; // Побитовый метод xor
        y = y ^ x;
        x = x ^ y;
        System.out.println("X "+x+" "+"Y "+y);

    }
}

