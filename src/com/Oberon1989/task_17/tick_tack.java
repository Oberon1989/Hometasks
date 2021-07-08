package com.Oberon1989.task_17;

import java.util.Random;
import java.util.Scanner;

public class tick_tack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        final char EMPTY_CELL = '.';
        final char CROSS_SYMBOL = 'X';
        final char NULL_SYMBOL = 'O';
        int fieldSize = 3;
        char[][] field = new char[fieldSize][fieldSize];
        boolean isGameOver = false;
        boolean isCorrectInput;
        int step = 1;
        int y = 0;
        int x = 0;
        clearFill(field, fieldSize, EMPTY_CELL);

        while (!isGameOver) {

            if (isVoidSpace(field, EMPTY_CELL, fieldSize)) {

                switch (step) {
                    case 1:
                        printField(field, fieldSize, EMPTY_CELL);
                        System.out.println(String.format("Введите координаты ячейки куда хотите поставить знак.\nКоординаты представляют собой два числа разделеных пробелом\n" +
                                "и должны быть в пределах от 0 включительно до %s включительно", fieldSize - 1));
                        isCorrectInput = false;

                        do {
                            try {
                                y = scanner.nextInt();
                                x = scanner.nextInt();

                                if (y >= 0 && y <= fieldSize - 1 && x >= 0 && x <= fieldSize - 1) {

                                    if (checkCell(field, fieldSize, EMPTY_CELL, y, x)) {
                                        move(CROSS_SYMBOL, field, y, x);
                                        isCorrectInput = true;

                                    }

                                } else throw new Exception();

                            } catch (Exception ex) {
                                System.out.println("Ваш ввод не распознан, пожалуйста повторите");
                            }
                        }
                        while (!isCorrectInput);

                        printField(field, fieldSize, EMPTY_CELL);

                        if (checkAllLines(CROSS_SYMBOL, field, fieldSize)) {
                            isGameOver = true;
                            System.out.println("Вы победили");
                            break;
                        } else {
                            step = 2;
                        }
                        break;
                    case 2:


                        isCorrectInput = false;
                        do {
                            y = rnd.nextInt(fieldSize);
                            x = rnd.nextInt(fieldSize);
                            if (checkCell(field, fieldSize, EMPTY_CELL, y, x)) {
                                move(NULL_SYMBOL, field, y, x);
                                isCorrectInput = true;
                            }
                        }
                        while (!isCorrectInput);
                        printField(field, fieldSize, EMPTY_CELL);
                        if (checkAllLines(NULL_SYMBOL, field, fieldSize)) {
                            System.out.println("Комп победил");
                            isGameOver = true;
                            break;
                        } else {
                            step = 1;
                        }
                        break;
                }


            } else {
                isGameOver = true;
                System.out.println("Ничья!");
            }
        }

    }

    public static void clearFill(char[][] arr, int size, char emptySymbol) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = emptySymbol;
            }
        }
    }


    public static boolean checkCell(char[][] arr, int size, char emptySymbol, int y, int x) {
        if (arr[y][x] == emptySymbol) {
            return true;
        } else {
            System.out.printf("Клетка %s:%s уже занята\n", y, x);
            return false;

        }

    }
//ход
    public static void move(char symbol, char[][] arr, int y, int x) {
        arr[y][x] = symbol;
    }
//вывод со смещением
    public static void printField(char[][] arr, int size, char empty) {
        int lines = 50;
        for (int i = 0; i < lines; i++) {
            System.out.println();
        }

        System.out.printf("Игровое поле. символ \"%s\" это пустое пространство\n", empty);
        System.out.println();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%-5c", arr[i][j]);
            }
            System.out.println();
        }
    }

    //проверка на возможность хода
    public static boolean isVoidSpace(char[][] arr, char emptySymbol, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i][j] == emptySymbol) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkHorizontal(char symbol, char[][] field, int size) {
        boolean isLine = true;

        int k = 0;
        for (int i = 0; i < size; i++) {
            isLine = true;
            for (int j = 0; j < size; j++) {
                k = j;
                if (field[i][j] != symbol) {

                    isLine = false;
                }

            }
            if (isLine) {
                return true;
            }
        }
        return isLine;
    }

    public static boolean checkVertical(char symbol, char[][] field, int size) {
        boolean isLine = true;

        int k = 0;
        for (int i = 0; i < size; i++) {
            isLine = true;
            for (int j = 0; j < size; j++) {
                k = j;
                if (field[j][i] != symbol) {
                    isLine = false;
                }
            }
            if (isLine) {
                return true;
            }
        }
        return isLine;
    }

    public static boolean checkDiagonals(char symbol, char[][] field, int size) {
        boolean mainDiagonal = true;
        boolean sideDiagonal = true;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    if (field[i][j] != symbol) {
                        mainDiagonal = false;

                    }
                }
                if (i + j == size - 1) {
                    if (field[i][j] != symbol) {
                        sideDiagonal = false;
                    }
                }
            }
        }
        if (mainDiagonal) {


            return true;

        }
        if (sideDiagonal) {

            return true;
        }

        return false;
    }
//Проверка на победу
    public static boolean checkAllLines(char symbol, char[][] field, int size) {
        boolean check = checkDiagonals(symbol, field, size);
        if (!check) {
            check = checkHorizontal(symbol, field, size);
            if (!check) {
                check = checkVertical(symbol, field, size);
            }
        }
        return check;
    }


}

