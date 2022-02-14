# Optimizing Query Execution in Large Differential Factbase

## Final Year Project Summary

Differential factbase is a uniform exchangeable representation supporting efficient querying and
manipulation, based on the existing concept of program facts. Such factbase is used to store
relevant information of software changes.

The existing factbase is not designed to scale.

Our plan in this project is to adopt graph database for efficient storage. The querying engine also
needs to be optimized so that the overall performance is significantly improved.

## Datalog Data

The existing factbase facts are stored in datalog. The facts schema in datalog declarations are as
follows:

```datalog
.decl IsMethod(fqn: MethodFQN, name: String, version: Version)

.decl Call(caller: MethodFQN, callee: MethodFQN, version: Version)

.decl IsClass(fqn: ClassFQN, isAbstract: Boolean, superClass: ClassFQN,
isNested: Boolean, outer: ClassFQN, isTestClass: Boolean, version: Version)

.decl Contain(er: FQN, ee: FQN, version: Version)

.decl Ref(er: FQN, ee: FQN, version: Version)

.decl Update(fqn: FQN, pos: FQN, commit: Version, parent: Version)

.decl Insert(fqn: FQN, pos: FQN, commit: Version, parent: Version)

.decl Delete(fqn: FQN, pos: FQN, commit: Version, parent: Version)

.decl IsTestClass(clazz: ClassFQN)

.decl IsAbstractClass(clazz: ClassFQN)

.decl Inherit(sub: ClassFQN, super: ClassFQN)
```

Each of the `.decl` line defines a predicate, where the parameters and corresponding types are
enclosed within the pair of parenthesis. For each predicate defined, there is a TAB-seperated CSV
file containing instances of those predicates.

One line in `Call.facts` is:

```
org.apache.commons.csv.CSVParser.1.next()    org.apache.commons.csv.CSVParser.isClosed()    7310e5
```

and the interpretation of this line is that the method `org.apache.commons.csv.CSVParser.1.next()`
calls `org.apache.commons.csv.CSVParser.isClosed()` in the version `7310e5`

## Graph Modeling

A graph database can have more flexibilities than the current facts schema in datalog.

In graph terminology, we can describe `org.apache.commons.csv.CSVParser.1.next()`
and `org.apache.commons.csv.CSVParser.isClosed()` as two distinct nodes. Then, the `Call`
relationship can be described as a directed edge between the two nodes. In addition, the
parameter `Version` on the relationship can be described as a property of the directed edge.

To model the current facts schema as a graph, we first define three different types of nodes (`FQN`
, `ClassFQN`, `MethodFQN`) where `ClassFQN` and `MethodFQN` both extend `FQN`. Each type of node will
have its own corresponding attributes and each predicate will be a directed edge between two nodes.

The resulting graph model is:

[FQN]: https://user-images.githubusercontent.com/37036242/153893961-b42dd961-4579-4163-9c03-dcf87ddc0a22.png

[ClassFQN]: https://user-images.githubusercontent.com/37036242/153893928-a8d375f7-f38b-459c-9326-8e4160340e5f.png

[MethodFQN]: https://user-images.githubusercontent.com/37036242/153893923-3944d229-db51-4cc7-93cb-a2dfc9b2cd4f.png

| FQN         | ClassFQN              | MethodFQN               |
|-------------|-----------------------|-------------------------|
| ![FQN][FQN] | ![ClassFQN][ClassFQN] | ![MethodFQN][MethodFQN] |

## Architecture

