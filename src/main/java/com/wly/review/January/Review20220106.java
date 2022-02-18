package com.ctrip.review.January;

import java.util.HashSet;

public class Review20220106 {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        HashSet<ListNode> hashSet = new HashSet<>();
        while(headA != null){
            hashSet.add(headA);
            headA = headA.next;
        }

        while(headB != null){
            if(hashSet.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public boolean hasCycle(ListNode head) {
        boolean res = false;
        HashSet<ListNode> hashSet = new HashSet<>();
        while(head != null){
            if(hashSet.contains(head)){
                return true;
            }
            hashSet.add(head);
            head = head.next;
        }
        return res;
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            int temp = cur.val;
            cur.val = cur.next.val;
            cur.next.val = temp;
            cur = cur.next.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode after = head;
        while(n > 0){
            pre = pre.next;
            n--;
        }

        if(pre == null) return head;

        while(pre != null){
            pre = pre.next;
            after = after.next;
        }
        after.next = after.next.next;
        return head;
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = pre;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return pre.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
