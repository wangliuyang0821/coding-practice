package com.wly.practice;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/6/23
 * @备注:
 */
public class TwoPointPractice {
    public static void main(String[] args) {
        /*DecimalFormat df=new DecimalFormat("0.00");
        float temp = (float)5 / 3;
        System.out.println(Math.floor(temp));
        System.out.println((int)Math.floor(temp));*/
        int[] arr = new int[]{3,2,2,1};
        System.out.println(numRescueBoats(arr, 3));

    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(true){
            try{
                slow = slow.next;
                fast = fast.next.next;
            }catch (Exception e){
                return false;
            }

            if(slow == fast){
                return true;
            }
        }
    }

    public boolean hasCycles(ListNode head) {
        if(head == null){
            return false;
        }

        HashSet<ListNode> hashSet = new HashSet<>();

        while(head.next != null){
            if(hashSet.contains(head)){
                return true;
            }
            hashSet.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycless(ListNode head) {
        if(head == null){
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && slow != null && fast.next != null){
            if(fast == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    public void reverseString(char[] s) {
        if(s == null){
            return;
        }
        int len = s.length;
        for(int i = 0;i < len;i++){
            if(i >= len){
                break;
            }
            char temp = s[i];
            s[i] = s[len];
            s[len] = temp;
            len--;
        }
    }


    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        int start = 0;
        int end = people.length - 1;
        while(start <= end){
            int s = people[start];
            int e = people[end];
            if(start == end){
                res++;
                end--;
                break;
            }else if((s + e) <= limit){
                res++;
                start++;
                end--;
            }else if((s + e) > limit){
                res++;
                end--;
            }
        }
        return res;
    }

    public static void sortArr(int[] arr){
       if(arr == null || arr.length < 2){
           return;
       }
       for(int i = 0;i < arr.length;i++){
           for(int j = 0;j < arr.length - i -1;j++){
               if(arr[j] < arr[j + 1]){
                   swift(arr,j,j + 1);
               }
           }
       }
    }


    public static void swift(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
