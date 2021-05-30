package com.Oberon1989.tasks_8;

import java.util.Scanner;

public class salaryQuarter {
    public static void main(String[] args) {
        final int QUARTER = 3;
        final int EMPLOYEES_COUNT = 12;
        int[] employees = new int[12];
        int mouthSum = 0;
        int quarterSum = 0;
        Scanner scanner = new Scanner(System.in);
        int tmp = 0;

        for (int i = 1; i <= QUARTER; i++) {
            for (int j = 1; j <= EMPLOYEES_COUNT; j++) {
                System.out.printf("Введите зарплату %s - сотрудника\n", j);
                tmp = scanner.nextInt();
                employees[j - 1] += tmp;
                mouthSum += tmp;
                quarterSum += tmp;
            }

            System.out.printf("Зарплата всех сотрудников за %s - месяц составляет %s \n", i, mouthSum);
            mouthSum = 0;
        }
        System.out.printf("Зарплата всех сотрудников за квартал составляет %s \n", quarterSum);

        for (int i = 0; i < employees.length; i++) {
            System.out.printf("Зарплата %s - работника за квартал сотавляет - %s\n", i + 1, employees[i]);
        }
    }
}
