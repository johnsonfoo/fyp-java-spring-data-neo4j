// Find all callee of method

PROFILE
MATCH (m1:MethodFQN)-[r:CALLS]->(m2:MethodFQN)
WHERE m1.name = "org.apache.commons.csv.TokenMatchersTest.testHasType()"
RETURN m2;
