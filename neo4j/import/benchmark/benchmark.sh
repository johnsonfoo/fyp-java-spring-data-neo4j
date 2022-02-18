[ -d $NEO4J_HOME/import/benchmark/results/ ] || mkdir $NEO4J_HOME/import/benchmark/results/

cat $NEO4J_HOME/import/benchmark/benchmark.cypher |
  bin/cypher-shell -u neo4j -p test --format plain |
  tee $NEO4J_HOME/import/benchmark/results/benchmark.txt |
  grep "Time: "
