package com.example.alco;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Parent {
	int x ;

	public Parent(){
		System.out.println("In A constructor");
	}
	public Parent(int value){
		System.out.println("In A constructor"+value);
	}
	public static void display() throws IOException{
		System.out.println("not sure A");
		}
	public void fun(){
		System.out.println("Original fun");
	}
}
