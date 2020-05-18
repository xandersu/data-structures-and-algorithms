package com.xandersu.my_test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author su
 * @date 2020/5/1412:35
 * @description
 */
public class MyLRU20200514<K, V> extends LinkedHashMap<K, V> {
    private int cache_size;

    public MyLRU20200514(int capacity) {
        super(capacity, 0.75F, true);
        cache_size = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cache_size;
    }
}
