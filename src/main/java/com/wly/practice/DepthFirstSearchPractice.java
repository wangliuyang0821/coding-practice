package com.wly.practice;

import java.util.HashSet;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/7/14
 * @备注:
 */
public class DepthFirstSearchPractice {
    public static void main(String[] args) {
       char[][] table = {{'5','3','.','.','7','.','.','.','.'},
                         {'6','.','.','1','9','5','.','.','.'},
                         {'.','9','8','.','.','.','.','6','.'},
                         {'8','.','.','.','6','.','.','.','3'},
                         {'4','.','.','8','.','3','.','.','1'},
                         {'7','.','.','.','2','.','.','.','6'},
                         {'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
       System.out.println(isValidSudoku(table));
        //System.out.println('9' - '1');
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

    public static boolean isValidSudoku(char[][] board) {
        //检测行
        boolean[][] htest = new boolean[10][10];
        //检测列
        boolean[][] ltest = new boolean[10][10];
        //检测box
        HashSet<String> btest = new HashSet<>();

        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                if(board[i][j] == '.') continue;

                int temp = Integer.parseInt(String.valueOf(board[i][j]));
                int x = i / 3;
                int y = j / 3;
                if(htest[i][temp] == true || ltest[temp][j] == true || btest.contains(x+"="+y+board[i][j])){
                    return false;
                }


                btest.add(x+"="+y+board[i][j]);

                htest[i][temp] = true;
                ltest[temp][j] = true;
            }
        }

        return true;
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
