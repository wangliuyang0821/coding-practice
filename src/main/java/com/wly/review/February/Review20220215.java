package com.wly.review.February;

import java.util.*;

public class Review20220215 {
    public static void main(String[] args) {
        /*int[] arr = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(arr, 8));*/
        //System.out.println(partition("aab"));
        /*int[] arr = {4,6,7,7};
        System.out.println(findSubsequences(arr).toString());*/
        int[] arr = {1,2,3};
        System.out.println(permuteUnique(arr).toString());
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permuteUniqueHandler(nums,temp,res,visited);
        return new ArrayList<>(res);
    }

    public static void permuteUniqueHandler(int[] nums,List<Integer> temp,Set<List<Integer>> res,boolean[] visited){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(!visited[i]){
                visited[i] = true;
                temp.add(nums[i]);
                permuteUniqueHandler(nums,temp,res,visited);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        HashSet<List<Integer>> hashSet = new HashSet<>();
        findSubsequencesHandler(nums,0,temp,res,hashSet);
        return new ArrayList<>(res);
    }

    public static void findSubsequencesHandler(int[] nums,int index,List<Integer> temp,Set<List<Integer>> res,HashSet<List<Integer>> hashSet){
        if(temp.size() >= 2){
            res.add(new ArrayList<>(temp));
            hashSet.add(temp);
        }

        if(index >= nums.length){
            return;
        }

        for(int i = index;i < nums.length;i++){
            if(temp.size() == 0 || temp.get(temp.size() - 1) <= nums[i]){
                temp.add(nums[i]);
                findSubsequencesHandler(nums,i + 1,temp,res,hashSet);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        partitionHandler(s,0,temp,res);
        return res;
    }

    public static void partitionHandler(String s,int index,List<String> temp,List<List<String>> res){
        if(index >= s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index;i < s.length();i++){
            String t = s.substring(index,i + 1);
            if(!isPalindrome(t)) continue;
            temp.add(t);
            partitionHandler(s,i + 1,temp,res);
            temp.remove(temp.size() - 1);
        }
    }

    public static boolean isPalindrome(String sb){
        boolean res = true;
        int start = 0;
        int end = sb.length() - 1;
        while(start <= end){
            if(sb.charAt(start) == sb.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return res;
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];
        HashSet<List<Integer>> hashSet = new HashSet<>();
        Arrays.sort(candidates);
        combinationSu2mHandler(candidates,0,target,temp,res,visited,hashSet);
        return res;
    }


    public static void combinationSu2mHandler(int[] candidates,int index,int target,List<Integer> temp,List<List<Integer>> res,boolean[] visited,HashSet<List<Integer>> hashSet){
        if(target == 0){
            if(!hashSet.contains(temp)){
                hashSet.add(temp);
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        if(target < 0){
            return;
        }

        for(int i = index;i < candidates.length;i++){
            if(!visited[i]){
                temp.add(candidates[i]);
                visited[i] = true;
                combinationSu2mHandler(candidates,i + 1,target - candidates[i],temp,res,visited,hashSet);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        combinationSumHandler(candidates,0,target,temp,res,visited);
        return res;
    }

    public static void combinationSumHandler(int[] candidates,int index,int target,List<Integer> temp,List<List<Integer>> res,boolean[] visited){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        if(target < 0){
            return;
        }

        for(int i = index;i < candidates.length;i++){
            temp.add(candidates[i]);
            combinationSumHandler(candidates,i,target - candidates[i],temp,res,visited);
            temp.remove(temp.size() - 1);
        }
    }
}
