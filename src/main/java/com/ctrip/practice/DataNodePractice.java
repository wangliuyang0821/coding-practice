package com.ctrip.practice;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/1/28
 * @备注:
 */
public class DataNodePractice {
    public static void main(String[] args) {
        DataNode dataNode1 = new DataNode(1);
        DataNode dataNode2 = new DataNode(2);
        DataNode dataNode3 = new DataNode(3);
        add(dataNode1);
        add(dataNode2);
        add(dataNode3);
        /*show();

        reverse(head);*/
        list();


    }

    /*public static DataNode reverseDataNode(DataNode dataNode){
        *//*if(head.getNext() == null || head.getNext().getNext() == null){
            return dataNode;
        }

        DataNode cur = head.getNext();
        DataNode reverseDataNode = head;
        while(cur != null){
            DataNode temp = cur.getNext();
            reverseDataNode.setNext(cur);
            cur.setNext();
        }*//*
    }*/

    public static void list(){
        if(head.getNext() == null){
            return;
        }

        while(head != null){
            System.out.println(head.getData());
            head = head.getNext();
        }
    }

    public static DataNode reverse(DataNode head){
        if(head == null || head.getNext() == null){
            return head;
        }

        DataNode pre = head;
        DataNode cur = head.getNext();
        while (cur.getNext() != null){
            DataNode temp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = temp;
        }
        cur.setNext(pre);
        head.setNext(null);
        return cur;
    }


    private static DataNode head = new DataNode(0);

    public static void show(){
        if(head.getNext() == null){
            System.out.println("empty");
            return;
        }
        DataNode temp = head.getNext();
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp.toString());
            temp = temp.getNext();
        }
    }

    public static void add(DataNode dataNode){
        DataNode temp = head;
        while(true){
            if(temp.getNext() == null){
                break;
            }else{
                temp = temp.getNext();
            }
        }
        temp.setNext(dataNode);
    }


}
