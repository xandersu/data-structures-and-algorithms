package com.xandersu.algorithms.sort;

/**
 * @author su
 * @date 2019/11/1015:29
 * @description
 */
public class TreeThreadPrintNumTest {

    public static void main(String[] args) {
        int totalThread = 3;
        for (int i = 0; i < totalThread; i++) {
            new printThread(i, totalThread).start();
        }
    }

    public static class printThread extends Thread {

        private static final Object LOCK = new Object();

        private final int threadNo;
        private final int totalThread;
        private int nowIndex = 1;
        private int maxIndex = 10;

        public printThread(int threadNo, int totalThread) {
            this.threadNo = threadNo;
            this.totalThread = totalThread;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (LOCK) {
                    if (nowIndex > maxIndex) {
                        break;
                    }
                    if (nowIndex % totalThread == threadNo) {
                        System.out.println("threadNo=" + threadNo + ",nowIndex=" + nowIndex++);
                        LOCK.notifyAll();
                    }
//                    LOCK.notifyAll();
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
