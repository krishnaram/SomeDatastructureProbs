package com.example.sg;

public class NullException {

	public static void print(Exception e){
		
	}
	
	public static void print(ArithmeticException ae){
		
	}
	
	public static void print(Object obj){
		System.out.println("Object printed");
	}
	
	public static  void main(String[] args) throws InterruptedException {
		//It prints nothing
		print(null);
		//Interrupted exception occurs
		/*Thread t = new Thread();
		t.start();
		System.out.println("hi how are you");
		t.wait();
		*/
		
	}

}
