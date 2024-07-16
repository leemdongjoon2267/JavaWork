select '심의선', '할말하않';

-- select 명령의 결과는 테이블 형태 aka. Record Set (Result Set)

select 100, 10, 100 + 10, 100 *10;

select * from t_professor;

-- SELECT - 데이터 조회/질의
-- SELECT [컬럼명 또는 표현식] FROM [테이블명, 뷰명]

-- '모든 컬럼' 조회 : * 사용
select * from t_emp;

-- 원하는 컬럼만 조회
select EMPNO, ENAME
    from t_emp;

-- 컬럼 별칭 (alias) 사용하여 select
select studno 학번, name 이름 from t_student;


select studno "학생 학번", name as 이름 from t_student;

-- 연습1
-- t_emp 테이블에서  empno 를 '사원번호',
-- ename을 '사원명',
-- job을 '직업'으로 별명을 설정하여 출력
select empno as 사원번호, ename as 사원명, job as 직원 from t_emp;

-- t_dept 테이블을 사용하여 deptno를 '부서#', dname을 '부서명', loc를 '위치' 로 별명을 설정하여 출력
select deptno as 부서, dname as 부서명, loc as 위치 from t_dept;

-- DISTINCT - 중복값 제거하고 출력
-- SELECT  DISTINCT [컬럼명 또는 표현식] FROM [테이블명, 뷰명]

select distinct deptno from t_emp;

-- 문자열 연결 concat() 사용
select name, position from t_professor;
# select name + position from t_professor;
select concat(name, ' ', position) "우리교수님들" from t_professor;










