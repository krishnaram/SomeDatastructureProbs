package com.example.leetcodemedium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountVowel {


    public  static void main(String[] arr){
        //System.out.println("Sample test passing is valid minKBitFlips: " +minKBitFlips(new int[]{0,1,0},1)==2);
        List<String> nullList = new ArrayList<>();
        Set<String> sampleSet = new HashSet<>(nullList);

        int[] res ;
        res = vowelStrings(new String[]{"aba","bcb","ece","aa","e"},new int[][]{{0,2},{1,4},{1,1}});
        int[] expectedRes = {2,3,0};
        System.out.println("Sample test passing is valid countVowels: " + (res==expectedRes) + "\r\n");;
        //System.out.println("Sample test passing is valid minKBitFlips: " + (minKBitFlips(new int[]{0,0,0,1,0,1,1,0},3) == 3)  + "\r\n");;

    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int[] res = new int[queries.length];
        int[] isStartAndEndVowel = new int[words.length];
        int index =0;
        int countOfVowel =0;
        for(String word:words){

            word = word.toLowerCase();
            if(word.charAt(0) =='a' || word.charAt(0) =='e' || word.charAt(0) =='i' || word.charAt(0) =='o'
                    || word.charAt(0) =='u'){
                if(word.charAt(word.length()-1) =='a' || word.charAt(word.length()-1) =='e' || word.charAt(word.length()-1) =='i' || word.charAt(word.length()-1) =='o'
                        || word.charAt(word.length()-1) =='u'){
                    countOfVowel++;
                    isStartAndEndVowel[index] = countOfVowel;
                }
            }
           index++;
        }
        for(int i=0;i< queries.length;i++){
            if(queries[i][1]>queries[i][0]){
                res[i] = isStartAndEndVowel[queries[i][1]]-isStartAndEndVowel[queries[i][0]];
            }
            else {
                if(queries[i][1]==0){
                    res[i]= isStartAndEndVowel[queries[i][0]];
                }else{

                }
            }

        }
    return res;
    }
}
