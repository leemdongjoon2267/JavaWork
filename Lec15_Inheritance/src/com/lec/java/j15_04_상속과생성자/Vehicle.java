package com.lec.java.j15_04_상속과생성자;

public class Vehicle {

    int speed;

    public Vehicle(){
        System.out.println("Vehicle() 생성");
    }

    public Vehicle(int speed){
        this.speed = speed;
        System.out.println("Vehicle(int) 생성: speed = " + speed);
    }
}
