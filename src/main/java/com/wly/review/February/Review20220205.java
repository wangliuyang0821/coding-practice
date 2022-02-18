package com.ctrip.review.February;

import java.util.*;

public class Review20220205 {
    public static void main(String[] args) {

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

    public List<Integer> preOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            res.add(treeNode.val);
            if(treeNode.right != null) stack.add(treeNode.right);
            if(treeNode.left != null) stack.add(treeNode.left);
        }
        return res;
    }

    public boolean isSymmetric(TreeNode root) {
        boolean res = true;
        Deque<TreeNode> deque = new LinkedList<>();
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            while(size > 0){
                TreeNode temp = deque.pollFirst();
                list.add(temp.val);
                if(temp.left != null) deque.add(temp.left);
                if(temp.right != null) deque.add(temp.right);
                size--;
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }

    public int maxDepth(TreeNode root) {
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            int size = stack.size();
            while(size > 0){
                TreeNode temp = stack.pop();
                if(temp.left != null) stack.add(temp.left);
                if(temp.right != null) stack.add(temp.right);
                size--;
            }
            res++;
        }
        return res;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
