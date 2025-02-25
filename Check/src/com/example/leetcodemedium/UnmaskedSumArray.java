package com.example.leetcodemedium;

import java.util.*;
import java.util.stream.Collectors;

public class UnmaskedSumArray {

    public static void main(String[] str){
        /*System.out.println("Sample test passing UnmaskedSumArray: " + (unmarkedSumArray(new int[]
                {1,2,2,1,2,3,1}, new int[][]{{1,2},{3,3},{4,2}})) + "\r\n");*/
        System.out.println("Sample test passing UnmaskedSumArray: " + (unmarkedSumArray(new int[]
                {9,9,9,9,9,14,17,3,15,15,4,17,19,11,9,15,9,4,10},
                new int[][]{{13,3},{15,2},{12,2},{4,3}})) + "\r\n");
        System.out.println("Sample test passing UnmaskedSumArray: " + (unmarkedSumArray2(new int[]
                        {9,9,9,9,9,14,17,3,15,15,4,17,19,11,9,15,9,4,10},
                new int[][]{{13,3},{15,2},{12,2},{4,3}})) + "\r\n");
    }
    public static long[] unmarkedSumArray(int[] nums, int[][] queries) {
        long[] sum = new long[queries.length];
        boolean[] mark = new boolean[nums.length];
        List<Integer> sortedPos = new ArrayList<Integer>();
        List<Integer> sortedNums = new ArrayList<Integer>();
        Map<Integer, List<Integer>> numberPosition = new HashMap<Integer, List<Integer>>();
        long totalSum = 0;
        for(int i=0;i<nums.length;i++){
            if(numberPosition.containsKey(nums[i])){
                numberPosition.get(nums[i]).add(i);
            }
            else {
                numberPosition.put(nums[i],new ArrayList<Integer>());
                numberPosition.get(nums[i]).add(i);
            }
            totalSum= totalSum+nums[i];
        }
        sortedNums = numberPosition.keySet().stream().collect(Collectors.toList());
        Collections.sort(sortedNums);

        for(Integer number:sortedNums){
            sortedPos.addAll(numberPosition.get(number));
        }

        //quickSort(sortedNums,0, sortedNums.length-1, sortedPos);

        int runningSum = 0;
        int numberOfSmall = 0;
        for(int i=0;i<queries.length;i++){
            runningSum = 0;
            if(mark[queries[i][0]] == false){
                runningSum = nums[queries[i][0]];
                mark[queries[i][0]] = true;
            }
            numberOfSmall = 0;
            List<Integer> removeList = new ArrayList<Integer>();
            for(int pos:sortedPos){
                if(mark[pos] == false && numberOfSmall<queries[i][1]){
                    mark[pos] = true;
                    runningSum = runningSum+ nums[pos];
                    numberOfSmall++;
                    removeList.add(pos);
                }
                else if(mark[pos] == true){
                    removeList.add(pos);
                }
                else if(numberOfSmall == queries[i][1]){
                    break;
                }
            }
            sortedPos.removeAll(removeList);
            sum[i] = totalSum - runningSum;
            totalSum = sum[i];

        }
        return sum;
    }

    public static long[] unmarkedSumArray2(int[] nums, int[][] q) {
        HashSet<Integer> hs=new HashSet<>(); // To store all visited index
        long sum=0;

        int[] check=new int[nums.length]; // Store index as per smallest value
        long[] ans=new long[q.length];
        for(int e:nums)
            sum+=e;
        TreeMap<Integer,ArrayList<Integer>> tm=new TreeMap<>();
        // TreeMap to get the nums value in sorted order as key and all index storing that key is stored in arraylist as values.
        // For nums=[1,2,2,1,2,3,1]
        // tm = (1 (0,3,6), 2 (2,4) , 3 (5)) --> (key, value) format
        for(int i=0;i<nums.length;i++){
            if(!tm.containsKey(nums[i])){
                ArrayList<Integer> arr=new ArrayList<>();
                arr.add(i);
                tm.put(nums[i],arr);
            }
            else{
                tm.get(nums[i]).add(i);
            }
        }
        int ind=0;
        for (Map.Entry<Integer,ArrayList<Integer>> e : tm.entrySet()){
            ArrayList<Integer> a=e.getValue();
            for(int h=0;h<a.size();h++){
                check[ind]=a.get(h);
                ind++;
            }
        }
        int now=0;
        for(int i=0;i<q.length;i++){
            if(!hs.contains(q[i][0])){
                sum-=nums[q[i][0]];
                hs.add(q[i][0]);
            }

            int count=q[i][1];
            for(int j=0;j<count;j++){
                if(now!=check.length){
                    if(!hs.contains(check[now])){
                        sum-=nums[check[now]];
                        hs.add(check[now]);
                    }
                    else
                        j--; // if it already contains then we need one more round of iteration
                    now++;
                }
            }
            ans[i]=sum;
        }
        return ans;
    }
}
