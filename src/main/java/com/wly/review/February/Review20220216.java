package com.wly.review.February;


public class Review20220216 {

    private static int max = 0;

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
    }

    public static String longestPalindrome(String s) {
        if(s.length() == 0){
            return s;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        for(int i = 0;i < s.length();i++){
            int l = i - 1;
            int r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                int len = r - l + 1;
                if(len > max){
                    max = len;
                    left = l;
                    right = r;
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                int len = r - l + 1;
                if(len > max){
                    max = len;
                    left = l;
                    right = r;
                }
                l--;
                r++;
            }
        }
        return s.substring(left,right + 1);
    }

    public static boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }


    public static int depth(TreeNode root){
        if(root.left == null && root.right == null){
            return 0;
        }

        int left = depth(root);
        int right = depth(root);

        max = Math.max(max,left + right);

        return Math.max(left,right) + 1;
    }

    public int longestUnivaluePath(TreeNode root) {
        return max;
    }

    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start <= end) {
            char temp = s[start];
            s[start] = s[end];
            s[start] = temp;
            start++;
            end--;
        }
    }

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        ListNode aft = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = aft;
            aft = cur;
            cur = temp;
        }
        return head;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
