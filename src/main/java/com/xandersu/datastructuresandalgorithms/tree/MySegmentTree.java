package com.xandersu.datastructuresandalgorithms.tree;

/**
 * @Author: suxun
 * @Date: 2018/10/21 17:12
 * @Description: 线段树--关注动态的情况,对于二叉树，元素是一个个线段，或者说一个个区间
 * 为什么使用线段树：经典问题：区间染色（m次操作后，可以在【i，j】区间可以看见多少种颜色）
 * 区间查询：【i，j】区间 最大值，最小值，或者区间数字和,基于区间统计查询
 * ------
 * 区间是固定的
 * --------------A[0-7]
 * --------A[0-3]-----------A[4-7]
 * ----A[0-1]  A[2-3]  A[4-5] A[6-7]
 * ---A[0]-A[1]-A[2]-A[3]-A[4]-A[5]-A[6]-A[7]
 */
public interface MySegmentTree {
}
