package com.Oberon1989.task_23;

public class phoneListManager {
    public static void main(String[] args) throws Exception {
        listPhone phones = new listPhone();
        phones.add(new Phone(1,"Nokia","N31",1,3.7f,35, Phone.Color.BLACK,3000));
        phones.add(new Phone(2,"Nokia","N33",1,3.7f,50, Phone.Color.RED,2500));
        phones.add(new Phone(3,"Motorola","E398",2,4.5f,55, Phone.Color.GRAY,1945));
        phones.add(new Phone(4,"Siemens","A35",1,2.2f,35, Phone.Color.YELLOW,700));
        phones.add(new Phone(5,"Philips","Node",3,7.7f,125, Phone.Color.BLUE,200));


        compareModel model = new compareModel();
        phones.bubbleSort(model);
        phones.listPrint();

    }


}
