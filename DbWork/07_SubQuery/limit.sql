-- SELECT 결과물중 맨 위의 5개만 출력해보고 싶으면 어케 해야 하나?
-- SELECT 결과물중 n 번째 부터 m 개를 출력하고 싶다면?
--   ex) 게시판.. 페이징


-- DBMS 마다 구현 방법 다름
-- MYSQL : LIMIT
-- MS SQL server : TOP
-- ORACLE : ROWNUM

select empno, name from t_emp2;

-- 샘플용 테이블 만들기
DROP TABLE IF EXISTS t_emp3;
CREATE TABLE t_emp3(
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       empno INT NOT NULL,
                       name VARCHAR(10) NOT NULL
);

insert into t_emp3(empno, name) select empno, name from t_emp2;
select * from t_emp3;

-- 뻥튀기
insert into t_emp3(empno, name) select empno, name from t_emp3;

select count(*) from t_emp3;

-- limit n : 첫 n 개

select * from t_emp3 limit 5;
select * from t_emp3 order by id desc limit 5; -- order by 보다 늦게옴

-- LIMIT from, n : from 부터 n개   (from 은 index 0 부터 시작)
-- ↓만약 한 페이지당 5개씩 보여준다면..

select * from t_emp3 limit 0, 5; -- 첫페이지
select * from t_emp3 limit 5, 5; -- 2페이지
select * from t_emp3 limit 10, 5; -- 3페이지

-- select * from t_emp3 limit (page -1) * n, n; // page 는 1부터 시작

-- id 역순
select * from t_emp3 order by id desc limit 0, 5;
select * from t_emp3 order by id desc limit 5, 5;
select * from t_emp3 order by id desc limit 10, 5;