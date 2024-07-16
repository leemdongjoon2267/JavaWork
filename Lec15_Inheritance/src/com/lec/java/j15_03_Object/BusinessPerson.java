package com.lec.java.j15_03_Object;

public class BusinessPerson extends Person{

    String company;

    public void showInfo(){
        whoAmI(); // Person 에서 상속받아서 부모인 Person 에서 가져옴
        System.out.println("회사는 " + company + " 입니다");
    }
}
