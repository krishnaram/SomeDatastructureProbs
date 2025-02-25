package com.example.leetcodemedium;

import java.util.HashMap;
import java.util.Map;

public class MinOperationWriteY {

    public static void main(String[] s){
       System.out.println("Sample test passing is valid BinarySearchTreeToGreaterSumtree: " +
                (minimumOperationsToWriteY(new int[][]
                        {{0,1,0,1,0},{2,1,0,1,2},{2,2,2,0,1},{2,2,2,2,2},{2,1,2,2,2}}) == 12)  + "\r\n");
        System.out.println("Sample test passing is valid BinarySearchTreeToGreaterSumtree: " +
                (minimumOperationsToWriteY(new int[][]
                        {{1,2,2},{1,1,0},{0,1,0}}) == 3)  + "\r\n");
        System.out.println("Sample test passing is valid BinarySearchTreeToGreaterSumtree: " +
                (minimumOperationsToWriteY(new int[][]
                        {{0,0,1},
                         {0,0,2},
                         {1,0,2}}) == 4)  + "\r\n");

        System.out.println("Sample test passing is valid BinarySearchTreeToGreaterSumtree: " +
                (minimumOperationsToWriteY(new int[][]
                        {{2,2,0,0,2}
                        ,{2,1,1,1,2}
                        ,{1,0,0,2,1}
                        ,{2,0,2,0,1},
                         {1,0,2,1,2}}) == 15)  + "\r\n");

    }


    public static int minimumOperationsToWriteY(int[][] grid) {
        int center =  (grid.length/2);
        Map<Integer,Integer> countY = new HashMap<Integer,Integer>();
        Map<Integer,Integer> countNonY = new HashMap<Integer,Integer>();

        boolean gridFlag= false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                gridFlag= false;
                if(i==0 && (j==0 || j+1== grid[i].length)){
                    gridFlag =true;
                }
                else if(i==j && i<center ){
                    gridFlag =true;
                }
                else if(j>center && j==(grid.length-1-i)  ){
                    gridFlag =true;
                }
                else if(center == i && center ==j){
                    gridFlag =true;
                }
                else if(center<  i && center ==j){
                    gridFlag =true;
                }
                if(gridFlag){
                    if(countY.containsKey(grid[i][j])){
                        countY.put(grid[i][j],countY.get(grid[i][j])+1);
                    }
                    else countY.put(grid[i][j],1);
                }else{
                    if(countNonY.containsKey(grid[i][j])){
                        countNonY.put(grid[i][j],countNonY.get(grid[i][j])+1);
                    } else countNonY.put(grid[i][j],1);
                }

            }
        }
        int  operations =  Integer.MAX_VALUE;
        int totalYCount = countY.keySet().stream().mapToInt(i->countY.get(i)).sum();
        int totalNonYCount = countNonY.keySet().stream().mapToInt(i->countNonY.get(i)).sum();
        if(countNonY.size() ==1 &&  countY.size() ==1){
            return totalYCount;
        }
        for(Integer number:countNonY.keySet()){
            for(Integer yNumber:countY.keySet()){
                if(number !=yNumber){

                    if (operations>(totalYCount-countY.get(yNumber)+totalNonYCount - countNonY.get(number)))
                    {
                        operations = totalYCount-countY.get(yNumber)+totalNonYCount - countNonY.get(number);
                    }
                }
            }
        }

        return operations;

    }
}
