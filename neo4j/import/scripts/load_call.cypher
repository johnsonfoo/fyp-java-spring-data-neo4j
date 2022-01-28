// Load call.facts
// Call(caller: MethodFQN, callee: MethodFQN, version: Version)

LOAD CSV FROM 'file:///datalog/call.facts' AS row
FIELDTERMINATOR '\t'
MERGE (f:FQN {name:row[0]})
SET f:MethodFQN;

LOAD CSV FROM 'file:///datalog/call.facts' AS row
FIELDTERMINATOR '\t'
MERGE (f:FQN {name:row[1]})
SET f:MethodFQN;

LOAD CSV FROM 'file:///datalog/call.facts' AS row
FIELDTERMINATOR '\t'
MATCH (m1:MethodFQN {name: row[0]})
MATCH (m2:MethodFQN {name: row[1]})
MERGE (m1)-[:CALLS {version: row[2]}]->(m2);
