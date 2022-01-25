package com.ntu.fyp.sdn6.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * This class represents the INSERTS relationship. A INSERTS relationship is a directed edge from a
 * Fqn node to a Fqn node with properties commit, parent.
 */
@RelationshipProperties
public class Inserts {

  @Id
  @GeneratedValue
  private Long id;

  @TargetNode
  private final Fqn insertedFqn;

  private final String commit;

  private final String parent;

  public Inserts(Fqn insertedFqn, String commit, String parent) {
    this.insertedFqn = insertedFqn;
    this.commit = commit;
    this.parent = parent;
  }

  public String getCommit() {
    return commit;
  }

  public String getParent() {
    return parent;
  }

  public Fqn getInsertedFqn() {
    return insertedFqn;
  }
}
