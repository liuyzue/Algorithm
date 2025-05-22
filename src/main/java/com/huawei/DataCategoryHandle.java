package com.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author liuyuze
 * @date 2025/3/25 13:43
 */
public class DataCategoryHandle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int in = scanner.nextInt();
        List<String> iList = new ArrayList<>();
        for (int i = 0; i < in; i++) {
            iList.add(scanner.next());
        }
        int rn = scanner.nextInt();
        List<Integer> rList = new ArrayList<>();
        for (int i = 0; i < rn; i++) {
            rList.add(scanner.nextInt());
        }

        rList = rList.stream().distinct().sorted().collect(Collectors.toList());
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rList.size(); i++) {
            String r = String.valueOf(rList.get(i));
            List<Integer> idList = new ArrayList<>();
            for (int j = 0; j < iList.size(); j++) {
                if (iList.get(j).contains(r)) {
                    idList.add(j);
                }
            }
            result.add(idList);
        }

        int total = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            if (!list.isEmpty()) {
                total = total + (list.size() * 2) + 2;
                sb.append(" ").append(rList.get(i)).append(" ").append(list.size());
                for (int j = 0; j < list.size(); j++) {
                    Integer index = list.get(j);
                    sb.append(" ").append(index).append(" ").append(iList.get(index));
                }
            }
        }
        if (sb.length() > 0) {
            sb.insert(0, total);
            System.out.println(sb);
        }
    }
}
