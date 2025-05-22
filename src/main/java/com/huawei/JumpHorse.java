package com.huawei;

import java.util.*;

/**
 * @author liuyuze
 * @date 2025/3/17 16:59
 */
public class JumpHorse {
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<int[]> horseList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String next = scanner.next();
                if (!".".equals(next)) {
                    int[] horse = {i,j,Integer.parseInt(next)};
                    horseList.add(horse);
                }
            }
        }
        boolean canReach = true;
        int minStep = Integer.MAX_VALUE;
        int[][] dir = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int[] target = {i,j};
                boolean found = false;
                int step = 0;
                for (int[] horse : horseList) {
                    Queue<int[]> queue = new LinkedList<>();
                    Map<String,Integer> visitedMap = new HashMap<>();
                    queue.offer(new int[]{horse[0],horse[1],0});
                    int maxStep = horse[2];
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        if (poll[0] == target[0] && poll[1] == target[1]) {
                            step += poll[2];
                            found = true;
                            break;
                        }
                        //是否访问过
                        if (visitedMap.get(poll[0] + "," + poll[1]) != null) {
                            continue;
                        }
                        //添加到访问列表
                        visitedMap.put(poll[0] +"," + poll[1], poll[2]);
                        //访问新位置 步骤加一
                        int nextStep = poll[2] + 1;
                        for (int[] dirs : dir) {
                            if (nextStep <= maxStep && poll[0] + dirs[0] >= 0 && poll[0] + dirs[0] < n && poll[1] + dirs[1] >= 0 && poll[1] + dirs[1] < m) {
                                queue.offer(new int[]{poll[0] + dirs[0], poll[1] + dirs[1], nextStep});
                            }
                        }
                    }
                    if (!found) {
                        canReach = false;
                        break;
                    }
                }
                if (found) {
                    minStep = Math.min(minStep,step);
                }
            }
        }
        if (canReach) {
            System.out.println(minStep);
        } else {
            System.out.println(0);
        }
    }*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<int[]> horseList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String next = scanner.next();
                if (!".".equals(next)) {
                    int[] horse = {i,j,Integer.parseInt(next)};
                    horseList.add(horse);
                }
            }
        }
        horseList.sort(Comparator.comparingInt(a -> a[2]));
        List<Map<String,Integer>> pointMapList = new ArrayList<>();
        for (int[] horse : horseList) {
            pointMapList.add(reachablePoint(horse, m, n));
        }
        Map<String, Integer> minPointMap = pointMapList.get(0);
        int minStep = Integer.MAX_VALUE;
        boolean found = false;
        for (String point : minPointMap.keySet()) {
            int totalStep = minPointMap.get(point);
            boolean has = true;
            for (int i = 1; i < pointMapList.size(); i++) {
                Map<String, Integer> pointMap = pointMapList.get(i);
                Integer stepNum = pointMap.get(point);
                if (stepNum == null) {
                    has = false;
                    break;
                }
                totalStep += stepNum;
            }
            if (has) {
                found = true;
                minStep = Math.min(minStep,totalStep);
            }
        }
        if (found) {
            System.out.println(minStep);
        } else {
            System.out.println(0);
        }
    }

    public static Map<String, Integer> reachablePoint(int[] horse,int m, int n) {
        Map<String, Integer> visitedMap = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{horse[0],horse[1],0});
        int[][] dir = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
        int maxStep = horse[2];
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (visitedMap.get(poll[0] + "," + poll[1]) != null) {
                continue;
            }
            visitedMap.put(poll[0] + "," + poll[1],poll[2]);
            int nextStep = poll[2] + 1;
            for (int[] dirs : dir) {
                if (nextStep <= maxStep && poll[0] + dirs[0] >= 0 && poll[0] + dirs[0] < n && poll[1] + dirs[1] >= 0 && poll[1] + dirs[1] < m) {
                    queue.offer(new int[]{poll[0] + dirs[0], poll[1] + dirs[1], nextStep});
                }
            }
        }
        return visitedMap;
    }

}
