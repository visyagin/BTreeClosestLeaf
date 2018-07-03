package com.visyagin.btree.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BinaryTree {

    private Node root;
    private List<Integer> resultPath = new ArrayList<>();

    public BinaryTree(Node node) {
        this.root = node;
    }

    /**
     * See {@link #printPathToClosestLeaf()}
     * @return List<Integer> that contains a path from the nearest leaf to the root node
     */
    public List<Integer> printPathToClosestLeaf() {
        printPathToClosestLeaf(root, new ArrayList<>());
        Collections.reverse(resultPath);
        return resultPath;
    }

    /**
     * Recursively searches the nearest leaf to the root node
     * @param node - see {@link Node}
     * @param newPath - variable for storing temporal path
     */
    private void printPathToClosestLeaf(Node node, List<Integer> newPath) {
        List<Integer> localPath = new ArrayList<>(newPath);
        localPath.add(node.getValue());

        if (!Objects.isNull(node.getLeft())) {
            printPathToClosestLeaf(node.getLeft(), localPath);
        }

        if (!Objects.isNull(node.getRight())) {
            printPathToClosestLeaf(node.getRight(), localPath);
        }

        boolean isLeaf = Objects.isNull(node.getLeft()) && Objects.isNull(node.getRight());
        if (isLeaf && (resultPath.isEmpty() || resultPath.size() > localPath.size())) {
            resultPath = localPath;
        }
    }

}
