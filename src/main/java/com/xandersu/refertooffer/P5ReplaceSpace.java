package com.xandersu.refertooffer;

/**
 * Created by lenovo on 2019/10/28.
 */
public class P5ReplaceSpace {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("we are family ");
//        System.out.println(replaceSpace1(sb));
        System.out.println(replaceSpace2(sb));
    }

    public static String replaceSpace1(StringBuffer str) {
//        String s = str.toString();

        while (str.indexOf(" ") != -1) {
            int i = str.indexOf(" ");
            str.replace(i, i + 1, "%20");
        }
        return str.toString();
    }

    public static String replaceSpace2(StringBuffer str) {
        String s = str.toString();
        char[] chars = s.toCharArray();
        int lengthSpace = 0;
        for (char aChar : chars) {
            if (aChar == ' ') {
                lengthSpace++;
            }
        }

        int oldCharIndex = 0;
        char[] newChar = new char[str.length() + lengthSpace * 2];
        for (int i = 0; i < newChar.length - 1; ) {
            char oldCharAt = str.charAt(oldCharIndex);
            if (oldCharAt == ' ') {
                newChar[i++] = '%';
                newChar[i++] = '2';
                newChar[i++] = '0';
            } else {
                newChar[i++] = oldCharAt;
            }
            oldCharIndex++;
        }
        return new String(newChar);
    }
}
