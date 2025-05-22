package com.huawei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuyuze
 * @date 2025/3/12 11:27
 */
public class Shunzi {

    public static void shunzi() {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> map = new HashMap<>();
        map.put("3",0);
        map.put("4",1);
        map.put("5",2);
        map.put("6",3);
        map.put("7",4);
        map.put("8",5);
        map.put("9",6);
        map.put("10",7);
        map.put("J",8);
        map.put("Q",9);
        map.put("K",10);
        map.put("A",11);
        map.put("2",12);
        Map<Integer,String> deMap = new HashMap<>();
        deMap.put(0,"3");
        deMap.put(1,"4");
        deMap.put(2,"5");
        deMap.put(3,"6");
        deMap.put(4,"7");
        deMap.put(5,"8");
        deMap.put(6,"9");
        deMap.put(7,"10");
        deMap.put(8,"J");
        deMap.put(9,"Q");
        deMap.put(10,"K");
        deMap.put(11,"A");
        deMap.put(12,"2");

        Set<Integer> paperSet = new HashSet<>();
        for (int i = 0; i < 13; i++) {
            String next = scanner.next();
            paperSet.add(map.get(next));
        }
        List<Integer> paperList = paperSet.stream().sorted().collect(Collectors.toList());
        int head = 0;
        int rear = 1;
        int count = 0;
        while (head < 9) {
            if (rear < paperList.size() && paperList.get(rear) < 12 && paperList.get(rear) - paperList.get(rear - 1) == 1) {
                rear++;
            } else {
                if (rear - head > 4) {
                    count++;
                    for (int i = head; i < rear; i++) {
                        System.out.print(deMap.get(paperList.get(i)) + " ");
                    }
                    System.out.println();
                }
                head = rear;
                rear = head + 1;
            }
        }
        if (count == 0) {
            System.out.println("No");
        }
    }

    public static void shunzi1() {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> map = new HashMap<>();
        map.put("3",0);
        map.put("4",1);
        map.put("5",2);
        map.put("6",3);
        map.put("7",4);
        map.put("8",5);
        map.put("9",6);
        map.put("10",7);
        map.put("J",8);
        map.put("Q",9);
        map.put("K",10);
        map.put("A",11);
        map.put("2",12);

        String input = scanner.nextLine();
        String[] papers = input.split(" ");
        Arrays.sort(papers, Comparator.comparingInt(map::get));
        int[] state = new int[papers.length];
        Arrays.fill(state, 0);
        List<LinkedList<String>> result = new ArrayList<>();
        for (int i = 0; i < papers.length; i++) {
            if (state[i] == 0) {
                for (LinkedList<String> linkedList : result) {
                    if (map.get(papers[i]) < 12 && map.get(papers[i]) - map.get(linkedList.getLast()) == 1) {
                        linkedList.add(papers[i]);
                        state[i] = 1;
                        break;
                    }
                }
                if (state[i] == 0) {
                    LinkedList<String> newShunzi = new LinkedList<>();
                    newShunzi.add(papers[i]);
                    result.add(newShunzi);
                    state[i] = 1;
                }
            }
        }
        int count = 0;
        for (LinkedList<String> linkedList : result) {
            if (linkedList.size() >= 5) {
                System.out.println(String.join(" ", linkedList));
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No");
        }

    }

    public static void main(String[] args) {
        shunzi1();
    }
}
