package com.xandersu.class082_leetcode.chapter_3;

/**
 * @author suxun
 * @date 2020/8/2 17:48
 * @description
 */
public class $8_3_longest_substring_without_repeating_characters {

    public static int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int l = 0;
        int r = -1;
        int maxLength = 0;
        while (r + 1 < s.length() && l < s.length()) {
            if (freq[s.charAt(r + 1)] == 0) {
                r++;
                freq[s.charAt(r)]++;
            } else {
                freq[s.charAt(l)]--;
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {

    }
}
