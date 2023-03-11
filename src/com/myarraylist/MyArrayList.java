package com.myarraylist;

public class MyArrayList {
    private Object[] array;
    private int size;

    public MyArrayList() {
        array = new Object[10];
        size = 0;
    }

    public void add(Object value) {
        if (size >= array.length) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size] = value;
        size++;
    }

    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object removed = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return removed;
    }

    public void clear() {
        array = new Object[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }
}