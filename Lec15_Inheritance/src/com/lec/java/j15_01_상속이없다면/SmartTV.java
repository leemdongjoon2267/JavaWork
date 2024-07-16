package com.lec.java.j15_01_상속이없다면;

public class SmartTV {

    // 기존의 BasicTV 의 멤버들에 추가 혹은 변형된 형태
    boolean isPowerOn;
    int channel;
    int volume;
    String ip; // 추가된 필드

    public void displayInfo(){
        System.out.println("--- TV 현재 상태 ---");
        System.out.println("전원: " + isPowerOn);
        System.out.println("채널: " + channel);
        System.out.println("볼륨: " + volume);
        System.out.println("IP주소: " + ip); // 추가된 기능
    }

}
