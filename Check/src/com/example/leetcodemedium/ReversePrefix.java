package com.example.leetcodemedium;

public class ReversePrefix {

    public  static void main(String[] arr){
        System.out.println("Sample test passing reversePrefix: " + (reversePrefix("xyxzxe", 'z').equals("zxyxxe")) + "\r\n");
        System.out.println("Sample test passing reversePrefix: " + (reversePrefix("abcdefd",'d').equals("dcbaefd")) + "\r\n");;
    }
    public static String reversePrefix(String word, char ch) {
        String revrseString = "";
        int charFound = -1;
        for(int i=0;i<word.length();i++){
            revrseString =  word.charAt(i) +revrseString;
            if(word.charAt(i) == ch){
                charFound = i;
                break;
            }
        }
        if(charFound != -1){
            revrseString = revrseString+word.substring(charFound+1,word.length());
            return revrseString;
        }
        return word;
    }
}
