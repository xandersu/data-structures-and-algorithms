package com.xandersu.my_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author su
 * @date 2020/5/219:12
 * @description 读入一个字符串str，输出字符串str中的连续最长的数字串（Java实现）
 * https://www.nowcoder.com/practice/bd891093881d4ddf9e56e7cc8416562d?tpId=85&&tqId=29864&rp=1&ru=/activity/oj&qru=/ta/2017test/question-ranking
 */
public class MaxNumString {

    public static String maxNumString(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        int max = 0;
        int count = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                count++;
                if (count > max) {
                    max = count;
                    index = i;
                }
            } else {
                count = 0;
            }
        }
        return max > 0 ? s.substring(index - max + 1, index + 1) : null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        String s = new String(line);
        if (s.length() == 0) {
            return;
        }

        int max = 0;
        int count = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                count++;
                if (count > max) {
                    max = count;
                    index = i;
                }
            } else {
                count = 0;
            }
        }
        System.out.println(max > 0 ? s.substring(index - max + 1, index + 1) : null);
    }


}
