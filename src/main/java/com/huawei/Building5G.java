package com.huawei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuyuze
 * @date 2025/3/20 22:49
 */
public class Building5G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] edges = new int[m][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 4; j++) {
                edges[i][j] = scanner.nextInt();
            }
        }
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        Arrays.sort(edges,Comparator.comparing(a -> a[2]));
        for (int[] ints : edges) {
            if (ints[3] == 1) {
                parent[ints[0]] = ints[1];
            }
        }
        int cost = 0;
        for (int[] edge : edges) {
            int root0 = find(parent, edge[0]);
            int root1 = find(parent, edge[1]);
            if (root0 == root1) {
                continue;
            }
            parent[root0] = root1;
            cost += edge[2];

        }
        for (int i = 1; i <= n; i++) {
            if (find(parent, i) != find(parent, 1)) {
                System.out.println("-1");
                return;
            }
        }
        System.out.println(cost);

    }

    public static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}
