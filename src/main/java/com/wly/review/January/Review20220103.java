package com.ctrip.review.January;

import java.util.*;

public class Review20220103 {
    public static void main(String[] args) {

    }

    public List<Integer> pre(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if(temp.right != null) stack.add(temp.right);
            if(temp.left != null) stack.add(temp.left);
        }
        return res;
    }

    public List<Integer> aft(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if(temp.left != null) stack.add(temp.left);
            if(temp.right != null) stack.add(temp.right);
        }
        Collections.reverse(res);
        return res;
    }

    public boolean isSymmetric(TreeNode root) {
        boolean res = true;
        Queue<TreeNode> deque = new LinkedList<>();
        deque.add(root.left);
        deque.add(root.right);
        while(!deque.isEmpty()){
            TreeNode left = deque.poll();
            TreeNode right = deque.poll();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;

            deque.add(left.left);
            deque.add(right.right);
            deque.add(left.right);
            deque.add(right.left);
        }
        return res;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.add(cur);
                cur = cur.left;
            }

            TreeNode treeNode = stack.pop();
            res.add(treeNode.val);
            cur = treeNode.right;
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
