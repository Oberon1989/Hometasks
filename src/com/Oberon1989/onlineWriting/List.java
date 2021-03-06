package com.Oberon1989.onlineWriting;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class List<T extends Comparable>{
    private int size;
    private T[] data;
    private Class<T> tClass;
    private T forCompare;

    public List(Class<T> tClass, int capacity) {
        this.tClass = tClass;
        size = capacity;
        data = (T[]) Array.newInstance(tClass, capacity);

    }

    public T get(int index) {
        if (size - 1 >= index) {
            return data[index];
        } else {
            return null;
        }
    }

    public void set(T content, int index) {
        data[index] = content;
    }

    public void add(T content) {
        int index = firstFreeCell();
        if(index==-1)
        {
            index=expand(10);
        }
        data[index] = content;
    }

    public void add(T content, int index) {
        if (index < 0) throw new ArrayIndexOutOfBoundsException(index);
        try {

            while ((index > size - 1))
            {
                expand(10);
            }
            data[index + 1] = data[index];
            data[index] = content;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int size() {

        return size;
    }

    private boolean isFreeCells() {
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (data[i]==null) {
                counter++;
            }

        }
        return counter > 5 ? true : false;
    }

    public int indexOf(T content) {
        for (int i = 0; i < size; i++) {
            if(content.equals(data[i]))return i;
        }
        return -1;
    }

    public int lastIndexOf(T content) {

        for (int i = 0; i < size; i++) {
            if(content.equals(data[i]))
            {
                return i;
            }
        }
        return -1;
    }

    public void sort() {
        boolean isSorted = true;
        int offset = 0;
        do {

            isSorted=true;
            for (int i = 0; i < size - 1 - offset; i++) {
                if(data[i]!=null&&data[i+1]!=null) {
                    int result = data[i].compareTo(data[+1]);
                    System.out.println(result);
                    if (result == 1) {
                        isSorted = false;
                        T tmp = data[i];
                        data[i] = data[i+1];
                        data[i+1] = tmp;
                    }
                }

            }
            offset++;

        }
        while (!isSorted);

    }



    private int firstFreeCell() {

        for (int i = 0; i < size; i++) {
            if (data[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private int expand(int exp) {
        int last = size;
        T[] tmp = (T[]) Array.newInstance(tClass, size + exp);
        for (int i = 0; i < size; i++) {
            tmp[i] = data[i];
        }
        size += exp;
        data = Arrays.copyOf(tmp, size);

        return last;

    }




    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if(data[i]!=null)builder.append(String.format("%-2s, ",data[i]));

        }
        return builder.toString();
    }
}
