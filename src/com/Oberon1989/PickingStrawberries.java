package com.Oberon1989;

import java.util.Scanner;

public class PickingStrawberries {
    public static void main(String[] args) {

        int x, y, z;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество ягод сорванных Машей");
        x = scanner.nextInt();

        System.out.println("Введите количество ягод сорванных Миша");
        y = scanner.nextInt();

        System.out.println("Введите количество съеденых ягод");
        z = scanner.nextInt();

        if (x + y > z) {
            String result = String.format("Маша собрала %s ягод, Миша собрал %s ягод \r\nОбщеее количество собраных ягод %s общее количество съеденых ягод %s осталось %s", x, y, x + y, z, x + y - z);
            System.out.println(result);
        } else {
            System.out.println("Ошибочка! Impossible! Судя по введенным данным ребята съели ягод больше чем собрали. Проверьте ввод");
        }
    }
}
