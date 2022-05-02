package com.java.Collection;

public class MultiplicationRec {

    public static int doMulti(int[] arr, int n){
        //base condition//
        if(n == 0) return 1;

        return arr[n] * doMulti(arr, n-1);
    }

    public static void main(String[] args) {
        int a[] = new int[]{1,2,3,4, 5,6};
        int result =  doMulti(a, a.length-1);
        System.out.println("Result is :: "+result);
    }
}
