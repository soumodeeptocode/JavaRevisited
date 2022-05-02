package com.java.Collection;

public class Recursion {

    public static void  doPrint(int n){
        //base condition//
        if(n == 6) return;
        System.out.println("Hello, I am :: "+ n);
        doPrint(++n);
    }

    public static void main(String args[]){
        doPrint(1);
    }
}




