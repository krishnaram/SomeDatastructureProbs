package com.example.iDeserve;

public class Hamilton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Hamilton();
		/* Let us create the following graph
		(0)--(1)--(2)
		|   / \   |
		|  /   \  |
		| /     \ |
		(3)-------(4)    */
		int graph1[][] = {{0, 1, 0, 1, 0},
		{1, 0, 1, 1, 1},
		{0, 1, 0, 0, 1},
		{1, 1, 0, 0, 1},
		{0, 1, 1, 1, 0},
		};
		
		// Print the solution
		Hamilton.hamCycle(graph1);
		
		/* Let us create the following graph
		(0)--(1)--(2)
		|   / \   |
		|  /   \  |
		| /     \ |
		(3)       (4)    */
		int graph2[][] = {{0, 1, 0, 1, 0},
		{1, 0, 1, 1, 1},
		{0, 1, 0, 0, 1},
		{1, 1, 0, 0, 0},
		{0, 1, 1, 0, 0},
		};
		
		// Print the solution
		Hamilton.hamCycle(graph2);
	}

	private static void hamCycle(int[][] graph1) {
		// TODO Auto-generated method stub
		
		int[] path = new int[graph1[0].length];
		path[0] = 1;
		
		
	}

}
