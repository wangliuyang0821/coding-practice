package com.wly.review.January;

public class Review20220121 {
    static int count = 0;
    public static void main(String[] args) {
        if(count < 3){
            count++;
            main(null);
        }else {
            return;
        }
        System.out.println("111");
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == q || root == p) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null) return root;
        return left == null ? right : left;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root,long low,long high){
        if(root == null) return true;
        int v = root.val;
        if(v <= low || v >= high) return false;
        return isValidBST(root.left,low,v) && isValidBST(root.right,v,high);
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
}
