package com.xandersu.class207_datastructuresandalgorithms.leetcode;

/**
 * @Author: suxun
 * @Date: 2018/11/18 12:39
 * @Description: leetcode 387 字符串中的第一个唯一字符
 * int[] freq = new int[26]; 就是哈希表
 * f(ch) = ch - 'a'就是哈希函数 键转化为函数
 * 每一个字符都有一个索引对应 O(1)查找操作
 * 哈希冲突：很难保证通过哈希函数的转换对应不同的索引
 * ·
 * 哈希表体现了经典算法思想：空间换时间
 * 哈希表是时间和空间之间的平衡
 * 哈希函数设计很重要
 * 键通过哈希函数得到的索引分布约均匀越好
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
