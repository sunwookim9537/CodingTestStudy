SELECT DISTINCT d.id, d.email, d.first_name, d.last_name
FROM developers d
JOIN skillcodes s
  ON d.skill_code & s.code != 0
WHERE s.category = 'Front End'
ORDER BY d.id ASC;