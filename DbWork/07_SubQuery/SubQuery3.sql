-- DDL, DML 의 subquery

-- INSERT 의 subquery
-- CREATE TABLE
-- UPDATE 의 set 절

CREATE TABLE test_emp_a (
emp_id    INT,
emp_name  VARCHAR(100)
);


CREATE TABLE test_emp_b (
emp_id    INT,
emp_name  VARCHAR(100)
);

-- 한 row 씩 insert
insert into test_emp_a values(101, '아이언맨');

insert into test_emp_b values(201, '켑틴아메리카');

-- 여러개의 row 를 한번에 insert
insert into test_emp_a
values(102, '블랙위도우'), (103, '토르'), (104, '블랙팬서');


select * from test_emp_a;
select * from test_emp_b;

-- sub query 로 insert 가능
-- select 의 결과가 insert 됨
insert into test_emp_a (select 105, '스파이더맨');
select * from test_emp_a;

select emp_id from test_emp_a;

insert into test_emp_b(emp_id) (select emp_id from test_emp_a);
-- test_emp_a 테이블에서 emp_id 열의 값을 선택합니다.
-- 선택된 값들을 test_emp_b 테이블의 emp_id 열에 삽입합니다.
insert into test_emp_a(select * from test_emp_a);

select * from phonebook;
insert into phonebook(select * from phonebook); -- 에러 id 값이 고정값이여서

insert into phonebook(name, regdate) (select name, now() from phonebook);

-- sub query 로 create table

create table test_emp_c
as
select * from test_emp_a;

select * from test_emp_c;