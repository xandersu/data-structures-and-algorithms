package com.xandersu.class082_leetcode.chapter_8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author suxun
 * @date 2020/9/13 11:56
 * @description
 */
public class $1_17_letter_combinations_of_a_phone_number {

    private String[] letterMap = {"", "",
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return res;
        }
        letterCombinations(digits, 0, "");
        return res;
    }

    public void letterCombinations(String digits, int index, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            letterCombinations(digits, index + 1, s + letters.charAt(i));
        }
    }
}
