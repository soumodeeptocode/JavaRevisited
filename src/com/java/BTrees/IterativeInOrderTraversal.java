package com.java.BTrees;

import java.util.Stack;

public class IterativeInOrderTraversal {

    static void printIterativeInOrderTraversal(Node node){
        Stack<Node> st = new Stack<>();

        while (true){
            if(node != null){
                st.push(node);
                node = node.left;
            }else{
                if(st.isEmpty()) break;
                Node top = st.pop();
                System.out.print(top.data + " ");
                node = top.right;
            }
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

        printIterativeInOrderTraversal(root);
    }
}
