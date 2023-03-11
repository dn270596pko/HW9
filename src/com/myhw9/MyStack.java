package com.myhw9;

import java.util.NoSuchElementException;

public class MyStack<T> {
    private T[] elements;
    private int size;

    public MyStack() {
        elements = (T[]) new Object[10];
        size = 0;
    }

    public void push(T element) {
        if (size == elements.length) {
            T[] newElements = (T[]) new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
        elements[size++] = element;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return elements[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T element = elements[--size];
        elements[size] = null;
        return element;
    }
}
