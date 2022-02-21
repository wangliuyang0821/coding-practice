package com.wly.review.January;

import java.util.ArrayList;
import java.util.List;

public class Review20220117 {
    public static void main(String[] args) {
        //System.out.println(reverseWords("  hello world  "));
        System.out.println(7 / 4);
    }

    public static String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int times = s.length() / (2 * k);
        int start = 0;
        int end = s.length();
        while(start < end){
            if(times > 0){
                swift(sb,s,start,k);
            }
            if(times == 0 && (end - start) > 0){

            }
            start = start + (2 * k);
            times--;
        }
        return sb.toString();
    }

    public static void swift(StringBuilder sb,String s,int start,int k){
        String temp = s.substring(start,start + 2 * k);
    }

    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while(start <= end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        List<String> list = new ArrayList<>();
        for(String str : arr){
            if(str.replaceAll(" ","").length() == 0) continue;
            list.add(str);
        }

        System.out.println(list.toString());

        for(int i = list.size() - 1;i >= 0;i--){
            sb.append(list.get(i) + " ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
