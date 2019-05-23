package com.example.app;

import java.util.ArrayList;

public class ThreadSharingObject implements Runnable {

	static ArrayList<Integer>arrayList = new ArrayList<Integer>();
	int limit;
	static volatile int  count;
	boolean flag;
	
	public ThreadSharingObject(boolean flag,int limit)
	{
		this.flag = flag;
		this.limit = limit;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//for even numbers
		ThreadSharingObject th = new ThreadSharingObject(true,50);
		ThreadSharingObject thNew = new ThreadSharingObject(false,50);
		
		Thread t = new Thread(th,"even");
		Thread tNew = new Thread(thNew,"Odd");
		
		NewThread n = new NewThread();
		Thread t2 = new Thread(n,"object n");
		t2.start();
		
		Thread t3 = new Thread(n,"same object n");
		t3.start();
		
		Thread t4 = new Thread(n,"same object n");
		t4.start();
		
		t.start();
		tNew.start();
	}

	@Override
	public void run() {
		while(count <= limit)
		{
			if(flag  && count%2 ==0)
			{
				System.out.println(count+" Thread name "+Thread.currentThread().getName());
				count++;
			}
			else if(!flag && count%2 !=0 ){
				System.out.println(count+" Thread name "+Thread.currentThread().getName());
				count++;
			}
		}
		
	}

}
class NewThread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
		this.notify();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
