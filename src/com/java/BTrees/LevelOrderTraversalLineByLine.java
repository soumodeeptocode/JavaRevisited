package com.java.BTrees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalLineByLine {

    static void printLevelOrderTraversalLineByLine(Node node){
        if(node == null) return;

        Queue<Node> q = new LinkedList<Node>();

        q.add(node);

        while(!q.isEmpty()){
            int qSize = q.size();
            for(int i = 1; i <= qSize; i++){
                Node top = q.remove();
                System.out.print(top.data + " ");
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
            }
            System.out.println();
        }
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

        printLevelOrderTraversalLineByLine(root);
    }
}
