package com.java.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSubsets {

    static void doFindSubSet(List<Character> inputList, List<Character> outputList, int i, int j){
        System.out.println(inputList.toString());
        //base case//
        if(j == inputList.size()){
            System.out.println(outputList.toString());
            return;
        }
        //Consider//
        outputList.add(inputList.get(i));
        doFindSubSet(inputList, outputList, i+1, j+1);

        //Not consider//
        doFindSubSet(inputList, outputList, i+1, j);

    }

    public static void main(String[] args) {
        List<Character> inputList = new ArrayList<Character>(Arrays.asList('a','b','c'));
        List<Character> outputList = new ArrayList<Character>();
        doFindSubSet(inputList, outputList, 0, 0);
    }
}
