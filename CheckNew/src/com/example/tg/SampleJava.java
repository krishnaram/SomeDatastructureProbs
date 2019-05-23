package com.example.tg;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SampleJava  extends Exception{

	public SampleJava(int i){
		System.out.println("new exception");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			
			System.out.println(15>>1);
			System.out.println(call());
			
		} catch (SampleJava e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int call() throws SampleJava
	{
		try{
			System.out.println("new");
			int i= 1/0;
			//return 0;
		}catch(ArithmeticException e)
		{
			//e.printStackTrace();
			throw new ArrayIndexOutOfBoundsException();
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			return 1;
		}
		finally{
			throw new SampleJava(0);
		}
	
		
	}
	

}
