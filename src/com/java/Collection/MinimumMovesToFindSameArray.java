package com.java.Collection;

import java.util.Arrays;

public class MinimumMovesToFindSameArray {

    static int doFindMinMoves(int[] arr){
        int n = arr.length;
        int sum = doSum(arr);
        int currentSum = sum;
        int max_element;
        int counter;
        int minMoves = Integer.MAX_VALUE;

        Arrays.sort(arr);
        max_element = arr[n-1];
        counter = max_element;
        System.out.println("Sum :: "+sum);
        doPrint(arr);

        while(sum <= currentSum){
            System.out.println("Counter :: "+counter);
            System.out.println("Current Sum :: "+currentSum);
            minMoves=  Math.min(checkMoves(arr, counter), minMoves);
            counter --;
            currentSum = counter * n;
        }

        return minMoves;
    }

    static int checkMoves(int[] arr, int max_element){
        int current_operations= 0;
        for(int i = 0; i< arr.length; i++){
            if(arr[i] < max_element){
                int diff = max_element - arr[i];
                current_operations += diff;
            }
        }
        return current_operations;
    }

    static void doPrint(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    static int doSum(int arr[]){
        int n = arr.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
               sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,4};
        System.out.println(doFindMinMoves(arr));
    }
}
