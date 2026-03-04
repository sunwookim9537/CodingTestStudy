-- DEVELOPERS 테이블에서 FRONTEND 스킬을 가진 개발자의 정보 조회 . 조건에 맞는 아이디, 이메일,이름 성을 조회하는 SQL문
-- 결과는 ID를 깆ㄴ으로 오름차순 정렬 ( 비 트 마 스 크 싫 어)

-- 스킬의 코드는 2진수로 표현했을 때 각 bit로 구분될 수 있도록 2의 제곱수로 구성되어 있습니다.

SELECT 
id
,email
,first_name
,last_name
FROM developers d JOIN skillcodes s
ON s.category= 'FRONT END'
WHERE (d.skill_code & s.code) != 0
ORDER BY id asc;