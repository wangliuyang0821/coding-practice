package com.wly.practice;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/6/9
 * @备注:
 */
public class SolutionTest {
    private static int index = 0;

    public static void main(String[] args) {
        System.out.println(calculate("2-1 + 2 "));
    }
    public static int calculate(String s){
        return cal(s.replaceAll(" ",""));
    }

    public static int cal(String s){
        if(index >= s.length()){
            return 0;
        }
        int res = 0;
        char sign = '+';
        while(index < s.length()){
            int cur = 0;

            if(s.charAt(index) == '('){
                index++;
                cur = cal(s);
            }else{
                while(s.length() > index && Character.isDigit(s.charAt(index))){
                    cur = cur * 10 + (s.charAt(index) - '0');
                    index++;
                }
            }

            if(sign == '+'){
                res += cur;
            }else{
                res -= cur;
            }

            if(s.length() > index && s.charAt(index) == ')'){
                index++;
            }

            if(s.length() > index){
                sign = s.charAt(index);
                index++;
            }
        }

        return res;
    }


}
