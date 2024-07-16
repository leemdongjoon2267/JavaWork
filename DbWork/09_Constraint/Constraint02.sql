-- 복합키 제약조건 만들기

-- 복수개 컬럼에 pk 지정

CREATE TABLE test_member (
mb_uid INT NOT NULL,
mb_nick VARCHAR(10) NOT NULL,
mb_name VARCHAR(10) NOT NULL,
    constraint test_member_pk primary key (mb_uid, mb_nick) -- 복합키 설정
);

insert into test_member values (1, 'aaa', 'John'); -- pk : 1-aaa
insert into test_member values (1, 'bbb', 'John'); -- pk : 1-bbb
insert into test_member values (2, 'aaa', 'John'); -- pk : 2-aaa

