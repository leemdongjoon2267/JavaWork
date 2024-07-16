package com.lec.java.j13_03_getter_setter;
/*
   캡슐화, 은닉, 추상화


   클래스 안에 필요한 '속성' 과 '행동' 을 멤버로 묶고
   외부에서의 '직접적인 접근을 제한'하여
   객체의 데이터 와 메소드를 은닉(hiding)하고,
   사용자에게는 필요한 기능만 제공하여 추상화(abstraction) 하는
   객체지향 기술을 '캡슐화(encapsulation)' 라고 한다
*/

public class Number {

    private int num;

    public Number(){}

    // 매개변수 받아 초기화 하는 생성자
    public Number(int num){
        this.num = num; // this : 자기자신(인스턴스)
    }


    // 메소드
    // getter: 멤버 변수의 값을 리턴해 주는 메소드
    // setter: 멤버 변수의 값을 변경해 줄 수 있는 메소드

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        if(num < 0) return; // num 값이 0보다 작으면 수정하지않음
        this.num = num;
    }

    // getter & setter 작명
    // age => getAge
    //     => setAge

    // realNumber => getRealNumber
    //            => setRealNumber

}
