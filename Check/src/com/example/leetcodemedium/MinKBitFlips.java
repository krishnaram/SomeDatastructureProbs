package com.example.leetcodemedium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MinKBitFlips {

    public  static void main(String[] arr){
        //System.out.println("Sample test passing is valid minKBitFlips: " +minKBitFlips(new int[]{0,1,0},1)==2);
        System.out.println("Sample test passing is valid minKBitFlips: " + (minKBitFlips(new int[]{0,1,0},1) == 2) + "\r\n");;
        System.out.println("Sample test passing is valid minKBitFlips: " + (minKBitFlips(new int[]{0,0,0,1,0,1,1,0},3) == 3)  + "\r\n");;

    }

    public static  int minKBitFlips(int[] nums, int k) {
        HashMap<Integer,Integer> bitZeroPos = new HashMap<Integer,Integer>();
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0)
            {
                bitZeroPos.put(i,0);
                count++;
            }

        }
        if(k==1){

            return count;
        }
        int totalFlips =0;
        int index =0;
        boolean indexSet =false;

        for(int i=0;i<nums.length;i++){
            count=0;
            indexSet =false;
            index =i;
            if(i+k>nums.length){
                break;
            }
            if(nums[i]==0){
                nums[i]=1;
                bitZeroPos.remove(i);
                count++;
                while(count<k && (i+k)<=nums.length){
                    int indexIn = i+count;
                    if(nums[indexIn] ==1) {
                         nums[indexIn] = 0;
                        bitZeroPos.put(indexIn,0);
                        if(indexSet == false){
                            index = indexIn;
                            indexSet = true;
                        }

                    }
                    else{
                        nums[indexIn] = 1;
                        bitZeroPos.remove(indexIn);

                    }
                    count++;
                }
                if(indexSet){
                    i= index-1;
                }
                else {
                    i= i+k-1;
                }

                totalFlips++;
            }
        }
        if(bitZeroPos.size()==0){
            return  totalFlips;
        }
        return -1;
    }
}
