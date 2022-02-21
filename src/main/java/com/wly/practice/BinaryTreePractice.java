package com.wly.practice;

import java.util.*;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/7/15
 * @备注:
 */
public class BinaryTreePractice {
    public int diameterOfBinaryTree(TreeNode root) {
        int left = 0;
        int right = 0;
        return left + right;
    }

    public TreeNode lowestCommonAncestorSupers(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestorSupers(root.left,p,q);
        TreeNode right = lowestCommonAncestorSupers(root.right,p,q);

        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        binaryTreePathsBFS(root,list,temp);
        return list;
    }

    public static void binaryTreePathsBFS(TreeNode root,List<String> res,List<Integer> temp){
        if(root == null){
            return;
        }

        temp.add(root.val);
        if(isLeaf(root)){
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i < temp.size();i++){
                if(i != temp.size() - 1){
                    sb.append(temp.get(i) + "->");
                }else{
                    sb.append(temp.get(i));
                }
            }
            res.add(sb.toString());
        }else{
            binaryTreePathsBFS(root.right,res,temp);
            binaryTreePathsBFS(root.left,res,temp);
        }
        temp.remove(temp.size() - 1);
    }

    public static boolean isLeaf(TreeNode root){
        return  root.left == null && root.right == null ? true : false;
    }


    public TreeNode lowestCommonAncestorSuper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;

        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();
        List<TreeNode> qRes = new ArrayList<>();
        List<TreeNode> pRes = new ArrayList<>();

        lowestCommonBackTracking(root,pList,pRes,p);
        lowestCommonBackTracking(root,qList,qRes,q);

        for(int i = 0;i < pList.size();i++){
            System.out.println(pList.get(i).val);
        }
        System.out.println("============");
        for(int i = 0;i < qList.size();i++){
            System.out.println(qList.get(i).val);
        }

        TreeNode pre = null;
        for(int i = 0;i < pList.size();i++){
            TreeNode pTemp = pList.get(i);
            TreeNode qTemp = qList.get(i);
            if(qTemp.val != pTemp.val) break;
            pre = pTemp;
        }

        return pre;
    }

    public static void lowestCommonBackTracking(TreeNode node,List<TreeNode> list,List<TreeNode> res,TreeNode target){
        if(node == null){
            return;
        }
        list.add(node);
        if(node.val == target.val){
            for(int i = 0;i < list.size();i++){
                res.add(list.get(i));
            }
            return;
        }else{
            lowestCommonBackTracking(node.left,list,res,target);
            lowestCommonBackTracking(node.right,list,res,target);
        }
        list.remove(list.size() - 1);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null){
            return null;
        }
        if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right,p,q);
        if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left,p,q);
        return root;
    }

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        postOrderTreeNode(root,list);
        for(int i = 1;i < list.size();i++){
            TreeNode prev = list.get(i - 1);
            TreeNode cur = list.get(i);
            prev.left = null;
            prev.right = cur;
        }
    }

    public static void postOrderTreeNode(TreeNode root,List<TreeNode> list){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp == null) continue;
            list.add(temp);
            stack.add(temp.right);
            stack.add(temp.left);
        }
    }

    public static List<Integer> postOrd3(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp == null) continue;
            res.add(temp.val);
            stack.add(temp.right);
            stack.add(temp.left);
        }
        return res;
    }

    public List<Integer> postOrderTreenode(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp == null) continue;
            res.add(temp.val);
            if(temp.right != null){
                stack.add(temp.right);
            }
            if(temp.left != null){
                stack.add(temp.left);
            }
        }
        return res;
    }

    public int maxDepth(TreeNode root) {
        int res = 0;
        if(root == null) return res;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while(!deque.isEmpty()){
            res++;
            int count = deque.size();
            while(count > 0){
                TreeNode temp = deque.pollFirst();
                if(temp.left != null) deque.add(temp.left);
                if(temp.right != null) deque.add(temp.right);
                count--;
            }
        }
        return res;
    }

    //非递归方式
    public static void preOrd2(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.println(node.value);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
    }

    //前序遍历
    public static void preOrd1(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.value);
        preOrd1(root.left);
        preOrd1(root.right);
    }

    //中序遍历
    public static void midOrd1(Node root){
        if(root == null){
            return;
        }
        preOrd1(root.left);
        System.out.println(root.value);
        preOrd1(root.right);
    }

    //中序遍历
    public static void midOrd2(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while(!stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            Node node = stack.pop();
            System.out.println(node.value);
            if(node.right != null){
                cur = node.right;
            }
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        return list;
    }

    //后序遍历
    public static void postOrd(Node root){
        if(root == null){
            return;
        }
        preOrd1(root.left);
        preOrd1(root.right);
        System.out.println(root.value);
    }

    public static void postOrd2(Node root){
        if(root == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            stack2.push(node);
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }

        while(!stack2.isEmpty()){
            System.out.println(stack2.pop().value);
        }
    }

    //层序遍历
    public static void bfs(Node root){
        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node.value);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");

        nodeA.left = nodeB;
        nodeA.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = nodeE;
        nodeC.right = nodeF;
        nodeE.left = nodeG;

        //preOrd1(nodeA);
        preOrd2(nodeA);
    }


    public static void levelBfs(Node root){
        if(root == null){
            return;
        }

        //true为正序 false为逆序
        boolean flag = true;
        Queue<Node> queue = new LinkedList();
        Stack<Node> stack = new Stack();
        queue.add(root);

        while(queue != null || stack != null){
            if(flag){
                while(queue != null){
                    Node r = queue.poll();
                    stack.add(r.left);
                    stack.add(r.right);
                }
            }else{
                while(stack != null){
                    Node temp = stack.pop();
                    queue.add(temp.left);
                    queue.add(temp.right);
                }
            }
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            TreeNode rightTreeNode = temp.right;

            temp.right = temp.left;
            temp.left = rightTreeNode;

            if(temp.left != null){
                queue.add(temp.left);
            }

            if(temp.right != null){
                queue.add(temp.right);
            }
        }

        return root;
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

    public static class Node{
        public String value;
        public Node left;
        public Node right;

        public Node(String value) {
            this.value = value;
        }
    }

    public static List<Integer> inordertraversalsss(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.add(cur);
                cur = cur.left;
            }

            TreeNode treeNode = stack.pop();
            res.add(treeNode.val);
            cur = cur.right;
        }
        return res;
    }

    public static List<Integer> inorderTraversals(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversalHandler(list,root);
        return list;
    }

    public static void inorderTraversalHandler(List<Integer> list,TreeNode root){
        if(root == null){
            return;
        }
        inorderTraversalHandler(list,root.left);
        list.add(root.val);
        inorderTraversalHandler(list,root.right);
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur == null) continue;
            stack.add(cur.left);
            stack.add(cur.right);
        }
        Collections.reverse(list);
        return list;
    }

    public static void postorderTraversalHandler(List<Integer> list,TreeNode root){
        if(root == null){
            return;
        }

        postorderTraversalHandler(list,root.left);
        postorderTraversalHandler(list,root.right);
        list.add(root.val);
    }

    public boolean isSymmetric(TreeNode root) {
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
        return true;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int count = deque.size();
            List<Integer> list = new ArrayList<>();
            while(count > 0){
                TreeNode temp = deque.pollFirst();
                list.add(temp.val);
                if(temp.left != null) deque.add(temp.left);
                if(temp.right != null) deque.add(temp.right);
                count--;
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }


}
