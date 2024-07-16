package practice.bookmanager;


import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// 필요한 클래스 추가 가능
// 이 패키지 외의 패키지에는 클래스 만들지도 말기.
public class BookManagerMain {

    static ArrayList<Book> bookList = new ArrayList<>();
    private static final String DATA_DIR = "ExBookManager/src/practice/bookmanager/data";
    private static final String DATA_FILE = "book.dat";

    private static long bookno = 1L;
    // 파일을 불러오려고 할때 저장된 책 번호로 불러들이기 위함




    public static void main(String[] args) {

        read();  // 디렉토리 (없으면) 생성.   파일 (있으면) 읽어들이기

        Scanner sc = new Scanner(System.in);

        // 메뉴에 따라서 생성 조회 수정 삭제를 하고서 프로그램이 자동적으로 끝내지 않고
        // 사용자가 0을 입력하기 전까지 무한 루프를 돌게끔 함
        while(true) {
            // 메뉴 출력
            System.out.println("\n도서관리 v1.0");
            System.out.println("---------------");
            System.out.println("[1] 입력");
            System.out.println("[2] 목록 [21]번호↓ [22]번호↑ [23]제목↓ [24]제목↑ [25]가격↓ [26]가격↑ [27]출판일↓ [28]출판일↑");
            System.out.println("[3] 수정");
            System.out.println("[4] 삭제");
            System.out.println("[0] 종료");
            System.out.println("---------------");
            System.out.print("선택: ");

            // 정수를 입력했는지 확인(정수를 입력 안하면 무한 루프 돌음)
            if(sc.hasNextInt()) {
                int choice = sc.nextInt();
                sc.nextLine();

                // 선택에 따라 각각의 기능 실행
                if ((choice <= 4 && choice >= 0) || (choice <= 28 && choice >=21)) {
                    switch (choice) {
                        case 1:
                            System.out.println("책 정보를 입력합니다.");
                            addBook(bookList, sc);
                            break;

                        case 2:
                            System.out.println("책 목록 출력");
                            displayAllBooks(bookList);
                            break;

                        case 21 :
                            System.out.println("책 번호 순으로 정렬된 책 목록을 출력합니다.");
                            Collections.sort(bookList, Comparator.comparing(Book::getNo));
                            displayAllBooks(bookList);
                            break;

                        case 22 :
                            System.out.println("책 번호 역순으로 정렬된 책 목록을 출력합니다.");
                            Collections.sort(bookList, Comparator.comparing(Book::getNo).reversed());
                            displayAllBooks(bookList);
                            break;

                        case 23 :
                            System.out.println("책 제목 순으로 정렬된 책 목록을 출력합니다.");
                            Collections.sort(bookList, Comparator.comparing(Book::getTitle));
                            displayAllBooks(bookList);
                            break;

                        case 24 :
                            System.out.println("책 제목 역순으로 정렬된 책 목록을 출력합니다.");
                            Collections.sort(bookList, Comparator.comparing(Book::getTitle).reversed());
                            displayAllBooks(bookList);
                            break;

                        case 25 :
                            System.out.println("책 가격 순으로 정렬된 책 목록을 출력합니다.");
                            Collections.sort(bookList, Comparator.comparing(Book::getPrice));
                            displayAllBooks(bookList);
                            break;

                        case 26 :
                            System.out.println("책 가격 역순으로 정렬된 책 목록을 출력합니다.");
                            Collections.sort(bookList, Comparator.comparing(Book::getPrice).reversed());
                            displayAllBooks(bookList);
                            break;

                        case 27 :
                            System.out.println("책 발행 순으로 정렬된 책 목록을 출력합니다.");
                            Collections.sort(bookList, Comparator.comparing(Book::getPublishedAt));
                            displayAllBooks(bookList);
                            break;

                        case 28 :
                            System.out.println("책 발행 역순으로 정렬된 책 목록을 출력합니다.");
                            Collections.sort(bookList, Comparator.comparing(Book::getPublishedAt).reversed());
                            displayAllBooks(bookList);
                            break;


                        case 3:
                            System.out.println("책 정보 수정");
                            modifyBook(bookList, sc);
                            break;

                        case 4:
                            System.out.println("책 삭제");
                            deleteBook(bookList, sc);
                            break;

                        case 0:
                            System.out.println("프로그램을 종료합니다.");
                            sc.close();
                            save(); // 파일 저장하기
//                            sc.nextLine();
                            return;

                    }
                } else {
                    System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
                    break;
                }
            }
        }
    } // end main()

