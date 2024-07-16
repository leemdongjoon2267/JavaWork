package com.lec.java.j14_02_access;

public class Test02 {
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
