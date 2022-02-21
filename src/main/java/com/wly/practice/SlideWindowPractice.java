package com.wly.practice;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/7/1
 * @备注:
 */
public class SlideWindowPractice {
    public static void main(String[] args) {
        //int[] arr = new int[]{1,2,3,4,5};
        //System.out.println(minSubArrayLen(11, arr));
        String s = "abciiidef";
        System.out.println(maxVowels(s, 3));
    }

    //abciiidef
    public static int maxVowels(String s, int k) {
        int start = 0;
        int end = 0;
        int count = 0;
        int max = 0;
        while (end < s.length()){
            String temp = String.valueOf(s.charAt(end));
            if(isContain(temp,"a,e,i,o,u")){
                count++;
            }
            end++;
            if(end - start == k){
                max = Math.max(count,max);
                String sta = String.valueOf(s.charAt(start));
                if(isContain(sta,"a,e,i,o,u")){
                    count--;
                }
                start++;
            }
        }
        return max;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = -1;
        int right = -1;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while(left <= right){
            if(sum < target){
                right++;
                if(right >= nums.length){
                    break;
                }
                sum = sum + nums[right];
            }else{
                if(right - left < minLen){
                    minLen = right - left;
                }
                left++;
                if(left > right){
                    break;
                }
                sum = sum - nums[left];
            }

        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }



    public static boolean isContain(String input,String targetColumns){
        boolean res = false;
        String[] arr = targetColumns.split(",");
        for(String s : arr){
            if(input.contains(s)){
                return true;
            }
        }
        return res;
    }
}
