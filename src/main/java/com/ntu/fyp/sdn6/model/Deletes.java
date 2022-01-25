package com.ntu.fyp.sdn6.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * This class represents the DELETES relationship. A DELETES relationship is a directed edge from
 * a Fqn node to a Fqn node with properties commit, parent.
 */
@RelationshipProperties
public class Deletes {

  @Id
  @GeneratedValue
  private Long id;

  @TargetNode
  private final Fqn deletedFqn;

  private final String commit;

  private final String parent;

  public Deletes(Fqn deletedFqn, String commit, String parent) {
    this.deletedFqn = deletedFqn;
    this.commit = commit;
    this.parent = parent;
  }

  public String getCommit() {
    return commit;
  }

  public String getParent() {
    return parent;
  }

  public Fqn getDeletedFQN() {
    return deletedFqn;
  }
}
