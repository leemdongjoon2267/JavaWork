package com.lec.java.j15_02_상속extends;

// extends 키워드를 사용하여 상속

// BasicTV
//   └─ SmartTV

// 자바 에선 오로지 '하나의 부모'로부터 상속받을수 있습니다 (단일 상속)
// 다중 상속 허용하지 않음

// ※ IntelliJ: 클래스에서 CTRL + H => Hierarchy 창 뜬다.

public class SmartTV extends BasicTV{

    String ip;

    public void displayInfo(){
        super.displayInfo(); // 부모의 displayInfo() 를 먼저 실행
        System.out.println("IP주소: " + ip);
    }
}
