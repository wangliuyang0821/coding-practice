package com.ctrip.review.January;

import java.util.*;

public class Review20220122 {
    public static void main(String[] args) {
        String input = "a,banana,app,appl,ap,apply,apple";
        System.out.println(longestWord(input.split(",")));
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();

        Map<String,Integer> map = new HashMap<>();
        for(String s : words){
            if(map.containsKey(s)){
                map.put(s,map.get(s) + 1);
            }else{
                map.put(s,1);
                res.add(s);
            }
        }

        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int val1 = map.get(o1);
                int val2 = map.get(o2);
                if(val1 == val2){
                    return o1.compareTo(o2);
                }else {
                    return val2 - val1;
                }
            }
        });
        return res.subList(0,k);
    }

    public static String longestWord(String[] words) {
        String res = "";
        Arrays.sort(words);
        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0;i < words.length;i++){
            String temp = words[i];
            if(hashSet.contains(temp.substring(0,temp.length() - 1)) || temp.length() == 1){
                hashSet.add(temp);
                if(res.length() < temp.length()){
                    res = temp;
                }
            }
        }
        return res;
    }
}
