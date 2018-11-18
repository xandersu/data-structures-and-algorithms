package com.xandersu.datastructuresandalgorithms.hashtable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: suxun
 * @Date: 2018/11/18 12:35
 * @Description: 哈希表
 * 哈希函数 键转化为函数
 * 每一个字符都有一个索引对应 O(1)查找操作
 * 哈希冲突：很难保证通过哈希函数的转换对应不同的索引
 * ·
 * 哈希表体现了经典算法思想：空间换时间
 * 哈希表是时间和空间之间的平衡
 * 哈希函数设计很重要
 * 键通过哈希函数得到的索引分布越均匀越好
 * ·
 * 哈希函数设计
 * 整形：小范围正整数直接使用，小范围负整数进行偏移（-100 ～ 100 -> 0 ～ 200）
 * 大整数
 * 通常做法：取模。比如，取后四位。等同于mod 10000
 * 一个简单的解决办法：模一个素数
 * 浮点型
 * 在计算机中都是32位或者64位二进制表示，只不过计算机解析成浮点数
 * 转成整型处理
 * 字符串
 * 转成整型处理
 * hash(code) = (c * B^3 + o * B^2 + d * B^1 + e * B^0) % M
 * |
 * -> hash(code) = ((((c * B) + o ) * B + d) * + e) % M
 * | 防止整型溢出
 * -> hash(code) = ((((c % M) * B) + o ) % M * B + d) % M * B + e) % M
 * `
 * int hash = 0;
 * for(i=1;i<s.length();i++)
 * hash = (hash * B + s.charAt(i)) % M
 * Date:year,month,day
 * 转成整型处理
 * `
 * 转成整型处理 并不是唯一的方法！
 * 哈希函数设计原则：
 * 1、一致性：如果a=b,则hash(a) == hash(b)
 * 2、高效性：计算高效便利
 * 3、均匀性：哈希值均匀分布
 * `
 * 哈希冲突的处理 链地址法 seperate chaining
 * (hashCode(k2) & 0x7fffffff) % M    0x7fffffff 31个1  将最高位变成0（正负号表示位）
 * `
 * 0 口
 * 1 口 -> k2 -> k3
 * 2 口
 * 3 口 -> k1
 * 4 口
 * | 查找表
 * ->
 * 0 口 -> TreeMap
 * 1 口 -> TreeMap
 * 2 口 -> TreeMap
 * 3 口 -> TreeMap
 * 4 口 -> TreeMap
 * jdk8   前，每一个位置对应一个链表
 * jdk8 开始，当哈希冲突达到一定程度，每一个位置从链表转成红黑树
 * `
 * 哈希表动态空间处理
 * 平均每个地址承载的元素多过一定程度，即扩容
 * n / m >= upperTol
 * 平均每个地址承载的元素少过一定程度，即缩容
 * n / m <= lowerTol
 * `
 * 哈希表复杂度分析
 * 回忆动态数组的均摊复杂度分析：平均复杂度O(1)
 * 对于哈希表来说，元素数从N增加到 upperTol * N；地址空间翻倍:
 * 平均复杂度O(1) 每个操作在O(lowerTol) ~ O(upperTol) -> O(1)
 * 缩容同理
 * 更复杂的动态空间处理方法
 * 扩容 M -> 2*M
 * 扩容 2*M 不是素数
 */
public class MyHashTable {
    public static void main(String[] args) {
        int a = 42;
        int aHashCode = ((Integer) a).hashCode();
        System.out.println(aHashCode);
        int b = -42;
        int bHashCode = ((Integer) b).hashCode();
        System.out.println(bHashCode);

        Double c = new Double(3.1415926);
        System.out.println(c.hashCode());

        String d = "imooc";
        System.out.println(d.hashCode());

        Student student = new Student(3, 2, "BOBO", "liu");
        System.out.println(student.hashCode());

        HashSet<Student> set = new HashSet<>();
        set.add(student);
        HashMap<Student, Integer> scores = new HashMap<>();
        scores.put(student, 100);

        Student student2 = new Student(3, 2, "BOBO", "liu");
        System.out.println(student2.hashCode());
    }
}
