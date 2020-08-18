package com.datastruct;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com.datastruct
 * @date:2020/7/7
 * @time:17:21
 */
class TreeNode<T>{
    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T value){
        this.value =value;
    }

    public TreeNode(T value,TreeNode<T> left,TreeNode<T> right){
        super();
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public static void print(TreeNode node){
        System.out.println(node.getValue());
    }



}
