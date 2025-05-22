package com.huawei;

import java.util.*;

/**
 * @author liuyuze
 * @date 2025/3/21 9:44
 */
public class SpecialSecret {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] str = new int[n];
        for (int i = 0; i < n; i++) {
            str[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[][] sec = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                sec[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (sec[i][j] == str[0]) {
                    List<String> resultList = new ArrayList<>();
                    if (dfs(i,j,sec,str,resultList)) {
                        resultList.sort(Comparator.naturalOrder());
                        System.out.println(resultList.get(0));
                        return;
                    }
                }
            }
        }
        System.out.println("error");
    }

    private static boolean dfs(int i, int j, int[][] sec, int[] str,  List<String> resultList) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] node = {i,j,0};
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        stack.push(node);
        Map<Integer, String> stepMap = new HashMap<>();
        Set<String> visited = new HashSet<>();
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            stepMap.put(pop[2],pop[0] + " " + pop[1]);
            visited.add(pop[0] + "," + pop[1]);
            if (pop[2] == str.length - 1) {
                List<Integer> list = new ArrayList<>(stepMap.keySet());
                list.sort(Comparator.comparingInt(a -> a));
                String[] result = new String[list.size()];
                for (int k = 0; k < list.size(); k++) {
                    result[k] = stepMap.get(k);
                }
                resultList.add(String.join(" ",result));
                continue;
            }
            List<int[]> nextNode = new ArrayList<>();
            for (int[] dir : dirs) {
                int x = pop[0] + dir[0];
                int y = pop[1] + dir[1];
                if (x >= 0 && y >= 0 && x < sec.length && y < sec.length
                && sec[x][y] == str[pop[2] + 1]) {
                    nextNode.add(new int[]{x,y,pop[2] + 1});
                }
            }
            if (!nextNode.isEmpty()) {
                nextNode.sort(Comparator.comparingInt(a -> (a[0] * 10) + a[1]));
                for (int k = nextNode.size() - 1; k >= 0 ; k--) {
                    if (!visited.contains(nextNode.get(k)[0] + "," + nextNode.get(k)[1])) {
                        stack.push(nextNode.get(k));
                    }
                }
            }
        }
        return !resultList.isEmpty();
    }
}
