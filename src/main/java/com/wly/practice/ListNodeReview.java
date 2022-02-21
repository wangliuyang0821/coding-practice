package com.wly.practice;

public class ListNodeReview {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode cur = head;
        ListNode aft = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = aft;
            aft = cur;
            cur = temp;
        }
        return aft;
    }
}
