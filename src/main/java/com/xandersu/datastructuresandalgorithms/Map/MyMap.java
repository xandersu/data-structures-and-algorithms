package com.xandersu.datastructuresandalgorithms.Map;

/**
 * @Author: suxun
 * @Date: 2018/10/16 21:13
 * @Description:
 * map 映射 ,类似于 python dict字典, key value
 * 存储（键，值）数据对的数据结构
 * 根据键，寻找值
 * 非常容易使用链表或二分搜索树实现
 */
public interface MyMap<K,V> {
    void add(K k,V v);
    V remove(K k);
    boolean contains(K k);
    V get(K k);
    void set(K k,V v);
    int getSize();
    boolean isEmpty();
}
