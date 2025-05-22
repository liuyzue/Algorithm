package com.huawei;

import java.util.*;

/**
 * @author liuyuze
 * @date 2025/3/14 21:45
 */
public class Qiaoqiaohua {
    public static void main(String[] args) {
       new Qiaoqiaohua().qiaoqiaohua();
    }

    public void qiaoqiaohua() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        Node root = buildTree(split, 0);
        System.out.println(sendMsg(root));
    }

    public int sendMsg(Node node) {
        int total = 0;
        if (node == null) {
            return total;
        }
        return node.val + Math.max(sendMsg(node.left),sendMsg(node.right));
    }

    public Node buildTree(String[] split, int index) {
        if (index >= split.length || split[index].equals("-1")) {
            return null;
        }
        Node node = new Node(Integer.parseInt(split[index]));
        node.left = buildTree(split, 2 * index + 1);
        node.right = buildTree(split, 2 * index + 2);
        return node;
    }

    class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }
}
