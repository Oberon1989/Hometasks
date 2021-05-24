package com.Oberon1989.tasks_7;

import java.util.Scanner;

public class fatMens {
    public static void main(String[] args) {
        final int MIN_WEIGHT = 94;
        final int MAX_WEIGHT = 727;
        int mass1, mass2, mass3;
        int min = 0;
        int max = 0;
        Scanner scanner = new Scanner(System.in);
        mass1 = scanner.nextInt();
        mass2 = scanner.nextInt();
        mass3 = scanner.nextInt();

        if (mass1 < mass2) {
            min = mass1;
        } else {
            min = mass2;
        }
        if (mass3 < min) {
            min = mass3;
        }

        if (mass1 > mass2) {
            max = mass1;
        } else {
            max = mass2;
        }
        if (mass3 > max) {
            max = mass3;
        }

       if((mass1<MIN_WEIGHT||mass1>MAX_WEIGHT) || (mass2<MIN_WEIGHT||mass2>MAX_WEIGHT) || (mass3<MIN_WEIGHT||mass3>MAX_WEIGHT))
       {
           System.out.println("Error");
           return;
       }
       System.out.println(max);
    }
}
