package com.wly.review.February;

import java.util.HashSet;

public class Review20220208 {
    public static void main(String[] args) {
        /*int[] arr = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, arr));*/
        System.out.println(maxVowels("abciiidef", 3));
    }

    public static int maxVowels(String s, int k) {
        HashSet<Character> hashSet = new HashSet<>();
        hashSet.add('a');
        hashSet.add('e');
        hashSet.add('i');
        hashSet.add('o');
        hashSet.add('u');
        int res = Integer.MIN_VALUE;
        int start = 0;
        int end = -1;
        int len = s.length();
        int temp = 0;
        while(end < len){
            if(end - start + 1 < k){
                end++;
                if(end >= len) break;
                if(isIn(s,end,hashSet)){
                    temp++;
                    res = Math.max(temp,res);
                }
            }else{
                if(isIn(s,start,hashSet)){
                    temp--;
                }
                start++;
            }
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }

    public static boolean isIn(String s,int index,HashSet hashSet){
        return hashSet.contains(s.charAt(index));
    }


    public static int minSubArrayLen(int target, int[] nums) {
        int start  = 0;
        int end = -1;
        int len = nums.length;
        int maxLen = Integer.MAX_VALUE;
        int sum = 0;
        while(end < len){
            if(sum < target){
                end++;
                if(end >= len) break;
                sum = sum + nums[end];
            }else{
                maxLen = Math.min(maxLen,end - start + 1);
                sum = sum - nums[start];
                start++;
            }
        }
        return maxLen == Integer.MAX_VALUE ? 0 : maxLen;
    }
}
