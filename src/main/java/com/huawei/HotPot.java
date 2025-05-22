package com.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/18 23:53
 */
public class HotPot {
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int m = scanner.nextInt();
        int[] eatTime = new int[num];
        int maxTime = 0;
        int minTime = Integer.MAX_VALUE;
        for (int i = 0; i < num; i++) {
            int addTime = scanner.nextInt();
            int useTime = scanner.nextInt();
            eatTime[i] = addTime + useTime;
            maxTime = Math.max(eatTime[i],maxTime);
            minTime = Math.min(eatTime[i],minTime);
        }
        int[] time = new int[maxTime + 1];
        for (int i : eatTime) {
            time[i] = 1;
        }
        int[] dp = new int[maxTime + 1];
        dp[minTime] = 1;
        int[] timeMax = new int[maxTime + 1];
        for (int i = minTime; i < time.length; i++) {
            dp[i] = time[i] + (i - m - 1 >= 0 ? Math.max(timeMax[i - m - 1],dp[i - m - 1]) : 0);
            timeMax[i] = Math.max(dp[i],timeMax[i - 1]);
        }
        System.out.println(timeMax[maxTime]);

    }*/


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] suit = new int[n];
        for (int i = 0; i < n; i++) {
            suit[i] = sc.nextInt() + sc.nextInt();
        }

        System.out.println(getResult(n, m, suit));
    }
    public static int getResult(int n, int m, int[] suit) {
        Arrays.sort(suit);

        int count = 1; // 第1个合适的菜必吃
        int pre = 0;
        for (int i = 1; i < suit.length; i++) {
            if (suit[i] >= suit[pre] + m) {
                // 如果想要捞本次合适的菜，则必须要与上次捞菜的时间差大于等于m，注意这里是suit[pre] + m ，而不是suit[i-1] + m
                count++;
                // 如果本次捞了菜，则更新缓存本次捞菜的时间点
                pre = i;
            }
        }
        return count;
    }


    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // 创建Scanner对象用于获取用户输入
        int n = scanner.nextInt();  // 读取菜的个数n
        int m = scanner.nextInt();  // 读取手速m，即每次捞菜后必须等待的时间

        List<Integer> times = new ArrayList<>();  // 用于存储每道菜煮熟的时间点
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();  // 读取开始时间
            int duration = scanner.nextInt();  // 读取持续时间
            times.add(start + duration);  // 计算并存储每道菜的煮熟时间
        }

        int[] nums = new int[getMax(times) + 1];  // 创建一个数组，用于标记每个时间点是否有菜
        for (int t : times) {
            nums[t] = 1;  // 将有菜的时间点标记为1
        }

        List<Integer> dp = new ArrayList<>();  // 用于存储不同策略下吃到的菜的数量

        dfs(1, new ArrayList<>(), nums, dp, m);  // 从时间点1开始，使用深度优先搜索

        int max = 0;
        for (int count : dp) {
            max = Math.max(max, count);  // 找出能吃到最多菜的策略
        }

        System.out.println(max);  // 输出最多能吃到的菜的数量
    }

    private static void dfs(int t, List<Integer> data, int[] nums, List<Integer> dp, int m) {
        if (t >= nums.length) {  // 如果时间点超出范围，计算当前策略的总菜数
            int sum = 0;
            for (int count : data) {
                sum += count;  // 统计吃到的菜的总数
            }
            dp.add(sum);  // 将结果加入dp列表
            return;
        }

        if (nums[t] == 1) {  // 当前时间点有菜
            List<Integer> newData = new ArrayList<>(data);  // 创建一个新的策略列表
            newData.add(1);  // 添加吃到的菜
            dfs(t + m, newData, nums, dp, m);  // 选择捞菜后跳过m个时间点继续搜索
            dfs(t + 1, data, nums, dp, m);  // 不捞菜，继续搜索下一个时间点
        } else {
            dfs(t + 1, data, nums, dp, m);  // 如果当前时间点没有菜，直接搜索下一个时间点
        }
    }

    private static int getMax(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int num : list) {
            max = Math.max(max, num);  // 找出列表中的最大值
        }
        return max;
    }*/


}
