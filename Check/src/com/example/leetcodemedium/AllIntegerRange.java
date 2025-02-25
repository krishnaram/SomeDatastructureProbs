package com.example.leetcodemedium;

public class AllIntegerRange {

    public static void main(String[] s){
        System.out.println("Sample test passing is all integers range covered: " +
                (isCovered(new int[][]
                        {{15,36},{15,23},{15,44},{30,49},{2,19},{27,36},{7,42},{12,41}},19,47) == true)  + "\r\n");
    }

    public static  boolean isCovered(int[][] ranges, int left, int right) {
        int covered =0;
        boolean isStartcovered= false;
        int temp;
        for(int i=0;i<ranges.length;i++){
            for(int j=i+1;j<ranges.length;j++){
                if(ranges[i][1]==-1){
                    break;
                }
                else{
                    if(ranges[i][0]>ranges[j][0]){
                        temp = ranges[i][0];
                        ranges[i][0] = ranges[j][0];
                        ranges[j][0] = temp;

                        temp = ranges[i][1];
                        ranges[i][1] = ranges[j][1];
                        ranges[j][1] = temp;
                    }

                    else if(ranges[i][0]==ranges[j][0] && ranges[j][1]>ranges[i][1]){
                        if(ranges[j][1]>ranges[i][1]){
                            temp = ranges[i][1];
                            ranges[i][1] = ranges[j][1];
                            ranges[j][1] = -1;
                            ranges[j][0] = -1;
                        }
                    }
                }

            }
        }
        //int[] range = new int[];
        for(int i=0;i<ranges.length;i++){
            if(ranges[i][1]==-1){
                continue;
            }
            else if(!isStartcovered && ranges[i][0]<=left && ranges[i][1]>=left ){
                isStartcovered = true;

                covered = ranges[i][1];
                if(ranges[i][1]>=right){
                    return true;
                }

            }
            else if(covered<=ranges[i][1] && (covered+1 == ranges[i][0] || covered>ranges[i][0])
                    && isStartcovered){
                 if( ranges[i][1]>=right){
                     return true;
                 }
                 else if(covered+1>=ranges[i][0]){
                     covered =ranges[i][1];
                 }
            }
        }
        return false;
    }
}
