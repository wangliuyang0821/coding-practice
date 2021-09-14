package com.ctrip.practice;

import scala.Int;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/9/3
 * @备注:
 */
public class TestBackTracking {
    public static void main(String[] args) {
        /*System.out.println(combine(4, 2).toString());*/
        int[] arr = {1,2,3};
        //System.out.println(subsets(arr));
        System.out.println(permute(arr).toString());
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
        return dp[amount] > amount ? - 1 : dp[amount];
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permuteDFS(res,temp,nums,visited);
        return res;
    }

    public static void permuteDFS(List<List<Integer>> res,List<Integer> temp,int[] nums,boolean[] visited){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(!visited[i]){
                visited[i] = true;
                temp.add(nums[i]);
                permuteDFS(res,temp,nums,visited);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        List<Integer> temp = new ArrayList<>();
        subsetDFS(res,temp,0,nums);
        return res;
    }

    public static void subsetDFS(List<List<Integer>> res,List<Integer> temp,int start,int[] nums){
        if(temp.size() > nums.length){
            return;
        }

        for(int i = start;i < nums.length;i++){

            temp.add(nums[i]);
            subsetDFS(res,temp,i + 1,nums);
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);

        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinDFS(res,temp,1,n,k);
        return res;
    }

    public static void combinDFS(List<List<Integer>> res,List<Integer> temp,int start,int n,int k){
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start;i <= n;i++){
            temp.add(i);
            combinDFS(res,temp,i + 1,n,k);
            temp.remove(temp.size() - 1);
        }
    }
}
