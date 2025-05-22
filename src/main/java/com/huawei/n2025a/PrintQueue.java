package com.huawei.n2025a;

import java.util.*;

/**
 * @author liuyuze
 * @date 2025/3/29 21:47
 */
public class PrintQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer,List<Queue<Integer>>> queueMap = new HashMap<>();
        int index = 0;
        for (int i = 0; i <= n; i++) {
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            String opt = split[0];
            if ("IN".equals(opt)) {
                int pId = Integer.parseInt(split[1]);
                int priority = Integer.parseInt(split[2]);
                List<Queue<Integer>> list = queueMap.get(pId - 1);
                if (list == null || list.size() != 10) {
                    list = createPrintQueue();
                }
                Queue<Integer> queue = list.get(priority - 1);
                queue.offer(++index);
                queueMap.put(pId - 1,list);
            } else if ("OUT".equals(opt)) {
                int pId = Integer.parseInt(split[1]);
                List<Queue<Integer>> queueList = queueMap.get(pId - 1);
                if (queueList == null || queueList.isEmpty()) {
                    System.out.println("NULL");
                    continue;
                }
                boolean isPrint = false;
                for (int j = queueList.size() - 1; j >= 0; j--) {
                    Queue<Integer> queue = queueList.get(j);
                    if (queue != null && !queue.isEmpty()) {
                        isPrint = true;
                        System.out.println(queue.poll());
                        break;
                    }
                }
                if (!isPrint) {
                    System.out.println("NULL");
                }
            }
        }
    }

    private static List<Queue<Integer>> createPrintQueue() {
        List<Queue<Integer>> queue = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            queue.add(new LinkedList<>());
        }
        return queue;
    }
}
