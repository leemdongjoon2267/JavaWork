-- 산술연산자
-- +, -, *, /

select ename, sal, sal * 1.1
from t_emp;

-- WHERE : 원하는 조건만 검색

-- SELECT [컬럼명 또는 표현식]
-- FROM [테이블명, 뷰명]
-- WHERE [조건절] ;

-- 직원 테이블(t_emp) 에서 직책(job) 이 salesman 인 사람만 조회
select * from t_emp where job = 'salesman';
select * from t_emp where job = 'SalesMan'; -- MySQL 은 대소문자 구분 없이 비교 (디폴트)

select * from t_emp where binary(job) = 'SalesMan'; -- MySQL 에서 대소문자 구분하여 비교

-- 직원 테이블(t_emp) 에서 10번 부서(deptno)에 근무하는 직원의
-- 원의 이름(ename)과 급여(sal)와 부서번호(deptno) 출력

select ename "이름", sal "급여", deptno "부서번호" from t_emp where deptno = 10;

-- 직원 테이블(t_emp) 에서 급여(sal) 가 2000보다 큰 사람의
-- 이름(ename)과 급여(sal)를 출력하세요

select ename "이름", sal "급여" from t_emp where sal > 2000;

-- 직원 테이블(t_emp) 에서 이름이 SCOTT인 사람의
-- 이름(ename)과 사원번호(empno), 급여(sal) 출력

select ename "이름", empno "사원번호", sal "급여" from t_emp where ename = 'scott';

-- 학생 테이블(t_student) 에서
-- 2,3 학년(grade) 학생의  이름(name), 학년(grade) 출력

select name "이름", grade "학년" from t_student where grade = 2 or grade = 3;
select name "이름", grade "학년" from t_student where grade in(2, 3);
-- 1학년 4학년
select name "이름", grade "학년" from t_student where grade not in(2, 3);
-- 2학년 ~ 4학년
select name "이름", grade "학년" from t_student where grade between 2 and 4;

-- 교수님 (t_professor) 중에서
-- 급여 (pay) 가 300 보다 크고,
-- 직급 (position) 이 '정교수' 인 분들의
-- 이름(name), 급여(pay), 직급(position) 을 출력하세요


select name "이름", pay "급여", position "직급" from t_professor where pay > 300 and position = '정교수';

select * from t_professor where bonus is null ;

-- null 값과 다른 값과의 연산 결과는 무조건 null
select name, pay, bonus, pay + bonus from t_professor;

-- LIKE 와 같이 쓰는 와일드 카드  % ,  _
-- % : 글자수 제한 없고 어떤 글자가 와도 됨
-- _ : 글자수는 한글자가 반드시 와야 되고 어떤 글자 와도 좋음

--  교수님 중에서 김씨 성을 가진 교수님의 이름만 출력 (LIKE 사용)
SELECT name FROM t_professor where name like '김%';

-- 연습
-- 직원 테이블(t_emp)에서 직원이름 (ename) 중에
-- NE 문자열이 포함된 직원만 출력

select * from t_emp;

select ename from t_emp where ename like '%ne%';

-- 연습
-- 직원 테이블(t_emp)에서 직원이름 (ename) 중에
-- 두번째 글자가 'A' 인 사람의 이름(ename)만 출력

select ename from t_emp where ename like '_a%';

-- -------------------------------


-- ORDER BY : SELECT 결과 정렬

-- SELECT [컬럼명 또는 표현식]
-- FROM [테이블명, 뷰명]
-- WHERE [조건절] ;
-- ORDER BY [정렬할 컬럼] [ASC|DESC]...  (ORDER BY 절 SELECT 의 가장 마지막)
--                 ascending | descending


-- 직원중 이름에 L 이 들어간 사람의 이름을 사전내림차순으로 출력하기
SELECT ename FROM t_emp where ename like '%l%' order by ename desc;

select ename, job, sal from t_emp order by job desc, sal asc;

-- 연습
-- 학생 테이블(t_student) 에서  학생의 이름(name)과 학년(grade)와 키(height)를 출력하세요,
-- 단 학년은 1학년부터 출력하고,  키는 큰사람부터  출력하세요


select name "이름", grade "학년", height "키" from t_student order by grade asc, height desc;




