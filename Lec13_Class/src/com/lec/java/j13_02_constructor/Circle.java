package com.lec.java.j13_02_constructor;

public class Circle {

    // 속성 => 필드 (멤버변수)
    public double radius; // 반지름

    // 생성자 (Constructor)
    // 생성자의 목적: 인스턴스 생성시 멤버변수들의 초기화
    // 생성자의 이름은 반드시 클래스의 이름과 동일
    // 생성자는 리턴 타입이 없다.
    // 생성자도 매개변수(argument)를 가질 수 있습니다.
    // 생성자도 오버로딩(overload) 가능

    // 클래스를 만들 때, 생성자를 따로 만들지 않으면
    // '디폴트 생성자(default constructor)'를 자동으로 만들어줌.
    // 디폴트 생성자란 : 매개변수가 없는 생성자.  모든 멤버변수는 기본값으로 초기화
    // (주의) 클래스에서 하나 이상의 생성자를 만들게 되면,
    // 자동으로 디폴트 생성자를 만들어 주지 않습니다.
    // (강력권장) 아무일도 안하더라도 디폴트 생성자는 반드시 만들어 주자.

    // 디폴트 생성자 (default constructor)
    public Circle(){ // 생성자
        System.out.println("Circle() 생성자 호출");
        System.out.println("반지름: " + radius);

    }

    // ↓ 생성자 오버로딩 가능
    public Circle(double r){
        System.out.println("Circle(" + r + ") 생성자 호출");
        radius = r;
        System.out.println("반지름: " + radius);
    }


    // 동작 => 메소드
    public double calcPerimeter(){
        return 2 * Math.PI * radius;
    }

    // 원의 넓이 계산
    public double calcArea(){
        return Math.PI * radius * radius;
    }
}
