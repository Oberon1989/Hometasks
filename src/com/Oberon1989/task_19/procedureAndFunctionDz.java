package com.Oberon1989.task_19;
import java.util.Random;
import java.util.regex.*;

public class procedureAndFunctionDz {

    public static void printDigitsInString(String str) {
        StringBuilder builder = new StringBuilder();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {

            builder.append(String.format("%s ", matcher.group()));
        }
        System.out.println(builder);

    }
    static int fibonacciNumbersRecursive(int k, int first, int second, int start) {
        try {
            if (k > 46 || k < -46) {
                throw new Exception("Integer overflow");
            }

            int result = 0;

            if (k == 1 || k == -1) {
                return 1;
            }

            if (k > 0) {

                result = first + second;
                second = result;
                first = second - first;

                if (start == k) {
                    return result;
                }
                result = fibonacciNumbersRecursive(k, first, second, ++start);

            } else if (k < 0) {

                result = first - second;
                second = result;
                first = -second + first;

                if (start == k + 4) {
                    return result;
                }
                result = fibonacciNumbersRecursive(k, first, second, --start);
            }

            return result;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    static int fibonacciNumbersIterate(int k) {
        try {
            if (k > 46 || k < -46) {
                throw new Exception("Integer overflow");
            }

            int result = 0;
            int first = 0;
            int second = 1;

            if (k == 1 || k == -1) {
                return 1;
            }

            if (k > 0) {

                for (int i = 2; i <= k; i++) {
                    result = first + second;
                    second = result;
                    first = second - first;
                }

            } else if (k < 0) {
                for (int i = 2; i <= Math.abs(k); i++) {
                    result = first - second;
                    second = result;
                    first = -second + first;
                }
            }
            return result;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    static void printEvenAndOddElements(int[] arr) {
        int length = arr.length;

        int middle = length / 2;
        StringBuilder builderEven = new StringBuilder();
        StringBuilder builderOdd = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                builderEven.append(arr[i] + " ");
            } else {
                builderOdd.append(arr[i] + " ");
            }
        }
        System.out.println(builderEven + "\n" + builderOdd);
    }

    static void RainDaysInMouthPrint(int arr[]) {
        //0 ясно 1 осадки
        int length = arr.length;
        int count = 0;
        if (length > 29) {
            System.out.println("Месяц не является февралем так как количество дней больше 29");
            return;
        }
        for (int i = 0; i < length; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }
        System.out.println("В феврале было " + count + " ясных дней");
    }


    static int[] getWeatherDataInFebruary() {
        Random rnd = new Random();
        int[] arr = new int[29];
        for (int i = 0; i < 29; i++) {
            int tmp = rnd.nextInt((1 - 0) + 1);
            arr[i] = tmp;
        }
        return arr;
    }

    static void printJointSalaryInJune(int[][] arr) {
        final int MOTH_JUNE = 5;
        int jointSum = 0;
        int countEmployees = arr.length;

        for (int i = 0; i < countEmployees; i++) {
            jointSum += arr[i][MOTH_JUNE];
        }
        System.out.printf("Общая сумма выплат всем сотрудникам в июне составила %.1f рублей", (float) jointSum);
    }

    static int[][] getSalaryTable(int countEmp) {
        final int COUNT_MOTH = 12;
        int countEmployees = countEmp;
        int minSalary = 10000;
        int maxSalary = 125000;
        int[][] table = new int[countEmployees][COUNT_MOTH];
        Random rnd = new Random();

        for (int i = 0; i < countEmployees; i++) {
            for (int j = 0; j < COUNT_MOTH; j++) {
                table[i][j] = rnd.nextInt((maxSalary - minSalary) + minSalary);
            }
        }
        return table;
    }

    public static void main(String[] args) {
        //1 напечатать цифры
      printDigitsInString("one two 90world757 test987 int32p098;");
       //2 рекурсивный вариант Фибоначчи
      System.out.println(fibonacciNumbersRecursive(10,0,1,2));
      //2 итеративный вариант Фибоначчи
      System.out.println(fibonacciNumbersIterate(-10));
        //напечатать четные а потом нечетные числа. массив с числами взял из другого метода.
      printEvenAndOddElements(getWeatherDataInFebruary());
        //Вывести количество дней  без осадков
      RainDaysInMouthPrint(getWeatherDataInFebruary());
        //Вывести общую зп за июнь
      printJointSalaryInJune(getSalaryTable(18));

    }
}
