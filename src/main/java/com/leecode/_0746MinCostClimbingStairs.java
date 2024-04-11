package com.leecode;

public class _0746MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2 || cost.length > 1000) {
            return 0;
        }
        return Math.min(minSum(cost,0),minSum(cost, 1));
    }

    public static int minSum(int[] cost, int index) {
        if (index > cost.length - 3 && index < cost.length) {
            return cost[index];
        }
        if (index >= cost.length) {
            return 0;
        }
        return Math.min(cost[index] + minSum(cost,index + 1), cost[index] + minSum(cost, index + 2));
    }

    public static int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        if (n < 2 || n > 1000) {
            return 0;
        }
        int[] stepCost = new int[n + 1];
        stepCost[0] = stepCost[1] = 0;
        for (int i = 2; i <= n; i++ ) {
            stepCost[i] = Math.min(stepCost[i-1] + cost[i-1], stepCost[i - 2] + cost[i - 2]);
        }

        return stepCost[n];
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs1(new int[]{841,462,566,398,243,248,238,650,989,576,361,126,334,729,446,897,953,38,195,679,65,707}));
    }
}
