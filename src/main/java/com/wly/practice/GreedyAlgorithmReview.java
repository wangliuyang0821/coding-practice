package com.ctrip.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GreedyAlgorithmReview {
    public static void main(String[] args) {
        //int[] arr = {-1,0,3,5,9,12};
        //System.out.println(search(arr, 9));
        //maxProfits(arr);
        //int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        //reconstructQueue(people);
        /*List<Integer> list = new ArrayList<>();
        list.add(1,9);
        list.add(0,2);
        System.out.println(list.toString());*/
        System.out.println(generateParenthesis(3).toString());
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesisBFS(n,0,0,"",res);
        return res;
    }

    public static void generateParenthesisBFS(int n,int left,int right,String str,List<String> res){
        if(left == n && right == n){
            res.add(str);
            return;
        }

        if(left > n || right > n || right > left){
            return;
        }

        if(left <= n){
            generateParenthesisBFS(n,left + 1,right,str + "(",res);
        }

        if(right <= left){
            generateParenthesisBFS(n,left,right + 1,str + ")",res);
        }

    }

   /* public static int maxProfits(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        //dp[i][0] 第i天收盘后手上还持有一只股票时的累计最大受益
        //dp[i][1] 第i天收盘后手上没有持有股票但是处于冷冻期的累计最大受益
        //dp[i][2] 第i天收盘瘦手上没有股票并且不是冷冻期时的累计最大受益

    }*/


    public static int[][] reconstructQueue(int[][] people) {
        int[][] res = new int[people.length][2];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        /*for(int i = 0;i < people.length;i++){
            for(int j = 0;j < people[i].length;j++){
                System.out.print(people[i][j]+" ");
            }
            System.out.println("");
        }*/
        List<int[]> list = new ArrayList<>();
        for(int[] i : people){
            list.add(i[1],i);
        }
        return res;
    }

    public static int search(int[] nums, int target) {
        int res = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }
        return res;
    }

    public int maxProfit(int[] prices) {
        int total = 0;
        for(int i = 1;i < prices.length;i++){
            if(prices[i] - prices[i - 1] > 0){
                total = total + (prices[i] - prices[i - 1]);
            }
        }
        return total;
    }

    public static boolean canJump(int[] nums) {
        if(nums.length < 1) return true;
        int maxStep = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(maxStep > i){
                maxStep = Math.max(maxStep,i + nums[i]);
            }
        }
        return maxStep > nums.length - 1 ? true : false;
    }



    public int maxArea(int[] height) {
        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;
        while(start < end){
            int h = Math.min(height[start],height[end]);
            int k = end - start;
            maxArea = Math.max(maxArea,h * k);
            if(height[start] > height[end]){
                end--;
            }else{
                start++;
            }
        }
        return maxArea;
    }
}
