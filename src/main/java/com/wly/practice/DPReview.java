package com.wly.practice;

import java.util.*;

public class DPReview {
    public static void main(String[] args) {
       /*List<List<Integer>> list = new ArrayList<>();
       List<Integer> temp1 = new ArrayList<>();
       temp1.add(2);
       list.add(new ArrayList<>(temp1));
       List<Integer> temp2 = new ArrayList<>();
       temp2.add(3);
       temp2.add(4);
       list.add(new ArrayList<>(temp2));
       List<Integer> temp3 = new ArrayList<>();
       temp3.add(6);
       temp3.add(5);
       temp3.add(7);
       list.add(new ArrayList<>(temp3));
       List<Integer> temp4 = new ArrayList<>();
       temp4.add(4);
       temp4.add(1);
       temp4.add(8);
       temp4.add(3);
       list.add(new ArrayList<>(temp4));
       System.out.println(minimumTotal(list));*/
       /*int[] arr = {1,3,-1,-3,5,3,6,7};
       int[] res = maxSlidingWindow(arr,3);
       for(int i : res){
           System.out.println(i);
       }*/
       /*int[] arr = {1,2,5};
        System.out.println(coinChange(arr, 11));*/
       int[] people = {3,2,2,1};
        System.out.println(numRescueBoats(people, 3));
    }

    public static int numRescueBoats(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        int start = 0;
        int end = people.length - 1;
        while(start <= end){
           if((people[start] + people[end]) > limit){
               end--;
           }else{
               start++;
               end--;
           }
           res++;
        }
        return res;
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for(int i = 1;i <= amount;i++){
            for(int coin : coins){
                if(coin > i) continue;
                dp[i] = Math.min(dp[i],dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static int lengthOfLIS(int[] nums) {
        int maxLen = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i = 0;i < nums.length;i++){
            for(int j = 0;j < i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }

    public static int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for(int i = 1;i < nums.length;i++){
            int tempMax = Math.max(nums[i],dpMax[i - 1] * nums[i]);
            dpMax[i] = Math.max(tempMax,nums[i] * dpMin[i - 1]);
            int tempMin = Math.min(nums[i],dpMin[i - 1] * nums[i]);
            dpMin[i] = Math.max(tempMin,dpMax[i - 1] * nums[i]);
        }

        for(int i = 0;i < dpMax.length;i++){
            res = Math.max(res,dpMax[i]);
        }
        return res;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0;i < nums.length;i++){
            if(i + 1 >= k && i - k + 1 > deque.peekFirst()){
                deque.pollFirst();
            }

            while(deque.size() > 0 && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }

            deque.add(i);
            if(i - k + 1 >= 0){
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n - 1).size();
        int[][] dp = new int[n][m];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1;i < m;i++){
            int size = triangle.get(i).size();
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            dp[i][size - 1] = dp[i - 1][size - 2] + triangle.get(i).get(size - 1);
            for(int j = 1;j < size - 1;j++){
                dp[i][j] = Math.min(dp[i - 1][j],dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
        }
        int res = dp[n - 1][0];
        for(int i = 0;i < m;i++){
            res = Math.min(res,dp[n - 1][i]);
        }
        return res;
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        if(n < 3){
            return dp[n];
        }
        for(int i = 3;i <= n;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void moveZeroes(int[] nums) {
        //标记0位
        int index = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != 0){
                swift(nums,i,index);
                index++;
            }
        }
    }

    public static void swift(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int maxProfit(int[] prices, int fee) {
        int res = 0;
        //dp[i][0]不持有股票
        //dp[i][1]持有股票
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        for(int i = 1;i < prices.length;i++){
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);
        }
        return Math.max(dp[dp.length - 1][0],dp[dp.length - 1][1]);
    }

    public static int hammingWeight(int n) {
        int res = 0;
        String input = Integer.toBinaryString(n);
        for(int i = 0;i < input.length();i++){
            char temp = input.charAt(i);
            if(temp == '1'){
                res++;
            }
        }
        return res;
    }


}