    // 읽기
    private static void read() {
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
                 bookno = oin.readLong();
                bookList = (ArrayList<Book>) oin.readObject();
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
    // 저장
    private static void save() {
        try (
                OutputStream out = new FileOutputStream(new File(DATA_DIR, DATA_FILE));
                ObjectOutputStream oout = new ObjectOutputStream(out);
        ) {
            oout.writeLong(bookno);
            oout.writeObject(bookList);

            System.out.println("파일을 저장하였습니다.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 생성
    public static void addBook(ArrayList<Book> bookList, Scanner sc) {
        while (true) {
            System.out.print("책 번호 입력 (알파벳1자리 + 숫자4자리 형식): ");
            String no;
            try {
                no = sc.nextLine().toUpperCase(); // 입력된 도서번호를 대문자로 변환하여 저장
                // 책 번호 유효성 검사
                // 알파벳 기준(A~Z)을 벗어나고 숫자4자리를 포함하지 않으면 걸러내줌
                if (!no.matches("[A-Z]\\d{4}")) {
                    throw new IllegalArgumentException("책 번호 형식이 올바르지 않습니다.");
                }
                // 사용자가 책 번호를 입력하지 않으면 조건문은 true 가 됨
                // 그래서 조건문이 true 이므로, IllegalArgumentException 을 발생시켜서
                //  오류 메시지 표시후에 다시 책 번호를 입력하게 해줌
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue; // 올바른 형식이 입력될 때까지 반복
            }

            System.out.print("책 제목 입력: ");
            String title;
            try {
                title = sc.nextLine();
                // 책 제목 필수 입력 유효성 검사
                // 만약 책 제목이 비어 있다면~
                if (title.isEmpty()) {
                    throw new IllegalArgumentException("책 제목은 반드시 입력해야 합니다.");
                    // 사용자가 책 제목을 입력하지 않으면 조건문은 true 가 됨
                    // 그래서 조건문이 true 이므로, IllegalArgumentException 을 발생시켜서
                    //  오류 메시지 표시후에 다시 제목을 입력하게 해줌
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue; // 제목이 입력될 때까지 반복
            }

            // 조건에는 0이상의 정수지만 혹여나 문자를 입력 할 수도 있으니
            int price;
            while (true) {
                System.out.print("가격 입력(0 이상의 정수): ");
                String inputPrice = sc.nextLine();
                try {
                    price = Integer.parseInt(inputPrice);
                    if (price < 0) {
                        throw new IllegalArgumentException("가격은 0 이상이어야 합니다.");
                    }
                    break; // 양의 정수가 입력되면 반복 종료
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다. 가격은 숫자로만 입력해야 합니다.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }


            // 사용자로부터 올바른 형식의 날짜를 입력받을 때까지 반복
            // 올바른 날짜가 입력되면 이 값을 LocalDate.parse(dateString)으로 변환해서
            // publishedAt 변수에 할당
            LocalDate publishedAt;
            while (true) {
                System.out.print("출판일 입력(yyyy-MM-dd): ");
                String dateString = sc.nextLine();

                try {
                    // 날짜 입력 형식 및 유효성 검사
                    publishedAt = LocalDate.parse(dateString);
                    break; // 유효한 날짜가 입력되면 반복 종료
                } catch (DateTimeParseException e) {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                }
            }

            // Book 객체 생성 후 bookList에 추가
            Book newBook = new Book(no, title, price, publishedAt);
            bookList.add(newBook);

            System.out.println("데이터가 입력되었습니다.");
            break; // 입력이 완료되면 반복 종료
        }
    }


    // 조회
    public static void displayAllBooks(ArrayList<Book> bookList) {
        if (bookList.isEmpty()) {
            System.out.println("등록된 책이 없습니다.");
            return;
        }

        // 정렬된 책 목록 출력
        System.out.println("등록된 책 목록:");
        System.out.printf(" %6s| %-20s| %10s| %s%n", "Uid", "Title", "Price", "Publication");
        for (Book book : bookList) {
            // 가격을 세 자리 단위로 콤마를 붙이고 우측 정렬하여 출력
            System.out.printf(" %6s| %-20s| %,10d| %s%n", book.getNo(), book.getTitle(), book.getPrice(), book.getPublishedAt());
        }
    }

    // 수정
    public static void modifyBook(ArrayList<Book> bookList, Scanner sc) {
        while (true) {
            System.out.print("수정할 책번호를 입력하세요: ");
            String choiceNo;
            try {
                choiceNo = sc.nextLine().toUpperCase(); // 입력된 도서번호를 대문자로 변환하여 저장
                // 입력된 책 번호가 비어 있으면 예외를 발생시킴
                if (choiceNo.isEmpty()) {
                    throw new IllegalArgumentException("책 번호를 입력해주세요.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue; // 책 번호가 입력될 때까지 반복
            }

            // 입력된 책 번호와 일치하는 책을 찾아 수정
            for (Book book : bookList) {
                if (book.getNo().equals(choiceNo)) { // 선택된 책 번호와 일치하는 책을 찾았을 때
                    System.out.print("책 제목 입력: ");
                    String title;
                    try {
                        title = sc.nextLine();
                        // 책 제목이 비어 있으면 예외를 발생시킴
                        if (title.isEmpty()) {
                            throw new IllegalArgumentException("책 제목을 입력해주세요.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue; // 책 제목이 입력될 때까지 반복
                    }

                    int price;
                    while (true) {
                        System.out.print("가격 입력(0 이상의 정수): ");
                        String inputPrice = sc.nextLine();
                        try {
                            price = Integer.parseInt(inputPrice);
                            if (price < 0) {
                                throw new IllegalArgumentException("가격은 0 이상이어야 합니다.");
                            }
                            break; // 양의 정수가 입력되면 반복 종료
                        } catch (NumberFormatException e) {
                            System.out.println("잘못된 입력입니다. 가격은 숫자로만 입력해야 합니다.");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    LocalDate publishedAt;
                    while (true) {
                        System.out.print("출판일 입력(yyyy-MM-dd): ");
                        String dateString = sc.nextLine();

                        try {
                            // 날짜 입력 형식 및 유효성 검사
                            publishedAt = LocalDate.parse(dateString);
                            break; // 유효한 날짜가 입력되면 반복 종료
                        } catch (DateTimeParseException e) {
                            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                        }
                    }

                    // 책 정보 수정
                    book.setTitle(title);
                    book.setPrice(price);
                    book.setPublishedAt(publishedAt);

                    System.out.println("수정되었습니다.");
                    return; // 수정이 완료되면 메소드 종료
                }
            }

            // 반복문을 통해 책 번호에 해당하는 책을 찾지 못한 경우
            System.out.println("해당하는 책이 없습니다. 다시 입력해주세요.");
        }
    }

    // 삭제
    public static void deleteBook(ArrayList<Book> bookList, Scanner sc) {
        System.out.print("삭제하려는 책번호를 입력하세요: ");
        String deleteNo = sc.nextLine().toUpperCase(); // 입력된 도서번호를 대문자로 변환하여 저장

        // 입력된 책 번호와 일치하는 책을 찾아 삭제
        for (Book book : bookList) {
            if (book.getNo().equals(deleteNo)) {
                bookList.remove(book);
                System.out.println("책이 삭제되었습니다.");
                return;
            }
        }

        // 반복문을 통해 책 번호에 해당하는 책을 찾지 못한 경우
        System.out.println("해당하는 책이 없습니다.");
    }


} // end class


// 정렬 미구현