![Alt text](https://user-images.githubusercontent.com/37036242/151647266-24412612-7f2a-4013-9468-0a0faca55010.png?raw=true "Title")

Summary of the folder corresponding to each tier from picture above:

| Tier    | Folder               | Description                                                                            |
|---------|----------------------|----------------------------------------------------------------------------------------|
| Client  |                      | DIFFBASE application                                                                   |
| Server  | [Spring Boot](./src) | Spring Boot application using Spring Data Neo4j framework for accessing Neo4j database |
| Storage | [Neo4j](./neo4j)     | Neo4j configuration, datalog and cypher files                                          |

## Getting Started

### Setup Neo4j Database

See the [Docker & Neo4j official guide](https://neo4j.com/developer/docker-run-neo4j/) for more
detailed explanations.

1. Set up a Docker container hosting the Neo4j database by running the following commands while in
   the directory `fyp-java-spring-data-neo4j`:

```shell
docker run \
--name neo4j_container \
-p7474:7474 -p7687:7687 \
-d \
-v $PWD/neo4j/data:/data \
-v $PWD/neo4j/logs:/logs \
-v $PWD/neo4j/conf:/conf \
-v $PWD/neo4j/import:/var/lib/neo4j/import \
-v $PWD/neo4j/plugins:/plugins \
--env NEO4J_AUTH=neo4j/test \
--env NEO4JLABS_PLUGINS=\[\"apoc\"\] \
neo4j:4.4.3-community
```

2. Place datalog files into the folder under path `fyp-java-spring-data-neo4j/neo4j/import/datalog`.
3. Start the Docker container created in Step 1 by running the following command:

```shell
docker start neo4j_container
```

4. The Neo4j database can be accessed at `http://localhost:7474/browser/`. Please refresh the page
   if there is no response as the web server will take sometime to load.

### Importing datalog files into Neo4j Database

1. Access the Neo4j database at `http://localhost:7474/browser/`.
2. Before running any import commands, set a uniqueness constraint for nodes to have distinct names
   with the following command:

```cypher
CREATE CONSTRAINT unique_fqn_name IF NOT exists FOR (f:FQN) REQUIRE f.name IS UNIQUE
```

3. Import the datalog files with the provided scripts by running the following commands:

```cypher
CALL apoc.cypher.runFile('file:///scripts/load_call.cypher');
CALL apoc.cypher.runFile('file:///scripts/load_contain.cypher');
CALL apoc.cypher.runFile('file:///scripts/load_delete.cypher');
CALL apoc.cypher.runFile('file:///scripts/load_inherit.cypher');
CALL apoc.cypher.runFile('file:///scripts/load_insert.cypher');
CALL apoc.cypher.runFile('file:///scripts/load_is_abstract_class.cypher');
CALL apoc.cypher.runFile('file:///scripts/load_is_class.cypher');
CALL apoc.cypher.runFile('file:///scripts/load_is_method.cypher');
CALL apoc.cypher.runFile('file:///scripts/load_is_test_class.cypher');
CALL apoc.cypher.runFile('file:///scripts/load_reference.cypher');
CALL apoc.cypher.runFile('file:///scripts/load_update.cypher');
```

### Setup Spring Boot Application

1. Start the Spring Boot application by running the following command while in
   the directory `fyp-java-spring-data-neo4j`:

```shell
./mvnw spring-boot:run
```

2. The Spring Boot interactive documentation can be accessed at `http://localhost:8080/docs/`.

### REST API Overview

| Endpoint                                        | Description                                                          |
|-------------------------------------------------|----------------------------------------------------------------------|
| `/api/v0/fqns/search?name=NAME`                 | Find FQN node with name NAME                                         |
| `/api/v0/fqns/contains/search?name=NAME`        | Find all FQN nodes that Contains FQN node with name NAME             |
| `/api/v0/fqns/references/search?name=NAME`      | Find all FQN nodes that References FQN node with name NAME           |
| `/api/v0/fqns/inserts/search?name=NAME`         | Find all FQN nodes that Inserts FQN node with name NAME              |
| `/api/v0/fqns/updates/search?name=NAME`         | Find all FQN nodes that Updates FQN node with name NAME              |
| `/api/v0/fqns/deletes/search?name=NAME`         | Find all FQN nodes that Deletes FQN node with name NAME              |
| `/api/v0/class-fqns/inherits/search?name=NAME`  | Find all ClassFQN nodes that Inherits ClassFQN node with name NAME   |
| `/api/v0/method-fqns/inherits/search?name=NAME` | Find all MethodFQN nodes that Inherits MethodFQN node with name NAME |

## License Summary

All rights reserved.