package com.datastruct;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com.datastruct
 * @date:2020/7/24
 * @time:21:10
 */
public class MyDequeue {
    private final static int DEFAULT_SIZE = 5 ;
    private Object[] dequeue;
    private int size;
    private int head;
    private int tail;
    public MyDequeue(){
        dequeue = new Object[DEFAULT_SIZE];
        head = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 判断如果队列放满了就双倍扩容
     * @param minCapacity
     */
    public void fullAndExtend(int minCapacity){
        if (minCapacity - dequeue.length > 0){
            System.out.println("====== do extend ======");
            int h = head;
            int len = dequeue.length;
            int r = len - h;
            int newCapacity =  dequeue.length << 1;
            //如果扩容超过了数组的最大容量则抛出异常
            if (newCapacity < 0){
                throw new IllegalStateException("deque is too large!");
            }
            Object[] newDeque = new Object[newCapacity];
            //因为是循环队列所以需要分两步往新队列里转移
            //转移 head --- length 部分
            System.arraycopy(dequeue,h,newDeque,0,r);
            //转移 0 ---head 部分
            System.arraycopy(dequeue,0,newDeque,r,h);
            //给新的队列赋值
            dequeue = newDeque;
            head = 0;
            tail = len;
        }
    }

    public void push(Object value){
        fullAndExtend(size + 1);
        dequeue[tail%dequeue.length] = value;
        tail++;
        size++;
    }

    public Object pop(){
        if (size == 0){
            return null;
        }
        Object value = dequeue[head];
        dequeue[head%dequeue.length] = null;
        head++;
        size--;
        return value;
    }


    public void travel(){
        System.out.print("travel : ");
        for (int i = head;i < head+size;i++){
            System.out.print(dequeue[i%dequeue.length]+" ");
        }
        System.out.println();
        System.out.println("head : "+head);
        System.out.println("tail : "+tail);
        System.out.println("size : "+size);
        System.out.println("deque.length : "+dequeue.length);
    }
}
