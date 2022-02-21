package com.wly.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/5/10
 * @备注:
 */
public class ArrayPractice {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1};
        //System.out.println(findMaxConsecutiveOness(arr));
        /*int[] nums = {0,1,0,3,12};
        moveZeroess(nums);
        for(int i = 0;i < nums.length;i++){
            System.out.println(nums[i]);
        }*/
        /*int[] a = {0,0,0,0};
        System.out.println(threeSum(a).toString());*/
        int[] a = {2,2,2,2,2};
        System.out.println(fourSum(a,8).toString());
    }

    public static void QuickSort(int[] nums){

    }

    public static void qSort(int[] nums,int start,int end){
        int mid = partition(nums,start,end);
        partition(nums,start,mid - 1);
        partition(nums,mid + 1,end);
    }

    public static int partition(int[] nums,int start,int end){
        int i = start;
        int j = end - 1;
        int target = nums[end];
        while(true){
            while(target > nums[i]) i++;
            while(j > 0 && target < nums[j]) j--;

            if(i < j){
                swift(nums,i,j);
            }else{
                break;
            }
        }
        swift(nums,i,end);
        return i;
    }

    public static void swiftNums(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int first = nums[i];
            for(int j = i + 1;j < nums.length;j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int second = nums[j];
                int start = j + 1;
                int end = nums.length - 1;
                while(start < end){
                    if((first + second + nums[start] + nums[end]) == target){
                        res.add(Arrays.asList(first,second,nums[start],nums[end]));
                        start++;
                        while(start < end && nums[start - 1] == nums[start]) start++;
                        end--;
                        while(start < end && nums[end + 1] == nums[end]) end--;
                    }else if((first + second + nums[start] + nums[end]) < target){
                        start++;
                    }else{
                        end--;
                    }
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length - 2;i++){
            if(i > 0 && nums[i - 1] == nums[i]) continue;
            int start = i + 1;
            int end = nums.length - 1;
            int temp = nums[i];
            while(start < end){
                int st = nums[start];
                int en = nums[end];
                if((temp + st + en) == 0){
                    res.add(Arrays.asList(temp,st,en));
                    start++;
                    while(nums[start] == nums[start - 1] && start < end) start++;
                    end--;
                    while(nums[end] == nums[end + 1] && start < end) end--;
                }else if((temp + st + en) > 0){
                    end--;
                }else{
                    start++;
                }
            }
        }
        return res;
    }

    public ListNode reverseList(ListNode head) {
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

    public static int removeElement(int[] nums, int val) {
        int len = nums.length - 1;
        int index = 0;
        while(index <= len){
            if(nums[index] == val){
                swift(nums,index,len);
                len--;
            }else{
                index++;
            }
        }
        return len + 1;
    }

    public static void moveZeroess(int[] nums) {
        int index = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != 0){
                swift(nums,index,i);
                index++;
            }
        }
    }

    public static int findMaxConsecutiveOness(int[] nums) {
        int res = 0;
        int len = nums.length - 1;
        int index = 0;
        int temp = 0;
        while(index <= len){
            if(nums[index] == 0){
                index++;
                res = Math.max(res,temp);
                temp = 0;
            }else{
                index++;
                temp++;
            }
        }
        return Math.max(res,temp);
    }


    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxLength = 0;
        int tempLength = 0;
        if(nums.length > 0){
            for(int i = 0;i < nums.length;i++){
                if(nums[i] == 1){
                    tempLength++;
                }else{
                    maxLength = Math.max(maxLength,tempLength);
                    tempLength = 0;
                }
            }
        }
        return Math.max(maxLength,tempLength);
    }

    public void moveZeroes(int[] nums) {
        if(nums.length < 2){
            return;
        }
        int index = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != 0){
                swift(nums,index,i);
                index++;
            }
        }
    }

    public static void BubbleSort(int[] nums){
        if(nums != null){
            for(int i = 0;i < nums.length;i++){
                for(int j = 0;j < nums.length - i - 1;j++){
                    if(nums[j] > nums[j + 1]){
                        swift(nums,j,j + 1);
                    }
                }
            }
        }
    }

    public static void swift(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
