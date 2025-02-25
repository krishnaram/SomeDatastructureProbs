package com.example.leetcodeeasy;

public class LemonadeChange {

    public static void main(String[] str){
        System.out.println("Sample test passing lemonade change: " + lemonadeChange(new int[] {5,5,10,10,20}) + "\r\n");
        System.out.println("Sample test passing lemonade change: " + lemonadeChange(new int[] {5,5,5,10,20}) + "\r\n");
    }

    public static boolean lemonadeChange(int[] bills) {
        int five_dollars = 0, ten_dollars = 0;

        for (int x : bills) {
            if (x == 5) {
                five_dollars++;
            } else if (x == 10) {
                if (five_dollars > 0) {
                    five_dollars--;
                    ten_dollars++;
                } else {
                    return false;
                }
            } else {
                if (five_dollars > 0 && ten_dollars > 0) {
                    five_dollars--;
                    ten_dollars--;
                } else if (five_dollars > 2) {
                    five_dollars -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
