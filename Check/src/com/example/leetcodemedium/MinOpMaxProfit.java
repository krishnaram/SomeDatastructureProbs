package com.example.leetcodemedium;

public class MinOpMaxProfit {

    public static void main(String[] s){
       /* System.out.println("Sample test passing is maxNumEdgesToRemove removed: " +
                (minOperationsMaxProfit(new int[]
                        {8,5},5,6) == 3)  + "\r\n");

        System.out.println("Sample test passing is maxNumEdgesToRemove removed: " +
                (minOperationsMaxProfit(new int[]
                        {10,9,6},6,4) == 7)  + "\r\n");

        System.out.println("Sample test passing is maxNumEdgesToRemove removed: " +
                (minOperationsMaxProfit(new int[]
                        {3,4,0,5,1},1,92)==-1) + "\r\n");
        System.out.println("Sample test passing is maxNumEdgesToRemove removed: " +
                (minOperationsMaxProfit(new int[]
                        {10,10,1,0,0},4,4)==5) + "\r\n");
       */ System.out.println("Sample test passing is maxNumEdgesToRemove removed: " +
                (minOperationsMaxProfit(new int[]
                        {0,43,37,9,23,35,18,7,45,3,8,24,1,6,37,2,38,15,1,14,39,27,4,25,27,33,43,8
                                ,44,30,38,40,20,5,17,27,43,11,6,2,30,49,30,25,32,3,18,23,45,43,30
                                ,14,41,17,42,42,44,38,18,26,32,48,37,5,37,21,2,9,48,48,40,45,25,30
                                ,49,41,4,48,40,29,23,17,7,5,44,23,43,9,35,26,44,3,26,16,31,11,9,4,28
                                ,49,43,39,9,39,37,7,6,7,16,1,30,2,4,43,23,16,39,5,30,23,39,29,31,26
                                ,35,15,5,11,45,44,45,43,4,24,40,7,36,10,10,18
                                ,6,20,13,11,20,3,32,49,34,41,13,11,3,13,0,13,44,48,43,23,12,23,2},43,54)==993) + "\r\n");
    }

    public static int  minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int higestProfit =0;
        int higestProfitRotate =0;
        int profit= 0;
        int waiting= 0;
        int customerOnBoard =0;
        int rotate =0;
        for(int i=0;i<customers.length;i++){
            if(customers[i]<=4 && customers[i]>0){
                rotate++;
                if(customers[i]+waiting>4){
                    waiting = waiting + customers[i]-4;
                    customerOnBoard = 4+customerOnBoard;
                    profit = (boardingCost*customers[i]) -(rotate*runningCost);
                }
                else{
                    customerOnBoard = customers[i]+customerOnBoard +waiting;
                    profit = (boardingCost*customers[i]) -(rotate*runningCost);
                }
                if(profit>higestProfit){
                    higestProfit = profit;
                    higestProfitRotate = rotate;
                }

            }
            else if(customers[i]>=4 || waiting>0){
                waiting = waiting + customers[i]-4;
                rotate++;
                customerOnBoard = 4+customerOnBoard;
                profit = (boardingCost*customerOnBoard) -(rotate*runningCost);
                if(profit>higestProfit){
                    higestProfit = profit;
                    higestProfitRotate = rotate;
                }
            }
        }
        while(waiting>4){
            rotate++;
            customerOnBoard = 4+customerOnBoard;
            profit = (boardingCost*customerOnBoard) -(rotate*runningCost);
            waiting = waiting-4;
            if(profit>higestProfit){
                higestProfit = profit;
                higestProfitRotate = rotate;
            }
        }
        if(waiting>=1){
            rotate++;
            customerOnBoard = waiting+customerOnBoard;
            profit = (boardingCost*customerOnBoard) -(rotate*runningCost);
            waiting = 0;
            if(profit>higestProfit){
                higestProfit = profit;
                higestProfitRotate = rotate;
            }
        }
        if(higestProfit<=0){
            return -1;
        }
        return higestProfitRotate;
    }
}
