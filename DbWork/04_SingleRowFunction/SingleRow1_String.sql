-- lower(), upper()

select 'Hello', lower('Hello'), upper('Hello');

-- t_student 테이블 : 1전공(deptno1) 이 201번인 학생들의
-- ID를 이름과 함께 소문자, 대문자로 출력 / upper() 사용
select name, id, upper(id) 대문자, lower(id) 소문자 from t_student where deptno1 = 201;

-- length(), char_length()
select length('Hello'), length('java'), length('뽀로로'); -- byte 단위 개수

select char_length('Hello'), char_length('뽀로로'); -- 글자 개수

-- t_student 테이블 :
-- ID가 9글자 이상인 학생들의
-- 이름과 ID 와 글자수 출력 / length() 사용

select name, id, length(id) 글자수 from t_student where length(id) >= 9;
-- 단일 행 함수는 where 조건절에서 사용가능

-- -------------------------------------------
-- SUBSTR 함수
-- 구문: SUBSTR( '문자열' 또는 컬럼명,   시작위치,  추출할 글자수 )
-- 문자열에서 특정 길이의 문자를 추출할 때 사용하는 함수
-- 시작위치, 음수 가능.
-- ★ 시작 인덱스가 1부터 시작한다 (인덱스는 1부터 시작)

select substr('ABCDE', 2, 3);
-- 2번째 문자부터 3개의 문자를 뽑아냄

select substr('ABCDE', 2);
-- 2번째 문자부터 끝까지

select substr('ABCDE', 20, 2); -- empty 문자열 null, error 아님

select substr('ABCDE', -2, 2);
-- 오른쪽에서 부터 뽑아냄(음수 인덱싱 가능)

-- t_student 테이블 : jumin 칼럼을 사용해서
-- 1전공(deptno1)이 101번인 학생의 이름과 생년월일 출력 / substr() 사용
select * from t_student;

select name, birthday, substr(jumin, 1, 6) from t_student where deptno1 = 101;

--  t_student 테이블 : jumin 칼럼을 사용해서
-- 태어난 달이 8월인 사람의 이름과 생년월일을 출력하세요 / substr() 사용
select name, birthday, substr(jumin, 1, 6) from t_student where substr(jumin, 3, 2) = '08';


-- t_student 테이블 : 4학년 학생들중 ‘여학생’ 들의 이름과 주민번호 출력 / substr() 사용
select name, jumin from t_student where substr(jumin, 7, 1) = '2' and grade = 4;

-- -----------------------------------------------
-- INSTR()
-- 주어진 문자열이나 컬럼에서 특정 글자의 위치를 찾아주는 함수 (인덱스 리턴)
select instr('ABCDEFG', 'D'); -- 4
select instr('ABCDEFG', 'EF'); -- 5
select instr('ABCDEFG', 'EFX'); -- 0 못찾으면 0 리턴

-- t_student 테이블 : tel 칼럼을 사용하여
-- 101번 학과(deptno1) 의 학생의 이름과 전화번호, ‘)’ 가 나오는 위치 출력  / instr() 사용
select name, tel, instr(tel, ')') from t_student where deptno1 = 101;

-- t_student 테이블 : 1전공이 101 인 학생의 이름과 전화번호, 지역번호를 출력하세요.
-- 지역번호는 숫자만!  / substr(), instr() 사용
select name, tel, substr(tel, 1, instr(tel, ')') -1) 지역번호 from t_student;

-- ltrim(), rtrim(), trim()
select '   abcd   ', ltrim('   abcd   ') ltrim, rtrim('   abcd   ') rtrim, trim('   abcd   ') trim;






