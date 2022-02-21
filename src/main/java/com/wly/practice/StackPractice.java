package com.wly.practice;

import java.util.*;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/6/2
 * @备注:
 * 先遍历大数组nums2，首先将第一个元素入栈；
 * 继续遍历，当当前元素小于栈顶元素时，继续将它入栈；当当前元素大于栈顶元素时，栈顶元素出栈，此时应将该出栈的元素与当前元素形成key-value键值对，存入HashMap中；
 * 当遍历完nums2后，得到nums2中元素所对应的下一个更大元素的hash表；
 * 遍历nums1的元素在hashMap中去查找‘下一个更大元素’，当找不到时则为-1。
 */
public class StackPractice {
    public static void main(String[] args) {
        /*int[] arr1 = new int[]{4,1,2};
        int[] arr2 = new int[]{1,3,4,2};
        nextGreaterElements(arr1,arr2);
        String s = "(";
        System.out.println(isValids(s));*/
        /*System.out.println(cal(" 2-1 + 2 "));
        System.out.println(System.currentTimeMillis());
        String s = "]";
        System.out.println(isValidss(s));
        */
        /*int[] arr1 = {1,3,5,2,4};
        int[] arr2 = {6,5,4,3,2,1,7};
        nextGreaterElementss(arr1, arr2);*/

        /*String[] strArray={"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(strArray));*/
        /*int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(arr,3);
        for(int i = 0;i < res.length;i++){
            System.out.println(res[i]);
        }*/
        /*String str = "abbaca";
        System.out.println(removeDuplicates(str));*/
        /*String str = "a good   example";
        System.out.println(reverseWords(str));*/
        String str = "abcdefg";
        //System.out.println(reverseStr(str, 2));
        //System.out.println(swiftStr(str,0,str.length() - 1));
    }


    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for(String str : s.trim().split(" ")){
            if(str.length() != 0 && !str.equalsIgnoreCase(" ")){
                stack.add(str);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }
        return sb.toString().substring(0,sb.length() - 1);
    }

