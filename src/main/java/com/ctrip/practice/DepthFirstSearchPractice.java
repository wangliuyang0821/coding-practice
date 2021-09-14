package com.ctrip.practice;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/7/14
 * @备注:
 */
public class DepthFirstSearchPractice {
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

    public int rangeSumBST(TreeNode root, int low, int high) {
        int res = 0;
        rangeSumBSTHandler(root,low,high,res);
        return res;
    }

    public void rangeSumBSTHandler(TreeNode root,int low,int high,int res){
        if(root == null){
            return;
        }
        int temp = root.val;
        if(temp > low && temp < high){
            res += temp;
        }
        rangeSumBSTHandler(root.left,low,high,res);
        rangeSumBSTHandler(root.right,low,high,res);
    }

}
