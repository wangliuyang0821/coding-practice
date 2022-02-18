package com.ctrip.practice;

import java.util.*;

public class BinaryTreeReview {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.remove("11");
    }

    public int minDepth(TreeNode root) {
        int res = 0;
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty()){
            res++;
            int count = stack.size();
            while(count > 0){
                TreeNode temp = stack.pop();
                if(temp.left == null && temp.right == null) return res;
                if(temp.right != null) stack.add(temp.right);
                if(temp.left != null) stack.add(temp.left);
                count--;
            }
        }
        return res;
    }

    public static void flattens(TreeNode root) {
        List<TreeNode> temp = new ArrayList<>();
        flattenHandler(root,temp);
        for(int i = 1;i < temp.size();i++){
            TreeNode pre = temp.get(i - 1);
            TreeNode cur = temp.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    public static void flattenHandler(TreeNode root,List<TreeNode> list){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur == null) continue;
            list.add(cur);
            stack.add(cur.right);
            stack.add(cur.left);
        }
    }

    public static Integer getInt(TreeNode root,int target){
        List<Integer> list = midOrd(root);
        for(int i = 0;i < list.size();i++){
            if(target == list.get(i) && i < list.size() - 1){
                return list.get(i + 1);
            }
        }
        return null;
    }

    public static List<Integer> midOrd(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.add(cur);
                cur = cur.left;
            }

            TreeNode temp = stack.pop();
            res.add(temp.val);
            cur = temp.right;
        }
        return res;
    }


    public static List<Integer> preOrders(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if(temp.right != null) stack.add(temp.right);
            if(temp.left != null) stack.add(temp.left);
        }
        return res;
    }

    public static List<Integer> inorderTraversals(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.add(cur);
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.add(cur);
                cur = cur.left;
            }

            TreeNode temp = stack.pop();
            res.add(temp.val);
            cur = temp.right;
        }

        return res;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode top = queue.poll();

            TreeNode temp = top.left;
            top.left = top.right;
            top.right = temp;

            if(top.left != null) queue.add(top.left);
            if(top.right != null) queue.add(top.right);
        }
        return root;
    }

    public static TreeNode lowestCommonAncestors(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestors(root.left,p,q);
        TreeNode right = lowestCommonAncestors(root.right,p,q);

        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
        return true;
    }

    public static boolean isValidBST(TreeNode root,long low,long high){
        if(root == null) return true;
        int value = root.val;
        if(value <= low || value >= high) return false;
        return isValidBST(root.left,low,value) && isValidBST(root.right,value,high);
    }

    public static List<Integer> test(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        boolean scanFlag = true;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int count = deque.size();
            while(count > 0){
                TreeNode temp = null;
                if(scanFlag){
                    temp = deque.pollFirst();
                    res.add(temp.val);
                }else{
                    temp = deque.pollLast();
                    res.add(temp.val);
                }
                if(temp.left != null) deque.add(temp.left);
                if(temp.right != null) deque.add(temp.right);
                if(scanFlag){
                    scanFlag = false;
                }else{
                    scanFlag = true;
                }
                count--;
            }
        }
        return res;
    }

    public static List<Integer> midOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.add(cur);
                cur = cur.left;
            }
            TreeNode temp = stack.pop();
            if(temp == null) continue;
            res.add(temp.val);
            cur = cur.right;
        }
        return res;
    }

    public static List<Integer> postOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp == null) continue;
            res.add(temp.val);
            stack.add(temp.left);
            stack.add(temp.right);
        }

        Collections.reverse(res);
        return res;
    }

    public static List<Integer> preOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            if(tmp == null) continue;
            res.add(tmp.val);
            stack.add(tmp.right);
            stack.add(tmp.left);
        }
        return res;
    }



    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static void flatten(TreeNode root) {

    }

    public static void flattenPostOrder(TreeNode root,List<Integer> res){
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            res.add(temp.val);

        }
    }

    public int maxDepth(TreeNode root) {
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            int count = stack.size();
            while(count > 0){
                TreeNode temp = stack.pop();
                if(temp.left != null) stack.add(temp.left);
                if(temp.right != null) stack.add(temp.right);
                count--;
            }
            res++;
        }
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            int count = stack.size();
            List<Integer> temp = new ArrayList<>();
            while(count > 0){
                TreeNode node = stack.pop();
                temp.add(node.val);
                if(node.right != null) stack.add(node.right);
                if(node.left != null) stack.add(node.left);
                count--;
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        boolean res = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return res;
    }

    public static List<Integer> postOrd(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();

        }
        return res;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()){
            int size = stack.size();
            while(size > 0){
                TreeNode temp = stack.pop();
                res.add(temp.val);
                if(temp.right != null) stack.add(temp.right);
                if(temp.left != null) stack.add(temp.left);
                size--;
            }
        }
        return res;
    }

    public static List<Integer> inorderTraversalFirst(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        inorderTraversalFirstHandler(root,res);
        return res;
    }

    public static void inorderTraversalFirstHandler(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }

        inorderTraversalFirstHandler(root.left,res);
        res.add(root.val);
        inorderTraversalFirstHandler(root.right,res);

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

