# Change the below variables only
n=10
input_file=$NEO4J_HOME/import/benchmark/find_at_least_n_callee.cypher

# Constants
output_directory=$NEO4J_HOME/import/benchmark/results/
output_file=$NEO4J_HOME/import/benchmark/results/benchmark.txt

# Creates output_directory if it does not exist
[ -d $output_directory ] || mkdir $output_directory

# Empties the output_file
>$output_file

# Performs the query defined in input_file for N times
# Each query execution time is appended to output_file
for ((i = 1; i <= n; i++)); do
  cat $input_file |
    bin/cypher-shell -u neo4j -p test --format plain |
    grep "Time: " | sed 's/^.*: //' |
    tee -a $output_file
done
