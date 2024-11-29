package ru.job4j.iterator;

import java.util.*;

public class BackwardArrayIterator implements Iterator<Integer> {
    private final int[] data;
    private int point;

    public BackwardArrayIterator(int[] data) {
        for (int i = 0; i < data.length / 2; i++) {
            int tmp = data[i];
            data[i] = data[data.length - 1 - i];
            data[data.length - 1 - i] = tmp;
        }
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return point < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("point >= data.length");
        }
        return data[point++];
    }
}