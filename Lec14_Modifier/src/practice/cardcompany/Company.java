package practice.cardcompany;

public class Company {

	// 필요한 변수, 메소드, 생성자 정의하기
    private static  Company instance = new Company();
    // Company 가 유일한 인스턴스를 가지도록 설정
    private Company(){ // Company 기본 생성자 생성

    }

    public static Company getInstance() {
        if(instance == null){ // 기존에 생성된 인스턴스가 없다면
            instance = new Company(); // 생성
        }
        return instance; // instance 반환
    }

    // 인스턴스가 생기면 이제 카드를 생성
    // static 이 없으면 인스턴스 생성후 사용 가능
    public Card createCard(){
        Card card = new Card(); // 카드 생성(발급)

        return card; // 반환
    }

} // end class
