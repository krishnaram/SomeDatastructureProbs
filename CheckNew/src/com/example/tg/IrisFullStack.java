package com.example.tg;

import java.util.ArrayList;
import java.util.List;

public class IrisFullStack {

	public static void main(String[] args) {
		//The output pipes connection 
		int[] input = {5,6,7,10}; //2,3,4,6
		int[] pipes = getJoinedPipes(input);
		
		for(int i=0;i<pipes.length;i++){
			System.out.println(pipes[i]);
		}
		
	}
	
	public static int[] getJoinedPipes(int[] input)
    {
		List<Integer> output = new ArrayList<Integer>(); 
		int temp;
		int[] outputArray = null;
		if(input.length<1)
		{
			return input;
		}
		if(input.length>1)
		{
			//Ascending order
			for(int i=0;i<input.length;i++) {
				for(int j=i+1;j<input.length;j++) {
					if(input[j]<input[i]) {
						temp = input[i];
						input[i] = input [j];
						input[j] = temp;
					}
				}
			}
			
			int lenPipe = input[0]+input[1];
			output.add(lenPipe);
			for(int i= 2; i<input.length;i++){
				if(i+1<input.length)
				{
					temp = input[i]+input[i+1];
					if(temp<lenPipe+input[i])
					{
						input[i+1] = lenPipe;
						lenPipe = temp;
						
					}
					else {
						lenPipe = lenPipe+input[i];
					}
				}
				else {
					lenPipe = lenPipe+input[i];
				}
				output.add(lenPipe);
			}
			 outputArray =new int[output.size()];
			for(int i =0;i<outputArray.length;i++)
			{
				outputArray[i] = output.get(i);
			}
		}
		else {
			outputArray = input;
		}
		
		return outputArray;
	}

}
