package com.Oberon1989;

public class Book_5_13 {
    /*Мне показалось скучным вывести просто таблицу умножения на 7. Поэтому я решил вывести всю таблицу от 2 до 9

    Код не оптимальный и присутствуют MAGIC_NUMBERS но это работает =)
     */
    public static void main(String[] args) {

        System.out.println(multiplicationTable());
    }
    public static String multiplicationTable()
    {
        String result="";
        int row = 4;
        int start =1;
        int count=2;
        int tmp=count;
        int columns=0;
        while (columns<2) {

            for(int k=1;k<10;k++) {
                for (int i = 2; i < row+2; i++) {
                    if(count*start>9)
                    {
                        result += String.format("%s * %s = %s   ",count,start,count*start);
                    }
                    else
                    {
                        result += String.format("%s * %s = %s    ",count,start,count*start);
                    }

                    count++;

                }

                count=tmp;

                result+="\n";
                start++;
            }
            result+="\n";
            columns++;
            count=6;
            tmp=6;
            start=1;
        }
        return  result;
    }
}
