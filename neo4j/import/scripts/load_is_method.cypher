// Load is_method.facts
// IsMethod(fqn: MethodFQN, name: String, version: Version)

LOAD CSV FROM 'file:///datalog/is_method.facts' AS row
FIELDTERMINATOR '\t'
MERGE (f:FQN {name:row[0]})
SET f:MethodFQN;
