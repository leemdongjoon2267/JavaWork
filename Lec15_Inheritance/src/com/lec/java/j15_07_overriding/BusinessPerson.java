package com.lec.java.j15_07_overriding;

public class BusinessPerson extends Person {

    // 멤버 변수
    private String company;

    // getter & setter
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    // 메소드 오버라이딩
    @Override
    protected void showInfo() { // private, default 사용 불가 public 은 가능
        super.showInfo(); // 부모클래스인 Person 에서 가져옴
        System.out.println("회사: " + company);
    }
    // 권한 범위가 같거나 넓은 쪽으로 가능

    // 메소드 오버로딩
    public void showInfo(int id) {
        System.out.println("id: " + id);
        System.out.println("이름: " + getName()); // 부모 클래스에서 name 가져옴
        System.out.println("회사: " + company);
    }

    // IntelliJ 에서 Override 코드 작성 방법
    // 1. 메소드 이름 타이핑하면서 자동완성
    // 2. CTRL + O 누르면 Override 창 뜬다.
    // 3. ALT + INSERT, Override 실행

    // final 메소드는 오버라이딩 불가
    @Override
    public void whoAreYou() {
        super.whoAreYou();
    } // 부모 클래스에서 가져옴

    @Override
    public String toString() {
        return String.format("이름:%s, 회사:%s", getName(), company);
        // name 은 private 여서 get 으로 받아야함(상속받았음)
    }

    // 리턴타입이 자손타입으로는 오버라이딩 가능
    @Override
    public BusinessPerson myPerson(){
        return new BusinessPerson();
    }

    // 리턴타입이 조상타입으로는 오버라이딩 불가
//    @Override
//    public Object myPerson(){
//        return null;
//    }



}
