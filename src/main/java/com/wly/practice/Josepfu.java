package com.ctrip.practice;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/2/22
 * @备注:
 */
public class Josepfu {
    public static void main(String[] args) {

    }
}

class CircleSingleLinkedList{
    //创建first节点
    private Boy first = new Boy(-1);

    //添加并构建成环形链表
    public void addBoy(int num){
        if(num <= 0){
            return;
        }
        Boy curBoy = null;
        //用for循环来创建环形链表
        for(int i = 1;i < num;i++){
            Boy boy = new Boy(i);
            if(i == 1){
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }
}

class Boy{
    private int no;
    private Boy next;

    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"no\":")
                .append(no);
        sb.append(",\"next\":")
                .append(next);
        sb.append('}');
        return sb.toString();
    }
}