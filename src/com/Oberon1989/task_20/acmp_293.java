package com.Oberon1989.task_20;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_293 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("INPUT.txt"));
        double max;
        int number=0;
        int companyCount = scanner.nextInt();
        double arr[] = new double[companyCount];
        double[] percent =new double[companyCount];
        for (int i = 0; i < companyCount; i++) {
            arr[i]=scanner.nextInt();
        }
        for (int i = 0; i < companyCount; i++) {
            percent[i]=scanner.nextInt();
        }
       max=arr[0]*(percent[0]/100);
        for (int i = 0; i < companyCount; i++) {
            if(arr[i]>=0&&percent[i]>=0) {
                double per = arr[i] * (percent[i] / 100);
                if (max < per) {
                    max = per;
                    number = i;
                }
            }
        }
        System.out.println(number+1);
    }
}
