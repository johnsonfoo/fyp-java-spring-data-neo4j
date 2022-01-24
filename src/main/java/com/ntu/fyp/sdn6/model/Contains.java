package com.ntu.fyp.sdn6.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * This class represents the CONTAINS relationship. A CONTAINS relationship is a directed edge from
 * a FQN node to a FQN node with property version.
 */
@RelationshipProperties
public class Contains {

  @Id
  @GeneratedValue
  private Long id;

  @TargetNode
  private final FQN containedFQN;

  private final String version;

  public Contains(FQN containedFQN, String version) {
    this.containedFQN = containedFQN;
    this.version = version;
  }

  public String getVersion() {
    return version;
  }

  public FQN getContainedFQN() {
    return containedFQN;
  }
}
