package com.Oberon1989.task_22;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int lampCount = 10;
        Random rnd = new Random();
        Lamp[] lamps = new Lamp[lampCount];

        for (int i = 0; i < lampCount; i++) {
            lamps[i] = new Lamp(rnd.nextBoolean(), rnd.nextInt(100 + 1), Lamp.Colors.values()[rnd.nextInt(Lamp.Colors.values().length)].toString());
        }

        for (int i = 0; i < lampCount; i++) {
            System.out.println(lamps[i]);
        }

    }
}
