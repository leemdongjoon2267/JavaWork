package com.lec.java.j14_01_access;

public class Test01 {
    private int privateNum;
    int defaultNum;
    protected int protectedNum;
    public int publicNum;

    void test(){
        privateNum = 111;
        defaultNum = 222;
        protectedNum = 333;
        publicNum = 444;
    }

}
