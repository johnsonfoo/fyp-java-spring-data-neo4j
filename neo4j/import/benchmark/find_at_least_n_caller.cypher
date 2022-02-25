// Find method with at least 10 callers

PROFILE
MATCH (m1:MethodFQN)-[r:CALLS]->(m2:MethodFQN)
WITH m2, count(r) as rel_cnt
WHERE rel_cnt >= 10
RETURN m2.name as name, rel_cnt;
