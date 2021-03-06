package com.xandersu.class207_datastructuresandalgorithms.trie;

import java.util.TreeMap;

/**
 * @Author: suxun
 * @Date: 2018/11/4 14:50
 * @Description: trie 字典树 前缀树
 * ------root
 * c      d    p
 * a     o  e  a
 * t     g  e  n
 * ---------e  d
 * ---------r  a
 * <p>
 * 每个节点有26个指向下个节点的指针
 * class node{ char c;Node next[26];}
 * 每个节点有若干个指向下个节点的指针
 * class Node{char c;Map<char,Node> next;}
 * class Node{boolean isWord;Map<char,Node> next;}
 * -------------------------
 * 局限性：空间！
 * 解决办法：压缩字典树
 * Ternary Search Trie  三分搜索字典树
 * -------------------------
 * 后缀树
 * -------------------------
 * 子串查询:KMP Boyer-Moore  Rabin-Karp
 * -------------------------
 * 文件压缩
 * -------------------------
 * 模式匹配
 * -------------------------
 * 编译原理
 * -------------------------
 * DNA
 */
public class MyTrie {

    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public MyTrie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public boolean isPerfix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
}
