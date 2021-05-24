package com.Oberon1989;

import java.util.Scanner;

public class coin {
    public static void main(String[] args) {
        int eagleCount=0;
        int tailCount=0;
        int i=0;
        Scanner scanner = new Scanner(System.in);
        int coinsCount=scanner.nextInt();

        while(i<coinsCount)
        {
            if (scanner.nextInt() == 1) {
                tailCount++;
            } else {
                eagleCount++;
            }
            i++;
        }
        System.out.println(eagleCount<tailCount?eagleCount:tailCount);
    }
}
