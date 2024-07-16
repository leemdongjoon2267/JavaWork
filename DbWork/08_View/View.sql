-- View

show full tables in db326; -- table_type 까지 조회

-- #8101)
-- t_professor 테이블의 profno, name, email, hpage 칼럼만
-- 사용하는 view를 생성하세요 view 의 이름은 v_prof로 하세요

-- create or replace view 를 해서 오타낸거 수정 가능할듯? table 에서는 불가능
create or replace view v_prof
as
select profno, name, email, hpage from t_professor
;

-- view 동작 확인
select * from v_prof;

-- view 목록만 조회
show full tables in db326 where table_type like 'view';

-- view 생성시 별도의 컬림이름을 줄수도 있음
create or replace view v_prof(pfno, nm, em, hp)
as
select profno, name, email, hpage from t_professor
;

-- #8102)  예제
-- t_professor, t_department 테이블을 join 하여
-- 교수번호와 교수이름과 소속학과 이름을 조회하는 view 를 생성하세요.
-- (이름: v_prof_dept)

create or replace view c_prof_dept
as
SELECT p.profno "교수번호", p.name "교수명", d.dname "소속학과명"
FROM t_professor p, t_department d
WHERE p.deptno = d.deptno;

select * from c_prof_dept;

-- 인라인뷰
-- View 는 한번 만들어 놓으면 계속 사용할수 있습니다.
-- 그러나 1회용으로만 사용할 경우는 FROM 절의 서브쿼리 형태로 만들수 있습니다.
-- 이러한 뷰를 Inline View 라 합니다.


-- #8103) 예제
-- t_student, t_department 테이블 :
-- 학과별로 학생들의 최대키와 최대몸무게, 학과 이름을 출력하세요

-- 우선, 학과별 최대키, 최대몸무게

select d.dname 학과명, s.max_height 최대키, s.max_weight 최대몸무게
from
(SELECT deptno1, MAX(height) "max_height", MAX(weight) "max_weight"
FROM t_student
GROUP BY deptno1) s, t_department d
where s.deptno1 = d.deptno
;

-- #8104) 연습
-- t_student, t_department 테이블 :
-- 학과별로 가장 키가 큰 학생들의 이름과 키,
-- 학과이름을 인라인뷰 를 사용하여 다음과 같이 출력하세요

select * from t_student;

SELECT deptno1, MAX(height) max_height
FROM t_student
GROUP BY deptno1;

select d.dname 학과명, a.max_height 최대키, s.name 학생이름, s.height 키
from (select deptno1, max(height) max_height
      from t_student
      group by deptno1) a, t_student s, t_department d
where s.height = a.max_height and s.deptno1 = d.deptno and s.deptno1 = a.deptno1
;

-- #8105) 연습
-- t_student 테이블 :
-- 학생의 키가 동일 학년의 평균 키보다 큰 학생들의
-- 학년과 이름과 키, 해당 학년의 평균키를 출력하되,
-- inline view 를 사용해서 아래와 같이 출력하세요.
-- 단 학년 칼럼은 오름 차순으로 정렬.


SELECT grade, AVG(height) avg_height
FROM t_student
GROUP BY grade;


select s.grade, s.name, s.height, s.avg_height
from
(select grade, name, height,
        (select format(avg(height), 1) from t_student where grade = s.grade) avg_height
 from t_student s)s
where s.height > s.avg_height order by grade;

-- 선생님 방법
select s.grade 학년, s.name 이름, s.height 키, a.avg_height 평균키
from(select grade, format(avg(height), 1) avg_height
     from t_student
     group by grade) a, t_student s
    where a.grade = s.grade and s.height > a.avg_height
    order by 1;

-- t_student 테이블에서 각 학생의 학년, 이름, 키를 선택.
-- 각 학생의 학년별 평균 키를 서브쿼리로 계산
-- 내부 뷰에서 각 학생의 키와 해당 학년의 평균 키를 비교
-- 각 학생의 학년, 이름, 키, 해당 학년의 평균 키를 출력
-- 결과를 학년 기준으로 정렬
























