package com.example.iDeserve;

public class Merge2ArraySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int mPlusN[] = {2, 8,0,0,0,13, 0,15, 20};
		  int n[] = {5, 7, 9, 25};
		  
		  int[] mPNSorted = new int[mPlusN.length];
		  int nextI = 0;
		  int nextJ = 0;
		  boolean brk = false;
		  for(int i = 0;i<mPlusN.length;i++)
		  {
			  if(mPlusN[i] != 0)
			  {
				  for(int j=nextJ;j<n.length;j++)
				  {
					  
					  if(mPlusN[i]<n[j] )
					  {
						  mPNSorted[i] = mPlusN[i]; 
						  nextI = i+1;
						  break;
					  }
					  else if( mPlusN[i] > n[j]){
						  mPNSorted[i] = n[j];
						  nextJ = j+1;
						  break;
					  }
					  
				  }
			  }
			  else{
				  for(int k = nextI;k<mPlusN.length;k++)
				  {
					  if( mPlusN[k] != 0)
					  {
						  for(int j=nextJ;j<n.length;j++)
						  {
							 // System.out.println("When 0 "+ mPlusN[k]+" "+n[j]);
							  if(mPlusN[k]<n[j] )
							  {
								  mPNSorted[i] = mPlusN[k];
								  nextI = k+1;
								  break;
							  }
							  else{
								  mPNSorted[i] = n[j];
								  nextJ = j+1;
								  brk = true;
								  break;
								  
							  }
						  }
						  if(brk)
							  break; 
					  }
					 
					  
				  }
			  }
			  
		  }
		  
		  moveToEnd(mPlusN, mPlusN.length);
		  
	        /*Merge N[] into mPlusN[] */
	        merge(mPlusN, n, mPlusN.length-n.length, n.length);
	 
		  for(int i = 0;i<mPlusN.length;i++)
		  {
			System.out.print(mPNSorted[i]+"  ");  
		  }

	}
	
	static void moveToEnd(int mPlusN[], int size) 
    {
        int i, j = size - 1;
        for (i = 0; i <size-1; i++) 
        {
            if (mPlusN[i] == 0) 
            {
                mPlusN[i] = mPlusN[i+1];
                mPlusN[i+1] = 0;
            }
        }
    }
 
    /* Merges array N[] of size n into array mPlusN[]
       of size m+n*/
	static void merge(int mPlusN[], int N[], int m, int n) 
    {
        int i = n;
         
        /* Current index of i/p part of mPlusN[]*/
        int j = 0;
         
        /* Current index of N[]*/
        int k = 0;
         
        /* Current index of of output mPlusN[]*/
        while (k < (m + n)) 
        {
            /* Take an element from mPlusN[] if
            a) value of the picked element is smaller and we have
                not reached end of it
            b) We have reached end of N[] */
            if ((i < (m + n) && mPlusN[i] <= N[j]) || (j == n)) 
            {
                mPlusN[k] = mPlusN[i];
                k++;
                i++;
            } 
            else // Otherwise take element from N[]
            {
                mPlusN[k] = N[j];
                k++;
                j++;
            }
        }
    }

}
