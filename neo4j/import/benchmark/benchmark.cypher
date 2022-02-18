// Run some benchmark queries

// Find FQN node with name org.apache.commons.csv.TokenMatchersTest.testHasType()
PROFILE
MATCH (f:FQN)
WHERE f.name = "org.apache.commons.csv.TokenMatchersTest.testHasType()"
RETURN f;

// Find all nodes that org.apache.commons.csv.TokenMatchersTest.testHasType() is connected to
PROFILE
MATCH (f1:FQN)-[r]->(f2:FQN)
WHERE f1.name = "org.apache.commons.csv.TokenMatchersTest.testHasType()"
RETURN f2;

// Find all Inserts relationships that have commit version 16b9e2c79122f5a76863854cc4b33939da63710d
PROFILE
MATCH (f1:FQN)-[r:INSERTS]->(f2:FQN)
WHERE r.commit = "16b9e2c79122f5a76863854cc4b33939da63710d"
RETURN r;

// Find all FQN nodes which have more than 10 incoming relationships
PROFILE
MATCH (f1:FQN)-[r]->(f2:FQN)
WITH f2, count(r) as rel_cnt
WHERE rel_cnt > 10
RETURN f2;

// Find all FQN nodes which have more than 10 outgoing relationships
PROFILE
MATCH (f1:FQN)-[r]->(f2:FQN)
WITH f1, count(r) as rel_cnt
WHERE rel_cnt > 10
RETURN f1;
