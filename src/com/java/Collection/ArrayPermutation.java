package com.java.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPermutation {

//    public static List<List<Integer>> doFindPermutation(List<Integer> array){
//        System.out.println("Array : "+array.toString());
//        do
//        return new ArrayList<List<Integer>>();
//    }

    public static void doFindPermutation(List<Integer> array) {
        List<Integer> newArray = new ArrayList<>();
        boolean[] hashArry = new boolean[array.size()];
        if (array.size() < 1) return;
        doPermutation(array, newArray, hashArry);

    }

        public static void doPermutation(List<Integer> array, List<Integer> newArray, boolean[] hashArray){
        System.out.println("func called :: "+newArray.toString());
            if(newArray.size() == array.size()) return;
            for (int i = 0; i < array.size(); i++) {
                System.out.println("index i at line number 26  :: "+i);
                if (!hashArray[i]) {
                    newArray.add(array.get(i));
                    hashArray[i] = true;
                    System.out.println("index i :: "+i);
                    System.out.println(newArray.toString());
                    doPermutation(array, newArray, hashArray);
                    System.out.println("Printing the index i :: "+i);
                    hashArray[i] = false;
                    newArray.remove(newArray.size()-1);
                    System.out.println("After removing from the new Array :: "+newArray.toString());
                }
            }
        }


//        for(int i=0; i< array.size()-1; i++){
//            System.out.println("Printing from line 19 :: "+array.get(i).toString());
//            swap(array, i, i+1);
//            System.out.println("Printing from line 21 :: "+array.toString());
//            swap(array, i, i);
//            System.out.println("Printing from line 23 :: "+array.toString());
//        }

    private static void swap(List<Integer> array, int first, int second) {

        int temp = array.get(first);
        array.set(first, array.get(second));
        array.set(second, temp);
       // return array;
    }

    
    public static void main(String args[]){

        List<Integer> input = new ArrayList<>(Arrays.asList(1,2,3));
        //List<List<Integer>> result = doFindPermutation(input);
        doFindPermutation(input);

    }
}
