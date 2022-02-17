// Create Constraint

CREATE CONSTRAINT unique_fqn_name IF NOT exists FOR (f:FQN) REQUIRE f.name IS UNIQUE;

CREATE CONSTRAINT unique_class_fqn_name IF NOT exists FOR (c:ClassFQN) REQUIRE c.name IS UNIQUE;

CREATE CONSTRAINT unique_method_fqn_name IF NOT exists FOR (m:MethodFQN) REQUIRE m.name IS UNIQUE;
