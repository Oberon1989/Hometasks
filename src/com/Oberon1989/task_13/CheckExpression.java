package com.Oberon1989.task_13;

import java.util.Scanner;

public class CheckExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение для проверки...");

        String input = scanner.nextLine();

        boolean isRight = checkString('(', ')', input);

        if (!isRight) {
            System.out.println("Выражение неверное");
            return;
        }
        isRight = checkString('[', ']', input);

        if (!isRight) {
            System.out.println("Выражение неверное");
            return;
        }

        isRight = checkString('{', '}', input);

        System.out.println(isRight ? "Выражение верное" : "Выражение неверное");


    }

    public static boolean checkString(char startSymbol, char endSymbol, String str) {


        int length = str.length();
        int countLeft = 0;
        int countRight = 0;

        if (str.indexOf(startSymbol) == -1 && str.indexOf(endSymbol) == -1) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == startSymbol) {
                countLeft++;
            }

            if (str.charAt(i) == endSymbol) {
                countRight++;
                if (countRight > countLeft) return false;
            }

        }

        if (countLeft != countRight || countRight != countLeft) {
            return false;
        }

        return true;
    }


}
