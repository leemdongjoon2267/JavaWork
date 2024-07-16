package practice.bookmanager;

import java.io.Serializable;
import java.time.LocalDate;

// 책 정보를 저장 후 가져오기 위한 Serializable(직렬화) 구현
public class Book implements Serializable {
    String no;   // 도서번호. 알파벳대문자1자리+ 숫자4자리 형식.  고유한 값.
    String title;  // 최소 한글자 이상!
    Integer price;  // 0 이상의 정수
    LocalDate publishedAt;  // 날짜.

    // TODO : 필요한 생성자, getter&setter, toString  작성
    
    // 이 클래스에 데이터 조작 관련 메소드 작성하지 마세요

    private static long bookno = 1L;
    // 생성자
    public Book(String no, String title, Integer price, LocalDate publishedAt) {
        this.no = no;
        this.title = title;
        this.price = price;
        this.publishedAt = publishedAt;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDate publishedAt) {
        this.publishedAt = publishedAt;
    }
}
