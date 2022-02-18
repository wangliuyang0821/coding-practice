package com.ctrip.practice;

import scala.collection.mutable.Stack;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/6/21
 * @备注:
 */
public class TreePractice {
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

        preOrder(nodeA);
        System.out.println("----------");
        minOrder(nodeA);
        System.out.println("----------");
        postOrder(nodeA);
        System.out.println("------------------");
        preOrder2(nodeA);
    }

    public int countNode(Node root){
        if(root == null){
            return 0;
        }
        return countNode(root.left) + countNode(root.right) + 1;
    }

    public int level(Node root,String target){
        if(root == null){
            return 0;
        }else if(root.value == target){
            return 1;
        }else{
            int left = level(root.left,target);
            int right = level(root.right,target);
            if(left + right == 0){
                return 0;
            }else {
                return left + right + 1;
            }
        }
    }

    public void printLeaf(Node root){
        if(root != null){
            if(root.right == null && root.left == null){
                System.out.println(root.value);
            }else{
                printLeaf(root.right);
                printLeaf(root.left);
            }
        }
    }

    public Node copy(Node root){
        Node n;
        if(root != null){
            n = new Node(root.value);
            n.left = this.copy(root.left);
            n.right = this.copy(root.right);
        }else{
            n = null;
        }
        return n;
    }

    public void preOrderPrint(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.value);
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

    public void postOrderPrint(Node root){
        if(root == null){
            return;
        }
        postOrderPrint(root.left);
        postOrderPrint(root.right);
        System.out.println(root.value);
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void preOrder2(Node root){
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

    public static void minOrder(Node root){
        if(root == null){
            return;
        }
        minOrder(root.left);
        System.out.println(root.value);
        minOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }

    public static class Node{
        public String value;
        public Node left;
        public Node right;

        public Node(String value){
            this.value = value;
        }
    }
}
