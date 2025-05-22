package com.huawei.n2025a;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/30 0:15
 */
public class WorkRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            String[] records = s.split(" ");
            int all = 0;
            int win = 0;
            boolean isOk = true;
            int abs = 0;
            for (int j = 0; j < records.length; j++) {
                String record = records[j];
                if ("absent".equals(record)){
                    abs++;
                    if (abs > 1) {
                        isOk = false;
                        break;
                    }
                }
                if (j > 0 && (("leaveearly".equals(record) || "late".equals(record)) &&
                        ("late".equals(records[j - 1]) || "leaveearly".equals(records[j - 1])))){
                    isOk = false;
                    break;
                }
                if ("late".equals(record) || "leaveearly".equals(record) || "absent".equals(record)) {
                    all++;
                }
                if (win < 7) {
                    win++;
                } else {
                    if (("absent".equals(records[j - 7]) || "late".equals(records[j - 7]) || "leaveearly".equals(records[j - 7])) && all > 0) {
                        all--;
                    }
                }
                if (all > 3) {
                    isOk = false;
                    break;
                }

            }
            System.out.println(isOk);
        }
    }
}
