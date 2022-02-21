package com.wly.practice;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/6/29
 * @备注:
 */
public class BinarySearchPractice {
    public static void main(String[] args) {
        /*int[] arr = new int[]{1,2,3,1};
        //System.out.println(search(arr, 9));
        System.out.println(findPeakElement(arr));

        int [][] arrs =new int[][]{{4,5,6,8},{2,3},{1,6,9}};
        System.out.println(arr.length);*/
        int[] arr = {5,7,7,8,8,10};
        int[] res = searchRanges(arr, 8);
        for(int i : res){
            System.out.println(i);
        }
    }

    public static int[] searchRanges(int[] nums,int target){
        int len = nums.length;
        if(len == 0) return new int[]{-1,-1};

        int first = findFirstPosition(nums,target);
        if(first == -1){
            return new int[]{-1,-1};
        }

        int last = findLastPosition(nums,target);
        return new int[]{first,last};
    }

    public static int findFirstPosition(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] == target){
                right = mid;
            }else{
                right = mid - 1;
            }
        }

        if(nums[left] == target){
            return left;
        }
        return -1;
    }

    public static int findLastPosition(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right + 1) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] == target){
                left = mid;
            }else{
                right = mid - 1;
            }
        }

        if(nums[left] == target){
            return left;
        }
        return -1;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if(nums.length == 0){
            return res;
        }
        boolean isFind = false;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == target && !isFind){
                res[0] = i;
                res[1] = i;
                isFind = true;
            }else if(nums[i] == target && isFind){
                res[1] = i;
            }else if(nums[i] > target && !isFind){
                return res;
            }
        }
        return res;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        boolean acc = true;
        boolean exist = false;
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[i].length;j++){
                if(j != 0 && matrix[i][j - 1] > matrix[i][j]){
                    return false;
                }
                if(matrix[i][j] == target){
                    exist = true;
                }
            }
        }
        return acc && exist;
    }

    public static int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        for(int i = 0;i < nums.length;i++){
            if(i == 0 ){
                if(nums[i] > nums[i + 1]){
                    return i;
                }
            }else if(i == nums.length - 1){
                if(nums[i] > nums[i - 1]){
                    return i;
                }
            }else if(nums[i - 1] < nums[i] && nums[i + 1] < nums[i]){
                return i;
            }
        }
        return 0;
    }

    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(nums[nums.length - 1] < target){
            return len;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid;
            }
        }
        return right;
    }



    public static int search(int[] nums, int target) {
        /*int res = -1;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == target){
                res = i;
                break;
            }
        }
        return res;*/
        int res = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target){
                res = mid;
                break;
            }else if(nums[mid] < target){
                start++;
            }else{
                end--;
            }
        }
        return res;
    }


}
