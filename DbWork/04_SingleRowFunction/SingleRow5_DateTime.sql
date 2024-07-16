select
    now() "오늘"
     , now() + 1 -- date 타입이 정수 변환한뒤 +1 산술연산
     , now() + 60 -- date 타입이 정수 변환한뒤 +60 산술연산 1분(60초) 중가한게 아님, 날짜시간연산 아님
     ;

-- 날짜 더하기, 빼기
-- DATE_ADD(date, INTERVAL 계산수 계산형식)
-- DATE_SUB(date, INTERVAL 계산수 계산형식)
-- 계산형식이란 월,일,시간 중 어떤걸 더할꺼냐를 선택하는 것이다.


SELECT
    now()
    , date_add(now(), interval 1 month) "한달뒤"
    , date_add(now(), interval 1 day) "내일"
    , date_add(now(), interval 2 day) "모레"
    , date_add(now(), interval -1 day) "어제"
    , date_add(now(), interval 1 hour) "한시간뒤"
;

select date_add('2021-02-21', interval 1 month); -- 매개변수가 문자열인 경우도 날짜연산됨 -> 리턴값은 문자열

-- 날짜 차이 계산
-- DATEDIFF(날짜1, 날짜2); : 일 차이
-- TIMESTAMPDIFF(단위, 날짜1, 날짜2); : 연, 분기, 월, 주, 일, 시, 분, 초  .. 차이


-- 단위
-- SECOND : 초
-- MINUTE : 분
-- HOUR : 시
-- DAY : 일
-- WEEK : 주
-- MONTH : 월
-- QUARTER : 분기
-- YEAR : 연

select now() "오늘", datediff(now(), '2024-03-26') "과정 시작한지"; -- 디폴트가 day 간격

select timestampdiff(second, '2021-07-20', now()) "초";
select timestampdiff(minute, '2021-07-20', now()) "분";
select timestampdiff(hour, '2021-07-20', now()) "시";
select timestampdiff(year, '2021-07-20', now()) "년";

-- t_professor 테이블에서 오늘(now())을 기준으로
-- 근속연수, 근속개월,  근속일를 계산해서 출력
-- 날짜양식은 YYYY-MM-DD

select * from t_professor;
select
    name 이름
     , date(now()) 오늘
     , hiredate 입사일
     , timestampdiff(year, hiredate, now()) 근속연수
     , timestampdiff(month , hiredate, now()) 근속개월
     , timestampdiff(day , hiredate, now()) 근속일
from t_professor;