    public static String removeDuplicates(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for(int i = 0;i < s.length();i++){
            Character pre = null;
            if(!deque.isEmpty() && deque.peekLast() == s.charAt(i)){
                deque.pollLast();
            }else{
                deque.add(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1){
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0;i < nums.length;i++){
            if(i + 1 >= k  && i - k + 1 > deque.peekFirst() ){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.add(i);
            if(i - k + 1 >= 0){
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

    public static int evalRPN(String[] tokens) {
        if(tokens.length == 1) return Integer.parseInt(tokens[0]);
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(!s.equalsIgnoreCase("+") && !s.equalsIgnoreCase("/") && !s.equalsIgnoreCase("*") && !s.equalsIgnoreCase("-")){
                stack.push(Integer.parseInt(s));
            }else{
                int first = stack.pop();
                int second = stack.pop();
                if(s.equalsIgnoreCase("+")){
                    res = first + second;
                }else if(s.equalsIgnoreCase("/")){
                    res = second / first;
                }else if(s.equalsIgnoreCase("*")){
                    res = second * first;
                }else{
                    res = second - first;
                }
                stack.push(res);
            }
        }
        return res;
    }

    /**
     * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
     *
     * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
     *
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
     * **/
    public static int[] nextGreaterElementss(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = nums2.length - 1;i >= 0;i--){
            int temp = nums2[i];
            while(!stack.isEmpty() && temp > stack.peek()){
                stack.pop();
            }

            if(!stack.isEmpty() && stack.peek() > temp){
                map.put(temp,stack.peek());
            }
            if(stack.isEmpty()){
                map.put(temp,-1);
            }
            stack.push(temp);
        }

        for(int i = 0;i < nums1.length;i++){
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

    public static boolean isValidss(String s) {
        Stack<String> stack = new Stack<>();
        Map<String,String> map = new HashMap<>();
        map.put(")","(");
        map.put("}","{");
        map.put("]","[");
        char[] chars = s.toCharArray();
        for(char c : chars){
            String temp = String.valueOf(c);
            if(isContain(temp,"{,(,[")){
                stack.push(temp);
            }
            if(isContain(temp,"},),]")){
                if(stack.isEmpty() || !map.get(temp).equalsIgnoreCase(stack.peek())){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public static int cal(String s){
        String target = s.replaceAll(" ","");
        if(target.length() == 0){
            return 0;
        }

        int res = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 0;i < target.length();i++){
            int cur = 0;
            if(target.charAt(i) == '('){
                i++;
                cur = cal(target);
            }else{
                while(target.length() > i && Character.isDigit(target.charAt(i))){
                    cur = cur * 10 + (target.charAt(i) - '0');
                    i++;
                }
            }

            if(sign == '+'){
                stack.push(cur);
            }else if(sign == '-'){
                stack.push(-cur);
            }else if(sign == '*'){
                int temp = stack.pop();
                stack.push(temp * cur);
            }else if(sign == '/'){
                int temp = stack.pop();
                stack.push(temp / cur);
            }

            if(target.length() > i && target.charAt(i) == ')'){
                i++;
            }

            if(target.length() > i){
                sign = target.charAt(i);
            }
        }

        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    public static int calculate(String s) {
        String target = s.replaceAll(" ","");
        if(target.length() == 0){
            return 0;
        }

        int res = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 0;i < target.length();i++){
            int cur = 0;
            while(i < target.length() && Character.isDigit(target.charAt(i))){
                cur = cur * 10 + (target.charAt(i) - '0');
                i++;
            }

            if(sign == '+'){
                stack.push(cur);
            }else if(sign == '-'){
                stack.push(-cur);
            }else if(sign == '*'){
                int temp = stack.pop();
                stack.push(temp * cur);
            }else if(sign == '/'){
                int temp = stack.pop();
                stack.push(temp / cur);
            }

            if(i < target.length()){
                sign = target.charAt(i);
            }
        }

        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    public static boolean isValids(String s) {
        if(s == null){
            return false;
        }
        HashMap<String,String> map = new HashMap<>();
        map.put("{","}");
        map.put("[","]");
        map.put("(",")");
        Stack<String> stack = new Stack<>();
        boolean res = true;
        for(int i = 0;i < s.length();i++){
            String temp = String.valueOf(s.charAt(i));
            if(map.containsKey(temp)){
                stack.push(temp);
            }else{
                if(stack.isEmpty() || !map.get(stack.peek()).equalsIgnoreCase(temp)){
                    return false;
                }else if (map.get(stack.peek()).equalsIgnoreCase(temp)){
                    stack.pop();
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }


    public static int[] nextGreaterElements(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap();
        for(int i = nums2.length - 1;i >= 0;i--){
            int temp = nums2[i];
            while(!stack.isEmpty() && temp > stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                map.put(temp,-1);
            }else{
                map.put(temp,stack.peek());
            }
            stack.push(temp);
        }
        int[] data = new int[nums1.length];
        for(int i = 0;i < nums1.length;i++){
            data[i] = map.get(nums1[i]);
        }
        return data;
    }

    public static boolean isValid(String s) {
        if(s == null){
            return true;
        }
        Map map = new HashMap<String,String>();
        map.put(")","(");
        map.put("}","{");
        map.put("]","[");


        Stack stack = new Stack();
        for(int i = 0; i < s.length(); i++) {
            String in = String.valueOf(s.charAt(i));
            if(isContain(in,"(,{,[")){
                stack.push(in);
            }else{
                if(stack.empty()){
                    return false;
                }else{
                    String popOut = stack.pop().toString();
                    if(!map.get(in).toString().equalsIgnoreCase(popOut)){
                        return false;
                    }
                }
            }
        }

        return stack.empty() ? true : false;
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


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] data = new int[nums1.length];
        for(int i = nums2.length - 1;i >=0;i--){
            int temp = nums2[i];
            while(!stack.isEmpty() && stack.peek() < temp){
                stack.pop();
            }
            if(stack.isEmpty()){
                map.put(temp,-1);
            }else {
                map.put(temp,stack.peek());
            }
            stack.push(temp);
        }

        for(int i = 0;i < nums1.length;i++){
            System.out.println(nums1[i]);
            data[i] = map.get(nums1[i]);
        }
        return data;
    }
}
