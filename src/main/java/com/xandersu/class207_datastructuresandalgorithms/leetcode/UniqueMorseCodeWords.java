package com.xandersu.class207_datastructuresandalgorithms.leetcode;

import java.util.TreeSet;

/**
 * @Author: suxun
 * @Date: 2018/10/15 22:40
 * @Description:
 */
public class UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = { ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> set = new TreeSet<>();
        for (String word : words) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                String code = codes[word.charAt(i) - 'a'];
                res.append(code);
            }
            set.add(res.toString());
        }
        return set.size();
    }
}
