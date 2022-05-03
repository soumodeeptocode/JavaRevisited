package com.java.BTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderWithoutRecursion {
    static void doPrintReverseLevelOrderTraversal(Node node){
        if(node == null) {
            System.out.println();
            return;
        }

        Queue<Node> q = new LinkedList<Node>();
        Stack<Node> s = new Stack<Node>();

        q.add(node);

        while(q.size() > 0){
            Node top = q.remove();

            if(top.right != null){
                q.add(top.right);
            }
            if(top.left != null){
                q.add(top.left);
            }

            s.add(top);
        }

        while(!s.isEmpty()){
            Node top = s.pop();
            System.out.print(top.data + " ");
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

        doPrintReverseLevelOrderTraversal(root);
    }
}
