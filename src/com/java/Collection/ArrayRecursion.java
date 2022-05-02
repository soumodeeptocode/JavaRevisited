package com.java.Collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayRecursion {
    static int count = 1;
    public static int doPrintArrayUsingRecursion(List<Object> nums){
        int currentVal = 0;

        if(nums.isEmpty()) return 0;
        System.out.println(nums.toString());
        if(nums.get(0) instanceof ArrayList){
            count ++;
            currentVal =  count * doPrintArrayUsingRecursion((List<Object>) nums.get(0));
            count --;
            System.out.println("Current Val : "+currentVal);
        }else{
            currentVal = Integer.parseInt(nums.get(0).toString());
            //System.out.println("Current Val :: "+currentVal);
        }
        nums.remove(0);
        return currentVal + doPrintArrayUsingRecursion(nums);
    }

    public static void main(String args[]){

        List<Object> nums = new ArrayList<>();
                //new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));
        nums.add(1);
        nums.add(2);
        nums.add(new ArrayList<>(List.of(3,4, new ArrayList<>(List.of(9,10)))));

        nums.add(5);
        nums.add(new ArrayList<>(List.of(6)));
        //doPrintArrayUsingRecursion(nums);
        int totalSum = doPrintArrayUsingRecursion(nums);
        System.out.println("Total sum : "+totalSum);
    }
}
