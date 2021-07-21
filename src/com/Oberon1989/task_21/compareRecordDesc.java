package com.Oberon1989.task_21;

import java.util.Comparator;

public class compareRecordDesc implements Comparator<Record> {
    @Override
    public int compare(Record o1, Record o2) {
        return o1.getDescription().compareTo(o2.getDescription());
    }
}
