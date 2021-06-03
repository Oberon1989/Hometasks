package com.Oberon1989.task_9;

import java.util.Random;
import java.util.Scanner;

public class guessTheNumber {
    public static void main(String[] args) {
        int complexity;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.printf("Введите уровень сложности указав цифру\nЛегкий :1\nСредний :2\nСложный :3 \nПроизвольный диапазон number number :4\n");
        int rangeMin = 1;
        int rangeMax = 0;
        int compNumber = 0;
        int userNumber = 0;
        int numberOfAttempts = 0;
        boolean isSuccess = false;
        String result = "";

        try {
            complexity = scanner.nextInt();

            switch (complexity) {
                case 1:
                    rangeMax = 10;
                    compNumber = random.nextInt(10) + 1;
                    break;

                case 2:
                    rangeMax = 100;
                    compNumber = random.nextInt(100) + 1;
                    break;

                case 3:
                    rangeMax = 1000;
                    compNumber = random.nextInt(1000) + 1;
                    break;

                case 4:
                    System.out.println("Введите границы диапазона");
                    rangeMin = scanner.nextInt();
                    rangeMax = scanner.nextInt();

                    if (rangeMin < 0 || rangeMax < 2) {
                        throw new Exception();

                    } else {

                        compNumber = random.nextInt(rangeMax - rangeMin + 1) + rangeMin;
                    }
                    break;
            }

        } catch (Exception e) {
            System.out.println("Неверный выбор уровня сложности! Выбран средний уровень...");
            rangeMax = 100;
            compNumber = random.nextInt(100) + 1;
            scanner = new Scanner(System.in);
        }

        System.out.printf("Введите число от %s до %s \n ", rangeMin, rangeMax);

        do {
            try {
                userNumber = scanner.nextInt();

            } catch (Exception e) {
                System.out.printf("Необходимо ввести число от %s до %s\n", rangeMin, rangeMax);

            }

            numberOfAttempts++;

            if (userNumber == compNumber) {
                result = String.format("Вы угадали число %s\nКоличество попыток : %s\n Оценка ", compNumber, numberOfAttempts);
                isSuccess = true;
            } else if (userNumber > compNumber) {
                System.out.printf("Неверное! Мое число меньше. Попробуйте от %S до %s\n", rangeMin, userNumber - 1);
            } else if (userNumber < compNumber) {
                System.out.printf("Неверное! Мое число больше. Попробуйте от %S до %s\n", userNumber + 1, rangeMax);
            }
        }
        while (!isSuccess);

        if (numberOfAttempts <= 5) {
            result += " - 5\nЭто супервезение!\n";
        } else if (numberOfAttempts > 6 && numberOfAttempts <= 10) {
            result += " - 4\nНеплохой результат!\n";
        } else if (numberOfAttempts >= 11 && numberOfAttempts <= 25) {
            result += " - 3\nПосредственно!\n";
        } else {
            result += " - 2\nПлохо!\n";
        }

        System.out.println(result);
    }


}
