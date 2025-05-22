package com.huawei.n2025a;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuyuze
 * @date 2025/3/29 23:16
 */
public class LongestShunZi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] hand = s.split("-");
        String s1 = scanner.nextLine();
        String[] used = s1.split("-");

        Map<Integer,Integer> paperMap = new HashMap<>();
        Map<String,Integer> transMap = new HashMap<>();
        Map<Integer,String> decodeMap = new HashMap<>();
        transMap.put("3",1);
        transMap.put("4",2);
        transMap.put("5",3);
        transMap.put("6",4);
        transMap.put("7",5);
        transMap.put("8",6);
        transMap.put("9",7);
        transMap.put("10",8);
        transMap.put("J",9);
        transMap.put("Q",10);
        transMap.put("K",11);
        transMap.put("A",12);
        transMap.put("2",13);
        transMap.put("B",14);
        transMap.put("C",15);
        paperMap.put(1,4);
        paperMap.put(2,4);
        paperMap.put(3,4);
        paperMap.put(4,4);
        paperMap.put(5,4);
        paperMap.put(6,4);
        paperMap.put(7,4);
        paperMap.put(8,4);
        paperMap.put(9,4);
        paperMap.put(10,4);
        paperMap.put(11,4);
        paperMap.put(12,4);
        paperMap.put(13,4);
        paperMap.put(14,1);
        paperMap.put(15,1);
        decodeMap.put(1,"3");
        decodeMap.put(2,"4");
        decodeMap.put(3,"5");
        decodeMap.put(4,"6");
        decodeMap.put(5,"7");
        decodeMap.put(6,"8");
        decodeMap.put(7,"9");
        decodeMap.put(8,"10");
        decodeMap.put(9,"J");
        decodeMap.put(10,"Q");
        decodeMap.put(11,"K");
        decodeMap.put(12,"A");
        decodeMap.put(13,"2");
        decodeMap.put(14,"B");
        decodeMap.put(15,"C");

        for (String string : used) {
            paperMap.compute(transMap.get(string), (k, i) -> i - 1);
        }
        for (String string : hand) {
            paperMap.compute(transMap.get(string), (k, i) -> i - 1);
        }

        int count = 0;
        List<String> result = new ArrayList<>();
        List<String> sb = new ArrayList<>();
        for (int i = 12; i > 0 ; i--) {
            Integer last = paperMap.get(i);
            if (last > 0) {
                count++;
                sb.add(0,decodeMap.get(i));
            }
            if (last <= 0 || i == 1) {
                if (count >=5 && count > result.size()) {
                    result = sb;
                }
                count = 0;
                sb = new ArrayList<>();
            }
        }
        if (result.size() < 5) {
            System.out.println("NO-CHAIN");
        } else {
            System.out.println(result.stream().collect(Collectors.joining("-")));
        }

    }
}
