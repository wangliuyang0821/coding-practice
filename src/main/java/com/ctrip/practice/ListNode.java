package com.ctrip.practice;

import java.util.HashSet;
import java.util.List;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/1/28
 * @备注:
 */
public class ListNode {
    public static void main(String[] args) {
        ListNode newList = null;
        newList = new ListNode(1);

        newList = new ListNode(2);
        list(newList);
    }

    public ListNode removeElement(ListNode head, int val) {
        ListNode pre = new ListNode(0);
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

    /*int val;
    ListNode next;

    public ListNode(int x){
        val = x;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"val\":")
                .append(val);
        sb.append('}');
        return sb.toString();


    public ListNode reverseList(ListNode head) {
    ListNode cursor = head;
    ListNode newList = null;
    while (cursor != null) {
        // 用一个临时变量记录下下一个节点，因为后面 cursor 要被重新赋值
        ListNode tmp = cursor.next;
        // 用当前节点作为新链表的头节点
        cursor.next = newList;
        // 然后当前节点为头结点就是翻转后的新链表
        newList = cursor;
        // 游标被改了，这里改回来指向下一个要翻转的节点
        cursor = tmp;
    }

    return newList;
}
    }*/
       int val;
       ListNode next;

      public ListNode(int val) {
          this.val = val;
      }

      public void reverse(ListNode head){
          if(head == null){
              return;
          }
          ListNode aft = null;
          ListNode cur = head;
          while(cur != null){
              ListNode temp = cur.next;
              cur.next = aft;
              aft = cur;
              cur = temp;
          }
      }

      public ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }

      public static void list(ListNode listNode){
          while(listNode != null){
              System.out.println(listNode.val);
              listNode = listNode.next;
          }
      }

    public ListNode reverseList(ListNode head) {
          ListNode newList = null;
          ListNode cur = head;
          while(cur != null){
              ListNode temp = cur.next;
              cur.next = newList;
              cur = temp;
              newList = cur;
          }
          return newList;
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
          ListNode head = new ListNode(0);
          ListNode cur = head;
          while(l1 != null && l2 != null){
              if(l1.val < l2.val){
                  cur.next = l1;
                  cur = cur.next;
                  l1 = l1.next;
              }else{
                  cur.next = l2;
                  cur = cur.next;
                  l2 = l2.next;
              }
          }

          if(l1 != null){
              cur.next = l1;
          }
          if(l2 != null){
              cur.next = l2;
          }
          return head.next;
    }

    public ListNode deleteDuplicates(ListNode head){
          if(head == null){
              return null;
          }
          if(head.next == null){
              return head;
          }
          ListNode cur = head;
          while(cur != null && cur.next != null){
              if(cur.val == cur.next.val){
                  cur.next = cur.next.next;
              }else{
                  cur = cur.next;
              }
          }
          return head;
    }

    public ListNode removeElementss(ListNode head, int val) {
          if(head == null){
              return head;
          }
          ListNode res = new ListNode(0);
          res.next = head;
          ListNode cur = res;
          while (cur.next != null){
              if(cur.next.val == val){
                  cur.next = cur.next.next;
              }else{
                  cur = cur.next;
              }
          }
          return res.next;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
          if(headA == null || headB == null){
              return null;
          }

          ListNode tempA = headA;
          ListNode tempB = headB;

          int lenA = getListNodeLength(headA);
          int lenB = getListNodeLength(headB);

          while(lenA != lenB){
              if(lenA < lenB){
                  tempB = tempB.next;
                  lenB--;
              }else{
                  tempA = tempA.next;
                  lenA--;
              }
          }

          while(tempA != null){
              if(tempA == tempB){
                  return tempA;
              }else{
                  tempA = tempA.next;
                  tempB = tempB.next;
              }
          }
          return null;
    }

    /*public ListNode deleteDuplicates(ListNode head) {
          if(head == null || head.next == null){
            return head;
        }

        ListNode cur = head;
        while(cur != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }*/

    public static int getListNodeLength(ListNode head){
          int res = 0;
          ListNode temp = head;
          while(temp != null){
              temp = temp.next;
              res += 1;
          }
          return res;
    }

    public static ListNode removeElements(ListNode head, int val) {
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



    public ListNode deleteDuplicatess(ListNode head) {
          if(head == null || head.next == null){
              return head;
          }
          ListNode cur = head;
          while(cur != null && cur.next != null){
              if(cur.val == cur.next.val){
                  cur.next = cur.next.next;
              }else{
                  cur = cur.next;
              }
          }
          return head;
    }


    public ListNode removeElementsss(ListNode head, int val) {
        if(head == null){
            return head;
        }
        ListNode res =  new ListNode(0);
        res.next = head;
        ListNode cur = res;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return res.next;
    }

    public ListNode reverseListss(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode cur = head;
        ListNode newList = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = newList;
            newList = cur;
            cur = temp;
        }
        return newList;
    }

}
