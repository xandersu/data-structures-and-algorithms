package com.xandersu.my_test.concurrent;

/**
 * @author su
 * @date 2020/5/1211:36
 * @description
 */
public class ThreadPrintTest200512 implements Runnable {
    private static final Object LOCK = new Object();
    private static volatile int curr = 0;
    private int num;

    ThreadPrintTest200512(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (LOCK) {
                LOCK.notifyAll();
                if (curr % 3 == num - 1) {
                    System.out.println(num);
                    curr++;
                } else {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadPrintTest200512(1)).start();
        new Thread(new ThreadPrintTest200512(2)).start();
        new Thread(new ThreadPrintTest200512(3)).start();
    }

}
