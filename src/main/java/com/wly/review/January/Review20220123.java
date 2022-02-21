package com.wly.review.January;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Review20220123 {
    public static void main(String[] args) {
        /*int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
        for(int i : arr){
            System.out.println(i);
        }*/
        int[][] map = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(map).toString());
    }

    public static void spiralOrders(int[][] matrix){
        int left = 0;
        int up = 0;
        int right = matrix[0].length - 1;
        int high = matrix.length - 1;
        while(true){
            for(int i = left;i <= right;i++){
                System.out.println(matrix[up][i]);
            }
            up++;
            if(up > high) break;

            for(int i = up;i <= high;i++){
                System.out.println(matrix[i][right]);
            }
            right--;
            if(right < left) break;

            for(int i = right;i >= left;i--){
                System.out.println(matrix[high][i]);
            }
            high--;
            if(high < up) break;

            for(int i = high;i >= up;i--){
                System.out.println(matrix[i][left]);
            }
            left++;
            if(left > right) break;
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int bottom = 0;
        int right = matrix[0].length - 1;
        int high = matrix.length - 1;
        while(true){
            for(int i = left;i <= right;i++){
                res.add(matrix[bottom][i]);
            }
            bottom++;
            if(bottom > high) break;

            for(int i = bottom;i <= high;i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(right < left) break;

            for(int i = right;i >= left;i--){
                res.add(matrix[high][i]);
            }
            high--;
            if(bottom > high) break;

            for(int i = high;i >= bottom;i--){
                res.add(matrix[i][left]);
            }
            left++;
            if(right < left) break;
        }
        return res;
    }

    public static int[] sortedSquares(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            int temp = nums[i];
            nums[i] = temp * temp;
        }

        Arrays.sort(nums);
        return nums;
    }

    public static void bubbleSort(int[] arr){
        for(int i = 0;i < arr.length - 1;i++){
            for(int j = 0;j < arr.length - 1 - i;j++){
                if(arr[j] > arr[j + 1]){
                    swift(arr,j,j + 1);
                }
            }
        }
    }

    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int index = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != val){
                swift(nums,i,index);
                index++;
            }
        }
        return nums.length - index;
    }

    public static void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != 0){
                swift(nums,i,index);
                index++;
            }
        }
    }

    public static void swift(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int temp = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 1){
                temp++;
                res = Math.max(temp,res);
            }else{
                temp = 0;
            }

        }
        return res;
    }
}
