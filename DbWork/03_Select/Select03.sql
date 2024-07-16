    select * from t_student;

-- 1 t_student 테이블에서 키(height)가 180 보다 크거나 같은 학생의 이름, 키 출력
    select name "이름", height "키" from t_student where height > 180 or height = 180;

-- 2 t_student 테이블에서 몸무게(weight)가 60~80 인 사람의 이름과 체중 출력
    select name "이름", weight "체중" from t_student where weight between 60 and 80;

-- 3 t_student 테이블에서는 제1전공(deptno1) 이 101번 학과학생과 201번 학과 학생들을 모두 출력하세요 (IN 연산자 활용)
    select * from t_student where deptno1 in (101, 201);

-- 4 t_student 테이블에서 성이 ‘김’ 씨인 사람 조회 (LIKE 연산자 사용)
    select * from t_student where name like '김%';

-- 5 t_student 테이블에서 4학년 학생중에 키 가 170cm 이상인 사람의 이름과 학년과 키를 조회하세요
    select name "이름", grade "학년", height "키" from t_student where height >= 170 and grade = 4;

-- 6 t_student 테이블에서 1학년이거나 또는 몸무게가 80kg 이상인 학생들의 이름과 키와 학년과 몸무게를 출력하세요
    select name "이름", height "키", grade "학년", weight "몸무게" from t_student where grade = 1 or weight >=80;

-- 7 t_student 테이블을 사용해서 2학년 중에서 키가 180cm 보다 크면서 몸무게가 70kg 보다 큰 학생들의 이름과 학년과 키와 몸무게를 출력하세요
    select name "이름", height "키", grade "학년", weight "몸무게" from t_student where grade = 2 and height > 180 and weight > 70;

-- 8 t_student 테이블: 2학년 학생중에서 키가 180cm보다 크거나 또는 몸무게가 70kg 보다 큰 학생들의 이름과 학년과 키와 몸무게를 출력하세요
    select name "이름", height "키", grade "학년", weight "몸무게" from t_student where grade in(2) and (height > 180 or weight > 70);

-- 9 t_emp 테이블에서 고용일(hiredate)가 1992년 이전인 사람들의 이름(ename) 과 고용일을 출력하세요
    select * from t_emp;
    select * from t_emp2;

    select ename "이름", hiredate "고용일" from t_emp where hiredate < '1992-01-01';

-- 10 t_student 테이블: 1학년 학생의 이름과 생일과 키와 몸무게를 출력하세요, 단 생일이 빠른 사람 순서대로 정렬하세요.
    select name "이름", birthday "생일", height "키", weight "몸무게" from t_student where grade = 1 order by birthday;

-- 11 t_student 테이블: 1학년 학생의 이름과 키를 출력하세요, 별명은 ‘이름’, ‘키’ 로 출력.  단, 이름은 오름차순으로 정렬하세요
    select name "이름", height "키" from t_student where grade = 1 order by name;

-- 12 t_emp2 직원 테이블에서 생일(birthday) 이 1980년대생인 사람들의 이름과 생일만 출력하세요- 즉 (1980/01/01 ~ 1989/12/31 사이 출생한 직원들)
    select name "이름", birthday "생일" from t_emp2 where birthday between '1980-01-01' and '1989-12-31';

    -- -----------------------------------------------------
-- WHERE 조건절에 1 = 1 으로 시작하면
-- 이후의 AND 조건들을 유연하게 작성할수 있다. (추가, 삭제 등이 용이)
    SELECT name, jumin FROM t_student
    WHERE
        1 = 1
      AND grade = 3
      AND deptno1 = 101
    ;


