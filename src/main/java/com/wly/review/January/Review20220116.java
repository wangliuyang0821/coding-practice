package com.ctrip.review.January;

public class Review20220116 {
    public static void main(String[] args) {

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

    public static void numIslandsHandler(char[][] grid,int x,int y){
        if(x >= grid.length || x < 0 || y >= grid[0].length || y < 0 || grid[x][y] == '0'){
            return;
        }

        grid[x][y] = '0';
        numIslandsHandler(grid,x + 1,y);
        numIslandsHandler(grid,x - 1,y);
        numIslandsHandler(grid,x,y + 1);
        numIslandsHandler(grid,x,y - 1);
    }
}
