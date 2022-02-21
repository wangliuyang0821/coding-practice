package com.wly.review.February;

import java.util.Arrays;

public class Review20220210 {
    public static void main(String[] args) {
        int[] arr = {1,2,5};
        /*System.out.println(coinChange(arr, 11));*/
    }

    public boolean canJump(int[] nums) {
        boolean res = true;
        int max = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(i > max){
                max = Math.max(max,i + nums[i]);
            }
        }
        return res;
    }

    public int minCostToMoveChips(int[] position) {
        int n = position.length;
        if(n % 2 == 0){
            return n / 2;
        }else{
            return (n / 2) + 1;
        }
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1;i <= amount;i++){
            for(int coin : coins){
                if(i < coin) continue;
                dp[i] = Math.min(dp[i],dp[i - coin] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? 0 : dp[amount];
    }
}
