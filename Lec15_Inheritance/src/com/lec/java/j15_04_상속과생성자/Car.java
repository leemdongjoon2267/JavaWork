package com.lec.java.j15_04_상속과생성자;

public class Car extends Vehicle {

    int oil;

    // 출력에는 Vehicle() 생성 먼저 찍히고 이게 찍힘
    // 자식클래스에서 부모클래스의 생성자를  안찍으면 부모클래스의 기본생성자가 찍힘
    public Car() {
        System.out.println("Car() 생성");
    }

    public Car(int oil){
//        super();// 부모의 기본생성자를 사용
        // 명시적으로 부모 생성자는 호출 가능 super(..)
        super(77); // super(..) 는 생성자의 첫번째 문장이여야 함
        System.out.println("Car(int) 생성 : oil = " + oil);
        this.oil = oil;
    }

    public Car(int speed, int oil){
        super(speed); // 부모인 Vehicle 클래스에서 스피드 값을 가져옴
        this.oil = oil;
        System.out.println("Car(int, int) 생성 : speed = " + speed + " oil = " + oil);
    }
}
