// Find method added in commit

PROFILE
MATCH (f1:FQN)-[r:INSERTS]->(m1:MethodFQN)
WHERE r.commit = "16b9e2c79122f5a76863854cc4b33939da63710d"
RETURN m1.name as name;
