package com.wly.review.January;

public class Review20220115 {
    public static void main(String[] args) {
        System.out.println(maxVowels("aeiou", 2));
    }

    public static int maxVowels(String s, int k) {
        int max = Integer.MIN_VALUE;
        int res = 0;
        int start = 0;
        int end = -1;
        while(end < s.length()){
            if(end - start + 1 < k){
                end++;
                if(end >= s.length()) break;
                if(isIn(s.charAt(end),"a,e,i,o,u")){
                    res++;
                    max = Math.max(max,res);
                }
            }else{
                if(isIn(s.charAt(start),"a,e,i,o,u")){
                    res--;
                }
                start++;
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public static boolean isIn(char target,String s){
        boolean res = false;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == target){
                return true;
            }
        }
        return res;
    }
}
