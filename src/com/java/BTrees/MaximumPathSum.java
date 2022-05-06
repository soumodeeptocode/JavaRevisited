package com.java.BTrees;

public class MaximumPathSum {

    static int doMaxPathSum(Node node){
        int pathSum[] = new int[1];
        maxPathSum(node, pathSum);
        return pathSum[0];
    }

    static int maxPathSum(Node node, int[] pathSum){
        //base condition//
        if(node == null) return 0;

        int leftSubTreeSum = Math.max(0, maxPathSum(node.left, pathSum));
        int rightSubTreeSum = Math.max(0, maxPathSum(node.right, pathSum));

        pathSum[0] = Math.max(pathSum[0], leftSubTreeSum + rightSubTreeSum + node.data);

        return node.data + Math.max(leftSubTreeSum, rightSubTreeSum);
    }
    public static void main(String[] args) {
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.left.right.left = new Node(8);
//        root.right.left = new Node(6);
//        root.right.right = new Node(7);
//        root.right.right.left = new Node(9);
//        root.right.right.right = new Node(10);

        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);

        int max_path_sum = doMaxPathSum(root);
        System.out.println("The maximum path sum :: "+ max_path_sum);
    }
}
