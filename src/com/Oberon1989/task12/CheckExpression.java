package com.Oberon1989.task12;

import java.util.Scanner;

public class CheckExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение для проверки...");
        boolean isRight = isCorrectExpression(scanner.nextLine());

        if (!isRight) {
            System.out.println("Выражение неверное!");
        } else {
            System.out.println("Выражение верное!");
        }

    }

    static boolean isCorrectExpression(String str) {
        char[] symbols = new char[]{'(', ')', '[', ']', '{', '}'};
        int[] counts = new int[symbols.length];

        for (int i = 0; i < symbols.length; i++) {
            counts[i] = countContains(symbols[i], str);
        }

        for (int i = 0; i < counts.length - 1; i += 2) {
            if (counts[i] != counts[i + 1]) {
                return false;
            }
        }

        return true;
    }

    static int countContains(char ch, String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }

        return count;
    }


}
