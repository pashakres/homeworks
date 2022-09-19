package org.module09.mycollections;

public class MyLinkedList<T> {
    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        Node(Node<T> prev, Node<T> next, T value) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size;
    private Node<T> firstNode;
    private Node<T> lastNode;

    public MyLinkedList() {
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public Node<T> getNode(int index) {
        if (index >= this.size && index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        Node<T> curNode = this.firstNode;
        while (curNode != null) {
            if (counter == index) {
                return curNode;
            }
            curNode = curNode.next;
            counter++;
        }
        return null;
    }

    public T get(int index) {
        return getNode(index).value;
    }

    public void add(T value) {
        Node<T> curNode = new Node<>(lastNode, null, value);
        if (lastNode == null) {
            firstNode = curNode;
        } else {
            lastNode.next = curNode;
        }
        lastNode = curNode;
        size++;
    }

    public void remove(int index) {
        Node<T> curNode = getNode(index);
        if (curNode.prev == null) {
            firstNode = curNode.next;
        } else {
            curNode.prev.next = curNode.next;
        }
        if (curNode.next == null) {
            lastNode = null;
        } else {
            curNode.next.prev = curNode.prev;
        }
        curNode.prev = null;
        curNode.next = null;
        curNode.value = null;
        size--;
    }

    public void clear() {
        Node<T> curNode = firstNode;
        while (curNode != null) {
            Node<T> nextNode = curNode.next;
            curNode.prev = null;
            curNode.next = null;
            curNode.value = null;
            curNode = nextNode;
        }
        size = 0;
    }
}
