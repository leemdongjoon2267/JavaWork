-- --------------------------------------
-- Sub Query

-- #7101
-- t_emp 테이블에서
-- scott 보다 급여를 많이 받는 사람의 이름과 급여 출력

select sal from t_emp where ename = 'SCOTT';

select ename, sal from t_emp where sal > (select sal from t_emp where ename = 'SCOTT');

-- #7102
-- t_student 테이블에서 가장 키 큰 학생의 '이름'과 '키'를 출력

select name, height from t_student where height = (select max(height) from t_student);

-- 1. 단일행 서브쿼리
-- SubQuery 결과가 한개 1행만 나오는 것.
-- 단일행 Sub Query 의  WHERE 에서 사용되는 연산자
-- = , <> , !=, >, >= , <, <=


-- #7103)연습
-- t_student, t_department 테이블 사용하여
-- 이윤나 학생과 1전공(deptno1)이 동일한 학생들의
-- 이름(name)과 1전공이름(dname)을 출력하세요

select s.name, d.dname from t_student s, t_department d
where s.deptno1 = d.deptno and s.deptno1 = (select deptno1 from t_student where name = '이윤나');

-- subquery 는 먼저 테스트 해보자

-- #7104) 연습
-- t_professor, t_department 테이블 :
-- 입사일이 송도권 교수보다 나중에 입사한 사람의
-- 이름과 입사일, 학과명을 출력하세요

select * from t_professor;
select * from t_department;
select p.name, p.hiredate, d.deptno from t_professor p join t_department d
on p.deptno = d.deptno where hiredate < (select hiredate from t_professor where name = '송도권');




-- #7105) 연습
-- t_student 테이블 :
-- 1전공이 101번인 학과의 평균 몸무게보다 몸무게가 많은 학생들의
-- 이름과 몸무게를 출력하세요

select * from t_student;
select name, weight from t_student where deptno1 = 101;
select name, weight from t_student
where weight > (select avg(weight) from t_student where deptno1 = 101 );



-- #7106) 연습
-- t_professor 테이블에서
-- 심슨 교수와 같은 입사일에 입사한 교수 중,
-- 조인형 교수보다 월급을 적게 받는 교수의
-- 이름과 급여, 입사일을 출력하세요

select * from t_professor;
select name, pay, hiredate from t_professor where hiredate = (select hiredate from t_professor where name ='심슨')
and pay < (select pay from t_professor where name = '조인형');


-- 2. 다중행 서브쿼리
-- Sub Query 결과가 2건 이상 출력되는 것을 말합니다.
-- 다중행 Sub Query 와 함께 사용하는 연산자
--       IN 같은 값을 찾음
--      >ANY 최소값을 반환함 (서브쿼리 결과중 가장작은것보다 큰) >= any
--      <ANY 최대값을 반환함 (서브쿼리 결과중 가장큰것보다 작은) <= any
--      <ALL 최소값을 반환함 (서브쿼리 결과중 가장작은것보다 작은) >= all
--      >ALL 최대값을 반환함 (서브쿼리 결과중 가장큰것보다 큰) <= all
--      EXIST Sub Query 값이 있을 경우 반환


-- #7107) 예제
-- t_emp2, t_dept2 테이블 :
-- 근무지역 (t_dept2.area) 이 서울 지사인 모든 사원들의
-- 사번(empno)과 이름(name), 부서번호(deptno)를 출력하세요


-- 근무지역이 '서울지사' 인 부서들

-- 복잡해지면 한번에 쓰기 어려우니까 과정을 밟아가면서 작성하자 동준아
select * from t_dept2;
select * from t_emp2;
select dcode from t_dept2 where area = '서울지사';
select empno, name, deptno  from t_emp2
where deptno in (select dcode from t_dept2 where area = '서울지사');

-- #7108)
-- t_emp2 테이블 : 전체직원중 과장 직급의 최소연봉자보다 연봉이 높은 사람의 이름(name)과 직급(post), 연봉(pay)을 출력하세요.
--  단, 연봉 출력 형식은 천 단위 구분 기호와 원 표시를 하세요
select * from t_emp2;
select pay from t_emp2 where post = '과장';
select name 이름, post 직급, concat(format(pay, 0), '원') 연봉 from t_emp2
where pay > any (select pay from t_emp2 where post = '과장');
-- 이윤나 과장까지 출력하고 싶으면 >= any

-- 단일행으로 변환
select name 이름, post 직급, concat(format(pay, 0), '원') 연봉 from t_emp2
where pay > (select min(pay) from t_emp2 where post = '과장');

-- #7109) 연습
-- t_student 테이블 :
-- 전체학생중에서 체중이 4학년 학생들의 체중에서
-- 가장 적게 나가는 학생보다
-- 몸무게가 적은 학생의 이름과 학년과 몸무게를 출력하세요
select * from t_student;
select name 이름, grade 학년, weight 몸무게 from t_student
where weight < all (select weight from t_student where grade = 4);



-- #7110) 연습
-- t_emp2, t_dept2 테이블 :
-- 각 부서별 평균 연봉을 구하고 그 중에서 평균 연봉이 가장 적은 부서의 평균연봉보다
-- 적게 받는 직원들의 부서명, 직원명, 연봉을 출력 하세요

select * from t_emp2;
select * from t_dept2;

select deptno, avg(pay) from t_emp2 group by deptno;
select d.dname 부서명, e.name 직원명, e.pay 연봉
from t_emp2 e, t_dept2 d
where e.deptno = d.dcode
  and e.pay < all ( select avg(pay) from t_emp2 group by deptno )
order by e.pay;
