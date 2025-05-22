package com.huawei;

import java.util.*;

/**
 * @author liuyuze
 * @date 2025/3/25 11:26
 */
public class ErrorRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> queue = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.equals("00")) {
                break;
            }
            String[] split = s.split(" ");
            int lastIndex = split[0].lastIndexOf("\\");
            int start = split[0].length() - lastIndex > 16 ? split[0].length() - 16 : lastIndex + 1;
            String file = s.substring(start, split[0].length());
            String message = file + " " + split[1];
            Integer num = map.get(message);
            if (num == null) {
                queue.add(message);
                num = 0;
            }
            map.put(message, num + 1);
        }
        int start = Math.max(queue.size() - 8, 0);
        for (int i = start; i < queue.size(); i++) {
            String s = queue.get(i);
            System.out.println(s + " " + map.get(s));
        }
    }
}
