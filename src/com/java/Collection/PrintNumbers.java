package com.java.Collection;

public class PrintNumbers {



    public static void doPrintReverse(int n){
        //base condition//
        if(n == 0) return;
        doPrintReverse(n-1);
        System.out.println("The value of n is :: "+n);
    }

    public static void main(String args[]){
       // doPrint(1);
        doPrintReverse(5);
    }
}
