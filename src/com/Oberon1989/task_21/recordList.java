package com.Oberon1989.task_21;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class recordList {

    static Record[] createRecordList(int length) {
        Record[] records = new Record[length];
        clearRecord(records);
        return records;
    }

    static void clearRecord(Record[] records) {
        for (int i = 0; i < records.length; i++) {
            if (records[i] == null) {
                records[i] = new Record("Empty", "Empty", "Empty");
            } else {
                records[i].setName("Empty");
                records[i].setPhone("Empty");
                records[i].setDescription("Empty");
            }
        }
    }

    static void printRecords(Record[] records) {
        System.out.println(String.format("%-5s %-10s %-12s", "Name", "Phone", "Description"));
        for (int i = 0; i < records.length; i++) {
            System.out.println(records[i]);
        }
        System.out.println();
    }

    static void recordsRandomValuesFill(Record[] records) {
        Random rnd = new Random();
        String[] names = new String[]{"Tomas", "Alice", "Bob", "Caroline", "Mary-Ann", "Patrick", "Henry", "Murray", "Eddie", "Jack", "Charlotte", "Claudette", "Katerine"};
        String[] tel = new String[]{"+79235728345", "+79135728545", "+79185728777", "+79255728345", "+79035726344", "+79995720761", "+79195786556", "+79072341167", "+79212758142", "+79235728345"};
        String[] desc = new String[]{"Don't drink", "Don't receive", "Enemy", "Friend", "Employee", "Not knows", "Undefined"};
        for (int i = 0; i < records.length; i++) {
            String name = names[rnd.nextInt(names.length)];
            String phone = tel[rnd.nextInt(tel.length)];
            String description = desc[rnd.nextInt(desc.length)];
            records[i].setName(name);
            records[i].setPhone(phone);
            records[i].setDescription(description);
        }
    }

    static Record[] addInLast(Record[] records, Record element) {
        Record[] tmp = createRecordList(records.length + 1);
        for (int i = 0; i < tmp.length - 1; i++) {
            tmp[i] = records[i];
        }
        tmp[tmp.length - 1].setName(element.getName());
        tmp[tmp.length - 1].setPhone(element.getPhone());
        tmp[tmp.length - 1].setDescription(element.getDescription());
        return tmp;
    }

    static Record[] addInIndex(Record[] records, Record elem, int index) {
        int newLength = records.length + 1;
        try {
            if (index < 0) {
                throw new ArrayIndexOutOfBoundsException("Выход за границы");
            }
            if (index > records.length) {
                newLength = records.length + (index - records.length) + 1;
            }
            Record[] tmp = createRecordList(newLength);
            for (int i = 0; i < index; i++) {
                if (i <= records.length - 1)
                    tmp[i] = records[i];
            }

            tmp[index].setName(elem.getName());
            tmp[index].setPhone(elem.getPhone());
            tmp[index].setDescription(elem.getDescription());
            for (int i = index; i < records.length; i++) {
                tmp[i + 1] = records[i];
            }
            return tmp;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Вставка не удалась");
            return records;
        }
    }

    static Record[] removeFromIndex(Record[] records, int index) {
        try {
            if (index < 0 || index > records.length - 1) {
                throw new ArrayIndexOutOfBoundsException("Вне диапазона!");
            }
            Record[] tmp = createRecordList(records.length - 1);
            for (int i = 0; i < index; i++) {
                tmp[i] = records[i];
            }
            for (int i = index; i < tmp.length; i++) {
                tmp[i] = records[i + 1];
            }
            return tmp;
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + " Удаление не удалось");
            return records;
        }
    }

    private static int simpleSearch(Record[] records, Record value) {
        int index = -1;
        for (int i = 0; i < records.length; i++) {
            if (records[i].equals(value)) {
                index = i;
            }
        }
        return index;
    }

    static void bubbleSort(Record[] records, Comparator<Record> comparator) {
        int offset = 0;
        boolean isSorted;
        do {
            isSorted = true;
            for (int i = 0; i < records.length - 1 - offset; i++) {
                int compare = comparator.compare(records[i], records[i + 1]);
                if (compare > 0) {
                    isSorted = false;
                    Record tmp = records[i];
                    records[i] = records[i + 1];
                    records[i + 1] = tmp;
                }
            }
            offset++;
        }
        while (!isSorted);
    }

    static void setElement(Record[] records, int index, Record newValue) {
        try {
            if (index < 0 || index > records.length) {
                throw new IndexOutOfBoundsException("Вне диапазона! Значение не установлено");
            }
            records[index] = newValue;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void rightOffset(Record[] arr, int step) {

        for (int i = 0; i < step; i++) {

            Record tmp = arr[arr.length - 1];

            for (int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = tmp;
        }
    }

    public static void leftOffset(Record[] records, int step) {


        for (int i = 0; i < step; i++) {

            Record tmp = records[0];

            for (int j = 0; j < records.length - 1; j++) {
                records[j] = records[j + 1];
            }
            records[records.length - 1] = tmp;
        }
    }

    public static void replaceElement(Record[] records, Record oldValue, Record newValue) throws Exception {
        int index = simpleSearch(records, oldValue);

        if (index >= 0) {
            setElement(records, index, newValue);
            System.out.println("Установлено новое значение");
        } else {
            System.out.println("Ошибка! запись' " + oldValue + " не обнаружена в книге");
        }
    }

    static Record createSingleRecord() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите имя");
        String name = input.nextLine();
        System.out.println("Введите телефон");
        String phone = input.nextLine();
        System.out.println("Введите примечание");
        String desc = input.nextLine();
        return new Record(name, phone, desc);
    }

    static void printLines(int countLines) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < countLines; i++) {
            builder.append("\n");
        }
        System.out.println(builder);
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Record[] records = null;

        int action = -1;
        boolean isRun = true;

        while (isRun) {

            System.out.println("Меню:");
            System.out.println("1. Создать пустой массив");
            System.out.println("2. Вывести массив");
            System.out.println("3. Заполнить массив случайными значениями");
            System.out.println("4. Добавить элемент в конец массива");
            System.out.println("5. Добавить элемент в указанный индекс");
            System.out.println("6. Удалить элемент по указанному индексу");
            System.out.println("7. Простой поиск");
            System.out.println("8. Сортировка пузырьком");
            System.out.println("9. Установить новое значение элемента");
            System.out.println("10. Сдвинуть массив вправо на указанное количество шагов");
            System.out.println("11. Сдвинуть массив влево на указанное количество шагов");
            System.out.println("12. Заменить элемент");
            System.out.println("0. Выход");

            System.out.print("Введите номер пункта меню: \n");
            action = input.nextInt();

            switch (action) {
                case 1: {
                    printLines(50);
                    System.out.println("Введите количество элементов");
                    int count = input.nextInt();
                    records = createRecordList(count);
                    break;
                }
                case 2: {
                    printLines(50);
                    printRecords(records);
                    break;
                }
                case 3: {
                    recordsRandomValuesFill(records);
                    break;
                }
                case 4: {
                    Record record = createSingleRecord();
                    String desc = input.nextLine();
                    records = addInLast(records, record);
                    break;
                }
                case 5: {
                    System.out.println("Введите индекс");
                    int index = input.nextInt();
                    Record record = createSingleRecord();
                    records = addInIndex(records, record, index);
                    break;
                }
                case 6: {
                    System.out.println("Введите индекс");
                    int index = input.nextInt();
                    records = removeFromIndex(records, index);
                    break;
                }

                case 7: {
                    Record search = createSingleRecord();
                    int index = simpleSearch(records, search);
                    if (index == -1) {
                        System.out.println("Элемент не найден");
                    } else {
                        System.out.println(index);
                    }
                    break;
                }
                case 8: {
                    System.out.println("Выберите варианты сортировки\n1. Сортировка по имени\n2. Сортировка по номеру телефона\n3. Сортировка по примечанию");
                    int number = input.nextInt();
                    switch (number) {
                        case 1: {
                            compareRecordName comp = new compareRecordName();
                            bubbleSort(records, comp);
                            break;
                        }
                        case 2: {
                            compareRecordPhone comp = new compareRecordPhone();
                            bubbleSort(records, comp);
                            break;
                        }
                        case 3: {
                            compareRecordDesc comp = new compareRecordDesc();
                            bubbleSort(records, comp);
                            break;
                        }
                    }
                    break;
                }
                case 9: {
                    System.out.println("Введите индекс элемента");
                    int index = input.nextInt();
                    Record record = createSingleRecord();
                    setElement(records, index, record);
                    break;
                }
                case 10: {
                    System.out.println("Сдвиг вправо введите шаг");
                    int step = input.nextInt();
                    rightOffset(records, step);
                    break;
                }
                case 11: {
                    System.out.println("Сдвиг влево введите шаг");
                    int step = input.nextInt();
                    leftOffset(records, step);
                    break;
                }
                case 12: {
                    System.out.println("Введите поля старого элемента");
                    Record oldRecord = createSingleRecord();

                    System.out.println("Введите поля нового элемента");
                    Record newRecord = createSingleRecord();

                    replaceElement(records, oldRecord, newRecord);
                    break;
                }
                case 0: {
                    System.out.println("Работа программы завершена");
                    isRun = false;
                }
            }

        }
    }
}

class Record implements Comparable<Record> {
    String name;
    String phone;
    String description;

    public Record(String name, String phone, String description) {
        this.name = name;
        this.phone = phone;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-10s %-12s", name, phone, description);
    }


    @Override
    public int compareTo(Record o) {
        return name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(name, record.name) && Objects.equals(phone, record.phone) && Objects.equals(description, record.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, description);
    }
}
