cat $NEO4J_HOME/import/benchmark/benchmark.cypher |
  bin/cypher-shell -u neo4j -p test --format plain >$NEO4J_HOME/import/benchmark/results/benchmark.txt
