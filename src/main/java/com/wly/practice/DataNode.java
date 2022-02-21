package com.wly.practice;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/1/28
 * @备注:
 */
public class DataNode {
    private int data;
    private DataNode next;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"data\":")
                .append(data);
        sb.append('}');
        return sb.toString();
    }

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }

    public DataNode getNext() {
        return next;
    }
    public void setNext(DataNode next) {
        this.next = next;
    }

    public DataNode(int data) {
        this.data = data;
    }
}
