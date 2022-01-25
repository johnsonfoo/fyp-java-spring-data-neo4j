package com.ntu.fyp.sdn6.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * This class represents the UPDATES relationship. A UPDATES relationship is a directed edge from a
 * Fqn node to a Fqn node with properties commit, parent.
 */
@RelationshipProperties
public class Updates {

  @Id
  @GeneratedValue
  private Long id;

  @TargetNode
  private final Fqn updatedFqn;

  private final String commit;

  private final String parent;

  public Updates(Fqn updatedFqn, String commit, String parent) {
    this.updatedFqn = updatedFqn;
    this.commit = commit;
    this.parent = parent;
  }

  public String getCommit() {
    return commit;
  }

  public String getParent() {
    return parent;
  }

  public Fqn getUpdatedFqn() {
    return updatedFqn;
  }
}
