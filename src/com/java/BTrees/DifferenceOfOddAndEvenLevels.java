package com.java.BTrees;

public class DifferenceOfOddAndEvenLevels {
    static int findDifferenceOfOddAndEvenLevels(Node node){
        //base condition//
        if(node == null) return 0;

        return node.data - findDifferenceOfOddAndEvenLevels(node.left) - findDifferenceOfOddAndEvenLevels(node.right);
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

        int diffOfOddAndEven = findDifferenceOfOddAndEvenLevels(root);
        System.out.println("Difference :: "+diffOfOddAndEven);
    }
}
