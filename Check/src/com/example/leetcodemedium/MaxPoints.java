package com.example.leetcodemedium;

public class MaxPoints {

    public static void main(String[] str){
        int sum =0, i=0;

        while(i<100){
            sum = sum +i;
            sum = i+sum;
            i+=1;
        }
        System.out.println(fun(100,2000)+" ");
        System.out.println(fib(6)+" ");
        for(int ind=0;ind<6;ind++){
            System.out.print(printTribeRC(ind)+" ");
        }
        System.out.println(sum);
        System.out.println("Sample test passing maxPoints change: " + maxPoints(new int[][] {{1,2,3},{1,5,1},{3,1,1}}) + "\r\n");
        System.out.println("Sample test passing maxPoints change: " + maxPoints(new int[] []{{1,5},{2,3},{4,2}}) + "\r\n");
        System.out.println("Sample test passing maxPoints change: " + maxPoints(new int[] []{{1,5},{3,2},{4,2}})+ "\r\n");
        System.out.println("Sample test passing maxPoints change: " + maxPoints(new int[] []{{1,2,3},{1,5,1},{3,1,1}})+ "\r\n");
    }

    public static long maxPoints(int[][] points) {
        int max;
        int lastCol=0;
        int tempLastCol =0;
        int sum=0;
        for(int i=0;i<points.length;i++){

            max = Math.abs(points[i][0]-Math.abs(0-lastCol));
            tempLastCol =0;
            for(int j=0;j<points[i].length;j++){
                if(i==0){
                    if(Math.abs(points[i][j]-Math.abs(lastCol))>max){
                        max = Math.abs(points[i][j]-Math.abs(0));
                        tempLastCol=j;
                }}
                else if(Math.abs(points[i][j]-Math.abs(j-lastCol))>max){
                    max = Math.abs(points[i][j]-Math.abs(j-lastCol));
                    tempLastCol=j;
                }

            }
            lastCol = tempLastCol;
            System.out.println(max);
            sum +=max;
            //System.out.println(sum);
        }
        return sum;
    }

    public static int printTribeRC(int n){
        if(n==0 || n==1 || n==2){
            return 0;
        }
        if(n==3){
            return 1;
        }
        else
            return  printTribeRC(n-1)+printTribeRC(n-2)+printTribeRC(n-3);
    }

    public static int fib(int n) {
        if(n<=1){
            return  n;
        }
        return  fib(n-1)+fib(n-2);
    }

    public static int fun(int A, int B) {
        if(B==0){
            return  A;
        }
        else return fun(B,A%B);
    }
}
