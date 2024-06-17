package com.example;

public class FinalVar {

    public static void main(String[] args){
        final int i =100;
        //i =102;  compile time error
        System.out.println(i);
    }
}
