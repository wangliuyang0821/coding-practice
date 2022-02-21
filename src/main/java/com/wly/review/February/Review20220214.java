package com.wly.review.February;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Review20220214 {
    public static void main(String[] args) {
        //System.out.println(generateParenthesis(3).toString());
        /*int[] arr = {1,2,3};
        System.out.println(subsets(arr).toString()); */
        //System.out.println(combine(4, 2));
        /*int[] arr = {1,2,3};
        System.out.println(permute(arr));*/
        System.out.println(letterCombinations("23").toString());
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        HashMap<Character,String> hashMap = new HashMap<>();
        hashMap.put('2',"abc");
        hashMap.put('3',"def");
        hashMap.put('4',"ghi");
        hashMap.put('5',"jkl");
        hashMap.put('6',"mno");
        hashMap.put('7',"pqrs");
        hashMap.put('8',"tuv");
        hashMap.put('9',"wxyz");
        letterCombinationsHandler(digits,hashMap,0,new StringBuilder(),res);
        return res;
    }

    public static void letterCombinationsHandler(String digits,Map<Character,String> map,int index,StringBuilder sb,List<String> res){
        if(digits.length() == sb.length()){
            res.add(sb.toString());
            return;
        }

        /*if(index >= digits.length()){
            return;
        }*/

        Character key = digits.charAt(index);
        String val = map.get(key);
        for(int i = 0;i < val.length();i++){
            Character temp = val.charAt(i);
            sb.append(temp);
            letterCombinationsHandler(digits,map,index + 1,sb,res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permuteHandler(nums,temp,res,visited);
        return res;
    }

    public static void permuteHandler(int[] nums,List<Integer> temp,List<List<Integer>> res,boolean[] visited){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        if(temp.size() > nums.length){
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(!visited[i]){
                visited[i] = true;
                temp.add(nums[i]);
                permuteHandler(nums, temp, res, visited);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinHandler(n,1,k,temp,res);
        return res;
    }

    public static void combinHandler(int n,int index,int k,List<Integer> temp,List<List<Integer>> res){
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
        }

        if(temp.size() > k){
            return;
        }

        for(int i = index;i <= n;i++){
            temp.add(i);
            combinHandler(n,i + 1,k,temp,res);
            temp.remove(temp.size() - 1);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        subsetsHandler(nums,0,temp,res);
        return res;
    }

    public static void subsetsHandler(int[] nums,int index,List<Integer> temp,List<List<Integer>> res){
        if(temp.size() > nums.length){
            return;
        }

        for(int i = index;i < nums.length;i++){
            temp.add(nums[i]);
            res.add(new ArrayList<>(temp));
            subsetsHandler(nums,i + 1,temp,res);
            temp.remove(temp.size() - 1);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesisHandler(res,0,0,"",n);
        return res;
    }

    public static void generateParenthesisHandler(List<String> res,int left,int right,String temp,int n){
        if(left < right || left > n || right > n){
            return;
        }

        if(left == n && right == n){
            res.add(temp);
            return;
        }


        generateParenthesisHandler(res,left + 1,right,temp + "(",n);
        generateParenthesisHandler(res,left,right + 1,temp + ")",n);
    }
}
