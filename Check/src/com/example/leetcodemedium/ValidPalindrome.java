package com.example.leetcodemedium;

public class ValidPalindrome {
    public static boolean validPalindrome(String s) {
        StringBuilder builder = new StringBuilder(s);
        String reverse =String.valueOf(builder.reverse());
        if(reverse.equals(s)){
            return true;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=reverse.charAt(i) ){
                StringBuilder temp = new StringBuilder(s);
                String tempString = String.valueOf(temp.deleteCharAt(i));
                String reverseTempString = String.valueOf(temp.reverse());
                if(tempString.equals(reverseTempString)){
                    return true;
                }
            }
        }
        return false;
    }
}
