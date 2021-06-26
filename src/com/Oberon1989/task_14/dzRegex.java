package com.Oberon1989.task_14;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dzRegex {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        // 1 задание

        String reg = "[0-9]{1}[+]{1}[0-9]";
        String str = "2+3 223 2223";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {

            System.out.println(matcher.group());
        }

        //2 задание

        reg = "(http|https)://[\\w]+(\\.)?([\\w]+)?[\\.][\\w]{2,4}";
        pattern = Pattern.compile(reg);
        System.out.println("Введите домен для проверки");
        str = scanner.next();

        matcher = pattern.matcher(str);

        if (matcher.find()) {
            System.out.println("Корректная запись домена");
            System.out.println(str.substring(matcher.start(), matcher.end()));
        }
        else {
            System.out.println("Некорректная запись домена");
        }

        //3 задание

        str = "http://ya.ru https://google.com https://hh.ru https//mail.ru http://change.org https://hithub.com";
        matcher = pattern.matcher(str);

        while (matcher.find()) {
            int index = matcher.group().lastIndexOf('/') + 1;
            String oldSequence = matcher.group();
            String newSequence = String.format("<a href = \"%s\">%s<\\a>",oldSequence,oldSequence.substring(index));
            str=str.replace(oldSequence,newSequence);
        }

        System.out.println(str);


        //4 задание

        reg = "([0-1][0-9]|2[0-3]):[0-5][0-9]";
        pattern = Pattern.compile(reg);
        System.out.println("Введите время для проверки");
        str = scanner.next();
        matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.printf("Формат записи времени вида %s является корректным\n", matcher.group());
        }
        else {
            System.out.println("Некорректный формат времени");
        }

        //5 задание

        reg = "([0-2][0-9]|3[0-1])/(0[0-9]|1[0-2])/[0-9]{4}";
        pattern = Pattern.compile(reg);
        System.out.println("Введите дату для проверки");
        str = scanner.next();
        matcher = pattern.matcher(str);

        if (matcher.find()) {
            System.out.printf("Дата вида %s является корректной\n", matcher.group());
        }
        else {
            System.out.println("Некорректный формат даты");
        }

        //6 задание

        reg = "[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}";
        pattern = Pattern.compile(reg);
        System.out.println("Введите IP адрес для проверки");
        str = scanner.next();
        matcher = pattern.matcher(str);

        if (matcher.find()) {
            System.out.printf("IP адрес формата %s является корректным\n", matcher.group());
        } else {
            System.out.println("Некорректный IP адрес");
        }


    }
}
