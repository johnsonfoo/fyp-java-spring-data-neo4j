// Load is_test_class.facts
// IsTestClass(clazz: ClassFQN)

LOAD CSV FROM 'file:///datalog/is_test_class.facts' AS row
FIELDTERMINATOR '\t'
MERGE (f:FQN {name:row[0]})
SET f:ClassFQN
SET (CASE WHEN f.isAbstract IS NULL THEN f END).isAbstract = False
SET (CASE WHEN f.isTest IS NULL OR f.isTest = False THEN f END).isTest = True;
