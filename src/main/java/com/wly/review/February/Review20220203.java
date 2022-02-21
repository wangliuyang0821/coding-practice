package com.wly.review.February;

import java.util.*;

public class Review20220203 {

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            TreeNode tempLeft = temp.left;
            temp.left = temp.right;
            temp.right = tempLeft;
            if(temp.left != null) queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);

        }
        return root;
    }

    public int countNodes(TreeNode root) {
        int res = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            TreeNode temp = deque.poll();
            if(temp.left != null) deque.add(temp.left);
            if(temp.right != null) deque.add(temp.right);
            res++;
        }
        return res;
    }

    public boolean isBalanced(TreeNode root) {
        int first = 0;
        int last = 0;
        boolean flag = true;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            while(size > 0){
                TreeNode temp = deque.pollFirst();
                if(temp.left != null){
                    deque.add(temp.left);
                }
                if(temp.right != null) {
                    deque.add(temp.right);
                }
                if(temp.left == null && temp.right == null){
                    flag = false;
                }
                size--;
            }
            if(flag) first++;
            last++;
        }
        System.out.println(last);
        System.out.println(first);
        return last - 1 > first ? false : true;
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        binaryTreePathsHandler(root,res,temp);
        return res;
    }

    public static void binaryTreePathsHandler(TreeNode root,List<String> res,List<Integer> temp){
        if(root == null) return;
        temp.add(root.val);
        if(isLeaf(root)){
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i < temp.size();i++){
                if(i + 1 == temp.size()){
                    sb.append(temp.get(i));
                }else{
                    sb.append(temp.get(i) + "->");
                }
            }
            res.add(sb.toString());
        }else{
            binaryTreePathsHandler(root.left,res,temp);
            binaryTreePathsHandler(root.right,res,temp);
        }
        temp.remove(temp.size() - 1);
    }

    public static boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null ? true : false;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if(root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            while(size > 0){
                TreeNode temp = deque.pollFirst();
                if(temp.left != null && temp.left.left == null && temp.left.right == null){
                    res = res + temp.left.val;
                }
                if(temp.left != null){
                    deque.add(temp.left);
                }
                if(temp.right != null) {
                    deque.add(temp.right);
                }
                size--;
            }
        }
        return res;
    }

    public int findBottomLeftValue(TreeNode root) {
        int res = root.val;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            boolean flag = true;
            while(size > 0){
                TreeNode temp = deque.pollFirst();
                if(flag && temp != null){
                    res = temp.val;
                    flag = false;
                }
                if(temp.left != null) deque.add(temp.left);
                if(temp.right != null) deque.add(temp.right);
                size--;
            }
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
