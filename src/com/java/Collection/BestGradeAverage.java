package com.java.Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BestGradeAverage {

    static int best_average_grade = Integer.MIN_VALUE;

    public static int doFindBestGrades(String[][] scores){
        HashMap<String, ArrayList<Integer>> scoreMap = new HashMap<String, ArrayList<Integer>>();

        for(int i = 0; i < scores.length; i++ ){
            if(scoreMap.get(scores[i][0]) == null) {
                ArrayList<Integer> scoreList = new ArrayList<>();
                scoreList.add(Integer.parseInt(scores[i][1]));
                System.out.println("Printing from line 15 : "+scores[i][0]);
                scoreMap.put(scores[i][0], new ArrayList<>(List.of(Integer.parseInt(scores[i][1]))));
                System.out.println("Printing from line 17 : "+scoreMap.toString());
            }else {
                ArrayList<Integer> scoreList = scoreMap.get(scores[i][0]);
                scoreList.add(Integer.parseInt(scores[i][1]));
            }
            //scoreMap.put(scores[i][0],scoreMap.getOrDefault(scores[i][0], new ArrayList<>(List.of())).add(Integer.parseInt(scores[i][1])));
        }

        System.out.println(scoreMap.toString());

        //iterating the HashMap of scoreMap //

        for(String names: scoreMap.keySet()){
            ArrayList<Integer> score = scoreMap.get(names);
            int current_sum = 0;
            int current_average = 0;
            for(int i=0; i < score.size(); i++) {
                current_sum += score.get(i);
            }
            System.out.println("Current Sum :"+current_sum);
            current_average = current_sum / score.size();
            System.out.println("Current Average :"+current_average);
            if(current_average > best_average_grade) {
                best_average_grade = current_average;
            }
        }
        return best_average_grade;
    }

    public static void main(String args[]){
        String [][] grades = {{"Bobby", "87"}, {"Charles", "100"}, {"Eric", "83"}, {"Charles", "22"}};
        int best_grade = doFindBestGrades(grades);
        System.out.println("Best Average Grade : "+best_grade);
    }
}
