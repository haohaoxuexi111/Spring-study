package com.xiang.demo03;

public class Host implements Rent {
    public Object rent(){
        System.out.println("房东要出租房子！");
        return "出租啦！！";
    }
    public Object push(){
        System.out.println("房东要卖出房子！");
        return "卖出去啦！！";
    }
}
