-- 참조: https://dev.mysql.com/doc/refman/8.0/en/type-conversion.html
-- 묵시적 자동 형변환 예

-- MySQL 은 필요시 string -> number, 혹은 number -> string 으로 묵시적 형변환 수행

select 1 + 1;
select 1 + '1'; -- 2
select '2' + 2; -- 4
select concat(1, '1'); -- 문자열 '11' 나옴

-- 실제로는 아래와 같이 동작
select 1 + cast('1' as signed); -- 함수 호출 발생 결과 : 2

-- 묵시적 형변환은 편한것 같지만,
-- 튜닝에서 뜻하지 않은 성능저하를 가져올수 있다.

-- 명시적 형변환
-- CAST(expr AS type)
-- CONVERT(expr, type)

select 38.8, cast(38.3 as char); -- 문자 타입으로 변환

-- BINARY[(N)]
-- CHAR[(N)] [charset_info]
-- DATE
-- DATETIME
-- DECIMAL[(M[,D])]
-- JSON
-- NCHAR[(N)]
-- SIGNED [INTEGER]
-- TIME
-- UNSIGNED [INTEGER]

-- 시간 => signed(숫자타입)
select cast(now() as signed);
select convert(now(), signed);

-- 숫자 -> 날짜 타입
select cast(20210801 as date);
select convert(20240419, date);

-- 숫자 -> 문자 타입
select cast(123456789 as char);
select convert(12345678910, char);

-- 날짜 -> 원하는 값을 '숫자' 로 리턴
select now(), year(now()), month(now()), day(now()),
       weekday(now()); -- 요일
-- 0 = Monday, 1 = Tuesday,..... 6 = Sunday

-- ################################################
-- 날짜 --> 원하는 포맷의 문자로 리턴
-- DATE_FORMAT() 함수
-- https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html

select date_format(now(), '%Y%m%d');
select date_format(now(), '%Y-%m-%d %H:%i:%s');
select date_format(now(), '%Y년%m월%d일 %H시%i분%s초');

select * from t_student;

-- t_student 테이블의 생일(birthday) 이 3월인 학생의 이름(name) 과 생일(birthday) 를  다음과 같은 형식으로 출력하세요
select name "이름", date_format(birthday, '%Y-%m-%d') "생일" from t_student where  month(birthday) = 3;

-- ################################################
-- format() 함수
-- 숫자 를 포맷팅하여 문자로 리턴
-- FORMAT(number, decimal_places)


-- 참조: https://www.w3schools.com/sql/func_mysql_format.asp


-- 숫자 세자리마다 콤마 찍기

select 1234567, format(1234567, 0);

select format(250500.5634, 0); -- 소수점 없이
select format(250500.5634, 2); -- 소수점 두자리수

-- t_professor 테이블에서 101번 학과 교수들의 이름(name), 연봉(pay) 를 출력하세요,
-- 단, 연봉은 (pay * 12) + bonus로 계산하고 천단위 구분기호로 표시하세요.

select name, format(((pay* 12) + ifnull(bonus, 0)), 0) 연봉 from t_professor where deptno = 101;

-- t_professor 테이블에서 2000년 이전에 입사한 교수명과 입사일,
-- 현재 연봉과 10% 인상 후 연봉을 아래와 같은 양식으로 출력하세요.
-- 연봉은 보너스(bonus)를 제외한 pay * 12 로 계산하고
-- 연봉과 인상후 연봉은 천단위 구분 기호를 추가하여 출력하세요

select * from t_professor;

select name, hiredate, format(pay * 12, 0) 연봉, format(1.1 * (pay* 12),  0) 인상후 from t_professor where year(hiredate) < 2000;
