// Find method with at least 10 callees

PROFILE
MATCH (m1:MethodFQN)-[r:CALLS]->(m2:MethodFQN)
WITH m1, count(r) as rel_cnt
WHERE rel_cnt >= 10
RETURN m1.name as name, rel_cnt;
