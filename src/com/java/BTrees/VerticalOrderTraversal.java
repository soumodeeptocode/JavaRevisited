package com.java.BTrees;

import java.util.*;

class Tuple {
    Node node;
    int level;
    int vertical;
    Tuple(Node _node, int _level, int _vertical){
        this.node = _node;
        this.level = _level;
        this.vertical = _vertical;
    }
}


public class VerticalOrderTraversal {
    static List<List<Integer>> verticalOrderTraversal(Node node){
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> qt = new LinkedList<Tuple>();

        qt.offer(new Tuple(node, 0, 0));

        while(!qt.isEmpty()) {
            Tuple tuple = qt.poll();
            Node currentNode = tuple.node;
            int row = tuple.level;
            int col = tuple.vertical;

            if (!map.containsKey(row)) {
                map.put(row, new TreeMap<>());
            }
            if (!map.get(row).containsKey(col)) {
                map.get(row).put(col, new PriorityQueue<>());
            }
            map.get(row).get(col).offer(currentNode.data);

            if (currentNode.left != null) {
                qt.offer(new Tuple(currentNode.left, row - 1, col + 1));
            }

            if (currentNode.right != null) {
                qt.offer(new Tuple(currentNode.right, row + 1, col + 1));
            }
        }

            List<List<Integer>> verticalOrderNodes = new ArrayList<>();

            for(TreeMap<Integer, PriorityQueue<Integer>> verticalMap : map.values()){
                    verticalOrderNodes.add(new ArrayList<>());
                    for(PriorityQueue<Integer> nodes: verticalMap.values()){
                        while(!nodes.isEmpty()){
                            //System.out.println(nodes.poll());
                            verticalOrderNodes.get(verticalOrderNodes.size()-1).add(nodes.poll());
                        }
                    }
            }
            return verticalOrderNodes;
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

        List<List<Integer>> result = new ArrayList<>();
        result = verticalOrderTraversal(root);

        for(List<Integer> list: result){
            for(int data: list){
                System.out.print(data + " ");
            }
            System.out.println();
        }

//        for(int i = 0; i < result.size(); i++){
//            for(int j = 0; j < result.get(i).size(); j++){
//                System.out.println(result.get(i).get(j));
//            }
//        }
    }
}
