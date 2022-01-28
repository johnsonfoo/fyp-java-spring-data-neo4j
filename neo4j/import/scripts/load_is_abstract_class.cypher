// Load is_abstract_class.facts
// IsAbstractClass(clazz: ClassFQN)

LOAD CSV FROM 'file:///datalog/is_abstract_class.facts' AS row
FIELDTERMINATOR '\t'
MERGE (f:FQN {name:row[0]})
SET f:ClassFQN
SET (CASE WHEN f.isAbstract IS NULL OR f.isAbstract = False THEN f END).isAbstract = True
SET (CASE WHEN f.isTest IS NULL THEN f END).isTest = False;
