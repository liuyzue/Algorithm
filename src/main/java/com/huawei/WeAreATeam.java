package com.huawei;

import java.util.*;

/**
 * @author liuyuze
 * @date 2025/3/24 16:31
 */
public class WeAreATeam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if (n < 0 || n >= 100000 || m < 0 || m >= 100000) {
            System.out.println("Null");
            return;
        }
        List<int[]> message = new ArrayList<>();
        Map<Integer,Set<Integer>> relation = new HashMap();
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (c == 0) {
                Set<Integer> setA = relation.get(a);
                Set<Integer> setB = relation.get(b);
                if (setA == null) {
                    setA = new HashSet<>();
                }
                setA.add(a);
                if (setB == null) {
                    setB = new HashSet<>();
                }
                setB.add(b);
                setA.addAll(setB);
                for (Integer item : setA) {
                    relation.put(item, setA);
                }
            } else {
                message.add(new int[]{a, b, c});
            }
        }
        for (int[] ints : message) {
            int a = ints[0];
            int b = ints[1];
            int c = ints[2];
            if (c == 1) {
                boolean flag = false;
                Set<Integer> set = relation.get(a);

                if (set.contains(b)) {
                    System.out.println("We are a team");
                } else {
                    System.out.println("We are not a team");
                }
            }
            if (a < 1 || a > n || b < 1 || b > n || c != 1) {
                System.out.println("da pian zi");
            }
        }
    }
}
