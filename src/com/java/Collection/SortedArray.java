package com.java.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedArray {

    public static boolean doCheck(List<Integer> arr, int n){
        //base condition//
        if(n == 0 || n == 1) return true;

        return arr.get(n-1) >= arr.get(n-2) && doCheck(arr, n-1);


    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(4,2,5,6,7,9,10));
        boolean result = doCheck(arr, arr.size());
        System.out.println(result == true ? "Array is Sorted" : "Array is not sorted");
    }
}





