package com.xandersu.algorithms.sort;

/**
 * @author su
 * @date 2019/11/1015:29
 * @description
 */
public class ThreadPrintTest {

    public static void main(String[] args) {
        int maxNum = 10;
        int maxThread = 10;
        for (int i = 0; i < maxThread; i++) {
            new ThreadPrint(i, maxThread, maxNum).start();
        }
    }

    public static class ThreadPrint extends Thread {

        private static int current = 0;
        private static final Object LOCK = new Object();

        private final int threadIndex;
        private final int maxThread;
        private final int maxNum;

        public ThreadPrint(int threadIndex, int maxThread, int maxNum) {
            this.threadIndex = threadIndex;
            this.maxThread = maxThread;
            this.maxNum = maxNum;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (LOCK) {
                    if (current > maxNum) {
                        break;
                    }
                    if (current % maxThread == threadIndex) {
                        System.out.println("threadIndex" + threadIndex + ",current" + current++);
                        LOCK.notifyAll();
                    }
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
