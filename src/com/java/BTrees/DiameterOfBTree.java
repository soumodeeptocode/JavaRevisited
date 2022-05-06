package com.java.BTrees;

public class DiameterOfBTree {

    static int returnDiameter(Node node){
        int diameter[] = new int[1];
        findDiameter(node, diameter);
        return diameter[0];
    }

    static int findDiameter(Node node, int[] diameter){
        //base condition//
        if(node == null) return 0;

        int leftSubTreeHeight = findDiameter(node.left, diameter);
        int rightSubTreeHeight = findDiameter(node.right, diameter);

        diameter[0] = Math.max(diameter[0], leftSubTreeHeight  + rightSubTreeHeight);

        return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);
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

        int diameter = returnDiameter(root.right);
        System.out.println("Diameter of given tree :: "+diameter);
    }
}
