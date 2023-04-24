package com.nowcoder;

import org.junit.Test;

/**
 * @Author LiuYuZe
 * @Date 2023/4/20 9:13
 */
public class MergeSortedList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode currNode = result;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                currNode.next = list1;
                list1 = list1.next;
            } else  {
                currNode.next = list2;
                list2 = list2.next;
            }
            currNode = currNode.next;
        }
        if (list1 == null) {
            currNode.next = list2;
        }
        if (list2 == null) {
            currNode.next = list1;
        }
        return result.next;
    }

    @Test
    public void test1(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(7);

        node1.next = node3;node3.next = node5;node5.next = node7;
        node2.next = node4;node4.next = node6;

        ListNode temp1 = node1;
        ListNode temp2 = node2;


        while (temp1 != null) {
            System.out.print(temp1.val + ",");
            temp1 = temp1.next;
        }
        System.out.println();
        while (temp2 != null) {
            System.out.print(temp2.val + ",");
            temp2 = temp2.next;
        }
        System.out.println();
        ListNode result = Merge(node1,node2);
        while (result != null) {
            System.out.print(result.val + ",");
            result = result.next;
        }

    }
}
