package com.xandersu.my_test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SearchBinartTree {

    public static void main(String[] args) {
        BTreeNFloorPointNum.TreeNode node = new BTreeNFloorPointNum.TreeNode();
        node.add(50);
        node.add(5);
        node.add(52);
        node.add(1);
        node.add(13);
        node.add(100);
        node.add(51);

        System.out.println(node.toString());
        String s = JSON.toJSONString(search(node, 202));
        System.out.println(s);
    }

    public static List<Integer> search(BTreeNFloorPointNum.TreeNode node,int target){
        List<Integer> list = new ArrayList<>();
        search(node,list,target);
        return list;
    }


    public static void search(BTreeNFloorPointNum.TreeNode node,List<Integer> list,int target){
        if (node == null) {
            return;
        }
        list.add(node.val);
        if(node.left== null && node.right == null){
            int sum = 0;
            for (Integer integer : list) {
                sum +=integer;
            }
            if (sum == target) {
                System.out.println(JSON.toJSONString(list));
                return;
            }

        }
        search(node.left,list,target);
        search(node.right,list,target);
        if(list.size()>0){
            list.remove(list.size()-1);
        }
    }

}
