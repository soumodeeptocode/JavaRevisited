package com.java.Application;


import java.util.ArrayList;
import java.util.List;

public class BigInteger {

    Node root;
    static  int carryover = 0;

    static class Node {
        int data;
        Node left, right;
        Node(int key){
            this.data = key;
            this.left = null;
            this.right = null;
        }
    }

    static Node insertNode(char[] ch, Node node, int index){
        if(index >= ch.length) return node;

        if( index < ch.length){
            int element = Character.getNumericValue(ch[index]);
            Node temp = new Node(element);
            node = temp;

            node.left = insertNode(ch, node.left, 2*index+1);
            node.right = insertNode(ch, node.right, 2*index+2);
        }
        return node;
    }

    static void doPrintInorder(Node node){
        if(node == null) return;

        doPrintInorder(node.left);
        System.out.print(node.data);
        doPrintInorder(node.right);
    }

    static Node mergeTrees(Node n1, Node n2){
        if(n1 == null) return n2;
        if(n2 == null) return n1;

        n1.data += n2.data;
        n1.left = mergeTrees(n1.left, n2.left);
        n1.right = mergeTrees(n1.right, n2.right);
        return n1;
    }

    static int findHeightOfTree(Node node){
        if(node == null) return 0;

        return 1 + Math.max(findHeightOfTree(node.left), findHeightOfTree(node.right));
    }

    static List<Character> findSum(Node node) {
        List<Character> result = new ArrayList<>();
        if(node == null) return result;
        int height = findHeightOfTree(node);

        for(int i = height; i >= 1; i--){
            sum(node, i, result);
            //System.out.println();
        }
        if(carryover == 1)result.add(Character.forDigit(1,10));
        return result;
    }

    static void sum(Node node, int level, List<Character> result) {
        if(node == null) return;

        if(level == 1){
            //System.out.print(node.data);
           // result.add(node.data);

            if(carryover != 0){
                System.out.println("Inside Carry Over for :: "+node.data);
                node.data = node.data + carryover;
            }
            System.out.println("The original data :: "+node.data);
            int digit = node.data >= 10 ? node.data % 10 : node.data;
            System.out.println("The digit is :: "+digit);
            carryover = node.data >= 10 ? node.data / 10 : 0;
            System.out.println("The carryover is :: "+carryover);
            result.add(Character.forDigit(digit,10));
           return;
        }
        sum(node.right, level -1, result);
        sum(node.left, level-1, result);

    }

    public static void main(String[] args) {
            BigInteger tree1 = new BigInteger();
            BigInteger tree2 = new BigInteger();
           // char[] s1 = "2768437".toCharArray();
            char[] s1 = "789648".toCharArray();
            tree1.root = tree1.insertNode(s1, tree1.root, 0);

           // char[] s2 = "7299652".toCharArray();
            char[] s2 = "287984".toCharArray();
            tree2.root = tree2.insertNode(s2, tree2.root, 0);

            //tree1.doPrintInorder(tree1.root);
            //findSum(tree1.root);
            System.out.println();
            //tree2.doPrintInorder(tree2.root);
            //findSum(tree2.root);

            Node merged = mergeTrees(tree1.root, tree2.root);
            System.out.println();
           // tree1.doPrintInorder(merged);

            List<Character> result = findSum(merged);
            //result.toString();
            for(int i = result.size()-1 ; i >= 0; i--){
                System.out.print(result.get(i));
            }


    }
}
