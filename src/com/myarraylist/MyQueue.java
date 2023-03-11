package com.myarraylist;

public class MyQueue<T> {

    private T[] queueArray;
    private int size;

    public MyQueue() {
        queueArray = (T[]) new Object[10];
        size = 0;
    }

    public void add(T value) {
        if (size == queueArray.length) {
            T[] newArray = (T[]) new Object[queueArray.length * 2];
            System.arraycopy(queueArray, 0, newArray, 0, queueArray.length);
            queueArray = newArray;
        }
        queueArray[size] = value;
        size++;
    }

    public void clear() {
        queueArray = (T[]) new Object[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (size == 0) {
            return null;
        }
        return queueArray[0];
    }

    public T poll() {
        if (size == 0) {
            return null;
        }
        T value = queueArray[0];
        System.arraycopy(queueArray, 1, queueArray, 0, size - 1);
        size--;
        return value;
    }
}

