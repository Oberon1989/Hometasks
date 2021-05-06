import java.util.Locale;
import java.util.Scanner;

public class Task_02 {

    public static void main(String[] args) {
        final double METER = 100;
        final int MAX_COUNT = 3;
        double height = 0;
        double weight = 0;
        double bodyMassIndex;
        String resume;
        int count = 0;

        while (height == 0 || weight == 0) {
            if (count == MAX_COUNT) {
                System.out.println("Попытки закончились. Работа программы завершена...");
                return;
            }
            System.out.println(String.format("Введите рост в сантиметрах у вас есть %s попыток", MAX_COUNT - count));
            height = getDoubleValue();
            if (height == 0) {

                count++;
                height = 0;
                weight = 0;
                continue;
            }
            System.out.println(String.format("Введите вес в килограмамх у вас есть %s попыток", MAX_COUNT - count));
            weight = getDoubleValue();
            if (weight == 0) {

                count++;
                height = 0;
                weight = 0;
                continue;
            }
        }

        height = height / METER;
        bodyMassIndex = weight / (height * height);

        if (bodyMassIndex < 15.99) {
            resume = String.format("Индекс массы тела %.2f\r\nВыраженный дефицит массы тела.\r\nНизкий риск сердечно-сосудистых заболеваний.\r\nНеобходима срочная консультация специалиста.", bodyMassIndex);
            System.out.println(resume);
        } else if (bodyMassIndex >= 16 && bodyMassIndex <= 18.49) {
            resume = String.format("Индекс массы тела %.2f\r\nНедостаточная (дефицит) масса тела.\r\nНизкий риск сердечно-сосудистых заболеваний.\r\nНеобходима консультация специалиста.", bodyMassIndex);
            System.out.println(resume);
        } else if (bodyMassIndex >= 18.50 && bodyMassIndex <= 24.99) {
            resume = String.format("Индекс массы тела %.2f\r\nНормальный.\r\nОбычный риск сердечно-сосудистых заболеваний.", bodyMassIndex);
            System.out.println(resume);
        } else if (bodyMassIndex >= 25.00 && bodyMassIndex <= 29.99) {
            resume = String.format("Индекс массы тела %.2f\r\nИзбыточная масса тела (предожирение).\r\nПовышенный риск сердечно-сосудистых заболеваний.\r\nНеобходима консультация специалиста.", bodyMassIndex);
            System.out.println(resume);
        } else if (bodyMassIndex >= 30.00 && bodyMassIndex <= 34.99) {
            resume = String.format("Индекс массы тела %.2f\r\nОжирение первой степени.\r\nВысокий риск сердечно-сосудистых заболеваний.\r\nНеобходима консультация специалиста.", bodyMassIndex);
            System.out.println(resume);
        } else if (bodyMassIndex >= 35.00 && bodyMassIndex <= 39.00) {
            resume = String.format("Индекс массы тела %.2f\r\nОжирение второй степени.\r\nОчень высокий риск сердечно-сосудистых заболеваний.\r\nНеобходима консультация специалиста.", bodyMassIndex);
            System.out.println(resume);
        } else if (bodyMassIndex > 40) {
            resume = String.format("Индекс массы тела %.2f\r\nОжирение третьей степени (морбидное).\r\nЧрезвычайно высокий риск сердечно-сосудистых заболеваний.\r\nНеобходима срочная консультация специалиста.", bodyMassIndex);
            System.out.println(resume);
        }
    }

    public static double getDoubleValue() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        double tmp = 0;
        try {
            if (scanner.hasNextDouble()) {
                tmp = scanner.nextDouble();
                if (tmp < 0) {
                    throw new Exception("Число не может быть меньше или равно 0");
                } else {
                    return tmp;
                }
            } else {
                throw new Exception("Требуюется неотрицательное число больше 0, проверьте правильность ввода");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }


    }
}

