package com.ctrip.review.January;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Review20220128 {
    public static void main(String[] args) {
//        int[] arr = {2,3,6,7};
//        //System.out.println(combinationSum2(arr, 5));
//        System.out.println(combinationSum(arr, 7).toString());
        //System.out.println(letterCombinations("23").toString());
        /*int[] arr = {1,2,3};
        System.out.println(permute(arr).toString());*/
        //System.out.println(combine(4, 2).toString());
        /*int[] arr = {1,2,3};
        System.out.println(subsets(arr).toString());*/
        System.out.println(generateParenthesis(3).toString());
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesisHandler(n,0,0,"",res);
        return res;
    }

    public static void generateParenthesisHandler(int n,int left,int right,String temp,List<String> res){
        if(right > left || left > n || right > n){
            return;
        }

        if(left == n && right == n){
            res.add(temp);
            return;
        }

        generateParenthesisHandler(n,left + 1,right,temp + "(",res);
        generateParenthesisHandler(n,left,right + 1,temp + ")",res);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        subsetsHandler(nums,0,temp,res);
        return res;
    }

    public static void subsetsHandler(int[] nums,int index,List<Integer> temp,List<List<Integer>> res){
        if(temp.size() > nums.length){
            return;
        }

        if(temp.size() <= nums.length){
            res.add(new ArrayList<>(temp));
        }

        for(int i = index;i < nums.length;i++){
            temp.add(nums[i]);
            subsetsHandler(nums,index + 1,temp,res);
            temp.remove(temp.size() - 1);
        }
    }


    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        combineHandler(n,k,1,visited,new ArrayList<>(),res);
        return res;
    }

    public static void combineHandler(int n,int k,int index,boolean[] visited,List<Integer> temp,List<List<Integer>> res){
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index;i <= n;i++){
            if(visited[i]) continue;
            visited[i] = true;
            temp.add(i);
            combineHandler(n,k,i + 1,visited,temp,res);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permuteHandler(nums,visited,new ArrayList<>(),res);
        return res;
    }

    public static void permuteHandler(int[] nums,boolean[] visited,List<Integer> temp,List<List<Integer>> res){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            temp.add(nums[i]);
            permuteHandler(nums,visited,temp,res);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        HashMap<Character,String> hashMap = new HashMap<>();
        hashMap.put('2',"abc");
        hashMap.put('3',"def");
        hashMap.put('4',"ghi");
        hashMap.put('5',"jkl");
        hashMap.put('6',"mno");
        hashMap.put('7',"pqrs");
        hashMap.put('8',"tuv");
        hashMap.put('9',"wxyz");
        letterCombinationsHandler(digits,0,new StringBuilder(),res,hashMap);
        return res;
    }

    public static void letterCombinationsHandler(String digits,int index,StringBuilder sb,List<String> res,HashMap<Character,String> hashMap){
        if(sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }

        String temp = hashMap.get(digits.charAt(index));

        for(int i = 0;i < temp.length();i++){
            sb.append(temp.charAt(i));
            letterCombinationsHandler(digits,index + 1,sb,res,hashMap);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHandler(candidates,target,0,new ArrayList<>(),res);
        return res;
    }

    public static void combinationSumHandler(int[] nums,int target,int index,List<Integer> tempList,List<List<Integer>> res){
        if(target < 0){
            return;
        }

        if(target == 0){
            res.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = index;i < nums.length;i++){
            tempList.add(nums[i]);
            combinationSumHandler(nums,target - nums[i],i,tempList,res);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        //HashSet<List<Integer>> hashSet = new HashSet<>();
        combinationSum2Handler(candidates,0,target,new ArrayList<>(),0,res);
        return res;
    }

    public static void combinationSum2Handler(int[] candidates,int index,int target,List<Integer> tempList,int temp,List<List<Integer>> res){
        if(temp == target){
            res.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = index;i < candidates.length;i++){
            temp = temp + candidates[i];
            tempList.add(candidates[i]);
            combinationSum2Handler(candidates,i + 1,target,tempList,temp,res);
            temp = temp - candidates[i];
            tempList.remove(tempList.size() - 1);
            while(i > 0 && i < candidates.length - 1 && candidates[i] == candidates[i + 1]) i++;
        }
    }
}
