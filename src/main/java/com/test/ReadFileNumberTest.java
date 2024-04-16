package com.test;

import java.io.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ReadFileNumberTest {
    public static void main(String[] args) {
        /*try {
            FileInputStream fis = new FileInputStream("D:\\numbers.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String s = "";
            while ((s = br.readLine()) != null ) {
                String s1 = s.replaceAll("[^0-9]+", " ");
                System.out.println(s1);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        Random random = new Random();
        Set<Long> set  = new HashSet<>();
        while (set.size() < 4) {
            long i = random.nextInt(100000000);
            System.out.println(i);
            if (i >= 10000000) {
                set.add(i);
            }
        }


    }
}
