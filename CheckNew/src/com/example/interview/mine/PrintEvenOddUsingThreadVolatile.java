package com.example.interview.mine;

public class PrintEvenOddUsingThreadVolatile implements Runnable {
	int max;
	boolean isEvenNumber;
	static volatile boolean isEven = false;
	
	public PrintEvenOddUsingThreadVolatile(int max, boolean isEvenNumber) {
		this.isEvenNumber =isEvenNumber;
		this.max = max;
	}
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new PrintEvenOddUsingThreadVolatile(100, false));
		Thread t2 = new Thread(new PrintEvenOddUsingThreadVolatile(100, true));
		
        t1.start();
        t2.start();
    }
	@Override
	public void run() {
		int number = isEvenNumber?2:1;
		while(number < max) {
			//if(isEvenNumber) {
				//synchronized (new Object()) {
					if(isEven && isEvenNumber ) {
						
						System.out.println("Even: "+number);
						isEven = false;
						number +=2;
						//notifyAll();
					}
					
				//}
				
			//}
			//else {
				//synchronized (new Object()) {
					else if(isEven != true && !isEvenNumber) {
						
						System.out.println("Odd: "+number);
						isEven = true;
						number +=2;
						//notifyAll();
					}
					
			//	}
				
			//}
			
		}
	}
	

}

