awk -F',' 'system("mv " "../datalog/" $1 " " "../datalog/" $2)' mapping.csv
