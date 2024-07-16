-- ↓ DDL 작성하기

create table TEST_STUDENT(
    stu_uid  int primary key,
    stu_name varchar(10) not null,
    stu_age int check (stu_age >= 0),
    stu_grade int check (1 <= stu_grade <=4),
    dept_uid int,
    foreign key (dept_uid) references TEST_STUDENT(stu_uid)

);
select stu_uid 학생고유번호, stu_name 학생이름, stu_age 나이, stu_grade 학년, dept_uid 전공번호
from TEST_STUDENT;

drop table if exists TEST_STUDENT cascade;
desc TEST_STUDENT;

create table TEST_DEPARTMENT(
    dept_uid  int primary key,
    dept_name varchar(10) not null unique ,
    dept_build ENUM ('K301', 'A203', 'B306')
);

select dept_uid 학과고유번호, dept_name 학과명, dept_build 건물동번호 from TEST_DEPARTMENT;
drop table if exists TEST_DEPARTMENT cascade;
desc TEST_DEPARTMENT;

-- ↓ DML 작성하기
insert into TEST_STUDENT (stu_uid, stu_name, stu_age, stu_grade, dept_uid) values
    (1, '학생1', 20, 3, 1),
    (2, '학생2', 21, 2, 1),
    (3, '학생3', 22, 4, 2),
    (4, '학생4', 19, 1, 3),
    (5, '학생5', 23, 3, 3);

insert into TEST_DEPARTMENT (dept_uid, dept_name, dept_build) values
    (1, '컴퓨터과학과', 'K301'),
    (2, '전자공학과', 'A203'),
    (3, '경영학과', 'B306');



-- ────────────────────────────────────────
-- 정규화 수행하기


# 1. 위 설계를 검토해보고, 발생할수 있는 ‘이상증상’을 예를 두가지 이상 서술해보세요,
# =>

-- 갱신 이상: 만약 회원 "솔방울"의 나이가 변경된다면, 같은 회원이 작성한 모든 게시글의 회원 나이 정보도 함께 갱신해야 함

-- 삭제 이상 : 회원 "솔방울"이 작성한 게시글이 삭제되면,
-- 그에 따라 해당 회원의 정보도 함께 삭제해야 함
-- 그러나 회원 "솔방울"이 작성한 게시글이 여러 개 있으므로, 이 회원의 정보를 삭제하려면 모든 관련된 게시글을 먼저 함

# 삽입이상 : 새로운 회원이 가입되었다. ‘게시글번호(PK)’ 가 없어서 삽입 불가
# 삭제이상 : 1004 글이 삭제되면 박김치 회원 정보까지 삭제됨.
# 수정이상 : 1002 글 작성자의 회원이름을 변경하면 정보 불일치 발생


# 2. 위 테이블의 ‘정규화’를 수행해보세요
#     a. 정규화 사유를 기술하세요
# =>

# 사유: 부분 함수적 종속 제거
#
#     게시글번호, 회원번호 → 회원이름, 회원나이, 게시글추천수
#                회원번호 → 회원이름, 회원나이


#     b. 정규화 결과로 나뉘어진 테이블을 답안에 서술하세요
# =>

# 게시글번호   회원고유번호  게시글추천수
# 1001        10              44
# 1002        20              33
# 1003        10              22
# 1004        40              11
# 1005        20              55


# 회원고유번호    회원이름    회원나이
# 10              솔방울     25
# 20              김만두     22
# 40              박김치     22


# -----------------------------
#  이름 |   나이   |  날짜  |
# ------------------------------
#  은정 |    23    | 2023-02-03|
#  ..       ..        ..
# ------------------------------

# =>

