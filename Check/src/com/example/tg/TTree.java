package com.example.tg;

import java.util.Stack;

public class TTree {
	/* input1 A#S
	 * 		  S#A	
	 * 
	 * input2 AS
	 * 
	 * Finding AS in matrix upward backward downward diagonal as you need 
	 * Here output is 2(Number of times it repeated)
	 * */
	public Stack<TTree> stack = new Stack<TTree>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String[] matrixString = {"E#D#E#E#E"
								,"D#I#S#K#E"
								,"E#S#E#E#E"
								,"E#C#E#E#E"
								,"E#E#E#E#E"};
								For disk*/
		String[] matrixString = {"A#s#A"
								,"A#s#A"
								,"A#s#A"};
		
		int result = word_count(matrixString, "AA");
		System.out.println(result);
	}

	public static int word_count(String[] input1,String input2)
    {
		String[][] matrixString = new String[input1.length][input1.length];
		
		int output = 0;
		//Splitting line by line
		int i = 0;
		int j = 0;
		String[] lineArray;
		//Adding into matrix string
		for(String line:input1)
		{
			j = 0;
			lineArray = line.split("#");
			for(String ele:lineArray)
			{
				//System.out.println(ele);
				matrixString[i][j] = ele;
				j++;
			}
			i++;
		}
		for(int k=0;k<input1.length;k++)
		{
			for(int l=0;l<input1.length;l++)
			{
				System.out.print(matrixString[k][l]+" ");
			}
			System.out.println("");
		}
		
		for(int k=0;k<input1.length;k++)
		{
			for(int l=0;l<input1.length;l++)
			{
				if(input2.contains(matrixString[k][l]))
				{
					//If having only one character
					if(input2.equals(matrixString[k][l]))
					{
						output++;
					}
					else{
						if(leftToRight(matrixString,matrixString[k][l],input2,k,l))
						{
							
							output++;
						}
						if(downWard(matrixString,matrixString[k][l],input2,k,l))
						{
							
							output++;
						}
						if(daigonal(matrixString,matrixString[k][l],input2,k,l))
						{
							
							output++;
						}
					}
					
				}
			}
			
		}
		return output;
    }
	
	 public static boolean leftToRight(String[][] matrixString,String buildString,String matchString,int row,int col)
	 {
		StringBuilder buildStringBuilder = new StringBuilder(buildString);
		boolean found = false;
		if(matchString.equals(buildString))
		{
			return true;
		}
		else if(col == matrixString[0].length-1)
		{
			return found;
		}
		else{
			
			for(int l=col+1;l<matrixString.length;l++)
			{
				buildStringBuilder.append(matrixString[row][l]);
				if(matchString.contains(buildStringBuilder.toString()))
				{
					if(matchString.equals(buildStringBuilder.toString()))
					{
						found = true;
						break;
					}
					
				}
				else{
					break;
				}
			}
		}
		
		return found;
	 }
	 
	 public static boolean downWard(String[][] matrixString,String buildString,String matchString,int row,int col)
	 {
		 	StringBuilder buildStringBuilder = new StringBuilder(buildString);
			boolean found = false;
			if(matchString.equals(buildString))
			{
				return true;
			}
			else if(row == matrixString[0].length-1)
			{
				return found;
			}
			else{
				
				for(int l=row+1;l<matrixString.length;l++)
				{
					buildStringBuilder.append(matrixString[l][col]);
					if(matchString.contains(buildStringBuilder.toString()))
					{
						if(matchString.equals(buildStringBuilder.toString()))
						{
							found = true;
							break;
						}
						
					}
					else{
						break;
					}
				}
			}
			return found;
	 }
	 
	 public static boolean daigonal(String[][] matrixString,String buildString,String matchString,int row,int col)
	 {
		 	int orgCol = col;
		 	StringBuilder buildStringBuilder = new StringBuilder(buildString);
			boolean found = false;
			if(matchString.equals(buildString))
			{
				return true;
			}
			else{
				buildStringBuilder = new StringBuilder(buildString);
				if(row == orgCol || (row == matrixString.length-1 && col == 0 ) || (row == 0 && col == matrixString.length-1 ))
				{
						col = orgCol;
						col++;
						//Here
						//row++ col++
						for(int l=row+1;l<matrixString.length;l++)
						{
							if(col==matrixString.length)
							{
								break;
							}
							buildStringBuilder.append(matrixString[l][col++]);
							if(matchString.contains(buildStringBuilder.toString()))
							{
								if(matchString.equals(buildStringBuilder.toString()))
								{
									found = true;
									break;
								}
							}
							else{
								break;
							}
						}
						buildStringBuilder = new StringBuilder(buildString);
						col = orgCol;
						col--;
						//Here
						//row-- col--
						for(int l=row-1;l>=0;l--)
						{
							if(col == -1)
							{
								break;
							}
							buildStringBuilder.append(matrixString[l][col--]);
							if(matchString.contains(buildStringBuilder.toString()))
							{
								if(matchString.equals(buildStringBuilder.toString()))
								{
									found = true;
									break;
								}
							}
							else{
								break;
							}
						}
						buildStringBuilder = new StringBuilder(buildString);
						col = orgCol;
						col--;
						//Here
						//row++ col--
						for(int l=row+1;l<matrixString.length;l++)
						{
							if(col == -1)
							{
								break;
							}
							buildStringBuilder.append(matrixString[l][col--]);
							if(matchString.contains(buildStringBuilder.toString()))
							{
								if(matchString.equals(buildStringBuilder.toString()))
								{
									found = true;
									break;
								}
							}
							else{
								break;
							}
						}
						buildStringBuilder = new StringBuilder(buildString);
						col = orgCol;
						col++;
						//Here
						//row-- col++
						for(int l=row-1;l>=0;l--)
						{
							if(col==matrixString.length)
							{
								break;
							}
							buildStringBuilder.append(matrixString[l][col++]);
							if(matchString.contains(buildStringBuilder.toString()))
							{
								if(matchString.equals(buildStringBuilder.toString()))
								{
									found = true;
									break;
								}
							}
							else{
								break;
							}
						}
					
					
					
				}
				
				
			}
			return found;
		 
	 }
}
