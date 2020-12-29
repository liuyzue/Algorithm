package com.datastruct;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com.datastruct.impl   循环链表
 * @date:2020/7/10
 * @time:23:35
 */
public class MyLinkList<T> {
    public LinkNode<T> head;
    public int size;

    public MyLinkList() {
    }

    public void insertHead(T node) {
        //创建新节点
        LinkNode<T> newNode = new LinkNode<>(node, null);
        //如果链表为空直接将赋值给头节点
        if (size == 0) {
            head = newNode;
            newNode.next = head;
        }
        //如果不为空
        if (size > 0) {
            //先找到最后一个节点
            LinkNode<T> temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            //将之前的head赋值给新节点的next
            newNode.next = head;
            //新节点成为新的head节点
            head = newNode;
            //最后一个节点的next指向新的head节点
            temp.next = head;
        }
        size++;
    }

    public void insertTail(T node) {
        //链表为空直接加在头节点上
        if (size == 0) {
            insertHead(node);
            return;
        }
        //链表不为空则找到最后一个节点
        LinkNode<T> temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        //将最后一个节点的next指向新节点，新节点的next指向head节点
        temp.next = new LinkNode<T>(node, head);
        size++;
    }

    public void deleteHead() {
        //链表只有一个节点，直接将头节点赋值为null
        if (size == 1) {
            head = null;
            size--;
        }
        //链表里有多个节点
        if (size > 1) {
            //找到最后一个节点
            LinkNode<T> temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            //头节点后移
            head = head.next;
            //最后一个节点的next指向新的head节点
            temp.next = head;

            size--;
        }
    }

    public T deleteTail() {
        T result = null;
        if (size == 0){
            return null;
        }
        //只有一个节点，置为null
        if (size == 1) {
            result = head.value;
            head = null;
            size--;
        }
        //至少有两个节点
        if (size > 1) {
            //找到倒数第二个节点
            LinkNode<T> temp = head;
            while (temp.next.next != head) {
                temp = temp.next;
            }
            //倒数第二个节点的next指向head节点
            result = temp.next.value;
            temp.next = head;
            size--;
        }

        return result;
    }

    public void deleteNth(T value) {
        //链表为空直接返回
        if (size == 0) {
            return;
        }
        //头节点即为要删除的节点，直接删除头
        if (value == head.value) {
            deleteHead();
            return;
        }
        //isExists记录链表中是否有该节点
        boolean isExists = false;
        LinkNode<T> temp = head;
        while (temp.next != head) {
            //遍历链表，找到 下一个节点的value等于目标值的 节点
            if (temp.next.value == value) {
                isExists = true;
                break;
            }
            temp = temp.next;
        }
        if (isExists){
            temp.next = temp.next.next;
            size--;
        }

    }

    public void travel() {
        LinkNode<T> tmp = head;
        System.out.print("list : ");
        for (int i = 0; i < size; i++) {
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
        }
    }
    public class LinkNode<T> {
        public T value;
        public LinkNode<T> next;

        public LinkNode(T value, LinkNode<T> next) {
            this.value = value;
            this.next = next;
        }

    }

}

