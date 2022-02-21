package com.wly.util;

import java.util.*;

public class SQLRandomOne {
    public static void main(String[] args) {
        System.out.println(getOne());
    }

    public static String getOne(){
        Map<String,String> map = new HashMap<>();
        map.put("1","留存率");
        map.put("2","连续登陆");
        map.put("3","观看视频最多的前5个userID");

        List<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            list.add(key);
        }
        int len = list.size() - 1;
        int randomNum = new Random().nextInt(len);
        String index = list.get(randomNum);
        System.out.println("index:"+index);
        return map.get(index);
    }
}
