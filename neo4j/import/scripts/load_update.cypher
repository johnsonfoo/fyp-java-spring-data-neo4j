// Load update.facts
// Update(fqn: FQN, pos: FQN, commit: Version, parent: Version)

LOAD CSV FROM 'file:///datalog/update.facts' AS row
FIELDTERMINATOR '\t'
MERGE (f:FQN {name:row[0]});

LOAD CSV FROM 'file:///datalog/update.facts' AS row
FIELDTERMINATOR '\t'
MERGE (f:FQN {name:row[1]});

LOAD CSV FROM 'file:///datalog/update.facts' AS row
FIELDTERMINATOR '\t'
MATCH (f1:FQN {name: row[0]})
MATCH (f2:FQN {name: row[1]})
MERGE (f2)-[:UPDATES {commit: row[2], parent: row[3]}]->(f1);
