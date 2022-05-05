package com.java.BTrees;

import java.util.Stack;

public class IterativePreOrderTraversal {

    static void printIterativePreOrderTraversal(Node node){
         if(node == null) return;

         Stack<Node> st = new Stack<Node>();

         st.push(node);

         while(!st.isEmpty()){

             Node top = st.pop();

             System.out.print(top.data + " ");

             if(top.right != null) st.push(top.right);
             if(top.left != null) st.push(top.left);
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

        printIterativePreOrderTraversal(root);
    }
}
