package com.example.leetcodemedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxDistance {

    public static void main(String[] str){
        List<List<Integer>> inputList = new ArrayList<List<Integer>>();
        inputList.add(Arrays.asList(new Integer[] {1,2,3}));
        inputList.add(Arrays.asList(new Integer[] {4,5}));
        inputList.add(Arrays.asList(new Integer[] {1,2,3}));

        System.out.println("Sample test passing max Distance: " + maxDistance(inputList)  + "\r\n");
        inputList = new ArrayList<List<Integer>>();
        inputList.add(Arrays.asList(new Integer[] {1}));
        inputList.add(Arrays.asList(new Integer[] {1}));
        System.out.println("Sample test passing max Distance: " + maxDistance(inputList) + "\r\n");

        inputList = new ArrayList<List<Integer>>();
        inputList.add(Arrays.asList(new Integer[] {1,4}));
        inputList.add(Arrays.asList(new Integer[] {0,5}));
        System.out.println("Sample test passing max Distance: " + maxDistance(inputList) + "\r\n");
    }
    public static int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = 0;
        int maxIndex = 0;
        int tempMin = min;
        int tempMax = max;
        for(int i=0;i<arrays.size();i++){
            List<Integer> list = arrays.get(i);
            if(list.get(0)<tempMin){

                if(list.get(0)<min){
                    tempMin = min;
                    min =list.get(0);
                    minIndex =i;
                }
                else{
                    tempMin = list.get(0);
                }

            }
            if(list.get(list.size()-1)>tempMax){
                 if(list.get(list.size()-1)>max){
                    tempMax = max;
                    max = list.get(list.size()-1);
                    maxIndex =i;
                }
                 else{
                     tempMax = list.get(list.size()-1);
                 }

            }

        }
        if(minIndex == maxIndex){
             return tempMax-min> max-tempMin? tempMax-min:max-tempMin;
        }

        return max-min;
    }
}
