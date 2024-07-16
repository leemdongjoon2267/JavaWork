-- 3. 다중칼럼 Sub Query
-- Sub Query 결과가 여러 칼럼인 경우.
-- 주로 Primary Key 를 여러 칼럼을 합쳐서 만들었을 경우 한꺼번에
-- 비교하기 위해서 자주 사용.


-- #7201) 예제
-- t_student 테이블을 조회하여
-- 각 학년별로 최대 키를 가진 학생들의
-- 학년과 이름과 키를 출력하세요
-- 학년 오름차순으로 출력

select grade, max(height) from t_student group by grade;

select grade, name, height from t_student
where (grade, height) in (select grade, max(height) from t_student group by grade) order by 1;
-- 먼저 where 절 안에 있는 첫번째 쿼리문에서는 max() 함수를 사용해 학년과 최대키를 구하는것이기 때문에 name 을 안씀

-- 팁 : 각 학년 별로 최대 키를 가진 학생들이라고 했으니 학년 grade, 최대키 max(height)를 where 절에 넣어줘야함


-- #7202) 연습
-- t_professor , t_department 테이블 :
-- 각 학과별로 입사일이 가장 오래된 교수의
-- 교수번호와 이름, 입사일, 학과명을 출력하세요.
-- 단 학과이름 순으로 오름차순 정렬하세요
select * from t_professor;
select * from t_department;


select p.profno 교수번호, p.name 이름, date_format(p.hiredate, '%Y-%m-%d') 입사일, d.dname 학과명
from t_professor p, t_department d where p.deptno = d.deptno
and (p.deptno, p.hiredate) in (select deptno, max(hiredate) from t_professor group by deptno)
order by d.dname;
-- 문제는 각 학과별로 입사일이 가장 오래된 교수의 교수번호를 찾는 것이기 때문에, p.profno 대신에 p.deptno와 p.hiredate를 사용
-- 서브쿼리에서 각 학과별로 가장 오래된 입사일을 구하는 데 사용

-- 팁 : 각 학과별로 입사일이 가장 오래된 교수라고 했으니 학과 deptno, 입사일 hiredate 를 where 절 안에 넣어야함

-- 서브쿼리에서 where @ in 사이에 들어갈 기준
-- 1. 필터링 조건: 서브쿼리의 결과를 필터링하기 위한 조건들이 있을 수 있습니다
-- 이 조건들은 서브쿼리의 결과를 제한하여 메인 쿼리에 전달될 행의 수를 줄입니다

-- 2. 연결 조건: 메인 쿼리와 서브쿼리 간의 관계를 정의하는 조건들이 있을 수 있습니다
-- 예를 들어, 서브쿼리의 결과를 메인 쿼리의 특정 열과 연결하여 일치하는 행들을 가져오는데 사용될 수 있습니다

-- 3. 그룹화 조건: 서브쿼리의 결과를 그룹화하고 집계하는데 필요한 조건들이 있을 수 있습니다
-- 예를 들어, 서브쿼리의 결과를 그룹화하여 특정 집계 함수를 적용할 수 있습니다

-- 4. 정렬 조건: 서브쿼리의 결과를 정렬하는데 사용될 조건들이 있을 수 있습니다
-- 예를 들어, 서브쿼리의 결과를 특정 열을 기준으로 정렬하여 메인 쿼리에 전달할 수 있습니다

-- #7203) 연습
-- t_emp2 테이블 :
-- 직급별로 해당직급에서 최대 연봉을 받는 직원의
-- 이름과 직급, 연봉을 출력하세요,
-- 단, 연봉순으로 오름차순 정렬하세요

select * from t_emp2;

select post, max(pay) from t_emp2 group by post;

select name 사원명, post 직급, pay 연봉 from t_emp2
where (post, pay) in (select post, max(pay) from t_emp2 group by post)
and post is not null
order by pay;

-- --------------------------------------------
-- 4. 상호연관 Sub Query
-- Main Query 값을 Sub Query 에 주고
-- Sub Query를 수행한 후 그 결과를 다시
-- Main Query 로 반환해서 수행하는 쿼리.

-- #7205) 연습
-- t_emp2 테이블 :
-- 직원들 중에서 자신의 직급의 평균연봉과
-- 같거나 많이 받는 사람들의
-- 이름과 직급, 현재 연봉을 출력하세요.

-- ** 오라클과 달리 MySQL 은 '' 를 null 로 간주하지 않는다.

-- 직급이 없는 경우 '' 로 처리 null 로 간주 안함
-- 상호연관 서브쿼리
select a.name 사원이름, ifnull(a.post, '') 직급, a.pay 급여
from t_emp2 a
where a.pay >= -- (a 테이블의 사원 직급의 평균 연봉)
(select avg(b.pay) from t_emp2 b where ifnull(a.post, '') = ifnull(b.post, ''));
-- 비교할 대상이 자기 자신밖에 없어서 자가조인 형식으로 별명만 다르게 해서 한듯

-- -------------------------
-- 스칼라 서브쿼리

select
    (select 10), (select 20), (select 30);

-- 부서의 이름을 내보내기
select e.name 사원이름, (select d.dname from t_dept2 d where e.deptno = d.dcode) 부서이름
from t_emp2 e;

-- JOIN 과 같은 결과 나옴.  그러나 데이터 양이 적은 경우는 스칼라서브쿼리 방식이 Join 보다 나은 성능을 보여줌

--  t_student, t_department 테이블 사용
-- 학생이름, 아이디, 학년, 제1전공 이름, 제2전공 이름이 나오게 하세요 (
-- 출력되게 하세요
-- 이때 제2전공이 null 인 경우는 empty 문자열로 출력되게 하세요.

-- 상호연관 서브쿼리
select * from t_student;
select * from t_department;
select s.name, s.id, s.grade,
ifnull((select d1.dname from t_department d1 where  s.deptno1 = d1.deptno), '') 제1전공이름,
ifnull((select d2.dname from t_department d2 where s.deptno2  = d2.deptno), '') 제2전공이름
from t_student s;

-- select 문은 각 학생의 정보를 출력
-- ifnull() 함수를 사용하여 제1전공과 제2전공이 null 일 경우를 처리
-- 제1전공과 제2전공이 null 이 아닌 경우에는 해당하는 학과의 이름을 가져오고, null 인 경우에는 빈 문자열('')을 반환
-- 서브쿼리는 각 학생마다 실행, 외부 쿼리의 결과에 따라 실행,
-- 각 서브쿼리는 해당 학생의 제1전공 또는 제2전공에 해당하는 학과의 이름을 가져옴

