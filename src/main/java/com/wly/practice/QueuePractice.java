package com.ctrip.practice;

import java.util.*;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/6/8
 * @备注:
 */
public class QueuePractice {
    public static void main(String[] args) {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public static int calculate(String s) {
        char[] c = s.toCharArray();
        Stack<Integer> num = new Stack<>();
        Stack<Character> op = new Stack<>();
        for(int i = 0; i < c.length; i++){
            if(c[i] == ' ') continue;
            if(Character.isDigit(c[i])){
                int x = 0, j = i;
                while(j < c.length && Character.isDigit(c[j])){
                    x = x * 10 + c[j] - '0';
                    j++;
                }
                i = j-1;
                num.push(x);
            }else if(c[i] == '('){
                op.push(c[i]);
            }else if(c[i] == ')'){
                while(op.peek() != '(') eval(num,op);
                op.pop();
            }else{
                while(op.size() != 0 && op.peek() != '(') eval(num,op);
                op.push(c[i]);
            }
        }
        while(op.size() != 0){
            eval(num,op);
        }
        return num.peek();
    }

    public static void eval(Stack<Integer> num, Stack<Character> op){
        int b = num.pop();
        int a = num.pop();
        char c = op.pop();
        if(c == '+') {
            a += b;
        }else{
            a -= b;
        }
        num.push(a);
    }

}
