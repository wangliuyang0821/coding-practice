package com.wly.review.January;

import java.util.HashSet;

public class Review20220113 {
    public static void main(String[] args) {

    }

    public boolean containsDuplicate(int[] nums) {
        boolean res = false;
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i : nums){
            if(hashSet.contains(i)){
                return true;
            }
            hashSet.add(i);
        }
        return res;
    }
}
