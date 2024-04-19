package com.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0138CopyRandomList {
    public Node copyRandomList(Node head) {
        Node headCur = head;
        Node resHead = new Node(0);
        Node cur = resHead;
        Map<Node, Node> nodeMap = new HashMap<>();
        while (headCur != null) {
            Node node = new Node(headCur.val);
            cur.next = node;
            cur = cur.next;
            nodeMap.put(headCur, node);
            headCur = headCur.next;
        }
        cur = resHead.next;
        headCur = head;
        while (cur != null && headCur != null) {
            Node random = headCur.random;
            if (random != null) {
                cur.random = nodeMap.get(random);
            }
            cur = cur.next;
            headCur = headCur.next;
        }
        return resHead.next;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
