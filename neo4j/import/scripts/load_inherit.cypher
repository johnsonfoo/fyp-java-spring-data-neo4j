// Load inherit.facts
// Inherit(sub: ClassFQN, super: ClassFQN)

LOAD CSV FROM 'file:///datalog/inherit.facts' AS row
FIELDTERMINATOR '\t'
MERGE (f:FQN {name:row[0]})
SET f:ClassFQN
SET (CASE WHEN f.isAbstract IS NULL THEN f END).isAbstract = False
SET (CASE WHEN f.isTest IS NULL THEN f END).isTest = False;

LOAD CSV FROM 'file:///datalog/inherit.facts' AS row
FIELDTERMINATOR '\t'
MERGE (f:FQN {name:row[1]})
SET f:ClassFQN
SET (CASE WHEN f.isAbstract IS NULL THEN f END).isAbstract = False
SET (CASE WHEN f.isTest IS NULL THEN f END).isTest = False;

LOAD CSV FROM 'file:///datalog/inherit.facts' AS row
FIELDTERMINATOR '\t'
MATCH (c1:ClassFQN {name: row[0]})
MATCH (c2:ClassFQN {name: row[1]})
MERGE (c1)-[:INHERITS]->(c2);
