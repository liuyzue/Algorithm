package com.leecode;

public class _0092ReverseBetweenⅡ {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cur = newHead;
        ListNode reverseNode = new ListNode(0);
        ListNode pre = new ListNode(0);
        ListNode tail = new ListNode(0);
        int index = 0;
        while (index <= right) {
            if (index < left - 1) {
                cur = cur.next;
            }
            if (index == left - 1){
                pre = cur;
                cur = cur.next;
                pre.next = null;
            }  else if (index >= left) {
                if (index == left) {
                    tail = cur;
                }
                ListNode temp = cur.next;
                cur.next = reverseNode.next;
                reverseNode.next = cur;
                cur = temp;
            }
            ++index;
        }
        pre.next = reverseNode.next;
        tail.next = cur;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next= new ListNode(4);
        head.next.next.next = new ListNode(7);
        ListNode n = new _0092ReverseBetweenⅡ().reverseBetween(head, 2, 4);
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
