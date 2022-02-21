package com.wly.practice;

import java.util.Arrays;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/7/30
 * @备注:
 */
public class MemorySearchPractice {
    public int fib(int n) {
      if(n == 0){
          return 0;
      }
      if(n == 1){
          return 1;
      }
      return fib(n - 1) + fib(n - 2);
    }


    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for(int i = 1;i <= amount;i++){
            for(int coin : coins){
                if(i < coin) continue;
                dp[i] = Math.min(dp[i - coin] + 1,dp[i]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
