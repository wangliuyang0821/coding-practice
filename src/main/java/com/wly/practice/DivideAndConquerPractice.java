package com.wly.practice;

import java.util.HashMap;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/7/6
 * @备注:
 */
public class DivideAndConquerPractice {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
    public int majorityElement(int[] nums) {
        int res = -1;
        int target = nums.length / 2;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            int cur = nums[i];
            if(!map.containsKey(cur)){
                map.put(cur,1);
            }else{
                map.put(cur,map.get(cur) + 1);
            }

            if(map.get(cur) > target){
                return cur;
            }
        }
        return res;
    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for(int i = 0;i < nums.length;i++){
            temp = Math.max(nums[i],temp + nums[i]);
            max = Math.max(max,temp);
        }
        return max;
    }

    public static int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++){
            int res = 0;
            for(int j = i;j < nums.length;j++){
                res += nums[j];
                max = Math.max(max,res);
            }
        }
        return max;
    }
}
