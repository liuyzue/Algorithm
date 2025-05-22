package com.huawei;

import java.util.*;

/**
 * @author liuyuze
 * @date 2025/3/19 10:32
 */
public class ProjectPlan {
    // static int maxTime  = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int num = scanner.nextInt();
        String[] split = str.split(" ");
        int[] jobs = new int[split.length];
        int min = 0;
        int total = 0;
        for (int i = 0; i < split.length; i++) {
            jobs[i] = Integer.parseInt(split[i]);
            total += jobs[i];
            min = Math.max(min,jobs[i]);
        }
        Arrays.sort(jobs);
        for (int i = 0; i < jobs.length / 2; i++) {
            int temp = jobs[jobs.length - 1 - i];
            jobs[jobs.length - 1 - i] = jobs[i];
            jobs[i] = temp;
        }
        for (int i = min; i <= total; i++) {
            if (canDo(jobs,0, new int[num], i)) {
                System.out.println(i);
                break;
            }
        }
    }

    private static boolean canDo(int[] jobs,int jobIndex, int[] persons, int limit) {
        if (jobIndex == jobs.length) {
            return true;
        }
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] + jobs[jobIndex] <= limit) {
                persons[i] = persons[i] + jobs[jobIndex];
                if (canDo(jobs, jobIndex + 1, persons, limit)) {
                    return true;
                }
                persons[i] = persons[i] - jobs[jobIndex];
            }
            if (persons[i] == 0 || persons[i] + jobs[jobIndex] == limit) {
                break;
            }
        }
        return false;
    }


    //超时
    /*private static int dfs(int[] jobs, int i, int[] personTime, int num) {
        if (i == jobs.length) {
            int max = 0;
            for (int time : personTime) {
                max = Math.max(max, time);
            }
            maxTime = Math.min(maxTime,max);
            return 0;
        }
        for (int j = 0; j < personTime.length; j++) {
            int lastTime = personTime[j];
            personTime[j] += jobs[i];
            dfs(jobs, i + 1, personTime, num);
            personTime[j] = lastTime;

        }
        return jobs[i];
    }*/



}
