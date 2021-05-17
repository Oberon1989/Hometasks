import java.util.Random;
import java.util.Scanner;

public class progerDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(GetDate(scanner.nextInt()));
    }

    public static String GetDate(int year) {

        int numberDay=256;
        int month = 0;
        int day = 0;
        int pos = 0;
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (year % 400 == 0) {
            months[1] = 29;

        } else if (year % 4 == 0 && year % 100 != 0) {
            months[1] = 29;

        } else {
            months[1] = 28;
        }

        for (int i = 0; i < months.length; i++) {
            if (pos >= numberDay) {

                month = i;
                pos -= numberDay;
                day = months[i - 1] - pos;
                break;
            }
            pos += months[i];
        }

        String result = "";
        if (day <= 9) {
            result += "0" + day + "/";
        }

        else
        {
            result += day + "/";
        }

        if (month <= 9) {
            result += "0" + month + "/";
        }

        else
        {
            result += month + "/";
        }

        if (year <= 9) {
            result += "000" + year;
        }

        else if (year <= 99) {
            result += "00" + year;
        }

        else if (year <= 999) {
            result += "0" + year;
        }

        else {
            result += year;
        }

        return result;

    }
}
