package com.example.tg;

import java.util.Scanner;

public class BinaryNumberTimeEff {

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
			

			// So that numbers can be in order

			for (int i = 0; i < numbers.length; i++) {
				 System.out.println(
						 getBinaryPalindrom(numbers[i]) );
			}
			long endTime = System.currentTimeMillis();
			System.out.println("Took " + (endTime - startTime) + " ms");
	}
	public static int getBinaryPalindrom(int N) {
	    if (N < 4) {
	        switch (N) {
	            case 1:
	                return 1;
	            case 2:
	                return 3;
	            case 3:
	                return 5;
	        }
	        throw new IndexOutOfBoundsException("You need to supply N >= 1");
	    }
	    // second highest to keep the right length (highest is always 1)
	    final int bitAfterHighest = (N >>> (Integer.SIZE - Integer.numberOfLeadingZeros(N) - 2)) & 1;
	    // now remove the second highest bit to get the left half of our palindrom
	    final int leftHalf = (((N >>> (Integer.SIZE - Integer.numberOfLeadingZeros(N) - 1)) & 1) << (Integer.SIZE -
	            Integer.numberOfLeadingZeros(N) - 2)) | ((N << (Integer.numberOfLeadingZeros(N) + 2)) >>> (Integer.numberOfLeadingZeros(N) + 2));
	    // right half is just the left reversed
	    final int rightHalf = Integer.reverse(leftHalf);
	    if (Integer.numberOfLeadingZeros(N) < Integer.SIZE / 2) {
	        throw new IndexOutOfBoundsException("To big to fit N=" + N + " into an int");
	    }
	    if (bitAfterHighest == 0) {
	        // First uneven-length palindromes
	        return (leftHalf << (Integer.SIZE - Integer.numberOfLeadingZeros(leftHalf)) - 1) | (rightHalf
	                >>> Integer.numberOfTrailingZeros(rightHalf));
	    } else {
	        // Then even-length palindromes
	        return (leftHalf << (Integer.SIZE - Integer.numberOfLeadingZeros(leftHalf))) | (rightHalf
	                >>> Integer.numberOfTrailingZeros(rightHalf));
	    }
	}
}
