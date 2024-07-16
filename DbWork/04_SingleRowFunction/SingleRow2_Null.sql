select * from t_professor;

select name, pay, bonus, pay + bonus from t_professor;

-- IFNULL : NULL값을 만나면 다른 값으로 치환해서 출력하는 함수
-- ISNULL : NULL 인지 체크하는 함수  (null 이면 1, 아니면 0 리턴)
-- IF : 첫번째 인자는 '참/거짓' 판정하여 '참' 이면 두번째 값을, '거짓' 이면 세번째 값을 리턴
--      숫자타입의 경우 0 이면 '거짓', 0 이외의 수는 '참' 판정
--      null 이면 '거짓' 판정

select bonus, ifnull(bonus, 0), isnull(bonus), if(bonus, bonus, 0)from t_professor;
-- null 값은 '거짓' 판정

select name, pay, bonus, pay + ifnull(bonus, 0) from t_professor;

-- Professor 테이블 : 101번 학과 교수들의 이름(name), 급여(pay), 보너스(bonus ), 연봉(pay) 출력하기.
-- 연봉은 pay * 12 + bonus 로 계산,  bonus 가 없는 교수는 0 으로 계산
select name, pay, ifnull(bonus, 0) bonus,
       (pay * 12 + ifnull(bonus, 0)) 연봉 from t_professor where deptno = 101;