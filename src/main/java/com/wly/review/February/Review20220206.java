package com.wly.review.February;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Review20220206 {
    public static void main(String[] args) {

    }

    private int res = 0;
    public int countNodes(TreeNode root) {
        if(root != null){
            res++;
            countNodes(root.right);
            countNodes(root.left);
        }
        return res;
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        binaryTreePathsHandler(root,res,list);
        return res;
    }

    public static void binaryTreePathsHandler(TreeNode root,List<String> res,List<Integer> list){
        if(root == null) return;
        if(root.left == null && root.right == null){
            list.add(root.val);
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i < list.size();i++){
                if(i != list.size() - 1){
                    sb.append(list.get(i)+"->");
                }else{
                    sb.append(list.get(i).toString());
                }
            }
            res.add(sb.toString());
            return;
        }

        list.add(root.val);
        binaryTreePathsHandler(root.left,res,list);
        binaryTreePathsHandler(root.right,res,list);
        list.remove(list.size() - 1);
    }



    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return true;
        if(root.right == null && root.left == null){
            return targetSum == root.val ? true : false;
        }
        return hasPathSum(root,targetSum - root.val);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }

        int coreVal = preorder[0];
        TreeNode root = new TreeNode(coreVal);
        for(int i = 0;i < inorder.length;i++){
            if(coreVal == inorder[i]){
                root.left = buildTree(Arrays.copyOfRange(preorder,1,i + 1),Arrays.copyOfRange(inorder,0,i));
                root.right = buildTree(Arrays.copyOfRange(preorder,i + 1,inorder.length),Arrays.copyOfRange(inorder,i + 1,inorder.length));
            }
        }
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] > max){
                maxIndex = i;
                max = nums[i];
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,maxIndex));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums,maxIndex + 1,nums.length));
        return root;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }

        TreeNode root = new TreeNode((root1 == null ? 0 : root1.val) + (root2 == null ? 0 : root2.val));
        root.left = mergeTrees(root1 == null ? null : root1.left,root2 == null ? null : root2.left);
        root.right = mergeTrees(root1 == null ? null : root1.right,root2 == null ? null : root2.right);
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
