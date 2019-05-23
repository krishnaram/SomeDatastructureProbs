package com.example.iDeserve;

public class TestClass implements TestInterface, Runnable{
	
	int[] number;
	String str;
	
	static int staticMember;
	public void display(){
		
		System.out.println(this.str);
		
	}
	
	public TestClass(String str){
		
		this.str = str;
		System.out.println(this.str);
		
	}
	
	public TestClass(int[] number){
		this.number = number;
		
	}
 interface TestInterface2{
	 
 }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =0 ;i<this.number.length;i++)
		{
			System.out.println(this.number[i]+" Thread Name:"+Thread.currentThread().getName());
		}
	}

public static void main(String[] args) {
	TestInterface.Test i = new Test();
	
	System.out.println("Display odd and even numbers from 2 threads");
	int[] odd = new int[50];
	int[] even = new int[50];
	int eCount = 0;
	int oCount = 0;
	for(int i1 = 1;i1<= 100;i1++)
	{
		if(i1%2 == 0)
		{
			even[eCount++] = i1;
		}
		else
		{
			odd[oCount++] = i1;	
		}
		
	}
	
	Thread t1 = new Thread(new TestClass(even),"Even thread");//= new Thread(new )
	Thread t2 = new Thread(new TestClass(odd),"Odd thread");
	t1.start();
	t2.start();

}
}
