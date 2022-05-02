package com.java.BTrees;

public class TotalNumberOfLeafNodes {

    static int findNumberOfLeafNodes(Node node){
        //base condition//
        if(node == null) return 0;
        if(node.left == null && node.right == null) return 1;
        return findNumberOfLeafNodes(node.left) + findNumberOfLeafNodes(node.right);
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

        int totalNumberOfLeafNodes = findNumberOfLeafNodes(root);
        System.out.println("Total Number Of Leaf Nodes :: "+totalNumberOfLeafNodes);
    }
}
