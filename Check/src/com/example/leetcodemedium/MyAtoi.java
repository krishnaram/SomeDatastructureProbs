package com.example.leetcodemedium;

import java.util.Stack;

public class MyAtoi {

    public  static void main(String[] arr){
       // System.out.println("Sample test passing myAtoi: " + (myAtoi("2147483648")==2147483647) + "\r\n");
        //System.out.println("Sample test passing remove-all-occurrences-of-a-substring: " + (removeOccurrences("aabababa","aba").equals("ba")) + "\r\n");;
       // System.out.println("Sample test passing is valid Parantisis: " + isValid("()") + "\r\n");;
        System.out.println("Sample test passing is valid Parantisis: " + isValid("[])") + "\r\n");;

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        stack.add(s.charAt(0));
        if(s.charAt(0)==')' && s.charAt(0)=='}' && s.charAt(0)==']' ){
            return false;
        }
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[' ){
                stack.add(s.charAt(i));
            }
            else if((s.charAt(i)==')' || s.charAt(i)==']' || s.charAt(i)=='}') && stack.size() ==0 ){
                return  false;
            }
            else if(s.charAt(i)==')' && stack.size()>0){
                if(stack.peek() =='(' ){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else if(s.charAt(i)=='}' && stack.size()>0){
                if(stack.peek() =='{' ){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else if( s.charAt(i)==']' && stack.size()>0){
                if(stack.peek() =='[' ){
                    stack.pop();
                }
                else{
                    return false;
                }
            }

        }
        if(stack.size()!=0){
            return false;
        }
        return true;
    }

    public static int myAtoi(String s) {
        int runningInt = 0;
        boolean neg = false;
        if(s.length() ==0){
            return 0;
        }
        int digit = 0;
        int i=0;
        for(;i<s.length();i++){
            if(s.charAt(i)==' '){
                continue;
            }
            if(s.charAt(i) =='+' || s.charAt(i) =='-'){
                if(s.charAt(i) =='-'){
                    neg = true;
                }
                i =i+1;
                break;
            }
            else{
                break;
            }
        }

        for(;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                digit = Integer.parseInt(s.charAt(i)+"");
                if((long)runningInt*10+digit <=Integer.MAX_VALUE){
                    runningInt = (runningInt*10)+digit;
                }
                else{
                    // System.out.println(runningInt+":In break");
                    if(neg){
                        return Integer.MIN_VALUE;
                    }
                    return Integer.MAX_VALUE;
                    //System.out.println(runningInt+":In break after");
                }

            }
            else{
                break;
            }
        }

        if(neg){
            runningInt = (runningInt* -1);

        }
        return runningInt;
    }

    public static String removeOccurrences(String s, String part) {
        String[] parts = s.split(part,2) ;  //.indexOf(part);
        StringBuilder stringBuild = new StringBuilder();
        while(parts.length>1){
            stringBuild = new StringBuilder();
            for(String str:parts){
                System.out.println(str);
                stringBuild.append(str);
            }
            s = stringBuild.toString();
            parts = s.split(part,2);
        }
        System.out.println(s);
        return s.replace(part,"");
    }


}
