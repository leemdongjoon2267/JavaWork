package practice.cardcompany;

public class Card {

	// 필요한 변수, 메소드, 생성자 정의하기
    private int cardNumber;
    private static int serialNumber = 10000; // 기본값을 10000이라고 고정

    Card(){
        serialNumber++; // 고유번호가 1씩 증가
        cardNumber = serialNumber; // 1씩 증가하는 고유번호가 카드번호가 됨
    }

    // getter, setter 생성
    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
} // end class
