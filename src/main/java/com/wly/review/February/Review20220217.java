package com.wly.review.February;

import java.util.HashMap;
import java.util.HashSet;

public class Review20220217 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode cur = head;
        ListNode aft = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = aft;
            aft = cur;
            cur = temp;
        }
        return head;
    }

    public boolean hasCycle(ListNode head) {
        boolean res = false;
        HashSet<ListNode> hashSet = new HashSet<>();
        while(head != null){
            if(hashSet.contains(head)){
                return true;
            }else{
                hashSet.add(head);
                head = head.next;
            }
        }
        return res;
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            int temp = cur.next.val;
            cur.next.val = cur.val;
            cur.val = temp;
            cur.next = cur.next.next;
        }

        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }

        ListNode pre = head;
        ListNode cur = head;
        while(n > 0){
            pre = pre.next;
            n--;
        }

        if(pre == null){
            return head;
        }


        while(pre != null){
            pre = pre.next;
            cur = cur.next;
        }

        cur.next = cur.next.next;



        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
