package com.ctrip.review.January;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Review20220109 {
    public static void main(String[] args) {
        //System.out.println(uniquePaths(3, 7));
        //int[] arr = {7,1,5,3,6,4};
        //System.out.println(maxProfit(arr));
        //System.out.println(climbStairs(3));
        System.out.println(generateParenthesis(3));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,n + 1);
        dp[0] = 0;
        for(int i = 1;i <= n;i++){
            for(int j = 0;j <= i;j++){
                if(j * j > i) continue;
                dp[i] = Math.min(dp[i],dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesisHandler(n,0,0,res,"");
        return res;
    }

    public static void generateParenthesisHandler(int n,int left,int right,List<String> res,String temp){
        if(left > n || right > n || right > left){
            return;
        }

        if(left == n && right == n){
            res.add(temp);
            return;
        }

        generateParenthesisHandler(n,left + 1,right,res,temp + "(");
        generateParenthesisHandler(n,left,right + 1,res,temp + ")");
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i <= n;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        int max = 0;
        int min = prices[0];
        for(int i = 1;i < prices.length;i++){
            dp[i] = prices[i] - min;
            min = Math.min(prices[i],min);
        }

        for(int i : dp){
            max = Math.max(i,max);
        }
        return max;
    }

    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++){
            dp[i][0] = 1;
        }

        for(int i = 0;i < n;i++){
            dp[0][i] = 1;
        }

        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
