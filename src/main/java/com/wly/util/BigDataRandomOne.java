package com.ctrip.util;

import java.util.*;

public class BigDataRandomOne {
    public static void main(String[] args) {
        //35,18,25,14,12,36,37,38
        System.out.println(getOne());
    }

    public static String getOne(){
        Map<String,String> map = new HashMap<>();
        map.put("1","HashMap的数据结构是什么？如何实现的？和hashtable、ConcurrentHashMap的区别？");
        map.put("2","ArrayList是如何实现的，ArrayList和LinkedList的区别？ArrayList如何实现扩容?");
        map.put("3","synchronized和volatile的使用方法和区别");
        map.put("4","Hbase读写基本流程");
        map.put("5","乐观锁与悲观锁");
        map.put("6","理解spark中的job、stage、task");
        map.put("7","kafka的消息传递方式");
        map.put("8","Spark的driver和executor");
        map.put("9","Java虚拟机");
        map.put("10","接口和抽象类有什么区别");
        map.put("11","List、set、map之间的区别是什么");
        map.put("12","spark mapreduce和hive mapreduce的区别，以及spark的优势与缺点");
        map.put("13","mapreduce过程");
        map.put("14","spark执行流程");
        map.put("15","维度建模");
        map.put("16","zookeeper选举");
        map.put("17","Lock与synchronized有以下区别");
        map.put("18","kafka如何保证数据不丢失");
        map.put("19","kafka零拷贝");
        map.put("20","spark内存模型");
        map.put("21","HDFS读写数据流程");
        map.put("22","namenode的作用");
        map.put("23","HBase的HMaster的作用");
        map.put("24","HDFS再上传文件的时候，如果其中一个块突然损坏了怎么办");
        map.put("25","order by和sort by的区别 cluster by和distribute by的区别");
        map.put("26","spark partition分区策略");
        map.put("27","Flink架构");
        map.put("28","spark shuffle调优");
        map.put("29","写入tidb性能优化");
        map.put("30","spark rdd的五大特性");
        map.put("31","flink checkpoint的对齐");
        map.put("32","rebalance与rescale的区别");
        map.put("33","Flink 从checkpoint恢复，并行度改变后，状态重分配");
        map.put("34","spark shuffle");
        map.put("35","spark rdd五大特性");
        map.put("36","Flink checkpoint 与 Spark checkpoint有什么区别或优势");
        map.put("37","对于迟到数据是怎么处理的");
        map.put("38","Flink 集群有哪些角色？各自有什么作用");
        map.put("39","Flink 资源管理中 Task Slot 的概念");
        map.put("40","Flink 的重启策略");
        map.put("41","如果下级存储不支持事务，Flink 怎么保证 exactly-once");
        map.put("42","Flink 是如何处理反压的");
        map.put("43","Flink 中的状态存储");
        map.put("44","简单说一下 hadoop 和 Spark 的 shuffle 相同和差异？");
        map.put("45","RDD 的弹性表现在哪几点");
        map.put("46","介绍一下 join 操作优化经验");
        map.put("47","Hive 中的压缩格式 TextFile、SequenceFile、RCfile 、ORCfile各有什么区别？");


        int len = map.size() - 1;
        int randomNum = new Random().nextInt(len);
        String content = map.get(String.valueOf(randomNum));
        System.out.println("index:"+randomNum);
        return content;
    }
}
