package com.ctrip.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/2/26
 * @备注:
 */
public class testUrl {
    public static void main(String[] args) {
        /*String url = "https://m.ctrip.com/webapp/vacations/tour/detail?productId=11927472&tabId=64&saleCityId=43&locateCityId=43&departCityId=43&ctm_ref=vactang_page_1144&fromminiapp=weixin&allianceid=262684&sid=711465&sourceid=55552689&_cwxobj=%7B%22cid%22%3A%2209301176210071276667%22%2C%22appid%22%3A%22wx0e6ed4f51db9d078%22%2C%22mpopenid%22%3A%22a10005d9-b877-4e08-9455-57b2fcf9f5ed%22%2C%22allianceid%22%3A%22262684%22%2C%22sid%22%3A%22711465%22%2C%22ouid%22%3A%22%22%2C%22sourceid%22%3A%2255552689%22%2C%22exmktID%22%3A%22%7B%5C%22openid%5C%22%3A%5C%22a10005d9-b877-4e08-9455-57b2fcf9f5ed%5C%22%2C%5C%22channelUpdateTime%5C%22%3A%5C%221614109343236%5C%22%2C%5C%22serverFrom%5C%22%3A%5C%22WAP%2FWECHATAPP%5C%22%7D%22%2C%22scene%22%3A1089%7D\t";
        //String url = "pages/gs/sight/newDetail?allianceid=263528&activityid=TOUR_GROUPBUY_1606983676487&sightId=20491&sid=3542019\t";
        String regEx="(\\?|&+)(.+?)=([^&]*)";//匹配参数名和参数值的正则表达式
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(url);
        while(m.find()){
            String paramName = m.group(2);//获取参数名
            String paramVal=m.group(3);//获取参数值
            System.out.println(paramName+"---"+paramVal);
        }*/
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
        for(int i :arr){
            System.out.println(i);
        }
    }

    public static void moveZeroes(int[] nums) {
        if(nums.length < 2){return;}
        int index = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != 0){
                swift(nums,i,index);
                index++;
            }
        }
    }

    public static void swift(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
