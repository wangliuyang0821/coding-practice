package com.wly.tools;

import java.util.*;

public class test {
    public static void main(String[] args) {
        //int[] arr = {1,3,4,6,7};
        //int[] arr = {1,3,4,6,7,10,22,30};
        /*int[] arr = {-2,0,0,2,2};
        System.out.println(threeSum(arr).toString());*/
        int[] arr = {-1,3,6,-9,2,-5,-1,9,3,-3};
        System.out.println(getMaxFromArr(arr));
    }

    public static int getMaxFromArr(int[] nums){
        int res = 0;
        int temp = 0;
        for(int i = 0;i < nums.length;i++){
            if(temp > 0){
                temp = temp + nums[i];
            }else{
                temp = nums[i];
            }

            res = Math.max(temp,res);
        }
        return res;
    }

    public static void getMaxSub(int[] nums){
        int start = 0;
        int tempSum = 0;
        int end = 0;
        int tempStart = 0;
        int max = 0;
        for(int i = 0;i < nums.length;i++){
            if(tempSum > 0){
                tempSum = tempSum + nums[i];
            }else{
                tempSum = nums[i];
                tempStart = i;
            }

            if(tempSum > max){
                start = tempStart;
                max = tempSum;
                end = i;
            }
        }

        System.out.println("max:"+max+" start:"+start+" end:"+end);
    }

    public static int maxArea(int[] height) {
        int res = 0;
        int start = 0;
        int end = height.length - 1;
        while(start < end){
            int high = Math.min(height[start],height[end]);
            int gap = end - start;
            res = Math.max(res,high * gap);
            if(height[start] > height[end]){
                end--;
            }else{
                start++;
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> marks = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length - 2;i++){
            int temp = nums[i];
            if(temp > 0 || marks.contains(temp)) continue;
            marks.add(temp);
            int start = i + 1;
            int end = nums.length - 1;
            while(end > start){
                if(temp + nums[start] + nums[end] == 0){
                    res.add(Arrays.asList(temp,nums[start],nums[end]));
                    start++;
                    while(nums[start] == nums[start - 1] && end > start) start++;
                    end--;
                    while(nums[end] == nums[end + 1] && end > start) end--;
                }else if(temp + nums[start] + nums[end] < 0){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return res;
    }

    public List<String> test(List<String> list1, List<String> list2){
        List<String> res = new ArrayList<>();
        for(int i = 0;i < list1.size();i++){
            String temp = list1.get(i);

            String start = temp.split(",")[0];
            String end = temp.split(",")[1];
            for(int j = 0;j < list2.size();j++){
                String temp2 = list2.get(j);
                String start2 = temp2.split(",")[0];
                String end2 = temp2.split(",")[1];
                /*if(start > start2 && end2 > end){
                    res.add(start+","+end);
                }*/
            }
        }
        return res;
    }
}
