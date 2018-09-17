package com.xandersu.datastructuresandalgorithms.array;

import java.util.Arrays;

/**
 * Created by lenovo on 2018/7/23.
 */
public class MyArrayGeneric<E> {

    private E[] data;
    private int size;

    public MyArrayGeneric() {
        this(10);
    }

    public MyArrayGeneric(int capcity) {
        data = (E[]) new Object[capcity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("参数越界");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];

        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("参数越界");
        }
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("参数越界");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        E ret = data[index];
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("参数越界");
        }
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length / 2) {
            resize(data.length / 2);
        }
        return ret;
    }

    @Override
    public String toString() {
        return "MyArrayGeneric{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", capacity="+ data.length +
                '}';
    }
}
