package com.Oberon1989;

import java.util.Scanner;

public class Arithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter A");
        int a = scanner.nextInt();

        System.out.println("Enter B");
        int b = scanner.nextInt();

        System.out.println("Enter C");
        int c = scanner.nextInt();

        if(a*b==c)
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
    }
}
