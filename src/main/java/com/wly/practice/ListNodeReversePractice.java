package com.ctrip.practice;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/1/28
 * @备注:
 */
public class ListNodeReversePractice {
    public static void main(String[] args) {
        ListNode listNode = initLink();
        /*printLink(listNode);
        System.out.println("-----------");
        listNode.next = preNode;
        printLink(listNode);
        System.out.println("----------------");*/
        printLink(listNode);
        ListNode res = reverseList(listNode);
        System.out.println("----------------");
        printLink(res);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            cur = temp;
            pre = cur;
        }
        return pre;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode res = null;
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
        return res;
    }


    public static ListNode initLink(){
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for(int i = 1;i < 6;i++){
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return head;
    }

    public static void printLink(ListNode listNode){
        if(listNode == null){
            return;
        }
        ListNode curr = listNode;
        while(curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    public ListNode reverseLists(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode cur = head;
        ListNode after = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = after;
            after = cur;
            cur = temp;
        }
        return after;
    }
}
