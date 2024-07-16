package practice.inventory;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Inventory implements Serializable {

    // ★ 필드는 수정하지 마세요 ★
    private Long id;  // 상품고유 일련번호 (숫자, 필수, 중복불가)
    private String name;  // 상품 이름 (문자열, 필수)
    private Integer price; // 상품 가격  (숫자, 필수)

    private Integer count; // 상품 재고  (숫자, 기본 0)
    private LocalDateTime createdDate;  // 상품 등록일  (등록날짜 )

    private static Long nextId = 1L; // 상품 id 를 static 으로 받음
    // 처음에 0으로 초기화 하고 Inventory() 에서 새로운 아이템을 생성할때마다 +1 씩 증가하게 함

    public Inventory() {
//        this.id = nextId++; // 새로운 아이템을 생성할 때마다 일련번호 증가
    }



//    public Inventory(Long id, String name, Integer price, Integer count, LocalDateTime createdDate) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//        this.count = count;
//        this.createdDate = createdDate;
//    }

    public Inventory(String name, Integer price, Integer count, LocalDateTime createdDate) {
        this.id = nextId++; // 이거 없으면 id null 값 나옴
        this.name = name;
        this.price = price;
        this.count = count;
        this.createdDate = createdDate;
    }


    // Getter, Setter 부분
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }



//    public void displayItems() {
//    }
//
//    public void modifyItem() {
//    }
//
//    public void deleteItem() {
//    }

} // end Model
