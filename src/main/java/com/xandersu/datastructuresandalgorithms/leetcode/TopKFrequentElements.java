package com.xandersu.datastructuresandalgorithms.leetcode;

import com.xandersu.datastructuresandalgorithms.queue.impl.PriorityQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @Author: suxun
 * @Date: 2018/10/21 15:41
 * @Description:
 */
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (pq.getSize() < k) {
                pq.enQueue(new Freq(key, map.get(key)));
            } else if (map.get(key) > pq.getFront().freq) {
                pq.deQueue();
                pq.enQueue(new Freq(key, map.get(key)));
            }
        }
        List<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.deQueue().e);
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
                return 1;
            } else if (this.freq > o.freq) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
