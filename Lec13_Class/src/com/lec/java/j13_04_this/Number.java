package com.lec.java.j13_04_this;

public class Number {
    private int num = 100; // 필드 선언시 초깃값 명시 가능

    public Number() {
    }

    public Number(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Number add(Number x){
        this.num += x.num;
        return this; // 자기 자신과 같은 타입을 리턴
    }

    public Number sub(Number x){
        this.num -= x.num;
        return this; // 자기 자신과 같은 타입을 리턴
    }
}
