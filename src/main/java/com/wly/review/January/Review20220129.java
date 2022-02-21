package com.wly.review.January;

import java.util.Arrays;

public class Review20220129 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] temp = Arrays.copyOfRange(arr,0,2);
        for(int i : temp){
            System.out.println(i);
        }
        int[] temp2 = Arrays.copyOfRange(arr,2,4);
        for(int i : temp2){
            System.out.println(i);
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int len = preorder.length;

        for(int i = 0;i < inorder.length;i++){
            if(preorder[0] == inorder[i]){
                root.left = buildTree(Arrays.copyOfRange(preorder,1,i),Arrays.copyOfRange(inorder,0,i));
                root.right = buildTree(Arrays.copyOfRange(preorder,i + 1,len),Arrays.copyOfRange(inorder,i + 1,len));
            }
        }
        return root;
    }


    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }

        TreeNode newTree = new TreeNode((root1 == null ? 0 : root1.val) + (root2 == null ? 0 : root2.val));
        newTree.left = mergeTrees(root1.left == null ? null : root1.left,root2.left == null ? null : root2.left);
        newTree.right = mergeTrees(root1.right == null ? null : root1.right,root2.right == null ? null : root2.right);
        return newTree;
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

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
