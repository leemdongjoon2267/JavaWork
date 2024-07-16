-- 제약조건 (Constraint)
-- MySQL 에서 Table 의 제약조건 확인
-- SELECT * FROM Information_schema.table_constraints WHERE table_schema="db이름";
-- SELECT * FROM Information_schema.table_constraints WHERE table_schema="db이름" AND table_name="table이름";


select * from information_schema.table_constraints where table_schema = 'db326';
-- 테이블 정보
select * from information_schema.table_constraints where table_schema = 'db326' and table_name = 't_emp4';

-- MySql 은 nn(not null) 에 대한 내용은 제약조건으로 다루지 않고 컬럼의 속성으로 다룬다

select * from t_dept2;

-- DROP TABLE IF EXISTS ~ CASCADE 옵션을 주면
-- 이를 참조하는 다른 관계된 테이블의 데이터도 연쇄 삭제딤

-- #9001
drop table if exists t_emp4 cascade;

-- 컬럼과 함께 명시
create table t_emp4(
    no int primary key, -- 기본키로 지정 : null 값을 가지지 않고 중복을 사용하지 않음
    name varchar(10) not null ,
    jumin varchar(13) not null unique , -- 제약조건 여러개 설정 가능
    -- unique : 유일값(중복 처리안됨), 기본키랑 비슷하다고 보면됨
    area int check (area < 5),
    deptno varchar(6) references t_dept2(dcode) -- 외래키 reference : 참조 즉, t_dept2 의 dcode 를  참조함
);
select * from t_emp4;

-- 별도의 항목으로 표시
create table t_emp4(
    no int,
    name varchar(10) not null ,
    jumin varchar(13) not null,
    area int,
    deptno varchar(6),
    primary key(no), -- 기본키
    unique (jumin), -- unique
    check (area < 5), -- 연산자들을 사용해 제약조건을 걸어줄때 사용
    foreign key (deptno) references t_dept2(dcode) -- 이렇게 할때는 누가 누구를 참조하는지 명시해줘야함
);

-- 제약조건에 이름을 달아 정의 가능
drop table if exists t_emp3 cascade;

create table t_emp3(
    no int,
    name varchar(10) not null ,
    jumin varchar(13) not null,
    area int,
    deptno varchar(6),
    constraint emp3_no_pk primary key(no),
    constraint emp3_jumin_uk unique (jumin),
    constraint emp3_area_ck check (area < 5),
    constraint emp3_deptno_fk foreign key (deptno) references t_dept2(dcode)
);

select * from t_emp3;
select * from information_schema.table_constraints where table_schema = 'db326' and table_name = 't_emp3';
-- ↑ 이름이 설정된것 확인하기

-- #9005)  t_emp3 에 제약조건에 맞는 / 위배되는 DML 시도해보기
-- 제약조건에 맞는 DML / 제약조건에 위배되는 DML

insert into t_emp3 values (1, 'MySQL', '1234561234567', 4, 1000);
-- 두번 실행하면 오류
-- SQL Error [1062] [23000]: Duplicate entry '1' for key 't_emp3.PRIMARY'
-- no 값이 기본키여서 중복이 안됨

insert into t_emp3 values (2, '오라클', '1234561234567', 4, 1000);
-- jumun unique 제약조건 위배
-- Duplicate entry '1234561234567' for key 't_emp3.emp3_jumin_uk'
-- 주민번호가 unique 여서 유일값을 가지므로 중복이 안됨

insert into t_emp3 values (2, '오라클', '222222222222222222222222', 4, 1000);
-- varchar(13) 초과
-- Data truncation: Data too long for column 'jumin' at row 1

insert into t_emp3 values (2, 'tigers', '2222222222222', 3, 2000);
-- fk 제약조건 위배
-- Cannot add or update a child row: a foreign key constraint fails (`db326`.`t_emp3`, CONSTRAINT `emp3_deptno_fk` FOREIGN KEY (`deptno`) REFERENCES `t_dept2` (`DCODE`))
-- dept2 테이블의 2000 의 값이 없음

select * from t_dept2;

insert into t_emp3 values (2, 'tigers', '2222222222222', 10, 1000);
-- check 제약조건 위배
-- Check constraint 'emp3_area_ck' is violated.
-- check(area < 5)

