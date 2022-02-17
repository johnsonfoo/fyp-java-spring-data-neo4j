// Create Index

CREATE INDEX contains_rel_index_name FOR ()-[r:CONTAINS]-() ON (r.version);

CREATE INDEX references_rel_index_name FOR ()-[r:REFERENCES]-() ON (r.version);

CREATE INDEX inserts_rel_index_name FOR ()-[r:INSERTS]-() ON (r.commit, r.parent);

CREATE INDEX updates_rel_index_name FOR ()-[r:UPDATES]-() ON (r.commit, r.parent);

CREATE INDEX deletes_rel_index_name FOR ()-[r:DELETES]-() ON (r.commit, r.parent);

CREATE INDEX calls_rel_index_name FOR ()-[r:CALLS]-() ON (r.version);
