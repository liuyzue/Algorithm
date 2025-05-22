package com.huawei.n2025a;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuyuze
 * @date 2025/3/31 22:27
 */
public class HalfmanTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.value > o2.value) {
                return 1;
            }
            if (o1.value < o2.value) {
                return -1;
            }
            if (o1.high > o2.high) {
                return 1;
            }
            if (o1.high < o2.high) {
                return -1;
            }
            return 0;
        });
        for (int i = 0; i < n; i++) {
            priorityQueue.offer(new Node(scanner.nextInt()));
        }
        Node result = null;
        while (!priorityQueue.isEmpty()) {
            Node poll1 = priorityQueue.poll();
            Node poll2 = priorityQueue.poll();
            Node root = new Node(poll1.value + poll2.value);
            if (poll1.value > poll2.value) {
                root.left = poll2;
                root.right = poll1;
            }
            if (poll1.value < poll2.value) {
                root.left = poll1;
                root.right = poll2;
            }
            if (poll1.value == poll2.value) {
                root.left = poll1.high <= poll2.high ? poll1 : poll2;
                root.right = poll1.high > poll2.high ? poll1 : poll2;
            }
            root.high = Math.max(poll1.high, poll2.high) + 1;
            if (priorityQueue.isEmpty()){
                result = root;
                break;
            }
            priorityQueue.offer(root);
        }
        List<Integer> list = new ArrayList<>();
        midSearch(result,list);

        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static void midSearch(Node result, List<Integer> list) {

        if (result.left != null) {
            midSearch(result.left, list);
        }
        list.add(result.value);
        if (result.right != null) {
            midSearch(result.right, list);
        }

    }

    public static class Node {
        int value;
        Node left;
        Node right;
        int high;
        Node(int value) {
            this.value = value;
            left = null;
            right = null;
            high = 0;
        }
    }

}
