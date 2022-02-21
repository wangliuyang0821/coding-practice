package com.wly.practice;

import java.util.*;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/7/20
 * @备注:
 */
public class testString {
    public static void main(String[] args) {
        String input = "[a[bc]]";
        System.out.println(str2list(input).toString());
    }

    public static List<List<String>> str2list(String str){
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int len = str.length();
        int index = 0;
        while(index < len){
            char tmp = str.charAt(index);
            index++;
            if(tmp == '[' && temp.isEmpty()) continue;

            if(tmp == '[' && !temp.isEmpty()){
                res.add(new ArrayList<>(temp));
                temp.clear();
                continue;
            }
            if(tmp == ']' && !temp.isEmpty()){
                res.add(new ArrayList<>(temp));
                temp.clear();
            }

            if(tmp == ']' && temp.isEmpty())continue;

            temp.add(String.valueOf(tmp));

        }
        return res;
    }

    public static void str2listHandler(String str,int index,List<Object> res,List<Object> temp){
        if(str.charAt(index) == ']'){
            return;
        }

        if(str.charAt(index) == '['){
            str2listHandler(str,index + 1,res,new ArrayList<>());
            res.add(new ArrayList<>(temp));
        }

    }

    public static List<List<Integer>> searchNums(int[] arr){
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];
        searchNumsDFS(arr,0,temp,res,visited);
        return res;
    }

    public static void searchNumsDFS(int[] arr,int start,List<Integer> temp,List<List<Integer>> res,boolean[] visited){
        if(start >= arr.length){
            return;
        }
        for(int i = start;i < arr.length;i++){
            if(!visited[i]){
                visited[i] = true;
                temp.add(arr[i]);
                searchNumsDFS(arr,i + 1,temp,res,visited);
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,List<String>> hashMap = new HashMap<>();

        for(String str : strs){
            char[] ar = str.toCharArray();
            Arrays.sort(ar);
            String sorted = String.valueOf(ar);

            if(hashMap.containsKey(sorted)){
                List<String> list = hashMap.get(sorted);
                list.add(str);
                hashMap.put(sorted,list);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                hashMap.put(sorted,list);
            }
        }


        for(String key : hashMap.keySet()){
            res.add(new ArrayList<>(hashMap.get(key)));
        }
        return res;
    }

    public static String reverseStr(String s, int k) {
        int times = 1;
        int len = s.length();
        int start = 0;
        int end = 0;
        char[] chars = s.toCharArray();
        while(start < len){
            end = Math.min(len, 2 * k * times);
            int dis = end - start;
            if(dis < k){
                swiftStr(chars,start,end - 1);
            }else{
                swiftStr(chars,start,start + k - 1);
            }
            times++;
            start = end;
        }
        return new String(chars);
    }

    public static void swiftStr(char[] chars,int i,int j){
        if(i < j){
            Character temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }

    /*public static String swiftStr(String s,int i,int j){
        char[] chars = s.toCharArray();
        while(i < j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }*/

    public static boolean isValid(String s) {
        boolean res = true;
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++){
            char temp = s.charAt(i);
            if(stack.isEmpty() && (temp == ')' || temp == '}' || temp == ']')){
                return false;
            }

            if(temp == '(' || temp == '{' || temp == '['){
                stack.add(temp);
            }else{
                if((temp == ')' && stack.peek() == '(') || (temp == ']' && stack.peek() == '[') || (temp == '}' && stack.peek() == '{')){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }

        if(!stack.isEmpty()) return false;
        return res;
    }

    public String multiply(String num1, String num2) {
        int temp = (Integer.valueOf(num1)) * (Integer.valueOf(num2));
        return String.valueOf(temp);
    }

    public static void quickSort(int[] arr){
        qSort(arr,0,arr.length - 1);
    }

    public static void qSort(int[] arr,int low,int high){
        if(low < high){
            int mid = partition(arr,low,high);
            qSort(arr,low,mid - 1);
            qSort(arr,mid + 1,high);
        }
    }

    //{7,1,5,3,6,4};
    public static int partition(int[] arr,int low,int high){
        int i = low;
        int j = high - 1;
        int pivot = arr[high];

        while(true){
            while(arr[i] < pivot){
                i++;
            }
            while(j >=0 && arr[j] > pivot){
                j--;
            }

            if(i < j){
                swift(arr,i,j);
            }else{
                break;
            }
        }
        swift(arr,i,high);
        return i;
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        for(int i = 1;i < prices.length;i++){
            max = Math.max(max,prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        return max;
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++){
            dp[i][0] = 1;
        }

        for(int j = 0;j < n;j++){
            dp[0][j] = 1;
        }

        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for(int i = 0;i <= amount;i++){
            for(int coin : coins){
                if(i < coin) continue;
                dp[i] = Math.min(dp[i - coin] + coin,dp[i]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static boolean canJump(int[] nums) {
        int max = nums[0];
        for(int i = 0;i < nums.length;i++){
            if(i <= max){
                max = Math.max(max,nums[i] + i);
            }
        }
        return max >= nums.length - 1 ? true : false;
    }


    public int minCostToMoveChips(int[] position) {
        int res = 0;
        int[] dp = new int[position.length];
        dp[0] = 0;
        dp[1] = 0;
        return res;
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinBackTracking(res,temp,1,n,k);
        return res;
    }

    public static void combinBackTracking(List<List<Integer>> res,List<Integer> temp,int start,int n,int limit){
        if(temp.size() == limit){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start;i <= n;i++){
            temp.add(i);
            combinBackTracking(res,temp,i + 1,n,limit);
            temp.remove(temp.size() - 1);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        res.add(new ArrayList<>());
        subsetsBackTracking(nums,temp,res,0);
        return res;
    }

    public static void subsetsBackTracking(int[] nums,List<Integer> temp,List<List<Integer>> res,int start){
        if(temp.size() >= nums.length){
            return;
        }

        for(int i = start;i < nums.length;i++){
            temp.add(nums[i]);
            subsetsBackTracking(nums,temp,res,i + 1);
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        generateParenthesisDFS(res,"",left,right,n);
        return res;
    }

    public static void generateParenthesisDFS(List<String> res,String temp,int left,int right,int n){
        if(left > n || right > n){
            return;
        }

        if(left == n && right == n){
            res.add(temp);
            return;
        }

        if(left >= right){
            generateParenthesisDFS(res,temp + "(",left + 1,right,n);
            generateParenthesisDFS(res,temp + ")",left,right + 1,n);
        }

    }

    public static int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int temp = 0;

        for(int i = 0;i < nums.length;i++){
            temp = Math.max(temp + nums[i],nums[i]);
            res = Math.max(res,temp);
        }

        return res;
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        return nums[mid];
    }

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while(end > start){
            swift(s,start,end);
            end--;
            start++;
        }
    }

    public static void swift(char[] s,int start,int end){
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
    }

    //a, e, i, o, u if(s.charAt(end) == 'a' || s.charAt(end) == 'e' || s.charAt(end) == 'i' || s.charAt(end) == 'o' || s.charAt(end) == 'u')
    public static int maxVowels(String s, int k) {
        int res = 0;
        int count = 0;
        int start = 0;
        int end = 0;
        while(s.length() > end){
            if(s.charAt(end) == 'a' || s.charAt(end) == 'e' || s.charAt(end) == 'i' || s.charAt(end) == 'o' || s.charAt(end) == 'u'){
                count++;
            }
            if(end - start + 1 == k){
                res = Math.max(count,res);
                if(s.charAt(start) == 'a' || s.charAt(start) == 'e' || s.charAt(start) == 'i' || s.charAt(start) == 'o' || s.charAt(start) == 'u'){
                    count = count - 1;
                }
                start++;
            }
            end++;
        }
        return res;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            sum = sum + nums[i];
            while(sum >= target){
                res = Integer.min(i - start + 1,res);
                sum = sum - nums[start];
                start++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        boolean acc = true;
        boolean isExist = false;
        if(matrix.length == 1 && matrix[0][0] != target){
            return false;
        }
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[i].length;j++){
                if(j == 0){
                    if(matrix[i][j] > matrix[i][j + 1]){
                        return false;
                    }
                    if(i > 0 && matrix[i - 1][matrix[i - 1].length - 1] > matrix[i][0]){
                        return false;
                    }
                }else if(j == matrix[i].length - 1){
                    if(matrix[i][j] < matrix[i][j - 1]){
                        return false;
                    }
                }
                if(matrix[i][j] == target){
                    isExist = true;
                }
            }
        }
        return acc == true && isExist == true ? true : false;
    }

    public static int findPeakElement(int[] nums) {
        int res = -1;
        if(nums.length == 1){
            return 0;
        }

        for(int i = 0;i < nums.length;i++){
            if(i == 0 && nums[i] > nums[i + 1]){
                return i;
            }else if(i == nums.length - 1 & nums[nums.length - 1] > nums[nums.length - 2]){
                return i;
            }else if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]){
                return i;
            }
        }
        return res;
    }

    public static int searchInsert(int[] nums, int target) {
        if(nums[nums.length - 1] < target){
            return nums.length;
        }

        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                low++;
            }else{
                high = mid;
            }
        }
        return high;
    }

    public static int search(int[] nums, int target) {
        int res = -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                high--;
            }else{
                low++;
            }
        }
        return res;
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0;i < nums.length;i++){
            hashSet.add(nums[i]);
        }
        return nums.length == hashSet.size() ? false : true;
    }

    public static int findKthLargest(int[] arr, int k) {
        for(int i = 0;i < arr.length - 1;i++){
            for(int j = 0;j < arr.length - 1 - i;j++){
                if(arr[j] > arr[j + 1]){
                    swift(arr,j,j + 1);
                }
            }
        }
        return arr[arr.length - k];
    }

    public static void swift(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*public static List<String> topKFrequent(String[] words, int k) {

    }*/
}
