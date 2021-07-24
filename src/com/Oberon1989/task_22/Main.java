package com.Oberon1989.task_22;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isWork = true;
        int action = 0;
        Lamp lamp = new Lamp();
        Scanner scanner = new Scanner(System.in);


        while (isWork) {
            System.out.println(lamp);
            System.out.println("Выберите действие путем ввода числа");

            System.out.println("1. Переключить состояние");
            System.out.println("2. Прибавить 10 % яркости");
            System.out.println("3. Убавить 10 % яркости");
            System.out.println("4. Изменить цвет");
            System.out.println("0. Выйти");

            try {
                action = scanner.nextInt();
            } catch (Exception ex) {
                action = -1;
            }

            switch (action) {

                case 1: {
                    lamp.setEnabled(!lamp.isEnabled());
                }
                break;

                case 2: {
                    lamp.increaseBrightness(10);
                }
                break;

                case 3: {
                    lamp.decreaseBrightness(-10);
                }
                break;

                case 4: {
                    System.out.println("Выберите цвет путем ввода числа");

                    for (int i = 0; i < Lamp.Colors.values().length; i++) {
                        System.out.printf("%s %s\n", i, Lamp.Colors.values()[i]);
                    }

                    try {
                        int colorNumber = scanner.nextInt();

                        if (colorNumber > Lamp.Colors.values().length - 1) {
                            throw new Exception("");
                        }

                        lamp.setColor(Lamp.Colors.values()[colorNumber]);
                    } catch (Exception ex) {
                        System.out.println("Выбрано неверное значение");
                        scanner = new Scanner(System.in);
                    }
                }
                break;

                case 0: {
                    isWork = false;
                    System.out.println("Работа завершена");
                }
                break;

                default: {
                    System.out.println("Команда не распознана");
                    scanner = new Scanner(System.in);
                }
                break;
            }
        }


    }
}
