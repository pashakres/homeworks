package org.module09.mycollections;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<T> {
    private int size;
    private Object[] arr;

    public MyStack() {
        this.arr = new Object[0];
        this.size = 0;
    }

    public void push(T value) {
        int curArrSize = this.arr.length;
        if (this.size < curArrSize) {
            this.arr[size++] = value;
        } else {
            Object[] newArray = new Object[curArrSize + 1];
            System.arraycopy(this.arr, 0, newArray, 0, curArrSize);
            newArray[size++] = value;
            this.arr = newArray;
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        int newArrSize = this.arr.length - 1;
        Object[] newArray = new Object[newArrSize];
        System.arraycopy(this.arr, 0, newArray, 0, index);
        System.arraycopy(this.arr, index+1, newArray, index, newArrSize-index);
        this.arr = newArray;
        this.size--;
    }

    public void clear() {
        this.arr = new Object[0];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public T peek() {
        if (this.size <= 0) {
            throw new EmptyStackException();
        }
        return (T) this.arr[this.size - 1];
    }

    public T pop() {
        T elem = peek();
        remove(this.size - 1);
        return elem;
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "size=" + size +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }
}
