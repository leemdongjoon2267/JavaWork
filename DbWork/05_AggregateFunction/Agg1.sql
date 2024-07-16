select count(*), count(hpage) from t_professor; -- 그룹함수에서 집계할때 null 값은 (기본적으로) 제외
select * from t_professor;
select count(bonus), sum(bonus) from t_professor;
select avg(bonus) from t_professor; -- null 값이 빠진 평균
select max(hiredate), min(hiredate) from t_professor;

-- 교수님들의 보너스 평균값 출력 ( AVG() 사용)
-- 그룹함수는 null 값은 계산안하기 때문에
-- null 허용 필드에 대해 계산할때는 반드시 ifnull 등을 사용하여 처리해야 함

select avg(bonus) from t_professor;
select avg(bonus), avg(ifnull(bonus, 0)) from t_professor;

-- t_professor 테이블에서 '학과별'로 교수들의 평균 급여를 출력하세요

select deptno, avg(pay) from t_professor group by deptno;
-- SELECT 절에 그룹함수 아닌 것과 그룹함수는 같이 올수는 없다.
-- 이 경우 그룹함수가 아닌 것들은 GROUP BY 로 묶여야 할 것이다.

-- #5101)연습
-- t_professor 테이블 : 학과별(deptno) 그리고 직급별(position)로 교수들의 평균 급여를 계산하여 출력하세요

select deptno, position, avg(pay) from t_professor group by deptno, position order by deptno, position;

-- 학과별 평균급여를 select 하되, 평균 급여가 450보다 많은 학과만 select
select deptno, avg(pay) from t_professor where avg(pay) > 450 group by deptno;
-- 에러 : 그룹 함수는 where 절에서 사용 불가

select deptno, avg(pay) from t_professor  group by deptno having avg(pay) > 450;
-- having 절 : 그룹함수 결과에 조건을 줄 수 있음

-- <select 쿼리문 순서> -- 처리순서
-- select              -- 5
-- from                -- 1
-- where               -- 2
-- group by            -- 3
-- having              -- 4
-- order by            -- 6

-- #5102)연습
-- t_emp 테이블: 매니저별(MGR)로 관리하는 직원들의
-- ‘매니저’, ‘직원수’와 ‘급여총액’과 ‘급여평균’과 ‘교통비 (COMM) 평균’ 지급액 을 출력하세요.
-- 단 사장님은 (job = president)제외

select * from t_emp;
select mgr 매니저, count(*) 직원수, sum(sal) 급여총액, avg(sal) 급여평균, ifnull(avg(comm), 0) 교통비평균
from t_emp where job <> 'president' group by mgr;


-- t_professor 테이블 :  직위가 정교수 혹은 조교수 인 분들 중에서 ‘과별(deptno)’로
-- 과번호, 소속교수 총수, 근속일 평균, 급여평균, 보너스 평균을 출력해보세요
select * from t_professor;

select deptno, count(*) 총인원,
       avg(datediff(now(), hiredate)) 근속평균,
       avg(pay) 급여평균,
       avg(ifnull(bonus,0)) 보너스평균
FROM t_professor
WHERE position like '%교수'

group by deptno;

--  t_student 테이블 : 학과별(deptno1) 로,  학과번호, 최대몸무게 - 최소몸무게 차이 값을 출력해보세요
select * from t_student;

select deptno1 학과, max(weight) - min(weight) 몸무게차 from t_student group by deptno1;

-- 그 차이가 30 이상인것만 출력하려면?
select deptno1 학과, max(weight) - min(weight) 몸무게차 from t_student group by deptno1 having (max(weight) - min(weight)) >= 30;

-- 요즘 MySQL 은 이것도 된다
select deptno1 학과, max(weight) - min(weight) 몸무게차 from t_student group by deptno1 having 몸무게차 >= 30;
-- SELECT 이전임에도 SELECT 의 alias 를 사용가능? <-- 요즘 dB 엔진에선 다시 흝는다.








