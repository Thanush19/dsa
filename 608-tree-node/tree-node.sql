# Write your MySQL query statement below
# Write your MySQL query statement below

SELECT 
    DISTINCT t.id,
    IF(t.p_id IS NULL, 'Root', IF(t.id = p.p_id, 'Inner', 'Leaf')) AS type
FROM 
    Tree t
LEFT JOIN 
    Tree p ON t.id = p.p_id;