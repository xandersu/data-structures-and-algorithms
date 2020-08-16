package com.xandersu.class082_leetcode.chapter_6;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author suxun
 * @date 2020/8/16 16:46
 * @description
 */
public class $1_20_valid_parentheses_My {
    char leftParentheses = '(';
    char rightParentheses = ')';
    char leftMiddleParentheses = '{';
    char rightMiddleParentheses = '}';
    char leftSquareParentheses = '[';
    char rightSquareParentheses = ']';

    public static boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (!((c == ')' && pop.equals('('))
                        || (c == ']' && pop.equals('['))
                        || (c == '}' && pop.equals('{')))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }
}
