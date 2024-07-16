package com.lec.java.j15_07_overriding;

// public final class Person { // final 클래스는 더이상 상속 불가
public  class Person {

    // 멤버 변수
    private String name;


    // getter & setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // 메소드
    protected void showInfo() {
        System.out.println("이름: " + name);
    }

    // final
    public  void whoAreYou(){
        System.out.println("이름: " + name);
    }

    public Person myPerson(){
        return new Person();
    }
}
