package com.xandersu.datastructuresandalgorithms.heap;

/**
 * @Author: suxun
 * @Date: 2018/10/21 12:43
 * @Description: O(logn)复杂度 几乎都跟树有关
 * 二叉堆 Binary Heap：是一颗完全二叉树(不一定是满的，不满的一定是在右下方)把元素排列成树的形状
 * 堆中某个节点的值总是不大于其父节点的值（最大堆（相应的可以定义最小堆））
 * 用数组储存二叉堆：
 * 0 - 1 - 2 - 3 - 4 - 5
 *   -62 -41 -30 -28 -16
 * parent(i) = i/2; left child (i) = 2*i; right child (i) = 2 * i +1;
 *  * 0 - 1 - 2 - 3 - 4 - 5
 *  * 62 -41 -30 -28 -16
 *  * parent(i) = (i-1)/2; left child (i) = 2*i+1; right child (i) = 2 * i +2;
 */
public interface MyHeap {
}
