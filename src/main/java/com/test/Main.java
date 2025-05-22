package com.test;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

// 定义一个节点类来表示哈夫曼树中的节点
class Node {
    int value;       // 节点存储的权值
    Node left;       // 指向左子节点的引用
    Node right;      // 指向右子节点的引用
    int height;      // 节点的高度，用于处理相等权值的情况

    // 构造函数
    public Node(int v) {
        value = v;
        left = null;
        right = null;
        height = 0;
    }
}

// 实现比较器，用于优先队列的比较逻辑
class Compare implements Comparator<Node> {
    @Override
    public int compare(Node a, Node b) {
        // 首先比较节点的权值，若权值相等则比较高度
        if (a.value > b.value) return 1;
        if (a.value < b.value) return -1;
        if (a.height > b.height) return 1;
        if (a.height < b.height) return -1;
        return 0;
    }
}

public class Main {
    // 构建哈夫曼树的函数
    public static Node buildHuffmanTree(ArrayList<Integer> values) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Compare());  // 使用优先队列存储节点
        // 为每个权值创建一个节点并添加到优先队列中
        for (int value : values) {
            pq.add(new Node(value));
        }

        // 当队列中至少有两个节点时，执行循环
        while (pq.size() > 1) {
            Node left = pq.poll();  // 弹出最小的节点作为左子节点
            Node right = pq.poll(); // 弹出次小的节点作为右子节点

            // 创建一个新节点，其权值为左右子节点的权值之和
            Node parent = new Node(left.value + right.value);
            // 确保左子节点权值不大于右子节点权值，若相等则比较高度
            if (left.value > right.value || (left.value == right.value && left.height > right.height)) {
                Node temp = left;
                left = right;
                right = temp;  // 交换左右子节点
            }
            parent.left = left;
            parent.right = right;
            parent.height = Math.max(left.height, right.height) + 1;  // 计算新节点的高度
            pq.add(parent);  // 将新节点加入优先队列
        }
        // 返回优先队列中剩余的最后一个节点，即哈夫曼树的根节点
        return pq.peek();
    }

    // 中序遍历哈夫曼树，并将遍历结果保存为字符串
    public static void inorderTraversal(Node root, StringBuilder result) {
        if (root != null) {
            inorderTraversal(root.left, result);  // 遍历左子树
            result.append(root.value).append(" ");  // 访问当前节点
            inorderTraversal(root.right, result);  // 遍历右子树
        }
    }

    // 主函数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 读取节点数量
        ArrayList<Integer> values = new ArrayList<>();  // 存储所有节点的权值
        for (int i = 0; i < n; i++) {
            values.add(scanner.nextInt());  // 读取权值
        }
        Node root = buildHuffmanTree(values);  // 构建哈夫曼树
        StringBuilder result = new StringBuilder();  // 用于存储中序遍历结果
        inorderTraversal(root, result);  // 执行中序遍历
        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);  // 移除最后的空格
        }
        System.out.println(result.toString());  // 输出中序遍历结果
        scanner.close();
    }
}

