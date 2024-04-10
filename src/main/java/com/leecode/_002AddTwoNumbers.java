package com.leecode;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class _002AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r = new ListNode();
        ListNode curr = r;
        int incr = 0;
        while (l1 != null || l2 != null || incr != 0) {
            int result = incr;
            if (l1 != null) {
                result += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                result += l2.val;
                l2 = l2.next;
            }
            ListNode h = new ListNode(result % 10);
            curr.next = h;
            curr = h;
            incr = result / 10;
        }
        return r.next;
    }




    public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(5);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);

        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
