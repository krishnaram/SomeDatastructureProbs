package com.example.iDeserve;

class Table{  
	 synchronized void printTable(int n){//synchronized method  
	   for(int i=1;i<=5;i++){  
	     System.out.println(n*i);  
	     try{  
	      Thread.sleep(400);  
	     }catch(Exception e){System.out.println(e);}  
	   }  
	  
	 }  
	 void notSyncTable(int n){//synchronized method  
		   for(int i=1;i<=5;i++){  
		     System.out.println(n*i);  
		     try{  
		      Thread.sleep(400);  
		     }catch(Exception e){System.out.println(e);}  
		   }  
		  
		 }  
	}  
	  
	public class TestSynchronization3{  
	public static void main(String args[]){  
	final Table obj = new Table();//only one object  
	  
	Thread t1=new Thread(){  
	public void run(){  
		obj.notSyncTable(15);
	obj.printTable(5);  
	
	}  
	};  
	Thread t2=new Thread(){  
	public void run(){  
		obj.notSyncTable(150);
	obj.printTable(100);  
	}  
	};  
	  
	t1.start();  
	t2.start();  
	}  
	}  
