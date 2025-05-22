package com.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/24 20:48
 */
public class SuShuBanlv {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        List<Integer> sList = new ArrayList<>();
        List<Integer> dList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
            if (nums[i] % 2 == 0)  {
                dList.add(nums[i]);
            } else {
              sList.add(nums[i]);
            }
        }
        int total = 0;
        int[] state = new int[sList.size()];
        for (int i = 0; i < dList.size(); i++) {
            boolean[] visited = new boolean[sList.size()];
            Arrays.fill(visited, false);
            if (bfs(dList.get(i),dList,i,sList,state,visited)) {
                total++;
            }
        }
        System.out.println(total);
    }
    private static boolean bfs(int a,List<Integer> dList,int i, List<Integer> sList,int[] state, boolean[] visited) {
        for (int j = 0; j < sList.size(); j++) {
            Integer b = sList.get(j);
            if (!visited[j] && isSushu(a + b)) {
                visited[j] = true;
                if (state[j] == 0 || bfs(state[j],dList,i,sList,state,visited)) {
                    state[j] = a;
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isSushu(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
