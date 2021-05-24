package com.Oberon1989.tasks_7;


import java.util.Arrays;
import java.util.Scanner;

public class census {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfResidents = Integer.parseInt(scanner.nextLine());
        int[] allResidents = new int[numberOfResidents];
        int max = 0;
        int count = 0;

        for (int i = 0; i < numberOfResidents; i++) {
            int[] tmp = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();// получаем массив int[2] для временного
                                                                                                                //  хранения возраста и пола
            if (tmp[1] == 1) {
                allResidents[i] = tmp[0];
            } else {
                allResidents[i] = 0;
            }
        }

        for (int i = 0; i < allResidents.length; i++) {

            if (allResidents[i] > max)
            {
                max = allResidents[i];
                count = i;
            }

        }
        if(max>0) {
            System.out.println(count);
        }
        else
        {
            System.out.println(-1);
        }


    }

}

