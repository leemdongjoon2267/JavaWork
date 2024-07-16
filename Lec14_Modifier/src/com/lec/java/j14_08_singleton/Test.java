package com.lec.java.j14_08_singleton;

public class Test {

    private int num;

    // singleton 디자인 패턴
    // 생성자는 private 로 작성
    private Test(){ // 생성자를 private 로 만들어서 인스턴스를 2개 못만들게 함
        System.out.println("Test() 인스턴스 생성");
        num = 100;
    }

    // 하나의 인스턴스를 가지게함
    private static Test instance = null; // 생성된 유일한 인스턴스 참조

    // Test 가 instance 를 가지게함
    public static Test getInstance(){ // 생성된 인스턴스 리턴

        if(instance == null){ // 기존에 생성된 인스턴스가 없다면
            instance = new Test(); // 생성
        }

        return instance;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

