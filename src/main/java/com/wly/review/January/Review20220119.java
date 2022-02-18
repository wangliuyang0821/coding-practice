package com.ctrip.review.January;

import java.util.HashSet;

public class Review20220119 {
    public static void main(String[] args) {

    }

    /*public ListNode reverseKGroup(ListNode head, int k) {

    }
*/

    public ListNode reverseList(ListNode head) {
        ListNode after = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = after;
            after = cur;
            cur = temp;
        }
        return after.next;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while(headA != null){
            hashSet.add(headA);
            headA = headA.next;
        }

        while(headB != null){
            if(hashSet.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while(head != null){
            if(hashSet.contains(head)) return head;
            hashSet.add(head);
            head = head.next;
        }
        return null;
    }

    public boolean hasCycle(ListNode head) {
        boolean res = false;
        HashSet<ListNode> hashSet = new HashSet<>();
        while(head != null){
            if(hashSet.contains(head)) return true;
            hashSet.add(head);
            head = head.next;
        }
        return res;
    }

    public ListNode swapPairs(ListNode head) {
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
        if(head == null) return head;
        ListNode cur = head;
        while(n > 0){
            cur = cur.next;
            n--;
        }

        while(cur != null){
            cur = cur.next;
            head = head.next;
        }
        head.next = head.next.next;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
