package com.leecode;

public class LCR024_ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode result = new ListNode();
        while (head != null) {
            ListNode listNode = new ListNode(head.val);
            listNode.next = result.next;
            result.next = listNode;
            head = head.next;
        }
        return result.next;
    }

    public static ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (head != null) {
            head = head.next;
            cur.next = pre;
            pre = cur;
            cur = head;
        }
        return pre;
    }

    public static void main(String[] args) {
       /* ListNode result = new ListNode(1);
        result.next = new ListNode(2);
        result.next.next = new ListNode(3);
        result.next.next.next = new ListNode(4);
        result.next.next.next.next = new ListNode(5);

        System.out.println(result.val + " " +result.next.val + " " + result.next.next.val + " "+ result.next.next.next.val + " "+ result.next.next.next.next.val + " ");

        result = reverseList1(result);

        System.out.println(result.val + " " + result.next.val + " " + result.next.next.val + " "+ result.next.next.next.val + " "+ result.next.next.next.next.val + " ");
    */
        System.out.println(10 << 1);
    }
}
