package com.Oberon1989.task_20;

import java.util.Random;
import java.util.Scanner;

public class methodsForArray {
    public static int[] createArray(int length) {
        return new int[length];
    }

    public static void clearArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }

    public static int getLength(int[] array) {
        return array.length;
    }

    public static void setElement(int[] array, int index, int value) throws Exception {
        if (index < 0 || index > array.length - 1) {
            throw new Exception("Выход за границы массивы");
        }

        array[index] = value;
    }

    public static int getElement(int[] array, int index) throws Exception {
        if (index < 0 || index > array.length - 1) {
            throw new Exception("Выход за границы массивы");
        }

        return array[index];
    }

    public static int[] add(int[] array, int value) {
        int[] tempArray = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[i];
        }

        tempArray[tempArray.length - 1] = value;

        return tempArray;
    }

    public static int[] insert(int[] array, int index, int value) throws Exception {
        if (index < 0 || index > array.length - 1) {
            throw new Exception("Выход за границы массивы");
        }

        int[] tempArray = new int[array.length + 1];

        for (int i = 0; i < index; i++) {
            tempArray[i] = array[i];
        }

        tempArray[index] = value;

        for (int i = index; i < array.length; i++) {
            tempArray[i + 1] = array[i];
        }

        return tempArray;
    }

    public static int[] delete(int[] array, int index) throws Exception {
        if (index < 0 || index > array.length - 1) {
            throw new Exception("Выход за границы массивы");
        }

        int[] tempArray = new int[array.length - 1];

        for (int i = 0; i < index; i++) {
            tempArray[i] = array[i];
        }

        for (int i = index + 1; i < array.length; i++) {
            tempArray[i - 1] = array[i];
        }

        return tempArray;
    }

    public static void rightOffset(int[]arr,int step){
        int length=arr.length;

        for (int i = 0; i < step; i++) {

            int tmp=arr[length-1];

            for (int j = length - 1; j > 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[0]=tmp;
        }
    }

    public static void leftOffset(int[]arr,int step){
        int length=arr.length;

        for (int i = 0; i < step; i++) {

            int tmp=arr[0];

            for (int j =0;j<length-1; j++) {
                arr[j] = arr[j+1];
            }
            arr[length-1]=tmp;
        }
    }

    public static int simpleSearch(int[] arr,int value)
    {
        int index=-1;
        int length=arr.length;

        for (int i = 0; i < length; i++) {
            if(arr[i]==value)
            {
                index=i;
            }
        }
        return index;
    }

    public static void replaceElement(int[] arr,int oldValue,int newValue) throws Exception {
        int index = simpleSearch(arr,oldValue);

        if(index>=0)
        {
            setElement(arr,index,newValue);
            System.out.println("Установлено новое значение");
        }
        else
        {
            System.out.println("Ошибка! Значение "+oldValue+" Не обнаруженно в массиве");
        }
    }


    public static void bubbleSort(int[] arr)
    {
        int offset=0;
        int length=arr.length;
        boolean isSorted;
        do {
            isSorted=true;
            for (int i = 0; i < length-1-offset; i++) {
                if(arr[i]>arr[i+1])
                {
                    isSorted=false;
                    int tmp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=tmp;
                }
            }
            offset++;
        }
        while (!isSorted);
    }

    public static int binarySearch(int[] coll, int elem) {
        int index = -1;
        int middle = coll.length / 2;
        int first = 0;
        int last = coll.length - 1;

        if (elem < coll[first] || elem > coll[last]) return -1;

        do {
            if (elem < coll[middle]) {
                last = middle - 1;
                middle = (first + last) / 2;
            }
            else if (elem > coll[middle]) {
                first = middle + 1;
                middle = (first + last) / 2;

            }
            else {
                index = middle;
                break;
            }
        }
        while (first <= last);

        return index;
    }


    public static void main(String[] args) throws Exception {
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        int action = -1;
        boolean isRun = true;
        int[] array = null;

        while (isRun) {

            System.out.println("Меню:");
            System.out.println("1. Создать массив");
            System.out.println("2. Обнулить массив");
            System.out.println("3. Вывести массив");
            System.out.println("4. Заполнить массив случайными значениями");
            System.out.println("5. Добавить элемент в конец массива");
            System.out.println("6. Добавить элемент в указанный индекс");
            System.out.println("7. Удалить элемент по указанному индексу");
            System.out.println("8. Поиск элемента BinarySearch");
            System.out.println("9. Простой поиск");
            System.out.println("10. Сортировка пузырьком");
            System.out.println("11. Установить новое значение элемента");
            System.out.println("12. Сдвинуть массив вправо на указанное количество шагов");
            System.out.println("13. Сдвинуть массив влево на указанное количество шагов");
            System.out.println("0. Выход");

            System.out.print("Введите номер пункта меню: ");
            action = input.nextInt();

            switch (action) {
                case 1: {
                    System.out.print("Введите количество элементов массива: ");
                    int count = input.nextInt();

                    array = createArray(count);
                }
                break;

                case 2: {
                    clearArray(array);
                }
                break;

                case 3: {
                    for (int i = 0; i < getLength(array); i++) {
                        System.out.printf("%-5d", getElement(array, i));
                    }
                    System.out.println();
                }
                break;

                case 4: {
                    for (int i = 0; i < getLength(array); i++) {
                        setElement(array, i, random.nextInt(100));
                    }
                }
                break;

                case 5: {
                    System.out.print("Введите значение элемента массива: ");
                    int value = input.nextInt();

                    array = add(array, value);
                }
                break;

                case 6: {
                    System.out.print("Введите индекс элемента массива: ");
                    int index = input.nextInt();

                    System.out.print("Введите значение элемента массива: ");
                    int value = input.nextInt();

                    array = insert(array, index, value);
                }
                break;

                case 7: {
                    System.out.print("Введите индекс элемента массива: ");
                    int index = input.nextInt();

                    array = delete(array, index);
                }
                break;
                case 8:
                {
                    System.out.println("Введите число для поиска.");
                    int result =binarySearch(array,input.nextInt());
                    System.out.println(result>=0?result:"Число не найдено "+result);
                    break;
                }
                case 9:
                {
                    System.out.println("Введите значение для поиска");
                    int result =simpleSearch(array,input.nextInt());
                    System.out.println(result>=0?result:"Число не найдено "+result);
                    break;
                }
                case 10:
                {
                    System.out.println("Сортируем массив");
                    bubbleSort(array);
                    break;
                }
                case 11:
                {
                    System.out.println("Введите старое значение элемента и новое значение элемента");
                    replaceElement(array,input.nextInt(),input.nextInt());
                    break;
                }
                case 12:
                {
                    System.out.println("Сдвиг вправо. введите шаг");
                    int step =input.nextInt();
                    rightOffset(array,step);
                    break;
                }
                case 13:
                {
                    System.out.println("Сдвиг влево. Введите шаг");
                    int step =input.nextInt();
                    leftOffset(array,step);
                    break;
                }

                case 0: {
                    isRun = false;
                }
                break;

                default: {
                    System.out.println("Ошибка. Такой команды не существует");
                }
                break;
            }

        }
    }
}
