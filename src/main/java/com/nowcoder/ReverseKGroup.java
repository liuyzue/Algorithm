package com.nowcoder;

import org.junit.Test;

import java.util.List;

/**
 * @Author LiuYuZe
 * @Date 2023/4/19 10:32
 */
public class ReverseKGroup {

    public class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }
    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        ListNode headList = new ListNode(-1);
        headList.next = head;
        ListNode currNode = headList;
        ListNode groupEndNode = null;
        int count = 0;
        while (currNode != null) {
            currNode = currNode.next;
            count++;
            if (count == k && currNode != null){
                groupEndNode = currNode.next;
                ListNode reverseNode = head;
                ListNode next = null;
                while (reverseNode.next != groupEndNode) {
                    next = reverseNode.next;
                    reverseNode.next = next.next;
                    next.next =  headList.next;
                    headList.next = next;
                }
                reverseNode.next = reverseKGroup(groupEndNode,k);
                break;
            }
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
        ListNode result = reverseKGroup(head,8);
        while (result != null) {
            System.out.print(result.val + ",");
            result = result.next;
        }

    }
}
