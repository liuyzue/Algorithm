package com.nowcoder;
/**
* @Author LiuYuZe
* @Date 2023/4/17 17:05
 * 反转链表
 *
 * 给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头。
 *
 * 数据范围：
 * 要求：空间复杂度  ，时间复杂度  。
 *
 * 如当输入链表{1,2,3}时，
 * 经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。
*/
public class ReverseLinkList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        ListNode newHead = null;

        ListNode cur = head;

        while (cur != null ) {
            ListNode temp = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = temp;
        }
        return newHead;
    }
}
