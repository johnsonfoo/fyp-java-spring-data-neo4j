package com.ntu.fyp.sdn6.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * This class represents the REFERENCES relationship. A REFERENCES relationship is a directed edge
 * from a FQN node to a FQN node with property version.
 */
@RelationshipProperties
public class References {

  @Id
  @GeneratedValue
  private Long id;

  @TargetNode
  private final FQN referencedFQN;

  private final String version;

  public References(FQN referencedFQN, String version) {
    this.referencedFQN = referencedFQN;
    this.version = version;
  }

  public String getVersion() {
    return version;
  }

  public FQN getReferencedFQNFQN() {
    return referencedFQN;
  }
}
