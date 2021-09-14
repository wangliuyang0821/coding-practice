package com.ctrip.practice;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/6/9
 * @备注:
 */
public class CalTest {
    private static int index = 0;
    public static void main(String[] args) {
        System.out.println(cal("(1+(4+5+2)-3)+(6+8)"));
    }
    public static int cal(String s){
        s = s.replaceAll(" ","");
        int ans = get(s);
        return ans;
    }

    public static int get(String s){
        if(index >= s.length()){
            return 0;
        }
        int res = 0;
        char sign = '+';
        while(index < s.length()){
            int cur = 0;
            if(s.charAt(index) == '('){
                index++;
                cur = get(s);
            }else{
                while(index < s.length() && Character.isDigit(s.charAt(index))){
                    cur = cur * 10 + (s.charAt(index) - '0');
                    index++;
                }
            }

            if(sign == '+'){
                res += cur;
            }else if(sign == '-'){
                res -= cur;
            }

            if(index < s.length() && s.charAt(index) == ')'){
                index++;
                break;
            }

            if(index < s.length()){
                sign = s.charAt(index);
                index++;
            }
        }
        return res;
    }
}
