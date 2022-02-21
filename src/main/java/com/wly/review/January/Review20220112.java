package com.wly.review.January;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Review20220112 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            while(size > 0){
                TreeNode temp = deque.pollFirst();
                list.add(temp.val);
                if(temp.left != null) deque.add(temp.left);
                if(temp.right != null) deque.add(temp.right);
                size--;
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            while(size > 0){
                TreeNode temp = deque.pollFirst();
                list.add(temp.val);
                if(temp.left != null) deque.add(temp.left);
                if(temp.right != null) deque.add(temp.right);
                size--;
            }
            res.add(new ArrayList<>(list));
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
