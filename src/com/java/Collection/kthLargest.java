//package com.java.Collection;
//
//public class kthLargest {
//
//    class Node {
//        int data;
//        Node left, right;
//        Node(int data){
//            this.data = data;
//            left=right=null;
//        }
//    }
//
//    int count = 0;
//    Node root;
//    boolean foundLargest = false;
//    public class NodeCount {
//        int c = 0;
//    }
//
//    static void doFindKthLargest(Node node, int k,  NodeCount count){
//        if(node == null) return;
//
//        doFindKthLargest(node.right, k , count);
//        count.c ++;
//        if(count.c == k){
//            System.out.println("The "+k+"th largest element is - "+node.data);
//            this.foundLargest = true;
//            return;
//        }
//        doFindKthLargest(node.left, k, count);
//    }
//
//    void kthLargest(int k){
//        NodeCount count = new NodeCount();
//        doFindKthLargest(this.root, k, count);
//    }
//
//    public void insertNode(int data){
//        this.root = doInsertNode(this.root, data);
//    }
//
//    Node doInsertNode(Node node, int data){
//        if(node == null){
//            this.root = new Node(data);
//            return this.root;
//        }
//
//        if(data == node.data){
//            return node;
//        }
//
//        if(data < node.data){
//            node.left = this.doInsertNode(node.left, data);
//        }else{
//            node.right = this.doInsertNode(node.right, data);
//        }
//        return node;
//    }
//
//    public static void main(String[] args) {
//        kthLargest tree = new kthLargest();
//
//    }
//}
