package com.Oberon1989.task_13;

import java.util.Scanner;

public class tasks13 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s1 = "";
        int length = 0;
        //получить слово образованое нечетными символами строки

        System.out.println("Введите слово");
        s1 = scanner.next();
        StringBuilder builder = new StringBuilder();
        length = s1.length();

        for (int i = 0; i < length; i++) {
            if (i % 2 != 0) {
                builder.append(s1.charAt(i));
            }
        }
        String s2 = new String(builder);
        System.out.println(s2);

        //напечатать название футбольного клуба в столбик

        s1 = "Cork City Football Club";
        length = s1.length();

        for (int i = 0; i < length; i++) {
            System.out.println(s1.charAt(i));
        }

        //Дано слово из четного числа букв. Поменять местами его половины
        s1 = "Хорошо";
        length = s1.length();
        s1 = s1.substring(length / 2) + s1.substring(0, length / 2);
        System.out.println(s1);

        // из слова яблоко путем вырезок и склеек его букв получить слова блок и око

        s1 = "Яблоко";
        int startIndex = s1.indexOf('б');
        int endIndex = s1.indexOf('к');
        String block = s1.substring(startIndex, endIndex + 1);
        startIndex = s1.indexOf('о');
        String oko = s1.substring(startIndex);
        System.out.println(block);
        System.out.println(oko);

        //дано слово определить одиноковы ли второй и четвертый символ в нем

        System.out.println("введите слово");
        s1 = scanner.next();
        char secondSymbol = s1.charAt(1);
        char fourthSymbol = s1.charAt(3);
        System.out.println(secondSymbol == fourthSymbol ? "Символы одиноковы" : "Символы различны");
    }
}
