package com.wly.review.February;

import java.util.*;

public class Review20220207 {

    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }

        int rootVal = preorder[0];
        int n = preorder.length;
        TreeNode root = new TreeNode(rootVal);
        for(int i = 0;i < n;i++){
            if(rootVal == inorder[i]){
                root.left = buildTree(Arrays.copyOfRange(preorder,1,i + 1),Arrays.copyOfRange(inorder,0,i));
                root.right = buildTree(Arrays.copyOfRange(preorder,i + 1,n),Arrays.copyOfRange(inorder,i + 1,n));
            }
        }
        return root;
    }

    public static void flatten(TreeNode root) {
        List<Integer> res = preOrder(root);
        for(int i = 1;i < res.size();i++){
            TreeNode pre = new TreeNode(res.get(i - 1));
            TreeNode cur = new TreeNode(res.get(i));
            pre.left = null;
            pre.right = cur;
        }
    }

    public static List<Integer> preOrder(TreeNode root){
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

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == q || root == p){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(right != null && left != null){
            return root;
        }
        return left == null ? right : left;
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    public static int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        max = Math.max(max,(left + right));
        return Math.max(left,right) + 1;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            TreeNode temp = deque.pollFirst();
            TreeNode tempLeft = temp.left;
            temp.left = temp.right;
            temp.right = tempLeft;
            if(temp.left != null) deque.add(temp.left);
            if(temp.right != null) deque.add(temp.right);
        }
        return root;
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
