package com.lec.java.j13_01_클래스정의;
/**
 *   클래스:
 *   우리가 만들고자 하는 대상의 '상태' 와 '기능' 을 함께 가지고 있는 '데이터 타입'
 *   상태(속성, 필드) -> 클래스의 멤버변수로 정의
 *       field, attribute, member variable 라고 함
 *   기능(동작) -> 클래스의 멤버메소드로 정의
 *       behavior, member method 라고 함
 *
 *
 *   일반적으로
 *    멤버변수(필드)는 private 으로 설정. → 자기 클래스 내에서만 사용 가능
 *    멤버메소드는 public 으로 설정. → 다른 클래스 에서도 사용 가능
 */

public class MyTV {
    // TV 의 상태 -> 멤버변수
    private boolean isPowerOn; // 전원 On/Off 상태
    private int channel; // 현재 채널 상태

    private int volume; // 현재 볼륨 상태

    // TV 의 기능(동작) -> 메소드

    // 현재 상태 출력
    public void displayStatus(){
        System.out.println("TV 현재 상태");
        System.out.println("----------------");
        System.out.println("전원 상태: " + isPowerOn); // 동일 클래스 안의 멤버들은 사용가능
        System.out.println("채널 상태: " + channel);
        System.out.println("볼륨 상태: " + volume);
        System.out.println("----------------");
    }

    // 전원 on//off
    public void powerOnOff(){
        if(isPowerOn){
            isPowerOn = false;
            System.out.println("TV를 끕니다");
        }else{
            isPowerOn = true;
            System.out.println("TV가 켜졌습니다");
        }
    }

    public int channelUp(){
        channel++;
        System.out.println("현재 채널: " + channel);
        return channel;
    }

    public int channelDown() {
        channel--;
        System.out.println("현재 채널: " + channel);

        return channel;
    } // end channelDown()

    public int volumeUp() {
        volume++;
        System.out.println("현재 볼륨: " + volume);

        return volume;
    } // end volumneUp()

    public int volumeDown() {
        volume--;
        System.out.println("현재 볼륨: " + volume);

        return volume;
    } // end volumeDown()


} // end class
