package com.ctrip.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/7/7
 * @备注:
 */
public class BacktrackingPractice {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        //System.out.println(combine(4, 2).toString());
        //System.out.println(subsets(arr).toString());
        //System.out.println(generateParenthesis(2).toString());
        System.out.println(permute(arr).toString());
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        permuteDfs(nums,temp,res,new boolean[nums.length]);
        return res;
    }

    public static void permuteDfs(int[] nums,List<Integer> temp,List<List<Integer>> res,boolean[] exist){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(!exist[i]){
                temp.add(nums[i]);
                exist[i] = true;
                permuteDfs(nums,temp,res,exist);
                temp.remove(temp.size() - 1);
                exist[i] = false;
            }
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        generateParenthesisDfs(left,right,n,"",res);
        return res;
    }

    public static void generateParenthesisDfs(int left,int right,int n,String str,List<String> res){
        if(left == n && right == n){
            res.add(str);
            return;
        }

        if(left > n || right > n){
            return;
        }

        if(left >= right){
            generateParenthesisDfs(left + 1,right,n,str + "(",res);
            generateParenthesisDfs(left,right + 1,n,str + ")",res);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        res.add(new ArrayList<>());
        SubsetsDfs(0,nums,temp,res);
        return res;
    }

    public static void SubsetsDfs(int start,int[] nums,List<Integer> temp,List<List<Integer>> res){
        if(temp.size() >= nums.length){
            return;
        }

        for(int i = start;i < nums.length;i++){
            temp.add(nums[i]);
            SubsetsDfs(i + 1,nums,temp,res);
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        CombineDfs(1,n,k,temp,res);
        return res;
    }

    public static void CombineDfs(int start,int n,int len,List<Integer> temp,List<List<Integer>> res){
        if(temp.size() == len){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start;i <= n;i++){
            temp.add(i);
            CombineDfs(i + 1,n,len,temp,res);
            temp.remove(temp.size() - 1);
        }
    }
}
