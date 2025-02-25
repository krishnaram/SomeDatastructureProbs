package com.example.leetcodemedium;

public class FindMaxFish {

    public static void main(String[] s){
      System.out.println("Sample test passing is all integers range covered: " +
                (findMaxFish(new int[][]
                        {{0,2,1,0}
                        ,{4,0,0,3}
                        ,{1,0,0,4}
                        ,{0,3,2,0}}) == 7)  + "\r\n");
        System.out.println("Sample test passing is all integers range covered: " +
                (findMaxFish(new int[][]
                        {{ 8,6},{2,6}}) == 22)  + "\r\n");
        System.out.println("Sample test passing is all integers range covered: " +
                (findMaxFish(new int[][]
                        {{ 4,5,5},{0,10,0}}) == 24)  + "\r\n");
    }

    public static int findMaxFish(int[][] grid) {
        boolean[][] visited;
        int maxFish =0;
        int count;

        for(int i=0;i<grid.length;i++){
            visited = new boolean[grid.length][grid[i].length];
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] >=1){
                    visited[i][j]=true;
                    count=dfs(grid,visited,grid[i][j],i,j);
                    if(count>maxFish){
                        maxFish = count;
                    }
                }
            }
        }
        return maxFish;
    }

    public static int dfs(int[][] grid,boolean[][] visited, int count,int row, int col){
        int runningCount = count;
        int max = count;
        if(row+1<grid.length){
            if(!visited[row+1][col] && grid[row+1][col] >=1){
                visited[row+1][col] = true;
                runningCount = runningCount+ dfs( grid, visited,  grid[row+1][col],row+1,col);
                if(runningCount>max){
                    max = runningCount;
                }
            }
        }

        if(row-1>=0){
            if(!visited[row-1][col] && grid[row-1][col] >=1){
                visited[row-1][col] = true;
                runningCount = runningCount+dfs( grid, visited,  grid[row-1][col],row-1,col);
                if(runningCount>max){
                    max = runningCount;
                }
            }
        }
        if(col-1>=0){
            if(!visited[row][col-1] && grid[row][col-1] >=1){
                visited[row][col-1] = true;
                runningCount = runningCount+dfs( grid, visited,  grid[row][col-1],row,col-1);
                if(runningCount>max){
                    max = runningCount;
                }
            }
        }
        if(col+1<grid[row].length){
            if(!visited[row][col+1] && grid[row][col+1] >=1){
                visited[row][col+1] = true;
                runningCount = runningCount+dfs( grid, visited,  grid[row][col+1],row,col+1);
                if(runningCount>max){
                    max = runningCount;
                }
            }
        }


        return max;
    }
}
