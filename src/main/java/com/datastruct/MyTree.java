package com.datastruct;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com.datastruct
 * @date:2020/7/7
 * @time:16:15
 */
public class MyTree {

    public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode<Integer>(1,null,null);
        TreeNode<Integer> node1 = new TreeNode<Integer>(2,null,null);
        TreeNode<Integer> node2 = new TreeNode<Integer>(3,null,null);
        TreeNode<Integer> node3 = new TreeNode<Integer>(4,null,null);
        TreeNode<Integer> node4 = new TreeNode<Integer>(5,null,null);
        root.setLeft(node1);root.setRight(node2);
        node1.setLeft(node3);node1.setRight(node4);

        level(root);

    }

    public static void print(TreeNode node){
        System.out.println(node.getValue());
    }

    /**
     * 层级遍历
     */
    public static void level(TreeNode node){
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (node == null){
            return;
        }
        queue.add(node);
        while(!queue.isEmpty()){
            TreeNode tmpNode = queue.poll();
            System.out.println(tmpNode.getValue());
            if (tmpNode.getLeft()!=null) {
                queue.add(tmpNode.getLeft());
            }
            if (tmpNode.getRight()!=null) {
                queue.add(tmpNode.getRight());
            }
        }
    }


    /**
     * 先序遍历--递归
     * @param node
     */
    public static void pro(TreeNode<Integer> node){
        print(node);
        if (node.getLeft()!=null){
            pro(node.getLeft());
        }
        if (node.getRight()!=null){
            pro(node.getRight());
        }
    }
    /**
     * 先序遍历--非递归
     * @param node
     */
    public static void pro1(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        if (node==null){
            return;
        }
        TreeNode tmpNode = node;
        stack.push(node);
        while (!stack.empty()){
            System.out.println(tmpNode.getValue());
        }
    }

    /**
     * 中序遍历--递归
     * @param node
     */
    public static void in(TreeNode node){
        if (node.getLeft()!=null){
            in(node.getLeft());
        }
        print(node);
        if (node.getRight()!=null){
            in(node.getRight());
        }
    }

    /**
     * 后序遍历--递归
     * @param node
     */
    public static void post(TreeNode node){
        if (node.getLeft()!=null){
            post(node.getLeft());
        }
        if (node.getRight()!=null){
            post(node.getRight());
        }
        print(node);

    }


}

