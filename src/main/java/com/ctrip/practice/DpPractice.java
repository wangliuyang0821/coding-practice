package com.ctrip.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/7/31
 * @备注:
 */
public class DpPractice {
    public static void main(String[] args) {
        //System.out.println(uniquePaths(3, 2));
        /*int[] arr =  {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));*/
        //System.out.println(climbStairs(2));
        /*System.out.println(numSquares(4));
        System.out.println(numSquares(2));*/
        System.out.println(generateParenthesis(1));
        int l = 0;
        System.out.println(l++);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        int left = 0;
        int right = 0;
        generateParenthesisBFS(list,"",left,right,n);
        return list;
    }

    public static void generateParenthesisBFS(List<String> res,String temp,int left,int right,int n){
        if(left > n || right > n){
            return;
        }
        if(left == n && right == n){
            res.add(temp);
            return;
        }
        if(left >= right){
            generateParenthesisBFS(res,temp + "(",left + 1,right,n);
            generateParenthesisBFS(res,temp + ")",left,right + 1,n);
        }
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,n + 1);
        dp[0] = 0;
        for(int i = 1;i <= n;i++){
            for(int j = 0;j <= i;j++){
                if(i < j * j) continue;
                dp[i] = Math.min(dp[i],dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i <= n;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     *
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     *
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 示例 2：0
     *
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     * **/
    public static int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        for(int i = 1;i < prices.length;i++){
            max = Math.max(max,prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        return max;
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
