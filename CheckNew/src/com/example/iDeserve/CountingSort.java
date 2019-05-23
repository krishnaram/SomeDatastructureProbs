package com.example.iDeserve;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


class CountingSort extends HashSet<BinarySerachTree>

{
	
	public static void main(String[] args) throws IOException {
		
		List<Integer> number = Arrays.asList(9,10,3,4,7,3,4);
		//List<Integer> distinct = number.stream()
		String obj = "abc";
		byte[] b = obj.getBytes();
		ByteArrayInputStream b1 = new ByteArrayInputStream(b);
		
		for(int i=0;i<2;++i){
			int c;
			while((c=b1.read()) != -1)
			{
				if(i==0)
				{
					System.out.println(Character.toUpperCase((char)c));
				}
			}
		}
		
		CountingSort c = new CountingSort();
		c.add(new BinarySerachTree());
		 System.out.println("Before Sorting : ");
		 int arr[]={1,4,7,3,4,5,6,3,4,8,6,4,4};
		 System.out.println(Arrays.toString(arr));
		 arr=countingSort(arr);
		 System.out.println("=======================");
		 System.out.println("After Sorting : ");
		 System.out.println(Arrays.toString(arr));
		 }
		 
		 static int[] countingSort(int arr[])
		 {
		 int n = arr.length;
		 
		 // The result will store sorted array
		 int result[] = new int[n];
		 
		 // Initialize count array with 9 as array contains elements from range 1 to 8.
		 int count[] = new int[9];
		 for (int i=0; i<9; ++i)
		 count[i] = 0;
		 
		 // store count of each element in count array
		 for (int i=0; i<n; ++i)
		 ++count[arr[i]];
		 

		 System.out.println("------------------------------------------------------");
		 System.out.println(Arrays.toString(count));
		 System.out.println("------------------------------------------------------");
		 
		 // Change count[i] so that count[i] now contains actual
		 // position of this element in output array
		 for (int i=1; i<=8; ++i)
		 count[i] += count[i-1];
		 
		 System.out.println("------------------------------------------------------");
		 System.out.println(Arrays.toString(count));
		 System.out.println("------------------------------------------------------");
		 
		 for (int i = 0; i<n; ++i)
		 {
			System.out.println(count[arr[i]]-1+" "+i+" "+arr[i]);
		 result[count[arr[i]]-1] = arr[i];
		 --count[arr[i]];
		 }
		 System.out.println("------------------------------------------------------");
		 return result;
		 }
}
