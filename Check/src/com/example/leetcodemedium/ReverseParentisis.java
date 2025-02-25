package com.example.leetcodemedium;

import java.util.ArrayList;
import java.util.List;

public class ReverseParentisis {

    public static void main(String[] str){
        System.out.println("Check min operation of folder ops:"+(reverseParentheses("(abcd)").equals("dcba")));
        System.out.println("Check min operation of folder ops:"+(reverseParentheses("(u(love)i)").equals("iloveu")));

    }

    public static String reverseParentheses(String s) {
        StringBuilder builder = new StringBuilder(s);
        int indexStart =0 ;
        List<Integer> parentisis = new ArrayList<Integer>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                parentisis.add(i);
            }
            else if(s.charAt(i)==')'){
                indexStart = parentisis.get(parentisis.size()-1);
                builder.replace(indexStart,i, String.valueOf(
                        new StringBuilder(builder.substring(indexStart,i)).reverse()));
                parentisis.remove(parentisis.size()-1);
            }
        }
        s =builder.toString();
        s= s.replaceAll("[)]{1}","");
        s= s.replaceAll("[(]{1}","");
        
        return s;

    }
}
