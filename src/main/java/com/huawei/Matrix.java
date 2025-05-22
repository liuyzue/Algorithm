package com.huawei;

import java.util.*;

/**
 * @author liuyuze
 * @date 2025/3/20 0:08
 */
public class Matrix {

    /*static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        Set<String> existsSet = new HashSet<>();
        List<List<Integer>> selectList = new ArrayList<>();
        find(matrix, 0, new ArrayList<>(), selectList, new HashSet<Integer>(), n, m, existsSet,k);
        *//*int min = Integer.MAX_VALUE;
        for (List<Integer> list : selectList) {
            min = Math.min(min, list.get(list.size() - k));
        }*//*
        System.out.println(min);
    }
    private static void find(int[][] matrix, int rowIndex, List<Integer> select, List<List<Integer>> selectList, HashSet<Integer> set, int n, int m,Set<String> existsSet,int k) {

        if (select.size() == n) {
            List<Integer> sortedList = select.stream().sorted().collect(Collectors.toList());
            *//*StringBuilder sb = new StringBuilder();
            for (Integer i : sortedList) {
                sb.append(i);
            }
            if (!existsSet.contains(sb.toString())) {
                selectList.add(sortedList);
            }*//*
            min = Math.min(min, sortedList.get(k - 1));
            return;
        }
        for (int j = 0; j < m; j++) {
            if (!set.contains(j)) {
                select.add(matrix[rowIndex][j]);
                set.add(j);
                find(matrix, rowIndex + 1, select, selectList, set, n, m, existsSet,k);
                select.remove(select.size() - 1);
                set.remove(j);
            }
        }
    }*/

    static int n;
    static int m;
    static int k;
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        matrix = new int[n][m];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
                max = Math.max(max, matrix[i][j]);
                min = Math.min(min, matrix[i][j]);
            }
        }
        int mid;
        while (min <= max) {
            mid = (min + max) / 2;
            if (find1(mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min);
    }

    private static boolean find1(int mid) {
        int[] match = new int[m];
        Arrays.fill(match,-1);
        boolean[] visited = new boolean[m];
        int line = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited,false);
            if (dfs(i,match,visited,mid)) {
                line++;
            }
        }
        return line >= n - k + 1;
    }

    private static boolean dfs(int i, int[] match, boolean[] visited, int mid) {
        for (int j = 0; j < m; j++) {
            if (!visited[j] && matrix[i][j] <= mid) {
                visited[j] = true;
                if (match[j] == -1 || dfs(match[j], match, visited, mid)) {
                    match[j] = i;
                    return true;
                }
            }
        }
        return false;
    }
}
