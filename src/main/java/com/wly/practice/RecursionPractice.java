package com.wly.practice;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/7/5
 * @备注:
 */
public class RecursionPractice {
    public int fib(int n) {
        if(n == 1 || n == 0){
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public ListNode reverseList(ListNode head) {
        ListNode aft = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = aft;
            aft = cur;
            cur = temp;
        }
        return aft;
    }

    public void reverseString(char[] s) {
        if(s == null){
            return;
        }
        int start = 0;
        int end = s.length - 1;
        while(start <= end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
