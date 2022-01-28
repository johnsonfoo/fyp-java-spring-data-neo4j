// Load contain.facts
// Contain (er: FQN, ee: FQN, version: Version)

LOAD CSV FROM 'file:///datalog/contain.facts' AS row
FIELDTERMINATOR '\t'
MERGE (f:FQN {name:row[0]});

LOAD CSV FROM 'file:///datalog/contain.facts' AS row
FIELDTERMINATOR '\t'
MERGE (f:FQN {name:row[1]});

LOAD CSV FROM 'file:///datalog/contain.facts' AS row
FIELDTERMINATOR '\t'
MATCH (f1:FQN {name: row[0]})
MATCH (f2:FQN {name: row[1]})
MERGE (f1)-[:CONTAINS {version: row[2]}]->(f2);
