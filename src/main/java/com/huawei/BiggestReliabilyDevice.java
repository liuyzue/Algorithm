package com.huawei;

import java.util.*;

/**
 * @author liuyuze
 * @date 2025/3/21 14:25
 */
public class BiggestReliabilyDevice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int n = scanner.nextInt();
        int total = scanner.nextInt();
        Map<Integer, List<int[]>> items = new HashMap<>();
        for (int i = 0; i < total; i++) {
            int id = scanner.nextInt();
            int reliability = scanner.nextInt();
            int cost = scanner.nextInt();
            List<int[]> itemList = items.getOrDefault(id, new ArrayList<>());
            itemList.add(new int[]{reliability, cost});
            items.put(id, itemList);
        }
        int[][] dp = new int[n + 1][s + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints,-1);
        }
        dp[0][0] = Integer.MAX_VALUE;

        /*for (Map.Entry<Integer, List<int[]>> entry : items.entrySet()) {
            List<int[]> list = entry.getValue();
            *//*for (int[] item : list) {
                int cost = item[1];
                int r = item[0];
                for (int i = 1; i < dp.length; i++) {
                    for (int j = s; j >= cost ; j--) {
                        if (dp[i - 1][j - cost] != -1) {
                            dp[i][j] = Math.max(dp[i][j - cost], Math.min(dp[i - 1][j - cost],r));
                        }
                    }
                }
            }*//*
        }*/
        List<List<int[]>> lists = new ArrayList<>(items.values());
        for (int i = 1; i < lists.size() + 1; i++) {

            List<int[]> list = lists.get(i - 1);
            for (int[] item : list) {
                int cost = item[1];
                int r = item[0];
                for (int j = s; j >= cost; j--) {
                    dp[i][j] = Math.max(dp[i][j], Math.min(dp[i - 1][j - cost] , r));
                }
            }
        }
        int max = Arrays.stream(dp[n]).max().getAsInt();
        System.out.println(max);
    }

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int n = scanner.nextInt();
        int total = scanner.nextInt();
        Map<Integer, List<int[]>> items = new HashMap<>();
        for (int i = 0; i < total; i++) {
            int id = scanner.nextInt();
            int reliability = scanner.nextInt();
            int cost = scanner.nextInt();
            List<int[]> itemList = items.getOrDefault(id, new ArrayList<>());
            itemList.add(new int[]{reliability, cost});
            items.put(id, itemList);
        }
        int[][] dp = new int[n + 1][s + 1];

        for (int[] ints : dp) {
            Arrays.fill(ints,-1);
        }
        dp[0][0] = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            List<int[]> list = items.get(i - 1);
            for (int[] item : list) {
                int r = item[0];
                int cost = item[1];

                for (int j = s; j >= cost; j--) {
                    if (dp[i - 1][j - cost] != -1) {
                        dp[i][j] = Math.max(dp[i][j], Math.min(dp[i - 1][j - cost],r));
                    }
                }
            }
        }
        int asInt = Arrays.stream(dp[3]).max().getAsInt();
        System.out.println(asInt);

    }*/

    /*public static int maxReliability(int S, int N, int[][] components) {
        // 初始化每种类型的元器件
        List<int[]>[] types = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            types[i] = new ArrayList<>();
        }

        // 将每个元器件根据其类型进行分类
        for (int[] component : components) {
            int t = component[0];  // 设备类型
            int r = component[1];  // 设备可靠性
            int p = component[2];  // 设备价格
            types[t].add(new int[]{r, p});
        }

        // 初始化 dp 数组，dp[i][j] 表示选择前i种类型的元器件，预算为j时的最大可靠性
        int[][] dp = new int[N + 1][S + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        dp[0][0] = Integer.MAX_VALUE;  // 初始化为无穷大，表示没有选择任何元器件时可靠性无穷大

        // 对每种类型的元器件进行处理
        for (int i = 1; i <= N; i++) {
            // 遍历每种类型的所有元器件
            for (int[] component : types[i - 1]) {
                int r = component[0];  // 设备可靠性
                int p = component[1];  // 设备价格
                // 从后向前更新dp数组，确保每个元器件只使用一次
                for (int budget = S; budget >= p; budget--) {
                    if (dp[i - 1][budget - p] != -1) {
                        dp[i][budget] = Math.max(dp[i][budget], Math.min(dp[i - 1][budget - p], r));
                    }
                }
            }
        }

        // 找到预算范围内的最大可靠性
        int result = Arrays.stream(dp[N]).max().getAsInt();
        return result == -1 ? -1 : result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 从输入获取预算和元器件信息
        int S = sc.nextInt();  // 预算
        int N = sc.nextInt();  // 元器件类型数量
        int total = sc.nextInt();  // 总元器件数目

        int[][] components = new int[total][3];  // 存储每个元器件的类型、可靠性和价格
        for (int i = 0; i < total; i++) {
            components[i][0] = sc.nextInt();  // 元器件类型
            components[i][1] = sc.nextInt();  // 元器件可靠性
            components[i][2] = sc.nextInt();  // 元器件价格
        }

        // 计算并输出最大可靠性
        System.out.println(maxReliability(S, N, components));
    }*/
}
