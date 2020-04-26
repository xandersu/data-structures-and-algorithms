package com.xandersu.class207_datastructuresandalgorithms.leetcode;


import java.util.*;

/**
 * @Author: suxun
 * @Date: 2018/10/21 15:41
 * @Description:
 */
public class TopKFrequentElements2 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        //java默认是最小堆
        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(new Freq(key, map.get(key)));
            } else if (map.get(key) > pq.peek().freq) {
                pq.poll();
                pq.add(new Freq(key, map.get(key)));
            }
        }
        List<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().e);
        }
        return res;
    }

    private class Freq implements Comparable<Freq> {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq o) {
            if (this.freq < o.freq) {
                return -1;
            } else if (this.freq > o.freq) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    //比较器
    private class FreqComparator implements Comparator<Freq> {
        @Override
        public int compare(Freq o1, Freq o2) {
            return o1.freq - o2.freq;
        }
    }
}
