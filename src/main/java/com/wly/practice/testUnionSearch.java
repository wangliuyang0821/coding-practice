package com.wly.practice;

import java.util.Arrays;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/9/8
 * @备注:
 */
public class testUnionSearch {
    public static void main(String[] args) {
        int[] arr = {186,419,83,408};
        //int[] arr = {1,2,5};
        System.out.println(coinChange(arr, 6249));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for(int i = 0;i <= amount;i++){
            for(int coin : coins){
                if(i < coin) continue;
                dp[i] = Math.min(dp[i - coin] + 1,dp[i]);
            }
        }
        return dp[amount] > amount ? - 1 : dp[amount];
    }

    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[i].length;j++){
                if(grid[i][j] == '1'){
                    res++;
                    numIslandsHandler(grid,i,j);
                }
            }
        }
        return res;
    }

    public static void numIslandsHandler(char[][] grid,int i,int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }

        if(grid[i][j] == '1'){
            grid[i][j] = '0';
        }

        numIslandsHandler(grid,i + 1,j);
        numIslandsHandler(grid,i - 1,j);
        numIslandsHandler(grid,i,j + 1);
        numIslandsHandler(grid,i,j - 1);
    }

}
