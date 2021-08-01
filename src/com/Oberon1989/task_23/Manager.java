package com.Oberon1989.task_23;

import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);
        private listPhone phones=null;
        private int id=0;
        public Manager(listPhone phones) {
            this.phones = phones;
        }



        public void execute() throws Exception {
            int action = -1;
            boolean isRun = true;

            while (isRun) {

                ConsoleHelper.PrintMessage("Меню:");
                ConsoleHelper.PrintMessage("1. Добавить телефон");
                ConsoleHelper.PrintMessage("2. Вывести телефон по его id");
                ConsoleHelper.PrintMessage("2. обновить телефон по его id");
                ConsoleHelper.PrintMessage("2. удалить телефон по его id");
                ConsoleHelper.PrintMessage("2.Сортировка");
                ConsoleHelper.PrintMessage("0. Выход");

                action = ConsoleHelper.InputInt("Введите номер пункта меню: ", 0, 2);

                switch (action) {
                    case 1: {
                        Phone phone = createPhone();
                        phones.add(phone);
                        id++;
                    }
                    break;
                    case 2: {
                        ConsoleHelper.PrintMessage("Введите id");
                      int id=ConsoleHelper.InputInt(scanner.nextLine());
                        System.out.println(phones.getPhoneById(id));
                    }
                    break;
                    case 0: {
                        isRun = false;
                    }
                    break;
                }
            }
        }
        private Phone createPhone()
        {
            scanner=new Scanner(System.in);
            ConsoleHelper.PrintMessage("Введите марку");
            String brand = ConsoleHelper.InputString(scanner.nextLine());
            ConsoleHelper.PrintMessage("Введите модель");
            String model = ConsoleHelper.InputString(scanner.nextLine());
            ConsoleHelper.PrintMessage("Введите количество ядер");
            int cpuCount = ConsoleHelper.InputInt(scanner.nextLine(),1,8);
            ConsoleHelper.PrintMessage("Введите Диагональ экрана");
            double diagonal = ConsoleHelper.InputDouble(scanner.nextLine());
            ConsoleHelper.PrintMessage("Введите вес");
            int weight = ConsoleHelper.InputInt(scanner.nextLine(),10,300);
            ConsoleHelper.PrintMessage("Введите цвет");
            Phone.Color color = Phone.Color.values()[ConsoleHelper.InputInt(scanner.nextLine(),0, Phone.Color.values().length-1)];
            ConsoleHelper.PrintMessage("Введите цену");
            int price = ConsoleHelper.InputInt(scanner.nextLine(),1,999999);

            return  new Phone(id,brand,model,cpuCount,(float)diagonal,weight,color,price);
        }
    }

