package com.java.Collection;

public class Factorial {

    public static  int doFactorial(int n) {
        //base condition//
        if(n == 0) return 1;
        return n * doFactorial(n-1);
    }

    public static void main(String args[]){
        int n = 4;
        int result = doFactorial(n);
        System.out.println("The Factorial of "+ n +" is :: "+result);
    }
}





