package com.wly.review.February;

import java.util.HashMap;
import java.util.Stack;

public class Review20220209 {
    public static void main(String[] args) {
        /*System.out.println(isValid("([)]"));*/
        /*int[] arr1 = {1,3,5,2,4};
        int[] arr2 = {6,5,4,3,2,1,7};
        nextGreaterElement(arr1,arr2);*/
        String str = "kkk";
        System.out.println(str.hashCode());
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = nums2.length - 1;i >= 0;i--){
            if(stack.isEmpty()){
                hashMap.put(nums2[i],-1);
                stack.add(nums2[i]);
            }else{
                while(!stack.isEmpty() && nums2[i] > stack.peek()){
                    stack.pop();
                }

                if(!stack.isEmpty() && nums2[i] < stack.peek()){
                    hashMap.put(nums2[i],stack.peek());
                    stack.add(nums2[i]);
                }


                if(stack.isEmpty()){
                    hashMap.put(nums2[i],-1);
                    stack.add(nums2[i]);
                }
            }
        }

        for(int i = 0;i < nums1.length;i++){
            res[i] = hashMap.get(nums1[i]);
        }

        return res;
    }

    public static boolean isValid(String s) {
        boolean res = true;
        Stack<Character> stack = new Stack<>();
        int start = 0;
        while(start < s.length()){
            Character temp = s.charAt(start);

            if(stack.isEmpty() && (temp == ']' || temp == ')' || temp == '}')){
                return false;
            }

            if(temp == '(' || temp == '{' || temp == '['){
                stack.add(temp);
                start++;
                continue;
            }

            Character pre = stack.pop();
            if(temp == '}' && pre != '{'){
                return false;
            }

            if(temp == ')' && pre != '('){
                return false;
            }

            if(temp == ']' && pre != '['){
                return false;
            }
            start++;
        }
        return !stack.isEmpty() ? false : res;
    }
}
