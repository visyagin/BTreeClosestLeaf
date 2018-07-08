package com.visyagin.btree;

import com.visyagin.btree.entity.BinaryTree;
import com.visyagin.btree.entity.Node;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BinaryTree bt = stubbedTree();

        List<Integer> pathToClosestLeaf = bt.pathToClosestLeaf();
        System.out.println(String.format("Path from the nearest leaf to the root node is %s", pathToClosestLeaf));

        String pathFoundByLevelTraversal = bt.pathToClosestLeafWithLevelOrderTraverse();
        System.out.println(String.format("Path from the nearest leaf to the root node is %s", pathFoundByLevelTraversal));

        System.out.println("Tree size: " + bt.size());
        System.out.println("Max value: " + bt.maxValue());
        System.out.println("Tree height: " + bt.height());
    }

    private static BinaryTree stubbedTree() {
        return new BinaryTree(new Node(0,
            new Node(1,
                    new Node(3,
                            new Node(6, null, null),
                            null),
                    null),
            new Node(2,
                    new Node(4,
                            null,
                            null),
                    new Node(5,
                            null,
                            new Node(7, null, null)))));
    }

}
