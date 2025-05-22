package com.nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyuze
 * @date 2025/4/7 22:10
 */
public class NC2 {

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        reorderList(node);
    }

    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            System.out.println(head.val);
            return;
        }
        ListNode node = head;
        List<ListNode> list = new ArrayList<>();
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        ListNode cur = null;

        int rear = list.size() - 1;
        int front = 0;
        while (front < rear) {

            ListNode frontNode = list.get(front);
            ListNode rearNode = list.get(rear);

            if (cur != null) {
                cur.next = frontNode;
            }
            rearNode.next = null;
            frontNode.next = rearNode;

            cur = rearNode;

            front++;
            rear--;

            if (front == rear) {
                ListNode next = list.get(front);
                next.next = null;
                cur.next = next;
            }

        }

        StringBuilder sb = new StringBuilder();
        ListNode node1 = list.get(0);
        while (node1 != null) {
            sb.append(node1.val).append(",");
            node1 = node1.next;
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */