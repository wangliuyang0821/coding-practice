package com.ctrip.practice;

import java.util.*;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/7/15
 * @备注:
 */
public class FindUnionPractice {
    public static void main(String[] args) {
        //char[][] arr ={{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        //System.out.println(numIslands(arr));
        //[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
        int[][] nums = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        //print(nums);
        //System.out.println(findCircleNum(nums));
        boolean[] arr = new boolean[3];
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        int len = accounts.size();
        Map<String,Integer> nameTimes = new HashMap<>();
        boolean[] visited = new boolean[len];
        for(List<String> list : accounts){
            nameTimes.put(list.get(0),nameTimes.getOrDefault(list.get(0),0) + 1);
        }

        for(int i = 0;i < len;i++){
            if(!visited[i]){
                visited[i] = true;
                int showCnt = nameTimes.get(accounts.get(i).get(0));
                HashSet tempSet = new HashSet();
                if(showCnt == 1){
                    List<String> temp = new ArrayList<>();
                    temp.add(accounts.get(i).get(0));
                    for(String str : accounts.get(i)){
                        tempSet.add(str);
                    }
                    List<String> accountTemp = new ArrayList<>(tempSet);
                    Collections.sort(accountTemp);
                    res.add(temp);
                    res.add(accountTemp);
                }else{

                }
            }
        }
        return res;
    }

    public List<List<String>> accountsMerge3(List<List<String>> accounts) {
        int accountsLen = accounts.size();
        //不再检查已经加到 res中的ArrayList元素
        boolean [] checked = new boolean[accountsLen];
        //判断是否是有相同名字的 ArrayList元素，没有的话直接输出
        HashMap<String, Integer>  nameTimes = new HashMap<>();
        //结果
        List<List<String>> res = new ArrayList<>();
        //首先判断名字是否重复
        for(List<String> tempList : accounts){
            nameTimes.put(tempList.get(0), nameTimes.getOrDefault(tempList.get(0), 0)+1);
        }

        for(int i = 0; i < accountsLen; i++){
            if(!checked[i]){
                checked[i] = true;
                String name = accounts.get(i).get(0);
                List<String> accountsTemp = accounts.get(i);
                HashSet<String> accountsSet = new HashSet<>();
                for(int j = 1; j < accountsTemp.size(); j++){
                    accountsSet.add(accountsTemp.get(j));
                }
                //名字出现一次的直接输出
                if(nameTimes.get(name) == 1){
                    System.out.println("1");
                    List<String> tempList = new ArrayList<>(accountsSet);
                    //字典排序又想账户
                    Collections.sort(tempList);
                    List<String> subAccounts = new ArrayList<>();
                    subAccounts.add(name);
                    subAccounts.addAll(tempList);
                    res.add(subAccounts);
                }else{
                    //遍历剩下的 ArrayList，找同名的。
                    for(int j = i+1; j < accountsLen; j++){
                        if(!checked[j]){
                            if(name.equals(accounts.get(j).get(0))){
                                for(String ss : accounts.get(j)){
                                    if(accountsSet.contains(ss)){
                                        checked[j] = true;
                                        for(int k = 1; k < accounts.get(j).size(); k++) accountsSet.add(accounts.get(j).get(k));
                                        //如果找到从头遍历。从而便利出所有两两相重的情况。
                                        j = i;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    List<String> tempList = new ArrayList<>(accountsSet);
                    Collections.sort(tempList);
                    List<String> subAccounts = new ArrayList<>();
                    subAccounts.add(name);
                    subAccounts.addAll(tempList);
                    res.add(subAccounts);
                }
            }
        }

        return res;

    }


    public List<List<String>> accountsMerge2(List<List<String>> accounts) {
        Map<String,Integer> emailToIndex = new HashMap<>(); //邮箱 --> 索引
        Map<String,String> emailToName = new HashMap<>(); //邮箱 --> 用户名
        int emailsCount = 0;
        for(List<String> account : accounts){
            String name = account.get(0);
            int size = account.size();
            for(int i = 1;i < size;i++){
                String email = account.get(i);
                if(!emailToIndex.containsKey(email)){
                    emailToIndex.put(email,emailsCount++);
                    emailToName.put(email,name);
                }
            }
        }
        UnionFind3 uf = new UnionFind3(emailsCount);

        Map<Integer,List<String>> indexToEmails = new HashMap<>();
        for(String email : emailToIndex.keySet()){
            int index = uf.find(emailToIndex.get(email));
            //新建账号或者在之前的账号上面加
            List<String> account = indexToEmails.getOrDefault(index,new ArrayList<>());
            account.add(email);
            indexToEmails.put(index,account);
        }

        List<List<String>> merged = new ArrayList<>();
        for(List<String> emails : indexToEmails.values()){
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        return merged;
    }

    private class UnionFind3{
        int[] parent;
        public UnionFind3(int n){
            parent = new int[n];
            for(int i = 0;i < n;i++){
                parent[i] = i;
            }
        }

        public void union(int x,int y){
            parent[find(y)] = find(x);
        }

        public int find(int x){
            if(x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }



    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0;i < n;i++){
            if(!visited[i]){
                visited[i] = true;
                findCircleNumFDFS(isConnected,i,n,visited);
                count++;
            }
        }
        return count;
    }

    public static void findCircleNumFDFS(int[][] isConnected,int x,int n,boolean[] visited){
        for(int i = 0;i < n;i++){
            if(isConnected[x][i] == 1 && !visited[i]){
                visited[i] = true;
                findCircleNumFDFS(isConnected,i,n,visited);
            }
        }
    }

    public static int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[i].length;j++){
                if(grid[i][j] == '1'){
                    res += 1;
                    numIslandsDfs(grid,i,j);
                }
            }
        }
        return res;
    }

    public static void numIslandsDfs(char[][] grid,int i,int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }

        if(grid[i][j] == '1'){
            grid[i][j] = '0';
        }
        numIslandsDfs(grid,i + 1,j);
        numIslandsDfs(grid,i - 1,j);
        numIslandsDfs(grid,i,j + 1);
        numIslandsDfs(grid,i,j - 1);
    }

    public static void print(int[][] arr){
        for(int i = 0;i < arr.length;i++){
            for(int j = 0;j < arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
