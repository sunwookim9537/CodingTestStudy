-- 코드를 입력하세요
SELECT mcdp_cd,count(*)
FROM appointment
where apnt_ymd<'2022-06-01 00:00' and apnt_ymd>='2022-05-01 00:00'
group by mcdp_cd
order by count(*) asc, mcdp_cd  asc;