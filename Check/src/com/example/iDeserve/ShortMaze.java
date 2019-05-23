package com.example.iDeserve;

import java.util.Arrays;

public class ShortMaze {
	int[][] maze;
	int[][] solution;
	int minDistance = 0;
	
	public ShortMaze(int[][] maze)
	{
		this.maze = maze;
		solution = new int[this.maze.length][this.maze[0].length];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	        int maze[][] = {
	        	{1, 1, 1, 1},
	            {1, 1, 1, 1},
	            {0, 1, 1, 0},
	            {1, 0, 1, 1}
	        };
	        ShortMaze rat = new ShortMaze(maze);
	        
	        int x = 4;
	        int y = 4;
	        if(maze[0][0] == 1)
	        {
	        	int[][] solution = new int[rat.maze.length][rat.maze[0].length];
	        	solution[0][0] = 1;
	        	rat.solveMaze(x-1,y-1,0,0,1,solution);
	        }
	        rat.printSolution(rat.solution);
	        
	}

	private void solveMaze(int x,int y,int startX,int startY,int distance,int[][] path) {
		int[][] interPath;
		if(isSafe(startX,startY))
		{
			if(this.maze[startX][startY] == 1)
			{
				path[startX][startY]=1;
				if(startX == x && startY== y)
				{
					if(minDistance == 0 || minDistance <distance)
					{
						minDistance = distance;
						for(int i=0;i<path.length;i++)
						{
							for(int j=0;j<path[i].length;j++)
							{
								this.solution[i][j] = path[i][j];
							}
						}
						
					}
				}
				
				interPath = path;
				solveMaze(x,y,startX+1,startY,distance+1,path);
				
				//path[startX+1][startY]= 0;
				//System.out.println("After next row");
				//printSolution(path);
				solveMaze(x,y,startX,startY+1,distance+1,interPath);
				//path[startX][startY+1]=0;
				//System.out.println("After next col");
				//printSolution(path);
				path[startX][startY]=0;
			}
		}
		
		
		
		
	}
	
	public boolean isSafe(int x,int y){
		if(x<this.maze.length && y<this.maze[x].length)
		{
			return true;
		}
		return false;
	}
	
	 void printSolution(int sol[][])
	    {
	        for (int i = 0; i < sol.length; i++)
	        {
	            for (int j = 0; j < sol[i].length; j++)
	                System.out.print(" " + sol[i][j] +
	                                 " ");
	            System.out.println();
	        }
	    }

}
