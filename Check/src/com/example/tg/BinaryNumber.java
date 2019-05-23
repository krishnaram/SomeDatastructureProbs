package com.example.tg;

import java.io.IOException;
import java.util.Scanner;

public class BinaryNumber {

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

			for (int i = 0; i < numbers.length; i++) {

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
/*
 * if(counterNumber == 1 ) { if(numbers[i] == 1) {
 * System.out.println(counterNumber); binaryNumber++; counterNumber++; continue;
 * }
 * 
 * binaryNumber++; counterNumber++;
 * 
 * }
 */
// System.out.println(" original "+original+" reverse "+rev);
// System.out.println(counterNumber);
// System.out.println(binaryNumber+" binary number and "+counterNumber+" counterNumber");
// System.out.println(counterNumber);