// Load is_class.facts
// IsClass(fqn: ClassFQN, isAbstract: Boolean, superClass: ClassFQN, isNested: Boolean, outer: ClassFQN, isTestClass: Boolean, version: Version)

LOAD CSV FROM 'file:///datalog/is_class.facts' AS row
FIELDTERMINATOR '\t'
MERGE (f:FQN {name:row[0]})
SET f:ClassFQN
SET (CASE WHEN f.isAbstract IS NULL THEN f END).isAbstract = False
SET (CASE WHEN f.isTest IS NULL THEN f END).isTest = False;
