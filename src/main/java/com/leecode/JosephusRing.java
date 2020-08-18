package com.leecode;

import com.datastruct.MyLinkList;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com.leecode
 * @date:2020/7/10
 * @time:22:32
 */
public class JosephusRing {

    /**
     * 约瑟夫环   链表解决方案
     */
    public void josephus(int m , int k){
        MyLinkList<Integer> myList = new MyLinkList<>();
        for(int i = 0; i < m ; i++){
            myList.insertTail(i+1);
        }
        MyLinkList<Integer> resultList = new MyLinkList<>();
        int p = 1 ;
        MyLinkList<Integer>.LinkNode<Integer> h = myList.head;
        while (myList.size > 1) {
            if (p == k){
                resultList.insertTail(h.value);
                myList.deleteNth(h.value);
                p=0;
            }
            h = h.next;
            p++;
        }
        System.out.println("last one is : ");
        myList.travel();
        System.out.println();
        System.out.println("out order is : ");
        resultList.travel();
    }

}
