-- 코드를 작성해주세요
WITH RECURSIVE gene AS(
    SELECT ID, PARENT_ID, 1 AS GENERATION
    FROM ecoli_data
    where parent_id is null
    
    UNION ALL
    
    SELECT e.id, e.parent_id, g.GENERATION+1
    FROM ecoli_data e
    JOIN gene g 
    ON e.parent_id=g.id
)

SELECT COUNT(*) AS COUNT,GENERATION
FROM gene
WHERE ID NOT IN (
    SELECT PARENT_ID
    FROM ecoli_data
    WHERE parent_id IS NOT NULL
    
    )
GROUP BY GENERATION
order by GENERATION