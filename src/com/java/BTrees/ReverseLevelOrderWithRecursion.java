package com.java.BTrees;

public class ReverseLevelOrderWithRecursion {

    static int doFindHeight(Node node){
        //base condition//
        if(node == null) return -1;

        return Math.max(doFindHeight(node.left), doFindHeight(node.right)) +1;
    }

    static void reverseLevelOrder(Node node){
        if(node == null) return;

        int heightOfTree = doFindHeight(node);
        int level = heightOfTree + 1;

        for(int i = level; i >= 1; i--){
            printReverseLevelOrder(node, i);
            System.out.println();
        }
    }

    static void printReverseLevelOrder(Node node, int level){
        //base condition//
        if(node == null) return;

        if(level == 1){
            System.out.print(node.data + " ");
            return;
        }
        printReverseLevelOrder(node.left, level - 1);
        printReverseLevelOrder(node.right, level - 1);
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

        reverseLevelOrder(root);
    }
}
