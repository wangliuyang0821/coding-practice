package com.wly.practice;

import java.util.Stack;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/6/5
 * @备注:
 */
public class MyQueue {
    private Stack<Integer> a;// 输入栈
    private Stack<Integer> b;// 输出栈

    /** Initialize your data structure here. */
    public MyQueue() {
        a = new Stack<>(); //input
        b = new Stack<>(); //output
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        a.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(b.isEmpty()){
            while(!a.isEmpty()){
                b.push(a.pop());
            }
        }
        return b.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(b.isEmpty()){
            while(!a.isEmpty()){
                b.push(a.pop());
            }
        }
        return b.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
       return a.isEmpty() && b.isEmpty();
    }
}
