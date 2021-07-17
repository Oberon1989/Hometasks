package com.Oberon1989.task_20;

import java.lang.*;
import java.util.Scanner;

public class acmp_675 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int N=scanner.nextInt();
        int M= scanner.nextInt();


        int distance=M;
        String []arr=new String[N];
        for (int i = 0; i < N; i++) {

                arr[i] = scanner.nextLine();

            int first=arr[i].lastIndexOf('A');
            int last=arr[i].indexOf('B');
            int tmp=last-(first+1);
            if(tmp>=0)
            {
                if (tmp<distance)
                {
                    distance=tmp;
                }
            }


        }
        System.out.println(distance);
    }
}

