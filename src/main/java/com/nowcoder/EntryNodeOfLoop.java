package com.nowcoder;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class EntryNodeOfLoop {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode entryNodeOfLoop(ListNode pHead) {
        ListNode current = pHead;
        Set<ListNode> nodeSet = new HashSet<>();
        while(current != null) {
            if (nodeSet.contains(current)) {
                return current;
            } else {
                nodeSet.add(current);
            }
            current = current.next;
        }
        return null;
    }

    @Test
    public void test(){

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;node2.next = node3;node3.next = node4;
        node4.next = node5;node5.next = node3;

        ListNode result = entryNodeOfLoop(node1);
        if (result != null) {
            System.out.println(result.val);
        } else {
            System.out.println("null");
        }
    }
}
