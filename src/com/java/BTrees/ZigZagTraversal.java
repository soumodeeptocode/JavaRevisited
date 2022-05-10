package com.java.BTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    static List<List<Integer>> findZigZagTraversal(Node node){
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new ArrayList<>();

        //edge case//
        if(node == null) return wrapList;

        boolean leftToRightFlag = true;
        queue.offer(node);

        while(!queue.isEmpty()){
            List<Integer> row = new ArrayList<>();
            int level = queue.size();

            for(int i = 0; i < level; i++){

                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);

                if(leftToRightFlag) row.add(queue.poll().data);
                else row.add(0, queue.poll().data);
            }
            leftToRightFlag = !leftToRightFlag;
            wrapList.add(row);
        }
        return wrapList;
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

        List<List<Integer>> result = findZigZagTraversal(root);
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
