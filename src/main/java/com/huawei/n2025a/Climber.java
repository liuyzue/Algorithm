package com.huawei.n2025a;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/28 23:11
 */
public class Climber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        int[] mountains = new int[split.length];
        for (int i = 0; i < mountains.length; i++) {
            mountains[i] = Integer.parseInt(split[i]);
        }
        int blood = scanner.nextInt();
        List<Integer> peekList = new ArrayList<>();

        for (int i = 0; i < mountains.length; i++) {
            if (i == 0) {
                if (mountains[i] > mountains[i + 1]) {
                    peekList.add(i);
                }
            } else if (i == mountains.length - 1){
                if (mountains[i] > mountains[i - 1]) {
                    peekList.add(i);
                }
            } else if ((mountains[i] > mountains[i - 1] && mountains[i] > mountains[i + 1])) {
                peekList.add(i);
            }
        }

        int result = 0;
        for (Integer peek : peekList) {
            boolean isOk = false;
            //从左边上下山
            if (peek > 0) {
                int cost = 0;
                int next = peek;
                while (next > 0 && mountains[next] != 0) {
                    cost += (mountains[next] - mountains[next - 1]) * 3;
                    next--;
                    if (mountains[next] == 0) {
                        if (cost <= blood) {
                            isOk = true;
                            result++;
                            break;
                        }
                    }
                }
            }
            //如果已经可以从左边下山，就不再考虑走右边的情况
            if (isOk) {
                continue;
            }
            //如果左边不可以，再计算下右边需要的体力
            if (peek < mountains.length - 1) {
                int cost = 0;
                int next = peek;
                while (next < mountains.length - 1 && mountains[next] != 0) {
                    cost += (mountains[next] - mountains[next + 1]) * 3;
                    next++;
                    if (mountains[next] == 0 && cost <= blood) {
                        result++;
                        break;
                    }
                }

            }
        }
        System.out.println(result);
    }
}
