package com.java.newton.doubt.class1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RightmostIndex {

    /*
    * Brute Force way to find the right most index
    */
    static void doFindRightMostIndex(List<Integer> inputList){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < inputList.size(); i++){
            for(int j = inputList.size()-1; j >=i; j--){
                if(inputList.get(j) >= inputList.get(i) && i <= j){

                    System.out.println("j is : "+j + ", i is : "+i);
                    result.add(j+1);
                    break;
                }
            }
        }
        System.out.print("The right most indexes of every element in the array :: ");
        System.out.println();
        for(Integer x : result){
            System.out.print(x);
        }
    }

    static void doFindRightIndexbyArray(List<Integer> inputList){
        int n = inputList.size();
        System.out.println("Length : "+n);
        int[] max = new int[n+1];
        Arrays.fill(max, Integer.MIN_VALUE);

        for(int i = n-1; i >= 0; i--){
            max[i] = Math.max(max[i+1], inputList.get(i));
        }

        for(int i = 0; i <= n; i++){
            System.out.print(max[i]);
        }

        //Binary Search//
        System.out.println("");
        for(int i = 0; i < n; i++){
            int low = i, high = n-1;
            int ans = i;

            while(low <= high){
                int mid = (low + high) / 2;
                //System.out.println("Mid :: "+mid);
                if(inputList.get(i) <= max[mid]){
                    ans = Math.max(ans, mid);
                    System.out.println("Answer : "+ans);
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
                //System.out.println(ans);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> listOfInteger = new ArrayList<>(Arrays.asList(5,2,4,3,1));
        //doFindRightMostIndex(listOfInteger);
        doFindRightIndexbyArray(listOfInteger);
    }
}
