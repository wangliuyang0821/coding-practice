package com.ctrip.review.January;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Review20220110 {
    public static void main(String[] args) {
        //int[] arr = {-1,0,1,2,-1,-4};
        //System.out.println(threeSum(arr).toString());
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        return String.valueOf(ss).equalsIgnoreCase(String.valueOf(tt)) ? true: false;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs.length == 0) return res;
        HashMap<String,List<String>> hashMap = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String temp = String.valueOf(chars);
            if(hashMap.containsKey(temp)){
                List<String> list = hashMap.get(temp);
                list.add(str);
                hashMap.put(temp,list);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                hashMap.put(temp,list);
            }
        }

        for(String key : hashMap.keySet()){
            res.add(hashMap.get(key));
        }
        return res;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 4) return res;
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int first = nums[i];
            for(int j = i + 1;j < nums.length;j++){
                int second = nums[j];
                int start = j + 1;
                int end = nums.length - 1;
                while(start < end){
                    if(first + second + nums[start] + nums[end] == target){
                        res.add(Arrays.asList(first,second,nums[start],nums[end]));
                        start++;
                        while(start < end && nums[start] == nums[start - 1]) start++;
                        end--;
                        while(start < end && nums[end] == nums[end + 1]) end--;
                    }else if((first + second + nums[start] + nums[end]) < target){
                        start++;
                    }else{
                        end--;
                    }
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int temp = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                if(nums[start] + nums[end] + temp == 0){
                    res.add(Arrays.asList(nums[start],nums[end],temp));
                    start++;
                    while(start < end && nums[start] == nums[start - 1]) start++;
                    end--;
                    while(start < end && nums[end] == nums[end + 1]) end--;
                }else if((nums[start] + nums[end] + temp) < 0){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return res;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0;i < nums.length;i++){
            for(int j = i + 1;j < nums.length;j++){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}
