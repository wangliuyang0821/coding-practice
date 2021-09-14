package com.ctrip.practice;

import java.util.Arrays;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/7/21
 * @备注:
 */
public class GreedyAlgorithmPractice {
    public static void main(String[] args) {
        int[] scores = {1,1,1,0};
        //System.out.println(coinChange(scores,3));
        //System.out.println(minCostToMoveChips(scores));
        System.out.println(canJump(scores));
    }


    public static boolean canJump(int[] nums) {
        if(nums.length == 0){
            return true;
        }
        int reachable = nums[0];

        for(int i = 1;i < nums.length;i++){
            if(reachable >= i){
                reachable = Math.max(reachable,nums[i] + i);
            }
        }

        return reachable >= nums.length - 1;
    }

    //状态转移方程 dp[i] = Math.min(dp[i - coin] + 1,dp[i])
    public static int coinChange(int[] coins, int amount) {
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

    public static int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;
        for(int i = 0;i < position.length;i++){
            int temp = position[i];
            if(temp % 2 == 0){
                even++;
            }else{
                odd++;
            }
        }
        return even > odd ? odd : even;
    }


}
