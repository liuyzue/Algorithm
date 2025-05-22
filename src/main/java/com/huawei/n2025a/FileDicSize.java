package com.huawei.n2025a;

import java.util.*;

/**
 * @author liuyuze
 * @date 2025/3/29 20:19
 */
public class FileDicSize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        Map<Integer, String> childDirMap = new HashMap<>();
        Map<Integer, Integer> sizeMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int fileId = scanner.nextInt();
            int size = scanner.nextInt();
            String childDir = scanner.next().replace("(", "").replace(")", "");
            sizeMap.put(fileId, size);
            if (!childDir.isEmpty()) {
                childDirMap.put(fileId, childDir);
            }
        }
        Integer totalSize = sizeMap.get(n);
        String s = childDirMap.get(n);
        if (s == null || s.isEmpty()) {
            System.out.println(totalSize);
            return;
        }
        Queue<Integer> childQueue = new LinkedList<>();
        String[] children = s.split(",");
        for (String child : children) {
            childQueue.offer(Integer.parseInt(child));
        }
        while (!childQueue.isEmpty()) {
            Integer childId = childQueue.poll();
            Integer nextSize = sizeMap.get(childId);
            totalSize += nextSize;

            String nextChildren = childDirMap.get(childId);
            if (nextChildren != null && !nextChildren.isEmpty()) {
                String[] next = nextChildren.split(",");
                for (String child : next) {
                    childQueue.offer(Integer.parseInt(child));
                }
            }
        }
        System.out.println(totalSize);
    }
}
