package com.example.leetcodemedium;

public class NumberOfSubArray {

    public static void main(String[] str){
       /* System.out.println("Sample test passing NumberOfSubArray: " + (numberOfSubarrays(new int[] {1,1,2,1,1}
                ,3)== 2) + "\r\n");*/
/*        System.out.println("Sample test passing NumberOfSubArray: " + (numberOfSubarrays(new int[]
                {2,2,2,1,2,2,1,2,2,2}, 2)== 16) + "\r\n");
        System.out.println("Sample test passing NumberOfSubArray: " + (numberOfSubarrays(new int[]
                {2,4,6}, 1)== 0) + "\r\n");*/
        System.out.println("Sample test passing NumberOfSubArray: " + (numberOfSubarraysApproach2(new int[]
                {2,2,2,1,2,2,1,2,2,2}, 2)== 16) + "\r\n");
        System.out.println("Sample test passing NumberOfSubArray: " + (numberOfSubarraysApproach2(new int[]
                {2,4,6}, 1)== 0) + "\r\n");
        System.out.println("Sample test passing NumberOfSubArray: " + (numberOfSubarraysApproach2(new int[] {1,1,2,1,1}
                ,3)== 2) + "\r\n");
        System.out.println("Sample test passing NumberOfSubArray: " + (numberOfSubarraysApproach2(new int[] {2044,96397,50143}
                ,1)== 3) + "\r\n");

        /*2,2,2,1,2,2,1,2,2,2
        2,2,1,2,2,1,2,2,2
        2,1,2,2,1,2,2,2

        2,2,2,1,2,2,1
        2,2,1,2,2,1
        2,1,2,2,1

        1,2,2,1
        1,2,2,1,2
        1,2,2,1,2,2
        1,2,2,1,2,2,2

        2,2,1,2,2,1,2,2,2*/
    }
    public static int numberOfSubarrays(int[] nums, int k) {
        int tempK=0;
        int index = 0;
        int count = 0;
        int slidingIndex =0;
        int tempSlidingIndex =0;
        int subArrayIndex = -1;
        int runningIndex = 0;
        while(index<nums.length || tempK == k) {
            if (tempK == k) {
                runningIndex = index;
                while (runningIndex<nums.length){
                    if(nums[index] % 2 == 0){
                        count++;
                    }
                    else{
                        break;
                    }
                    runningIndex++;

                }
                while (slidingIndex <= subArrayIndex) {
                    slidingIndex++;
                    count++;
                }
                if(!(slidingIndex <= subArrayIndex)) {
                    tempSlidingIndex = slidingIndex;
                    if(index<nums.length && nums[index]%2 ==0){
                        slidingIndex = index;
                        while (slidingIndex<nums.length ){
                            if(nums[slidingIndex]%2 ==0){
                                slidingIndex++;
                                count++;
                            }
                            else {
                                break;
                            }
                        }
                    }


                    index = tempSlidingIndex;
                    subArrayIndex = -1;
                    tempK =0;
                    continue;
                }
            }
            if (nums[index] % 2 == 1 && tempK < k) {
                tempK++;
                if (subArrayIndex == -1) {
                    subArrayIndex = index;
                }
            }
            index++;

        }
        return  count;
    }

    public static int numberOfSubarraysApproach2(int[] nums, int k) {
        int tempK=0;
        int index = 0;
        int count = 0;
        int bigSlidingStart =0;
        int bigSlidingEnd =0;
        int smallSlidingStart =0;
        int smallSlidingEnd =0;

        while(index<nums.length || tempK == k) {
            if(nums[index] % 2 ==0 && index<=bigSlidingStart){
                bigSlidingStart = index;
            }
            if (nums[index] % 2 == 1 ) {
                tempK++;
                if(tempK == 1 ){
                    smallSlidingStart = index;
                }
                if(tempK == k){
                    smallSlidingEnd = index;
                }
            }
            if(tempK > k || (tempK == k && index == nums.length-1) ){
                if(index == nums.length-1 && tempK == k){
                    bigSlidingEnd = index;
                }
                else if(tempK >k){
                    bigSlidingEnd = index-1;

                }

                count = count+((smallSlidingStart-bigSlidingStart)*(bigSlidingEnd - smallSlidingEnd))
                        +(smallSlidingStart-bigSlidingStart)+(bigSlidingEnd - smallSlidingEnd) +1;
                if(tempK >k){
                    index = smallSlidingStart;
                }if(index == nums.length-1){
                    break;
                }
                else{
                    index = smallSlidingStart+1;
                    bigSlidingStart = index;
                }
                tempK = 0;
            }
            else if(tempK ==k || nums[index] % 1 == 0){
                bigSlidingEnd = index;
            }
            index++;
        }
        return  count;
    }
}
