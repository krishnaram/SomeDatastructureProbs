package com.example.tg;

import java.io.IOException;
import java.util.Scanner;

public class BinaryNumberPow {

	public static void main(String args[]) throws Exception {
		/*
		 * Read input from stdin and provide input before running Use either of
		 * these methods for input
		 * 
		 * //BufferedReader BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String line = br.readLine(); int N =
		 * Integer.parseInt(line);
		 */
		// Scanner
		
		Scanner s = new Scanner(System.in);
	
		//it wont throw any exception 
		IOException d = new IOException();
		
			int T = s.nextInt();
			int[] numbers = new int[T];
			for (int i = 0; i < T; i++) {
				numbers[i] = s.nextInt();
			}
			long startTime = System.currentTimeMillis();
			// code

			StringBuilder rev = new StringBuilder();
			StringBuilder original = new StringBuilder();
			int binaryNumber = 0;
			int counterNumber = 1;
			
//			for(int j=1;j<=100;j++)
//			{
//				System.out.println(j);
//			}
			String binary;

		/*	for (int i = 0; i < numbers.length; i++) {
				switch(numbers[i])
				{
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				default:
					
					break;
					
				}
			}*/
			
			
			// So that numbers can be in order
			
			int counterAddition = 2;
			int counter = 4;
			int pow = 3;
			boolean counterDouble = false;
			//boolean conditionDouble = false;

			for (int i = 0; i < numbers.length; i++) {
				 
				if(numbers[i]>4)
				{
					while(counter<numbers[i])
					{
						
						if(!counterDouble){
							counter+=counterAddition;
							pow++;
							counterDouble= !counterDouble;
						}
						
						else if(counterDouble ){
							pow++;
							counterAddition = 2*counterAddition;
							counter+=counterAddition;
							counterDouble= !counterDouble;
							
							
						}
						
					}
					
					pow--;
					counterNumber =(int)Math.pow(2, pow)+1;
					binaryNumber = counter-counterAddition;
				}
				// System.out.println(numbers[i]+" number array");
				//counterNumber++;

				while (binaryNumber <= numbers[i]) {
					rev = new StringBuilder();
					original = new StringBuilder();
					
					
					binary = Integer.toBinaryString(counterNumber);
					
					original.append(binary);
					rev.append(binary);

					if (original.reverse().toString().equals(rev.toString())) {
						binaryNumber++;
						if (binaryNumber == numbers[i]) {
							System.out.println(binaryNumber+" "+counterNumber+" "+original);
							counterNumber+=2;
							break;
						}
					}
					counterNumber+=2;

				}
			}
			long endTime = System.currentTimeMillis();
			System.out.println("Took " + (endTime - startTime) + " ms");
		

		// System.out.println("Hello World!");
	}
}
