package com.ctrip.review.January;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Review20220105 {
    public static void main(String[] args) {
        /*int[] arr = {2,7,11,15};
        int[] res = twoSum(arr, 9);
        for(int i : res){
            System.out.println(i);
        }*/
        //int[] arr = {-1,0,1,2,-1,-4};
        //System.out.println(threeSum(arr).toString());
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
        for(int i : arr){
            System.out.println(i);
        }
    }

    public static void sortColors(int[] nums) {
        for(int i = 0;i < nums.length - 1;i++){
            for(int j = 0;j < nums.length - i - 1;j++){
                if(nums[j] > nums[j + 1]){
                    swift(nums,j,j + 1);
                }
            }
        }
    }

    public static void swift(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                if(nums[i] + nums[start] + nums[end] == 0){
                    res.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    start++;
                    while(start < end && nums[start] == nums[start + 1]) start++;
                    end--;
                    while(start < end && nums[end - 1] == nums[end]) end--;
                }else if(nums[i] + nums[start] + nums[end] < 0){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return res;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0;i < nums.length;i++){
            for(int j = i + 1;j < nums.length;j++){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
}
