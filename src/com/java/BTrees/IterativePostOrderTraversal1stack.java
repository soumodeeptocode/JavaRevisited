package com.java.BTrees;

import java.util.Stack;

public class IterativePostOrderTraversal1stack {

    static void printPostOrderTraversal(Node node){
        if(node == null) return;
        Stack<Node> st = new Stack<Node>();
        Node prev = null;

        st.push(node);

        while(!st.isEmpty()){
            Node curr = st.peek();

            if(prev == null || prev.left == curr || prev.right == curr){
                if(curr.left != null) st.push(curr.left);
                else if(curr.right != null) st.push(curr.right);
            } else if(curr.left == prev){
                if(curr.right != null) st.push(curr.right);
            }else{
                System.out.print(curr.data + " ");
                st.pop();
            }
            prev = curr;
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
