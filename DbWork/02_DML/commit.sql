-- DCL : Data Control Language
-- commit : 작업결과를 물리적 디스크에 저장.  manipulation 작업이 정상적으로 완료
-- rollback : 원래의 데이터 상태로 복구

-- 테이블과 데이터 준비
DESC phonebook;
SELECT * FROM phonebook ;

DROP TABLE IF EXISTS phonebook; 

-- 이것이 SQL 한줄 주석

-- 기본적으로 MySQL 은 auto-commit 이다
-- DML 은 실행 즉시 물리적인 데이터에 반영된다.

-- MySQL 은 기본적으로 auto commit 이다.
-- commit 을 사용하려면 auto commit 부터 비활성화 해야 한다.

select @@autocommit; -- 현재 auto COMMIT 활성화 여부 1: 활성화  0:비활성화

set @@autocommit = 0; -- auto commit 비활성화

delete from phonebook where id = 14;

select * from phonebook;

-- rollback 하기 전, 마지막으로 commit 한 지점까지 복구 가능하다
rollback ;

insert into phonebook(name, phonenum, email)
values('베베', '4545-4545', 'bebe@도마뱀닷컴');

commit ; -- 물리적으로 DB 에 저장

select * from phonebook;

delete from phonebook;

rollback ;








