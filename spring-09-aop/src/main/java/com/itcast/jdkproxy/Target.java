package com.itcast.jdkproxy;

public class Target implements TargetInterface{
    @Override
    public void save() {
        System.out.println("save running...");
    }
}
