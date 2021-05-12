package com.Oberon1989;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        int cut=0;
        Scanner scanner=new Scanner(System.in);

        System.out.println("введите количество едоков");
        int eaters = scanner.nextInt();

        if(eaters%2==0){

            cut=eaters/2;
        }

        else if(eaters>1){
            cut=eaters;
        }
        System.out.println(String.format("Дабы каждому едоку досталось по равному куску необходимо сделать %s разрезов",cut));
    }
}
