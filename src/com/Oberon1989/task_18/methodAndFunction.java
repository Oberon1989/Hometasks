package com.Oberon1989.task_18;

import java.util.Locale;
import java.util.Scanner;

public class methodAndFunction {
    public static void main(String[] args) {
        System.out.println("Вычисление выражения");
        System.out.println(calculate());
        System.out.println();

        System.out.println("Сравнение 2-х чисел по сумме цифр в кажом числе");
        maxSumDigits(333, 5001);
        System.out.println();

        System.out.println("Сравнение строк, в какой строке процент буквы \"а\" выше");
        maxPercentSymbol('а');
        System.out.println();

        System.out.println("Линия");
        printLine('*', 10);
        System.out.println();

        System.out.println("Прямоугольник");
        printRectangle(5, 5, "*");
        System.out.println();

        System.out.println("Прямоугольник c использованием метода printLine");
        printRectangle(5, 5, '#');
        System.out.println();

        System.out.println("Рекурсивный подсчет факториала");
        System.out.println(factRecursive(5));


    }

    //суммируем выражение
    static float calculate() {
        float a = 2 * fact(5) + 3 * fact(8);
        float b = fact(6) + fact(4);
        return Float.parseFloat(String.format(Locale.US, "%.2f", a / b));
    }

    //подсчет факториала//
    static int fact(int num) {
        int result = 1;
        //Число не должно быть меньше 1 и больше 12. факториал числа 13 уже не входит в диапазон INT 32
        if (num < 1 || num > 12) {
            return -1;
        }
        //факториал числа 1 равен 1
        if (num == 1) {
            return 1;
        }

        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    //сравниваем 2 числа и выводим на экран то число в котором сумма цифр больше
    static void maxSumDigits(int a, int b) {
        int sumA = sumDigits(a);
        int sumB = sumDigits(b);

        if (sumA > sumB) {
            System.out.printf("Сумма цифр первого числа больше\nЧисло - %s Сумма цифр - %s\n", a, sumA);
        } else {
            System.out.printf("Сумма цифр второго числа больше\nЧисло - %s Сумма цифр - %s\n", b, sumB);
        }
    }

    //подсчитываем сумму цифр в числе
    static int sumDigits(int num) {
        int length = Integer.toString(num).length();
        int sum = 0;

        for (int i = 0; i < length; i++) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    //выводим на экран полученный процент
    static void maxPercentSymbol(char ch) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое предложение...");
        float firstLinePercent = getPercentSymbol(ch, scanner.nextLine());

        System.out.println("Введите второе предложение...");
        float secondLinePercent = getPercentSymbol(ch, scanner.nextLine());

        if (firstLinePercent > secondLinePercent) {
            System.out.printf("Процент буквы %s в первой строке больше. Он составляет %s%%\n", ch, firstLinePercent);
        } else if (secondLinePercent > firstLinePercent) {
            System.out.printf("Процент буквы %s во второй строке больше. Он составляет %s%%\n", ch, secondLinePercent);
        } else {
            System.out.printf("Процент буквы %s обоих строках равен. Он составляет %s%%\n", ch, firstLinePercent);
        }
    }

    //Получаем процент символа в строке
    static float getPercentSymbol(char ch, String str) {
        float countSymbol = 0;
        char[] symbols = str.toCharArray();
        float length = symbols.length;

        for (int i = 0; i < length; i++) {
            if (Character.toLowerCase(symbols[i]) == ch) {
                countSymbol++;
            }
        }

        return Float.parseFloat(String.format(Locale.US, "%.2f", countSymbol / length * 100));
    }

    //рисуем прямоугольник через 2 фора
    static void printRectangle(int height, int width, String symbol) {

        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {

                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    System.out.printf("%-2s", symbol);
                } else {
                    System.out.printf("%-2s", " ");
                }

            }
            System.out.println();
        }
    }

    //Рисуем прямоугольник
    //перегруженный метод с использованием метода printLine
    static void printRectangle(int height, int width, char ch) {

        for (int i = 0; i < height; i++) {

            if (i == 0 || i == height - 1) {
                printLine(ch, width);
            } else {
                printLine(Character.toString(ch), width);
            }

        }
    }

    //рисуем линию
    static void printLine(char symbol, int length) {

        for (int i = 0; i < length; i++) {
            System.out.printf("%-2s", symbol);
        }
        System.out.println();

    }

    //перегруженый метод
    static void printLine(String s, int length) {


        for (int i = 0; i < length; i++) {

            if (i == 0 || i == length - 1) {
                System.out.printf("%-2s", s);
            } else {
                System.out.printf("%-2s", " ");
            }

        }
        System.out.println();
    }

    //подсчет факториала рекурсивным путем
    //выражение не мое. когда то давно я увидел подобную конструкцию и запомнил
    //Мне не до конца понятен механизм
    static int factRecursive(int num) {
        if (num == 1) return 1;
        return num * factRecursive(num - 1);
    }
}
