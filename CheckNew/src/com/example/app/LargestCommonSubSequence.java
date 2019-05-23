package com.example.app;

public class LargestCommonSubSequence {

	public static void main(String[] args)
	{
		LargestCommonSubSequence lcs = new LargestCommonSubSequence();
	    String s1 = "AGGTAB";
	    String s2 = "GXTXAYB";
	 
	    char[] X=s1.toCharArray();
	    char[] Y=s2.toCharArray();
	    int m = X.length;
	    int n = Y.length;
	 
	    System.out.println("Length of LCS is" + " " +
	                                  lcs.lcs( X, Y, m, n ) );
	  }

	private int lcs(char[] x, char[] y, int m, int n) {
		if (m == 0 || n == 0)
		      return 0;
		    if (x[m-1] == y[n-1])
		      return 1 + lcs(y, y, m-1, n-1);
		    else
		      return max(lcs(y, y, m, n-1), lcs(y, y, m-1, n));
	}
	
	/* Utility function to get max of 2 integers */
	  int max(int a, int b)
	  {
	    return (a > b)? a : b;
	  }
}
