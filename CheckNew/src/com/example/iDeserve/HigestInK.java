package com.example.iDeserve;

public class HigestInK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 23, 12, 9, 30, 2, 50};
		
		int num = 6;
		boolean assigned = false;
		int temp = 0;
		int temp2 = 0;
		
		int[] arrHigh = new int[num];
		
		for(int i=0;i<arr.length;i++)
		{
			temp = 0;
			assigned = false;
			for(int j=0;j<arrHigh.length;j++)
			{
				if(arr[i]>arrHigh[j] && !assigned )
				{
					temp = arrHigh[j];
					arrHigh[j] = arr[i];
					assigned = true;
				}
				else if(temp != 0){
					if(temp>arrHigh[j])
					{
						temp2 = arrHigh[j];
						arrHigh[j] = temp;
						temp = temp2;
					}
				}
			}
		}
		for(int i = 0;i<arrHigh.length;i++)
		  {
			System.out.print(arrHigh[i]+"  ");  
		  }
	}

}
