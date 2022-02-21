package com.wly.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/6/15
 * @备注:
 */
public class HashTablePractice {
    public static void main(String[] args) {
        /*char a = 'b';
        System.out.println(a - 'a');
        nums1 = [4,1,2], nums2 = [1,3,4,2].
        */
        int[] nums1 = new int[]{2,4};
        int[] nums2 = new int[]{1,2,3,4};
        System.out.println(nextGreaterElement(nums1, nums2));

    }
    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 0){
            return false;
        }

        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0;i < nums.length;i++){
            hashSet.add(nums[i]);
        }

        return hashSet.size() == nums.length ? false : true;
    }

    public static char findTheDifference(String s, String t) {
        char res = ' ';
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            String temp = String.valueOf(s.charAt(i));
            map.put(temp,(map.get(temp) == null ? 1 :map.get(temp) + 1));
        }
        for(int i = 0;i < t.length();i++){
            String temp = String.valueOf(t.charAt(i));
            if(!map.containsKey(temp) ||  (map.get(temp) - 1) < 0){
                res = t.charAt(i);
                break;
            }
            map.put(temp,map.get(temp) - 1);
        }
        return res;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[nums1.length];
        for(int i = nums2.length - 1;i >= 0;i--){
            int temp = nums2[i];
            while(!stack.isEmpty() && stack.peek() < temp){
                stack.pop();
            }

            if(!stack.isEmpty() && stack.peek() > temp){
                map.put(temp,stack.peek());
            }

            if(stack.isEmpty()){
                map.put(temp,-1);
            }

            stack.add(temp);
        }

        for(int i = 0;i < nums1.length;i++){
            arr[i] = map.get(nums1[i]);
        }
        return arr;
    }
}
