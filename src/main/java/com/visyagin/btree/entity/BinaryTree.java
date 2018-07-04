package com.visyagin.btree.entity;

import java.util.*;

public class BinaryTree {

    private Node root;
    private List<Integer> resultPath = new ArrayList<>();

    public BinaryTree(Node node) {
        this.root = node;
    }

    /**
     * See {@link #pathToClosestLeaf()}
     * @return List<Integer> that contains a path from the nearest leaf to the root node
     */
    public List<Integer> pathToClosestLeaf() {
        pathToClosestLeaf(root, new ArrayList<>());
        Collections.reverse(resultPath);
        return resultPath;
    }

    /**
     * Recursively searches the nearest leaf to the root node
     * @param node - see {@link Node}
     * @param newPath - variable for storing temporal path
     */
    private void pathToClosestLeaf(Node node, List<Integer> newPath) {
        if (!resultPath.isEmpty() && newPath.size() >= resultPath.size()) {
            return;
        }

        List<Integer> localPath = new ArrayList<>(newPath);
        localPath.add(node.getValue());

        if (!Objects.isNull(node.getLeft())) {
            pathToClosestLeaf(node.getLeft(), localPath);
        }

        if (!Objects.isNull(node.getRight())) {
            pathToClosestLeaf(node.getRight(), localPath);
        }

        boolean isLeaf = Objects.isNull(node.getLeft()) && Objects.isNull(node.getRight());
        if (isLeaf && (resultPath.isEmpty() || resultPath.size() > localPath.size())) {
            resultPath = localPath;
        }
    }

    public String pathToClosestLeafWithLevelOrderTraverse() {
        String resultPath = "";

        NodePath nodePath = new NodePath(root, "");
        LinkedList<NodePath> nodesQueue = new LinkedList<>();
        nodesQueue.add(nodePath);

        while(!nodesQueue.isEmpty()) {
            NodePath current = nodesQueue.poll();
            Node currentNode = current.getNode();
            String newChain = current.getPath() + currentNode.getValue();

            boolean isLeaf = Objects.isNull(currentNode.getLeft()) && Objects.isNull(currentNode.getRight());
            if (isLeaf && (resultPath.isEmpty() || newChain.length() < resultPath.length())) {
                resultPath = newChain;
            }

            if (!Objects.isNull(currentNode.getLeft())) {
                nodesQueue.push(new NodePath(currentNode.getLeft(), newChain));
            }

            if (!Objects.isNull(currentNode.getRight())) {
                nodesQueue.push(new NodePath(currentNode.getRight(), newChain));
            }
        }

        return new StringBuilder(resultPath).reverse().toString();
    }

    /**
     * key-value object for building and storing paths for each node in queue
     */
    private class NodePath {
        private Node node;
        private String path;

        public NodePath() {
        }

        public NodePath(Node node, String path) {
            this.node = node;
            this.path = path;
        }

        public Node getNode() {
            return node;
        }

        public void setNode(Node node) {
            this.node = node;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }

}
