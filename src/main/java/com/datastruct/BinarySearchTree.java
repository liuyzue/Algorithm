package com.datastruct;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com.datastruct
 * @date:2020/7/7
 * @time:17:16
 */
public class BinarySearchTree {

    public static void addNode(TreeNode<Integer> root , TreeNode<Integer> node){
        if (root == null){
            root = node ;
        }
        if (node.getValue() < root.getValue()){
            if (root.getLeft()==null){
                root.setLeft(node);
            } else {
                addNode(root.getLeft(),node);
            }
        }
        if (node.getValue() > root.getValue()){
            if (root.getRight() == null){
                root.setRight(node);
            } else {
                addNode(root.getRight(),node);
            }
        }
    }

    /**
     * 中序遍历
     * @param node
     */
    public static void in(TreeNode node){
        if (node.getLeft()!=null){
            in(node.getLeft());
        }
        System.out.println(node.getValue());
        if (node.getRight()!=null){
            in(node.getRight());
        }
    }

}
