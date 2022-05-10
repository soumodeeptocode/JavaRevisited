package com.java.BTrees;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {

    static boolean isLeaf(Node node){
        return (node.left == null) && (node.right == null);
    }

    static List<Integer> boundaryNodes(Node node){
        List<Integer> result = new ArrayList<>();
        if(node == null) return result;
        if(!isLeaf(node)) result.add(node.data);
        findLeftBoundary(node, result);
        addLeaves(node, result);
        findRightBoundary(node, result);
        return result;
    }

    static void findLeftBoundary(Node node, List<Integer> result){
        Node currentNode = node.left;

        while(currentNode != null){

            if(!isLeaf(currentNode)) result.add(currentNode.data);

            if(currentNode.left != null) currentNode = currentNode.left;
            else currentNode = currentNode.right;
        }
    }
    static void findRightBoundary(Node node, List<Integer> result){
        Node current_Node = node.right;
        List<Integer> temp = new ArrayList<>();

        while(current_Node != null){

            if(!isLeaf(current_Node)) temp.add(current_Node.data);

            if(current_Node.right != null) current_Node = current_Node.right;
            else current_Node = current_Node.left;
        }

        for(int i = temp.size() -1; i >= 0; i--){
            result.add(temp.get(i));
        }
    }

    static void addLeaves(Node node, List<Integer> result){

        if(isLeaf(node)){
            result.add(node.data);
            return;
        }

        if(node.left != null) addLeaves(node.left, result);
        if(node.right != null) addLeaves(node.right, result);
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

        List<Integer> result = boundaryNodes(root);

        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}
