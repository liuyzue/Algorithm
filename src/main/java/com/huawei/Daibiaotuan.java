package com.huawei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuyuze
 * @date 2025/3/24 13:35
 */
public class Daibiaotuan {

   /* public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        int[] persons = new int[split.length];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(persons);
        int sites = scanner.nextInt();
        boolean[] visited = new boolean[persons.length];
        Arrays.fill(visited, false);
        Set<String> set = new HashSet<>();
        dfs(persons, sites, new ArrayList<>(), set,visited);

        System.out.println(set.size());
    }

    private static void dfs(int[] persons, int last, ArrayList<Integer> result, Set<String> set, boolean[] visited) {
        if (last == 0) {
            String sorted = result.stream().sorted().map(String::valueOf).collect(Collectors.joining(","));
            set.add(sorted);
            return;
        } else if (last < 0) {
            return;
        }
        for (int i = 0; i < persons.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                last -= persons[i];
                result.add(i);
                dfs(persons,last,result,set,visited);
                last += persons[i];
                visited[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }
*/
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       String s = scanner.nextLine();
       String[] split = s.split(",");
       int[] persons = new int[split.length];
       for (int i = 0; i < persons.length; i++) {
           persons[i] = Integer.parseInt(split[i]);
       }
       Arrays.sort(persons);
       int sites = scanner.nextInt();
       int[] dp = new int[sites + 1];
       dp[0] = 1;
       for (int person : persons) {
           for (int i = sites - person; i >= 0 ; i--) {
                dp[i + person] += dp[i];
           }
       }
       System.out.println(dp[sites]);
   }

}
