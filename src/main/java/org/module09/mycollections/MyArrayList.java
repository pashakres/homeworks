package org.module09.mycollections;

import java.util.Arrays;

public class MyArrayList<T> {
    private Object[] arr;
    private int size;

    public MyArrayList() {
        this.arr = new Object[0];
        this.size = 0;
    }

    public MyArrayList(T[] arr) {
        this.size = arr.length;
        this.arr = Arrays.copyOf(arr, this.size);
    }

    public T get(int index) {
        if (index < this.size && index > 0) {
            return (T) this.arr[index];
        }
        throw new IndexOutOfBoundsException();
    }

    public void add(T value) {
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

    @Override
    public String toString() {
        return "MyArrayList{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                '}';
    }
}
