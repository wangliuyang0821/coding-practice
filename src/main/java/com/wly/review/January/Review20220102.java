package com.wly.review.January;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Review20220102 {
    public static void main(String[] args) {
        //System.out.println(isValid("(("));
        /*int[] arr = {7,2,4};
        int[] res = maxSlidingWindow(arr,2);
        for(int i = 0;i < res.length;i++){
            System.out.print(res[i]);
        }*/
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> deque = new LinkedList<>();
        for(int i = 0;i < s.length();i++){
            if(!deque.isEmpty() && deque.peekLast() == s.charAt(i)){
                deque.pollLast();
                continue;
            }


            if(deque.isEmpty() || s.charAt(i) != deque.peekLast()){
                deque.add(s.charAt(i));
            }


        }
        while(!deque.isEmpty()) sb.append(deque.pollFirst());
        return sb.toString();
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0;i < nums.length;i++){
            //保留最大的数在队列中
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }

            //超出k窗口限制
            while(i - k  + 1 >= 0 && !deque.isEmpty() && i - k + 1 > deque.peekFirst()){
                deque.pollFirst();
            }
            deque.add(i);

            if(i - k + 1 >= 0){
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

    public static boolean isValid(String s) {
        if (s.length() < 2) return false;
        boolean res = true;
        Stack<Character> stack = new Stack<>();
        int start = 0;
        int end = s.length();
        while (start < end) {
            char temp = s.charAt(start);
            if ((temp == ')' || temp == ']' || temp == '}') && stack.isEmpty()) {
                return false;
            }

            if ((temp == ')' || temp == '}' || temp == ']') && !stack.isEmpty()) {
                char stackPop = stack.pop();
                if (temp == ')' && stackPop != '(') return false;
                if (temp == ']' && stackPop != '[') return false;
                if (temp == '}' && stackPop != '{') return false;
            }

            if (temp == '(' || temp == '{' || temp == '[') {
                stack.add(temp);
            }

            start++;
        }
        return !stack.isEmpty() ? false : res;
    }
}
