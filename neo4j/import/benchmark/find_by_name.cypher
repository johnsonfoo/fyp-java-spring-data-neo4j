// Find the detail information of method

PROFILE
MATCH (m:MethodFQN)
WHERE m.name = "org.apache.commons.csv.TokenMatchersTest.testHasType()"
RETURN m;
