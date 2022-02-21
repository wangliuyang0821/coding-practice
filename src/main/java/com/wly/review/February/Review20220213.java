package com.wly.review.February;

public class Review20220213 {
    public static void main(String[] args) {
       /* int[] arr = {1,2,3};
        System.out.println(searchRange(arr, 1));*/
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        int start = 1;
        int end = x;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int sqrt = x / mid;
            if(sqrt == mid){
                return mid;
            }else if(mid > sqrt){
                start = mid - 1;
            }else{
                end = mid + 1;
            }
        }
        return end;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            if(nums[start] == target && res[0] == -1){
                res[0] = start;
            }else if(res[0] == -1){
                start++;
            }

            if(nums[end] == target && res[1] == -1){
                res[1] = end;
            }else if(res[1] == -1){
                end--;
            }

            if(res[0] != -1 && res[1] != -1) break;
        }

        for(int i : res){
            System.out.println(i);
        }
        return res;
    }
}
