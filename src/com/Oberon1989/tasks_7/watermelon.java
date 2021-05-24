package com.Oberon1989.tasks_7;

import java.util.Arrays;
import java.util.Scanner;

public class watermelon {
    public static void main(String[] args) {

        int max=0;
        int min = 30000;
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int[] weight = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if(weight.length==1)
        {
            max= weight[0];
            min=weight[0];
            System.out.printf("%s %s",max,min);
            return;
        }

        for (int i=0;i<weight.length;i++)
        {
            if(weight[i]>max)
            {
                max=weight[i];
            }
            if(weight[i]<min)
            {
                min=weight[i];
            }

        }

        System.out.printf("%s %s",min,max);

    }
}
