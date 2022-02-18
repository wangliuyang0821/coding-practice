package com.ctrip.practice;

public class testFastSort {
    public static void main(String[] args) {
        /*int[] arr = {3,2,6,8,9,10,1};
        quickSort(arr,0,arr.length - 1);

        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }*/
        /*int[][] arr = {{1,2,3,4}, {5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printNums(arr);*/
        //int[] arr = {9,5,2,11,12,4,3,1,7};
        int[] arr = {2,3,5,6,4,1};
        quickSort(arr);
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }


    public static void quickSort(int[] arr){
        qSort(arr,0,arr.length - 1);
    }

    public static void qSort(int[] arr,int low,int high){
        if(low < high){
            int mid = partition(arr,low,high);
            quickSort(arr,low,mid - 1);
            quickSort(arr,mid + 1,high);
        }
    }

    public static int partition(int[] arr,int low,int high){
        int i = low;
        int j = high - 1;
        int value = arr[high];
        while(true){
            while(arr[i] < value){
                i++;
            }
            while(j >= 0 && arr[j] > value){
                j--;
            }

            if(j > i){
                swap(arr,i,j);
            }else{
                break;
            }
        }

        swap(arr,i,high);
        return i;
    }

    public static void printNums(int[][] arr){
        int left = 0;
        int right = arr.length - 1;
        int top = 0;
        int bottom = arr[0].length - 1;

        while(true){
            if(left <= right && top <= bottom){
                for(int i = left;i <= right;i++){
                    System.out.println("1:"+arr[top][i]);
                }
                top++;
            }

            if(top <= bottom){
                for(int i = top;i <= bottom;i++){
                    System.out.println("2:"+arr[i][right]);
                }
                right--;
            }

            if(left <= right && top <= bottom){
                for(int i = right;i >= left;i--){
                    System.out.println("3:"+arr[bottom][i]);
                }
                bottom--;
            }

            if(top <= bottom ){
                for(int i = bottom;i >= top;i--){
                    System.out.println("4:"+arr[i][left]);
                }
                left++;
            }

            if(top >= bottom && left >= right){
                break;
            }
        }
    }

   public static void quickSort(int[] arr,int left,int right){
        if(left >= right){
            return;
        }

        int i = left;
        int j = right;
        int temp = arr[left];

        while(i != j){
            while(i < j && arr[j] > temp){
                j--;
            }
            swap(arr,i,j);

            while(i < j && arr[i] < temp){
                i++;
            }
            swap(arr,i,j);
        }

        quickSort(arr,i + 1,right);
        quickSort(arr,left,i - 1);
   }

   public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
   }
}
