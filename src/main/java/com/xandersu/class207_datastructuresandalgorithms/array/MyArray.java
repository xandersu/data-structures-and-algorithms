package com.xandersu.class207_datastructuresandalgorithms.array;

/**
 * Created by lenovo on 2018/7/23.
 */
public class MyArray {

    private int[] data;
    private int size;

    public MyArray() {
        this(10);
    }

    public MyArray(int capcity) {
        data = new int[capcity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(int index, int e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("参数越界");
        }
        if (size >= data.length) {
            throw new IllegalArgumentException("集合已满");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];

        }
        data[index] = e;
        size++;
    }

    public void addFirst(int e) {
        add(0, e);
    }

    public void addLast(int e) {
        add(size, e);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("参数越界");
        }
        return data[index];
    }

    public void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("参数越界");
        }
        data[index] = e;
    }

    public boolean contains(int e) {
        for (int i = 0; i < data.length; i++) {
            if(data[i] == e){
                return true;
            }
        }
        return false;
    }

    public int find(int e){
        for (int i = 0; i < data.length; i++) {
            if(data[i] == e){
                return i;
            }
        }
        return -1;
    }

    public int remove(int index){
        int ret = data[index];
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("参数越界");
        }
        for (int i = index+1; i < size; i++) {
            data[i-1]=data[i];
        }
        size--;
        return ret;
    }
}
