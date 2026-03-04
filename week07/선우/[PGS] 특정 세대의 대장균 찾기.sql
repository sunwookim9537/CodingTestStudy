WITH RECURSIVE tree AS (

    -- 1세대
    SELECT 
        id,
        parent_id,
        1 AS level
    FROM ecoli_data
    WHERE parent_id IS NULL

    UNION ALL

    -- 다음 세대
    SELECT
        e.id,
        e.parent_id,
        t.level + 1
    FROM ecoli_data e
    JOIN tree t
        ON e.parent_id = t.id
    where t.level < 3
)

SELECT id
FROM tree
WHERE level = 3;