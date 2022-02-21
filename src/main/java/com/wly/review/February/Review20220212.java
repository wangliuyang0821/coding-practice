package com.wly.review.February;

import java.util.*;

public class Review20220212 {
    public static void main(String[] args) {
        //a%2！=0
        System.out.println((4%2) == 1);

    }

    public static int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == '1'){
                    res++;
                    numIslandsHandler(grid,i,j);
                }
            }
        }
        return res;
    }

    public static void numIslandsHandler(char[][] grid,int x ,int y){
        if(x < 0 || x > grid.length || y < 0 || y > grid[0].length || grid[x][y] == '0'){
            return;
        }

        grid[x][y] = '0';
        numIslandsHandler(grid,x + 1,y);
        numIslandsHandler(grid,x - 1,y);
        numIslandsHandler(grid,x,y + 1);
        numIslandsHandler(grid,x,y - 1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int count = 1;
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
            if(count%2 == 1){
                Collections.reverse(list);
            }
            res.add(new ArrayList<>(list));
            count++;
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
