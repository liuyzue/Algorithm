package com.nowcoder;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author LiuYuZe
 * @Date 2023/4/20 10:09
 */
public class MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode merge(ListNode list1, ListNode list2) {
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

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode result = null;
        for (int i = 0; i < lists.size(); i++) {
            result = merge(result,lists.get(i));
        }
        return result;
    }

    public ListNode mergeKLists1(ArrayList<ListNode> lists, int start, int end) throws InterruptedException {
        //Thread.sleep(1000);
        if (end < 0) {
            return null;
        } else {
            return merge(mergeKLists1(lists , start, end / 2 - 1), mergeKLists1(lists , end / 2 , end - 1));
        }
    }

    @Test
    public void test1() throws InterruptedException {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node0 = new ListNode(10);

        node1.next = node8;node8.next = node9;node9.next = node0;
        node2.next = node4;node4.next = node6;
        node3.next = node5;node5.next = node7;

        ListNode temp1 = node1;
        ListNode temp2 = node2;
        ListNode temp3 = node3;
        ArrayList<ListNode> lists = new ArrayList();
        lists.add(node1);lists.add(node2);lists.add(node3);

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
        while (temp3 != null) {
            System.out.print(temp3.val + ",");
            temp3 = temp3.next;
        }
        //System.out.println(lists.remove(0));
        System.out.println();
        long start = System.currentTimeMillis();
        ListNode result = mergeKLists1(lists, 0 ,lists.size());
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(time);
        while (result != null) {
            System.out.print(result.val + ",");
            result = result.next;
        }

    }
}
