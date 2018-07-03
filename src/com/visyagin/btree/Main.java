package com.visyagin.btree;

import com.visyagin.btree.entity.BinaryTree;
import com.visyagin.btree.entity.Node;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BinaryTree bt = stubbedTree();

        List<Integer> pathToTheNearestLeaf = bt.printPathToClosestLeaf();
        System.out.println(String.format("Path from the nearest leaf to the root node is %s", pathToTheNearestLeaf));
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
