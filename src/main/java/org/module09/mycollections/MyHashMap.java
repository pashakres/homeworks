package org.module09.mycollections;

import javax.management.openmbean.InvalidKeyException;

public class MyHashMap<K, V> {
    static class Node <K,V>{
        K key;
        V val;
        Node<K,V> next;

        public  Node(K key, V val,Node<K,V> next ) {
            this.key=key;
            this.val=val;
            this.next=next;
        }
    }

    private static final int CAPACITY = 4;
    private Node<K,V>[] bucket ;

    public  MyHashMap(){
        this.bucket = new Node[CAPACITY];
    }

    public void put(K key, V value) {
        if (null == key) {
            return;
        }
        int hash = hash(key);
        Node<K,V> add = new Node<>(key, value,null);
        if (bucket[hash] != null) {
            Node<K,V> currNode = bucket[hash];
            while (null != currNode){
                if (currNode.key.equals(key)) {
                    currNode.val = value;
                    return;
                } else {
                    if (currNode.next == null) {
                        currNode.next = add;
                        return;
                    }
                    currNode = currNode.next;
                }
            }
        } else {
            bucket[hash] = add;
        }
    }
    public void remove(K key) {
        if (key == null) {
            throw new InvalidKeyException();
        }

        int hash = hash(key);
        Node<K,V> b = bucket[hash];
        if (b == null) {
            throw new InvalidKeyException();
        }

        Node<K,V> prev = null;
        while (b != null) {
            if (b.key.equals(key)) {
                if (prev == null) {
                    bucket[hash] = b.next;
                } else {
                    prev.next = b.next;
                }
                return;
            } else {
                prev = b;
                b = b.next;
            }
        }
    }

    public void clear() {
        this.bucket = new Node[CAPACITY];
    }

    public int size() {
        return this.size();
    }

    public V get(K key) {
        if (key == null) {
            throw new InvalidKeyException();
        }
        int hash = hash(key);
        Node<K,V> b = bucket[hash];
        if (b == null) {
            return null;
        }
        while (null !=b) {
            if (b.key.equals (key)) {
                return b.val;
            } else {
                b = b.next;
            }
        }
        return null;
    }

    private int hash (K key)
    {
        return Math.abs(key.hashCode()) % CAPACITY;
    }
}
