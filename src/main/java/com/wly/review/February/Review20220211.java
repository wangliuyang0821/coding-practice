package com.wly.review.February;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Review20220211 {
    public static void main(String[] args) {
        /*int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));*/
        /*int[] arr = {1,0,-1,0,-2,2};
        System.out.println(fourSum(arr, 0));*/
        String s ="eat,tea,tan,ate,nat,bat";
        System.out.println(groupAnagrams(s.split(",")));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,String> hashMap = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(hashMap.containsKey(key)){
                hashMap.put(key,hashMap.get(key) +","+str);
            }else{
                hashMap.put(key,str);
            }
        }


        for(String key : hashMap.keySet()){
            List<String> temp = new ArrayList<>();
            String words = hashMap.get(key);
            for(String word : words.split(",")){
                temp.add(word);
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            if(i > 0 && nums[i - 1] == nums[i]) continue;
            int first = nums[i];
            for(int j = i + 1;j < nums.length;j++){
                int second = nums[j];
                int start = j + 1;
                int end = nums.length - 1;
                while(start < end){
                    int third = nums[start];
                    int forth = nums[end];
                    if(first + second + third + forth == target){
                        res.add(Arrays.asList(first,second,third,forth));
                        start++;
                        while(start < end && nums[start] == nums[start + 1]) start++;
                        end--;
                        while(start < end && nums[end] == nums[end - 1]) end--;
                    }else if(first + second + third + forth < target){
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
            if(i > 0 && nums[i - 1] == nums[i]) continue;
            int temp = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                if(temp + nums[start] + nums[end] == 0){
                    res.add(Arrays.asList(temp,nums[start],nums[end]));
                    start++;
                    while(start < end && start < nums.length - 1 && nums[start] == nums[start + 1]) start++;
                    end--;
                    while(start < end && end > 0 && nums[end] == nums[end - 1]) end--;
                }else if(temp + nums[start] + nums[end] < 0){
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
