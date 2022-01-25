package com.ntu.fyp.sdn6.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * This class represents the DELETES relationship. A DELETES relationship is a directed edge from
 * a FQN node to a FQN node with properties commit, parent.
 */
@RelationshipProperties
public class Deletes {

  @Id
  @GeneratedValue
  private Long id;

  @TargetNode
  private final FQN deletedFQN;

  private final String commit;

  private final String parent;

  public Deletes(FQN deletedFQN, String commit, String parent) {
    this.deletedFQN = deletedFQN;
    this.commit = commit;
    this.parent = parent;
  }

  public String getCommit() {
    return commit;
  }

  public String getParent() {
    return parent;
  }

  public FQN getDeletedFQN() {
    return deletedFQN;
  }
}
