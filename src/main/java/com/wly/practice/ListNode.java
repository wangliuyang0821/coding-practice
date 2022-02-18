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
        String res = "";
        res.toLowerCase().replaceAll("\\?","").replaceAll("\\!","").replaceAll("\\,","").replaceAll("\\.","");
        System.out.println(getSql("pageid,keyid,key_params,isactive", "dim_log_key_params_config"));

    }

    public ListNode oddEvenLists(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while(odd != null && even != null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }

        odd.next =evenHead;
        return head;
    }

    //根据字段名称和表名拼接insert语句--重复覆盖更新
    public static String getSql(String keys,String tableName){
        StringBuilder sbkey = new StringBuilder();
        StringBuilder sbw = new StringBuilder();
        StringBuilder result = new StringBuilder();
        StringBuilder update = new StringBuilder();
        if(!keys.isEmpty() && !tableName.isEmpty()){
            for(String k : keys.split(",")){
                sbkey.append(k).append(",");
                sbw.append("?").append(",");
                update.append(k).append(" = values(").append(k+"),");
            }
            result.append("insert into "+tableName)
                    .append(" ("+sbkey.substring(0,sbkey.toString().length() - 1)+")")
                    .append(" values (")
                    .append(sbw.substring(0,sbw.toString().length() - 1))
                    .append(") ON DUPLICATE KEY UPDATE ")
                    .append(update.substring(0,update.length() - 1));
        }

        return result.toString();
    }


    public ListNode removeNthFromEnds(ListNode head, int n) {
        ListNode pre = head;
        ListNode aft = head;

        while(n > 0){
            pre = pre.next;
            n--;
        }

        if(pre == null){
            return head;
        }

        while(pre != null){
            pre = pre.next;
            aft = aft.next;
        }

        aft.next = aft.next.next;
        return head;
    }


    public ListNode reverseLists(ListNode head) {
        if(head == null) return null;

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

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode oddList = head;
        ListNode evenList = head.next;
        ListNode evenHead = evenList;
        while(evenList != null && evenList.next != null){
            oddList.next = oddList.next.next;
            oddList = oddList.next;

            evenList.next = evenList.next.next;
            evenList = evenList.next;
        }

        oddList.next = evenHead;
        return head;
    }

    public ListNode getIntersectionNodes(ListNode headA, ListNode headB) {
        ListNode res = null;
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode a = headA;
        ListNode b = headB;
        while(a != null){
            hashSet.add(a);
            a = a.next;
        }

        while(b != null){
            if(hashSet.contains(b)){
                return b;
            }
            b = b.next;
        }
        return res;
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while(cur != null){
            if(set.contains(cur)){
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }

    public boolean hasCycle(ListNode head) {
        boolean res = false;
        ListNode fast = head;
        ListNode slow = head;
        while(slow != null || fast !=  null){

            if(slow == fast) return true;
            try{
                slow = slow.next;
                head = head.next.next;
            }catch (Exception e){
                return false;
            }

        }
        return res;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        //前继节点
        ListNode prev = dummy;
        while(prev != null){
            ListNode start = prev.next;
            ListNode end = prev.next;

            //定位本组结束的节点
            for(int i = 0;i < k - 1;i++){
                end = end.next;
            }

            if(end == null) break;

            ListNode follow = end.next;//缓存本组的后继节点
            end.next = null; //切断后边的分组
            prev.next = reverseListNode(start); //反转
            //反转完成，要把指针移动到下组需要的位置
            start.next = follow;//重新连接
            prev = start;
        }

        return dummy.next;
    }

    public static ListNode reverseListNode(ListNode head){
        ListNode pre = new ListNode(-1);
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            int temp = cur.val;
            cur.val = cur.next.val;
            cur.next.val = temp;
        }
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while(n-- > 0){
            fast = fast.next;
        }

        if(fast == null) return head.next;

        ListNode slow = head;
        while(fast.next == null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
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

      public ListNode testl(ListNode head,int n){
          ListNode fast= head;
          ListNode slow = head;
          while(n > 0){
              fast = fast.next;
              n--;
          }

          if(fast.next == null) return head.next;

          while(fast.next != null){
              fast = fast.next;
              slow = slow.next;
          }
          slow.next = slow.next.next;
          return head;
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
