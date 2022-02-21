package com.wly.practice;

import java.util.ArrayDeque;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/6/7
 * @备注:
 * 写一个 RecentCounter 类来计算特定时间范围内最近的请求。
 *
 * 请你实现 RecentCounter 类：
 *
 * RecentCounter() 初始化计数器，请求数为 0 。
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证 每次对 ping 的调用都使用比之前更大的 t 值。
 */
public class RecentCounter {
    private ArrayDeque<Integer> queue ;
    public RecentCounter() {
        queue = new ArrayDeque<Integer>();
    }

    public int ping(int t) {
        queue.add(t);
        if(!queue.isEmpty()){
            while(queue.peek() < (t - 3000)){
                queue.pop();
            }
        }
        return queue.size();
    }
}
