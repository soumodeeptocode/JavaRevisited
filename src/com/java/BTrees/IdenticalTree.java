package com.java.BTrees;

public class IdenticalTree {

    static boolean isTreSame(Node p, Node q){
        if(p == null || q == null) return (p == q);

        return (p.data == q.data) && isTreSame(p.left, q.left) && isTreSame(p.right, q.right);
    }

    public static void main(String[] args) {
        Node pRoot = new Node(1);
        pRoot.left = new Node(2);
        pRoot.right = new Node(3);
        pRoot.left.left = new Node(4);
        pRoot.right.left = new Node(5);
        pRoot.right.right = new Node(6);

        Node qRoot = new Node(1);
        qRoot.left = new Node(2);
        qRoot.right = new Node(3);
        qRoot.left.left = new Node(4);
        qRoot.right.left = new Node(5);
       // qRoot.right.right = new Node(6);

        boolean isSame = isTreSame(pRoot, qRoot);
        System.out.println(isSame == true ? "Both the tree are same" : "The trees are not same");
    }
}
