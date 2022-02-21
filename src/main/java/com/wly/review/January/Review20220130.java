package com.wly.review.January;

import java.util.Arrays;

public class Review20220130 {
    public static void main(String[] args) {
        int[] arr = {3,9,20,15,7};
        int[] pre = Arrays.copyOfRange(arr,0,1);
        for(int i : pre){
            System.out.println(i);
        }
        System.out.println("11111");
        int[] inorder = Arrays.copyOfRange(arr,1 + 1,arr.length);
        for(int i : inorder){
            System.out.println(i);
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.right == null && root.left == null){
            return root.val == targetSum;
        }
        return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right,targetSum - root.val);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0) return null;
        int max = nums[0];
        int index = 0;
        for(int i = 1;i < nums.length;i++){
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,index));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums,index + 1,nums.length));
        return root;
    }

    public TreeNode buildTrees(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0){
            return null;
        }

        int rootVal = postorder[postorder.length - 1];
        int len = postorder.length;
        TreeNode root = new TreeNode(rootVal);
        for(int i = 0;i < inorder.length;i++){
            if(inorder[i] == rootVal){
                root.left = buildTree(Arrays.copyOfRange(inorder,0,i),Arrays.copyOfRange(postorder,0,i));
                root.right = buildTree(Arrays.copyOfRange(inorder,i + 1,len),Arrays.copyOfRange(postorder,i,len - 1));
            }
        }
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0){
            return null;
        }

        int rootVal = preorder[0];
        int len = preorder.length;
        TreeNode root = new TreeNode(rootVal);
        for(int i = 0;i < inorder.length;i++){
            if(inorder[i] == rootVal){
                root.left = buildTree(Arrays.copyOfRange(preorder,1,i + 1),Arrays.copyOfRange(inorder,0,i));
                root.right = buildTree(Arrays.copyOfRange(preorder,i + 1,len),Arrays.copyOfRange(inorder,i + 1,len));
            }
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

        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
