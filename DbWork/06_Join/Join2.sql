-- 비등가 조인 (Non-Equi Join)


-- #6201)
-- t_customer 테이블, t_gift 테이블을 join 하여
-- 고객의 마일리지 포인트별로 받을수 있는 상품을 조회하여
-- 고객의 '이름(c_name)'과 포인트(c_point) 상품명(g_name)을 출력하세요
-- BETWEEN ~ AND ~ 사용


SELECT * FROM t_customer; -- 일단 함 보자
SELECT * FROM t_gift;

-- MySQL 구문
select c.c_name 이름, c.c_point 포인트, g.g_name 상품명
from t_customer c, t_gift g where c.c_point between g.g_start and g.g_end;

-- ANSI SQL 구문
select c.c_name 이름, c.c_point 포인트, g.g_name 상품명
from t_customer c join t_gift g on c.c_point between g.g_start and g.g_end;


-- 앞 예제에서 조회한 상품의
-- 이름(g_name)과  필요수량이 몇개인지
-- 조회하세요

-- MySQL 구문
select g.g_name 상품명, count(*) 필요수량
from t_customer c, t_gift g where c.c_point between g.g_start and g.g_end
group by g.g_name;

-- ANSI SQL 구문
select g.g_name 상품명, count(*) 필요수량
from t_customer c join t_gift g on c.c_point between g.g_start and g.g_end
group by g.g_name;


-- #6203) 연습
-- t_student 테이블과 t_exam01 시험성적 테이블, t_credit 학점 테이블을 조회하여
-- 학생들의 이름과 점수와 학점을 출력하세요

select * from t_student;
SELECT * FROM t_exam01;  -- 일단 함 보자
SELECT * FROM t_credit;

select s.name 이름, e.total 점수, c.grade 학점 from t_student s, t_exam01 e,
t_credit c where s.studno = e.studno and e.total between c.min_point and c.max_point;


select s.name 이름, e.total 점수, c.grade 학점 from t_student s join t_exam01 e on s.studno = e.studno
join t_credit c on e.total between c.min_point and c.max_point;


-- t_customer 와 t_gift 테이블 join : 자기 포인트(c_point) 보다 낮은 포인트의 상품 중 한가지를 선택할수 있다고 할때
-- '산악용자전거'를 선택할 수 있는 고객명(c_name)과 포인트(c_point), 상품명(g_name)을 출력하세요

select * from t_customer;
select * from t_gift;

select c.c_name 고객명 , c.c_point 포인트, g.g_name 상품명 from t_customer c, t_gift g
where  g.g_name = '산악용자전거' and c.c_point between g.g_start and g.g_end ;

select c.c_name 고객명 , c.c_point 포인트, g.g_name 상품명 from t_customer c join t_gift g
on  g.g_name = '산악용자전거' and c.c_point between g.g_start and g.g_end;

--  #6204) 연습
-- t_customer 와 t_gift 테이블 join :
-- 자기 포인트(c_point) 보다 낮은 포인트의 상품 중
-- 한가지를 선택할수 있다고 할때
-- '산악용자전거'를 선택할 수 있는
-- 고객명(c_name)과 포인트(c_point),
-- 상품명(g_name)을 출력하세요


select
    c.c_name "고객명",
    c.c_point "POINT",
    g.g_name "상품명"
from
    t_customer c, t_gift g
where g.g_start <= c.c_point and g.g_name = '산악용자전거';


select
    c.c_name "고객명",
    c.c_point "POINT",
    g.g_name "상품명"
from
    t_customer c join t_gift g
                      on g.g_start <= c.c_point and g.g_name = '산악용자전거';

-- t_emp2, t_post 테이블 사용하여
-- 사원들의 이름(name)과 나이, 현재직급(post),  ‘예상직급’을 출력하세요.
-- ‘예상직급’은 나이로 계산하며 해당 나이가 받아야 하는 직급을 의미합니다.
-- 나이는 오늘(now())을 기준으로 하되 소수점 이하는 절삭하여 계산하세요
-- (t_emp2 의 직급(post) 은 null 허용함에 주의)

-- 나이계산은 어떻게?  :  (현재연도 - 생년월일연도) + 1,
select * from t_emp2;
select * from t_post;

