package com.java.BTrees;

public class LevelOrderTraversalUsingRecursion {

    static int findHeightOfBTree(Node node){
        if(node == null) return -1;
        return Math.max(findHeightOfBTree(node.left), findHeightOfBTree(node.right) +1);
    }

    static void doLevelOrderTraversal(Node node){
        if(node == null) return;

        int height = findHeightOfBTree(node);
        int level = height + 1;

        for(int i = 1; i <=level; i++){
                printElementsAtLevelOrder(node, i);
                System.out.println();
        }
    }

    private static void printElementsAtLevelOrder(Node node, int level){
        if(node == null) return;

        if(level == 1){
            System.out.print(node.data + " ");
            return;
        }

        printElementsAtLevelOrder(node.left, level -1);
        printElementsAtLevelOrder(node.right, level -1);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);
        doLevelOrderTraversal(root);
    }
}
