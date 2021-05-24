package com.Oberon1989.tasks_7;


import java.util.Arrays;
        import java.util.Scanner;

public class busExcursion {


    public static void main(String[] args) {
        final int BUS_HEIGHT =437;
        Scanner scanner = new Scanner(System.in);
        int bridgeCount = Integer.parseInt(scanner.nextLine());
        int[]bridges = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0;i<bridges.length;i++)
        {
            if(bridges[i]<=BUS_HEIGHT)
            {
                System.out.printf("Crash %s",i+1);return;
            }
        }
        System.out.println("No crash");
    }


}