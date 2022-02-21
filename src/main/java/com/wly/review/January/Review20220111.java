package com.wly.review.January;

import java.util.Arrays;
import java.util.HashSet;

public class Review20220111 {
    public static void main(String[] args) {
        int[] p = {3,2,2,1};
        System.out.println(numRescueBoats(p,3));
    }

    public static int numRescueBoats(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        int start = 0;
        int end = people.length - 1;
        while(start <= end){
            if(people[start] + people[end] <= limit){
                res++;
                start++;
                end--;
            }else{
                res++;
                end--;
            }
        }
        return res;
    }

    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public boolean hasCycle(ListNode head) {
        boolean res = false;
        ListNode cur = head;
        HashSet<ListNode> hashSet = new HashSet<>();
        while(cur != null){
            if(hashSet.contains(cur)){
                return true;
            }
            hashSet.add(cur);
            cur = cur.next;
        }
        return res;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
