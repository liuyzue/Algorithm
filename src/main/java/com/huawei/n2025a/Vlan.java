package com.huawei.n2025a;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuyuze
 * @date 2025/3/30 21:03
 */
public class Vlan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String vlanStr = scanner.nextLine();
        int need = scanner.nextInt();
        String[] split = vlanStr.split(",");
        List<Integer> vlanList = new ArrayList<>();
        for (String s : split) {
            if (s.contains("-")){
                String[] split1 = s.split("-");
                int start = Integer.parseInt(split1[0]);
                int end = Integer.parseInt(split1[1]);
                for (int i = start; i <= end; i++) {
                    if (i == need){
                        continue;
                    }
                    vlanList.add(i);
                }
            } else {
                int i = Integer.parseInt(s);
                if (i == need) {
                    continue;
                }
                vlanList.add(i);
            }
        }
        vlanList = vlanList.stream().sorted().collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        sb.append(vlanList.get(0));
        boolean isCon = false;
        for (int i = 1; i < vlanList.size(); i++) {
            Integer id = vlanList.get(i);
            Integer lastId = vlanList.get(i - 1);
            if (id - lastId == 1) {
                isCon = true;
                if (i == vlanList.size() - 1) {
                    sb.append("-").append(id);
                    break;
                } else {
                    continue;
                }
            }
            if (isCon) {
                sb.append("-").append(lastId).append(",").append(id);
                isCon = false;
            } else {
                sb.append(",").append(id);
            }

        }
        System.out.println(sb);
    }
}
