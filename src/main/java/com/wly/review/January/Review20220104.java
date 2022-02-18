package com.ctrip.review.January;

import java.util.*;

public class Review20220104 {
    private static int max = 0;
    public static void main(String[] args) {

    }

    public static int diameterOfBinaryTree(TreeNode root){
        depth(root);
        return max;
    }

    public static int depth(TreeNode root){
        if(root == null){
            return 0;
        }

        int l = depth(root.left);
        int r = depth(root.right);

        max = Math.max(max,l + r);
        return 1 + Math.max(l,r);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null){
            return root;
        }

        return left != null ? left : right;
    }

    public static void flatten(TreeNode root) {
        List<TreeNode> preOrdList = preOrd(root);
        for(int i = 1;i < preOrdList.size();i++){
            TreeNode prev = preOrdList.get(i - 1);
            prev.left = null;
            prev.right = preOrdList.get(i);
        }
    }

    public static List<TreeNode> preOrd(TreeNode root){
        List<TreeNode> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            res.add(temp);
            if(temp.right != null) stack.add(temp.right);
            if(temp.left != null) stack.add(temp.left);
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
                TreeNode treeNode = stack.pop();
                if(treeNode.left != null) stack.add(treeNode.left);
                if(treeNode.right != null) stack.add(treeNode.right);
                size--;
            }
            res++;
        }
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> temp = new ArrayList<>();
            while(size > 0){
                TreeNode t = deque.pollFirst();
                temp.add(t.val);
                if(t.left != null) deque.add(t.left);
                if(t.right != null) deque.add(t.right);
                size--;
            }
            res.add(new ArrayList<>(temp));
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