insert into t_emp3 (no, jumin, area, deptno) values (2, '3333333333333', 4, 1001);
-- not null 제약조건 위배
-- Field 'name' doesn't have a default value

-- update/delete 에서도 제약조건 오류 날수 있음
select * from t_emp3;
update t_emp3 set area = 10 where no = 1;
-- check 제약조건 위배;

delete from t_dept2 where dcode = 1000;
-- 참조되고 있는 부모는 삭제 불가
-- 삭제 할거면 자식 먼저 삭제하고 부모 삭제가능
-- Cannot delete or update a parent row: a foreign key constraint fails (`db326`.`t_emp3`, CONSTRAINT `emp3_deptno_fk` FOREIGN KEY (`deptno`) REFERENCES `t_dept2` (`DCODE`))

-- #9005)   ALTER 명령 사용하여 테이블 에 제약조건 추가가능
-- 위에서 생성한 t_emp4 테이블의 name 컬럼에 UNIQUE 제약조건 추가하기
alter table t_emp4 add constraint emp4_name_uk unique (name);
-- t_emp4 테이블에서 name 에 별명이 emp4_name_uk 라는 unique 제약조건을 넣어줌

SELECT * FROM Information_schema.table_constraints
WHERE table_schema='db326' AND table_name= 't_emp4';

-- #9006)
-- t_emp4 테이블의 area 컬럼에 NOT NULL 제약조건 추가해보세요
-- (과연 ADD CONSTRAINT 로 될까?)
alter table t_emp4 modify column area int not null;
desc t_emp4;
-- not null 조건은 add 로 안되기 때문에 modify column 을 사용해줌


-- 외래키 추가
-- t_emp4 테이블의 name 컬럼이
-- t_emp2 테이블의 name 컬럼의 값을 참조하도록 참조키 제약조건을 설정하세요
-- 그러나! 참조되는 부모테이블의 컬럼은 Primary Key 이거나 Unique 이어야 한다
-- 다음은 에러다
alter table t_emp4 add constraint emp_name_fk foreign key(name) references t_emp2(name);
select * from t_emp2;

-- 부모테이블의 name 을 unique 제약조건을 추가뒤 위의 쿼리 다시 실행
alter table t_emp2 add constraint emp_name_uk unique (name);


-- #9008)    t_emp3 테이블을 DROP 하고, 이전과 같은 조건으로 다시 만들되
-- t_dept2(dcode)를 참조하는 detpno 컬럼은
-- 부모테이블의 해당 데이터가 삭제되면 참조하는 자식도 함께 삭제되도록 설정

-- 참조하는 부모테이블의 데이터에
-- ON DELETE [reference_option]
--
-- 1. RESTRICT : (디폴트) 개체를 변경/삭제할 때 다른 개체가 변경/삭제할 개체를 참조하고 있을 경우 변경/삭제가 취소됩니다.(제한)
-- 2. CASCADE : 개체를 변경/삭제할 때 다른 개체가 변경/삭제할 개체를 참조하고 있을 경우 함께 변경/삭제됩니다.
-- 3. NO ACTION : MYSQL에서는 RESTRICT와 동일합니다.
-- 4. SET NULL : 개체를 변경/삭제할 때 다른 개체가 변경/삭제할 개체를 참조하고 있을 경우 참조하고 있는 값은 NULL로 세팅됩니다.

-- https://dev.mysql.com/doc/refman/8.0/en/create-table-foreign-keys.html


DROP TABLE IF EXISTS t_emp3 CASCADE;
CREATE TABLE t_emp3 (
    no INT,
    name VARCHAR(10) NOT NULL,
    jumin VARCHAR(13) NOT NULL,
    area INT,
    deptno VARCHAR(6),
    CONSTRAINT emp3_no_pk PRIMARY KEY(NO),
    CONSTRAINT emp3_jumin_uk UNIQUE(jumin),
    CONSTRAINT emp3_area_ck CHECK(area < 5),
    CONSTRAINT emp3_deptno_fk FOREIGN KEY(deptno) references t_dept2(dcode)
    on delete cascade  -- 부모테이블의 참조가 삭제되면 참조하는 자시도 자동으로 연쇄 삭제
    -- on update ... -- 부모테이블의 참조내용이 수정되는 경우 자식쪽도 수정을 할지 부모쪽의 변경을 막을지
);



