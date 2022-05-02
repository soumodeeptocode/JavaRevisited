package com.java.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {

    static int count = 1;

    public static int doProductSum(List<Object> arr, int index) {
       // [1, 2, [3, 4], [5, [6, 7]]] = [1+2+3+4+5+6+7] = 28
        // [1 + 2 + 14 + ]

//        [5, [6,7]] = [5 + [6,7]] = [5 + [6+7]] = [5+ 13] = 18
        int element = 0;
        //Base condition//
        System.out.println("Line number 12 :: "+index);
        if(index == arr.size()) return 0;

        System.out.println("Line number 15 :: "+index);

        if(arr.get(index) instanceof ArrayList){
            System.out.println("Line 15 :: "+ arr.get(index).toString());
            count ++;
            element = count * doProductSum((List<Object>) arr.get(index), 0);
            count --;
        }else {

            element = Integer.parseInt(arr.get(index).toString());
            System.out.println("Line 20 :: "+element);
        }

        return element + doProductSum(arr, index + 1);
    }

    public static void main(String[] args) {
        List<Object> arr = new ArrayList<>(Arrays.asList(5,2, new ArrayList<>(Arrays.asList(7,-1)),3, new ArrayList<>(Arrays.asList(6, new ArrayList<>(Arrays.asList(-13,8)), 4))));
//       List<Object> a1 = new ArrayList<>(Arrays.asList(3,4));
//        List<Object> a2 = new ArrayList<>(Arrays.asList(5, new ArrayList<>(Arrays.asList(6,7))));
//        arr.add(a1);
//        arr.add(a2);
        System.out.println("Input Array is :: "+ arr.toString());
        int result = doProductSum(arr, 0);
        System.out.println("Result :: "+result);
    }
}



//array = [5,2, [7,-1], 3, [6, [-13,8],4]];
//
//a = [1,2,3,4];
//
//a = 10;
//
//a = [1,2,[3,4], [5, [6,7]]];
//   = 1+2+[3,4] + [5, [6,7]]
//   =1+2+ 2*(3+4) + 2 *(5 + [6,7])
//   = 3+ 2*7 + 2 * (5+ 3*(6+7))
//   = 3 + 14 + 2* (5 + 39)
//   = 17 + 2 * 44
//   = 17 + 88
//   = 105
//
//a = [1,2,[3,4], [5, [6,7]]]

//a = [1,2,3,4,5,6,7]
//a = 28;
