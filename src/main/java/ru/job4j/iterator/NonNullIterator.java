package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NonNullIterator implements Iterator<Integer> {

    private Integer[] data;
    private int index;

    public NonNullIterator(Integer[] data) {
        this.data = data;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {

            while (index < data.length && data[index] == null) {
                index++;
            }

        return index < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Элемент не существует");
        }
        return data[index++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Операция удаления временно не используется");
    }

}