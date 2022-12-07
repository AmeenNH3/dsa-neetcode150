package com.dsa.slidingwindow;

public class BuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit2(new int[] {7,1,5,3,6,4,0,9}));
    }

    //Brute Force Approach
    public static int maxProfit(int[] prices) {
        int len = prices.length;

        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0 ; i<len;i++){
            for(int j = i + 1;j<len;j++){
                int profit = prices[j] - prices[i];
                if(maxProfit < profit) maxProfit = profit;
            }
        }
        return Math.max(maxProfit, 0);
    }
    public static int maxProfit2(int[] prices) {
        int len = prices.length;
        int maxProfit = Integer.MIN_VALUE;
        int i = 0;
        int j = i + 1;
        while(i < j && i<len && j< len){
            int profit = prices[j] - prices[i];
            maxProfit = Math.max(profit,maxProfit);
            if (prices[i] > prices[j]) {
                while(i<j && prices[i] > prices[j]) i++;
            }
            j++;
        }

        return Math.max(maxProfit, 0);
    }


}
