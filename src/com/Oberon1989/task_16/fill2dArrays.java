package com.Oberon1989.task_16;

import java.util.Arrays;
import java.util.Random;

public class fill2dArrays {


    public static void main(String[] args) {


        int[][] offsetArr = offsetFilling(5);
        array2dPrint(offsetArr);
        System.out.println();

        int[][] spiralArr = spiralFilling(5, 5, 1);
        array2dPrint(spiralArr);
        System.out.println();

        int[][] notOverlapArr = notOverlapFill(5);
        array2dPrint(notOverlapArr);
        System.out.println();

        int count = 15;
        int[] singleArr = uniqueDigitFill(count);


        for (int i = 0; i < count; i++) {
            System.out.printf("%-5d", singleArr[i]);
        }
        System.out.println("\nОтсортированный массив для проверки");
        Arrays.sort(singleArr);

        for (int i = 0; i < count; i++) {
            System.out.printf("%-5d", singleArr[i]);
        }


    }

    private static int[][] offsetFilling(int m) {
        int[][] arr = new int[m][m];
        int offset = -m;
        int curNum = 1;
        boolean isFill = true;
        boolean isRightPart = false;

        arr = clear2dArr(arr);
        do {
            isFill = arr[m - 1][m - 1] == 0 ? false : true;

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < m; j++) {

                    if (i + j == m + offset) {
                        arr[i][j] = curNum;
                    }
                }
            }
            offset++;

            if (!isRightPart) {
                curNum++;

                if (curNum == m) {

                    isRightPart = true;
                }
            } else {
                curNum = 1;
                isRightPart = false;
            }
        }
        while (!isFill);

        return arr;
    }

    private static int[][] spiralFilling(int m, int n, int curNumber) {
        int[][] arr = new int[m][n];
        int max = m * n + 1;//что бы заполнить последний элемент требуется еще один проход цикла

        //направление обхода
        int dirM = 0;
        int dirN = 1;

        //текущая позиция
        int y = 0;
        int x = 0;

        //смещение
        int offset = 0;
        int direction = 1;
        int currentNumber = curNumber;

        arr = clear2dArr(arr);


        for (int i = 1; i < max; i++) {

            switch (direction) {//выбор направления обхода

                case 1: {
                    //right run
                    if (x <= n - 1 - offset) {
                        arr[y][x] = currentNumber;
                    }

                    if (x == n - 1 - offset) {
                        dirM = 1;
                        dirN = 0;
                        direction = 2;

                    }
                }
                break;
                //down run
                case 2: {

                    if (y <= m - 1 - offset) {
                        arr[y][x] = currentNumber;
                    }

                    if (y == m - 1 - offset) {
                        dirM = 0;
                        dirN = -1;
                        direction = 3;
                    }
                }
                break;
                //left run
                case 3: {

                    if (x >= 0 + offset) {
                        arr[y][x] = currentNumber;
                    }

                    if (x == 0 + offset) {
                        dirM = -1;
                        dirN = 0;
                        direction = 4;
                    }
                }
                break;

                case 4: {
                    //up run
                    if (arr[y - 1][x] != 0) {
                        offset++; //если следующий элемент уже не пуст то смещаемся
                    }

                    if (y >= offset) {
                        arr[y][x] = currentNumber;
                    }

                    if (y == offset) {

                        dirM = 0;
                        dirN = 1;
                        direction = 1;
                    }
                }
                break;
            }
            x += dirN;
            y += dirM;
            currentNumber++;
        }
        return arr;
    }

    private static int[][] notOverlapFill(int m) {
        int[][] arr = new int[m][m];
        Random rnd = new Random();
        int y;
        int x;
        int count = 0;
        arr = clear2dArr(arr);
        boolean isFill = false;
        while (!isFill) {

            y = rnd.nextInt(m - 1) + 1;
            x = rnd.nextInt(m - 1) + 1;
            if (arr[y][x] == 0) {
                arr[y][x] = 1;
                count++;

            }
            if (count == m) {
                isFill = true;
            }
        }
        return arr;
    }

    private static int[] uniqueDigitFill(int count) {
        int[] arr = new int[count];
        Random rnd = new Random();
        int curNum;
        int counter = 0;
        boolean isFill = false;
        boolean isContains = false;

        for (int i = 0; i < count; i++) {
            arr[i] = 0;
        }

        while (!isFill) {
            isContains = false;
            isFill = true;
            curNum = rnd.nextInt(count) + 1;
            for (int i = count - 1; i >= 0; i--) {
                if (arr[i] == curNum) {
                    isContains = true;
                }
            }
            if (!isContains) {
                arr[counter] = curNum;
                counter++;
            }

            for (int i = count - 1; i >= 0; i--) {
                if (arr[i] == 0) {
                    isFill = false;
                }
            }
        }

        return arr;
    }

    private static void array2dPrint(int[][] arr) {
        int columnsCount = arr.length;
        int rowsCount;

        for (int i = 0; i < columnsCount; i++) {
            rowsCount = arr[i].length;

            for (int j = 0; j < rowsCount; j++) {
                System.out.printf("%-5d", arr[i][j]);
            }
            System.out.println();
        }

    }

    private static int[][] clear2dArr(int[][] arr) {
        int columnsCount = arr.length;
        int rowsCount;
        for (int i = 0; i < columnsCount; i++) {
            rowsCount = arr[i].length;
            for (int j = 0; j < rowsCount; j++) {
                arr[i][j] = 0;
            }
        }
        return arr;
    }
}


