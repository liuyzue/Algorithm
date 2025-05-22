package com.huawei.n2025a;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuyuze
 * @date 2025/3/30 15:55
 */
public class MessageQueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        Map<Integer,Integer> messageMap = new HashMap<>();
        int index = 0;
        int maxTime = 0;
        while (index < split.length) {
            int key = Integer.parseInt(split[index++]);
            int value = Integer.parseInt(split[index++]);
            messageMap.put(key, value);
            maxTime = Math.max(key,maxTime);
        }
        String s1 = scanner.nextLine();
        String[] split1 = s1.split(" ");
        List<int[]> consumerList = new ArrayList<>();
        index = 0;
        List<List<Integer>> consumeRecord = new ArrayList<>();
        while (index < split1.length) {
            consumerList.add(new int[]{Integer.parseInt(split1[index++]),Integer.parseInt(split1[index++])});
            consumeRecord.add(new ArrayList<>());
        }

        for (int i = 1; i <= maxTime; i++) {
            Integer message = messageMap.get(i);
            if (message == null || message == 0){
                continue;
            }
            for (int j = consumerList.size() - 1; j >= 0; j--) {
                int[] consumer = consumerList.get(j);
                if (i >= consumer[0] && i < consumer[1]){
                    List<Integer> list = consumeRecord.get(j);
                    list.add(message);
                    break;
                }
            }
        }

        for (List<Integer> list : consumeRecord) {
            if (list.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            }
        }
    }
}
