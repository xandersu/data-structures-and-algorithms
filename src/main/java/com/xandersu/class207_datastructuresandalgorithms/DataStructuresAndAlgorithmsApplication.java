package com.xandersu.class207_datastructuresandalgorithms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 玩转数据结构
 * 线性结构 -> 动态数组  普通队列  栈  链表  哈希表
 * 树形结构 -> 二分搜索树  AVL搜索树  红黑树
 * ---------堆  线段树
 * ---------Trie  并查集
 * 图结构 -> 邻接表               邻结矩阵    (图复杂在基于存储信息计算出存储的数据的性质)
 * ------链地址法哈希表很像      nxn 二维数组
 * 个节点就是有n个链表的数组
 * 位置i存储的是和i顶点相连接的其他顶点
 * ----和i节点向连接的边
 * 抽象数据结构 ->  线性表：表示数据是线性排列的，可以是动态数组可以是链表
 * ------------>  栈  队列
 * ------------>  集合  映射   -- 有序集合，有序映射  无序集合，无序映射
 * 更多队列 -> 双端队列、随机队列、最大最小队列
 * ---------> 双向链表、循环链表
 * ---------> 跳跃表、后缀数组
 * ---------> K-D树、Splay树、B树
 */
@SpringBootApplication
public class DataStructuresAndAlgorithmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataStructuresAndAlgorithmsApplication.class, args);
    }
}
