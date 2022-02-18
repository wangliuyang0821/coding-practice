package com.ctrip.util;

import java.util.*;

public class JavaRandomOne {
    public static void main(String[] args) {
        //20,16,25,17,23,9,3,8
        System.out.println(getOne());
    }

    public static String getOne(){
        Map<String,String> map = new HashMap<>();
        map.put("1","面向对象");
        map.put("2","JVM性能调优实战");
        map.put("3","JDK、JRE和JVM区别和联系");
        map.put("4","==和equals比较");
        map.put("5","final");
        map.put("6","String、StringBuffer和StringBuilder的区别和使用场景");
        map.put("7","重载和重写的区别");
        map.put("8","接口和抽象类的区别");
        map.put("9","list和set");
        map.put("10","hashcode和equals");
        map.put("11","ArrayList和LinkedList的区别");
        map.put("12","HashMap和HashTable的区别及底层实现");
        map.put("13","ConcurrentHashMap原理简述，jdk7和jdk8的区别");
        map.put("16","java类加载器有哪些");
        map.put("17","双亲委派模型");
        map.put("18","java中的异常体系");
        map.put("19","GC如何判断对象可以被回收");
        map.put("20","线程的生命周期及状态");
        map.put("21","sleep、wait、join、yield");
        map.put("22","对线程安全的理解");
        map.put("23","Thread和Runnable");
        map.put("24","说说你对守护线程的理解");
        map.put("25","ThreadLocal的原理和使用场景");
        map.put("26","ThreadLocal内存泄露的原因，如何避免");
        map.put("27","并发、并行和串行的区别");
        map.put("28","并发的三大特性");
        map.put("29","为什么要使用线程池，参数解释");
        map.put("30","线程池处理流程");
        map.put("31","线程池中阻塞队列的作用？为什么是先添加队列而不是先创建最大线程？");
        map.put("32","线程池的复用原理");

        int len = map.size() - 1;
        int randomNum = new Random().nextInt(len);
        String content = map.get(String.valueOf(randomNum));
        System.out.println("index:"+randomNum);
        return content;
    }
}
