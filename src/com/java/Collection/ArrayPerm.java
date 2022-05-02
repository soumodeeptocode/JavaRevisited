package com.java.Collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayPerm {

    static List<List<Integer>> finalArr = new ArrayList<>();

 public static void doRecursion(List<Integer> arr) {
  List<Integer> newDS = new ArrayList<>();
  boolean []hashArr = new boolean[arr.size()];
  doRec(arr, newDS, hashArr);
 }

 public static void doRec(List<Integer> arr, List<Integer> newDS, boolean[] hashArr){
  //base condition//
  if(arr.size() == newDS.size()) {
      //finalArr.add(newDS);
      System.out.println(newDS.toString());
      return;
  }
  for(int i = 0; i < arr.size(); i++){
      if(!hashArr[i]){
         hashArr[i] = true;
         newDS.add(arr.get(i)); // [1,2,3] i=2 [1,3,2]
         doRec(arr, newDS, hashArr);
         //System.out.println(newDS.toString());
         hashArr[i] = false;
         newDS.remove(newDS.size()-1);
      }
  }
 }

 public static void main(String[] args) {
  List<Integer> a = new ArrayList<>(List.of(1,2,3));
  doRecursion(a);
 }
}




