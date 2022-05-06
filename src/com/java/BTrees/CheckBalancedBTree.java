package com.java.BTrees;

public class CheckBalancedBTree {

    static boolean isBalancedTree(Node node){
        return doDFS(node) != -1;
    }

    static int doDFS(Node node){
        //base condition//
        if(node == null) return 0;

        int leftSubTreeHeight = doDFS(node.left);
        int rightSubTreeHeight = doDFS(node.right);

        if(Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1) return -1;

        return Math.max(leftSubTreeHeight, rightSubTreeHeight) +1;

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

        boolean heightOfNode = isBalancedTree(root);
        System.out.println("The tree is height balanced :: "+heightOfNode);
    }
}
