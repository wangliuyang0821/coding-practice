package com.wly.review.January;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Review20220127 {
    public static void main(String[] args) {
        /*int[] arr = {1,1,2};
        System.out.println(permuteUnique(arr).toString());*/
        /*System.out.println(isPalindrome("abba"));*/
        /*System.out.println(partition("aab").toString());*/
        /*int[] arr = {4,4,3,2,1};
        System.out.println(findSubsequences(arr).toString());*/
        System.out.println(partition("aab").toString());
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        partitionDFS(s,0,temp,res);
        return res;
    }

    public static void partitionDFS(String s,int index,List<String> temp,List<List<String>> res){
        if(index == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index;i < s.length();i++){
            String t = s.substring(index,i + 1);
            if(!isPalindrome(t)) continue;
            temp.add(t);
            partitionDFS(s,i + 1,temp,res);
            temp.remove(temp.size() - 1);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        return res;
    }

    public static void restoreIpAddresses(String s,int index,StringBuilder sb,List<String> res){
        if(sb.length() == s.length() + 4){
            res.add(sb.toString());
        }

        for(int i = index;i < s.length();i++){

        }
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> hashSet = new HashSet<>();
        findSubsequencesHandler(nums,0,new ArrayList<>(),res,hashSet);
        return res;
    }

    public static void findSubsequencesHandler(int[] nums,int index,List<Integer> temp,List<List<Integer>> res,HashSet hashSet){
        if(temp.size() > 1 && !hashSet.contains(temp)){
            res.add(new ArrayList<>(temp));
            hashSet.add(temp);
        }

        for(int i = index;i < nums.length;i++){
            if(temp.size() == 0 || temp.get(temp.size() - 1) <= nums[i]){
                temp.add(nums[i]);
                findSubsequencesHandler(nums,i + 1,temp,res,hashSet);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String str){
        if(str.length() == 0) return false;
        boolean flag = true;
        int start = 0;
        int end = str.length() - 1;
        while(start <= end){
            char startTemp = str.charAt(start);
            char endTemp = str.charAt(end);
            if(startTemp != endTemp) return false;
            end--;
            start++;
        }
        return flag;
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Boolean[] visited = new Boolean[nums.length];
        HashSet<List<Integer>> hashSet = new HashSet<>();
        Arrays.fill(visited,false);
        permuteUniqueDFS(nums,res,visited,new ArrayList<>(),hashSet);
        return res;
    }

    public static void permuteUniqueDFS(int[] nums,List<List<Integer>> res,Boolean[] visited,List<Integer> temp,HashSet<List<Integer>> hashSet){
        if(hashSet.contains(temp)){
            return;
        }

        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            hashSet.add(temp);
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            temp.add(nums[i]);
            permuteUniqueDFS(nums,res,visited,temp,hashSet);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}
