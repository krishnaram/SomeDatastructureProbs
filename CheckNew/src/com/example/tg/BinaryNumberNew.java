package com.example.tg;

import java.util.Scanner;

public class BinaryNumberNew {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		int[] numbers = new int[T];
		for (int i = 0; i < T; i++) {
			numbers[i] = s.nextInt();
		}
		// code
		int binaryNumber = 0;
		int counterNumber = 1;
		

		int temp = 0;
		for (int i = 0; i < numbers.length; i++) {
			while (binaryNumber <= numbers[i]) {
				
				
				if (isBinaryPalindrome(counterNumber)) {

					binaryNumber++;
					if (binaryNumber == numbers[i]) {
						System.out.println(counterNumber);
						counterNumber+=2;
						break;
					}
				}
				counterNumber+=2;

			}

		}
	
	// System.out.println("Hello World!");
	}
	
	public static boolean isBinaryPalindrome ( int num ){
		  int numOfBits = (int) (Math.floor( ( Math.log( num )/Math.log(2)) ) + 1);
		  int left = 0;
		  int right = numOfBits - 1; 
		  while( left < right ){
		    if( isBitSet( num, numOfBits - left ) != isBitSet( num, numOfBits-right )  ) {
		      return false;
		    }
		    left++;
		    right--;
		  }
		  return true;
		}

	public static boolean isBitSet( int num, int index ){
		  return ( num & (1 << (index - 1 ) ) ) != 0;
		}
}
