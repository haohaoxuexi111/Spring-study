package com.xiang.demo01;

public class Proxy {
    private Host host;
    public Proxy(){
    }
    public Proxy(Host host){
        this.host = host;
    }
    public void rent(){
        seeHouse();
        host.rent();
        agreement();
        fare();
    }
    public void seeHouse(){
        System.out.println("中介带你看房");
    }
    public void fare(){
        System.out.println("收中介费");
    }
    public void agreement(){
        System.out.println("签租赁合同");
    }
}

