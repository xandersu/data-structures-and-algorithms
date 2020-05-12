package com.xandersu.my_test.practice;

import com.xandersu.class071_algorithms.SortUtil;
import lombok.ToString;

import java.util.Arrays;

/**
 * @author: suxun
 * @date: 2020/5/4 10:03
 * @description:
 */
public class Practice200508 {

    //insert
    public static void insert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            int num = arr[i];
            for (; j > 0 && num < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = num;
        }
    }


    //merge
    public static void merge(int[] arr) {
        merge(arr, 0, arr.length - 1);
    }

    private static void merge(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        merge(arr, l, mid);
        merge(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(arr, l, r + 1);
        int lIndex = l;
        int rIndex = mid + 1;
        int k = l;
        while (lIndex <= mid && rIndex <= r) {
            if (aux[lIndex - l] < aux[rIndex - l]) {
                arr[k] = aux[lIndex - l];
                lIndex++;
            } else {
                arr[k] = aux[rIndex - l];
                rIndex++;
            }
            k++;
        }
        for (; lIndex <= mid; lIndex++, k++) {
            arr[k] = aux[lIndex - l];
        }
        for (; rIndex <= r; rIndex++, k++) {
            arr[k] = aux[rIndex - l];
        }
    }

    //quick_1
    public static void quick_1(int[] arr) {
        quick_1(arr, 0, arr.length - 1);

    }

    public static void quick_1(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition_1(arr, l, r);
        quick_1(arr, l, p - 1);
        quick_1(arr, p + 1, r);
    }

    public static int partition_1(int[] arr, int l, int r) {
        int v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                j++;
                swap(arr, i, j);
            }
        }

        swap(arr, l, j);
        return j;
    }

    //quick_2
    public static void quick_2(int[] arr) {
        quick_2(arr, 0, arr.length - 1);
    }

    public static void quick_2(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition_2(arr, l, r);
        quick_2(arr, l, p - 1);
        quick_2(arr, p + 1, r);
    }

    public static int partition_2(int[] arr, int l, int r) {
        int v = arr[l];
        //[l+1,lt-1]<v
        int lt = l + 1;
        //[gt+1,r]>v
        int gt = r;
        while (true) {
            while (lt <= r && arr[lt] < v) {
                lt++;
            }
            while (gt >= l + 1 && arr[gt] > v) {
                gt--;
            }
            if (lt > gt) {
                break;
            }
            swap(arr, lt, gt);
            lt++;
            gt--;
        }
        swap(arr, l, gt);
        return gt;
    }

    //quick_3
    public static void quick_3(int[] arr) {
        quick_3(arr, 0, arr.length - 1);

    }

    public static void quick_3(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int v = arr[l];
        //[l+1,lt]<v
        int lt = l;
        //[gt,r]>v
        int gt = r + 1;
        //[lt+1,i-1]=v
        int i = lt + 1;
        while (i < gt) {
            if (arr[i] < v) {
                lt++;
                swap(arr, lt, i);
                i++;
            } else if (arr[i] > v) {
                gt--;
                swap(arr, gt, i);
            } else {
                i++;
            }
        }
        swap(arr, l, lt);
        quick_3(arr, l, lt - 1);
        quick_3(arr, gt, r);

    }

    //reverseLinkedList
    public static ListNode reverseLinkedList_1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverseLinkedList_1(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }

    public static ListNode reverseLinkedList_2(ListNode head) {
        ListNode temp = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }
        return temp;
    }


    @ToString
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int x) {
            val = x;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
//        SortUtil.verify(Practice200508::insert, 10000, 100000);
//        SortUtil.verify(Practice200508::merge, 100000, 100000);
//        SortUtil.verify(Practice200508::quick_1, 1000000, 100000);
//        SortUtil.verify(Practice200508::quick_2, 1000000, 100000);
        SortUtil.verify(Practice200508::quick_3, 1000000, 100000);

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode9 = new ListNode(9);
        ListNode listNode10 = new ListNode(10);
        ListNode listNode11 = new ListNode(11);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;
        listNode10.next = listNode11;
//        System.out.println(listNode1);

//        System.out.println(reverseLinkedList_1(listNode1));
//        System.out.println(reverseLinkedList_2(listNode1));


    }

}
