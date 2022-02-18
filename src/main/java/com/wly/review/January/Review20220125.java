package com.ctrip.review.January;

import java.util.ArrayList;
import java.util.List;

public class Review20220125 {
    public static void main(String[] args) {
        /*int[] arr = {10,15,20};
        System.out.println(minCostClimbingStairs(arr));*/
        int[][] arr = {{0,0}};
        System.out.println(uniquePathsWithObstacles(arr));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    if(i > 0) dp[i][j] += dp[i - 1][j];
                    if(j > 0) dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
        /*List<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        uniquePathsWithObstaclesHandler(obstacleGrid,0,0,res,visited);
        return res.size();*/
    }

    public static void uniquePathsWithObstaclesHandler(int[][] obstacleGrid,int x,int y,List<String> res,boolean[][] visited){
        if(x >= obstacleGrid.length  || x < 0 || y >= obstacleGrid[0].length || y < 0 || obstacleGrid[x][y] == 1 || visited[x][y]){
            return;
        }

        if(x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1){
            res.add("1");
            return;
        }

        visited[x][y] = true;

        uniquePathsWithObstaclesHandler(obstacleGrid,x + 1,y,res,visited);
        uniquePathsWithObstaclesHandler(obstacleGrid,x,y + 1,res,visited);

        visited[x][y] = false;
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2;i <= n;i++){
            dp[i] = Math.min(dp[i - 1] + cost[i - 1],dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
