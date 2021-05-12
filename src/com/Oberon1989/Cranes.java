package com.Oberon1989;

import java.util.Scanner;

public class Cranes {
    public static void main(String[] args) {
        double allCranes;
        double katyaCount, petyaCount, seregaCount;
        final double FACTOR_X = 2;
        final double CHILDREN_COUNT = 3;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите общее количество изготовленных журавликов");
        allСranes = scanner.nextDouble();

        if (allСranes <= 0) {
            System.out.println("Ребята явно сделали больше нуля журавликов..");
            return;
        }
пше
        double tmp = allСranes / CHILDREN_COUNT;
        katyaCount = tmp * FACTOR_X;
        petyaCount = tmp / FACTOR_X;
        seregaCount = petyaCount;

        String result = String.format("Катя сделала %.2f журавликов, Петя сделал %.2f журавликов, Сережа сделал %.2f журавликов", katyaCount, petyaCount, seregaCount);
        System.out.println(result);


    }
}
