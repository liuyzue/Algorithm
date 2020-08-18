package com.datastruct;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com.datastruct
 * @date:2020/7/22
 * @time:18:36
 */
public class MyLinkStack<T> {

    private MyLinkList<T> stack ;
    public MyLinkStack(){
        this.stack = new MyLinkList<>();
    }

    public void push(T value){
        stack.insertTail(value);
    }
    public T pop(){
        return stack.deleteTail();
    }
    public int size(){
        return stack.size;
    }
    public void travel(){
        stack.travel();
    }

}
