package com.xandersu.class207_datastructuresandalgorithms.Map;

/**
 * @Author: suxun
 * @Date: 2018/10/16 21:13
 * @Description: <p>
 * map 映射 ,类似于 python dict字典, key value
 * 存储（键，值）数据对的数据结构
 * 根据键，寻找值
 * 非常容易使用链表或二分搜索树实现
 * </p><p>
 * 有序映射：搜索树
 * 无序映射：哈希表
 * </p>
 * 多重映射：键可以重复
 */
public interface MyMap<K, V> {
    void add(K k, V v);

    V remove(K k);

    boolean contains(K k);

    V get(K k);

    void set(K k, V v);

    int getSize();

    boolean isEmpty();
}
