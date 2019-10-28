package com.xandersu.refertooffer;

/**
 * Created by lenovo on 2019/10/28.
 */
public class P4FindInTwoDimensionalArray {

    public static void main(String[] args) {
        int[][] array = {{1, 4}, {3, 4}, {4, 5}, {5, 6}};
        System.out.println(Find(3, array));
    }

    public static boolean Find(int target, int[][] array) {
        int row = array.length - 1;
        int column = array[0].length - 1;

        int i = row;
        int j = 0;
        while (i >= 0 && j >= 0 && i <= row && j <= column) {
            if (array[i][j] > target) {
                i--;
            } else if (array[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
