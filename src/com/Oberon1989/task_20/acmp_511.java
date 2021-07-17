package com.Oberon1989.task_20;

import java.util.Scanner;

public class acmp_511 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int MAX_CLIENTS=(12*60/5);
        int queueCount= scanner.nextInt();
        if(queueCount>MAX_CLIENTS)
        {
            System.out.println("No");
        }
        else
        {
            int t=queueCount*5-5;
            if(t<0)
            {
                System.out.println("No");return;
            }

            System.out.println(t/60+" "+t%60);

        }


    }
}
