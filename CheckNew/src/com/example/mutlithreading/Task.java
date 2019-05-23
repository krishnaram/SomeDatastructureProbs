package com.example.mutlithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<String> {
    private String name;
    private int number;
 
    public Task(String name,int number) {
        this.name = name;
        this.number = number;
    }
 
    public String getName() {
        return name;
    }
 
    public void run() {
        try {
            Long duration = 2l;
            System.out.println("Executing : " + name);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	@Override
	public String call() throws Exception  {
		if(Thread.currentThread().getName() != null || Thread.currentThread().getName().trim().length()>0) {
		
			System.out.println("Already assigned Thread name: "+Thread.currentThread().getName());
		}
		else {
			Thread.currentThread().setName(this.name);
			System.out.println("First time assigning Thread name: "+Thread.currentThread().getName());
		}
		 try {
			 	if(number%5 ==0)
			 	{
			 		int i = 1/0;
			 	}
	            Long duration = 2l;
	          //  System.out.println("Executing : " + name);
	            TimeUnit.SECONDS.sleep(duration);
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new Exception();
	        }
		return name;
	}
}
