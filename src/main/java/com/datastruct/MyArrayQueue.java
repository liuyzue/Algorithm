package com.datastruct;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com.datastruct
 * @date:2020/7/24
 * @time:21:01
 */
public class MyArrayQueue {
    private MyArrayList queue;
    public MyArrayQueue(){
        this.queue = new MyArrayList();
    }

    public void enQueue(Object value){
        queue.addTail(value);
    }
    public Object deQueue(){
        return queue.deleteNth(1);
    }
    public void travel(){
        queue.travel();
    }
}
