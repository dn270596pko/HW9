package com.myarraylist;

public class MyLinkedList {

    private int size = 0;
    private Node head = null;

    private static class Node {
        Object value;
        Node prev = null;
        Node next = null;

        Node(Object value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public void add(Object value) {
        if (head == null) {
            head = new Node(value, null, null);
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(value, node, null);
        }
        size++;
    }

    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        size--;
        return node.value;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }
}
