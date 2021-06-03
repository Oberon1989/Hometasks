package com.Oberon1989.task_9;

import java.util.Scanner;

//Буду честен алгоритм я посмотрел в сети. пробежался по нему отладчиком но но все равно работу его не уловил.
//Поэтому данное задание я не сделал
public class grandFatherCold {
    public static void main(String[] args) {
        int x, y, z, w, tmpX, tmpY;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        y = scanner.nextInt();
        z = scanner.nextInt();
        w = scanner.nextInt();


        for (int i = 0; i <= w / x; i++) {
            tmpX = x * i;

            for (int j = 0; j <= (w - tmpX) / y; j++) {

                tmpY = y * j;
                int tmpZ = w - (tmpX + tmpY);

                if (tmpZ % z == 0) {
                    sum++;
                }
            }
        }
        System.out.println(sum);

    }
}
