package com.Oberon1989.tasks_7;
import java.util.Scanner;

public class elevator {

    public static void main(String[] args) {
        final int UP = 1;
        final int DOWN = 2;
        int currentFloor = 0;
        int minFloor = 0;
        int maxFloor = 0;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            if (Character.getNumericValue(input.charAt(i)) == UP) {
                currentFloor++;
            }

            if (currentFloor > maxFloor) {
                maxFloor = currentFloor;
            }

            if (Character.getNumericValue(input.charAt(i)) == DOWN) {
                currentFloor--;
            }

            if (currentFloor < minFloor) {
                minFloor = currentFloor;
            }
        }

        System.out.println(maxFloor - minFloor + 1);

    }

}



