package ru.job4j.iterator;

import java.util.*;

public class BackwardArrayIterator implements Iterator<Integer> {
    private final int[] data;
    private int point;

    public BackwardArrayIterator(int[] data) {

        this.data = data;
        this.point = data.length - 1;
    }

    @Override
    public boolean hasNext() {

        return point < data.length && point > -1;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("point >= data.length");
        }

        return data[point--];
    }
}