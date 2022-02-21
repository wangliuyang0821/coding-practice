package com.wly.practice;

import java.util.*;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/6/22
 * @备注:
 */
public class HeapPractice {
    public static void main(String[] args) {
        String[] str = "i,love,leetcode,i,love,coding".split(",");
        System.out.println(topKFrequent(str, 2).toString());
    }

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String str : words){
            if(!map.containsKey(str)){
                map.put(str,1);
                list.add(str);
            }else{
                int temp = map.get(str);
                map.put(str,temp + 1);
            }
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                int t1 = map.get(str1);
                int t2 = map.get(str2);
                if(t1 == t2) {
                    return str1.compareTo(str2);
                }else{
                    return t2 - t1;
                }
            }
        });
        return list.subList(0,k);
    }
}