select e.name 이름, year(now()) - year(e.birthday) + 1 현재나이, ifnull(e.post, '') 현재직급, p.post 예상직급
from t_emp2 e, t_post p
where year(now()) - year(e.birthday) + 1 between p.s_age and p.e_age;

select e.name 이름, year(now()) - year(e.birthday) + 1 현재나이, ifnull(e.post, '') 현재직급, p.post 예상직급
from t_emp2 e join t_post p on year(now()) - year(e.birthday) + 1 between p.s_age and p.e_age;

-- -------------------------------------------------------
-- 지금까지의 JOIN 은 모두 INNER JOIN 이다.


SELECT s.name, p.name
FROM t_student s, t_professor p
WHERE s.profno  = p.PROFNO;


SELECT s.name, p.name
FROM t_student s INNER JOIN t_professor p  -- 사실은 이게 INNER JOIN . (INNER 는 보통 생략함)
                            ON s.profno  = p.PROFNO;


SELECT s.name, p.name
FROM t_student s, t_professor p; -- 카티션곱, cross join

SELECT s.name, p.name
FROM t_student s CROSS JOIN t_professor p;

-- --------------------------------
-- OUTER JOIN


-- #6206)
-- t_student 테이블과 t_professor 테이블 Join :
-- 학생이름과 지도교수 이름을 출력하세요.
-- 단! 지도교수가 결정되지 않은 학생의 명단도 함께 출력하세요

select * from t_student;
select * from t_professor;
SELECT s.name, p.name
FROM t_student s left outer JOIN t_professor p
                                 ON s.profno  = p.profno;
-- 모든 학생 레코드를 결과에 포함시키기 위해서 left join

-- #6207)
-- t_student, t_professor 테이블 join :
-- 학생이름과 지도교수 이름을 출력,
-- 단! 지도 학생이 결정되지 않은 교수 명단도 출력

select * from t_student;
select * from t_professor;

SELECT s.name, p.name
FROM t_student s right outer JOIN t_professor p
                                  ON s.profno  = p.profno;
-- 모든 교수 레코드를 결과에 포함시키기 위해서 right join

-- #6208)
-- t_student, t_professor 테이블 join :
-- 학생이름과 지도교수 이름을 출력,
-- 단! 지도 학생이 결정되지 않은 교수 명단,
-- 지도교수가 결정되지 않은 학생명단 모두 출력

SELECT s.name "학생이름", p.name "교수이름"
FROM t_student s FULL OUTER JOIN t_professor p   -- MySQL 은 FULL OUTER 를 지원하지 않는다
ON s.profno = p.profno
;

-- 대신에 UNION 을 사용하여 full outer 를 구현 가능.
SELECT s.name "학생이름", p.name "교수이름"
FROM t_student s LEFT JOIN t_professor p   -- ※MySQL 은 LEFT JOIN 이라 해도 된다
                           ON s.profno = p.profno
union

SELECT s.name "학생이름", p.name "교수이름"
FROM t_student s RIGHT JOIN t_professor p
                            ON s.profno = p.profno
;


-- ----------------------------------------------
-- self join


-- #6209)
-- t_dept2 테이블에서
-- 부서명 과 그 부서의 상위부서명을 출력하세요

select * from t_dept2;

select d1.dname 부서명, d2.dname 상위부서명
from t_dept2 d1, t_dept2 d2
where d1.pdept = d2.dcode -- d1 의 상위부서 번호가 d2 의 부서 번호랑 같아야함
order by 1;



-- #6210)
-- t_professor 테이블 : 교수번호, 교수이름, 입사일,
-- 그리고 자신보다 입사일 빠른 사람의 인원수를 출력하세요,
-- 단 자신보다 입사일이 빠른 사람수를 오름차순으로 출력하세요
-- hint: left outer 사용
--         / 그룹함수 사용


-- left outer 를 사용하는 이유는 '조인형' 교수 때문.
-- 조인형 교수보다 먼저 입사한 사람이 없기 때문에 일반 join으론 하면 조인형 교수가 join 에서 빠져버린다.


select * from t_professor order by  hiredate ;
select p1.profno 교수번호, p1.name 교수이름, p1.hiredate 입사일, count(p2.profno) 입사일빠른사람
from t_professor p1 left outer join t_professor p2 on p1.hiredate > p2.hiredate
group by p1.profno, p1.name, p1.hiredate
order by 입사일빠른사람;







