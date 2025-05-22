package com.huawei;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author liuyuze
 * @date 2025/3/26 6:17
 */
public class _0or1 {
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        // int n = scanner.nextInt();
        // String str = scanner.next();
        // char[] chars = str.toCharArray();

        // 使用带缓冲的快速IO
        BufferedInputStream bis = new BufferedInputStream(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(bis), 1<<20);
        // 读取输入并转换为字符数组
        int n = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().trim().toCharArray();
        List<int[]> zeroList = new ArrayList<>();

        int begin = -1;
        int end = 0;
        boolean in = false;
        for (int i = 0; i < chars.length; i++) {
           if (chars[i] == '0' && !in) {
               in = true;
               begin = i;
           }
           if ((chars[i] == '1' || i == chars.length - 1) && in) {
               if (i == chars.length - 1) {
                   end = i;
               } else {
                   end = i - 1;
               }
               zeroList.add(new int[]{begin,end});
               in = false;
           }
        }
        /*int q = scanner.nextInt();
        int[][] lr = new int[q][2];
        for (int i = 0; i < q; i++) {
            lr[i][0] = scanner.nextInt();
            lr[i][1] = scanner.nextInt();
        }
         for (int[] ints : lr) {
            int l = ints[0] - 1;
            int r = ints[1] - 1;
            int length = r - l + 1;
            int total = length * (length + 1) / 2;
            for (int[] zeros : zeroList) {
                int zeroL = zeros[0];
                int zeroR = zeros[1];
                int zeroNum = 0;
                if (l >= zeroL && l <= zeroR && r >= zeroR) {
                    zeroNum = zeroR - l + 1;
                } else if (l <= zeroL && r >= zeroR) {
                    zeroNum = zeroR - zeroL + 1;
                } else if (zeroL >= l && zeroL <= r && zeroR >= r) {
                    zeroNum = r - zeroL + 1;
                } else if (zeroL <= l && zeroR >= r) {
                    zeroNum = r - l + 1;
                }
                total -= zeroNum * (zeroNum + 1) / 2;
            }
            System.out.println(total);
        }*/
        // 使用StringBuilder加速输出
        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;  // 转换为0-based
            int r = Integer.parseInt(st.nextToken()) - 1;
            long len = r - l + 1;
            long total = len * (len + 1) >> 1;
            int left = 0;
            int right = zeroList.size() - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (zeroList.get(mid)[1] >= l) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            for (int i = left; i < zeroList.size(); i++) {
                int[] zeros = zeroList.get(i);
                int zeroL = zeros[0];
                int zeroR = zeros[1];
                long zeroNum = 0;
                if (l >= zeroL && l <= zeroR && r >= zeroR) {
                    zeroNum = zeroR - l + 1;
                } else if (l <= zeroL && r >= zeroR) {
                    zeroNum = zeroR - zeroL + 1;
                } else if (zeroL >= l && zeroL <= r && zeroR >= r) {
                    zeroNum = r - zeroL + 1;
                } else if (zeroL <= l && zeroR >= r) {
                    zeroNum = r - l + 1;
                }
                total -= zeroNum * (zeroNum + 1) / 2;
            }
            sb.append(total).append('\n');
        }
        System.out.print(sb);
    }
}
