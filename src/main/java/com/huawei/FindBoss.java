package com.huawei;

import java.util.*;

/**
 * @author liuyuze
 * @date 2025/3/13 9:59
 */
public class FindBoss {

    public static void main(String[] args) {
        FindBoss findBoss = new FindBoss();
        findBoss.findBoss();
    }
    public void findBoss() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Set<Integer> idSet = new HashSet<>();
        Node[] nodes = new Node[num];
        for (int i = 0; i < num; i++) {
            Node node = new Node();
            int id = scanner.nextInt();
            idSet.add(id);
            node.setId(id);
            int bossId = scanner.nextInt();
            node.setBossId(bossId);
            int money = scanner.nextInt();
            node.setMoney(money);
            nodes[i] = node;
        }
        Node boss = new Node();
        //find boss
        for (int i = 0; i < num; i++) {
            if (!idSet.contains(nodes[i].getBossId())) {
                boss.setId(nodes[i].getBossId());
                boss.setChild(findChildNode(boss.id, nodes));
            }
            nodes[i].setChild(findChildNode(nodes[i].getId(), nodes));
        }
        int sum = 0;
        for (Node node : boss.getChild()) {
            sum += sum(node);
        }

        System.out.println(boss.id + " " + sum);
    }

    public int sum(Node node) {
        int sum = 0;
        if (node.getChild() != null) {
            List<Node> child = node.getChild();
            int childMoney = 0;
            for (Node c : child) {
                childMoney += sum(c);
            }
            node.setMoney(node.getMoney() + childMoney);
        }
        sum = (node.getMoney() / 100) * 15;
        return sum;
    }

    public List<Node> findChildNode(int id,Node[] nodes) {
        List<Node> childList = new ArrayList<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].getBossId() == id) {
                childList.add(nodes[i]);
            }
        }
        return childList;
    }

    class Node {
        int id;
        int bossId;
        int money;
        List<Node> child;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getBossId() {
            return bossId;
        }

        public void setBossId(int bossId) {
            this.bossId = bossId;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public List<Node> getChild() {
            return child;
        }

        public void setChild(List<Node> child) {
            this.child = child;
        }
    }
}
