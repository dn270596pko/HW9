package com.myarraylist;

public class MyHashMap {

    private Node[] table;
    private int capacity;
    private int size;
    private static final float LOAD_FACTOR = 0.75f;

    public MyHashMap() {
        this(16);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        table = new Node[capacity];
    }

    public void put(Object key, Object value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        if (size >= LOAD_FACTOR * capacity) {
            resize();
        }

        int hash = hash(key);
        Node node = new Node(key, value);

        if (table[hash] == null) {
            table[hash] = node;
            size++;
        } else {
            Node current = table[hash];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }

            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = node;
                size++;
            }
        }
    }

    public Object get(Object key) {
        int hash = hash(key);
        Node current = table[hash];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    public Object remove(Object key) {
        int hash = hash(key);
        Node current = table[hash];
        Node previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    table[hash] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }

        return null;
    }

    public void clear() {
        table = new Node[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    private void resize() {
        capacity *= 2;
        Node[] newTable = new Node[capacity];

        for (Node node : table) {
            while (node != null) {
                Node next = node.next;
                int hash = hash(node.key);
                node.next = newTable[hash];
                newTable[hash] = node;
                node = next;
            }
        }

        table = newTable;
    }

    private int hash(Object key) {
        return Math.abs(key.hashCode() % capacity);
    }

    private static class Node {
        private Object key;
        private Object value;
        private Node next;

        private Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}

