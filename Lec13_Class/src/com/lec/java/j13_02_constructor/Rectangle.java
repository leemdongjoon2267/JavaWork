package com.lec.java.j13_02_constructor;

public class Rectangle {

    // 필드
    private double width;
    private double height;

    // 기본 생성자
    public Rectangle(){ // 생성자
        System.out.println("Rectangle() 생성자 호출");
        System.out.println("가로: " + width);
        System.out.println("세로: " + height);

    }


    // 매개변수 받아서 초기화 하는 생성자
    public Rectangle(double w, double h){
        System.out.println("Rectangle(" + w + ", " + h + " ) 생성자 호출");
        width = w;
        height = h;
        System.out.println("가로: " + width);
        System.out.println("세로: " + height);
    }

    // 둘레 계산 메소드
    public double calcPerimeter(){
        return 2 *(width + height);
    }

    // 넓이 계산 메소드
    public double calcArea(){
        return width * height;
    }

}





