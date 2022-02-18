package com.ctrip.review.January;

public class Review20220126 {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2;i <= n;i++){
            for(int j = 1;j < i;j++){
                dp[i] = Math.max(dp[i],j * (i - j));
                dp[i] = Math.max(dp[i],dp[i - j] * j);
            }
        }
        return dp[n];
    }
}
