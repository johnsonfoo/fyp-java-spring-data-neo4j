package com.ntu.fyp.sdn6.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * This class represents the CONTAINS relationship. A CONTAINS relationship is a directed edge from
 * a Fqn node to a Fqn node with property version.
 */
@RelationshipProperties
public class Contains {

  @Id
  @GeneratedValue
  private Long id;

  @TargetNode
  private final Fqn containedFqn;

  private final String version;

  public Contains(Fqn containedFqn, String version) {
    this.containedFqn = containedFqn;
    this.version = version;
  }

  public String getVersion() {
    return version;
  }

  public Fqn getContainedFqn() {
    return containedFqn;
  }
}
