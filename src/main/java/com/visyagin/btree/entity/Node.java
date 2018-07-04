package com.visyagin.btree.entity;

/**
 * Node entity is a part of {@link BinaryTree}
 */
public class Node {

    private int value;
    private Node left;
    private Node right;

    public Node(int value, Node leftChild, Node rightChild) {
        this.value = value;
        this.left = leftChild;
        this.right = rightChild;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
