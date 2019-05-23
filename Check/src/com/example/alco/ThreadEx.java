package com.example.alco;

public class ThreadEx implements Runnable{

	public ThreadEx(String name){
		Thread th = new Thread(this, name);
		
		th.start();
		
		try {
			th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(th.getName());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadEx newThread = new ThreadEx("ram");
	}
	@Override
	public void run() {
		
		
	}

}
