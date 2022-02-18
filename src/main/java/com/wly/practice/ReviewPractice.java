package com.ctrip.practice;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/8/20
 * @备注:
 */
public class ReviewPractice {
    public static void main(String[] args) {
        int[] arr = {3,2,2,1};
        System.out.println(numRescueBoats(arr, 3));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;

        int high = people.length - 1;
        int low = 0;
        while(high >= low){
            if(people[high] + people[low] <= limit){
                low++;
            }
            res++;
            high--;
        }

        return res;
    }

    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while(start <= end){
            swift(s,start,end);
            start++;
            end--;
        }
    }

    public void swift(char[] s,int start,int end){
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
    }

    public boolean hasCycle(ListNode head) {
        boolean res = false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && slow != null && fast.next != null){
            if(fast == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return res;
    }
}
