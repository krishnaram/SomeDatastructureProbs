package com.example.leetcodemedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSwapCircular {
    public static void main(String[] str){
        double value =50-(50*((double) 85/(double)100));
        double result = (double) (85/100);
        System.out.println((double)value);
        System.out.println("Check min swaps required:"+(minSwaps(new int[]{272,499,238})
                ==0));

    }

    public static int minSwaps(int[] nums) {
        List<Integer> betweenZeros = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                betweenZeros.add(i);
            }
        }
        for(int position:betweenZeros){

        }
    return 0;
    }

}
