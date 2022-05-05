package com.java.BTrees;

import java.util.Stack;

public class IterativePostOrderTraversal2Stack {

    static  void printPostOrderTraversal(Node node){
        if(node == null) return;

        Stack<Node> st1 = new Stack<Node>();
        Stack<Node> st2 = new Stack<Node>();

        st1.push(node);

        while(!st1.isEmpty()){
            Node top = st1.pop();
            if(top.left != null) st1.push(top.left);
            if(top.right != null) st1.push(top.right);

            st2.push(top);
        }

        while(!st2.isEmpty()){
            System.out.print(st2.peek().data + " ");
            st2.pop();
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

        printPostOrderTraversal(root);
    }
}
