package com.ntu.fyp.sdn6.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * This class represents the INSERTS relationship. A INSERTS relationship is a directed edge from
 * a FQN node to a FQN node with properties commit, parent.
 */
@RelationshipProperties
public class Inserts {

  @Id
  @GeneratedValue
  private Long id;

  @TargetNode
  private final FQN insertedFQN;

  private final String commit;

  private final String parent;

  public Inserts(FQN insertedFQN, String commit, String parent) {
    this.insertedFQN = insertedFQN;
    this.commit = commit;
    this.parent = parent;
  }

  public String getCommit() {
    return commit;
  }

  public String getParent() {
    return parent;
  }

  public FQN getInsertedFQN() {
    return insertedFQN;
  }
}
