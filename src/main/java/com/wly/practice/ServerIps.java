package com.ctrip.practice;

import java.util.*;

public class ServerIps {
    public static final List<String> LIST = Arrays.asList("A","B","C");

    public static final Map<String,Integer> WEIGHT_LIST = new LinkedHashMap<>();

    static {
        WEIGHT_LIST.put("A",2);
        WEIGHT_LIST.put("B",3);
        WEIGHT_LIST.put("C",5);
    }

    public static String getServerByWeightRandom(){
        //生成随机数作为list下标
        List<String> ips = new ArrayList<>();

        for(String ip: ServerIps.WEIGHT_LIST.keySet()){
            Integer weight = ServerIps.WEIGHT_LIST.get(ip);

            for(int i = 0;i < weight;i++){
                ips.add(ip);
            }
        }

        Random random = new Random();
        int randomPos = random.nextInt(ips.size());
        return ips.get(randomPos);
    }
}
