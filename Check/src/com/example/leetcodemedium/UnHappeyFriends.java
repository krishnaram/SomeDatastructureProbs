package com.example.leetcodemedium;

import java.util.HashMap;
import java.util.Map;

public class UnHappeyFriends {

    public static void main(String[] s){
      System.out.println("Sample test passing is all integers range covered: " +
                (unhappyFriends(4, new int[][]
                        {{1,3,2},{2,3,0},{1,0,3},{1,0,2}},
                        new int[][] {{2,1},{3,0}}) == 0)  + "\r\n");

        System.out.println("Sample test passing is all integers range covered: " +
                (unhappyFriends(4, new int[][]
                                {{1,2,3},{3,2,0},{3,1,0},{1,2,0}},
                        new int[][] {{0,1},{2,3}}) == 2)  + "\r\n");

        System.out.println("Sample test passing is all integers range covered: " +
                (unhappyFriends(4, new int[][]
                        {{2,1,3},{2,3,0},{3,0,1},{2,0,1}},
                        new int[][] {{1,3},{0,2}})==3) + "\r\n");
    }

    public static int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int unHappy = 0;
        boolean isHappyone;
        boolean isHappyTwo;
        Map<Integer,Integer> pairedPerson = new HashMap<Integer,Integer>();
        for(int i=0;i<pairs.length;i++){
            isHappyone = false;
             isHappyTwo = false;
            for(int j:preferences[pairs[i][0]]){
                if(pairedPerson.containsKey(j)){
                    //do no thing
                }
                else if(j == pairs[i][1]){
                    isHappyone = true;
                    //pairedPerson.put(pairs[i][0],0);
                    break;
                }
                else{ unHappy++; break;}
            }
            for(int j:preferences[pairs[i][1]]){

                if(pairedPerson.containsKey(j)){
                    //do no thing
                }
                else if(j == pairs[i][0]){
                    isHappyTwo = true;
                   // pairedPerson.put(pairs[i][1],0);
                    break;
                }
                else{ unHappy++; break;}
            }
            if(isHappyone)pairedPerson.put(pairs[i][0],0);
            if(isHappyTwo)pairedPerson.put(pairs[i][1],0);
        }
        return unHappy;
    }
}
