package com.ctrip.review.January;

public class Review20220114 {
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, arr));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int start = 0;
        int end = -1;
        int sum = 0;
        while(end < nums.length){
            if(sum < target){
                end++;
                if(end >= nums.length) break;
                sum = sum + nums[end];
            }else{
                res = Math.min(res,end - start + 1);
                sum = sum - nums[start];
                start++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
