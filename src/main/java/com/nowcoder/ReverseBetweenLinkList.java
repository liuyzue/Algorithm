package com.nowcoder;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author LiuYuZe
 * @Date 2023/4/17 17:10
 */
public class ReverseBetweenLinkList {
     public class ListNode {
       int val;
       ListNode next = null;

       public ListNode(int val) {this.val = val;}
     }
    /**
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        if (n <= 1){
            return head;
        }
        ListNode headNode = new ListNode(-1);
        headNode.next = head;
        head = headNode;
        ListNode mNode = headNode;
        ListNode newListHead = new ListNode(-1);
        ListNode newEndNode = new ListNode(-1);
        for (int i = 1; i <= n; i++){
            if (headNode != null) {
                headNode = headNode.next;
            }
            if (i == m - 1){
                mNode = headNode;
            }
            if (i == m){
                newEndNode = new ListNode(headNode.val);
                newListHead.next = newEndNode;
            }
            if (i > m && i <=  n) {
                ListNode tempNode = new ListNode(headNode.val);
                tempNode.next = newListHead.next;
                newListHead.next = tempNode;
            }
            if (i == n){
                newEndNode.next = headNode.next;
                break;
            }
        }
        mNode.next = newListHead.next;
        return head.next;
    }
    public ListNode reverseBetween1 (ListNode head, int m, int n) {
        ListNode headList = new ListNode(-1);
        headList.next = head;
        ListNode headNode = headList;
        ListNode preNode = null;
        for (int i = 1; i < m ; i++) {
            headNode = headNode.next;
        }
        preNode = headNode;
        ListNode currNode = preNode.next;
        ListNode next = null;
        for (int i = m; i < n; i++) {
            next = currNode.next;
            currNode.next = next.next;
            next.next = preNode.next;
            preNode.next = next;
        }
        return headList.next;
    }


    @Test
    public void testMain() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node1.next = node2;node2.next = node3;node3.next = node4;node4.next = node5;node5.next = node6;node6.next = node7;


        ListNode head = node1;
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + ",");
            temp = temp.next;
        }
        System.out.println();
        ListNode result = reverseBetween1(head,2,7);
        while (result != null) {
            System.out.print(result.val + ",");
            result = result.next;
        }

    }
}
