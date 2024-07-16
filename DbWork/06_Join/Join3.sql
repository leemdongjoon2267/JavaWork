SELECT t_emp.deptno, t_emp.empno, t_emp.ename, t_dept.dname
FROM t_emp, t_dept
WHERE t_emp.deptno = t_dept.deptno;


-- 그동안 JOIN <=> INNER JOIN
SELECT t_emp.deptno, t_emp.empno, t_emp.ename, t_dept.dname
FROM t_emp INNER JOIN t_dept
                      ON t_emp.deptno = t_dept.deptno;

select * from t_emp;
select * from t_dept;
-- ---------------------------------------------------------
-- #08 p307
-- NATURAL JOIN 은 두 테이블 간의 '동일한 이름'을 갖는 '모든 컬럼'들에 대해
-- EQUI JOIN 수행한다 (동등 조인)
-- NATURAL JOIN 이 수행되면, 추가로 USING 조건절, ON 조건절, WHERE 조건절에서
-- JOIN 조건을 정의할수 없다.
-- (** MS SQL Server 는 지원안함)




-- 사원 번호와 사원 이름， 소속부서 코드와 소속부서 이름을 찾아본다
-- #6301
-- t_emp, t_dept 테이블에서  
-- 사원번호, 사원이름，
-- 소속부서코드, 소속부서 이름 출력
-- 부서번호(deptno), 직원번호(empno) 오름차순 정렬

select deptno, empno, ename, dname
# select *
from t_emp natural join t_dept
order by deptno, empno;
-- 두 테이블의 동일 컬럼이 먼저 등장하고 딱 한번만 나옴
-- 위에서는 비록 별도의 JOIN 조건 컬럼을 지정하지 않았으나
-- deptno 가 공통칼럼으로 '자동으로' 인식하여 JOIN 처리


-- JOIN 에 사용된 컬럼 들은 같은 데이터 유형이어야 한다.
-- ALIAS 나 테이블 명과 같은 접두어 줄수 없다
-- ★ ORACLE 에서는 에러
-- ★ MySQL 에서는 허용.
-- 가령.
-- #6302
select t_emp.deptno, empno, ename, d.dname
from t_emp natural join t_dept d
order by deptno, empno;


-- ↑ORA-25155: column used in NATURAL join cannot have qualifier (오라클의 경우는 에러)
-- ERROR: NATURAL JOIN에 사용된 열은 식별자를 가질 수 없음  (오라클의 경우)


-- NATURAL JOIN은 JOIN이 되는 테이블의 데이터 성격(도메인)과 칼럼명 등이 동일해야 하는 제약 조건이 있다.
-- 간혹 모댈령 상의 부주의로 인해 동일한 칼럼명이더라도 다른 용도의 데이터를 저장하는 경우도 있으므로 주의해서 사용해야 한다.

-- -----------------

-- 아래 ’*’ 와일드카드처럼 별도의 칼럼 순서를 지정하지 않으면 NATURAL JOIN의 기준이 되는 칼럼 들이 다른 칼럼보다 먼저 출력된다.
-- (ex: DEPTNO가 첫 번째 칼럼이 된다.) 이때 NATURAL JOIN은 JOIN에 사용된 같은 이름의 칼럼을 '하나'로 처리한다


-- #6303
SELECT *
FROM t_emp NATURAL JOIN t_dept;


-- 반면， INNER JOIN의 경우
-- 첫 번째 테이블，두 번째 테이블의 칼럼 순서대로 데이터가 출력된다
-- 이때 NATURAL JOIN은 JOIN에 사용된 같은 이름의 칼럼을 하나로 처리하지만
-- INNER JOIN은 별개의 칼럼으로 표시한다.
-- #6304
SELECT *
FROM t_emp INNER JOIN t_DEPT ON t_EMP.DEPTNO = t_DEPT.DEPTNO;


-- --------------------------------------------------------------------------
-- NATURAL JOIN과 INNER JOIN의 차이를 자세히 설명하기 위해 DEPT TEMP 태이블을 임시로 만든다


-- #6305

create table dept_temp
as
select * from t_dept; -- select 한 결과로 table 을 만들어라

select * from dept_temp;

desc dept_temp; -- 테이블 구조 확인
-- #6306
update dept_temp set dname = 'R&D' where dname = 'RESEARCH';
update dept_temp set dname = 'MARKETING' where dname = 'SALES';

select * from t_dept;
select * from dept_temp;

-- #6307)
select * from t_dept natural join dept_temp;
select * from t_dept, dept_temp
where t_dept.deptno = dept_temp.deptno
and t_dept.dname = dept_temp.dname
and t_dept.loc = dept_temp.loc;

-- -------------------------------------------------------------------------------
-- USING 조건절

-- NATURAL JOIN에서는 모든 일치되는 칼럼들에 대해 JOIN이 이루어지지만
-- 반면 일반적인 JOIN 에서도 FROM 절의 USING 조건절을 이용하면
-- 같은 이름을 가진 칼럼들 중에서 원하는 칼럼에 대해서만 선택적으로 EQUI JOIN을 할 수가 있다.
-- 다만， 이 기능은 MS SQL Server에서는 지원하지 않는다.

-- #6308 [예제]
-- 세 개의 칼럼명이 모두 같은 DEPT와 DEPT TEMP 테이블을 DEPTNO 칼럼을 이용한 [INNER] JOIN의 USING 조건절로 수행한다

select * from t_dept join dept_temp using(deptno);
-- deptno 칼럼을 중심으로 자연조인을 해라

select * from t_dept join dept_temp dt using(deptno, dname, loc);

-- 위 SQL의 '*' 와일드카드처럼 별도의 칼럼 순서를 지정하지 않으면
-- USING 조건절의 기준이 되는 칼럼이 다른 칼럼보다 먼저 출력된다
-- (ex: DEPTNO가 첫 번째 칼럼이 된다 )
-- 이때 USING JOIN은 JOIN에 사용된 같은 이름의 칼럼을 하나로 처리한다

select * from t_dept join dept_temp dt using(dname);


-- [예제]
-- USING 조건절을 이용한 EQUI JOIN에서도 NATURAL JOIN과 마찬가지로
-- JOIN 칼럼에 대해서는 ALIAS나 테이블 이름과 같은 접두사를 붙일 수 없다 (DEPT.DEPTNO • DEPTNO) ·
-- * MySQL 은 가능!


-- ↓잘못된 사례:
-- #6309
SELECT t_dept.deptno, t_dept.dname, t_dept.loc, dept_temp.dname, dept_temp.loc
FROM t_dept JOIN dept_temp USING (deptno);

-- 바른사례:
-- #6310
SELECT deptno, t_dept.dname, t_dept.loc, dept_temp.dname, dept_temp.loc
FROM t_dept JOIN dept_temp USING (deptno);
-- using 안에 있는 칼럼앞에 접두어를 붙이면 안됨

select * from t_dept;
select * from dept_temp;

select * from t_dept join dept_temp using(deptno, dname);


-- 이번에는 세 개의 칼럼명이 모두 같은 DEPT와 DEPT TEMP 테이블을 LOC와 DEPTNO 2개 칼럼을 이용한  [INNER] JOIN의 USING 조건절로 수행한다.
select loc, deptno, t_dept.dname dname , dept_temp.dname dname from t_dept  join dept_temp using(loc, deptno);





