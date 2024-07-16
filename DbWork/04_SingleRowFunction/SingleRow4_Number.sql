-- ROUND(), TRUNC(), CEIL(), FLOOR()

select '12.5'
     , round(12.5) "round"
     , truncate(12.5, 0) "truncate"
     , ceil(12.5) "ceil"
     , floor(12.5) "floor";

select '-12.5',
       round(-12.5) "round",
       truncate(-12.5, 0) "truncate",
       ceil(-12.5) "ceil",
       floor(-12.5) "floor"
;

