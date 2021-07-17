package com.Oberon1989.task_20;

import java.util.Scanner;

public class acmp_46 {
    public static void main(String[] args) {
        int start=2;
        String E= "2.7182818284590452353602875";
        StringBuilder builder = new StringBuilder("2.");
        Scanner scanner = new Scanner(System.in);
        int count =scanner.nextInt();
        if(count==0)
        {
            System.out.println(3);
            return;
        }
        for (int i = start; i < count+start; i++) {
            builder.append(E.charAt(i));
        }
        System.out.println(builder.toString());
    }
}
