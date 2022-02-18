package com.ctrip.review.January;

import java.util.*;

public class Review20220107 {
    private static int res = 0;
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(subsets(arr).toString());
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = true;
        Deque<TreeNode> odd = new ArrayDeque<>();
        Deque<TreeNode> even = new ArrayDeque<>();
        odd.add(root);
        while(!odd.isEmpty() || !even.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            if(flag){
                int size = odd.size();
                while(size > 0){
                    TreeNode treeNode = odd.pollFirst();
                    temp.add(treeNode.val);
                    if(treeNode.left != null) even.add(treeNode.left);
                    if(treeNode.right != null) even.add(treeNode.right);
                    size--;
                }
            }else{
                int size = even.size();
                while(size > 0){
                    TreeNode treeNode = even.pollLast();
                    temp.add(treeNode.val);
                    if(treeNode.left != null) odd.add(treeNode.left);
                    if(treeNode.right != null) odd.add(treeNode.right);
                    size--;
                }
            }
            flag = flag ? false : true;
            res.add(new ArrayList<>(temp));
        }
        return res;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            int size = stack.size();
            List<Integer> list = new ArrayList<>();
            while(size > 0){
                TreeNode temp = stack.pop();
                list.add(temp.val);
                if(temp.right != null) stack.add(temp.right);
                if(temp.left != null) stack.add(temp.left);
                size--;
            }
            res.add(new ArrayList<>(list));
        }
        Collections.reverse(res);
        return res;
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        subsetsHandler(nums,0,res,new ArrayList<>());
        return res;
    }

    public static void subsetsHandler(int[] nums,int index,List<List<Integer>> res,List<Integer> temp){
        if(temp.size() > nums.length){
            return;
        }

        for(int i = index;i < nums.length;i++){
            temp.add(nums[i]);
            res.add(new ArrayList<>(temp));
            subsetsHandler(nums,i + 1,res,temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        int res = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            while(size > 0){
                TreeNode temp = deque.pollFirst();
                if(temp.val > low && temp.val < high){
                    res = res + temp.val;
                }
                if(temp.left != null) deque.add(temp.left);
                if(temp.right != null) deque.add(temp.right);
                size--;
            }
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
