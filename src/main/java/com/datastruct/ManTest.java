package com.datastruct;

import com.leecode.JosephusRing;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author create by lyz
 * @version: v1.0
 * @description: com.datastruct
 * @date:2020/7/22
 * @time:22:09
 */
public class ManTest {

    @Test
    public void testLinkList(){
        MyLinkList<Integer> myLinkList = new MyLinkList<>();

        myLinkList.insertHead(7);
        myLinkList.insertHead(8);
        myLinkList.insertHead(9);
        myLinkList.insertHead(10);
        myLinkList.insertTail(1);
        myLinkList.insertTail(2);
        myLinkList.insertTail(13);
        myLinkList.insertTail(4);

       // myLinkList.deleteHead();
       // myLinkList.deleteTail();
        myLinkList.deleteNth(1); //list : 10 9 8 7 1 2 13 4

        myLinkList.travel();
    }

    @Test
    public void Josephus(){
        JosephusRing jr = new JosephusRing();
        jr.josephus(10,2);
    }

    @Test
    public void testArrayList(){
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.addTail(1);
        myArrayList.addTail(2);
        myArrayList.addTail(3);
        myArrayList.addTail(4);
        myArrayList.addTail(5);
        myArrayList.addTail(6);
        myArrayList.addTail(7);
        myArrayList.addTail(8);
        myArrayList.addTail(9);
        myArrayList.addTail(10);
        myArrayList.addTail(11);
        //myArrayList.addNth(2,12);
        //myArrayList.deleteTail();
        myArrayList.deleteNth(11);

        System.out.println("size : "+myArrayList.size);
        System.out.println("values.length : "+myArrayList.values.length);
        myArrayList.travel();
        System.out.println();
        System.out.println(myArrayList.find(99));
    }

    @Test
    public void testStack(){
        MyLinkStack<Integer> stack = new MyLinkStack<>();
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(3);
        stack.travel();
    }

    @Test
    public void testQueue(){
        MyArrayQueue queue = new MyArrayQueue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.deQueue();
        queue.enQueue(3);
        queue.travel();
    }

    @Test
    public void testDequeue(){
        MyDequeue dequeue = new MyDequeue();
        dequeue.push(1);
        dequeue.push(2);
        dequeue.push(3);
        dequeue.push(4);
        dequeue.push(5);
        dequeue.push(6);
        System.out.print(dequeue.pop() + " " + dequeue.pop() + " " +dequeue.pop() + " ");
        System.out.println();
        dequeue.push(1);
        dequeue.push(2);
        /*dequeue.push(3);
        dequeue.push(4);
        dequeue.push(5);
        dequeue.push(6);
        dequeue.push(7);
        dequeue.push(8);
        dequeue.push(9);
        dequeue.push(10);*/

        dequeue.travel();
    }

    @Test
    public void test(){
        Long num = 0L;
        List<Integer> testList = new ArrayList<>();
        for (int i = 0; i < 10000; i++){
            testList.add(i);
        }
        Date start = new Date();
        for (int i = 0; i < testList.size() ; i++){
            num += testList.get(i);
        }
        /*for (Integer e : testList){
            num += e;
        }*/
        Date end = new Date();

        System.out.println(end.getTime() - start.getTime());
    }

}
