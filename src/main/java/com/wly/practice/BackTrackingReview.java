package com.wly.practice;

import java.util.*;

public class BackTrackingReview {
    private static boolean isFind;

    public static void main(String[] args){
        int[] nums = {1,2,3};
        char[][] xx = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(xx,"ABCCED"));
    }



    public static boolean exist(char[][] board, String word){
        boolean res = false;
        isFind  = false;
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                boolean[][] visited = new boolean[board.length][board[0].length];
                if(board[i][j] == word.charAt(0)){
                    existHandler(board,0,i,j,word,visited);
                    if(isFind) return true;
                }
            }
        }
        return res;
    }

    public static void existHandler(char[][] board,int index,int x,int y,String word,boolean[][] visited){
        if(x >= board.length || x < 0 || y >= board[0].length || y < 0 || visited[x][y] == true || word.charAt(index) != board[x][y] || isFind){
            return;
        }

        visited[x][y] = true;
        if(index == word.length() - 1){
            isFind = true;
            return;
        }
        existHandler(board,index + 1,x + 1,y,word,visited);
        existHandler(board,index + 1,x - 1,y,word,visited);
        existHandler(board,index + 1,x,y + 1,word,visited);
        existHandler(board,index + 1,x,y - 1,word,visited);
        visited[x][y] = false;
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[i].length;j++){
                if(grid[i][j] == '1'){
                    count++;
                    numIslandsHandler(grid,i,j);
                }
            }
        }
        return count;
    }

    public void numIslandsHandler(char[][] grid,int x,int y){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0'){
            return;
        }

        grid[x][y] = '0';
        numIslandsHandler(grid,x - 1,y);
        numIslandsHandler(grid,x + 1,y);
        numIslandsHandler(grid,x,y - 1);
        numIslandsHandler(grid,x,y + 1);
    }

    public List<String> letterCombinationss(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        Map<Character,String> map  = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        //letterCombinationBFSHandler(digits,0,map,new StringBuilder(),res);
        return res;
    }



    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        subsetsBFS(nums,0,new ArrayList<>(),res);
        return res;
    }

    public static void subsetsBFS(int[] nums,int index,List<Integer> temp,List<List<Integer>> res){
        if(temp.size() > nums.length){
            return;
        }
        for(int i = index;i < nums.length;i++){
            temp.add(nums[i]);
            res.add(new ArrayList<>(temp));
            subsetsBFS(nums,i + 1,temp,res);
            temp.remove(temp.size() - 1);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        /*for(int i = 0;i < nums.length;i++){
            permuteBFS(nums,i,visited,temp,res);
        }*/
        permuteBFS(nums,0,visited,temp,res);
        return res;
    }

    public static void permuteBFS(int[] nums,int index,boolean[] visited,List<Integer> temp,List<List<Integer>> res){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            temp.add(nums[i]);
            permuteBFS(nums,i + 1,visited,temp,res);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public static List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        Map<Character,String> map  = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        letterCombinationsBFS(digits,0,map,new StringBuilder(),res);
        return res;
    }

    public static void letterCombinationsBFS(String digits,int index,Map<Character,String> map,StringBuilder temp,List<String> res){
        if(temp.length() == digits.length()){
            res.add(temp.toString());
            return;
        }

        Character c = digits.charAt(index);
        String target = map.get(c);
        for(int i = 0;i < target.length();i++){
            temp.append(target.charAt(i));
            letterCombinationsBFS(digits,index + 1,map,temp,res);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumBFS(candidates,0,target,temp,res);
        return res;
    }

    public static void combinationSumBFS(int[] candidates,int start,int target,List<Integer> temp,List<List<Integer>> res){
        if(target < 0){
            return;
        }

        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start;i < candidates.length;i++){
            temp.add(candidates[i]);
            combinationSumBFS(candidates,i,target - candidates[i],temp,res);
            temp.remove(temp.size() - 1);
        }
    }


    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesisBFS(0,0,n,"",res);
        return res;
    }

    public static void generateParenthesisBFS(int left,int right,int n,String temp,List<String> res){
        if(left < right || left > n || right > n){
            return;
        }

        if(left == n && right == n){
            res.add(temp);
            return;
        }

        if(left < n){
            generateParenthesisBFS(left + 1,right,n,temp + "(",res);
        }

        if(right < n){
            generateParenthesisBFS(left,right + 1,n,temp + ")",res);
        }
    }


    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combineBFS(1,k,n,temp,res);
        return res;
    }

    public static void combineBFS(int start,int k,int n,List<Integer> temp,List<List<Integer>> res){
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start;i <= n;i++){
            temp.add(i);
            combineBFS(i + 1,k,n,temp,res);
            temp.remove(temp.size() - 1);
        }
    }

}
