package com.ctrip.review.February;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Review20220204 {
    public static void main(String[] args) {

    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0){
            return null;
        }
        int coreVal = preorder[0];
        TreeNode root = new TreeNode(coreVal);
        for(int i = 0;i < inorder.length;i++){
            if(inorder[i] == coreVal){
                root.left = buildTree(Arrays.copyOfRange(preorder,i,i + 1),Arrays.copyOfRange(inorder,0,i));
                root.right = buildTree(Arrays.copyOfRange(preorder,i + 1,inorder.length),Arrays.copyOfRange(inorder,i + 1,inorder.length));
            }
        }

        return root;
    }

    public static void flatten(TreeNode root) {
        List<Integer> list = preOrder(root);

    }

    public static List<Integer> preOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
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

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null){
            return root;
        }

        return left != null ? left : right;
    }

    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    public int depth(TreeNode root){
        if(root == null) return 0;

        int left = depth(root.left);
        int right = depth(root.right);

        max = Math.max(max,right + left);

        return Math.max(left,right) + 1;
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
