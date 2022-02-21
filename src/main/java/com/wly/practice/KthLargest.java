package com.wly.practice;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class KthLargest {
    Set<Integer> hashSet = new TreeSet<>();
    int top = 0;
    public KthLargest(int k, int[] nums) {
        top = k;
        for(int num : nums){
            hashSet.add(num);
        }
    }

    public int add(int val) {
        int count = 0;
        int res = 0;
        hashSet.add(val);
        Iterator<Integer> it = hashSet.iterator();
        while(it.hasNext()){
            if(count == top){
                res = it.next();
            }
            count++;
        }
        return res;
    }
}
