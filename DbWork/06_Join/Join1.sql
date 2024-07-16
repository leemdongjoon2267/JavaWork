-- form 절의 테이블에도 별칭(alias)을 줄수 있다
-- 20 레코드
select s.studno, s.name, s.deptno1 from t_student s;

-- 12 레코드
select d.deptno, d.dname from t_department d;

-- 카티션곱 (Cartesian Product)
-- 두개의 테이블을 JOIN 하게 되면,
-- 각 테이블의 레코드들의 모든 조합이 출력된다.
-- WHERE 나 ON 등으로 JOIN 조건이 주어지지 않으면
-- 모든 카티션곱이 출력된다.


-- 20 x 12 = 240 레코드
select s.studno, s.name, s.deptno1, d.deptno, d.dname from t_student s, t_department d;

-- 위의 카티션 곱에서 '조건'을 주면 원하는 레코드만 select 가능

-- ---------------------------------------------------------------------------------
-- Equi Join (등가 Join)
-- 일반적으로 많이 쓰이는 Join 이며, 양쪽 테이블 Join 한 카티션곱에서 ‘같은조건’이 존재할 경우만 값을 가져오는 것

-- 예) #6101
-- t_student 테이블과 t_department 테이블을 사용하여 학생이름, 1전공 학과번호, 1전공 학과 이름을 출력하세요

-- MySQL 구문
select s.studno, s.name, d.dname from t_student s, t_department d
where s.deptno1 = d.deptno; -- join 조건

-- ansi SQl 구문

select s.studno, s.name, d.dname from t_student s
    join t_department d on s.deptno1 = d.deptno; -- join 조건

-- 제 2전공은
-- null 값은 join 조건에 참여 안함
select s.name 학생이름, s.deptno2 제2학과번호, d.dname 학과이름
    from t_student s, t_department d where s.deptno2 = d.deptno;

-- 연습 #6102)
-- t_student 테이블, t_professor 테이블 을 join하여
-- ‘학생이름’, ‘지도교수번호’, ‘지도교수이름’ 을 출력하세요

select * from t_student;
select * from t_professor;

-- MySQL 구문
select s.name 학생이름, s.profno 지도교수, p.name 지도교수이름
    from t_student s, t_professor p where s.profno = p.profno;

-- ANSI 구문
select s.name 학생이름, s.profno 지도교수, p.name 지도교수이름
from t_student s join t_professor p on s.profno = p.profno;

-- 3개 테이블 join
-- t_student, t_department, t_professor 테이블 을 join 하여
-- 학생의 이름, 학과이름, 지도교수 이름  을 출력하세요

select s.name 학생이름, d.dname 학과이름, p.name 교수이름 from t_student s, t_department d, t_professor p
where s.deptno1 = d.deptno and s.profno = p.profno;

select s.name 학생이름, d.dname 학과이름, p.name 교수이름 -- ,profno <-- 별명 없이 사용하면 에러
from t_student s join t_department d on s.deptno1 = d.deptno join t_professor p
on  s.profno = p.profno;

-- 조금 다르게
-- select s.name 학생이름, d.dname 학과이름, p.name 교수이름
-- from (t_student s join t_department d) join t_professor p
-- on s.deptno1 = d.deptno and s.profno = p.profno;

select * from t_emp2;
select * from t_post;

-- t_emp2 직원 테이블과 t_post 직급 테이블을 조회하여
-- 사원의 이름과 직급, 현재연봉, 해당직급의 연봉의 하한금액(s_pay)과 상한금액(e_pay)을 출력하세요
select e.name 사원이름, e.post 직급, e.pay 현재연봉, p.s_pay 연봉의하한금액, p.e_pay 연봉의상한금액
from t_emp2 e, t_post p where e.post = p.post;

select e.name 사원이름, e.post 직급, e.pay 현재연봉, p.s_pay 연봉의하한금액, p.e_pay 연봉의상한금액
from t_emp2 e join t_post p on e.post = p.post;

-- MySQL 구문
select s.name 학생이름, s.profno 지도교수, p.name 지도교수이름
from t_student s, t_professor p where s.profno = p.profno and -- join 조건 카티션곱에서 걸러내기
                                      s.deptno1 = 101; -- 검색 조건 카티션 곱 만들기 전에 걸러내기
-- 단! 위 join 조건 보다 검색조건을 먼저 수행하게 된다.
-- 일반적으로 DB 내부에선 JOIN 조건보다 검색조건을 먼저 수행 -> 카티션곱 부하를 줄이기 위해


-- ANSI 구문
select s.name 학생이름, s.profno 지도교수, p.name 지도교수이름
from t_student s join t_professor p on s.profno = p.profno and s.deptno1 = 101;
-- where 절을 만들어도 됨

