package com.ctrip.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/7/15
 * @备注:
 */
public class BinaryTreePractice {
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

    public static class Node{
        public String value;
        public Node left;
        public Node right;

        public Node(String value) {
            this.value = value;
        }
    }
}
