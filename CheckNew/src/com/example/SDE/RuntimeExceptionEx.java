package com.example.SDE;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.Reader;

public class RuntimeExceptionEx extends RuntimeException {

	
	public static void main(String[] args) throws InterruptedException {
		RuntimeExceptionEx ex = new RuntimeExceptionEx();
		System.out.println("Here");
		
		int i = 5;
		
		
		//PrintStream r = new PrintStream(arg0); 
		float j = i;
		j+=0.5;
		System.out.println(j);
		i =(int) j;
		i ='k';
		System.out.println(i);
		
		float k = ex.method(1.1f, 2.2f);
		try {
			ex.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("in catch");
		}
		for(int z=0;;z++)
		{
			Thread t = new Thread();
			t.start();
			t.sleep(Long.MAX_VALUE);
		}
	}
	
	public void method(int a)
	{
		
	}
	
	public void method(int a,int b)
	{
		System.out.println("in void");
	}
	
	public float method(float a,float b)
	{
		System.out.println("in float");
		return a;
	}
}

class ComplieTimeEx {
	
}
