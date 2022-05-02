package com.java.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayRec {

    public static int doPrint(List<Integer> arr){
        //base condition//
        if(arr.size() == 0) return 0;

        int element = arr.get(0);
       // System.out.println(element);
        arr.remove(0);
        return element + doPrint(arr);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        int result = doPrint(arr);
        System.out.println("The result is :: "+result);
    }
}




