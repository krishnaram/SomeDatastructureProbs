package com.example.leetcodemedium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxImportanceRoad {
    public static void main(String[] s){
        System.out.println("Sample test passing is all integers range covered: " +
                (maximumImportance(5, new int[][]
                                        {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}}) == 43l)  + "\r\n");

        System.out.println("Sample test passing is all integers range covered: " +
                (maximumImportance(5, new int[][]
                        {{0,3},{2,4},{1,3}}) == 20l)  + "\r\n");
    }
    public static long maximumImportance(int n, int[][] roads) {
        List<Integer> impArray = new ArrayList<Integer>();
        int[] valueArray = new int[n];
        for(int i=0;i<roads.length;i++){
            valueArray[roads[i][0]]++;
            valueArray[roads[i][1]]++;
        }
        for(int i=0;i<valueArray.length;i++){
            impArray.add(i);
        }
        Collections.sort(impArray,(a, b)-> Integer.compare(valueArray[(int)a],valueArray[(int)b]));


        int allImp =0;
        for(int i=0;i<roads.length;i++){
            allImp = allImp+ (impArray.indexOf(roads[i][1])+1) + (impArray.indexOf(roads[i][0])+1);
        }
        return allImp;
    }
}
