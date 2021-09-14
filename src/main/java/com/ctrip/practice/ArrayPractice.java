package com.ctrip.practice;

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
        int[] a = {3,2,2,3};
        System.out.println(removeElement(a, 3));
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
