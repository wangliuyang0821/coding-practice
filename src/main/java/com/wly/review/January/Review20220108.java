package com.ctrip.review.January;

import java.util.HashMap;
import java.util.Stack;

public class Review20220108 {
    public static void main(String[] args) {
        //System.out.println(isValid("{[]}"));
        int[] nums1 = {4,1,2};
        int[] nums2 = {6,5,4,3,2,1,7};
        int[] res = nextGreaterElement(nums1,nums2);
        for(int i : res){
            System.out.println(i);
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = nums2.length - 1;i >= 0;i--){
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                hashMap.put(nums2[i],-1);
            }else if(!stack.isEmpty() && stack.peek() > nums2[i]){
                hashMap.put(nums2[i],stack.peek());
            }
            stack.add(nums2[i]);
        }

        for(int i = 0; i < nums1.length;i++){
            res[i] = hashMap.get(nums1[i]);
        }
        return res;
    }

    public static boolean isValid(String s) {
        if(s.length() < 2) return false;
        boolean res = true;
        Stack<Character> stack = new Stack<>();
        int start = 0;
        int end = s.length();
        while(start < end){
            if(stack.isEmpty() && (s.charAt(start) == ')' || s.charAt(start) == ']' || s.charAt(start) == '}')){
                return false;
            }

            if(stack.isEmpty() || (s.charAt(start) == '(' || s.charAt(start) == '[' || s.charAt(start) == '{')){
                stack.add(s.charAt(start));
                start++;
                continue;
            }

            if(!stack.isEmpty()){
                char temp = stack.pop();
                if(temp == '(' && s.charAt(start) != ')'){
                    return false;
                }else if(temp == '[' && s.charAt(start) != ']'){
                    return false;
                }else if(temp == '{' && s.charAt(start) != '}'){
                    return false;
                }
                start++;
            }
        }
        return !stack.isEmpty() ? false :res;
    }
}
