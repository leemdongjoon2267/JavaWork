package practice.inventory;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class InventoryMain {


    static ArrayList<Inventory> inventoryList = new ArrayList<>();
    // 저장할 파일 및 디렉토리
    private static final String DATA_DIR = "data";
    private static final String DATA_FILE = "inventory.dat";
    private static Long nextId = 1L;


    public static void main(String[] args) {

        init();  // 디렉토리 (없으면) 생성.   파일 (있으면) 읽어들이기

        Scanner sc = new Scanner(System.in);
//        Inventory inventory = new Inventory();



        while(true){
            // 메뉴 출력
            System.out.println("\n상품정보 관리 프로그램 v1.0");
            System.out.println("---------------");
            System.out.println("[1] 입력");
            System.out.println("[2] 열람");
            System.out.println("[3] 수정");
            System.out.println("[4] 삭제");
            System.out.println("[0] 종료");
            System.out.println("---------------");
            System.out.print("선택: ");


            // 정수를 입력했는지 확인(정수를 입력 안하면 무한 루프 돌음)
            if(sc.hasNextInt()){
                int choice = sc.nextInt();
                sc.nextLine();

                // 선택에 따라 각각의 기능 실행
                if(choice <= 4 && choice >= 0){
                    switch(choice){
                        case 1 :
                            System.out.println("아이템 항목 입력을 시작합니다.");
                            addItem(inventoryList, sc);
                            break;

                        case 2 :
                            displayAllItems(inventoryList);
                            System.out.println("모든 아이템 항목을 출력합니다.");
                            break;

                        case 3 :
                            modifyItem(inventoryList, sc);
                            break;

                        case 4 :
                            deleteItem(inventoryList, sc);
                            break;

                        case 0 :
                            System.out.println("프로그램을 종료합니다.");

                        sc.close();
                        close();   // 파일 저장하기
                            return;
                    }
                }else{ // 범위를 벗어날때
                    System.out.println("선택하신 번호의 항목은 존재하지 않습니다. 재입력해주십시오.");
                    break;
                }
            }
        }

    }
    private static void init() {
        File dataDir = new File(DATA_DIR);
        if (!dataDir.exists()) {
            // 저장할 디렉토리 없으면 새로 생성
            if (dataDir.mkdir()) {
                System.out.println("폴더 생성 성공");
            } else {
                System.out.println("폴더 생성 실패");
            }
        } else {
            System.out.println("폴더 존재: " + dataDir.getAbsolutePath());
        }
        // 데이터 파일이 있다면 읽어 들이기
        File dataFile = new File(dataDir, DATA_FILE);
        if (dataFile.exists()) {
            System.out.println("데이터 파일 존재: " + dataFile.getAbsolutePath());

            try (
                    InputStream in = new FileInputStream(dataFile);
                    ObjectInputStream oin = new ObjectInputStream(in);
            ) {
                nextId = oin.readLong();
                inventoryList = (ArrayList<Inventory>) oin.readObject();
                System.out.println("파일에서 읽어 들어왔습니다 <- " + dataFile.getAbsolutePath());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private static void close() {
        try (
                OutputStream out = new FileOutputStream(new File(DATA_DIR, DATA_FILE));
                ObjectOutputStream oout = new ObjectOutputStream(out);
        ) {
            oout.writeLong(nextId);
            oout.writeObject(inventoryList);

            System.out.println("파일을 저장하였습니다.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    private static void addItem(ArrayList<Inventory> inventoryList, Scanner sc) {
        System.out.println("아이템 이름을 입력해주세요.");
        String name;

        // 상품 이름이 비어있을때
        while(true) {
            name = sc.nextLine();
            if(name.isEmpty()){
                System.out.println("[ERR-2] 문자열 오류 insert() 이름이 입력되지 않았습니다.");
                System.out.println("아이템 이름을 입력해주세요.");
                continue;
                // 상품 이름을 입력안하면 다시 입력받게끔 함

            }else{
                break; // 상품 이름을 입력 받으면 멈춤
            }

        }

        // 가격이 제대로 입력되었는지 확인 해주는 반복문
        int price;
        while(true){
            System.out.println("아이템 가격을 정해주세요.");
            String priceInsert = sc.nextLine();

            // 가격 입력이 비어있는지 확인
            if(priceInsert.isEmpty()){
                System.out.println("[ERR-4] 가격 오류 insert() 가격에 정상적인 입력이 되지 않았습니다.");
                continue; // 가격을 다시 입력하도록 반복
            }

            // 사용자가 정수를 입력했는지 확인
            // int로 받았기 때문에 정수로 입력했는지 예외 처리
            try{
                price = Integer.parseInt(priceInsert);
                break; // 정상적인 입력이면 반복문 종료
            }catch(NumberFormatException e){ // 문자열을 숫자로 변환할 때 발생하는 예외(String priceInsert)
                System.out.println("[ERR-4] 가격 오류 insert() 가격에 정상적인 입력이 되지 않았습니다.");
            }
        }



        // 개수를 입력하지 않으면 기본으로 0
        System.out.println("몇 개 등록하시겠습니까?");
        int count = 0; // 기본값으로 0 설정
        String countInsert = sc.nextLine();
        if(!countInsert.isEmpty()){
            try{
                count = Integer.parseInt(countInsert);
            }catch(NumberFormatException e){
                return;
            }
        }

        // 현재 시각 가져오기
        LocalDateTime currentTime = LocalDateTime.now();

        // 사용자로부터 날짜와 시간 입력 받기
        LocalDateTime userDateTime = inputDate(sc);


        Inventory newItem = new Inventory(name, price, count, LocalDateTime.now());
        newItem.setId(nextId); // 새로운 아이템에 다음 ID 할당
        nextId++;



        // 이미 존재하는 아이템인지 확인 후 업데이트 또는 추가
        boolean updated = false;
        for(Inventory item : inventoryList){
            if(item.equals(newItem)){
                item.setCount(item.getCount() + count);
                updated = true;
                break;
            }
        }

        // 새로운 아이템인 경우 리스트에 추가
        if(!updated){
            inventoryList.add(newItem);
        }

        System.out.println("상품이 추가되었습니다.");
    }

    private static void displayAllItems(ArrayList<Inventory> inventoryList){
        System.out.println("id   name     price     count   time");
        System.out.println("------------------------------");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for(Inventory item : inventoryList){
//            Collections.sort(inventoryList, (a, b) -> b.getCount() - a.getCount());
//            Collections.sort(inventoryList, (a, b) -> Integer.compare(b.getCount(), a.getCount()));

            System.out.printf("%d | %s | %d원 | %d개 | %s%n", item.getId(), item.getName(), item.getPrice(), item.getCount(), formatter.format(item.getCreatedDate()));
        }
        System.out.println("------------------------------");
    }

    private static void modifyItem(ArrayList<Inventory> inventoryList, Scanner sc) {
        System.out.println("변경할 상품 id를 입력해주세요.");
        try {
            long choiceId = sc.nextLong();
            //sc.nextLine();

            // 선택한 상품 찾기
            Inventory choiceItem = null;
            for (Inventory item : inventoryList) {
                if (item.getId() == choiceId) {
                    choiceItem = item;
                    break;
                }
            }

            // 선택한 상품이 없는 경우 에러 메시지 출력 후 다시 입력
            if (choiceItem == null) {
                System.out.println("[ERR-3] ID오류 존재하지 않는 id: " + choiceId);
                return;
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // 선택한 상품 출력
            System.out.println("선택한 항목은 다음과 같습니다.");
            System.out.println("------------------------------");
//            Collections.sort(inventoryList, (a, b) -> b.getCount() - a.getCount());
//            Collections.sort(inventoryList, (a, b) -> Integer.compare(b.getCount(), a.getCount()));
            System.out.printf("%d | %s | %d원 | %d개 | %s%n", choiceItem.getId(), choiceItem.getName(), choiceItem.getPrice(), choiceItem.getCount(), formatter.format(choiceItem.getCreatedDate()));
            System.out.println("------------------------------");

            // 변경할 내용 입력
            System.out.println("상품명을 입력해주세요.");
            String name = sc.nextLine();

            // 수정할때도 이름이 입력되지 않았을때(비어 있을때)
            while(true) {
                name = sc.nextLine();
                if(name.isEmpty()){
                    System.out.println("[ERR-2] 문자열 오류 insert() 이름이 입력되지 않았습니다.");
                    System.out.println("상품명을 입력해주세요.");
                    continue;

                }else{
                    break;
                }

            }

            // 수정할때도 가격이 입력되지 않았을때 예외 처리
            int price;
            while (true)  {
                System.out.println("아이템 가격을 정해주세요.");
                String priceInsert = sc.nextLine();

                // 가격 입력이 비어있는지 확인
                if (priceInsert.isEmpty()) {
                    System.out.println("[ERR-4] 가격 오류 insert() 가격에 정상적인 입력이 되지 않았습니다.");
                    continue; // 가격을 다시 입력하도록 반복
                }

                // 사용자가 정수를 입력했는지 확인
                try {
                    price = Integer.parseInt(priceInsert);
                    break; // 정상적인 입력이면 반복문 종료
                } catch (NumberFormatException e) {
                    System.out.println("[ERR-4] 가격 오류 insert() 가격에 정상적인 입력이 되지 않았습니다.");
                }
            }


            // 개수를 입력하지 않으면 기본으로 0
            System.out.println("몇 개 등록하시겠습니까?");
            int count = 0; // 기본값으로 0 설정
            String countInsert = sc.nextLine();
            if (!countInsert.isEmpty()) {
                try {
                    count = Integer.parseInt(countInsert);
                } catch (NumberFormatException e) {
                    return;
                }
            }

            // 사용자로부터 날짜와 시간 입력 받기
            LocalDateTime userDateTime = inputDate(sc);


            // 선택한 상품의 내용 변경
            choiceItem.setName(name);
            choiceItem.setPrice(price);
            choiceItem.setCount(count);
            choiceItem.setCreatedDate(userDateTime);



            // 성공 여부 출력
            if (inventoryList.contains(choiceItem)) {
                System.out.println("성공 여부: 1");
            } else {
                System.out.println("성공 여부: 0");
            }
        } catch (NoSuchElementException e) {
            sc.nextLine();
        }
    }

    private static void deleteItem(ArrayList<Inventory> inventoryList, Scanner sc){
        System.out.println("선택한 항목의 상품을 삭제합니다.");
        System.out.println("삭제할 상품 id를 입력해주세요.");

        try{
            long deleteId = sc.nextLong();
            sc.nextLine();

            boolean deleted = false;
            for(int i = 0; i < inventoryList.size(); i++){
                if(inventoryList.get(i).getId() == deleteId){
                    inventoryList.remove(i);
                    deleted = true;
                    break;
                }
            }

            if(deleted){
                System.out.println("성공 여부: 1");
            }else{
                System.out.println("[ERR-3] ID오류 존재하지 않는 id: " + deleteId);
                System.out.println("성공 여부: 0");
            }
        }catch(NoSuchElementException e){
            sc.nextLine();
        }
    }

    private static LocalDateTime inputDate(Scanner in) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = null; // 반환할 값

        while (true) {
            try {
                System.out.print("\n일시를 입력해 주세요.(yyyy-MM-dd HH:mm:ss 형식으로 입력)\n입력 : ");
                String dateInput = in.nextLine();
                date = LocalDateTime.parse(dateInput, formatter);
                break;
            } catch (DateTimeParseException ex) {
                System.out.println("\n[ERR-5] 일시 오류 : insert()\n일시에 정상적인 입력이 되지 않았습니다.");
            }
        }

        return date;
    }


} // end class

